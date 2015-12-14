// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.request;


public interface Request
{

    public abstract void begin();

    public abstract void clear();

    public abstract boolean isCancelled();

    public abstract boolean isComplete();

    public abstract boolean isResourceSet();

    public abstract boolean isRunning();

    public abstract void pause();

    public abstract void recycle();
}
