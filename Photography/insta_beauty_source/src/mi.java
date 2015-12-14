// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.hardware.Camera;
import android.widget.ImageView;
import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCameraNew;

public class mi
    implements android.hardware.Camera.AutoFocusCallback
{

    final ActivityCameraNew a;

    public mi(ActivityCameraNew activitycameranew)
    {
        a = activitycameranew;
        super();
    }

    public void onAutoFocus(boolean flag, Camera camera)
    {
        ActivityCameraNew.V(a).setVisibility(4);
        ActivityCameraNew.V(a).clearAnimation();
    }
}
