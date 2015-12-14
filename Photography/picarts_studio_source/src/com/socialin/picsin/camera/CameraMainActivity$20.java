// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.picsin.camera;

import android.view.View;
import myobfuscated.db.a;

// Referenced classes of package com.socialin.picsin.camera:
//            CameraMainActivity

final class a
    implements android.view.inActivity._cls20
{

    private CameraMainActivity a;

    public final void onClick(View view)
    {
        if (CameraMainActivity.g(a) != null && CameraMainActivity.g(a).c())
        {
            CameraMainActivity.g(a).b(true);
        }
    }

    (CameraMainActivity cameramainactivity)
    {
        a = cameramainactivity;
        super();
    }
}
