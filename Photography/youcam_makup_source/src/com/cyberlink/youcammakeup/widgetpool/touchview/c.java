// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.touchview;

import android.os.Handler;
import java.util.TimerTask;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.touchview:
//            TouchImageView

class c extends TimerTask
{

    final TouchImageView a;

    private c(TouchImageView touchimageview)
    {
        a = touchimageview;
        super();
    }

    c(TouchImageView touchimageview, TouchImageView._cls1 _pcls1)
    {
        this(touchimageview);
    }

    public void run()
    {
        TouchImageView.h(a).sendEmptyMessage(0);
    }
}
