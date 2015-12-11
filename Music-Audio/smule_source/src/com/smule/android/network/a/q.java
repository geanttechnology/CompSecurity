// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.a;

import com.smule.android.network.core.b;
import com.smule.android.network.core.k;
import com.smule.android.network.core.l;
import com.smule.android.network.core.m;
import com.smule.android.network.core.n;
import com.smule.android.network.core.o;
import java.util.HashMap;
import java.util.Map;

public class q
{

    private static final String a = com/smule/android/network/a/q.getName();

    private q()
    {
    }

    public static o a()
    {
        k k1 = d("/v2/rec/songs");
        return com.smule.android.network.core.b.a().a(k1);
    }

    public static o a(String s)
    {
        k k1 = d("/v2/rec/select");
        k1.d = new HashMap();
        k1.d.put("selection", s);
        k1.h = 2;
        return com.smule.android.network.core.b.a().a(k1);
    }

    public static o b(String s)
    {
        k k1 = d("/v2/rec/song/similar");
        k1.d = new HashMap();
        k1.d.put("songId", s);
        return com.smule.android.network.core.b.a().a(k1);
    }

    public static o c(String s)
    {
        k k1 = d("/v2/rec/accounts");
        k1.d = new HashMap();
        k1.d.put("type", s);
        return com.smule.android.network.core.b.a().a(k1);
    }

    private static k d(String s)
    {
        return new k(m.a, s, l.b, n.c, null, true);
    }

}
