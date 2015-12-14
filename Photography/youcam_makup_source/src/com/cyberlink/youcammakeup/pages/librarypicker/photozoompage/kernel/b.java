// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel;

import android.os.Handler;
import android.os.Message;

// Referenced classes of package com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel:
//            a, AsyncTask

class b extends Handler
{

    private b()
    {
    }

    b(AsyncTask._cls1 _pcls1)
    {
        this();
    }

    public void handleMessage(Message message)
    {
        a a1 = (a)message.obj;
        switch (message.what)
        {
        default:
            return;

        case 1: // '\001'
            AsyncTask.c(a1.a, a1.b[0]);
            return;

        case 2: // '\002'
            a1.a.b(a1.b);
            break;
        }
    }
}
