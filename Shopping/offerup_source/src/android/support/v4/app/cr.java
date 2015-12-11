// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.os.Bundle;

// Referenced classes of package android.support.v4.app:
//            cw, ct, cx, cv, 
//            cu

public final class cr extends cw
{

    private final String a;
    private final CharSequence b;
    private final CharSequence c[];
    private final boolean d;
    private final Bundle e;

    cr(String s, CharSequence charsequence, CharSequence acharsequence[], boolean flag, Bundle bundle)
    {
        a = s;
        b = charsequence;
        c = acharsequence;
        d = flag;
        e = bundle;
    }

    public final String a()
    {
        return a;
    }

    public final CharSequence b()
    {
        return b;
    }

    public final CharSequence[] c()
    {
        return c;
    }

    public final boolean d()
    {
        return d;
    }

    public final Bundle e()
    {
        return e;
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 20)
        {
            new ct();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            new cv();
        } else
        {
            new cu();
        }
        new cx();
    }
}
