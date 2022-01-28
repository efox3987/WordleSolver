JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
		$(JC) $(JFLAGS) $*.java

# This uses the line continuation character (\) for readability
# You can list these all on a single line, separated by a space instead.
# If your version of make can't handle the leading tabs on each
# line, just remove them (these are also just added for readability).
CLASSES = \
		GenWordList.java \
		WordleSolver.java 

default: classes

classes: $(CLASSES:.java=.class)

run:
		java WordleSolver

gen:
		java GenWordList

clean:
		$(RM) *.class