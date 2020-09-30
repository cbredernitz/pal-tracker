package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/time-entries")
public class TimeEntryController {

    private TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody TimeEntry timeEntryToCreate) {
        TimeEntry timeEntryCreated = this.timeEntryRepository.create(timeEntryToCreate);

        return new ResponseEntity<>(timeEntryCreated, HttpStatus.CREATED);
    }

    @GetMapping("{timeEntryId}")
    public ResponseEntity<TimeEntry> read(@PathVariable long timeEntryId) {
        TimeEntry timeEntryRead = this.timeEntryRepository.find(timeEntryId);

        if (timeEntryRead != null) {
            return new ResponseEntity<>(timeEntryRead, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping()
    public ResponseEntity<List<TimeEntry>> list() {
        List<TimeEntry> timeEntries = this.timeEntryRepository.list();

        if(timeEntries != null) {
            return new ResponseEntity<>(timeEntries, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity update(long timeEntryId, TimeEntry expected) {
        return null;
    }

    public ResponseEntity delete(long timeEntryId) {
        return null;
    }
}
