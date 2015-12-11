// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.concurrent.locks.Lock;

final class aww extends Handler
{

    private awq a;

    aww(awq awq1, Looper looper)
    {
        a = awq1;
        super(looper);
    }

    public final void handleMessage(Message message)
    {
        if (message.what != 1)
        {
            break MISSING_BLOCK_LABEL_115;
        }
        a.b.lock();
        boolean flag;
        if (a.c() || a.d())
        {
            break MISSING_BLOCK_LABEL_52;
        }
        flag = a.e();
        if (flag)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        a.b.unlock();
        return;
        message = a;
        message.f = ((awq) (message)).f - 1;
        a.a();
        a.b.unlock();
        return;
        message;
        a.b.unlock();
        throw message;
        Log.wtf("GoogleApiClientImpl", "Don't know how to handle this message.");
        return;
    }
}
