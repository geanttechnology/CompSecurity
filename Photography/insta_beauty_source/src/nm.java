// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.hardware.Camera;
import android.widget.ImageView;
import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCameraNoRealtime;

public class nm
    implements android.hardware.Camera.AutoFocusCallback
{

    final ActivityCameraNoRealtime a;

    public nm(ActivityCameraNoRealtime activitycameranorealtime)
    {
        a = activitycameranorealtime;
        super();
    }

    public void onAutoFocus(boolean flag, Camera camera)
    {
        ActivityCameraNoRealtime.g(a).setVisibility(4);
    }
}
