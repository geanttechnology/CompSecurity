// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.widget.Scroller;

public final class yx
{

    public static void a(Scroller scroller, float f)
    {
        if (scroller != null)
        {
            scroller.setFriction(f);
        }
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT < 11)
        {
            throw new RuntimeException("Should not get to HoneycombPlus class unless sdk is >= 11!");
        }
    }
}
