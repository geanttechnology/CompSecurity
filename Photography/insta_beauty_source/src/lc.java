// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCamera;

public class lc
    implements Runnable
{

    final ActivityCamera a;

    public lc(ActivityCamera activitycamera)
    {
        a = activitycamera;
        super();
    }

    public void run()
    {
        a.finish();
    }
}
