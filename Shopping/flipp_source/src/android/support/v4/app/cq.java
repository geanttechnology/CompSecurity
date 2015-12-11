// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.os.Bundle;

// Referenced classes of package android.support.v4.app:
//            cy, ct, cr, cv, 
//            cu, cz, cs

public final class cq extends cy
{

    public static final cz a = new cr();
    private static final cs g;
    private final String b;
    private final CharSequence c;
    private final CharSequence d[];
    private final boolean e;
    private final Bundle f;

    public final String a()
    {
        return b;
    }

    public final CharSequence b()
    {
        return c;
    }

    public final CharSequence[] c()
    {
        return d;
    }

    public final boolean d()
    {
        return e;
    }

    public final Bundle e()
    {
        return f;
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 20)
        {
            g = new ct();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            g = new cv();
        } else
        {
            g = new cu();
        }
    }
}
