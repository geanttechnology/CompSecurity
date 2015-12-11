// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.services.now.model;

import com.google.api.a.e.b;
import com.google.api.a.g.l;

public final class Timestamp extends b
{

    private Integer nanos;
    private Long seconds;

    public Timestamp()
    {
    }

    public final volatile b clone()
    {
        return clone();
    }

    public final volatile l clone()
    {
        return clone();
    }

    public final Timestamp clone()
    {
        return (Timestamp)super.clone();
    }

    public final volatile Object clone()
    {
        return clone();
    }

    public final Integer getNanos()
    {
        return nanos;
    }

    public final Long getSeconds()
    {
        return seconds;
    }

    public final volatile b set(String s, Object obj)
    {
        return set(s, obj);
    }

    public final volatile l set(String s, Object obj)
    {
        return set(s, obj);
    }

    public final Timestamp set(String s, Object obj)
    {
        return (Timestamp)super.set(s, obj);
    }

    public final Timestamp setNanos(Integer integer)
    {
        nanos = integer;
        return this;
    }

    public final Timestamp setSeconds(Long long1)
    {
        seconds = long1;
        return this;
    }
}
