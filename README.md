# Simple Note Manager

Web application for creating, modifying, deleting and visualizing notes.

Every note consists of the title and some plain text. All the notes are listed on a single web page (client). The user
can enter new notes by clicking on a button opening taking the input data from a edit field and a textarea.

The front-end is written with HTML, CSS and java script. On the back-end site a REST API is written in Java together
with the Spring framework. A H2 database acts as storage. 
The IDE intelliJ makes it very easy to set this up and maintain.

The architecture on the top level of this application looks like this:

![The Business Context](/doc/images/SimpleNoteManager_BusinessContext.png)

The client site sends REST API calls to the server application, which holds the persistent data (notes).
The web server on the backend-site is responding to the following endpoints:
- POST /api/[id] : insert a new note
- GET /api/list : get a list with all available notes
- GET /api/[id] : get the note entry for a given id
- DELETE /api/[id] : delete the note entry with a given id
- PUT /api/[id] : update the note entry with a given id

The architecture on the server site is shown in the image below:
![The backend architecture](/doc/images/SimpleNoteManager_ServerArchitecture.png)
Dependency Injection is used to get a loose coupling. Hence the application becomes more reusable, maintainable and
testable.
