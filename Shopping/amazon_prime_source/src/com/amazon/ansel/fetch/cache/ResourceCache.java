// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.ansel.fetch.cache;


public interface ResourceCache
{

    public abstract void clear();

    public abstract Object get(Object obj);

    public abstract Object put(Object obj, Object obj1);

    public abstract Object remove(Object obj);

    public abstract int size();
}
