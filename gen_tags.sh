#!/usr/bin/env bash
# Script to generate tags file for various tag tools

CLJ_SRC="src"
CONF_DIR="etc"
OUT_DIR="tags"

# CTAGS
# =====

CTAGS_BIN="ctags"
CTAGS_VRS=$($CTAGS_BIN --version | head -1 | tr ',' ' ' | cut -d' ' -f3)

# Test ctags with as Lisp conf
CTAGS_LSP="$OUT_DIR/ctags_${CTAGS_VRS}-as-lsp.tags"
[ -f "$CTAGS_LSP" ] && \rm "$CTAGS_LSP"
"$CTAGS_BIN" --options=NONE -o "$CTAGS_LSP" --options="$CONF_DIR/ctags_as_lsp.opt" -R "$CLJ_SRC"

# Test ctags with custom Clojure conf
CTAGS_CLJ="$OUT_DIR/ctags_${CTAGS_VRS}-clj.tags"
[ -f $CTAGS_CLJ ] && \rm $CTAGS_CLJ
"$CTAGS_BIN" --options=NONE -o "$CTAGS_CLJ" --options="$CONF_DIR/ctags_clj.opt" -R "$CLJ_SRC"


# UCTAGS
# ======

# Test universal ctags which as native Clojure support
UCTAGS_BIN="uctags"
UCTAGS_VRS=$($UCTAGS_BIN --version | head -1 | tr ',' ' ' | cut -d' ' -f3)

UCTAGS_OUT="$OUT_DIR/uctags_${UCTAGS_VRS}.tags"
[ -f "$UCTAGS_OUT" ] && \rm "$UCTAGS_OUT"
"$UCTAGS_BIN" --options=NONE -o "$UCTAGS_OUT" -R "$CLJ_SRC"
