// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import android.view.View;
import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCameraNew;
import jp.co.cyberagent.android.gpuimage.camera.BeautyCameraGLSurfaceView;

public class lw
    implements android.view.View.OnClickListener
{

    final ActivityCameraNew a;

    public lw(ActivityCameraNew activitycameranew)
    {
        a = activitycameranew;
        super();
    }

    public void onClick(View view)
    {
        Log.e(ActivityCameraNew.i(a), "continousRecordListener");
        if (view.getId() == 0x7f0d0071)
        {
            if (a.k.getCaptureState() == jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumCameraCaptureState.STATE_CONTINOUS_RECORD)
            {
                ActivityCameraNew.I(a);
            } else
            if (a.k.getCaptureState() == jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumCameraCaptureState.STATE_PREPARE_CONTINOUS_RECORD)
            {
                ActivityCameraNew.J(a);
                return;
            }
        }
    }
}
