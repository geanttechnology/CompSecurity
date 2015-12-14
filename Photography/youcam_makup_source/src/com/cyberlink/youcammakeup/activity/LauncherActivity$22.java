// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.net.Uri;
import android.widget.ImageView;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.banner.BannerRequest;
import java.io.File;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            LauncherActivity

class a
    implements Runnable
{

    final String a;
    final LauncherActivity b;

    public void run()
    {
        LauncherActivity.b(b).setImageURI(Uri.fromFile(new File(a, BannerRequest.b())));
    }

    ner.BannerRequest(LauncherActivity launcheractivity, String s)
    {
        b = launcheractivity;
        a = s;
        super();
    }
}
