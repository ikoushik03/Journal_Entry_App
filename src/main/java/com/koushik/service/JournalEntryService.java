package com.koushik.service;

import com.koushik.entity.JournalEntry;
import com.koushik.repository.JournalRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JournalEntryService {

    @Autowired
    private JournalRepo journalRepo;

    public void saveEntry(JournalEntry journalEntry)
    {
         journalRepo.save(journalEntry);

    }

    public Optional<JournalEntry> findById(ObjectId id)
    {
        Optional<JournalEntry> byId = journalRepo.findById(id);
        return byId;
        //  journalRepo.findById(id);
    }

    public List<JournalEntry> getAll()
    {
        return journalRepo.findAll();
    }

    public void deleteJournal(ObjectId id){
       journalRepo.deleteById(id);
    }
}
