$(document).ready(() => {
    let articolToEdit = null;

    $('#add-articol-button').click(() => {
        if (articolToEdit) {
            editArticol(articolToEdit);
        } else {
            addNew();
        }
    });

    function editArticol(articolToEdit) {
        const name = $('#modal-articol-name').val();
        const description = $('#modal-articol-description').val();
        const category = $('#modal-articol-category').val();

        fetch(`/api/articole/${articolToEdit}`, {
            method: 'PUT',
            body: JSON.stringify({
                name: name,
                description: description,
                category: category
            }),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(response => {
            if (response.ok) {
                location.reload();
            } else {
                alert("There were errors " + response.status);
            }
        });
    }

    function addNew() {
        const name = $('#modal-articol-name').val();
        const description = $('#modal-articol-description').val();
        const category = $('#modal-articol-category').val();

        fetch('/api/articole', {
            method: 'POST',
            body: JSON.stringify({
                name: name,
                description: description,
                category: category
            }),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(response => {
            if (response.ok) {
                location.reload();
                clearModal();
            } else {
                alert("There were errors " + response.status);
            }
        });
    }

    function clearModal() {
        $('#modal-articol-name').val('');
        $('#modal-articol-description').val('');
        $('#modal-articol-category').val('');
    }

    $('.delete-icon').click(function () {
            const articolId = this.parentElement.id;
            fetch(`api/articole/${articolId}`, {
                method: 'DELETE'
            }).then(response => location.reload());
        });

    $('.edit-icon').click(function () {
        articolToEdit = this.parentElement.id;
        const row = this.parentElement.parentElement.parentElement;
        const name = row.children[1].innerText;
        const description = row.children[2].innerText;
        const category = row.children[3].innerText;

        $('#modal-articol-name').val(name);
        $('#modal-articol-description').val(description);
        $('#modal-articol-category').val(category);
    });

    $('#add-articol-main-button').click(() => {
        clearModal();
        transactionToEdit = null
    });
});