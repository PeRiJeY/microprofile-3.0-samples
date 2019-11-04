package es.german.healthrecord.common.mapper;

import org.modelmapper.ModelMapper;

public class EntityMapper<DTO, Entity> {

	private Class<DTO> classDTO;
	private Class<Entity> classEntity;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	public EntityMapper(Class<DTO> classDTO, Class<Entity> classEntity) {
        this.classDTO = classDTO;
        this.classEntity = classEntity;
	}
	
	public Entity mapToEntity(DTO dto) {
		return modelMapper.map(dto, classEntity);
	}
	
	public DTO mapToDTO(Entity entity) {
		return modelMapper.map(entity, classDTO);
	}
}
