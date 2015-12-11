// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.content.Intent;
import android.view.View;

// Referenced classes of package com.aio.downloader.activity:
//            AppDetailsActivity, MyMainActivity

class this._cls0
    implements android.view.ilsActivity._cls19
{

    final AppDetailsActivity this$0;

    public void onClick(View view)
    {
        if (AppDetailsActivity.access$74(AppDetailsActivity.this) == 1 || AppDetailsActivity.access$75(AppDetailsActivity.this) == 1)
        {
            view = new Intent(getApplicationContext(), com/aio/downloader/activity/MyMainActivity);
            view.putExtra("acquire_url_start", "");
            startActivity(view);
            finish();
            return;
        } else
        {
            finish();
            return;
        }
    }

    ()
    {
        this$0 = AppDetailsActivity.this;
        super();
    }
}
