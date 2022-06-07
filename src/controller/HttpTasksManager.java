package controller;

/**
 * // TODO .
 *
 * @author Vladimir Ivanov (ivanov.vladimir.l@gmail.com)
 */
public class HttpTasksManager extends FileBackedTasksManager {
	int port;
	public HttpTasksManager(int port) {
		this.port = port; // PORT KVServer
	}
}
