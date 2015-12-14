// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCameraNew;
import jp.co.cyberagent.android.gpuimage.camera.BeautyCameraGLSurfaceView;

public class mh
    implements Runnable
{

    final ActivityCameraNew a;

    public mh(ActivityCameraNew activitycameranew)
    {
        a = activitycameranew;
        super();
    }

    public void run()
    {
        if (a.k.getCamera() == null)
        {
            a.finish();
            return;
        } else
        {
            a.k.startPreview();
            ActivityCameraNew.Q(a).setVisibility(4);
            ActivityCameraNew.U(a);
            ActivityCameraNew.S(a);
            return;
        }
    }
}
