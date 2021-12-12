package com.acyclic.jndijilt;
import org.junit.jupiter.api.Test;

public class AgentTest {

    @Test
    void tryToLoad() {
        assert(!Agent.didRefuse());
        new JndiLookup();
        assert(Agent.didRefuse());
    }

}
