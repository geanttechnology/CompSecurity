// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.accessibility;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;

// Referenced classes of package com.comcast.cim.android.accessibility:
//            DefaultTalkDelegate

class this._cls0 extends Handler
{

    final DefaultTalkDelegate this$0;

    public void handleMessage(Message message)
    {
        if (message.what == com.comcast.cim.android.OUNCE_LOADED)
        {
            speak(context.getString(com.comcast.cim.android._x, new Object[] {
                DefaultTalkDelegate.access$000(DefaultTalkDelegate.this)
            }));
        } else
        {
            speak(message.what);
            handler.sendEmptyMessageDelayed(message.what, 5000L);
        }
        super.handleMessage(message);
    }

    A()
    {
        this$0 = DefaultTalkDelegate.this;
        super();
    }
}
