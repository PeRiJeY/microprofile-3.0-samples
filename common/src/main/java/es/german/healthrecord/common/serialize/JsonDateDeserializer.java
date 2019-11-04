package es.german.healthrecord.common.serialize;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.json.bind.JsonbException;
import javax.json.bind.serializer.DeserializationContext;
import javax.json.bind.serializer.JsonbDeserializer;
import javax.json.stream.JsonParser;

public class JsonDateDeserializer implements JsonbDeserializer<Date> {

	private SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD");

	@Override
	public Date deserialize(JsonParser parser, DeserializationContext ctx, Type rtType) {
		Date result = null;
		try {
			result = dateFormat.parse(parser.getString());
		} catch (ParseException e) {
			throw new JsonbException("Error deserializando fecha", e);
		}
		return result;
	}


}
