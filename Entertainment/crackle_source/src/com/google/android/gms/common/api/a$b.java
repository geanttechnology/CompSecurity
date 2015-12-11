// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;

// Referenced classes of package com.google.android.gms.common.api:
//            a, ResultCallback, Result

static abstract class <init> extends Handler
{

    protected abstract void a(ResultCallback resultcallback, Result result);

    public void b(ResultCallback resultcallback, Result result)
    {
        sendMessage(obtainMessage(1, new Pair(resultcallback, result)));
    }

    public void handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            Log.wtf("GoogleApi", "Don't know how to handle this message.");
            return;

        case 1: // '\001'
            message = (Pair)message.obj;
            break;
        }
        a((ResultCallback)((Pair) (message)).first, (Result)((Pair) (message)).second);
    }

    public lt()
    {
        this(Looper.getMainLooper());
    }

    public <init>(Looper looper)
    {
        super(looper);
    }
}
