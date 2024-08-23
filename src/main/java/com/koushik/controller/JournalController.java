package com.koushik.controller;

import com.koushik.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/_journal")
public class JournalController {

  public Map<Long,JournalEntry> journalEntryList = new HashMap();

  @GetMapping("/")
  public List<JournalEntry>  getAll()
  {
      return new ArrayList<>(journalEntryList.values());
  }

//  @PostMapping("/create")
//   public String createEntry(@RequestBody JournalEntry journalEntry)
//   {
//       journalEntryList.put(journalEntry.getId(),journalEntry);
//       return "created";
//   }

   @GetMapping("id/{id}")
   public JournalEntry getById(@PathVariable Long id)
   {
       JournalEntry journalEntry =journalEntryList.get(id);
       return  journalEntry;
   }


   @DeleteMapping("delete/{id}")
   public Boolean deleteById(@PathVariable Long id)
   {
       journalEntryList.remove(id);
       return true;
   }
}
