# Simple Tic-Tac-Toe

A JetBrains Academy Project written using Java and Intellij Idea

## Description

A command line app for playing Tic-Tac-Toe

## Instructions

At start of game, a blank Tic-Tac-Toe grid is displayed and waits for player one to enter coordinates.

    ---------
    |       |
    |       |
    |       |
    ---------
    Enter the coordinates:

Valid coordinates are

    1 1     1 2     1 3
    2 1     2 2     2 3
    3 1     3 2     3 3

Player 1 (X) enters coordinates

    Enter the coordinates: 1 1

The updated grid is then printed to screen, ready for player 2(O) to enter coordinates.

    ---------
    | X     |
    |       |
    |       |
    ---------
    Enter the coordinates: 

The game continues till there is either a winner or draw.

    ---------
    | X X O |
    | O O O |
    | X   X |
    ---------
    O wins

## Installation

* Clone the repository into directory SimpleTicTacToe.
* Open a command prompt window and go to the directory where you save the program.
* Change to directory - SimpleTicTacToe\src
* Compile code - javac *.java
* Run app - java Main