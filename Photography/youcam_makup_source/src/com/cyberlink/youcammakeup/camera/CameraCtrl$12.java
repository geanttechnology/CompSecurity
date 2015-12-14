// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.camera;

import com.cyberlink.youcammakeup.widgetpool.ICameraPanel;

// Referenced classes of package com.cyberlink.youcammakeup.camera:
//            af, CameraCtrl

class a
    implements af
{

    final CameraCtrl a;

    public void a(com.cyberlink.youcammakeup.widgetpool.lingDirection lingdirection)
    {
        if (CameraCtrl.g(a) instanceof ICameraPanel)
        {
            ((ICameraPanel)CameraCtrl.g(a)).a(lingdirection);
        }
    }

    el.FlingDirection(CameraCtrl cameractrl)
    {
        a = cameractrl;
        super();
    }
}
