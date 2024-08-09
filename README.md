
# Simple Note Manager

Web application for creating, modifying, deleting and visualizing notes.

Every note consists of the title and some plain text. All the notes are listed on a single web page (client). The user can enter new notes by clicking on a single button opening  
a form with two edit fields for the title and the note text.

The front-end is written with HTML, CSS and java script. On the back-end site a REST API is written in Java together with the Spring framework.  
The IDE intelliJ makes it very easy to set this up and maintain.

The architecture on the top level of this application looks like this:

![The Business Context](/doc/images/SimpleNoteManager_BusinessContext.png)

The client site sends REST API calls to the server application, which holds the persistent data (notes).
The web server is responding to the following endpoints:
- /api/add
- /api/list
- /api/delete

The architecture on the server site is shown in the image below:
![The backend architecture](/doc/images/SimpleNoteManager_ServerArchitecture.png)
Dependency Injection is used to get a loose coupling. Hence the application becomes more reusable, maintainable and testable.
