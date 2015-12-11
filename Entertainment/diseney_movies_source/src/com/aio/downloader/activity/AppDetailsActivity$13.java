// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

// Referenced classes of package com.aio.downloader.activity:
//            AppDetailsActivity, ImagePagerActivity

class this._cls0
    implements android.widget.kListener
{

    final AppDetailsActivity this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        Log.e("www", (new StringBuilder("(Serializable) list")).append(AppDetailsActivity.access$24(AppDetailsActivity.this)).toString());
        adapterview = new Intent(AppDetailsActivity.this, com/aio/downloader/activity/ImagePagerActivity);
        adapterview.putExtra("screenshotlist", AppDetailsActivity.access$24(AppDetailsActivity.this));
        adapterview.putExtra("screenshotpos", i);
        startActivity(adapterview);
    }

    ()
    {
        this$0 = AppDetailsActivity.this;
        super();
    }
}
