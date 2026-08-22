# 🧩 Maze Game

A **maze game developed in Java**, where the player navigates through a 15×15 maze, collects different bonuses, encounters mines and walls, and tries to reach the exit with the minimum possible number of moves.

The project focuses on applying **basic Java programming, algorithmic thinking, two-dimensional arrays, randomization, and game logic** to create an interactive console-based maze game.

## 🎮 About the Game

The game represents a maze as a two-dimensional grid containing paths, walls, mines, bonuses, a starting point, and an exit.

The player's goal is to move from the **B (Beginning)** position to the **E (Exit)** position while trying to complete the maze in as few moves as possible. During the game, the player can collect different bonuses that provide advantages such as teleportation, removing walls, reducing the move count, or protection against mines.

Mines and bonuses are placed at random positions and can change locations during the game, adding a dynamic element to the maze.

## ✨ Features

- 🧩 15×15 maze structure
- 🎮 Player-controlled movement using W, A, S, and D
- 🧱 Wall and obstacle detection
- 💣 Randomly placed mines
- 🎁 Collectible bonus system
- 🌀 Teleportation bonus
- 🧱 Wall removal bonus
- ⏪ Move reduction bonus
- 🛡️ Mine protection bonus
- 🔢 Move counter and penalty system
- 🔀 Dynamic mine and bonus placement
- 🏁 Start and exit points
- 🏆 Completion detection

## ⚙️ How It Works

The maze is represented using a **two-dimensional array**, where different characters represent paths, walls, mines, bonuses, and important game locations.

When the player attempts to move, the program:

1. 🎮 Receives the movement input using W, A, S, or D.
2. 📍 Calculates the player's next position.
3. 🚧 Checks whether the position contains a wall, mine, bonus, or open path.
4. 🎁 Collects and stores bonuses encountered during movement.
5. 🔄 Updates the player's position and move count.
6. 🏁 Checks whether the exit has been reached.

The player can also use collected bonuses during the game. The **T bonus** allows teleportation, the **R bonus** removes a wall, the **H bonus** reduces the move count by two, and the **F bonus** provides protection against mines.

If the player encounters a mine without protection, a **5-move penalty** is added to the total move count.

## 🛠️ Technologies & Concepts

- ☕ **Java**
- 🧩 **2D Arrays / Grid Structures**
- 🎲 **Random Number Generation**
- 🔁 **Loops**
- 🔀 **Conditional Logic**
- ⌨️ **Scanner Input**
- 🎮 **Game Logic**
- 📍 **Coordinate-Based Movement**
- 🔢 **Move & Game-State Tracking**
- 🧠 **Algorithmic Thinking**
- 🔧 **Git & GitHub**

## 📂 Project Structure

```text
MAZE-GAME/
│
└── labirentOyunu.java
```

The game logic is contained in a single Java source file, including the maze structure, player movement, bonus mechanics, mine placement, and move tracking.

## 🚀 Running the Game

### Compile

```bash
javac labirentOyunu.java
```

### Run

```bash
java labirentOyunu
```

> Depending on the class name used in the source code, the run command may need to be adjusted.

## 💡 About This Project

This project was one of my exercises in applying **Java fundamentals to a small interactive application**.

Building the game required managing player movement, randomly positioned mines and bonuses, different bonus effects, obstacles, and the move counter within the same maze. It was a useful way to practice **two-dimensional arrays, conditional logic, randomization, user input, and algorithmic thinking** through an interactive game scenario.


