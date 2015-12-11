// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;

public class <init>
{

    private zzaYM zzaYM;
    private final Map zzban;

    public <init> zzEb()
    {
        return new <init>(zzban, zzaYM, null);
    }

    public zzaYM zzb(String s, zzaYM zzaym)
    {
        zzban.put(s, zzaym);
        return this;
    }

    public zzban zzq(zzban zzban1)
    {
        zzaYM = zzban1;
        return this;
    }

    private ()
    {
        zzban = new HashMap();
    }

    zzban(zzban zzban1)
    {
        this();
    }
}
