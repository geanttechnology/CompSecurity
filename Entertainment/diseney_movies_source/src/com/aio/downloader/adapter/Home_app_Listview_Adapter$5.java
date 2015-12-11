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
//            Home_app_Listview_Adapter

class val.list
    implements android.view.iew_Adapter._cls5
{

    final Home_app_Listview_Adapter this$0;
    private final ArrayList val$list;

    public void onClick(View view)
    {
        view = new Intent(Home_app_Listview_Adapter.access$0(Home_app_Listview_Adapter.this), com/aio/downloader/activity/AppDetailsActivity);
        view.putExtra("myid", ((DownloadMovieItem)val$list.get(0)).getBannerid());
        Home_app_Listview_Adapter.access$0(Home_app_Listview_Adapter.this).startActivity(view);
    }

    ()
    {
        this$0 = final_home_app_listview_adapter;
        val$list = ArrayList.this;
        super();
    }
}
