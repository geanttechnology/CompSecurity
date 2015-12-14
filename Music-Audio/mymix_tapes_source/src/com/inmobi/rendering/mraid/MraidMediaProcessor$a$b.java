// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.rendering.mraid;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

// Referenced classes of package com.inmobi.rendering.mraid:
//            MraidMediaProcessor

static final class a extends Handler
{

    private WeakReference a;

    public void handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            super.handleMessage(message);
            return;

        case 1: // '\001'
            message = (a)a.get();
            break;
        }
        if (message != null)
        {
            a(message);
        }
        message = Message.obtain();
        message.what = 1;
        sendMessageDelayed(message, 1000L);
    }

    public (Looper looper,  )
    {
        super(looper);
        a = new WeakReference();
    }
}
