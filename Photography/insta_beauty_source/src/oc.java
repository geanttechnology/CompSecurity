// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCameraNoRealtime;

public class oc
    implements android.view.View.OnClickListener
{

    final ActivityCameraNoRealtime a;

    public oc(ActivityCameraNoRealtime activitycameranorealtime)
    {
        a = activitycameranorealtime;
        super();
    }

    public void onClick(View view)
    {
        if (pt.b(pt.j, a, true))
        {
            ActivityCameraNoRealtime.e(a);
        }
    }
}
