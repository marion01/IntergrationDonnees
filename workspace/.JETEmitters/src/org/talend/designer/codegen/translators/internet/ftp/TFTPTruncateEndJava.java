package org.talend.designer.codegen.translators.internet.ftp;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TFTPTruncateEndJava
{
  protected static String nl;
  public static synchronized TFTPTruncateEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFTPTruncateEndJava result = new TFTPTruncateEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t}";
  protected final String TEXT_2 = NL + "\t\t\t";
  protected final String TEXT_3 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_4 = " - Closing the connection to the server.\");" + NL + "\t\t\t";
  protected final String TEXT_5 = NL + "    \t\tsession_";
  protected final String TEXT_6 = ".disconnect(); " + NL + "\t\t\t";
  protected final String TEXT_7 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_8 = " - Connection to the server closed.\");" + NL + "\t\t\t";
  protected final String TEXT_9 = "  ";
  protected final String TEXT_10 = NL + "\t} ";
  protected final String TEXT_11 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_12 = " - Closing the connection to the server.\");";
  protected final String TEXT_13 = NL + "\t\t\tftp_";
  protected final String TEXT_14 = ".disconnect();";
  protected final String TEXT_15 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_16 = " - Connection to the server closed.\");";
  protected final String TEXT_17 = NL + "\t\t} ";
  protected final String TEXT_18 = NL + "\t\t\t\ttry{" + NL + "\t\t\t\t\t";
  protected final String TEXT_19 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_20 = " - Closing the connection to the server.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_21 = NL + "\t\t\t\t\tftp_";
  protected final String TEXT_22 = ".quit();" + NL + "\t\t\t\t\t";
  protected final String TEXT_23 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_24 = " - Connection to the server closed.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_25 = "  " + NL + "\t\t\t\t}catch(java.net.SocketException se_";
  protected final String TEXT_26 = "){" + NL + "\t\t\t\t\t";
  protected final String TEXT_27 = NL + "\t\t\t\t\t\tlog.warn(\"";
  protected final String TEXT_28 = " - \" + se_";
  protected final String TEXT_29 = ".getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_30 = " " + NL + "\t\t\t\t\t//ignore failure" + NL + "\t\t\t\t}";
  protected final String TEXT_31 = NL + "\t\t\t\t";
  protected final String TEXT_32 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_33 = " - Closing the connection to the server.\");" + NL + "\t\t\t\t";
  protected final String TEXT_34 = NL + "\t\t\t\tftp_";
  protected final String TEXT_35 = ".quit();" + NL + "\t\t\t\t";
  protected final String TEXT_36 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_37 = " - Connection to the server closed.\");" + NL + "\t\t\t\t";
  protected final String TEXT_38 = "  ";
  protected final String TEXT_39 = NL + "\t\t  \t\tftp_";
  protected final String TEXT_40 = ".chdir(rootDir_";
  protected final String TEXT_41 = ");";
  protected final String TEXT_42 = NL + NL + "globalMap.put(\"";
  protected final String TEXT_43 = "_NB_FILE\",nb_file_";
  protected final String TEXT_44 = ");" + NL;
  protected final String TEXT_45 = NL + "\tlog.info(\"";
  protected final String TEXT_46 = " - Truncated files count: \" + nb_file_";
  protected final String TEXT_47 = "  + \".\");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	String ignoreFailureAtQuit= ElementParameterParser.getValue(node,"__IGNORE_FAILURE_AT_QUIT__");
	String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
	String useExistingConn = ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__");
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	boolean moveToCurrentDir = ("true").equals(ElementParameterParser.getValue(node, "__MOVE_TO_THE_CURRENT_DIRECTORY__"));
	boolean sftp = false;
	boolean ftps = false;
	if(("true").equals(useExistingConn)){
		List<? extends INode> nodeList = node.getProcess().getGeneratingNodes();
		for(INode n : nodeList){
			if(n.getUniqueName().equals(connection)){
				sftp = ("true").equals(ElementParameterParser.getValue(n, "__SFTP__"));
				ftps = ("true").equals(ElementParameterParser.getValue(n, "__FTPS__"));
			}
		}
	}else{
		sftp = ("true").equals(ElementParameterParser.getValue(node, "__SFTP__"));
		ftps = ("true").equals(ElementParameterParser.getValue(node, "__FTPS__"));
	}
	if(sftp){// *** sftp *** //

    stringBuffer.append(TEXT_1);
    
		if(!("true").equals(useExistingConn)){

    stringBuffer.append(TEXT_2);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    }
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    }
    stringBuffer.append(TEXT_9);
    
		}

    	
	} else if (ftps) { // *** ftps *** //

    stringBuffer.append(TEXT_10);
     /* close main loop */ 
    
		if (("false").equals(useExistingConn)) {
			if(isLog4jEnabled) {

    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    
			}

    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    
			if(isLog4jEnabled) {

    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    
			}
		}
	} else {// *** ftp *** //

    stringBuffer.append(TEXT_17);
    
		if(!("true").equals(useExistingConn)){
 			if(("true").equals(ignoreFailureAtQuit)){

    stringBuffer.append(TEXT_18);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    }
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    }
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    }
    stringBuffer.append(TEXT_30);
    
			}else{

    stringBuffer.append(TEXT_31);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    }
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    }
    stringBuffer.append(TEXT_38);
    
			}
		}else{
		    if(!moveToCurrentDir){

    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    	
			}
		}
	}

    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    }
    return stringBuffer.toString();
  }
}
