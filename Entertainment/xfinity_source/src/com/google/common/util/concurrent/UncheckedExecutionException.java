// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.util.concurrent;


public class UncheckedExecutionException extends RuntimeException
{

    protected UncheckedExecutionException()
    {
    }

    public UncheckedExecutionException(Throwable throwable)
    {
        super(throwable);
    }
}
