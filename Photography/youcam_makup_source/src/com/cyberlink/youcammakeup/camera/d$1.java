// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.camera;

import android.hardware.Camera;

// Referenced classes of package com.cyberlink.youcammakeup.camera:
//            d, CameraCtrl

class a
    implements Runnable
{

    final d a;

    public void run()
    {
        if (CameraCtrl.q(a.a) == null)
        {
            break MISSING_BLOCK_LABEL_26;
        }
        CameraCtrl.q(a.a).startPreview();
        return;
        Exception exception;
        exception;
        if (CameraCtrl.q(a.a) != null)
        {
            try
            {
                CameraCtrl.q(a.a).release();
            }
            catch (Exception exception1) { }
        }
        CameraCtrl.a(a.a, null);
        return;
    }

    raCtrl(d d1)
    {
        a = d1;
        super();
    }
}
