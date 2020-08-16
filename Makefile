# Copyright (c) 2020 Quirino Gervacio

.PHONY: help

help:
	@echo "Usage: make [target]"
	@awk 'BEGIN {FS = ":.*?## "} /^[a-zA-Z_-]+:.*?## / {printf "\033[36m%-11s\033[0m %s\n", $$1, $$2}' $(MAKEFILE_LIST)

.DEFAULT_GOAL := help

c: clean
clean: ## (c) Clean repo by resetting head hard
	@git clean -fdx
	@git fetch origin
	@git reset --hard origin/master
	