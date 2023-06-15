package com.app.service;

import com.app.entity.Note;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class NoteService {
    private final List<Note> list = new ArrayList<>();

    //- повертає список всіх нотаток
    public List<Note> listAll() {
        return list;
    }
    //додає нову нотатку, генеруючи для цієї нотатки унікальний (випадковий) числовий ідентифікатор, повертає цю ж нотатку з згенерованим ідентифікатором
    public Note add(Note note){
        //note.setId(Jojo.generateId());
        list.add(note);
        return note;
    }
    //видаляє нотатку з вказаним ідентифікатором. Якщо нотатки з ідентифікатором немає - викидає виключення.
    public void deleteById(long id){
        Note noteToRemove = list.stream()
                .filter(note -> note.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Note with id " + id + " not found"));

        list.remove(noteToRemove);
    }
    //шукає нотатку по note.id. Якщо нотатка є - оновлює для неї title та content. Якщо нотатки немає - викидає виключення
    public void update(Note note){
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == note.getId()) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            list.set(index, note);
        } else {
            throw new IllegalArgumentException("Note with id " + note.getId() + " not found");
        }
    }
    //повертає нотатку по її ідентифікатору. Якщо нотатки немає - викидає виключення.
    public Note getById(long id) {
        return list.stream()
                .filter(note -> Objects.equals(note.getId(), id))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("There is not any note with id -" + id));
    }

    static class Jojo{
        public static long generateId() {
            Random random = new Random();
            return Math.abs(random.nextInt());
        }
    }
}
