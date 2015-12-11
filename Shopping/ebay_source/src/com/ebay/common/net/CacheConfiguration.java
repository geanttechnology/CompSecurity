// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net;


public interface CacheConfiguration
{

    public static final int MAX_ITEMS_IN_CACHE = 1000;

    public abstract boolean isPrefetchEnabled();

    public abstract void restartFetch(int i, int j, int k);
}
