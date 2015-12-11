// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

// Referenced classes of package com.helpshift:
//            HSMessagesFragment

class a extends Handler
{

    final HSMessagesFragment a;

    public void handleMessage(Message message)
    {
        super.handleMessage(message);
        if (HSMessagesFragment.f(a) != null)
        {
            HSMessagesFragment.f(a).getLooper().quit();
        }
        HSMessagesFragment.a(a);
    }

    (HSMessagesFragment hsmessagesfragment)
    {
        a = hsmessagesfragment;
        super();
    }
}
