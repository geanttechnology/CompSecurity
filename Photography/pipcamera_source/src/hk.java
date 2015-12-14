// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;
import java.util.HashMap;

class hk extends Handler
{

    final hj a;
    private WeakReference b;

    public hk(hj hj1, hj hj2)
    {
        a = hj1;
        super();
        b = new WeakReference(hj2);
    }

    public void handleMessage(Message message)
    {
        hj hj1 = (hj)b.get();
        if (message != null && message.obj != null)
        {
            message = (HashMap)message.obj;
            hj.b(hj1).a((Bitmap)message.get("bitmap"), ((Integer)message.get("position")).intValue());
        }
    }
}
