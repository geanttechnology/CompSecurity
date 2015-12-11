// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.content.Intent;
import android.view.View;

// Referenced classes of package com.aio.downloader.activity:
//            GameActivity1, DownloadAppManager

class this._cls0
    implements android.view.ener
{

    final GameActivity1 this$0;

    public void onClick(View view)
    {
        startActivity(new Intent(GameActivity1.this, com/aio/downloader/activity/DownloadAppManager));
    }

    er()
    {
        this$0 = GameActivity1.this;
        super();
    }
}
