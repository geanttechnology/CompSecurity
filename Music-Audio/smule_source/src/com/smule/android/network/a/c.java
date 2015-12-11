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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class c
{

    public static o a()
    {
        return a(Boolean.valueOf(false));
    }

    public static o a(Boolean boolean1)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("previous", boolean1);
        boolean1 = new k(m.a, "/v2/contest/get", l.b, n.c, hashmap, true);
        return com.smule.android.network.core.b.a().a(boolean1);
    }

    public static o a(Long long1, String s, Integer integer)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("contestId", long1);
        hashmap.put("songId", s);
        hashmap.put("score", integer);
        long1 = new k(m.a, "/v2/contest/score", l.b, n.c, hashmap, true);
        return com.smule.android.network.core.b.a().a(long1);
    }

    public static o a(ArrayList arraylist, Boolean boolean1)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("contestScores", arraylist);
        hashmap.put("previous", boolean1);
        arraylist = new k(m.a, "/v2/contest/get", l.b, n.c, hashmap, true);
        return com.smule.android.network.core.b.a().a(arraylist);
    }

    public static o b()
    {
        return a(Boolean.valueOf(true));
    }
}
