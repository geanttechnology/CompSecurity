// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.engine.executor;

import android.util.Log;

public class <init> extends Enum
{

    private static final THROW $VALUES[];
    public static final THROW IGNORE;
    public static final THROW LOG;
    public static final THROW THROW;

    public static <init> valueOf(String s)
    {
        return (<init>)Enum.valueOf(com/bumptech/glide/load/engine/executor/GlideExecutor$UncaughtThrowableStrategy, s);
    }

    public static <init>[] values()
    {
        return (<init>[])$VALUES.clone();
    }

    protected void handle(Throwable throwable)
    {
    }

    static 
    {
        IGNORE = new <init>("IGNORE", 0);
        LOG = new GlideExecutor.UncaughtThrowableStrategy("LOG", 1) {

            protected final void handle(Throwable throwable)
            {
                if (throwable != null && Log.isLoggable("GlideExecutor", 6))
                {
                    Log.e("GlideExecutor", "Request threw uncaught throwable", throwable);
                }
            }

        };
        THROW = new GlideExecutor.UncaughtThrowableStrategy("THROW", 2) {

            protected final void handle(Throwable throwable)
            {
                handle(throwable);
                if (throwable != null)
                {
                    throw new RuntimeException("Request threw uncaught throwable", throwable);
                } else
                {
                    return;
                }
            }

        };
        $VALUES = (new .VALUES[] {
            IGNORE, LOG, THROW
        });
    }

    private _cls2(String s, int i)
    {
        super(s, i);
    }

    _cls2(String s, int i, _cls2 _pcls2)
    {
        this(s, i);
    }
}
