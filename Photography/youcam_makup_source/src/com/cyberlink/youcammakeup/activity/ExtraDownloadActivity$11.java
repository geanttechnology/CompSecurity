// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.content.Intent;
import android.view.View;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.utility.o;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            ExtraDownloadActivity, LauncherActivity

class a
    implements android.view.traDownloadActivity._cls11
{

    final ExtraDownloadActivity a;

    public void onClick(View view)
    {
        view = new Intent(a, com/cyberlink/youcammakeup/activity/LauncherActivity);
        view.setFlags(0x10008000);
        a.startActivity(view);
        Globals.d().i();
        o.a(a);
        a.finish();
    }

    (ExtraDownloadActivity extradownloadactivity)
    {
        a = extradownloadactivity;
        super();
    }
}
