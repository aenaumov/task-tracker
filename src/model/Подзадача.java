package model;

import java.util.Objects;

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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Подзадача)) return false;
		if (!super.equals(o)) return false;
		Подзадача подзадача = (Подзадача) o;
		return эпикИД == подзадача.эпикИД;
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), эпикИД);
	}

	@Override
	public String toString() {
		return "Подзадача{" +
				"название='" + название + '\'' +
				", описание='" + описание + '\'' +
				", ид=" + ид +
				", cтатус='" + статус + '\'' +
				"эпикИД=" + эпикИД +
				'}';
	}
}
