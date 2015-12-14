// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.camera;

import com.cyberlink.youcammakeup.utility.IntroDialogUtils;

// Referenced classes of package com.cyberlink.youcammakeup.camera:
//            g, CameraCtrl, CameraSettingDialog

class a
    implements g
{

    final CameraCtrl a;

    public void a()
    {
        if (CameraCtrl.v(a).b() == ialog.Setting.c)
        {
            IntroDialogUtils.a(CameraCtrl.x(a), null, null, com.cyberlink.youcammakeup.utility.ls.IntroDialogType.E, true);
        }
    }

    ils(CameraCtrl cameractrl)
    {
        a = cameractrl;
        super();
    }
}
