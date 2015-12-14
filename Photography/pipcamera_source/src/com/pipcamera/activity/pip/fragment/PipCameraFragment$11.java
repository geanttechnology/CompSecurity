// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity.pip.fragment;

import android.view.View;
import com.flurry.android.FlurryAgent;
import java.util.ArrayList;
import jp.co.cyberagent.android.gpuimage.camera.PipCameraGLSurfaceView;

// Referenced classes of package com.pipcamera.activity.pip.fragment:
//            PipCameraFragment

class a
    implements android.view.t.PipCameraFragment._cls11
{

    final PipCameraFragment a;

    public void onClick(View view)
    {
        if (PipCameraFragment.q(a).getFlashLightList().size() == 0)
        {
            return;
        } else
        {
            PipCameraFragment.r(a);
            PipCameraFragment.d(a, PipCameraFragment.p(a) % PipCameraFragment.q(a).getFlashLightList().size());
            PipCameraFragment.c(a, PipCameraFragment.p(a));
            FlurryAgent.logEvent("ActivityCamera_BtnFlash");
            return;
        }
    }

    ceView(PipCameraFragment pipcamerafragment)
    {
        a = pipcamerafragment;
        super();
    }
}
