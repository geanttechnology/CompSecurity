// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;
import java.util.HashMap;

class aki extends Handler
{

    final akf a;
    private WeakReference b;

    public aki(akf akf1, akf akf2)
    {
        a = akf1;
        super();
        b = new WeakReference(akf2);
    }

    public void handleMessage(Message message)
    {
        akf akf1 = (akf)b.get();
        if (message != null && message.obj != null)
        {
            message = (HashMap)message.obj;
            akf.b(akf1).a((Bitmap)message.get("bitmap"), ((Integer)message.get("position")).intValue());
        }
    }
}
