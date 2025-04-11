from dataclasses import dataclass
from typing import Optional

@dataclass
class Flashcard:
    id: str
    front: str   # e.g. Kanji
    back: str    # e.g. Meaning or reading
    video_url: Optional[str] = None