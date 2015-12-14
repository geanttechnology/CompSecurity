// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sina.weibo.sdk.exception.WeiboException;
import java.lang.ref.WeakReference;

class k extends Handler
{

    private WeakReference callBackReference;

    public void handleMessage(Message message)
    {
        k k = (k)callBackReference.get();
        message.what;
        JVM INSTR tableswitch 1001 1002: default 36
    //                   1001 37
    //                   1002 58;
           goto _L1 _L2 _L3
_L1:
        return;
_L2:
        if (k != null)
        {
            k.onAidGenSuccessed(((k.onAidGenSuccessed)message.obj).Info());
            return;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (k != null)
        {
            k.onAidGenFailed((WeiboException)message.obj);
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void setCallback(k k)
    {
        if (callBackReference != null)
        {
            if ((k)callBackReference.get() == k)
            {
                return;
            } else
            {
                callBackReference = new WeakReference(k);
                return;
            }
        } else
        {
            callBackReference = new WeakReference(k);
            return;
        }
    }

    public k(Looper looper)
    {
        super(looper);
    }
}
