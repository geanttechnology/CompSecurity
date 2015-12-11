// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityManager;

// Referenced classes of package android.support.v4.view.accessibility:
//            AccessibilityManagerCompatIcs

public class AccessibilityManagerCompat
{
    static class AccessibilityManagerIcsImpl extends AccessibilityManagerStubImpl
    {

        public boolean isTouchExplorationEnabled(AccessibilityManager accessibilitymanager)
        {
            return AccessibilityManagerCompatIcs.isTouchExplorationEnabled(accessibilitymanager);
        }

        AccessibilityManagerIcsImpl()
        {
        }
    }

    static class AccessibilityManagerStubImpl
        implements AccessibilityManagerVersionImpl
    {

        public boolean isTouchExplorationEnabled(AccessibilityManager accessibilitymanager)
        {
            return false;
        }

        AccessibilityManagerStubImpl()
        {
        }
    }

    static interface AccessibilityManagerVersionImpl
    {

        public abstract boolean isTouchExplorationEnabled(AccessibilityManager accessibilitymanager);
    }


    private static final AccessibilityManagerVersionImpl IMPL;

    public AccessibilityManagerCompat()
    {
    }

    public static boolean isTouchExplorationEnabled(AccessibilityManager accessibilitymanager)
    {
        return IMPL.isTouchExplorationEnabled(accessibilitymanager);
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            IMPL = new AccessibilityManagerIcsImpl();
        } else
        {
            IMPL = new AccessibilityManagerStubImpl();
        }
    }
}
