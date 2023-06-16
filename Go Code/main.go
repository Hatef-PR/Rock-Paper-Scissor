package main

import (
	"fmt"
	"math/rand"
	"strings"
)

func main() {
	var userWin, computerWin = 0, 0
	var option = [3]string{"r", "p", "s"}

	for true {
		fmt.Println("Type R / P / S or Q to quite: ")
		var userInput string
		fmt.Scanln(&userInput)
		var userInput1 = strings.ToLower(userInput)
		if userInput1 == "q" {
			break
		} else if userInput1 != "r" && userInput1 != "p" &&
			userInput1 != "s" {
			continue
		}
		var randomNumber = rand.Intn(2)
		var computerPick = option[randomNumber]

		if checkUserWin(userInput1, computerPick) {
			fmt.Println("You won!")
			userWin += 1
		} else if checkCoputerWin(userInput1, computerPick) {
			fmt.Println("Computer won!")
			computerWin += 1
		} else if userInput1 == computerPick {
			fmt.Println("Both are the same!")
		}
	}
	fmt.Println("You:", userWin)
	fmt.Println("Computer:", userWin)

}

// This method checks the user won the game or not
func checkUserWin(userInput, computerPick string) bool {
	var flag = false
	if (userInput == "r" && computerPick == "p") ||
		(userInput == "p" && computerPick == "s") ||
		(userInput == "s" && computerPick == "r") {
		flag = true
	}
	return flag
}

// This method checks the computer won the game or not
func checkCoputerWin(userInput, computerPick string) bool {
	var flag = false
	if (computerPick == "r" && userInput == "p") ||
		(computerPick == "p" && userInput == "s") ||
		(computerPick == "s" && userInput == "r") {
		flag = true
	}
	return flag
}
