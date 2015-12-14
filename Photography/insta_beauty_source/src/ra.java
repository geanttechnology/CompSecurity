// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.beautyui.gpuimage.sample.activity.Third2CameraActivity;

public class ra
    implements Runnable
{

    final Third2CameraActivity a;

    public ra(Third2CameraActivity third2cameraactivity)
    {
        a = third2cameraactivity;
        super();
    }

    public void run()
    {
        a.finish();
    }
}
