// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.data;

import com.bumptech.glide.Priority;

public interface DataFetcher
{

    public abstract void cancel();

    public abstract void cleanup();

    public abstract String getId();

    public abstract Object loadData(Priority priority)
        throws Exception;
}
