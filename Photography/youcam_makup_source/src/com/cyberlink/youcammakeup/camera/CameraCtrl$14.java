// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.camera;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.pf.common.utility.m;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.cyberlink.youcammakeup.camera:
//            CameraCtrl

class a extends BroadcastReceiver
{

    final CameraCtrl a;

    public void onReceive(Context context, Intent intent)
    {
        if (!intent.getAction().equals("android.intent.action.SCREEN_OFF")) goto _L2; else goto _L1
_L1:
        CameraCtrl.z(a).set(false);
_L4:
        m.e("isScreenOn", String.valueOf(CameraCtrl.z(a).get()));
        return;
_L2:
        if (intent.getAction().equals("android.intent.action.SCREEN_ON"))
        {
            CameraCtrl.z(a).set(true);
            CameraCtrl.c(a).set(true);
        } else
        if (intent.getAction().equals("android.intent.action.CAMERA_BUTTON"))
        {
            CameraCtrl.n(a);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    (CameraCtrl cameractrl)
    {
        a = cameractrl;
        super();
    }
}
