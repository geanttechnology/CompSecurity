// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.fragments;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import com.aio.downloader.activity.AppDetailsActivity;

// Referenced classes of package com.aio.downloader.fragments:
//            BackedUpNoRootFragment

class val.archiveFilePath
    implements android.view.icListAdapter._cls1
{

    final this._cls1 this$1;
    private final String val$archiveFilePath;

    public void onClick(View view)
    {
        view = null;
        android.content.pm.PackageInfo packageinfo = cess._mth0(this._cls1.this).getActivity().getPackageManager().getPackageInfo(val$archiveFilePath, 0);
        view = packageinfo;
_L2:
        Log.e("backup", (new StringBuilder("packageInfo=")).append(view).toString());
        if (view == null)
        {
            view = new Intent(cess._mth0(this._cls1.this).getActivity(), com/aio/downloader/activity/AppDetailsActivity);
            view.putExtra("myid", val$archiveFilePath);
            view.putExtra("linkurl", "");
            view.setFlags(0x10000000);
            cess._mth0(this._cls1.this).getActivity().startActivity(view);
            return;
        } else
        {
            Toast.makeText(cess._mth0(this._cls1.this).getActivity(), "App is already installed.", 0).show();
            return;
        }
        Exception exception;
        exception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    ()
    {
        this$1 = final_;
        val$archiveFilePath = String.this;
        super();
    }
}
