// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCameraNew;
import jp.co.cyberagent.android.gpuimage.camera.BeautyCameraGLSurfaceView;

public class lx
    implements android.view.View.OnClickListener
{

    final ActivityCameraNew a;

    public lx(ActivityCameraNew activitycameranew)
    {
        a = activitycameranew;
        super();
    }

    public void onClick(View view)
    {
        Log.e(ActivityCameraNew.i(a), "changeSurfaceScaleListener");
        if (a.k.getPreviewRatio() == jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumPreviewRatio.Ratio_four2three)
        {
            ActivityCameraNew.K(a).setBackgroundResource(0x7f020190);
            view = jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumPreviewRatio.Ratio_one2one;
            a.k.updateVideoSize(jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumPreviewRatio.Ratio_one2one);
        } else
        {
            ActivityCameraNew.K(a).setBackgroundResource(0x7f02018f);
            view = jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumPreviewRatio.Ratio_four2three;
            a.k.updateVideoSize(jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumPreviewRatio.Ratio_four2three);
        }
        a.k.setPreviewRatio(view);
        a.a(view);
    }
}
