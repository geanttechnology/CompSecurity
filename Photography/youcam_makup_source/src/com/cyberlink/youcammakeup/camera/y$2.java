// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.camera;

import android.hardware.Camera;
import com.cyberlink.youcammakeup.activity.CameraActivity;
import com.pf.common.utility.m;

// Referenced classes of package com.cyberlink.youcammakeup.camera:
//            y

class a
    implements android.hardware.ra.AutoFocusCallback
{

    final y a;

    public void onAutoFocus(boolean flag, Camera camera)
    {
        m.b("LiveMakeupCtrl", (new StringBuilder()).append("ProcessingFrame(), onAutoFocus result=").append(String.valueOf(flag)).toString());
        CameraActivity.b(false);
        y.a(a, true);
    }

    meraActivity(y y1)
    {
        a = y1;
        super();
    }
}
