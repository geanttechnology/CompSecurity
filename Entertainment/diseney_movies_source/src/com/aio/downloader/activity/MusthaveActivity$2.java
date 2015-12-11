// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.content.Intent;
import android.view.View;

// Referenced classes of package com.aio.downloader.activity:
//            MusthaveActivity, DownloadAppManager

class this._cls0
    implements android.view.r
{

    final MusthaveActivity this$0;

    public void onClick(View view)
    {
        startActivity(new Intent(getApplicationContext(), com/aio/downloader/activity/DownloadAppManager));
    }

    ()
    {
        this$0 = MusthaveActivity.this;
        super();
    }
}
