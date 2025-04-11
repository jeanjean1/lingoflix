from flask import Flask, request, jsonify, render_template

app = Flask(__name__)

mock_decks = {
    "japanese_basic": [
        {"id": 1, "front": "犬", "back": "Dog"},
        {"id": 2, "front": "猫", "back": "Cat"},
    ],
}

# To implement ---------------------------------------------------
@app.route('/')
def index():
    return render_template('templates/index.html')


@app.route('/api/getDeckCards/<deckname>', methods=['GET'])
def get_deck_cards(deckname):
    # Fetch deck by name, or return an empty list if not found
    deck = mock_decks.get(deckname)

    # Return the flashcards as JSON
    return jsonify(deck)


@app.route('/api/getFlashcard/<cardID>', methods=['GET'])
def get_flashcard(cardID):
    pass


@app.route('/api/getVideoSuggestions/<word>', methods=['GET'])
def get_video_suggestions(word):
    pass


@app.route('/api/saveFlashcard', methods=['POST'])
def save_flashcard():
    pass

if __name__ == '__main__':
    app.run(debug=True)
