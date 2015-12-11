// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.fragments;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

// Referenced classes of package com.aio.downloader.fragments:
//            BackedUpFragment

class val.archiveFilePath
    implements android.view.icListAdapter._cls1
{

    private PackageInfo pInfo;
    final this._cls1 this$1;
    private final String val$archiveFilePath;
    private final String val$packageName;

    public void onClick(View view)
    {
        try
        {
            pInfo = cess._mth0(this._cls1.this).getActivity().getPackageManager().getPackageInfo(val$packageName, 0);
        }
        // Misplaced declaration of an exception variable
        catch (View view) { }
        Log.e("backup", (new StringBuilder("packageinfo=")).append(pInfo).toString());
        if (pInfo == null)
        {
            Log.e("backup", (new StringBuilder("click=")).append(val$archiveFilePath).toString());
            view = new Intent("android.intent.action.VIEW");
            view.setDataAndType(Uri.parse((new StringBuilder("file://")).append(val$archiveFilePath).toString()), "application/vnd.android.package-archive");
            view.setFlags(0x10000000);
            cess._mth0(this._cls1.this).getActivity().startActivity(view);
            return;
        } else
        {
            Toast.makeText(cess._mth0(this._cls1.this).getActivity(), "App is already installed.", 0).show();
            return;
        }
    }

    ()
    {
        this$1 = final_;
        val$packageName = s;
        val$archiveFilePath = String.this;
        super();
    }
}
