// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.concurrent;

import android.os.Handler;
import java.util.concurrent.Executor;
import org.apache.commons.lang3.Validate;

public class UIThreadExecutor
    implements Executor
{

    private final Handler handler;

    public UIThreadExecutor(Handler handler1)
    {
        Validate.notNull(handler1);
        handler = handler1;
    }

    public void execute(Runnable runnable)
    {
        handler.post(runnable);
    }
}
