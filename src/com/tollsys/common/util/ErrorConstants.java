package com.tollsys.common.util;

import java.text.MessageFormat;

import com.tollsys.common.util.CommonConstants;

public class ErrorConstants {

	/*---------------------Client-Side Error Constants-------------------------------------------------------*/
	/** The Constant COMMON_EXCEPTION_MESSAGE. */
	public static final String COMMON_EXCEPTION_MESSAGE = "An Error has occured. " + "Please check with Admininstrator."
			+ CommonConstants.LINE_SEPARATOR + "Cause : ";

	/** The Constant REPORT_MISSING_MESSAGE. */
	public static final String REPORT_MISSING_MESSAGE = "Report Object not found." + CommonConstants.LINE_SEPARATOR
			+ "Please check if you have configured your ReportResources folder properly.";

	/** The Constant WARNING_TITLE. */
	public static final String WARNING_TITLE = "Warning";

	/** The Constant ERROR_TITLE. */
	public static final String ERROR_TITLE = "Error";

	/** The Constant INFORMATION_TITLE. */
	public static final String INFORMATION_TITLE = "Information";

	/** The Constant RECORD_EXISTS. */
	public static final String RECORD_EXISTS = "Record already exists";

	/** The Constant INCOMPATIBLE_JRE_WARNING_APP. */
	public static final String INCOMPATIBLE_JRE_WARNING_APP = "            This "
			+ "application works with JRE version : ";

	/** The Constant INCOMPATIBLE_JRE_WARNING_USER. */
	public static final String INCOMPATIBLE_JRE_WARNING_USER = "     The version of "
			+ "the JRE found on this system is : ";

	/** The Constant INCOMPATIBLE_JRE_WARNING_PROMPT_START. */
	public static final String INCOMPATIBLE_JRE_WARNING_PROMPT_START = "Your JRE version might "
			+ "not be compatible with this application." + CommonConstants.LINE_SEPARATOR
			+ "  Please install JRE version ";

	/** The Constant INCOMPATIBLE_JRE_WARNING_PROMPT_END. */
	public static final String INCOMPATIBLE_JRE_WARNING_PROMPT_END = " before running " + "the application."
			+ CommonConstants.LINE_SEPARATOR + "                        Do you want to continue anyway?";

	/** The Constant INCOMPATIBLE_JRE_TITLE. */
	public static final String INCOMPATIBLE_JRE_TITLE = "Toll Management System Warning!";

	/** The Constant REPORT_NOT_GENERATED. */
	public static final String REPORT_NOT_GENERATED = "No data for report generation.";

	/** The Constant REPORT_GENERATION_ERROR. */
	public static final String REPORT_GENERATION_ERROR = "Error in report generation";

	/** The Constant DATA_NOT_FOUND. */
	public static final String DATA_NOT_FOUND = "Data not found";

	/** The Constant MANDATORY_FIELDS. */
	public static final String MANDATORY_FIELDS = "Please enter the Mandatory Fields";

	/** The Constant CANNOT_INITILIZE_FIELDS. */
	public static final String CANNOT_INITILIZE_FIELDS = "Cannot initilize Fields";

	/** The Constant JDBC_EXCEPTION. */
	public static final String JDBC_EXCEPTION = "JDBC";

	/** The Constant OPERATION_FAILS_AS_PARENT_NOT_EXISTS. */
	public static final MessageFormat OPERATION_FAILS_AS_PARENT_NOT_EXISTS = new MessageFormat(
			"Cannot {0} {1} as {2} is missing.");

	/** The Constant IS_MISSING. */
	public static final String IS_MISSING = "is missing.";

	/** The Constant CREATE. */
	public static final String CREATE = "create";

	/** The Constant UPDATE. */
	public static final String UPDATE = "update";

	/** The Constant ENTITY_NOT_EXISTS. */
	public static final String ENTITY_NOT_EXISTS = " does not exist!";

	/** The Constant ENTITY_NOTUNIQUE. */
	public static final String ENTITY_NOTUNIQUE = " is not Unique!";

