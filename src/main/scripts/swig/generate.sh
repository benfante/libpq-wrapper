#!/bin/sh

swig -java -package com.benfante.experiments.libpqwrapper.swig -outdir ../../../generated/java/com/benfante/experiments/libpgwrapper/swig pqswig.i

gcc -c pqswig_wrap.c -I /usr/lib/jvm/java-6-sun/include -I /usr/lib/jvm/java-6-sun/include/linux

ld -G pqswig_wrap.o -o libpqswig.so -lpq