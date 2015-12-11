// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.content.Intent;
import android.view.View;
import com.aio.downloader.dialog.HelpusShareDialog;

// Referenced classes of package com.aio.downloader.activity:
//            MySettingsActivity

class val.helpusShareDialog
    implements android.view.ingsActivity._cls8
{

    final MySettingsActivity this$0;
    private final HelpusShareDialog val$helpusShareDialog;

    public void onClick(View view)
    {
        view = new Intent("android.intent.action.SEND");
        view.putExtra("android.intent.extra.TEXT", "http://tinyurl.com/allinone-downloader");
        view.setType("text/plain");
        view.setFlags(0x10000000);
        startActivity(Intent.createChooser(view, "Share a free tool to download music & app..."));
        val$helpusShareDialog.dismiss();
    }

    ()
    {
        this$0 = final_mysettingsactivity;
        val$helpusShareDialog = HelpusShareDialog.this;
        super();
    }
}
