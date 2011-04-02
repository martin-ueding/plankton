# Copyright (c) 2011 Martin Ueding <dev@martin-ueding.de>

# TODO put these in their own targets
.PHONY: planktongame.jar
planktongame.jar: Plankton.java
	javac Plankton.java
	jar cfm planktongame.jar manifest.txt *.class *.java *.properties *.png *.jpg

