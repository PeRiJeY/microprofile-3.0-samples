package es.german.healthrecord.common.serialize;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.json.bind.JsonbException;
import javax.json.bind.serializer.DeserializationContext;
import javax.json.bind.serializer.JsonbDeserializer;
import javax.json.stream.JsonParser;

import org.apache.commons.lang3.StringUtils;

public class JsonDateTimeDeserializer implements JsonbDeserializer<Date> {

	private SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD HH:mm");

	@Override
	public Date deserialize(JsonParser parser, DeserializationContext ctx, Type rtType) {
		Date result = null;
		try {
			if (StringUtils.isNotEmpty(parser.getString())) {				
				result = dateFormat.parse(parser.getString());
			}
		} catch (ParseException e) {
			throw new JsonbException("Error deserializando fecha", e);
		}
		return result;
	}


}
