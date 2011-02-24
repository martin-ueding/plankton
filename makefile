# Copyright (c) 2011 Martin Ueding <dev@martin-ueding.de>

.PHONY: planktongame.jar
planktongame.jar:
	javac Plankton.java
	jar cfm planktongame.jar manifest.txt *.class *.java *.properties *.png *.jpg

