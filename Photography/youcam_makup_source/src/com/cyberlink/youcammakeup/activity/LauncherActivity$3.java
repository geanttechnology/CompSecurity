// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.content.Intent;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            LauncherActivity, CameraLandscapeActivity

class a
    implements Runnable
{

    final LauncherActivity a;

    public void run()
    {
        Intent intent = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/CameraLandscapeActivity);
        a.startActivity(intent);
        a.finish();
    }

    vity(LauncherActivity launcheractivity)
    {
        a = launcheractivity;
        super();
    }
}
