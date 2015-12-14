// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCameraNoRealtime;

public class ns
    implements qc
{

    final String a;
    final ActivityCameraNoRealtime b;

    public ns(ActivityCameraNoRealtime activitycameranorealtime, String s)
    {
        b = activitycameranorealtime;
        a = s;
        super();
    }

    public void a()
    {
        b.runOnUiThread(new nt(this));
    }

    public void b()
    {
        b.runOnUiThread(new nu(this));
    }
}
