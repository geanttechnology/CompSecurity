// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.helpshift.i.g;
import java.util.HashMap;

// Referenced classes of package com.helpshift:
//            HSMessagesFragment

class a extends Handler
{

    final HSMessagesFragment a;

    public void handleMessage(Message message)
    {
        super.handleMessage(message);
        message = (Integer)((HashMap)message.obj).get("status");
        if (message.intValue() != -1 && HSMessagesFragment.f(a) != null)
        {
            HSMessagesFragment.f(a).getLooper().quit();
        }
        g.a(message.intValue(), null, com.helpshift.HSMessagesFragment.g(a));
    }

    (HSMessagesFragment hsmessagesfragment)
    {
        a = hsmessagesfragment;
        super();
    }
}
