package scrum.mda;

import ilarkesto.base.Str;
import ilarkesto.core.logging.Log;
import ilarkesto.core.scope.Scope;
import ilarkesto.di.app.ApplicationStarter;
import ilarkesto.mda.legacy.model.EntityModel;
import ilarkesto.mda.legacy.model.PropertyModel;
import ilarkesto.mda.model.CsvFileModelSource;
import ilarkesto.mda.model.Model;
import ilarkesto.mda.model.ModelProcessor;
import ilarkesto.mda.model.ModellingSession;
import ilarkesto.mda.model.Node;
import ilarkesto.mda.model.NodeTypes;
import ilarkesto.mda.swingeditor.Starter;
import ilarkesto.mda.swingeditor.Workspace;

import java.io.File;

public class ScrumModeller extends Starter {

	private static Log log = Log.get(ScrumModeller.class);

	private static ScrumModelApplication scrumModelApplication;

	public static void main(String[] args) {
		scrumModelApplication = ApplicationStarter.startApplication(ScrumModelApplication.class);

		Scope scope = createModellerScope();

		ModellingSession modellingSession = scope.getComponent(ModellingSession.class);
		modellingSession.addProcessor(new LegacyGeneration());
		modellingSession.load(new CsvFileModelSource(new File("src/model.csv")));
		appendLegacy(modellingSession.getModel());

		scope.getComponent(Workspace.class).showJFrame();
	}

	private static void appendLegacy(Model model) {
		Node nRoot = model.getRoot();
		Node nScrum = nRoot.getChildOrCreate(NodeTypes.GwtModule, "Scrum");
		for (EntityModel entity : scrumModelApplication.getEntityModels(false)) {
			if (!entity.isGwtSupport()) continue;
			log.info(entity.getName());
			String packageName = Str.removePrefix(entity.getPackageName(), "scrum.server.");
			Node nPackage = nScrum.getChildOrCreate(NodeTypes.Package, packageName);
			Node nEntity = nPackage.getChildOrCreate("Entity", entity.getName());
			for (PropertyModel property : entity.getProperties()) {
				Node nProperty;
				if (property.isReference()) {
					nProperty = nEntity.getChildOrCreate(NodeTypes.ReferenceProperty, property.getName());
				} else if (property.getType().equals(String.class.getName())) {
					nProperty = nEntity.getChildOrCreate(NodeTypes.TextProperty, property.getName());
				} else {
					log.warn("Unsupported type:", property.getType());
					continue;
				}
			}
		}
	}

	static class LegacyGeneration implements ModelProcessor {

		public void processModel(Model model) {
			scrumModelApplication.generateClasses().shutdown();
		}

	}

}
