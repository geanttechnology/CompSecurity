// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.j.g;

import android.content.SharedPreferences;

// Referenced classes of package com.shazam.android.j.g:
//            d, h

public final class k
    implements d
{

    private final d b;
    private final SharedPreferences c;
    private final String d;

    public k(h h, SharedPreferences sharedpreferences, String s)
    {
        b = h;
        c = sharedpreferences;
        d = s;
    }

    public final String a()
    {
        return b.a();
    }

    public final String b()
    {
        return b.b();
    }

    public final String c()
    {
        return b.c();
    }
}
