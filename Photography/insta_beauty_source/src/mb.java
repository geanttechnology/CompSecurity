// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.widget.ImageView;
import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCameraNew;

public class mb
    implements Runnable
{

    final ActivityCameraNew a;

    public mb(ActivityCameraNew activitycameranew)
    {
        a = activitycameranew;
        super();
    }

    public void run()
    {
        ActivityCameraNew.M(a);
        JVM INSTR tableswitch 1 4: default 36
    //                   1 82
    //                   2 97
    //                   3 112
    //                   4 127;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        ActivityCameraNew.N(a).setVisibility(4);
_L7:
        ActivityCameraNew.O(a);
        if (ActivityCameraNew.M(a) <= 5)
        {
            ActivityCameraNew.P(a).postDelayed(this, 1000L);
        }
        return;
_L2:
        ActivityCameraNew.N(a).setBackgroundResource(0x7f02029a);
        continue; /* Loop/switch isn't completed */
_L3:
        ActivityCameraNew.N(a).setBackgroundResource(0x7f020299);
        continue; /* Loop/switch isn't completed */
_L4:
        ActivityCameraNew.N(a).setBackgroundResource(0x7f020298);
        continue; /* Loop/switch isn't completed */
_L5:
        ActivityCameraNew.E(a);
        if (true) goto _L7; else goto _L6
_L6:
    }
}
