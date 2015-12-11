// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.content.Intent;
import android.view.View;

// Referenced classes of package com.aio.downloader.activity:
//            PaidforFreeActivity1, DownloadAppManager

class this._cls0
    implements android.view.reeActivity1._cls4
{

    final PaidforFreeActivity1 this$0;

    public void onClick(View view)
    {
        startActivity(new Intent(PaidforFreeActivity1.this, com/aio/downloader/activity/DownloadAppManager));
    }

    ()
    {
        this$0 = PaidforFreeActivity1.this;
        super();
    }
}
