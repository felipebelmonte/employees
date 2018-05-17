package net.atos.employees.exception;

public class RepositoryException extends Exception {
	static final long serialVersionUID = 1L;

	public RepositoryException() { super(); }

	public RepositoryException(String message) { super(message); }

	public RepositoryException(String message, Throwable cause) { super(message, cause); }

	public RepositoryException(Throwable cause) { super(cause); }
}
