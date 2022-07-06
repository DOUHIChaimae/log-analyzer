package org.sqli.pfe.enset.utils.mappers;

import org.sqli.pfe.enset.models.entities.LogEntity;
import org.sqli.pfe.enset.utils.dtos.LogDto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

public final class LogMapper {
    private static final SimpleDateFormat DATE_FORMAT_PARSER = new SimpleDateFormat("yy-MM-dd HH:mm:ss");

    public static LogDto from(LogEntity entity) {
        return LogDto.builder()
                .id(entity.getId())
                .thread(entity.getThread())
                .login(entity.getLogin())
                .request(entity.getRequest())
                .date(entity.getDate().toString())
                .build();
    }

    public static LogEntity from(LogDto dto) throws ParseException {
        return LogEntity.builder()
                .id(dto.getId())
                .thread(dto.getThread())
                .login(dto.getLogin())
                .request(dto.getRequest())
                .date(DATE_FORMAT_PARSER.parse(dto.getDate()))
                .build();
    }

    public static List<LogDto> from(List<LogEntity> entities) {
        return entities.stream().map(LogMapper::from).collect(Collectors.toList());
    }

}
