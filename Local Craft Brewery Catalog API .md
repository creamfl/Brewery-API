#Local Craft Brewery Catalog API

##Introduction
An API for a local craft brewery catalog, detailing brewery profiles, beer listings, tasting notes, and customer reviews.

##Base URL
`http://localhost:8080/api`

## Endpoints

### 1. Create a New Brewery

**HTTP Method:** `POST`

**Endpoint:** `/brewery`

**Description:** Allows you to add new breweries by your choice.

**Request Headers:**
- `Content-Type: application/json`

**Request Body:**
```json
{
        "name": "UACS's brewery",
        "location": "Skopje",
        "establishedYear": 2005
}
```

**Responses:**

- **201 Created:**
  ```json
  {
        "id": 3,
        "name": "UACS's brewery",
        "location": "Skopje",
        "establishedYear": 2005
    }
  ```
- **400 Bad Request:** Invalid input

---

### 2. View Current Status of All Local Breweries

**HTTP Method:** `GET`

**Endpoint:** `/brewery`

**Description:** View Current Status of All Local Breweries.

**Request Headers:**
- `Accept: application/json`

**Responses:**

- **200 OK:**
```json
[
    {
        "id": 1,
        "name": "nikis brewery",
        "location": "Gevgelija",
        "establishedYear": 1992
    },
    {
        "id": 2,
        "name": "stefans brewery",
        "location": "Bitola",
        "establishedYear": 2000
    },
    {
        "id": 3,
        "name": "UACS's brewery",
        "location": "Skopje",
        "establishedYear": 2005
    }
]
```
- **204 No Content:** No issues found

---

### 3. Retrieve a Single Brewery

**HTTP Method:** `GET`

**Endpoint:** `/brewery/{id}`

**Description:** View Current Status of All Local Breweries by its ID.

**Request Headers:**
- `Accept: application/json`

**Path Parameters:**
- `id` (integer): ID of the issue

**Responses:**

- **200 OK:**
```json
{
    "id": 3,
    "name": "UACS's brewery",
    "location": "Skopje",
    "establishedYear": 2005
}
```

- **404 Not Found:** Issue not found

---

### 4. Update brewery

**HTTP Method:** `PUT`

**Endpoint:** `/brewery/{id}?name=____&location=_____`

**Description:** Update the status of a brewery, location or name.

**Request Headers:**
- `Content-Type: application/json`

**Path Parameters:**
- `id` (integer): ID of the issue

**Request Body:**
```json

```

**Responses:**

- **200 OK:**
  ```json
  [
    {
        "id": 1,
        "name": "nikis brewery",
        "location": "Gevgelija",
        "establishedYear": 1992
    },
    {
        "id": 2,
        "name": "stefans brewery",
        "location": "Bitola",
        "establishedYear": 2000
    },
    {
        "id": 4,
        "name": "sda's brewery",
        "location": "Skopje",
        "establishedYear": 2005
    },
    {
        "id": 3,
        "name": "UUAACCSS brewery",
        "location": "Skopje",
        "establishedYear": 2005
    }
  ]
  ```
  - **400 Bad Request:** Invalid input
- **404 Not Found:** Issue not found

  ### 5. Delete a brewery

**HTTP Method:** `DELETE`

**Endpoint:** `/brewery/{id}`

**Description:** Delete a brewery after it gets closed.

**Request Headers:**
- `Accept: application/json`

**Path Parameters:**
- `id` (integer): ID of the issue

**Responses:**

- **204 No Content:**
- **404 Not Found:** Issue not found

---
