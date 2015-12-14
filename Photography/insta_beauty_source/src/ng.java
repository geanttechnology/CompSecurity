// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.res.Resources;
import android.util.Log;
import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCameraNew;
import jp.co.cyberagent.android.gpuimage.camera.BeautyCameraGLSurfaceView;

public class ng
    implements pz
{

    final ActivityCameraNew a;

    public ng(ActivityCameraNew activitycameranew)
    {
        a = activitycameranew;
        super();
    }

    public void a(String s, int i, String s1)
    {
        ActivityCameraNew.a(a, s1);
        ActivityCameraNew.b(a, s1);
        ActivityCameraNew.b(a, i);
        if (s1.equalsIgnoreCase(a.getResources().getString(0x7f06009d)))
        {
            a.k.setFilterLevel(1.0F);
        } else
        {
            a.k.setFilterLevel(0.7F);
        }
        a.k.setFilterType(bku.d(a, s1));
        Log.e(ActivityCameraNew.i(a), (new StringBuilder()).append("filterpath=").append(s).append(", filterName=").append(s1).toString());
    }
}
