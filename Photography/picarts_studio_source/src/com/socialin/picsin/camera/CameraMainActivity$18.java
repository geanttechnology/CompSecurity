// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.picsin.camera;

import android.widget.RelativeLayout;
import com.socialin.camera.opengl.h;
import com.socialin.picsin.camera.view.ColorSplashForegroundView;

// Referenced classes of package com.socialin.picsin.camera:
//            CameraMainActivity

final class a
    implements Runnable
{

    private CameraMainActivity a;

    public final void run()
    {
        android.view.View view = ((RelativeLayout)a.findViewById(0x7f1001f6)).findViewWithTag("COLOR_SPLASH_FOREGROUND_VIEW_TAG");
        if (view != null)
        {
            CameraMainActivity.p(a).x = (ColorSplashForegroundView)view;
        }
        CameraMainActivity.p(a).c = true;
    }

    oundView(CameraMainActivity cameramainactivity)
    {
        a = cameramainactivity;
        super();
    }
}
