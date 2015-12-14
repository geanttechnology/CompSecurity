// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.camera;

import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.widgetpool.dialogs.w;

// Referenced classes of package com.cyberlink.youcammakeup.camera:
//            CameraCtrl, d

class a
    implements w
{

    final o a;
    final CameraCtrl b;

    public void a(boolean flag)
    {
        a.i(CameraCtrl.u(b));
        CameraCtrl.a(false);
        CameraCtrl.a(b, false);
        CameraCtrl.b(b, true);
        CameraCtrl.d(b).c();
    }

    public void b(boolean flag)
    {
    }

    (CameraCtrl cameractrl, o o1)
    {
        b = cameractrl;
        a = o1;
        super();
    }
}
