// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.text.TextPaint;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.aio.downloader.db.TypeDbUtils;
import com.aio.downloader.mydownload.DownloadMovieItem;
import com.aio.downloader.mydownload.MyApplcation;
import com.aio.downloader.utils.MyAppInfo;
import com.aio.downloader.utils.ProgressWheel;
import com.aio.downloader.utils.publicTools;
import com.aio.downloader.views.HorizontalListView;
import com.umeng.analytics.MobclickAgent;
import java.util.ArrayList;
import java.util.List;
import net.tsz.afinal.FinalDBChen;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.aio.downloader.activity:
//            AppDetailsActivity

class this._cls0 extends AsyncTask
{

    final AppDetailsActivity this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient ArrayList doInBackground(Void avoid[])
    {
        String s;
        avoid = (new StringBuilder("http://android.downloadatoz.com/_201409/market/app_detail_more.php?url_id=")).append(AppDetailsActivity.access$21(AppDetailsActivity.this)).toString();
        s = publicTools.getUrl(avoid);
        Log.e("gak", (new StringBuilder(String.valueOf(avoid))).append("=====================jsonData=").append(s).toString());
        if (s != null) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        AppDetailsActivity.access$22(AppDetailsActivity.this, new ArrayList());
        avoid = new JSONObject(s);
        if (avoid.getInt("status") != 1) goto _L1; else goto _L3
_L3:
        AppDetailsActivity.access$23(AppDetailsActivity.this, new DownloadMovieItem());
        avoid = avoid.getJSONObject("pdt");
        AppDetailsActivity.access$18(AppDetailsActivity.this).setId(avoid.getString("id"));
        AppDetailsActivity.access$18(AppDetailsActivity.this).setTitle(avoid.getString("title"));
        AppDetailsActivity.access$18(AppDetailsActivity.this).setAuthor_title(avoid.getString("author_title"));
        AppDetailsActivity.access$18(AppDetailsActivity.this).setIcon(avoid.getString("icon"));
        AppDetailsActivity.access$18(AppDetailsActivity.this).setRating(Float.valueOf(Float.parseFloat(avoid.getString("rating"))));
        AppDetailsActivity.access$18(AppDetailsActivity.this).setVersion(avoid.getString("version"));
        AppDetailsActivity.access$18(AppDetailsActivity.this).setRelease_date(avoid.getString("release_date"));
        AppDetailsActivity.access$18(AppDetailsActivity.this).setDownloads(avoid.getString("downloads"));
        AppDetailsActivity.access$18(AppDetailsActivity.this).setSize(avoid.getString("size"));
        AppDetailsActivity.access$18(AppDetailsActivity.this).setPrice(avoid.getString("price"));
        AppDetailsActivity.access$18(AppDetailsActivity.this).setDetail(avoid.getString("detail"));
        AppDetailsActivity.access$18(AppDetailsActivity.this).setHas_apk(avoid.getString("has_apk"));
        AppDetailsActivity.access$18(AppDetailsActivity.this).setIs_official(avoid.getString("is_official"));
        AppDetailsActivity.access$18(AppDetailsActivity.this).setSerial(avoid.getInt("serial"));
        AppDetailsActivity.access$18(AppDetailsActivity.this).setSetCount(avoid.getString("rating_count"));
        AppDetailsActivity.access$18(AppDetailsActivity.this).setPpshort_desc(avoid.getString("short_desc"));
        avoid = avoid.getJSONArray("screenshots");
        int i = 0;
_L6:
        int j = avoid.length();
        if (i < j) goto _L5; else goto _L4
_L4:
        return AppDetailsActivity.access$24(AppDetailsActivity.this);
_L5:
        DownloadMovieItem downloadmovieitem = new DownloadMovieItem();
        downloadmovieitem.setScreenshots(avoid.getString(i));
        AppDetailsActivity.access$24(AppDetailsActivity.this).add(downloadmovieitem);
        i++;
          goto _L6
        avoid;
        avoid.printStackTrace();
          goto _L4
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((ArrayList)obj);
    }

