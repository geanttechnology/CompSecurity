// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.widget.ImageView;
import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCameraNoRealtime;

public class nn
    implements Runnable
{

    final ActivityCameraNoRealtime a;

    public nn(ActivityCameraNoRealtime activitycameranorealtime)
    {
        a = activitycameranorealtime;
        super();
    }

    public void run()
    {
        ActivityCameraNoRealtime.h(a);
        JVM INSTR tableswitch 1 4: default 36
    //                   1 71
    //                   2 86
    //                   3 101
    //                   4 116;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        ActivityCameraNoRealtime.l(a);
        if (ActivityCameraNoRealtime.h(a) < 5)
        {
            ActivityCameraNoRealtime.m(a).postDelayed(this, 1000L);
        }
        return;
_L2:
        ActivityCameraNoRealtime.i(a).setBackgroundResource(0x7f02029a);
        continue; /* Loop/switch isn't completed */
_L3:
        ActivityCameraNoRealtime.i(a).setBackgroundResource(0x7f020299);
        continue; /* Loop/switch isn't completed */
_L4:
        ActivityCameraNoRealtime.i(a).setBackgroundResource(0x7f020298);
        continue; /* Loop/switch isn't completed */
_L5:
        ActivityCameraNoRealtime.i(a).setVisibility(4);
        if (!ActivityCameraNoRealtime.j(a))
        {
            ActivityCameraNoRealtime.k(a);
        }
        if (true) goto _L1; else goto _L6
_L6:
    }
}
