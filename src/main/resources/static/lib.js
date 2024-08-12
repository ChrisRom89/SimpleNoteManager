
const baseURL = "http://localhost:8080"

/**
 * Send DELETE REST request for a given note id. If successful the page gets reloaded.
 * @param noteId
 */
function deleteNote(noteId) {
    fetch(baseURL + '/api/' +noteId, {
        method: 'DELETE'
    }).then(response => {
        location.reload();
    });
}

/**
 * Send GET REST request and create a div container for every obtained note entry dynamically.
 * The div element contains the title, text and a remove button for every note.
 */
function displayNotes() {
    fetch(baseURL + '/api/list')
        .then(function(response) {
            return response.json()
        })
        .then((data) => {
            let elementList = document.getElementById("displayNotesList");
            data.forEach((item) => {
                const newDivElement = document.createElement("div");
                newDivElement.className = "noteEntryDiv";

                let li = document.createElement("li");
                li.innerText = item.title + ': ' + item.text;

                const deleteButton = document.createElement('button');
                deleteButton.className = "btnStyled";
                deleteButton.onclick = function() {
                    deleteNote(item.id);
                }
                const buttonIconElement = document.createElement('a');
                buttonIconElement.className = 'fa fa-trash';
                deleteButton.appendChild(buttonIconElement);
                li.appendChild(deleteButton);

                newDivElement.appendChild(li);
                elementList.appendChild(newDivElement);
            })
        })
        .catch((err) => {
            console.log(`Error fetching: ${err}`)
        });
}

/**
 * This function simply clears the two elements: text input field (id=noteTitle) and the textarea (id=noteText)
 */
function clearInputFields() {
    document.getElementById('noteTitle').value = '';
    document.getElementById('noteText').value = '';
}

/**
 * Get input values from the text field "noteTitle" and textarea "noteText", put into
 * json and send POST request for adding a new note. If successful the page gets reloaded.
 */
function addNote() {
    // receive values from input and textarea
    const valTitle = document.getElementById('noteTitle').value;
    const valText = document.getElementById('noteText').value;

    // prepare json for request
    const test = JSON.stringify({
        title: valTitle,
        text: valText
    });

    // send REST request for adding a new note
    fetch(baseURL + '/api', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            title: valTitle,
            text: valText
        })
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok ' + response.statusText);
            }
            return response;
        })
        .then(data => {
            console.log('Adding note successful');
            clearInputFields();
            location.reload();
        })
        .catch(error => {
            console.error('error during sending data:', error);
        });
}

