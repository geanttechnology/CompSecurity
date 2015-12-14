// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import android.widget.ImageButton;
import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCameraNew;
import com.fotoable.beautyui.other.SeperateMovieBar;
import java.io.File;
import java.util.ArrayList;
import jp.co.cyberagent.android.gpuimage.camera.BeautyCameraGLSurfaceView;

public class lv
    implements android.view.View.OnClickListener
{

    final ActivityCameraNew a;

    public lv(ActivityCameraNew activitycameranew)
    {
        a = activitycameranew;
        super();
    }

    public void onClick(View view)
    {
        view = a;
        boolean flag;
        if (!ActivityCameraNew.F(a))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ActivityCameraNew.g(view, flag);
        if (!ActivityCameraNew.F(a))
        {
            if (ActivityCameraNew.b(a).getBarState() != com.fotoable.beautyui.other.SeperateMovieBar.MovieBarState.STATE_PREPARE_DELETE)
            {
                return;
            }
            ActivityCameraNew.G(a).setBackgroundResource(0x7f020191);
            ActivityCameraNew.b(a).deleteMovie();
            ActivityCameraNew.b(a).setBarState(com.fotoable.beautyui.other.SeperateMovieBar.MovieBarState.STATE_CAPTURING);
            if (ActivityCameraNew.H(a).size() > 1)
            {
                view = new File((String)ActivityCameraNew.H(a).get(ActivityCameraNew.H(a).size() - 1));
                a.a(view);
                ActivityCameraNew.H(a).remove(ActivityCameraNew.H(a).size() - 1);
                return;
            } else
            {
                view = new File((String)ActivityCameraNew.H(a).get(0));
                a.a(view);
                ActivityCameraNew.H(a).remove(0);
                a.k.setCaptureState(jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumCameraCaptureState.STATE_PREPARE_SEPERATE_RECORD);
                ActivityCameraNew.a(a, jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumCameraCaptureState.STATE_PREPARE_SEPERATE_RECORD);
                ActivityCameraNew.g(a, false);
                return;
            }
        } else
        {
            ActivityCameraNew.G(a).setBackgroundResource(0x7f020192);
            ActivityCameraNew.b(a).setBarState(com.fotoable.beautyui.other.SeperateMovieBar.MovieBarState.STATE_PREPARE_DELETE);
            return;
        }
    }
}
