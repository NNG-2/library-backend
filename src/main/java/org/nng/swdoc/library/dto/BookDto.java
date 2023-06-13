package org.nng.swdoc.library.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDto {
    private Long id;

    private String title;

    private Double quantity;

    private Double collateralCost;

    private Double rentalCost;

    private AuthorDto author;

    private GenreDto genre;

    private LibraryDto library;

    private Long imageId;
}
