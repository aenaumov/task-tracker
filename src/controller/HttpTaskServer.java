package controller;

import java.time.LocalDateTime;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.Задача;
import model.Статус;
import model.Эпик;

/**
 * // TODO .
 *
 * @author Vladimir Ivanov (ivanov.vladimir.l@gmail.com)
 */
public class HttpTaskServer {
	Менеджер менеджер = Менеджеры.получитьМенеджера();
	public static Gson getGson() {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter());
		return gsonBuilder.create();
	}

	public static void main(String[] args) {
		final Gson gson = getGson();
		Задача задача = new Задача("Тест", "Описание", Статус.NEW);
		задача.setИд(1);
		задача.setНачало(LocalDateTime.now());
		final HashMap<Integer, Задача> map = new HashMap<>();
		map.put(задача.getИд(), задача);

		Эпик эпик = new Эпик("Эпик", "Описание эпик");
		эпик.setИд(2);
		эпик.setНачало(LocalDateTime.now());
		map.put(эпик.getИд(), эпик);

		System.out.println(gson.toJson(задача));
		final String json = gson.toJson(map);
		System.out.println(json);
		final HashMap<Integer, Задача> mapRestored = gson.fromJson(json,
				new TypeToken<HashMap<Integer, Задача>>() {
		}.getType());
		System.out.println("Restored:");
		System.out.println(mapRestored);
		System.out.println(mapRestored.get(1));

		System.out.println("Было:");
		System.out.println(map.get(2));
		System.out.println("Стало:");
		System.out.println(mapRestored.get(2));



		// KVServer (8078) <--> {[KVClient <-->  HttpTaskManager] <--> HttpTaskServer} (8080) <--> FRONTEND
		// HttpTaskServer получает id или json (body) -> Объект (Задача, Подзадача, Эпик)
		// HttpTaskManager
	}
}
