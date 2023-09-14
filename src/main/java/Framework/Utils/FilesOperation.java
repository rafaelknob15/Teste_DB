package Framework.Utils;

import java.io.*;
import java.util.Properties;

public class FilesOperation {

    private static final String DIR_PATH_PROPERTIES = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" +
            File.separator + "resources" + File.separator + "Properties" + File.separator;

    public static void atualizarSaldo(String conta, String novoSaldo) throws IOException {
        Properties properties = getProperties("saldo");
        properties.setProperty("saldoConta" + conta, novoSaldo);
        saveProperties("saldo", properties);
    }

    public static Properties getProperties(String name) throws IOException {
        InputStream inputStream = null;
        Properties prop = new Properties();

        try {
            File file = new File(DIR_PATH_PROPERTIES + name + ".properties");
            inputStream = new FileInputStream(file);
            prop.load(inputStream);
            return prop;
        } catch (Exception e) {
            System.out.println("Não carregou o arquivo" + e.getMessage());
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return prop;
    }

    public static void setSaldo(String conta, String saldo) throws IOException {
        Properties properties = getProperties("saldo");
        properties.setProperty("saldoConta" + conta, saldo);
        saveProperties("saldo", properties);
    }

    public static String getSaldo(String conta) throws IOException {
        Properties properties = getProperties("saldo");
        return properties.getProperty("saldoConta" + conta);
    }

    public static void setProperty(String name, String key, String value) throws IOException {
        Properties properties = getProperties(name);
        properties.setProperty(key, value);
        saveProperties(name, properties);
    }

    private static void saveProperties(String name, Properties properties) throws IOException {
        OutputStream outputStream = null;

        try {
            File file = new File(DIR_PATH_PROPERTIES + name + ".properties");
            outputStream = new FileOutputStream(file);
            properties.store(outputStream, null);
        } catch (Exception e) {
            System.out.println("Não foi possível salvar as propriedades: " + e.getMessage());
        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}
