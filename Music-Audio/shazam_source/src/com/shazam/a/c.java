// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.a;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class c
{
    public static final class a
    {

        public final Map a = com.shazam.i.e.a.a(0);

        public a()
        {
        }
    }


    public final Map a;

    private c(a a1)
    {
        a = a1.a;
    }

    public c(a a1, byte byte0)
    {
        this(a1);
    }

    public final String toString()
    {
        Object obj = a.entrySet();
        StringBuilder stringbuilder = new StringBuilder();
        java.util.Map.Entry entry;
        for (obj = ((Set) (obj)).iterator(); ((Iterator) (obj)).hasNext(); stringbuilder.append((String)entry.getKey()).append(":").append((String)entry.getValue()).append(", "))
        {
            entry = (java.util.Map.Entry)((Iterator) (obj)).next();
        }

        stringbuilder.setLength(stringbuilder.length() - 2);
        return (new StringBuilder("EndpointPopulatorEntries{entries= ")).append(stringbuilder.toString()).append(" }").toString();
    }
}
