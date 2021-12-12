package com.acyclic.jndijilt;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

public class Agent {

    static private boolean refused = false;
    static boolean didRefuse() {
        return refused;
    }

    public static void premain(String args, Instrumentation instrumentation){
        ClassFileTransformer transformer = new ClassFileTransformer() {
            @Override
            public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
                // Could use fqcn, but it'd be more likely that I make a typo.
                if (className.contains("JndiLookup")) {
                    Throwable t = new NoClassDefFoundError(
                            "Refusing to load " + className +
                                    "; see https://nvd.nist.gov/vuln/detail/CVE-2021-44228");
                    // Presumably there's some logging complexity, so try to cover bases.
                    t.printStackTrace(System.out);
                    t.printStackTrace(System.err);
                    refused = true;
                    if(!className.contains("com/acyclic/jndijilt"))
                        Runtime.getRuntime().exit(-1);
                }
                return classfileBuffer;
            }
        };
        instrumentation.addTransformer(transformer);

    }
}
