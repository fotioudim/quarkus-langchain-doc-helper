# quarkus-langchain-doc-helper

This project uses Quarkus, the Supersonic Subatomic Java Framework, integrated with LangChain4j
library using Retrieval-Augmented Generation process and
providing a REST API to interact with Large Language Models. 

- Large Language Models (LLMs) are AI-based systems designed to understand, generate, and manipulate human language, 
showcasing advanced natural language processing capabilities. 
- LangChain4j library offers a declarative approach to interact with diverse LLMs like OpenAI, Hugging Face, Ollama, or Jlama.
- Retrieval-Augmented Generation (RAG) is the process of optimizing the output of a large language model, so it references 
an authoritative knowledge base outside of its training data sources before generating a response. RAG extends the already
powerful capabilities of LLMs to specific domains or an organization's internal knowledge base, all without the need to retrain the model.

## Prerequisites
- Java 21
- A running container environment, such as Docker or Podman


## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
mvn quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at <http://localhost:8080/q/dev/>.

## Requests
You can interact with the LLM using the following two ways:

1) Make a question:
```
curl --request POST \
  --url http://localhost:8080/doc/help/question \
  --header 'Content-Type: application/json' \
  --data '{
	"question": "Is Runtime Verification useful in Internet of Things ecosystems?",
	"style": "informal",
	"size": "short"
}'
```

2) Require a summary about a keyphrase:

```
curl --request POST \
  --url http://localhost:8080/doc/help/summary \
  --header 'Content-Type: application/json' \
  --data '{
	"keyPhrase": "Runtime Verification",
	"style": "academic"
}'
```

## Related Documentation

- LangChain4j OpenAI ([guide](https://docs.quarkiverse.io/quarkus-langchain4j/dev/index.html)): Provides the basic integration with LangChain4j
- RAg process [benefits](https://aws.amazon.com/what-is/retrieval-augmented-generation/)
- Edge-Based Runtime Verification for the Internet of Things [paper](https://ieeexplore.ieee.org/stamp/stamp.jsp?tp=&arnumber=9411895)
