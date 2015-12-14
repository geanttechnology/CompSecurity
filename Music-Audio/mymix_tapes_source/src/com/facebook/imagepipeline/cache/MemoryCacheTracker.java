// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.cache;


public interface MemoryCacheTracker
{

    public abstract void onCacheHit();

    public abstract void onCacheMiss();

    public abstract void onCachePut();
}
