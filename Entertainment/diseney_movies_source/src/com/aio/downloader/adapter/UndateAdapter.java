// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.aio.downloader.activity.AppDetailsActivity;
import com.aio.downloader.mydownload.ContentValue;
import com.aio.downloader.mydownload.DownloadMovieItem;
import com.aio.downloader.utils.MyAppInfo;
import java.util.ArrayList;

public class UndateAdapter extends BaseAdapter
    implements ContentValue
{
    class ViewHolder
    {

        private ImageView icon;
        private TextView name;
        private RelativeLayout rl_update;
        final UndateAdapter this$0;
        private TextView tv_current_version_list;
        private TextView tv_uninstall1;
        private TextView tv_uninstall_size;
        private TextView tv_updata_version_list;
        private View view_up;

















        ViewHolder()
        {
            this$0 = UndateAdapter.this;
            super();
        }
    }


    private Context ctx;
    ViewHolder holder;
    private ArrayList list_update;
    private Typeface typeFace;
    private Typeface typeFace2;

    public UndateAdapter(Context context, ArrayList arraylist)
    {
        typeFace = null;
        typeFace2 = null;
        holder = null;
        ctx = context;
        list_update = arraylist;
        try
        {
            typeFace = Typeface.createFromAsset(context.getAssets(), "Roboto-Light.ttf");
            typeFace2 = Typeface.createFromAsset(context.getAssets(), "Roboto-Condensed.ttf");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
    }

    public int getCount()
    {
        return list_update.size();
    }

    public Object getItem(int i)
    {
        return Integer.valueOf(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(final int position, View view, ViewGroup viewgroup)
    {
        Object obj;
        if (view == null)
        {
            holder = new ViewHolder();
            view = View.inflate(ctx, 0x7f0300b9, null);
            holder.icon = (ImageView)view.findViewById(0x7f0703e4);
            holder.name = (TextView)view.findViewById(0x7f0703e5);
            holder.tv_current_version_list = (TextView)view.findViewById(0x7f0703e6);
            holder.tv_updata_version_list = (TextView)view.findViewById(0x7f0703e7);
            holder.tv_uninstall_size = (TextView)view.findViewById(0x7f0703e8);
            holder.tv_uninstall1 = (TextView)view.findViewById(0x7f0703e9);
            holder.rl_update = (RelativeLayout)view.findViewById(0x7f0703e3);
            holder.view_up = view.findViewById(0x7f0702f8);
            view.setTag(holder);
        } else
        {
            holder = (ViewHolder)view.getTag();
        }
        if (position == 0)
        {
            holder.view_up.setVisibility(0);
        } else
        {
            holder.view_up.setVisibility(8);
        }
        holder.name.setTypeface(typeFace);
        holder.tv_current_version_list.setTypeface(typeFace2);
        holder.tv_updata_version_list.setTypeface(typeFace2);
        holder.tv_uninstall_size.setTypeface(typeFace2);
        obj = new MyAppInfo(ctx);
        try
        {
            viewgroup = ((MyAppInfo) (obj)).getAppName(((DownloadMovieItem)list_update.get(position)).getId());
            String s = ((MyAppInfo) (obj)).getAppVersion(((DownloadMovieItem)list_update.get(position)).getId());
            obj = ((MyAppInfo) (obj)).getAppIcon(((DownloadMovieItem)list_update.get(position)).getId());
            holder.icon.setBackgroundDrawable(((android.graphics.drawable.Drawable) (obj)));
            holder.name.setText(viewgroup);
            holder.tv_current_version_list.setText(s);
            holder.tv_updata_version_list.setText(((DownloadMovieItem)list_update.get(position)).getVersion());
            holder.tv_uninstall_size.setText(((DownloadMovieItem)list_update.get(position)).getSize());
        }
        // Misplaced declaration of an exception variable
        catch (ViewGroup viewgroup)
        {
            viewgroup.printStackTrace();
        }
        holder.rl_update.setOnClickListener(new android.view.View.OnClickListener() {

            final UndateAdapter this$0;
            private final int val$position;

            public void onClick(View view1)
            {
                view1 = new Intent(ctx, com/aio/downloader/activity/AppDetailsActivity);
                view1.putExtra("myid", ((DownloadMovieItem)list_update.get(position)).getId());
                view1.putExtra("linkurl", ((DownloadMovieItem)list_update.get(position)).getLink_url());
                view1.putExtra("myupver", ((DownloadMovieItem)list_update.get(position)).getVersion());
                view1.putExtra("wocao", 1);
                view1.setFlags(0x10000000);
                ctx.startActivity(view1);
            }

            
            {
                this$0 = UndateAdapter.this;
                position = i;
                super();
            }
        });
        holder.tv_uninstall1.setOnClickListener(new android.view.View.OnClickListener() {

            final UndateAdapter this$0;
            private final int val$position;

            public void onClick(View view1)
            {
                view1 = new Intent(ctx, com/aio/downloader/activity/AppDetailsActivity);
                view1.putExtra("myid", ((DownloadMovieItem)list_update.get(position)).getId());
                view1.putExtra("linkurl", ((DownloadMovieItem)list_update.get(position)).getLink_url());
                view1.putExtra("myupver", ((DownloadMovieItem)list_update.get(position)).getVersion());
                view1.putExtra("wocao", 1);
                view1.setFlags(0x10000000);
                ctx.startActivity(view1);
            }

            
            {
                this$0 = UndateAdapter.this;
                position = i;
                super();
            }
        });
        return view;
    }


}
