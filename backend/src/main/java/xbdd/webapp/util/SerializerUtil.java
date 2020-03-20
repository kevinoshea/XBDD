package xbdd.webapp.util;

import com.google.gson.Gson;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import java.util.List;

public class SerializerUtil {
	private static final Gson gson = new Gson();

	private SerializerUtil() {
	}

	public static String serialise(DBObject toSerialise) {
		return gson.toJson(toSerialise);
	}

	public static String serialise(BasicDBObject toSerialise) {
		return gson.toJson(toSerialise);
	}

	public static String serialise(BasicDBList toSerialise) {
		return gson.toJson(toSerialise);
	}

	public static String serialise(List<?> toSerialise) {
		return gson.toJson(toSerialise);
	}

}
