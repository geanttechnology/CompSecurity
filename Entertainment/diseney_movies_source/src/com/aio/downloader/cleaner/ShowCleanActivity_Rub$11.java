// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.cleaner;

import android.content.DialogInterface;
import android.content.Intent;
import com.aio.downloader.activity.DownloadAppManager;
import com.aio.downloader.utils.publicTools;

// Referenced classes of package com.aio.downloader.cleaner:
//            ShowCleanActivity_Rub

class this._cls0
    implements android.content.stener
{

    final ShowCleanActivity_Rub this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
        dialoginterface = new Intent(getApplicationContext(), com/aio/downloader/activity/DownloadAppManager);
        startActivity(dialoginterface);
        publicTools.cleanertag = false;
        finish();
    }

    _cls9()
    {
        this$0 = ShowCleanActivity_Rub.this;
        super();
    }
}
