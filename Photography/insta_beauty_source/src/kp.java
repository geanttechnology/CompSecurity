// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.widget.ImageView;
import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCamera;

public class kp
    implements Runnable
{

    final ActivityCamera a;

    public kp(ActivityCamera activitycamera)
    {
        a = activitycamera;
        super();
    }

    public void run()
    {
        ActivityCamera.p(a);
        JVM INSTR tableswitch 1 4: default 36
    //                   1 71
    //                   2 86
    //                   3 101
    //                   4 116;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        ActivityCamera.t(a);
        if (ActivityCamera.p(a) < 5)
        {
            ActivityCamera.u(a).postDelayed(this, 1000L);
        }
        return;
_L2:
        ActivityCamera.q(a).setBackgroundResource(0x7f02029a);
        continue; /* Loop/switch isn't completed */
_L3:
        ActivityCamera.q(a).setBackgroundResource(0x7f020299);
        continue; /* Loop/switch isn't completed */
_L4:
        ActivityCamera.q(a).setBackgroundResource(0x7f020298);
        continue; /* Loop/switch isn't completed */
_L5:
        ActivityCamera.q(a).setVisibility(4);
        if (!ActivityCamera.r(a))
        {
            ActivityCamera.s(a);
        }
        if (true) goto _L1; else goto _L6
_L6:
    }
}
