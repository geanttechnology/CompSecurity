// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.accessibility.AccessibilityEvent;

public final class fc
{

    public static ff a(AccessibilityEvent accessibilityevent)
    {
        return new ff(accessibilityevent);
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            new fd();
        } else
        {
            new fe();
        }
    }
}
