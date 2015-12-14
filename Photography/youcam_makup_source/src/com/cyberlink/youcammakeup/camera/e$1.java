// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.camera;

import android.hardware.Camera;
import android.os.Handler;
import android.widget.ImageView;

// Referenced classes of package com.cyberlink.youcammakeup.camera:
//            e, CameraCtrl, ah, m

class a
    implements Runnable
{

    final e a;

    public void run()
    {
        if (e.a(a) > 0)
        {
            CameraCtrl.F(a.a).setImageResource(e.b(a)[e.a(a)]);
            e.c(a).postDelayed(this, 1000L);
            CameraCtrl.G(a.a).a(2);
            e.d(a);
            return;
        }
        CameraCtrl.F(a.a).setImageResource(0);
        if (e.e(a))
        {
            e.a(a, false);
            try
            {
                CameraCtrl.q(a.a).autoFocus(CameraCtrl.H(a.a));
                return;
            }
            catch (Exception exception)
            {
                CameraCtrl.H(a.a).onAutoFocus(false, CameraCtrl.q(a.a));
            }
            return;
        } else
        {
            a.c();
            return;
        }
    }

    raCtrl(e e1)
    {
        a = e1;
        super();
    }
}
