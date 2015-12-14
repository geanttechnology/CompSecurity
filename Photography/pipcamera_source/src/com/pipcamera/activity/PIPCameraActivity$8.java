// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity;

import com.fotoable.fullscreenad.FullScreenAdView;
import jh;

// Referenced classes of package com.pipcamera.activity:
//            PIPCameraActivity

class a
    implements jh
{

    final PIPCameraActivity a;

    public void a()
    {
        if (PIPCameraActivity.b(a) != null)
        {
            PIPCameraActivity.b(a).destroyView();
            PIPCameraActivity.a(a, null);
        }
        PIPCameraActivity.c(a);
    }

    public void a(String s)
    {
        PIPCameraActivity.a(a, s);
    }

    (PIPCameraActivity pipcameraactivity)
    {
        a = pipcameraactivity;
        super();
    }
}
