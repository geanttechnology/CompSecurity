// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.i.b.w.c;

import com.shazam.android.fragment.home.b;
import com.shazam.android.fragment.home.c;
import java.util.Map;

public final class a
{

    public static final Map a;

    public static c a()
    {
        return new com.shazam.android.fragment.home.a(a, com.shazam.i.b.aj.a.a());
    }

    static 
    {
        Map map = com.shazam.i.e.a.a(3);
        a = map;
        map.put(b.a, new com.shazam.android.fragment.home.b());
        a.put(b.b, new com.shazam.android.fragment.home.b());
        a.put(b.c, new com.shazam.android.fragment.home.a());
    }
}
