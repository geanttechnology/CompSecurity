// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.adapter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.format.Formatter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.aio.downloader.activity.VideoViewActivity;
import com.aio.downloader.mydownload.DownloadMovieItem;
import com.aio.downloader.mydownload.MyApplcation;
import com.aio.downloader.utils.MyAppInfo;
import com.aio.downloader.utils.publicTools;
import java.util.List;

public class AppDownloadedAdapter extends BaseAdapter
{
    class ViewHolder
    {

        private ImageView my_delete_movie;
        private TextView my_movie_name_item;
        private TextView my_stop_download_bt;
        private ImageView my_test_head_image;
        private TextView my_totalsize;
        final AppDownloadedAdapter this$0;











        ViewHolder()
        {
            this$0 = AppDownloadedAdapter.this;
            super();
        }
    }


    private final String ACTION_NAME_VER = "wocaonima";
    private MyApplcation app;
    private Context ctx;
    ViewHolder holder;
    private List list;
    private BroadcastReceiver mBroadcastReceiver;
    private String myVer;
    private PackageInfo packageInfo;
    private Typeface typeFace;

    public AppDownloadedAdapter(Context context, List list1)
    {
        packageInfo = null;
        typeFace = null;
        holder = null;
        mBroadcastReceiver = new BroadcastReceiver() {

            final AppDownloadedAdapter this$0;

            public void onReceive(Context context1, Intent intent)
            {
                context1 = intent.getAction();
                intent.getIntExtra("MyUpver", 0);
                if (context1.equals("wocaonima"))
                {
                    holder.my_stop_download_bt.setText("Open");
                }
            }

            
            {
                this$0 = AppDownloadedAdapter.this;
                super();
            }
        };
        ctx = context;
        list = list1;
        try
        {
            app = (MyApplcation)context.getApplicationContext();
        }
        // Misplaced declaration of an exception variable
        catch (List list1) { }
        try
        {
            typeFace = Typeface.createFromAsset(context.getAssets(), "Roboto-Light.ttf");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
    }

    public static Drawable bitmapToDrawble(Bitmap bitmap, Context context)
    {
        return new BitmapDrawable(context.getResources(), bitmap);
    }

    public int getCount()
    {
        if (list != null && list.size() > 0)
        {
            return list.size();
        } else
        {
            return 0;
        }
    }

    public Object getItem(int i)
    {
        return list.get(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(final int position, View view, final ViewGroup in_fo)
    {
        Log.v("oiu", "cccccccccc");
        in_fo = (DownloadMovieItem)list.get(position);
        if (view == null)
        {
            holder = new ViewHolder();
            view = View.inflate(ctx, 0x7f030015, null);
            holder.my_delete_movie = (ImageView)view.findViewById(0x7f0700ee);
            holder.my_test_head_image = (ImageView)view.findViewById(0x7f0700ef);
            holder.my_movie_name_item = (TextView)view.findViewById(0x7f0700f0);
            holder.my_totalsize = (TextView)view.findViewById(0x7f0700f1);
            holder.my_stop_download_bt = (TextView)view.findViewById(0x7f0700f2);
            view.setTag(holder);
        } else
        {
            holder = (ViewHolder)view.getTag();
        }
        try
        {
            holder.my_totalsize.setText(Formatter.formatFileSize(ctx, Long.parseLong(in_fo.getFileSize())));
        }
        catch (Exception exception2) { }
        holder.my_movie_name_item.setText(in_fo.getMovieName());
        if (in_fo.getSerial() != 110)
        {
            try
            {
                app.asyncLoadImage(in_fo.getMovieHeadImagePath(), holder.my_test_head_image);
            }
            catch (Exception exception1) { }
        }
        try
        {
            packageInfo = ctx.getPackageManager().getPackageInfo(in_fo.getFile_id(), 0);
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            Log.e("qwa", "catch");
            packageInfo = null;
            namenotfoundexception.printStackTrace();
        }
        if (packageInfo != null && in_fo.getSerial() != 110)
        {
            holder.my_stop_download_bt.setText("Open");
        } else
        {
            holder.my_stop_download_bt.setText("Install");
        }
        Log.e("qwa", (new StringBuilder("in_fo.getSerial()=")).append(in_fo.getSerial()).append("in_fo.getFile_id()=").append(in_fo.getFile_id()).append("packageInfo=").append(packageInfo).toString());
        if (in_fo.getSerial() == 110 && packageInfo != null)
        {
            holder.my_stop_download_bt.setText("Update");
            Object obj = new MyAppInfo(ctx);
            try
            {
                Drawable drawable = ((MyAppInfo) (obj)).getAppIcon(in_fo.getFile_id());
                myVer = ((MyAppInfo) (obj)).getAppVersion(in_fo.getFile_id());
                holder.my_test_head_image.setBackgroundDrawable(drawable);
            }
            catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception1)
            {
                namenotfoundexception1.printStackTrace();
            }
        }
        if (in_fo.getType().equals("mp3") || in_fo.getType().equals("video"))
        {
            holder.my_stop_download_bt.setText("Play");
        }
        obj = new IntentFilter();
        ((IntentFilter) (obj)).addAction("wocaonima");
        ctx.registerReceiver(mBroadcastReceiver, ((IntentFilter) (obj)));
        try
        {
            if (in_fo.getMovieHeadImagePath().equals(myVer) && packageInfo != null)
            {
                holder.my_stop_download_bt.setText("Open");
            }
        }
        catch (Exception exception) { }
        holder.my_stop_download_bt.setOnClickListener(new android.view.View.OnClickListener() {

            private String myVer_c;
            final AppDownloadedAdapter this$0;
            private final DownloadMovieItem val$in_fo;

            public void onClick(View view1)
            {
                try
                {
                    packageInfo = ctx.getPackageManager().getPackageInfo(in_fo.getFile_id(), 0);
                }
                // Misplaced declaration of an exception variable
                catch (View view1)
                {
                    packageInfo = null;
                    view1.printStackTrace();
                }
                view1 = new MyAppInfo(ctx);
                try
                {
                    myVer_c = view1.getAppVersion(in_fo.getFile_id());
                }
                // Misplaced declaration of an exception variable
                catch (View view1)
                {
                    view1.printStackTrace();
                }
                Log.e("qwa", (new StringBuilder("n_fo.getMovieHeadImagePath()=")).append(in_fo.getMovieHeadImagePath()).append("myVer_c=").append(myVer_c).toString());
                Log.e("qwa", (new StringBuilder("++++++++++")).append(in_fo.getFile_id()).toString());
                if (!in_fo.getType().equals("video")) goto _L2; else goto _L1
_L1:
                view1 = new Intent(ctx, com/aio/downloader/activity/VideoViewActivity);
                view1.putExtra("playurl", in_fo.getFilePath());
                ctx.startActivity(view1);
_L4:
                return;
_L2:
                if (in_fo.getType().equals("mp3"))
                {
                    view1 = new Intent();
                    view1.setAction("mymp3play");
                    view1.putExtra("mp3positiontitle", in_fo.getMovieName());
                    view1.putExtra("mp3position", in_fo.getFilePath());
                    Log.v("mp3position", in_fo.getFilePath());
                    ctx.sendBroadcast(view1);
                    return;
                }
                if (in_fo.getSerial() != 110)
                {
                    break; /* Loop/switch isn't completed */
                }
                if (packageInfo != null && in_fo.getMovieHeadImagePath().equals(myVer_c))
                {
                    try
                    {
                        view1 = ctx.getPackageManager().getLaunchIntentForPackage(in_fo.getFile_id());
                        ctx.startActivity(view1);
                        Log.v("sss", "2222");
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view1)
                    {
                        return;
                    }
                }
                if (packageInfo == null && in_fo.getSerial() != 110)
                {
                    publicTools.openimgpath = in_fo.getMovieHeadImagePath();
                    publicTools.opentitle = in_fo.getMovieName();
                    publicTools.openid = in_fo.getFile_id();
                    Log.v("sss", "11111");
                    view1 = new Intent("android.intent.action.VIEW");
                    view1.setDataAndType(Uri.parse((new StringBuilder("file://")).append(in_fo.getFilePath()).toString()), "application/vnd.android.package-archive");
                    ctx.startActivity(view1);
                    return;
                }
                if (packageInfo != null && in_fo.getSerial() == 110)
                {
                    publicTools.openimgpath = in_fo.getMovieHeadImagePath();
                    publicTools.opentitle = in_fo.getMovieName();
                    publicTools.openid = in_fo.getFile_id();
                    Log.v("sss", "11111");
                    view1 = new Intent("android.intent.action.VIEW");
                    view1.setDataAndType(Uri.parse((new StringBuilder("file://")).append(in_fo.getFilePath()).toString()), "application/vnd.android.package-archive");
                    ctx.startActivity(view1);
                    return;
                }
                if (true) goto _L4; else goto _L3
_L3:
                if (packageInfo != null)
                {
                    try
                    {
                        view1 = ctx.getPackageManager().getLaunchIntentForPackage(in_fo.getFile_id());
                        ctx.startActivity(view1);
                        Log.v("sss", "2222");
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view1)
                    {
                        return;
                    }
                }
                if (packageInfo == null)
                {
                    publicTools.openimgpath = in_fo.getMovieHeadImagePath();
                    publicTools.opentitle = in_fo.getMovieName();
                    publicTools.openid = in_fo.getFile_id();
                    Log.v("sss", "11111");
                    view1 = new Intent("android.intent.action.VIEW");
                    view1.setDataAndType(Uri.parse((new StringBuilder("file://")).append(in_fo.getFilePath()).toString()), "application/vnd.android.package-archive");
                    ctx.startActivity(view1);
                    return;
                }
                if (true) goto _L4; else goto _L5
_L5:
            }

            
            {
                this$0 = AppDownloadedAdapter.this;
                in_fo = downloadmovieitem;
                super();
            }
        });
        holder.my_delete_movie.setOnClickListener(new android.view.View.OnClickListener() {

            final AppDownloadedAdapter this$0;
            private final int val$position;

            public void onClick(View view1)
            {
                view1 = new Intent();
                view1.setAction("delete");
                view1.putExtra("position", position);
                ctx.sendBroadcast(view1);
            }

            
            {
                this$0 = AppDownloadedAdapter.this;
                position = i;
                super();
            }
        });
        return view;
    }



}
