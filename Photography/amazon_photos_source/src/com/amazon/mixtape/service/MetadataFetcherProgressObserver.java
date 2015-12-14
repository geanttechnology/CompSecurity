// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.service;


interface MetadataFetcherProgressObserver
{

    public abstract void notifyComplete();

    public abstract void setCurrentCount(long l);

    public abstract void setTotalCount(long l);

    public abstract void updateCurrentCount(long l);
}
