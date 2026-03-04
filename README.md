# ai-text-assistant

A simple Spring Boot REST API that demonstrates Spring AI integration with OpenAI for text tasks.

## Tech Stack
- Java 21
- Spring Boot 3
- Spring AI
- Maven
- Lombok

## Endpoints

### 1) Summarize Text
`POST /ai/summarize`

Request:
```json
{
  "text": "long paragraph"
}
```

Response:
```json
{
  "summary": "short summary"
}
```

### 2) Explain Like I'm 5
`POST /ai/explain`

Request:
```json
{
  "topic": "Microservices architecture"
}
```

Response:
```json
{
  "explanation": "simple explanation suitable for a 5 year old"
}
```

### 3) Java Code Review
`POST /ai/code-review`

Request:
```json
{
  "code": "Java code snippet"
}
```

Response:
```json
{
  "review": "AI suggestions and improvements"
}
```

## Prerequisites
- Java 21
- Maven 3.9+
- OpenAI API key

## Run
1. Export your API key:
   ```bash
   export OPENAI_API_KEY=your_openai_api_key
   ```
2. Build the project:
   ```bash
   mvn clean compile
   ```
3. Start the app:
   ```bash
   mvn spring-boot:run
   ```

The application starts on `http://localhost:8080`.

## Test with curl

Summarize:
```bash
curl -X POST http://localhost:8080/ai/summarize \
  -H "Content-Type: application/json" \
  -d '{"text":"Spring AI helps developers integrate language models into Spring applications using familiar patterns."}'
```

Explain:
```bash
curl -X POST http://localhost:8080/ai/explain \
  -H "Content-Type: application/json" \
  -d '{"topic":"Microservices architecture"}'
```

Code Review:
```bash
curl -X POST http://localhost:8080/ai/code-review \
  -H "Content-Type: application/json" \
  -d '{"code":"public class Test { public static void main(String[] args){ System.out.println(\"Hi\"); }}"}'
```
