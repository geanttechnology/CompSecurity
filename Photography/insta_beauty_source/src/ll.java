// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCameraNew;
import java.util.ArrayList;
import jp.co.cyberagent.android.gpuimage.camera.BeautyCameraGLSurfaceView;

public class ll
    implements android.view.View.OnClickListener
{

    final ActivityCameraNew a;

    public ll(ActivityCameraNew activitycameranew)
    {
        a = activitycameranew;
        super();
    }

    public void onClick(View view)
    {
        if (a.k.getFlashLightList().size() != 0 && !a.k.isFrontFacing())
        {
            ActivityCameraNew.n(a);
            ActivityCameraNew.c(a, ActivityCameraNew.o(a) % a.k.getFlashLightList().size());
            ActivityCameraNew.d(a, ActivityCameraNew.o(a));
        } else
        if ((a.k.getCaptureState() == jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumCameraCaptureState.STATE_CONTINUOUS_PHOTO || a.k.getCaptureState() == jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumCameraCaptureState.STATE_TAKE_PHOTO) && a.k.isFrontFacing())
        {
            ActivityCameraNew.n(a);
            ActivityCameraNew.c(a, ActivityCameraNew.o(a) % 3);
            ActivityCameraNew.d(a, ActivityCameraNew.o(a));
            return;
        }
    }
}
