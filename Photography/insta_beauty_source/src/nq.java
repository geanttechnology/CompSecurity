// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCameraNoRealtime;

public class nq
    implements uy
{

    final ActivityCameraNoRealtime a;

    public nq(ActivityCameraNoRealtime activitycameranorealtime)
    {
        a = activitycameranorealtime;
        super();
    }

    public void a()
    {
        a.runOnUiThread(new nr(this));
    }
}
