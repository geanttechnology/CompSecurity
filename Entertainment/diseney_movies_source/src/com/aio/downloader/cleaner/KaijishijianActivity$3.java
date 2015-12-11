// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.cleaner;

import android.content.pm.PackageManager;
import android.view.View;

// Referenced classes of package com.aio.downloader.cleaner:
//            KaijishijianActivity

class this._cls0
    implements android.view.ianActivity._cls3
{

    final KaijishijianActivity this$0;

    public void onClick(View view)
    {
        view = null;
        android.content.pm.PackageInfo packageinfo = getPackageManager().getPackageInfo("com.evzapp.cleanmaster", 0);
        view = packageinfo;
_L1:
        android.content.pm.oundException oundexception;
        if (view == null)
        {
            KaijishijianActivity.access$0(KaijishijianActivity.this);
        } else
        {
            view = getPackageManager().getLaunchIntentForPackage("com.evzapp.cleanmaster");
            startActivity(view);
        }
        finish();
        return;
        oundexception;
        oundexception.printStackTrace();
          goto _L1
    }

    ption()
    {
        this$0 = KaijishijianActivity.this;
        super();
    }
}
