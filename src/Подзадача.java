/**
 * Подзадача.
 *
 * @author Vladimir Ivanov (ivanov.vladimir.l@gmail.com)
 */
public class Подзадача extends Задача {
	int эпикИД;

	public Подзадача(String название, String описание, int ид, String cтатус, int эпикИД) {
		super(название, описание, ид, cтатус);
		this.эпикИД = эпикИД;
	}

	public int getЭпикИД() {
		return эпикИД;
	}

	public void setЭпикИД(int эпикИД) {
		this.эпикИД = эпикИД;
	}
}
