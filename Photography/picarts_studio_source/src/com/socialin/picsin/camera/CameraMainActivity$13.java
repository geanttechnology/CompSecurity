// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.picsin.camera;

import android.view.View;
import android.widget.ViewFlipper;

// Referenced classes of package com.socialin.picsin.camera:
//            CameraMainActivity

final class a
    implements android.view.inActivity._cls13
{

    private CameraMainActivity a;

    public final void onClick(View view)
    {
        if (((ViewFlipper)a.findViewById(0x7f10020f)).getDisplayedChild() == 4)
        {
            CameraMainActivity.b(a, CameraMainActivity.a(a));
        } else
        {
            CameraMainActivity.b(a, CameraMainActivity.a(a));
            if (CameraMainActivity.y(a))
            {
                a.b();
                return;
            }
        }
    }

    (CameraMainActivity cameramainactivity)
    {
        a = cameramainactivity;
        super();
    }
}
