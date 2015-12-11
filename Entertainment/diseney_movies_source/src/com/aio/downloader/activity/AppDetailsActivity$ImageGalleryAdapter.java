// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.aio.downloader.mydownload.DownloadMovieItem;
import com.aio.downloader.mydownload.MyApplcation;
import java.util.ArrayList;

// Referenced classes of package com.aio.downloader.activity:
//            AppDetailsActivity

private class ctx extends BaseAdapter
{

    private Context ctx;
    private ImageView image;
    final AppDetailsActivity this$0;

    public int getCount()
    {
        return AppDetailsActivity.access$24(AppDetailsActivity.this).size();
    }

    public Object getItem(int i)
    {
        return Integer.valueOf(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        viewgroup = view;
        if (view == null)
        {
            AppDetailsActivity.access$61(AppDetailsActivity.this, LayoutInflater.from(ctx));
            viewgroup = AppDetailsActivity.access$62(AppDetailsActivity.this).inflate(0x7f03005f, null);
            image = (ImageView)viewgroup.findViewById(0x7f070245);
        }
        AppDetailsActivity.access$42(AppDetailsActivity.this).asyncLoadImage1(((DownloadMovieItem)AppDetailsActivity.access$24(AppDetailsActivity.this).get(i)).getScreenshots(), image);
        return viewgroup;
    }

    public (Context context)
    {
        this$0 = AppDetailsActivity.this;
        super();
        ctx = context;
    }
}
