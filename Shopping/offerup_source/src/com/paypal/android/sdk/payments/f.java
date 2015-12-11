// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk.payments;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

// Referenced classes of package com.paypal.android.sdk.payments:
//            e

final class f extends Handler
{

    private e a;

    f(e e1, Looper looper)
    {
        a = e1;
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
            e.a(a);
            break;
        }
    }
}
