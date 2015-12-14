// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.camera;

import android.hardware.Camera;
import com.cyberlink.youcammakeup.activity.CameraActivity;
import com.pf.common.utility.m;

// Referenced classes of package com.cyberlink.youcammakeup.camera:
//            CameraCtrl

class a
    implements android.hardware.usMoveCallback
{

    final CameraCtrl a;

    public void onAutoFocusMoving(boolean flag, Camera camera)
    {
        m.e("onAutoFocusMoving", String.valueOf(flag));
        if (flag)
        {
            CameraActivity.b(true);
            return;
        } else
        {
            CameraActivity.b(false);
            return;
        }
    }

    ty(CameraCtrl cameractrl)
    {
        a = cameractrl;
        super();
    }
}
