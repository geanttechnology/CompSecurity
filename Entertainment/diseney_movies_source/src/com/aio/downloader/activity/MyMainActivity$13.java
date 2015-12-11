// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.content.Intent;
import android.view.View;
import com.aio.downloader.dialog.NointentDialog;

// Referenced classes of package com.aio.downloader.activity:
//            MyMainActivity

class val.dialog
    implements android.view.er
{

    final MyMainActivity this$0;
    private final NointentDialog val$dialog;

    public void onClick(View view)
    {
        startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
        val$dialog.dismiss();
    }

    ()
    {
        this$0 = final_mymainactivity;
        val$dialog = NointentDialog.this;
        super();
    }
}
