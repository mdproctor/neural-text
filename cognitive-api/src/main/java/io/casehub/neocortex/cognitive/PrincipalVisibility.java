package io.casehub.neocortex.cognitive;

import java.util.Set;

public final class PrincipalVisibility {

    private PrincipalVisibility() {}

    public static boolean isVisible(String callerPrincipalId,
                                    String ownerPrincipalId,
                                    Set<String> sharedWith) {
        if (callerPrincipalId == null) return true;
        if (ownerPrincipalId == null) return true;
        if (ownerPrincipalId.equals(callerPrincipalId)) return true;
        return sharedWith != null && sharedWith.contains(callerPrincipalId);
    }
}
