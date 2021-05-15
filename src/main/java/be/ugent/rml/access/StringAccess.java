package be.ugent.rml.access;

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

	public StringAccess(final InputStream inputStream) throws IOException {
		this.text = IOUtils.toString(inputStream, "UTF-8");
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StringAccess other = (StringAccess) obj;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}

}
