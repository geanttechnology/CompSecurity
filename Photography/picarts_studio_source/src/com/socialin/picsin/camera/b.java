// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.picsin.camera;

import android.view.View;
import com.socialin.picsin.camera.view.c;

// Referenced classes of package com.socialin.picsin.camera:
//            CameraMainActivity

public class b
{

    CameraMainActivity a;

    b(CameraMainActivity cameramainactivity)
    {
        a = cameramainactivity;
        super();
    }

    public void a()
    {
        if (com.socialin.picsin.camera.CameraMainActivity.c(a) != null && !com.socialin.picsin.camera.CameraMainActivity.c(a).B() && a.findViewById(0x7f10022b).getVisibility() != 0)
        {
            com.socialin.picsin.camera.CameraMainActivity.c(a).a(null, a);
        }
    }
}
