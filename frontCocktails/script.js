const apiUrl = 'http://localhost:8080/api/cocktails';

async function getAllCocktails() {
    try {
        const response = await fetch(apiUrl);
        const cocktails = await response.json();
        const cocktailsList = document.getElementById('cocktails-list');
        cocktailsList.innerHTML = JSON.stringify(cocktails, null, 2);
    } catch (error) {
        console.error('Error fetching cocktails:', error);
    }
}

document.getElementById('create-cocktail-form').addEventListener('submit', async function(event) {
    event.preventDefault();
    const formData = new FormData(event.target);
    
    const imageFile = formData.get('imagen');
    const imageData = await uploadImage(imageFile);
    formData.set('imagen', imageData);

    const cocktailData = Object.fromEntries(formData.entries());
    try {
        const response = await fetch(apiUrl, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(cocktailData)
        });
        const newCocktail = await response.json();
        alert('Cocktail created successfully');
    } catch (error) {
        console.error('Error creating cocktail:', error);
    }
});

document.getElementById('delete-cocktail-form').addEventListener('submit', async function(event) {
    event.preventDefault();
    const id = event.target.elements.id.value;
    try {
        await fetch(`${apiUrl}/${id}`, { method: 'DELETE' });
        alert('Cocktail deleted successfully');
    } catch (error) {
        console.error('Error deleting cocktail:', error);
    }
});

document.getElementById('calculate-order-form').addEventListener('submit', async function(event) {
    event.preventDefault();
    const id = event.target.elements.id.value;
    const cantidad = event.target.elements.cantidad.value;
    try {
        const response = await fetch(`${apiUrl}/calculate?id=${id}&cantidad=${cantidad}`, { method: 'POST' });
        const result = await response.json();
        const orderResult = document.getElementById('order-result');
        orderResult.innerHTML = JSON.stringify(result, null, 2);
    } catch (error) {
        console.error('Error calculating order:', error);
    }
});

async function uploadImage(imageFile) {
    const formData = new FormData();
    formData.append('image', imageFile);

    const response = await fetch('/php/upload.php', {
        method: 'POST',
        body: formData
    });

    const imageData = await response.json();
    return imageData.filePath;
}
