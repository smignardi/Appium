package data;

import model.CredentialErrorMessageModel;
import model.CredentialModel;

public class DataCaller {

    private final ExcelReader excelReader = new ExcelReader();
    private final MapParser mapParser = new MapParser();

    public CredentialModel getValidCredential(){
        return mapParser.getCredentialMap().get("valid");
    }

    public CredentialModel getInvalidCredential(){
        return mapParser.getCredentialMap().get("invalid");
    }

    public CredentialModel getLockedCredential(){
        return mapParser.getCredentialMap().get("locked");
    }

    public String getInvalidErrorMessage(){
        return mapParser.getCredentialErrorMessageMap().get("invalid").getMessage();
    }

    public String getLockedErrorMessage(){
        return mapParser.getCredentialErrorMessageMap().get("locked").getMessage();
    }
}