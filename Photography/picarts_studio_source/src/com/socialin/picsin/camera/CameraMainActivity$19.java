// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.picsin.camera;

import com.socialin.camera.opengl.h;

// Referenced classes of package com.socialin.picsin.camera:
//            CameraMainActivity

public final class a
    implements Runnable
{

    private CameraMainActivity a;

    public final void run()
    {
        if (CameraMainActivity.p(a) != null)
        {
            CameraMainActivity.p(a).c = false;
            CameraMainActivity.p(a).x = null;
        }
    }

    public (CameraMainActivity cameramainactivity)
    {
        a = cameramainactivity;
        super();
    }
}
