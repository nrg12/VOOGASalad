package structures.data.actions.params;

import exceptions.ParameterParseException;

public class IntegerParam implements IParameter {
	
	private int myNum;
	private String myString;
	private String myTitle;
	
	public IntegerParam(String title) {
		myTitle = title;
	}

	@Override
	public void parse(String string) throws ParameterParseException {
		try {
			myNum = Integer.parseInt(string);
			myString = string;
		} catch (NumberFormatException ex) {
			throw new ParameterParseException(String.format("Not an integer: '%s'", string));
		}
	}

	@Override
	public String getOriginal() {
		return myString;
	}
	
	public int getValue() {
		return myNum;
	}
	
	@Override
	public String getTitle() {
		return myTitle;
	}

}