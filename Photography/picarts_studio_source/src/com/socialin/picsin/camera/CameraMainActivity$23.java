// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.picsin.camera;

import android.view.View;

// Referenced classes of package com.socialin.picsin.camera:
//            CameraMainActivity

final class a
    implements Runnable
{

    private boolean a;
    private CameraMainActivity b;

    public final void run()
    {
        View view = b.findViewById(0x7f100684);
        View view1 = b.findViewById(0x7f100685);
        if (view != null && view1 != null)
        {
            if (a)
            {
                view.setVisibility(0);
                view1.setVisibility(0);
            } else
            if (CameraMainActivity.x(b))
            {
                view.setVisibility(8);
                view1.setVisibility(8);
                return;
            }
        }
    }

    (CameraMainActivity cameramainactivity, boolean flag)
    {
        b = cameramainactivity;
        a = flag;
        super();
    }
}
