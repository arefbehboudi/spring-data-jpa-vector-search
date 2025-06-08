
# 🧠 Spring Boot + Vector Search + Text Embedding API

A simple open-source project to find similar articles using **vector search** with PostgreSQL. It uses Spring Data JPA on the Java backend and a lightweight Python API to generate text embeddings using [`sentence-transformers/all-MiniLM-L6-v2`](https://huggingface.co/sentence-transformers/all-MiniLM-L6-v2).

---

## ✨ Features

* Add new articles with vector embeddings
* Find similar articles using cosine similarity
* Embedding generation via a separate Python API (`embedding_api.py`)
* PostgreSQL + `pgvector` for vector storage and similarity search

---

## ⚙️ Project Structure

```text
project-root/
│
├── src/                      # Spring Boot project
│   └── main/java/...
│
├── embedding-api/            # Python service for embeddings
│   ├── embedding_api.py
│   └── requirements.txt
│
└── README.md
```

---

## 🧪 Python Embedding API

### 1. Setup

```bash
cd embedding-api/
pip install -r requirements.txt
python embedding_api.py
```

The service will be available at `http://localhost:5000`.

### 2. Endpoint: `POST /embed`

**Request:**

```json
{
  "texts": ["Example article content"]
}
```

**Response:**

```json
{
  "embeddings": [[0.123, -0.456, ...]]
}
```

---

## 🚀 Spring Boot API

Your Spring Boot backend interacts with the embedding service and PostgreSQL database.

### 🔹 `POST /api/articles`

**Description:** Adds a new article to the database.

**Request Body:**

```json
{
  "title": "AI in Healthcare",
  "content": "Artificial intelligence is revolutionizing healthcare..."
}
```

**Flow:**

1. Spring Boot sends `content` to Python embedding API.
2. Receives the vector and stores it alongside the article in PostgreSQL using `pgvector`.

---

### 🔹 `POST /api/articles/search`

**Description:** Finds similar articles based on input text.

**Request Body:**

```json
{
  "query": "How AI is used in medicine?"
}
```

**Flow:**

1. Spring Boot sends the `query` to the embedding API.
2. Gets back a vector.
3. Runs a cosine similarity search in the `articles` table using the embedding vector.
4. Returns a list of most similar articles.

---

## 📦 Example Java Model

```java
@Entity
public class Article {
    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String content;

    @Column(columnDefinition = "vector(384)") // pgvector
    @JdbcTypeCode(SqlTypes.VECTOR)
    @Array(length = 384)
    private Vector embedding;
}
```

---

## 🧠 Technologies Used

* **Java 17 + Spring Boot**
* **PostgreSQL** with `pgvector` extension
* **Python + Flask** for embeddings
* **sentence-transformers/all-MiniLM-L6-v2**

---

