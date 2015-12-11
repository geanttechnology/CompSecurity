// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.aio.downloader.activity.AppDetailsActivity;
import com.aio.downloader.mydownload.DownloadMovieItem;
import java.util.ArrayList;

// Referenced classes of package com.aio.downloader.adapter:
//            UndateAdapter

class val.position
    implements android.view.ener
{

    final UndateAdapter this$0;
    private final int val$position;

    public void onClick(View view)
    {
        view = new Intent(UndateAdapter.access$0(UndateAdapter.this), com/aio/downloader/activity/AppDetailsActivity);
        view.putExtra("myid", ((DownloadMovieItem)UndateAdapter.access$1(UndateAdapter.this).get(val$position)).getId());
        view.putExtra("linkurl", ((DownloadMovieItem)UndateAdapter.access$1(UndateAdapter.this).get(val$position)).getLink_url());
        view.putExtra("myupver", ((DownloadMovieItem)UndateAdapter.access$1(UndateAdapter.this).get(val$position)).getVersion());
        view.putExtra("wocao", 1);
        view.setFlags(0x10000000);
        UndateAdapter.access$0(UndateAdapter.this).startActivity(view);
    }

    Item()
    {
        this$0 = final_undateadapter;
        val$position = I.this;
        super();
    }
}
