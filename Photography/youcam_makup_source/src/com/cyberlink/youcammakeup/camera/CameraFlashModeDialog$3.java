// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.camera;

import android.view.View;

// Referenced classes of package com.cyberlink.youcammakeup.camera:
//            CameraFlashModeDialog, f

class a
    implements android.view.eraFlashModeDialog._cls3
{

    final CameraFlashModeDialog a;

    public void onClick(View view)
    {
        ashMode ashmode = null;
        if (view != CameraFlashModeDialog.a(a)) goto _L2; else goto _L1
_L1:
        ashmode = ashMode.a;
_L4:
        a.a(ashmode);
        CameraFlashModeDialog.d(a);
        if (CameraFlashModeDialog.e(a) != null)
        {
            CameraFlashModeDialog.e(a).a(ashmode);
        }
        a.dismiss();
        return;
_L2:
        if (view == CameraFlashModeDialog.b(a))
        {
            ashmode = ashMode.b;
        } else
        if (view == CameraFlashModeDialog.c(a))
        {
            ashmode = ashMode.c;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    ashMode(CameraFlashModeDialog cameraflashmodedialog)
    {
        a = cameraflashmodedialog;
        super();
    }
}
