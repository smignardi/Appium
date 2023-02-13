package data;

import com.poiji.annotation.ExcelSheet;
import data.ExcelReader;
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
}
