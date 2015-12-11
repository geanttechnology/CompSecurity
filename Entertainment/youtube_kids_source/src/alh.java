// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.os.Message;

final class alh extends Handler
{

    private alg a;

    alh(alg alg1)
    {
        a = alg1;
        super();
    }

    public final void handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            return;

        case 1: // '\001'
            a.b(message.arg1);
            return;

        case 0: // '\0'
            a.c();
            return;
        }
    }
}
