// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.picsin.camera;

import com.socialin.picsin.camera.view.CameraFocusRectView;

// Referenced classes of package com.socialin.picsin.camera:
//            CameraMainActivity

public final class a
    implements Runnable
{

    private CameraMainActivity a;

    public final void run()
    {
        if (CameraMainActivity.f(a) == null)
        {
            CameraMainActivity.a(a, (CameraFocusRectView)a.findViewById(0x7f1001fa));
        }
        if (CameraMainActivity.f(a) != null)
        {
            CameraMainActivity.f(a).setVisibility(8);
        }
    }

    public ew(CameraMainActivity cameramainactivity)
    {
        a = cameramainactivity;
        super();
    }
}
