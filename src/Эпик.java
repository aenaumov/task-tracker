import java.util.ArrayList;

/**
 * Эпик.
 *
 * @author Vladimir Ivanov (ivanov.vladimir.l@gmail.com)
 */
public class Эпик extends Задача {
	private ArrayList<Подзадача> подзадачи;

	public Эпик(String название, String описание, int ид, String cтатус) {
		super(название, описание, ид, cтатус);
	}

	public Эпик(String название, String описание, int ид, String cтатус, ArrayList<Подзадача> подзадачи) {
		super(название, описание, ид, cтатус);
		this.подзадачи = подзадачи;
	}

	public ArrayList<Подзадача> getПодзадачи() {
		return подзадачи;
	}

	public void setПодзадачи(ArrayList<Подзадача> подзадачи) {
		this.подзадачи = подзадачи;
	}
}
