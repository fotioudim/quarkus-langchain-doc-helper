package com.dfotiou.gr.dochelper.resource;

import com.dfotiou.gr.dochelper.model.ValidationGroups;
import com.dfotiou.gr.dochelper.service.DocHelperAIService;
import com.dfotiou.gr.dochelper.model.DocHelperRequest;
import io.micrometer.core.annotation.Timed;
import jakarta.validation.Valid;
import jakarta.validation.groups.ConvertGroup;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/doc/help")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.TEXT_PLAIN)
public class DocHelperAIResource {

    private final DocHelperAIService docHelperAIService;

    DocHelperAIResource(DocHelperAIService docHelperAIService) {
        this.docHelperAIService = docHelperAIService;
    }

    @POST
    @Path("/summary")
    @Timed(value = "Doc-Summary timer", histogram = true,
            description = "A measure of how long it takes to extract a summary for a key phrase.")
    public String summary(@Valid @ConvertGroup(to = ValidationGroups.Summary.class) DocHelperRequest docHelperRequest) {
        return docHelperAIService.summary(docHelperRequest);
    }

    @POST
    @Path("/question")
    @Timed(value = "Doc-Answer timer", histogram = true,
            description = "A measure of how long it takes to answer a question.")
    public String question(@Valid @ConvertGroup(to = ValidationGroups.Question.class) DocHelperRequest docHelperRequest) {
        return docHelperAIService.question(docHelperRequest);
    }

}
