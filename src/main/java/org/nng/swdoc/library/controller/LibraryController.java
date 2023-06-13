package org.nng.swdoc.library.controller;

import org.nng.swdoc.library.dto.LibraryDto;
import org.nng.swdoc.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/library")
@EnableMethodSecurity(securedEnabled = true)
public class LibraryController {
    @Autowired
    private LibraryService libraryService;

    @GetMapping("/{id}")
    public ResponseEntity<LibraryDto> getLibraryById(@PathVariable Long id) {
        LibraryDto libraryDto = libraryService.findById(id);
        return ResponseEntity.ok(libraryDto);
    }

    @GetMapping
    public ResponseEntity<List<LibraryDto>> getAllLibraries() {
        List<LibraryDto> libraryDtos = libraryService.findAll();
        return ResponseEntity.ok(libraryDtos);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<LibraryDto> createLibrary(@RequestBody LibraryDto libraryDto) {
        LibraryDto createdLibraryDto = libraryService.createLibrary(libraryDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLibraryDto);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<LibraryDto> updateLibrary(@PathVariable Long id, @RequestBody LibraryDto libraryDto) {
        LibraryDto updatedLibraryDto = libraryService.updateLibrary(id, libraryDto);
        return ResponseEntity.ok(updatedLibraryDto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Void> deleteLibrary(@PathVariable Long id) {
        libraryService.deleteLibrary(id);
        return ResponseEntity.noContent().build();
    }
}

