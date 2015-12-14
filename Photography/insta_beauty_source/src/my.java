// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCameraNew;

public class my
    implements Runnable
{

    final ActivityCameraNew a;

    public my(ActivityCameraNew activitycameranew)
    {
        a = activitycameranew;
        super();
    }

    public void run()
    {
        ActivityCameraNew.a(a, ActivityCameraNew.f(a));
    }
}
