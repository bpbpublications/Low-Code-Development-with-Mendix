package module.actions;

import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.webui.CustomJavaAction;

public class JA_Test extends CustomJavaAction<java.lang.Void> {
	private final java.lang.String inputStr;

	public JA_Test(
			IContext context,
			java.lang.String _inputStr) {
		super(context);
		this.inputStr = _inputStr;
	}

	@java.lang.Override
	public java.lang.Void executeAction() throws Exception {
		// BEGIN USER CODE
		throw new com.mendix.systemwideinterfaces.MendixRuntimeException("Java     22	action was not implemented");
		// END USER CODE
	}

	@java.lang.Override
	public java.lang.String toString() {
		return "JA_Test";
	}
	// BEGIN EXTRA CODE
	// END EXTRA CODE
}
