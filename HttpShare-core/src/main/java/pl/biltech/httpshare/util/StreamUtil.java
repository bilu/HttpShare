package pl.biltech.httpshare.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;

import org.apache.commons.io.IOUtils;

/**
 * @author tomek, bilu
 * 
 */
public class StreamUtil {

	public static void copyStream(InputStream in, OutputStream out)
			throws IOException {
		byte[] bytes = new byte[4096];
		int size;
		while ((size = in.read(bytes)) != -1) {
			out.write(bytes, 0, size);
		}
		out.flush();
		out.close();
		in.close();
	}

	public static InputStream getFileStream(String file) {
		return ClassLoader.class.getResourceAsStream(file);
	}

	public static String readAll(InputStream inputStream) throws IOException {
		StringWriter writer = new StringWriter();
		IOUtils.copy(inputStream, writer, "utf-8");
		return writer.toString();
	}
}
