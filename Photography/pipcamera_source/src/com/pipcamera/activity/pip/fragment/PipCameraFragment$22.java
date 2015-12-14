// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity.pip.fragment;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import com.pipcamera.activity.pip.PipRealTimeCameraActivity;
import com.wantu.imagerender.ImageGLSurfaceView;

// Referenced classes of package com.pipcamera.activity.pip.fragment:
//            PipCameraFragment

class a extends Handler
{

    final int a;
    final PipCameraFragment b;

    public void handleMessage(Message message)
    {
        if (message != null && message.obj != null)
        {
            message = (Bitmap)message.obj;
            PipCameraFragment.d(b).b(message);
            if (a == 2000)
            {
                if (PipCameraFragment.d(b) != null)
                {
                    PipCameraFragment.d(b).d();
                    PipCameraFragment.e(b).setVisibility(8);
                }
            } else
            if (a == 3000)
            {
                PipCameraFragment.d(b).b();
                if (PipCameraFragment.d(b) != null)
                {
                    PipCameraFragment.d(b).d();
                    PipCameraFragment.e(b).setVisibility(8);
                    return;
                }
            }
        }
    }

    (PipCameraFragment pipcamerafragment, int i)
    {
        b = pipcamerafragment;
        a = i;
        super();
    }
}
