// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity.pip.fragment;

import android.view.View;
import jp.co.cyberagent.android.gpuimage.camera.PipCameraGLSurfaceView;

// Referenced classes of package com.pipcamera.activity.pip.fragment:
//            PipCameraFragment

class a
    implements android.view.t.PipCameraFragment._cls15
{

    final PipCameraFragment a;

    public void onClick(View view)
    {
        PipCameraFragment.q(a).takePhoto();
    }

    ceView(PipCameraFragment pipcamerafragment)
    {
        a = pipcamerafragment;
        super();
    }
}
