package be.ugent.rml.access;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.Map;

import org.apache.commons.io.IOUtils;

public class StringAccess implements Access {
  private String text;


  public StringAccess(final String text) {
    this.text = text;
  }

  public StringAccess(final InputStream inputStream) {
    try {
      String encoding = "UTF-8";

      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      byte[] byteSize = new byte[inputStream.available()];

      int length = inputStream.read(byteSize);
      byteArrayOutputStream.write(byteSize, 0, length);
      this.text = byteArrayOutputStream.toString(encoding);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public InputStream getInputStream() throws IOException, SQLException, ClassNotFoundException {
    return IOUtils.toInputStream(this.text, Charset.forName("UTF-8"));
  }

  public String getText() {
    return this.text;
  }

  @Override
  public Map<String, String> getDataTypes() {
    return null;
  }
}
