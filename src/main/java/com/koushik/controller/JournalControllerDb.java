package com.koushik.controller;

import com.koushik.entity.JournalEntry;
import com.koushik.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;



@RestController
@RequestMapping("/journal")
public class JournalControllerDb {


    @Autowired
    private JournalEntryService journalEntryService;

  @GetMapping("/getAllEntry")
  public List<JournalEntry>  getAll()
  {

      List<JournalEntry> all = journalEntryService.getAll();
      return  all;
  }

  @PostMapping("/create")
   public JournalEntry createEntry(@RequestBody JournalEntry journalEntry)
   {
        journalEntry.setLocalDataTime(LocalDateTime.now());
       journalEntryService.saveEntry(journalEntry);
       return journalEntry;
   }

   @GetMapping("id/{id}")
   public JournalEntry getById(@PathVariable ObjectId id)
   {
       return journalEntryService.findById(id).orElse(null);
       //journalEntryService.findById(id);
       //JournalEntry journalEntry =journalEntryList.get(id);

   }


   @DeleteMapping("delete/{id}")
   public void deleteById(@PathVariable ObjectId id)
   {
       //journalEntryService.findById(id);
       journalEntryService.deleteJournal(id);

   }

   @GetMapping("/msg")
   public String msg()
   {
       return "Koushik";
   }
}
