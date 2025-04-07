from flask import Flask, request, jsonify, render_template

app = Flask(__name__)


# To implement ---------------------------------------------------
@app.route('/')
def index():
    return render_template('index.html')


@app.route('/api/getDeckCards/<deckname>', methods=['GET'])
def get_deck_cards(deckname):
    pass


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
