// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.picsin.camera;

import com.socialin.android.dialog.g;
import myobfuscated.de.b;

// Referenced classes of package com.socialin.picsin.camera:
//            CameraMainActivity

public final class a
    implements Runnable
{

    private CameraMainActivity a;

    public final void run()
    {
        if (CameraMainActivity.u(a) != null && CameraMainActivity.u(a).isShowing())
        {
            CameraMainActivity.u(a).dismiss();
        }
        CameraMainActivity.D(a).b();
        CameraMainActivity.D(a).a();
    }

    public (CameraMainActivity cameramainactivity)
    {
        a = cameramainactivity;
        super();
    }
}
