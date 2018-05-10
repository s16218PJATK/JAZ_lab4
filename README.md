**Moviedb REST API**
----
**Modules:**
  - movies
  - actors
  - comments
----
Movies - Get all movies
-----------------------

* **URL**

      /movies

* **Method:**

  #### `GET`


* **Success Response:**

 * **Code:** 200 <br />
   **Content:**

      ```json
      [
        {
          "URI": "/movies/2",
          "actors": [
              "/actors/2"
          ],
          "comments": [
              "/comments/2",
              "/comments/3"
          ],
          "id": 2,
          "info": "First part!",
          "rating": 2,
          "title": "Spiderman"
        }
      ]
      ```

----
Movies - Get movie by ID
------------------------

* **URL**

      /movies/{id}

* **Method:**

    #### `GET`


* **Success Response:**

 * **Code:** `200` <br />
   **Content:**

      ```json
      {
          "URI": "/movies/2",
          "actors": [
              "/actors/2"
          ],
          "comments": [
              "/comments/2",
              "/comments/3"
          ],
          "id": 2,
          "info": "First part!",
          "rating": 2,
          "title": "Spiderman"
        }
        ```

----
Movies - Add / update movie
---------------------------

* **URL**

      /movies/{id}

* **Method:**

    #### `POST` - add
    #### `PUT` - update


* **Body:**

  ```json
    {
    	"title": "Spiderman I",
    	"info": "First part - out of 3!"
    }
  ```

* **Success Response:**

 * **Code:** `200` <br />
   **Content:**

        /movies/2

----
Movies - Remove movie
---------------------

* **URL**

      /movies/{id}

* **Method:**

    #### `DELETE`


* **Success Response:**

 * **Code:** `200` <br />

----
Movies - Get movie average rating
---------------------------------

* **URL**

      /movies/{id}/rating

* **Method:**

    #### `GET`


* **Success Response:**

 * **Code:** `200` <br />
   **Content:**

      ```json
      4.85
        ```
----
Movies - Rate movie
-------------------

* **URL**

      /movies/{id}/rating/{rate}

* **Method:**

    #### `POST`


* **Success Response:**

 * **Code:** `200`

Movies - Get all actors in a movie by ID
------------------------

* **URL**

     /movies/{id}/actors

* **Method:**

   #### `GET`


* **Success Response:**

* **Code:** `200` <br />
  **Content:**

     ```json
     [
        "/actors/2",
        "/actors/42"
     ]
       ```

----
Movies - Add an actor to a movie; add movie to actor's movie list
---------------------------

* **URL**

      /movies/{id}/actors/{actor_id}

* **Method:**

    #### `POST`


* **Success Response:**

 * **Code:** `200` <br />
   **Content:**

    ```json
   [
      "/actors/2",
      "/actors/42"
   ]
    ```

----
Movies - Remove an actor from a movie; remove movie from actor's movie list
---------------------------

* **URL**

      /movies/{id}/actors/{actor_id}

* **Method:**

    #### `DELETE`


* **Success Response:**

 * **Code:** `200` <br />
   **Content:**

    ```json
   [
      "/actors/2",
      "/actors/42"
   ]
    ```

----
Movies - Get all comments in a movie by ID
------------------------

* **URL**

     /movies/{id}/comments

* **Method:**

   #### `GET`


* **Success Response:**

* **Code:** `200` <br />
  **Content:**

     ```json
     [
        "/comments/2",
        "/comments/3"
     ]
       ```

----
Movies - Add comment to a movie
---------------------------

* **URL**

      /movies/{id}/comments

* **Method:**

    #### `POST`

* **Body:**

  ```json
  {
     "content": "Best movie so far!"
  }
  ```

* **Success Response:**

 * **Code:** `200` <br />
   **Content:**

        /comments/2

----
Actors - Get all actors
-----------------------

* **URL**

      /actors

* **Method:**

  #### `GET`


* **Success Response:**

 * **Code:** 200 <br />
   **Content:**

      ```json
      [
        {
          "URI": "/actors/2",
          "id": 2,
          "movies": [
              "/movies/2"
          ],
          "name": "Fred",
          "surname": "Fredowski"
        }
      ]
      ```

----
Actors - Get actor by ID
------------------------

* **URL**

      /actors/{id}

* **Method:**

    #### `GET`


* **Success Response:**

 * **Code:** `200` <br />
   **Content:**

      ```json
      {
        "URI": "/actors/2",
        "id": 2,
        "movies": [
            "/movies/2"
        ],
        "name": "Fred",
        "surname": "Fredowski"
      }
      ```

----
Actors - Add / update actor
---------------------------

* **URL**

      /actors/{id}

* **Method:**

    #### `POST` - add
    #### `PUT` - update


* **Body:**

  ```json
  {
    "name": "Derf",
    "surname": "Derfowski"
  }
  ```

* **Success Response:**

 * **Code:** `200` <br />
   **Content:**

        /actors/2

----
Actors - Remove actor
---------------------

* **URL**

      /actor/{id}

* **Method:**

    #### `DELETE`


* **Success Response:**

 * **Code:** `200` <br />

----
Actors - Get all movies of an actor by ID
------------------------

* **URL**

     /actors/{id}/movies

* **Method:**

   #### `GET`


* **Success Response:**

* **Code:** `200` <br />
  **Content:**

     ```json
     [
        "/movies/2",
        "/movies/3"
     ]
       ```

----
Comments - Get comment by ID
------------------------

* **URL**

      /comments/{id}

* **Method:**

    #### `GET`


* **Success Response:**

 * **Code:** `200` <br />
   **Content:**

      ```json
      {
        "URI": "/comments/3",
        "content": "Can't wait for sequel!",
        "date": "2018/05/10 16:55:09",
        "id": 3,
        "movie": "/movies/2"
      }
      ```

----
Comments - Update comment
---------------------------

* **URL**

      /comments/{id}

* **Method:**

    #### `PUT`


* **Body:**

  ```json
  {
    "content": "Can't wait for more!"
  }
  ```

* **Success Response:**

 * **Code:** `200` <br />
   **Content:**

        /comments/2

      _Note: Comment will update it's date!_
----
Comments - Remove comment
---------------------

* **URL**

      /comment/{id}

* **Method:**

    #### `DELETE`


* **Success Response:**

 * **Code:** `200` <br />

----


# Common Error Responses:
* **Error Response:**

  Movie / actor / comment with given ID does not exist.

  * **Code:** `404` <br />
    **Content:** Glassfish server 404 landing page.
