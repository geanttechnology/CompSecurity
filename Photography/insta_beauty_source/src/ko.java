// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.hardware.Camera;
import android.widget.ImageView;
import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCamera;

public class ko
    implements android.hardware.Camera.AutoFocusCallback
{

    final ActivityCamera a;

    public ko(ActivityCamera activitycamera)
    {
        a = activitycamera;
        super();
    }

    public void onAutoFocus(boolean flag, Camera camera)
    {
        ActivityCamera.k(a).setVisibility(4);
    }
}
