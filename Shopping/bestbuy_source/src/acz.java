// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

final class acz extends Handler
{

    final acy a;

    public acz(acy acy1, Looper looper)
    {
        a = acy1;
        super(looper);
    }

    public void handleMessage(Message message)
    {
        if (message.what == 1 && !a.g())
        {
            message = (ada)message.obj;
            message.a();
            message.c();
            return;
        }
        if (message.what == 3)
        {
            acy.a(a).a(new pp(((Integer)message.obj).intValue(), null));
            return;
        }
        if (message.what == 4)
        {
            acy.a(a, 4, null);
            acy.a(a).a(((Integer)message.obj).intValue());
            acy.a(a, 4, 1, null);
            return;
        }
        if (message.what == 2 && !a.c())
        {
            message = (ada)message.obj;
            message.a();
            message.c();
            return;
        }
        if (message.what == 2 || message.what == 1)
        {
            ((ada)message.obj).b();
            return;
        } else
        {
            Log.wtf("GmsClient", "Don't know how to handle this message.");
            return;
        }
    }
}
