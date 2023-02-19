package data;

import model.CredentialErrorMessageModel;
import model.CredentialModel;

import java.util.HashMap;
import java.util.Map;

public class MapParser {

    final ExcelReader excelReader = new ExcelReader();

    public Map<String, CredentialModel> getCredentialMap(){
        final var map = new HashMap<String,CredentialModel>();
        final var credentialList = excelReader.getCredentialList();
        for (var element:credentialList) {
            map.put(element.getKey(), element);
        }
        return map;
    }

    public Map<String, CredentialErrorMessageModel> getCredentialErrorMessageMap(){
        final var map = new HashMap<String, CredentialErrorMessageModel>();
        final var credentialErrorMessagesList = excelReader.getCredentialErrorMessageList();
        for (var element:credentialErrorMessagesList) {
            map.put(element.getKey(), element);
        }
        return map;
    }
}
