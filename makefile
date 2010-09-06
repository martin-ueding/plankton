.PHONY: planktongame.jar
planktongame.jar:
	javac Plankton.java
	jar cfm planktongame.jar manifest.txt *.class *.java *.properties *.png

