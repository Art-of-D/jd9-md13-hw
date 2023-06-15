package com.app;

import com.app.entity.Note;
import com.app.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
public class Application {
	@Autowired
	private NoteService notes;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@PostConstruct
	public void init() {
		List<Note> noteList = notes.listAll();
		if (noteList.isEmpty()) {
			notes.add(new Note(1341L, "S1", "Something2"));
			notes.add(new Note(123123L, "S2", "Something2"));
			notes.add(new Note(124234L, "S3", "Something2"));
			notes.add(new Note(9945646L, "S4", "Something2"));
		}
	}
}