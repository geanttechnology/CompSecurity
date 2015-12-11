// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.p;


// Referenced classes of package com.shazam.android.p:
//            m

public final class c
    implements m
{

    public c()
    {
    }

    private static boolean a(int i)
    {
        return android.os.Build.VERSION.SDK_INT >= i;
    }

    private static boolean b(int i)
    {
        return android.os.Build.VERSION.SDK_INT <= i;
    }

    public final boolean a()
    {
        return b(15);
    }

    public final boolean b()
    {
        return a(17);
    }

    public final boolean c()
    {
        return b(18);
    }

    public final boolean d()
    {
        return a(21);
    }

    public final boolean e()
    {
        return a(19);
    }
}
