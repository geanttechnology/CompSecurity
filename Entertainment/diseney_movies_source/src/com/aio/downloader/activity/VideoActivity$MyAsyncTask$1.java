// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.view.View;
import com.aio.downloader.dialog.RestaryDownloadDialog;

// Referenced classes of package com.aio.downloader.activity:
//            VideoActivity

class val.restarydialog
    implements android.view..MyAsyncTask._cls1
{

    final val.restarydialog this$1;
    private final RestaryDownloadDialog val$restarydialog;

    public void onClick(View view)
    {
        val$restarydialog.dismiss();
    }

    ()
    {
        this$1 = final_;
        val$restarydialog = RestaryDownloadDialog.this;
        super();
    }
}
