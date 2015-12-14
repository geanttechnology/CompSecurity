// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity.pip.fragment;

import android.view.View;
import com.flurry.android.FlurryAgent;
import com.pipcamera.activity.pip.PipRealTimeCameraActivity;
import com.wantu.model.res.pip.TDFSceneInfo;
import jp.co.cyberagent.android.gpuimage.camera.PipCameraGLSurfaceView;

// Referenced classes of package com.pipcamera.activity.pip.fragment:
//            PipCameraFragment

class a
    implements android.view.t.PipCameraFragment._cls14
{

    final PipCameraFragment a;

    public void onClick(View view)
    {
        FlurryAgent.logEvent("ActivityCamera_BtnSwitch");
        PipCameraFragment.q(a).switchCamera();
        PipCameraFragment.b(a, PipCameraFragment.d(a).i());
        if (PipCameraFragment.s(a) != null && PipCameraFragment.s(a).getName() != null)
        {
            PipCameraFragment.c(a, PipCameraFragment.s(a));
        }
        PipCameraFragment.q(a).setIsTakingPhoto(false);
    }

    ceView(PipCameraFragment pipcamerafragment)
    {
        a = pipcamerafragment;
        super();
    }
}
