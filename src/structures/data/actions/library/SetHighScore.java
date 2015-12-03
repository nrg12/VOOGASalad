package structures.data.actions.library;

import structures.data.DataAction;
import structures.data.actions.params.DoubleParam;
import structures.data.actions.params.StringParam;

public class SetHighScore extends DataAction {

	public SetHighScore(){
		init(new StringParam("NewScoreVariable"));
	}

	@Override
	public String getTitle() {
		return "SetHighScore";
	}

	@Override
	public String getDescription() {
		return String.format("sets the high score to the value of %s", get("NewScoreVariable").getValue());
	}

	@Override
	protected String getSyntax() {
		return "library.set_high_score(library.get_variable('%s'));";
	}

}
