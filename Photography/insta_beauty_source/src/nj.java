// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCameraNew;
import java.util.TimerTask;

public class nj extends TimerTask
{

    final ActivityCameraNew a;

    public nj(ActivityCameraNew activitycameranew)
    {
        a = activitycameranew;
        super();
    }

    public void run()
    {
        ActivityCameraNew.g(a);
        ActivityCameraNew.f(a).sendEmptyMessage(1);
    }
}
