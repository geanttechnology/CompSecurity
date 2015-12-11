// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.d;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.target.mothership.model.d;

// Referenced classes of package com.target.ui.d:
//            a, b

static class mReceiver extends Handler
{

    private static final String KEY_NOTIFICATION_COUNT_CACHE = "cache";
    private static final String KEY_NOTIFICATION_COUNT_VALUE = "value";
    private d mReceiver;

    public void handleMessage(Message message)
    {
        message = (Bundle)message.obj;
        int i = message.getInt("value");
        boolean flag = message.getBoolean("cache");
        mReceiver.a(new b(Integer.valueOf(i).intValue(), Boolean.valueOf(flag).booleanValue()));
    }

    public p.model.d(d d1)
    {
        mReceiver = d1;
    }
}
