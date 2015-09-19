package hudsonclientv2.views.console;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;

public class StringStorage implements IStorage {
	private String string;
	private String name = "...";

	public StringStorage(String name, String input) {
		this.string = input;
		this.name = name;
	}

	StringStorage(String input) {
		this.string = input;
	}

	public InputStream getContents() throws CoreException {
		return new ByteArrayInputStream(string.getBytes());
	}

	public IPath getFullPath() {
		return null;
	}

	public Object getAdapter(Class adapter) {
		return null;
	}

	public String getName() {
		int len = Math.min(5, string.length());
		return string.substring(0, len).concat(name); //$NON-NLS-1$
	}

	public boolean isReadOnly() {
		return true;
	}
}