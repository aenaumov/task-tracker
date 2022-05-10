package model;

import java.util.Objects;

/**
 * Задача.
 *
 * @author Vladimir Ivanov (ivanov.vladimir.l@gmail.com)
 */
public class Задача {
	protected String название;
	protected String описание;
	protected int ид;
	protected String статус;

	public Задача(String название, String описание, int ид, String статус) {
		this.название = название;
		this.описание = описание;
		this.ид = ид;
		this.статус = статус;
	}

	public Задача(String название, String описание, String статус) {
		this.название = название;
		this.описание = описание;
		this.ид = 0;
		this.статус = статус;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Задача)) return false;
		Задача задача = (Задача) o;
		return ид == задача.ид && Objects.equals(название, задача.название) && Objects.equals(описание, задача.описание) && Objects.equals(статус, задача.статус);
	}

	@Override
	public int hashCode() {
		return Objects.hash(название, описание, ид, статус);
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

	public String getСтатус() {
		return статус;
	}

	public void setСтатус(String статус) {
		this.статус = статус;
	}

	public ТипыЗадач getТип() {
		return ТипыЗадач.TASK;
	}

	@Override
	public String toString() {
		return "Задача{" +
				"название='" + название + '\'' +
				", описание='" + описание + '\'' +
				", ид=" + ид +
				", cтатус='" + статус + '\'' +
				'}';
	}
}
