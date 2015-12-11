// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.View;
import android.widget.Toast;
import com.aio.downloader.utils.MyAppInfo;

// Referenced classes of package com.aio.downloader.activity:
//            AppDetailsActivity

class this._cls0
    implements android.view.ilsActivity._cls22
{

    final AppDetailsActivity this$0;

    public void onClick(View view)
    {
        MyAppInfo myappinfo;
        try
        {
            view = getPackageManager().getPackageInfo(AppDetailsActivity.access$27(AppDetailsActivity.this), 0);
        }
        catch (android.content.pm.FoundException foundexception)
        {
            view = null;
            foundexception.printStackTrace();
        }
        myappinfo = new MyAppInfo(getApplicationContext());
        try
        {
            AppDetailsActivity.access$80(AppDetailsActivity.this, myappinfo.getAppVersion(AppDetailsActivity.access$27(AppDetailsActivity.this)));
        }
        catch (android.content.pm.FoundException foundexception1)
        {
            foundexception1.printStackTrace();
        }
        if (view == null)
        {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse((new StringBuilder("file://")).append(AppDetailsActivity.access$81(AppDetailsActivity.this)).toString()), "application/vnd.android.package-archive");
            startActivity(intent);
        } else
        {
            try
            {
                Intent intent1 = getPackageManager().getLaunchIntentForPackage(AppDetailsActivity.access$27(AppDetailsActivity.this));
                intent1.addFlags(0x10000000);
                startActivity(intent1);
            }
            catch (Exception exception)
            {
                Toast.makeText(AppDetailsActivity.this, "This program is protected", 0).show();
            }
        }
        if (AppDetailsActivity.access$17(AppDetailsActivity.this) != 1)
        {
            break MISSING_BLOCK_LABEL_174;
        }
        if (!AppDetailsActivity.access$30(AppDetailsActivity.this).equals(AppDetailsActivity.access$82(AppDetailsActivity.this)) || view == null)
        {
            break MISSING_BLOCK_LABEL_261;
        }
        view = getPackageManager().getLaunchIntentForPackage(AppDetailsActivity.access$27(AppDetailsActivity.this));
        view.addFlags(0x10000000);
        startActivity(view);
        return;
        view;
        Toast.makeText(AppDetailsActivity.this, "This program is protected", 0).show();
        return;
        view = new Intent("android.intent.action.VIEW");
        view.setDataAndType(Uri.parse((new StringBuilder("file://")).append(AppDetailsActivity.access$81(AppDetailsActivity.this)).toString()), "application/vnd.android.package-archive");
        startActivity(view);
        return;
    }

    ption()
    {
        this$0 = AppDetailsActivity.this;
        super();
    }
}
