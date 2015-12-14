// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.picsin.camera;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.ViewFlipper;
import myobfuscated.db.a;

// Referenced classes of package com.socialin.picsin.camera:
//            CameraMainActivity, m

final class a
    implements Runnable
{

    private int a;
    private CameraMainActivity b;

    public final void run()
    {
        com.socialin.picsin.camera.CameraMainActivity.a(b, CameraMainActivity.i(b));
        if (a == com.socialin.picsin.camera.CameraMainActivity.a(b))
        {
            if (CameraMainActivity.g(b) != null)
            {
                CameraMainActivity.g(b).a((int)(360F - (float)a));
            }
            ViewFlipper viewflipper = (ViewFlipper)b.findViewById(0x7f10020f);
            if (viewflipper.getVisibility() == 0)
            {
                int i = viewflipper.getDisplayedChild();
                com.socialin.picsin.camera.CameraMainActivity.a(b, i, a);
            }
            if (b.o != null)
            {
                b.o.a((int)(360F - (float)a));
            }
            if (CameraMainActivity.j(b) != null)
            {
                CameraMainActivity.j(b).setRotation((int)(360F - (float)a));
            }
            int j = 0;
            while (j < CameraMainActivity.k(b).length) 
            {
                int k = CameraMainActivity.k(b)[j];
                View view = b.findViewById(k);
                view.clearAnimation();
                view.setRotation(360F - (float)a);
                j++;
            }
        }
    }

    (CameraMainActivity cameramainactivity, int i)
    {
        b = cameramainactivity;
        a = i;
        super();
    }
}
