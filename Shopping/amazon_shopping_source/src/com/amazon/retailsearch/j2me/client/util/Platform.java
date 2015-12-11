// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.j2me.client.util;


public interface Platform
{

    public abstract void invokeLater(Runnable runnable);

    public abstract void invokeLater(Runnable runnable, long l);
}
