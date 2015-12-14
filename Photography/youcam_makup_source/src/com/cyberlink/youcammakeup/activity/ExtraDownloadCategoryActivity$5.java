// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.content.Intent;
import android.view.View;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.utility.o;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            ExtraDownloadCategoryActivity, LauncherActivity

class a
    implements android.view.loadCategoryActivity._cls5
{

    final ExtraDownloadCategoryActivity a;

    public void onClick(View view)
    {
        Globals.d().i();
        o.a(a);
        view = new Intent(a, com/cyberlink/youcammakeup/activity/LauncherActivity);
        view.setFlags(0x10008000);
        a.startActivity(view);
        a.finish();
    }

    I(ExtraDownloadCategoryActivity extradownloadcategoryactivity)
    {
        a = extradownloadcategoryactivity;
        super();
    }
}
