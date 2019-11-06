package es.german.healthrecord.common.exception.rest;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import es.german.healthrecord.common.exception.EhrException;

@Provider
public class MapperEhrException implements ExceptionMapper<EhrException> {

	@Override
	public Response toResponse(EhrException exception) {
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
	}

}
