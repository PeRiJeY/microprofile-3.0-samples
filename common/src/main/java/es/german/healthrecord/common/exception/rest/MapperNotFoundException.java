package es.german.healthrecord.common.exception.rest;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import es.german.healthrecord.common.exception.EhrNotFoundException;

@Provider
public class MapperNotFoundException implements ExceptionMapper<EhrNotFoundException> {

	@Override
	public Response toResponse(EhrNotFoundException exception) {
		return Response.status(Response.Status.NOT_FOUND).build();
	}

}
