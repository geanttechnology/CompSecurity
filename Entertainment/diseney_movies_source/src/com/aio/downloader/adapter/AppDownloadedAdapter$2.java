// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import com.aio.downloader.activity.VideoViewActivity;
import com.aio.downloader.mydownload.DownloadMovieItem;
import com.aio.downloader.utils.MyAppInfo;
import com.aio.downloader.utils.publicTools;

// Referenced classes of package com.aio.downloader.adapter:
//            AppDownloadedAdapter

class val.in_fo
    implements android.view.adedAdapter._cls2
{

    private String myVer_c;
    final AppDownloadedAdapter this$0;
    private final DownloadMovieItem val$in_fo;

    public void onClick(View view)
    {
        try
        {
            AppDownloadedAdapter.access$1(AppDownloadedAdapter.this, AppDownloadedAdapter.access$0(AppDownloadedAdapter.this).getPackageManager().getPackageInfo(val$in_fo.getFile_id(), 0));
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            AppDownloadedAdapter.access$1(AppDownloadedAdapter.this, null);
            view.printStackTrace();
        }
        view = new MyAppInfo(AppDownloadedAdapter.access$0(AppDownloadedAdapter.this));
        try
        {
            myVer_c = view.getAppVersion(val$in_fo.getFile_id());
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            view.printStackTrace();
        }
        Log.e("qwa", (new StringBuilder("n_fo.getMovieHeadImagePath()=")).append(val$in_fo.getMovieHeadImagePath()).append("myVer_c=").append(myVer_c).toString());
        Log.e("qwa", (new StringBuilder("++++++++++")).append(val$in_fo.getFile_id()).toString());
        if (!val$in_fo.getType().equals("video")) goto _L2; else goto _L1
_L1:
        view = new Intent(AppDownloadedAdapter.access$0(AppDownloadedAdapter.this), com/aio/downloader/activity/VideoViewActivity);
        view.putExtra("playurl", val$in_fo.getFilePath());
        AppDownloadedAdapter.access$0(AppDownloadedAdapter.this).startActivity(view);
_L4:
        return;
_L2:
        if (val$in_fo.getType().equals("mp3"))
        {
            view = new Intent();
            view.setAction("mymp3play");
            view.putExtra("mp3positiontitle", val$in_fo.getMovieName());
            view.putExtra("mp3position", val$in_fo.getFilePath());
            Log.v("mp3position", val$in_fo.getFilePath());
            AppDownloadedAdapter.access$0(AppDownloadedAdapter.this).sendBroadcast(view);
            return;
        }
        if (val$in_fo.getSerial() != 110)
        {
            break; /* Loop/switch isn't completed */
        }
        if (AppDownloadedAdapter.access$2(AppDownloadedAdapter.this) != null && val$in_fo.getMovieHeadImagePath().equals(myVer_c))
        {
            try
            {
                view = AppDownloadedAdapter.access$0(AppDownloadedAdapter.this).getPackageManager().getLaunchIntentForPackage(val$in_fo.getFile_id());
                AppDownloadedAdapter.access$0(AppDownloadedAdapter.this).startActivity(view);
                Log.v("sss", "2222");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                return;
            }
        }
        if (AppDownloadedAdapter.access$2(AppDownloadedAdapter.this) == null && val$in_fo.getSerial() != 110)
        {
            publicTools.openimgpath = val$in_fo.getMovieHeadImagePath();
            publicTools.opentitle = val$in_fo.getMovieName();
            publicTools.openid = val$in_fo.getFile_id();
            Log.v("sss", "11111");
            view = new Intent("android.intent.action.VIEW");
            view.setDataAndType(Uri.parse((new StringBuilder("file://")).append(val$in_fo.getFilePath()).toString()), "application/vnd.android.package-archive");
            AppDownloadedAdapter.access$0(AppDownloadedAdapter.this).startActivity(view);
            return;
        }
        if (AppDownloadedAdapter.access$2(AppDownloadedAdapter.this) != null && val$in_fo.getSerial() == 110)
        {
            publicTools.openimgpath = val$in_fo.getMovieHeadImagePath();
            publicTools.opentitle = val$in_fo.getMovieName();
            publicTools.openid = val$in_fo.getFile_id();
            Log.v("sss", "11111");
            view = new Intent("android.intent.action.VIEW");
            view.setDataAndType(Uri.parse((new StringBuilder("file://")).append(val$in_fo.getFilePath()).toString()), "application/vnd.android.package-archive");
            AppDownloadedAdapter.access$0(AppDownloadedAdapter.this).startActivity(view);
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (AppDownloadedAdapter.access$2(AppDownloadedAdapter.this) != null)
        {
            try
            {
                view = AppDownloadedAdapter.access$0(AppDownloadedAdapter.this).getPackageManager().getLaunchIntentForPackage(val$in_fo.getFile_id());
                AppDownloadedAdapter.access$0(AppDownloadedAdapter.this).startActivity(view);
                Log.v("sss", "2222");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                return;
            }
        }
        if (AppDownloadedAdapter.access$2(AppDownloadedAdapter.this) == null)
        {
            publicTools.openimgpath = val$in_fo.getMovieHeadImagePath();
            publicTools.opentitle = val$in_fo.getMovieName();
            publicTools.openid = val$in_fo.getFile_id();
            Log.v("sss", "11111");
            view = new Intent("android.intent.action.VIEW");
            view.setDataAndType(Uri.parse((new StringBuilder("file://")).append(val$in_fo.getFilePath()).toString()), "application/vnd.android.package-archive");
            AppDownloadedAdapter.access$0(AppDownloadedAdapter.this).startActivity(view);
            return;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    ption()
    {
        this$0 = final_appdownloadedadapter;
        val$in_fo = DownloadMovieItem.this;
        super();
    }
}
