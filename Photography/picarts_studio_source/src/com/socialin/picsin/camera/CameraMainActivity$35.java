// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.picsin.camera;

import android.view.View;
import android.widget.ViewFlipper;
import com.socialin.picsin.camera.view.c;
import myobfuscated.db.a;

// Referenced classes of package com.socialin.picsin.camera:
//            CameraMainActivity, m

final class a
    implements android.view.inActivity._cls35
{

    private CameraMainActivity a;

    public final void onClick(View view)
    {
        if (a.o != null && a.o.b())
        {
            a.o.a();
        }
        if (CameraMainActivity.g(a) != null && CameraMainActivity.g(a).c())
        {
            CameraMainActivity.g(a).b(true);
        }
        if (((ViewFlipper)a.findViewById(0x7f1001fb)).getDisplayedChild() != 0)
        {
            CameraMainActivity.h(a);
        }
        if (com.socialin.picsin.camera.CameraMainActivity.c(a) != null && (com.socialin.picsin.camera.CameraMainActivity.c(a).N() || com.socialin.picsin.camera.CameraMainActivity.c(a).W() || a.findViewById(0x7f100684).getVisibility() == 0))
        {
            return;
        } else
        {
            CameraMainActivity.d(a);
            return;
        }
    }

    (CameraMainActivity cameramainactivity)
    {
        a = cameramainactivity;
        super();
    }
}
