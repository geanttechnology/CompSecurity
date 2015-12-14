// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.camera;

import android.os.Handler;
import com.cyberlink.clgpuimage.ab;
import com.cyberlink.youcammakeup.kernelctrl.LiveDemoConfigHelper;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.cyberlink.youcammakeup.camera:
//            CameraCtrl

class a
    implements ab
{

    final CameraCtrl a;

    public void a(float f)
    {
        if (NetworkManager.f() || LiveDemoConfigHelper.h().o())
        {
            android.os.Message message = CameraCtrl.a(a).obtainMessage(0x6f396c3d, String.valueOf(f));
            CameraCtrl.a(a).sendMessage(message);
        }
        if (f < 10F && CameraCtrl.l(a) && !CameraCtrl.l().get() && !CameraCtrl.m().compareAndSet(true, false))
        {
            CameraCtrl.c(a, true);
        }
    }

    nfigHelper(CameraCtrl cameractrl)
    {
        a = cameractrl;
        super();
    }
}
