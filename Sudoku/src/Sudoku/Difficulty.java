package Sudoku;

public enum Difficulty {

    EASY {
        @Override
        public int getDifficulty() {
            return 1;
        }
    },
    MEDIUM {
        @Override
        public int getDifficulty() {
            return 2;
        }
    },
    HARD {
        @Override
        public int getDifficulty() {
            return 3;
        }
    },
    EXPERT {
        @Override
        public int getDifficulty() {
            return 4;
        }
    },
    EVIL {
        @Override
        public int getDifficulty() {
            return 5;
        }
    };

    public abstract int getDifficulty();
}
