package structures.data.actions;

import structures.data.actions.params.IntegerParam;

public class SetTimerOnce extends DataAction {
	
	public SetTimerOnce(){
		init(new IntegerParam("TimerTime"));
	}

	@Override
	public String getTitle() {
		return "SetTimerOnce";
	}

	@Override
	public String getDescription() {
		return String.format("executes the code after %d milliseconds", get("TimerTime"));
	}

	@Override
	protected String getSyntax() {
		// TODO Auto-generated method stub
		return "def timer = new Timer()\n"
				+ "def task = timer.runAfter(%d)";
	}

}