    protected void onPostExecute(ArrayList arraylist)
    {
        super.onPostExecute(arraylist);
        if (arraylist == null)
        {
            if (AppDetailsActivity.access$17(AppDetailsActivity.this) == 0)
            {
                AppDetailsActivity.access$0(AppDetailsActivity.this).setVisibility(8);
                AppDetailsActivity.access$25(AppDetailsActivity.this).setVisibility(0);
                MobclickAgent.onEvent(getApplicationContext(), "acquire_fail");
                return;
            }
            if (AppDetailsActivity.access$26(AppDetailsActivity.this).queryfile(AppDetailsActivity.access$27(AppDetailsActivity.this)) == null && AppDetailsActivity.access$10(AppDetailsActivity.this).findItemsByWhereAndWhereValue("file_id", AppDetailsActivity.access$27(AppDetailsActivity.this), com/aio/downloader/mydownload/DownloadMovieItem, "downloadtask2", null).size() == 0)
            {
                arraylist = new MyAppInfo(getApplicationContext());
                try
                {
                    AppDetailsActivity.access$28(AppDetailsActivity.this, arraylist.getAppName(AppDetailsActivity.access$27(AppDetailsActivity.this)));
                    AppDetailsActivity.access$29(AppDetailsActivity.this, arraylist.getAppIcon(AppDetailsActivity.access$27(AppDetailsActivity.this)));
                }
                // Misplaced declaration of an exception variable
                catch (ArrayList arraylist)
                {
                    arraylist.printStackTrace();
                }
                MydownloadApk_Update(AppDetailsActivity.access$27(AppDetailsActivity.this), AppDetailsActivity.access$19(AppDetailsActivity.this), AppDetailsActivity.access$30(AppDetailsActivity.this), 110, AppDetailsActivity.drawableToBitmap(AppDetailsActivity.access$31(AppDetailsActivity.this)));
                AppDetailsActivity.access$32(AppDetailsActivity.this).setBackgroundResource(0x7f02006e);
                arraylist = new Intent("setbroadUpdate");
                sendBroadcast(arraylist);
                return;
            } else
            {
                arraylist = new Message();
                arraylist.what = 2;
                handler.sendMessage(arraylist);
                return;
            }
        }
        AppDetailsActivity.access$6(AppDetailsActivity.this).setVisibility(0);
        AppDetailsActivity.access$33(AppDetailsActivity.this).setVisibility(0);
        AppDetailsActivity.access$34(AppDetailsActivity.this).setVisibility(0);
        AppDetailsActivity.access$35(AppDetailsActivity.this).setVisibility(0);
        AppDetailsActivity.access$36(AppDetailsActivity.this).setVisibility(0);
        AppDetailsActivity.access$37(AppDetailsActivity.this).setVisibility(0);
        AppDetailsActivity.access$38(AppDetailsActivity.this).setVisibility(0);
        AppDetailsActivity.access$39(AppDetailsActivity.this).setVisibility(0);
        arraylist = null;
        android.content.pm.PackageInfo packageinfo = getPackageManager().getPackageInfo("com.freepezzle.hexcrush", 0);
        arraylist = packageinfo;
_L5:
        android.content.pm.undException undexception;
        if (arraylist != null)
        {
            AppDetailsActivity.access$40(AppDetailsActivity.this).setVisibility(8);
        } else
        {
            AppDetailsActivity.access$40(AppDetailsActivity.this).setVisibility(0);
        }
        AppDetailsActivity.access$41(AppDetailsActivity.this).fullScroll(33);
        AppDetailsActivity.access$42(AppDetailsActivity.this).asyncLoadImage(AppDetailsActivity.access$18(AppDetailsActivity.this).getIcon(), AppDetailsActivity.access$43(AppDetailsActivity.this));
        AppDetailsActivity.access$42(AppDetailsActivity.this).asyncLoadImage(AppDetailsActivity.access$18(AppDetailsActivity.this).getIcon(), AppDetailsActivity.access$44(AppDetailsActivity.this));
        AppDetailsActivity.access$45(AppDetailsActivity.this).setText(AppDetailsActivity.access$18(AppDetailsActivity.this).getTitle());
        AppDetailsActivity.access$46(AppDetailsActivity.this).setText(AppDetailsActivity.access$18(AppDetailsActivity.this).getTitle());
        AppDetailsActivity.access$47(AppDetailsActivity.this).setText(AppDetailsActivity.access$18(AppDetailsActivity.this).getAuthor_title());
        AppDetailsActivity.access$48(AppDetailsActivity.this).setRating(AppDetailsActivity.access$18(AppDetailsActivity.this).getRating().floatValue());
        AppDetailsActivity.access$49(AppDetailsActivity.this).setText((new StringBuilder("Version:")).append(AppDetailsActivity.access$18(AppDetailsActivity.this).getVersion()).toString());
        AppDetailsActivity.access$50(AppDetailsActivity.this).setText(AppDetailsActivity.access$18(AppDetailsActivity.this).getRelease_date());
        AppDetailsActivity.access$51(AppDetailsActivity.this).setText(AppDetailsActivity.access$18(AppDetailsActivity.this).getSize());
        AppDetailsActivity.access$52(AppDetailsActivity.this).setText((new StringBuilder("Downloads:")).append(AppDetailsActivity.access$18(AppDetailsActivity.this).getDownloads()).toString());
        AppDetailsActivity.access$53(AppDetailsActivity.this).setText((new StringBuilder(String.valueOf(AppDetailsActivity.access$18(AppDetailsActivity.this).getDetail()))).append("\n").toString());
        AppDetailsActivity.access$54(AppDetailsActivity.this).setText((new StringBuilder("(")).append(AppDetailsActivity.access$18(AppDetailsActivity.this).getSetCount()).append(")").toString());
        AppDetailsActivity.access$55(AppDetailsActivity.this).setText(AppDetailsActivity.access$18(AppDetailsActivity.this).getPpshort_desc());
        AppDetailsActivity.access$45(AppDetailsActivity.this).setTypeface(AppDetailsActivity.access$56(AppDetailsActivity.this));
        AppDetailsActivity.access$46(AppDetailsActivity.this).setTypeface(AppDetailsActivity.access$56(AppDetailsActivity.this));
        AppDetailsActivity.access$47(AppDetailsActivity.this).setTypeface(AppDetailsActivity.access$57(AppDetailsActivity.this));
        if (!AppDetailsActivity.access$18(AppDetailsActivity.this).getPrice().equals("FREE")) goto _L2; else goto _L1
_L1:
        AppDetailsActivity.access$58(AppDetailsActivity.this).setVisibility(8);
_L6:
        arraylist = AppDetailsActivity.access$18(AppDetailsActivity.this).getIs_official();
        if (!arraylist.equals("1")) goto _L4; else goto _L3
_L3:
        AppDetailsActivity.access$59(AppDetailsActivity.this).setVisibility(0);
_L8:
        try
        {
            AppDetailsActivity.access$34(AppDetailsActivity.this).setAdapter(new GalleryAdapter(AppDetailsActivity.this, AppDetailsActivity.this));
            AppDetailsActivity.access$34(AppDetailsActivity.this).setSelection(1);
        }
        // Misplaced declaration of an exception variable
        catch (ArrayList arraylist) { }
        try
        {
            AppDetailsActivity.access$0(AppDetailsActivity.this).setVisibility(8);
            if (AppDetailsActivity.access$18(AppDetailsActivity.this).getHas_apk().equals("1"))
            {
                AppDetailsActivity.access$60(AppDetailsActivity.this).setVisibility(0);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (ArrayList arraylist)
        {
            return;
        }
        break MISSING_BLOCK_LABEL_1038;
        undexception;
        undexception.printStackTrace();
          goto _L5
_L2:
        AppDetailsActivity.access$58(AppDetailsActivity.this).setText(AppDetailsActivity.access$18(AppDetailsActivity.this).getPrice());
        AppDetailsActivity.access$58(AppDetailsActivity.this).getPaint().setFlags(16);
          goto _L6
_L4:
        if (!arraylist.equals("0")) goto _L8; else goto _L7
_L7:
        AppDetailsActivity.access$59(AppDetailsActivity.this).setVisibility(8);
          goto _L8
        arraylist;
          goto _L8
        AppDetailsActivity.access$18(AppDetailsActivity.this).getHas_apk().equals("0");
        return;
          goto _L6
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        AppDetailsActivity.access$0(AppDetailsActivity.this).setVisibility(0);
    }

    ion()
    {
        this$0 = AppDetailsActivity.this;
        super();
    }
}
