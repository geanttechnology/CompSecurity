// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.zeroes.intentservice.persistence;


public interface ZeroesCache
{

    public abstract String get(String s);

    public abstract boolean invalidate(String s);

    public abstract boolean put(String s, String s1, long l);
}
