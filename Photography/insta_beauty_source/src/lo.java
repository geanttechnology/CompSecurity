// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCameraNew;
import jp.co.cyberagent.android.gpuimage.Rotation;
import jp.co.cyberagent.android.gpuimage.camera.BeautyCameraGLSurfaceView;

public class lo
    implements android.view.View.OnClickListener
{

    final ActivityCameraNew a;

    public lo(ActivityCameraNew activitycameranew)
    {
        a = activitycameranew;
        super();
    }

    public void onClick(View view)
    {
        ActivityCameraNew.s(a).setVisibility(0);
        ActivityCameraNew.t(a);
        ActivityCameraNew.u(a);
        if (a.k.isFrontFacing())
        {
            a.g = pt.b(pt.k, a, 0);
        } else
        {
            a.g = pt.b(pt.l, a, 0);
        }
        a.g = a.g + a.a();
        view = Rotation.NORMAL;
        a.g % 360;
        JVM INSTR lookupswitch 3: default 128
    //                   90: 183
    //                   180: 190
    //                   270: 197;
           goto _L1 _L2 _L3 _L4
_L1:
        a.k.setRotation(view, a.k.isFrontFacing(), false);
        a.k.setIsTakingPhoto(false);
        return;
_L2:
        view = Rotation.ROTATION_90;
        continue; /* Loop/switch isn't completed */
_L3:
        view = Rotation.ROTATION_180;
        continue; /* Loop/switch isn't completed */
_L4:
        view = Rotation.ROTATION_270;
        if (true) goto _L1; else goto _L5
_L5:
    }
}
