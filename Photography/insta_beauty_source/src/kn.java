// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.widget.ImageView;
import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCamera;
import jp.co.cyberagent.android.gpuimage.GPUImage;

public class kn
    implements qi
{

    final ActivityCamera a;

    public kn(ActivityCamera activitycamera)
    {
        a = activitycamera;
        super();
    }

    public void a()
    {
        ActivityCamera.b(a);
    }

    public void a(android.hardware.Camera.Size size)
    {
        ActivityCamera.a(a, size);
    }

    public void a(GPUImage gpuimage)
    {
        ActivityCamera.a(a, gpuimage);
    }

    public void a(boolean flag)
    {
        if (flag)
        {
            ActivityCamera.a(a).setVisibility(0);
            return;
        } else
        {
            ActivityCamera.a(a).setVisibility(4);
            return;
        }
    }

    public void b(boolean flag)
    {
        ActivityCamera.a(a, flag);
    }
}
