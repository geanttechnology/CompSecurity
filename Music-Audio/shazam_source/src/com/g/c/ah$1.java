// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

// Referenced classes of package com.g.c:
//            ah

static final class oper extends Handler
{

    public final void handleMessage(Message message)
    {
        sendMessageDelayed(obtainMessage(), 1000L);
    }

    oper(Looper looper)
    {
        super(looper);
    }
}
