// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.picsin.camera;

import android.view.View;
import com.socialin.android.dialog.g;
import myobfuscated.cv.c;

// Referenced classes of package com.socialin.picsin.camera:
//            CameraMainActivity

final class a
    implements Runnable
{

    private CameraMainActivity a;

    public final void run()
    {
        if (CameraMainActivity.H(a) == CameraMainActivity.I(a) && a.findViewById(0x7f10022b).getVisibility() == 0 && !CameraMainActivity.i(a))
        {
            if (CameraMainActivity.u(a) != null && CameraMainActivity.u(a).isShowing())
            {
                CameraMainActivity.u(a).dismiss();
            }
            if (CameraMainActivity.A(a) && CameraMainActivity.J(a) != null)
            {
                c.a(a, CameraMainActivity.J(a), CameraMainActivity.K(a), CameraMainActivity.L(a), "camera", "share_to_pa");
                CameraMainActivity.l(a);
            }
        }
    }

    (CameraMainActivity cameramainactivity)
    {
        a = cameramainactivity;
        super();
    }
}
