// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.view.accessibility.AccessibilityEvent;

class bd
{

    public static int a(AccessibilityEvent accessibilityevent)
    {
        return accessibilityevent.getContentChangeTypes();
    }

    public static void a(AccessibilityEvent accessibilityevent, int i)
    {
        accessibilityevent.setContentChangeTypes(i);
    }
}
