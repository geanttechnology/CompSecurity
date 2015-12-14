// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.picsin.camera;

import android.view.View;
import com.socialin.picsin.camera.view.c;

// Referenced classes of package com.socialin.picsin.camera:
//            CameraMainActivity

final class a
    implements Runnable
{

    private CameraMainActivity a;

    public final void run()
    {
        if (com.socialin.picsin.camera.CameraMainActivity.c(a) != null && !com.socialin.picsin.camera.CameraMainActivity.c(a).N() && !com.socialin.picsin.camera.CameraMainActivity.c(a).W() && CameraMainActivity.x(a))
        {
            a.findViewById(0x7f100684).setVisibility(8);
            a.findViewById(0x7f100685).setVisibility(8);
        }
    }

    (CameraMainActivity cameramainactivity)
    {
        a = cameramainactivity;
        super();
    }
}
