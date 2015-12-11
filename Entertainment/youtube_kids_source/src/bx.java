// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class bx extends Handler
{

    private bw a;

    bx(bw bw1, Looper looper)
    {
        a = bw1;
        super(looper);
    }

    public final void handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            super.handleMessage(message);
            return;

        case 1: // '\001'
            bw.a(a);
            break;
        }
    }
}
