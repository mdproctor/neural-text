package io.casehub.neocortex.cognitive;

import org.junit.jupiter.api.Test;
import java.util.Set;
import static org.assertj.core.api.Assertions.assertThat;

class PrincipalVisibilityTest {

    @Test
    void nullCaller_alwaysVisible() {
        assertThat(PrincipalVisibility.isVisible(null, "agent:alice", Set.of())).isTrue();
    }

    @Test
    void nullOwner_alwaysVisible() {
        assertThat(PrincipalVisibility.isVisible("agent:bob", null, Set.of())).isTrue();
    }

    @Test
    void ownerMatchesCaller_visible() {
        assertThat(PrincipalVisibility.isVisible("agent:alice", "agent:alice", Set.of())).isTrue();
    }

    @Test
    void callerInSharedWith_visible() {
        assertThat(PrincipalVisibility.isVisible("agent:bob", "agent:alice", Set.of("agent:bob"))).isTrue();
    }

    @Test
    void callerNotOwnerNotShared_notVisible() {
        assertThat(PrincipalVisibility.isVisible("agent:bob", "agent:alice", Set.of())).isFalse();
    }

    @Test
    void nullSharedWith_notVisible() {
        assertThat(PrincipalVisibility.isVisible("agent:bob", "agent:alice", null)).isFalse();
    }

    @Test
    void bothNull_visible() {
        assertThat(PrincipalVisibility.isVisible(null, null, null)).isTrue();
    }
}
