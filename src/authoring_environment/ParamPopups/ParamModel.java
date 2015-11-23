package authoring_environment.ParamPopups;

import java.util.List;

import structures.data.actions.IAction;
import structures.data.actions.params.IParameter;
import structures.data.events.IDataEvent;

public class ParamModel {
	//IDataEvent myEvent;
	List<IParameter> myList;
	List<IAction> myActions;
	IAction myAction;
	public ParamModel(IAction e,List<IAction> action) {
	//	myEvent= e;
		myAction = e;
		myList= e.getParameters();
		myActions = action;
	}
	public int getListsize() {
		// TODO Auto-generated method stub
		return myList.size();
	}
	public List<IParameter> getList() {
		// TODO Auto-generated method stub
		return myList;
	}
	public void addAction(){
		myActions.add(myAction);
	}
	public List<IAction> getActionList() {
		// TODO Auto-generated method stub
		return myActions;
	}

}
