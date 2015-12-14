// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;


// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            CameraLandscapeActivity

class a
    implements Runnable
{

    final CameraLandscapeActivity a;

    public void run()
    {
        if (!a.b())
        {
            CameraLandscapeActivity.a(a, true);
            a.finish();
        }
    }

    (CameraLandscapeActivity cameralandscapeactivity)
    {
        a = cameralandscapeactivity;
        super();
    }
}
