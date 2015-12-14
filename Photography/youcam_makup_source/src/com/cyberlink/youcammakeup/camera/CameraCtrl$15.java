// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.camera;

import android.widget.Toast;

// Referenced classes of package com.cyberlink.youcammakeup.camera:
//            CameraCtrl

class a
    implements Runnable
{

    final CameraCtrl a;

    public void run()
    {
        Toast.makeText(CameraCtrl.u(a), 0x7f070381, 0).show();
        CameraCtrl.o(a);
    }

    (CameraCtrl cameractrl)
    {
        a = cameractrl;
        super();
    }
}
