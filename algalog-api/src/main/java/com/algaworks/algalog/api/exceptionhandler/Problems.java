package com.algaworks.algalog.api.exceptionhandler;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Problems {
	
	private Integer status;
	private LocalDateTime time;
	private String title;
	private List<Field> fields;
	
	@AllArgsConstructor
	@Getter
	public static class Field{
		private String nome;
		private String mensagens;
	}
}
