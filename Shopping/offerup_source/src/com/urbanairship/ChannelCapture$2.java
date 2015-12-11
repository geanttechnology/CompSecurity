// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship;

import android.content.IntentFilter;
import android.support.v4.b.h;

// Referenced classes of package com.urbanairship:
//            ChannelCapture

class this._cls0
    implements Runnable
{

    final ChannelCapture this$0;

    public void run()
    {
        ChannelCapture channelcapture = ChannelCapture.this;
        Object obj;
        if (android.os._INT >= 11)
        {
            obj = new ipboardHoneyComb(ChannelCapture.this);
        } else
        {
            obj = new ipboardFroyo(ChannelCapture.this);
        }
        ChannelCapture.access$102(channelcapture, ((ipboard) (obj)));
        obj = new IntentFilter();
        ((IntentFilter) (obj)).addAction("com.urbanairship.analytics.APP_FOREGROUND");
        h.a(ChannelCapture.access$200(ChannelCapture.this)).a(ChannelCapture.access$300(ChannelCapture.this), ((IntentFilter) (obj)));
    }

    ipboardFroyo()
    {
        this$0 = ChannelCapture.this;
        super();
    }
}
