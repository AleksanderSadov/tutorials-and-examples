#!/usr/bin/env bash

if ! [[ -x $(command -v node) ]]; then
  curl -sL https://deb.nodesource.com/setup_10.x | sudo -E bash -
  sudo apt-get install -y nodejs
fi

if ! [[ -x $(command -v ng) ]]; then
  npm install -g @angular/cli
fi

if ! [[ -d "/vagrant/node_modules" ]]; then
  npm install --prefix /vagrant --no-bin-links
fi
