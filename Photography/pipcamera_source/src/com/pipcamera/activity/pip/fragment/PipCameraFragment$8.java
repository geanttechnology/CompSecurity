// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity.pip.fragment;

import android.content.res.Resources;
import android.widget.Toast;
import com.pipcamera.activity.pip.PipRealTimeCameraActivity;
import com.wantu.model.res.TResInfo;
import com.wantu.model.res.pip.TDFSceneInfo;
import com.wantu.piprender.ESceneMode;
import kf;
import ua;
import yf;

// Referenced classes of package com.pipcamera.activity.pip.fragment:
//            PipCameraFragment

class a
    implements ua
{

    final PipCameraFragment a;

    public void a(TResInfo tresinfo)
    {
        if (tresinfo != null && PipCameraFragment.d(a) != null)
        {
            PipCameraFragment.d(a).o();
        }
    }

    public void a(TResInfo tresinfo, float f)
    {
    }

    public void a(TDFSceneInfo tdfsceneinfo)
    {
        if (PipCameraFragment.d(a) != null)
        {
            PipCameraFragment.d(a).p();
        }
        tdfsceneinfo.mode = ESceneMode.SCENE_MODE1;
        kf.c().d().a(tdfsceneinfo);
        PipCameraFragment.a(a, tdfsceneinfo);
    }

    public void b(TResInfo tresinfo)
    {
        if (PipCameraFragment.d(a) != null)
        {
            PipCameraFragment.d(a).p();
            Toast.makeText(PipCameraFragment.d(a), PipCameraFragment.d(a).getResources().getString(0x7f0600d7), 0).show();
        }
    }

    (PipCameraFragment pipcamerafragment)
    {
        a = pipcamerafragment;
        super();
    }
}
