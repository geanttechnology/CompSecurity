// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.engine.executor;


final class nit> extends nit>
{

    protected final void handle(Throwable throwable)
    {
        super.ndle(throwable);
        if (throwable != null)
        {
            throw new RuntimeException("Request threw uncaught throwable", throwable);
        } else
        {
            return;
        }
    }

    (String s, int i)
    {
        super(s, i, null);
    }
}
