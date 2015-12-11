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
//            AppDetailsActivity

class this._cls0
    implements android.widget.kListener
{

    final AppDetailsActivity this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = new Intent(AppDetailsActivity.this, com/aio/downloader/activity/AppDetailsActivity);
        adapterview.putExtra("myid", ((DownloadMovieItem)AppDetailsActivity.access$71(AppDetailsActivity.this).get(i)).getId());
        startActivity(adapterview);
    }

    ()
    {
        this$0 = AppDetailsActivity.this;
        super();
    }
}
