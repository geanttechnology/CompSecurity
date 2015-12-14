// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.model;

import com.bumptech.glide.load.data.DataFetcher;

public interface ModelLoader
{

    public abstract DataFetcher getResourceFetcher(Object obj, int i, int j);
}