	/** The Constant LOGIN_FAILURE_MESSAGE. */
	public static final String LOGIN_FAILURE_MESSAGE = "Login not successful - Wrong Login password";

	/** The Constant LOGOUT_FAILURE_MESSAGE. */
	public static final String LOGOUT_FAILURE_MESSAGE = "Logout failed. Please try again.";

	/** The Constant OLDPASSWORD_FAILURE_MESSAGE. */
	public static final String OLDPASSWORD_FAILURE_MESSAGE = "Old password is incorrect.";

	/** The Constant LOGIN_ERROR. */
	public static final String LOGIN_ERROR = "Error during Login" + CommonConstants.LINE_SEPARATOR;

	/** The Constant ACCESS_DENIED. */
	public static final String ACCESS_DENIED = "Sorry, You dont seem to have appropriate permissions to access this Application!";

	/*---------------------End Client-Side Error Constants-----------------------------------------------------------------*/

	/*---------------------Server-Side Error Constants---------------------------------------------------------------------*/

	/** The Constant SERVER_CONNECTION_EXCEPTION_MESSAGE. */
	public static final String SERVER_CONNECTION_EXCEPTION_MESSAGE = "Cannot connect to server. "
			+ "Please check with Admininstrator.";

	public static final String REPORT_GENERATION_FAILED = "Cannot generate report. "
			+ "Please contact your administrator.";

	/** The Constant CANNOT_UPDATE_USER. */
	public static final String CANNOT_UPDATE_USER = "Error while Updating User";

	/** The Constant SEND_JMSException. */
	public static final String SEND_JMS_EXCEPTION = "Error while sending a JMS Message";

	/** The Constant CLOSE_JMSException. */
	public static final String CLOSE_JMS_EXCEPTION = "Error while closing a JMS Connection";

	/** The Constant MESSAGE_PROCESSING_JMSEXCEPTION. */
	public static final String MESSAGE_PROCESSING_JMSEXCEPTION = "Error while processing a JMS Message";

	/** The Constant CANNOT_FIND. */
	public static final String CANNOT_FIND = "Error while finding";

	/** The Constant CANNOT_CREATE. */
	public static final String CANNOT_CREATE = "Error while creating the entity";

	/** The Constant CANNOT_UPDATE. */
	public static final String CANNOT_UPDATE = "Error while Updating the entity";

	/** The Constant CANNOT_FIND_BY_PRIMARYID. */
	public static final String CANNOT_FIND_BY_PRIMARYID = "Error while finding entity with primary key id : ";

	/** The Constant CANNOT_DELETE. */
	public static final String CANNOT_DELETE = "Cannot delete the ";

	/** The Constant CANNOT_COUNT. */
	public static final String CANNOT_COUNT = "Error while counting the entity";

	// Oracle Exceptions and codes-

	/** The Constant ORACLE_CONNECTION_REFUSED. */
	public static final String ORACLE_CONNECTION_REFUSED = "Connection refused: connect";

	/** The Constant ORACLE_REMOTE_EXCEPTION. */
	public static final String ORACLE_REMOTE_EXCEPTION = "oracle.oc4j.rmi.OracleRemoteException";

	/** The Constant TABLE_LIMIT_EXCEEDED. */
	public static final String TABLE_LIMIT_EXCEEDED = "ORA-01438";

	/** The Constant INTEGRITY_CONSTR_VIOLATION. */
	public static final String INTEGRITY_CONSTR_VIOLATION = "ORA-02292";

	/** The Constant SCREEN_DOES_NOT_EXIST. */
	public static final String SCREEN_DOES_NOT_EXIST = " screen does not exist!";

	/** The Constant PASSWORDS_DONOT_MATCH. */
	public static final String PASSWORDS_DONOT_MATCH = "The Passwords you have typed do not match. Please confirm new Password correctly.";

	/** The Constant INSUFFICIENT_PARAMETERS. */
	public static final String INSUFFICIENT_PARAMETERS = "Too many or too less parameters!";

	/*---------------------End Server-Side Error Constants------------------------------*/
}
