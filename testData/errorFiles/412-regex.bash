#!/usr/bin/env bash

if [[ $# == 1 && ($1 == "a" || $1 =~ "b") ]]; then
  echo "pong"
fi

if [[ $# == 1 && ($1 == "a" || $1 =~ 'b') ]]; then
  echo "pong"
fi

[[ a =~ ^([0-9]+)\.(.*)$ ]]