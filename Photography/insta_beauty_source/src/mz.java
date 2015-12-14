// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import android.view.Window;
import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCameraNew;

public class mz
    implements Runnable
{

    final ActivityCameraNew a;

    public mz(ActivityCameraNew activitycameranew)
    {
        a = activitycameranew;
        super();
    }

    public void run()
    {
        if (ActivityCameraNew.o(a) == 2)
        {
            ActivityCameraNew.Q(a).setVisibility(0);
            android.view.WindowManager.LayoutParams layoutparams = a.getWindow().getAttributes();
            layoutparams.screenBrightness = 1.0F;
            a.getWindow().setAttributes(layoutparams);
            return;
        }
        if (ActivityCameraNew.o(a) == 0)
        {
            float f = ActivityCameraNew.ak(a);
            jp.co.cyberagent.android.gpuimage.camera.BeautyCameraGLSurfaceView beautycameraglsurfaceview = a.k;
            if (f < 10F)
            {
                ActivityCameraNew.Q(a).setVisibility(0);
                android.view.WindowManager.LayoutParams layoutparams1 = a.getWindow().getAttributes();
                layoutparams1.screenBrightness = 1.0F;
                a.getWindow().setAttributes(layoutparams1);
                return;
            }
        }
        ActivityCameraNew.Q(a).setVisibility(4);
    }
}
