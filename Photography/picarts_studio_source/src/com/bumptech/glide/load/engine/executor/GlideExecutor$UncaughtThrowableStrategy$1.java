// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.engine.executor;

import android.util.Log;

final class nit> extends nit>
{

    protected final void handle(Throwable throwable)
    {
        if (throwable != null && Log.isLoggable("GlideExecutor", 6))
        {
            Log.e("GlideExecutor", "Request threw uncaught throwable", throwable);
        }
    }

    (String s, int i)
    {
        super(s, i, null);
    }
}
