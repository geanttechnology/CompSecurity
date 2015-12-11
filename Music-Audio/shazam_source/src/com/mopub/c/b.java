// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.c;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

public final class b
    implements Serializable
{
    public static final class a
    {

        String a;
        String b;
        String c;
        String d;
        String e;
        String f;
        String g;
        String h;
        String i;
        Integer j;
        Integer k;
        Integer l;
        Integer m;
        String n;
        boolean o;
        String p;
        JSONObject q;
        String r;
        Map s;

        public final a a(Map map)
        {
            if (map == null)
            {
                s = new TreeMap();
                return this;
            } else
            {
                s = new TreeMap(map);
                return this;
            }
        }

        public final b a()
        {
            return new b(this, (byte)0);
        }

        public a()
        {
            o = false;
            s = new TreeMap();
        }
    }


    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    final String f;
    public final Integer g;
    public final Integer h;
    public final Integer i;
    public final Integer j;
    public final String k;
    public final String l;
    public final String m;
    public final Map n;
    public final long o;
    private final String p;
    private final String q;
    private final String r;
    private final boolean s;
    private final JSONObject t;

    private b(a a1)
    {
        a = a1.a;
        p = a1.b;
        q = a1.c;
        b = a1.d;
        r = a1.e;
        c = a1.f;
        d = a1.g;
        e = a1.h;
        f = a1.i;
        g = a1.j;
        h = a1.k;
        i = a1.l;
        j = a1.m;
        k = a1.n;
        s = a1.o;
        l = a1.p;
        t = a1.q;
        m = a1.r;
        n = a1.s;
        o = com.mopub.common.d.b.a().getTime();
    }

    b(a a1, byte byte0)
    {
        this(a1);
    }
}
