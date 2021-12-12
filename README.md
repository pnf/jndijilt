# jndijilt

**PLEASE NOTE: This code is offered as-is, as a demonstration, with absolutely
no warranty.  It may not work at all.  It may make your program crash and/or, perversely,
expose you to even greater security risks.  Use this only if you completely understand it and take
full responsibility for any and all consequences that may result.  That said, you may use or not use
the contents of this repository any way you like, consistent with the terms of the
[unlicense](<http://unlicense.org/>), included at the end of this file.** 

Per

https://nvd.nist.gov/vuln/detail/CVE-2021-44228

one mitigation for the Log4Shell exploit is to remove `JndiLookup.class` from log4j jars.
Equivalently, we can refuse to load `JndiLookup` via an agent, as illustrated in this repository.

With 
```
   -javaagent:/path/to/jndijilt-1.0.jar'
```
added to JVM args, any attempt to access `JndiLookup` (irrespective of FCQN, to reduce the likelihood that I mistyped something)
will abort the program with an explanatory stacktrace.

----------

This is free and unencumbered software released into the public domain.

Anyone is free to copy, modify, publish, use, compile, sell, or
distribute this software, either in source code form or as a compiled
binary, for any purpose, commercial or non-commercial, and by any
means.

In jurisdictions that recognize copyright laws, the author or authors
of this software dedicate any and all copyright interest in the
software to the public domain. We make this dedication for the benefit
of the public at large and to the detriment of our heirs and
successors. We intend this dedication to be an overt act of
relinquishment in perpetuity of all present and future rights to this
software under copyright law.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR
OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
OTHER DEALINGS IN THE SOFTWARE.

For more information, please refer to <http://unlicense.org/>