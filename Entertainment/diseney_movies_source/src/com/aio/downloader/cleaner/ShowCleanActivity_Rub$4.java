// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.cleaner;

import android.content.Intent;
import android.view.View;
import com.aio.downloader.activity.DownloadAppManager;
import com.aio.downloader.utils.publicTools;

// Referenced classes of package com.aio.downloader.cleaner:
//            ShowCleanActivity_Rub

class this._cls0
    implements android.view.ctivity_Rub._cls4
{

    final ShowCleanActivity_Rub this$0;

    public void onClick(View view)
    {
        view = new Intent(getApplicationContext(), com/aio/downloader/activity/DownloadAppManager);
        startActivity(view);
        publicTools.cleanertag = false;
        finish();
    }

    ()
    {
        this$0 = ShowCleanActivity_Rub.this;
        super();
    }
}
