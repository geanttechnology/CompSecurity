// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity.pip.fragment;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import com.pipcamera.activity.pip.PipStyleActivity;
import com.wantu.imagerender.ImageGLSurfaceView;

// Referenced classes of package com.pipcamera.activity.pip.fragment:
//            PipStyleFragment

class a extends Handler
{

    final PipStyleFragment a;

    public void handleMessage(Message message)
    {
        if (message != null && message.obj != null)
        {
            message = (Bitmap)message.obj;
            PipStyleFragment.d(a).b(message);
            PipStyleFragment.f(a).setFilterName(PipStyleFragment.e(a));
            PipStyleFragment.f(a).setSourceBitmap(message);
        }
    }

    (PipStyleFragment pipstylefragment)
    {
        a = pipstylefragment;
        super();
    }
}
