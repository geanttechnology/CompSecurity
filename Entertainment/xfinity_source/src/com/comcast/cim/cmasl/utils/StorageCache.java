// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.utils;

import java.io.InputStream;

public interface StorageCache
{

    public abstract void remove(String s);

    public abstract void removeAll();

    public abstract InputStream retrieve(String s);

    public abstract void store(InputStream inputstream, String s);
}
