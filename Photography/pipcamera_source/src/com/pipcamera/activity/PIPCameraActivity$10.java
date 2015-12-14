// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity;

import android.view.View;
import pb;

// Referenced classes of package com.pipcamera.activity:
//            PIPCameraActivity

class a
    implements Runnable
{

    final PIPCameraActivity a;

    public void run()
    {
        a.t = false;
        if (PIPCameraActivity.d(a) != null)
        {
            float f = (float)pb.a(a) / 320F;
            ((android.widget.Params)PIPCameraActivity.d(a).getLayoutParams()).height = pb.a(a, 243F * f);
            PIPCameraActivity.d(a).requestLayout();
        }
    }

    (PIPCameraActivity pipcameraactivity)
    {
        a = pipcameraactivity;
        super();
    }
}
