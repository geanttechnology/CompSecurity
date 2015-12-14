// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.camera;

import android.view.View;

// Referenced classes of package com.cyberlink.youcammakeup.camera:
//            e, CameraCtrl

class a
    implements Runnable
{

    final e a;

    public void run()
    {
        CameraCtrl.I(a.a).setSelected(false);
        CameraCtrl.a(a.a, true);
        CameraCtrl.a(false);
    }

    raCtrl(e e1)
    {
        a = e1;
        super();
    }
}
