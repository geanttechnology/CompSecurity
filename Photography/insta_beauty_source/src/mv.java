// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCameraNew;

public class mv
    implements Runnable
{

    final String a;
    final ActivityCameraNew b;

    public mv(ActivityCameraNew activitycameranew, String s)
    {
        b = activitycameranew;
        a = s;
        super();
    }

    public void run()
    {
        sx.a("onCameraOpenFailed", a);
        oj.a(b, new mw(this));
    }
}
