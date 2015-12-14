// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.camera.opengl;

import com.socialin.android.dialog.g;
import com.socialin.picsin.camera.CameraMainActivity;
import com.socialin.picsin.camera.view.c;
import myobfuscated.db.a;

// Referenced classes of package com.socialin.camera.opengl:
//            a

final class a
    implements Runnable
{

    private com.socialin.camera.opengl.a a;

    public final void run()
    {
        CameraMainActivity cameramainactivity = (CameraMainActivity)com.socialin.camera.opengl.a.c(a);
        if (cameramainactivity.b != null && cameramainactivity.b.isShowing())
        {
            cameramainactivity.b.dismiss();
        }
        if (com.socialin.camera.opengl.a.k(a) != null)
        {
            com.socialin.camera.opengl.a.k(a).c(true);
            com.socialin.camera.opengl.a.k(a).b();
            com.socialin.camera.opengl.a.k(a).a();
        }
        cameramainactivity.a.setPictureTaking(false);
    }

    .c(com.socialin.camera.opengl.a a1)
    {
        a = a1;
        super();
    }
}
