package com.dfotiou.gr.dochelper.model;

import jakarta.validation.constraints.NotNull;

public record DocHelperRequest(
        @NotNull(groups = ValidationGroups.Question.class) String question,
        @NotNull(groups = {ValidationGroups.Question.class, ValidationGroups.Summary.class}) String style,
        @NotNull(groups = ValidationGroups.Question.class) String size,
        @NotNull(groups = ValidationGroups.Summary.class) String keyPhrase) {
}
