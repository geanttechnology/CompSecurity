// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.aio.downloader.mydownload.DownloadMovieItem;
import java.util.ArrayList;

// Referenced classes of package com.aio.downloader.activity:
//            TodaysPickActivity, AppDetailsActivity

class this._cls0
    implements android.widget.ckListener
{

    final TodaysPickActivity this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = new Intent(TodaysPickActivity.this, com/aio/downloader/activity/AppDetailsActivity);
        adapterview.putExtra("myid", ((DownloadMovieItem)TodaysPickActivity.access$5(TodaysPickActivity.this).get(i)).getId());
        startActivity(adapterview);
    }

    ()
    {
        this$0 = TodaysPickActivity.this;
        super();
    }
}
