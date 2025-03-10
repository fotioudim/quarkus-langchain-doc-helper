package com.dfotiou.gr.dochelper.service;

import com.dfotiou.gr.dochelper.model.DocHelperRequest;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;

@RegisterAiService
@SystemMessage("""
            You are an AI tool helping researchers, engineers, developers etc in their path to attain
            greater knowledge for a scientific field.
        """)
public interface DocHelperAIService {


    @UserMessage("""
                Your task is answer the question "{request.question}" with {request.style} style.
                The answers should be explanatory providing source references and be {request.size} in size.
            """)
    String question(DocHelperRequest request);

    @UserMessage("""
                Your task is to provide a brief summary for the key phrase "{request.keyPhrase}"
                with {request.style} style.
            """)
    String summary(DocHelperRequest request);
}
