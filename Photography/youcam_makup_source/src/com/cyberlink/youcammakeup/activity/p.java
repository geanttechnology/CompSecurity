// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.os.Message;
import android.view.MotionEvent;
import com.cyberlink.youcammakeup.widgetpool.wigpreviewview.a;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            o

class p
    implements android.os.Handler.Callback
{

    final o a;

    private p(o o1)
    {
        a = o1;
        super();
    }

    p(o o1, OpeningTutorialActivity._cls1 _pcls1)
    {
        this(o1);
    }

    public boolean handleMessage(Message message)
    {
        if (message.what == 2)
        {
            message = (MotionEvent)message.obj;
            com.cyberlink.youcammakeup.activity.o.a(a).a(message);
            message.recycle();
            return true;
        } else
        {
            return false;
        }
    }
}
