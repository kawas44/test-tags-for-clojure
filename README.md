# Test Tags For Clojure

## WHAT

Provide better tags tools configuration for the Clojure language.

Goals of the project are:
- to test tools that generate or search tags on Clojure project
- to provide optimal ways to configure those tools
- to provide tips to editor/IDE users who want to use tags tools
- and to lesser extent, to give tags tool creators a feedback on their Clojure support

### TL;DR

- **Ctags:** Use a better Clojure language regexp extension
```bash
cat ctags_clj.opt >> $HOME/.ctags
```

- **Universal Ctags:** Even with support for Clojure, for now you still have better
results with a Ctags Clojure language regexp extension
```bash
mkdir -p $HOME/.ctags.d
cp ctags_clj.opt $HOME/.ctags.d/clojure.ctags
```

- **GNU Global:** You need Pygments + Ctags parser with Clojure language
regexp extension (see above for configuration)  
*NB:* "Find symbol usage" will mostly not work because:
  - Pygments Clojure parser
  [does not separate namespace/alias from symbol name](https://bitbucket.org/birkenfeld/pygments-main/src/7941677dc77d4f2bf0bbd6140ade85a9454b8b80/pygments/lexers/jvm.py?at=default&fileviewer=file-view-default#jvm.py-802)
  - Pygments Clojure parser does not find symbols if they are used after
  a quote reader macro (#')

## WHY

We all need to navigate the code of our project and for this purpose nothing
is as features rich as your editor/IDE connected to a network REPL with
couple of middlewares.

But you know sometimes, you already have 2 or 3 REPLs running for your projects
and you still want to skim the code of this other project or library.
Launching an other REPL is not an option, so you reach for the old *working*
tricks. Some of us use *sharp* tools like `find` or `grep` to cut their way.
Some use **tags** to build an efficient database of defined symbols.

Unfortunately the use of **tags** needs some support by tools that collect or
search them. The current landscape for Clojure is dry in this field (obviously
a REPL knows so much more about your code than static tools) but with a little
bit of tweaking, we can still make use of `ctags` or `global`.

#### Obviously

- Use of a network REPL connected to your editor/IDE is a very efficient way to
navigate your code!
- Use of a proper Clojure static code analyzer would yield vastly better
results
- So now you want *tags* for symbols defined in dependencies....
please start that REPL!

## HOW

### Exuberant Ctags

http://ctags.sourceforge.net/

Looking on the Web, I found two ways to use `ctags`
- Add Clojure file extension to the default LISP language support
- Add Clojure support by defining regular expressions

First solution is lacking a lot and the second is spread around blog posts or
forum messages with relatively inconsistent definition support.

This project defines a better set of regular expressions to match more
Clojure symbols: Have a look at [ctags_clj.opt](etc/ctags_clj.opt)

You can check the output in the [tags/](tags/) directory to see by yourself
what symbols have been found for each solutions.

#### Install

```bash
cat ctags_clj.opt >> $HOME/.ctags
```

### Universal Ctags

https://ctags.io/

Universal Ctags is a fork or Exuberant Ctags and add a native support for
Clojure, but as you can read in
[tags/uctags_0.0.0(4f9f6f8).tags](tags/uctags_0.0.0(4f9f6f8).tags) the
support is still incomplete compared to a custom regexp configuration.

#### Install

```bash
mkdir -p $HOME/.ctags.d
cp ctags_clj.opt $HOME/.ctags.d/clojure.ctags
```

### GNU GLOBAL

https://www.gnu.org/software/global/global.html

GNU Global has more features than Ctags but only supports a handful of
languages with its built-in parsers. Hopefully we can tweak it to make use of
Pygments + Ctags as documented in the source:
[PLUGIN_HOWTO.pygments](http://cvs.savannah.gnu.org/viewvc/global/global/plugin-factory/PLUGIN_HOWTO.pygments?revision=1.6&view=markup)

#### Install

First extends Ctags with our regex Clojure language configuration (see above).
Than follow religiously all the installation and configuration steps
(don't forget the env variables), you should be able to have `global` parsing
Clojure files using Pygments and Ctags.

**NB:** With `global`, finding usage of a symbol **ONLY** works if the symbol
is used without namespace/alias or quote reader macro (#')

- Pygments Clojure parser
[does not separate namespace/alias from symbol name](https://bitbucket.org/birkenfeld/pygments-main/src/7941677dc77d4f2bf0bbd6140ade85a9454b8b80/pygments/lexers/jvm.py?at=default&fileviewer=file-view-default#jvm.py-802)
- Pygments Clojure parser does not find symbols if they are used after
a quote reader macro (#')

## Editors/IDEs

### Vim

- You can use [jsfaint/gen_tags.vim](https://github.com/jsfaint/gen_tags.vim) plugin
- The default "Jump to definition" Vim mapping (CTRL-\]) may not work because
[guns/vim-clojure-static](https://github.com/guns/vim-clojure-static/blob/fae5710a0b79555fe3296145be4f85148266771a/ftplugin/clojure.vim#L20)
defines the character / in `iskeyword`.
To have this mapping always working you can for Clojure filetype:
`:set iskeyword-=/`
