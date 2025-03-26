# makefile fifthproject
# windows version

.SUFFIXES: .class .java

PACK=fifthproject
TARG=test
JC=javac -g -encoding utf8
JM=java -ea -jar
JR=jar -cfe

OBJ=$(PACK)\Abiturient.class \
    $(PACK)\test.class

.java.class:
	$(JC) $<

run: build
	$(JM) $(TARG).jar

build: 	$(OBJ)
	$(JR) $(TARG).jar $(PACK).test $(OBJ)

clean:
	for %%f in ($(OBJ)) do del %%f
	del $(TARG).jar

$(PACK)\Abiturient.class: $(PACK)\Abiturient.java makefile.win

$(PACK)\test.class: $(PACK)\test.java makefile.win

# eof makefile fifthproject