// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.cache;

import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

public abstract class CacheLoader
{
    public static final class InvalidCacheLoadException extends RuntimeException
    {

        public InvalidCacheLoadException(String s)
        {
            super(s);
        }
    }


    protected CacheLoader()
    {
    }

    public abstract Object load(Object obj)
        throws Exception;

    public ListenableFuture reload(Object obj, Object obj1)
        throws Exception
    {
        return Futures.immediateFuture(load(obj));
    }
}
