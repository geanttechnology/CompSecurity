// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.camera;

import android.os.Message;
import android.widget.TextView;

// Referenced classes of package com.cyberlink.youcammakeup.camera:
//            CameraCtrl

class c
    implements android.os.Handler.Callback
{

    final CameraCtrl a;

    private c(CameraCtrl cameractrl)
    {
        a = cameractrl;
        super();
    }

    c(CameraCtrl cameractrl, CameraCtrl._cls1 _pcls1)
    {
        this(cameractrl);
    }

    public boolean handleMessage(Message message)
    {
        if (message.what == 0x12ce79b9)
        {
            CameraCtrl.P(a);
            return true;
        }
        if (message.what == 0x6f396c3d)
        {
            CameraCtrl.Q(a).setVisibility(0);
            CameraCtrl.Q(a).setText(message.obj.toString());
            return true;
        } else
        {
            return false;
        }
    }
}
