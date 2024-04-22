JAVAC=/usr/bin/javac
JAVA=/usr/bin/java

.SUFFIXES: .java .class
SRCDIR = src
BINDIR = bin

$(BINDIR)/%.class:$(SRCDIR)/%.java
	$(JAVAC) -d $(BINDIR)/ -cp $(BINDIR) $<

CLASSES = Statement.class DataQuery.class Guru.class ArrayBase.class Node.class BinarySearchTree.class BinarySearchTreeBase.class coButton.class Home.class SearchField.class Search.class Update.class UniversalListener.class GenericsKbArrayApp.class GenericsKbBSTApp.class


CLASS_FILES = $(CLASS:%.class=$(BINDIR)%.class)

default: $(CLASS_FILES)

clean:
	rm $(BINDIR)/*.class

GenericsKbBSTApp:
	java -cp $(BINDIR) GenericsKbBSTApp

GenericsKbArrayApp:
	java -cp $(BINDIR) GenericsKbArrayApp

help:
	cat README.txt


