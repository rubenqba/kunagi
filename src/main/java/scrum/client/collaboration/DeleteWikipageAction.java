package scrum.client.collaboration;


public class DeleteWikipageAction extends GDeleteWikipageAction {

	public DeleteWikipageAction(scrum.client.collaboration.Wikipage wikipage) {
		super(wikipage);
	}

	@Override
	public String getLabel() {
		return "Delete Wiki Page";
	}

	@Override
	protected void onExecute() {
		getDao().deleteWikipage(wikipage);
	}

}