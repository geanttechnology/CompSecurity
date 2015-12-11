// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.content.Intent;
import android.view.View;
import com.aio.downloader.mydownload.DownloadMovieItem;

// Referenced classes of package com.aio.downloader.activity:
//            AppDetailsActivity, AppDetatils_moreActivity

class this._cls0
    implements android.view.ilsActivity._cls25
{

    final AppDetailsActivity this$0;

    public void onClick(View view)
    {
        view = new Intent(getApplicationContext(), com/aio/downloader/activity/AppDetatils_moreActivity);
        view.putExtra("dea_title", AppDetailsActivity.access$18(AppDetailsActivity.this).getTitle());
        view.putExtra("dea_sheart", AppDetailsActivity.access$18(AppDetailsActivity.this).getPpshort_desc());
        view.putExtra("dea_dea", AppDetailsActivity.access$18(AppDetailsActivity.this).getDetail());
        view.putExtra("dea_up", AppDetailsActivity.access$18(AppDetailsActivity.this).getRelease_date());
        view.putExtra("dea_ver", AppDetailsActivity.access$18(AppDetailsActivity.this).getVersion());
        view.putExtra("dea_down", AppDetailsActivity.access$18(AppDetailsActivity.this).getDownloads());
        view.putExtra("dea_size", AppDetailsActivity.access$18(AppDetailsActivity.this).getSize());
        startActivity(view);
    }

    ty()
    {
        this$0 = AppDetailsActivity.this;
        super();
    }
}
