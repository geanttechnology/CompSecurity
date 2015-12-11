// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import com.aio.downloader.activity.AppDetailsActivity;
import com.aio.downloader.mydownload.DownloadMovieItem;
import java.util.ArrayList;

// Referenced classes of package com.aio.downloader.adapter:
//            Home_app_Listview_Adapter

class val.list
    implements android.widget.ner
{

    final Home_app_Listview_Adapter this$0;
    private final ArrayList val$list;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = new Intent(Home_app_Listview_Adapter.access$0(Home_app_Listview_Adapter.this), com/aio/downloader/activity/AppDetailsActivity);
        adapterview.putExtra("myid", ((DownloadMovieItem)val$list.get(i)).getId());
        Log.e("bbb", (new StringBuilder("id=")).append(((DownloadMovieItem)val$list.get(i)).getId()).toString());
        Home_app_Listview_Adapter.access$0(Home_app_Listview_Adapter.this).startActivity(adapterview);
    }

    ()
    {
        this$0 = final_home_app_listview_adapter;
        val$list = ArrayList.this;
        super();
    }
}
