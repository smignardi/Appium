package data;

import com.poiji.bind.Poiji;
import model.CredentialModel;

import java.io.File;
import java.util.List;

public class ExcelReader {
    private final String excelPath = "src/test/resources/data/testData.xlsx";

    public List<CredentialModel> getCredentialList(){
        return Poiji.fromExcel(new File(excelPath),CredentialModel.class);
    }
}
