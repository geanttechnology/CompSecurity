// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class arg extends Handler
{

    private arc a;

    public arg(arc arc1, Looper looper)
    {
        a = arc1;
        super(looper);
    }

    public final void handleMessage(Message message)
    {
        if (a.g == 0 || a.i != 3 && a.i != 4)
        {
            return;
        }
        switch (message.what)
        {
        default:
            return;

        case 1: // '\001'
            a.i = 3;
            a.e();
            return;

        case 2: // '\002'
            a.f();
            return;

        case 3: // '\003'
            a.i = 3;
            break;
        }
        a.f();
    }
}
