// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.camera;

import android.view.View;
import android.widget.TextView;

// Referenced classes of package com.cyberlink.youcammakeup.camera:
//            CameraCtrl

class a
    implements Runnable
{

    final CameraCtrl a;

    public void run()
    {
        CameraCtrl.h(a).setVisibility(4);
        CameraCtrl.i(a).setText("");
    }

    (CameraCtrl cameractrl)
    {
        a = cameractrl;
        super();
    }
}
