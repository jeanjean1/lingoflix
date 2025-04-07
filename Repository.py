from abc import ABC, abstractmethod


# Flashcard repos ---------------------------------------

# Abstract class for flashcard repositories
class FlashcardRepository(ABC):
    @abstractmethod
    def get_flashcard(self, card_id: str):
        pass

    @abstractmethod
    def save_flashcard(self, flashcard_data: dict):
        pass


# Concrete implementations

class Anki(FlashcardRepository):
    # NOTE: Use AnkiConnect : https://git.sr.ht/~foosoft/anki-connect
    def get_flashcard(self, card_id: str):
        # Fetch flashcard from Anki
        pass

    def save_flashcard(self, flashcard_data: dict):
        # Save flashcard to Anki
        pass


# class WaniKani(FlashcardRepository):
#     def get_flashcard(self, card_id: str):
#         # Fetch flashcard from WaniKani API
#         pass

#     def save_flashcard(self, flashcard_data: dict):
#         # Save flashcard to WaniKani
#         pass

# class Bunpro(FlashcardRepository):
#     def get_flashcard(self, card_id: str):
#         # Fetch flashcard from Bunpro API
#         pass

#     def save_flashcard(self, flashcard_data: dict):
#         # Save flashcard to Bunpro
#         pass



# Subtitle repos ---------------------------------------
# Abstract class for subtitle repositories
class SubtitlesRepository(ABC):
    @abstractmethod
    def fetch_subtitles(self, word: str):
        pass


# Concrete implementations 
class FilmOT(SubtitlesRepository):
    def fetch_subtitles(self, word: str):
        # Fetch subtitles via HTTP request
        pass

# class SubtitlesDB(SubtitlesRepository):
#     def fetch_subtitles(self, word: str):
#         # Fetch subtitles from a database
#         pass

