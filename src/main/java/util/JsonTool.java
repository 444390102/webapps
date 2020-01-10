package util;

import javax.servlet.ServletInputStream;
import java.io.*;

public class JsonTool {
    private String t;
    private StringBuffer buffer = null;
    private InputStreamReader inputStreamReader = null;
    private BufferedReader reader = null;

    public String InString(ServletInputStream inputStream) {

        try {
            inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            reader = new BufferedReader(inputStreamReader);
            buffer = new StringBuffer();
            while ((t = reader.readLine()) != null) {
                buffer.append(t);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return buffer.toString();
    }

    public void OutString(PrintWriter writer, String str) {
        PrintWriter out = writer;
        out.print(str);
        out.flush();
        out.close();
    }
}
