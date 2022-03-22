import java.util.Objects;

/**
 * Задача.
 *
 * @author Vladimir Ivanov (ivanov.vladimir.l@gmail.com)
 */
public class Задача {
	private String название;
	private String описание;
	private int ид;
	private String cтатус;

	public Задача(String название, String описание, int ид, String cтатус) {
		this.название = название;
		this.описание = описание;
		this.ид = ид;
		this.cтатус = cтатус;
	}

	public Задача(String название, String описание, String cтатус) {
		this.название = название;
		this.описание = описание;
		this.ид = 0;
		this.cтатус = cтатус;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Задача)) return false;
		Задача задача = (Задача) o;
		return ид == задача.ид && Objects.equals(название, задача.название) && Objects.equals(описание, задача.описание) && Objects.equals(cтатус, задача.cтатус);
	}

	@Override
	public int hashCode() {
		return Objects.hash(название, описание, ид, cтатус);
	}

	public String getНазвание() {
		return название;
	}

	public void setНазвание(String название) {
		this.название = название;
	}

	public String getОписание() {
		return описание;
	}

	public void setОписание(String описание) {
		this.описание = описание;
	}

	public int getИд() {
		return ид;
	}

	public void setИд(int ид) {
		this.ид = ид;
	}

	public String getCтатус() {
		return cтатус;
	}

	public void setCтатус(String cтатус) {
		this.cтатус = cтатус;
	}

	@Override
	public String toString() {
		return "Задача{" +
				"название='" + название + '\'' +
				", описание='" + описание + '\'' +
				", ид=" + ид +
				", cтатус='" + cтатус + '\'' +
				'}';
	}
}
