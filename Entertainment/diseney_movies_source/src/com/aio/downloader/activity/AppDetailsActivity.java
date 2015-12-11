// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.aio.downloader.adapter.Home_Gridview_Adapter;
import com.aio.downloader.db.TypeDbUtils;
import com.aio.downloader.dialog.LianwangDialog;
import com.aio.downloader.mydownload.BaseActivity;
import com.aio.downloader.mydownload.DownloadMovieItem;
import com.aio.downloader.mydownload.MyApplcation;
import com.aio.downloader.utils.DisplayUtil;
import com.aio.downloader.utils.MyAppInfo;
import com.aio.downloader.utils.Myutils;
import com.aio.downloader.utils.NetWorkUtil;
import com.aio.downloader.utils.ProgressWheel;
import com.aio.downloader.utils.SharedPreferencesConfig;
import com.aio.downloader.utils.publicTools;
import com.aio.downloader.views.BadgeView;
import com.aio.downloader.views.HorizontalListView;
import com.aio.downloader.views.LImageButton;
import com.aio.downloader.views.MyGridView;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.NativeAd;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;
import com.umeng.analytics.MobclickAgent;
import java.io.File;
import java.io.FileInputStream;
import java.net.CookieManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.tsz.afinal.FinalDBChen;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.aio.downloader.activity:
//            AppRecommendKeywordsActivity, AppActivity1, DownloadAppManager, MusthaveActivity, 
//            PaidforFreeActivity1, MyMainActivity, ImagePagerActivity, AppDetatils_moreActivity

public class AppDetailsActivity extends BaseActivity
    implements android.view.View.OnClickListener, AdListener
{
    private class ImageGalleryAdapter extends BaseAdapter
    {

        private Context ctx;
        private ImageView image;
        final AppDetailsActivity this$0;

        public int getCount()
        {
            return list.size();
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
                inflate = LayoutInflater.from(ctx);
                viewgroup = inflate.inflate(0x7f03005f, null);
                image = (ImageView)viewgroup.findViewById(0x7f070245);
            }
            app.asyncLoadImage1(((DownloadMovieItem)list.get(i)).getScreenshots(), image);
            return viewgroup;
        }

        public ImageGalleryAdapter(Context context)
        {
            this$0 = AppDetailsActivity.this;
            super();
            ctx = context;
        }
    }

    class Mya1 extends AsyncTask
    {

        final AppDetailsActivity this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient ArrayList doInBackground(Void avoid[])
        {
            String s;
            avoid = (new StringBuilder("http://android.downloadatoz.com/_201409/market/app_detail_more.php?url_id=")).append(id).toString();
            s = publicTools.getUrl(avoid);
            Log.e("gak", (new StringBuilder(String.valueOf(avoid))).append("=====================jsonData=").append(s).toString());
            if (s != null) goto _L2; else goto _L1
_L1:
            return null;
_L2:
            list = new ArrayList();
            avoid = new JSONObject(s);
            if (avoid.getInt("status") != 1) goto _L1; else goto _L3
_L3:
            model = new DownloadMovieItem();
            avoid = avoid.getJSONObject("pdt");
            model.setId(avoid.getString("id"));
            model.setTitle(avoid.getString("title"));
            model.setAuthor_title(avoid.getString("author_title"));
            model.setIcon(avoid.getString("icon"));
            model.setRating(Float.valueOf(Float.parseFloat(avoid.getString("rating"))));
            model.setVersion(avoid.getString("version"));
            model.setRelease_date(avoid.getString("release_date"));
            model.setDownloads(avoid.getString("downloads"));
            model.setSize(avoid.getString("size"));
            model.setPrice(avoid.getString("price"));
            model.setDetail(avoid.getString("detail"));
            model.setHas_apk(avoid.getString("has_apk"));
            model.setIs_official(avoid.getString("is_official"));
            model.setSerial(avoid.getInt("serial"));
            model.setSetCount(avoid.getString("rating_count"));
            model.setPpshort_desc(avoid.getString("short_desc"));
            avoid = avoid.getJSONArray("screenshots");
            int i = 0;
_L6:
            int j = avoid.length();
            if (i < j) goto _L5; else goto _L4
_L4:
            return list;
_L5:
            DownloadMovieItem downloadmovieitem = new DownloadMovieItem();
            downloadmovieitem.setScreenshots(avoid.getString(i));
            list.add(downloadmovieitem);
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
                if (wocao == 0)
                {
                    progress_wheel.setVisibility(8);
                    rl_sad.setVisibility(0);
                    MobclickAgent.onEvent(getApplicationContext(), "acquire_fail");
                    return;
                }
                if (dbUtils.queryfile(wycmyid) == null && db.findItemsByWhereAndWhereValue("file_id", wycmyid, com/aio/downloader/mydownload/DownloadMovieItem, "downloadtask2", null).size() == 0)
                {
                    arraylist = new MyAppInfo(getApplicationContext());
                    try
                    {
                        appName = arraylist.getAppName(wycmyid);
                        appIcon2 = arraylist.getAppIcon(wycmyid);
                    }
                    // Misplaced declaration of an exception variable
                    catch (ArrayList arraylist)
                    {
                        arraylist.printStackTrace();
                    }
                    MydownloadApk_Update(wycmyid, appName, myUpver, 110, AppDetailsActivity.drawableToBitmap(appIcon2));
                    bt_dea_download.setBackgroundResource(0x7f02006e);
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
            detailtoprel.setVisibility(0);
            ll_dea_sh.setVisibility(0);
            mygallery.setVisibility(0);
            ll_gall.setVisibility(0);
            view1.setVisibility(0);
            view2.setVisibility(0);
            tv_readmore.setVisibility(0);
            rl_yuancheng.setVisibility(0);
            arraylist = null;
            PackageInfo packageinfo = getPackageManager().getPackageInfo("com.freepezzle.hexcrush", 0);
            arraylist = packageinfo;
_L5:
            android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
            if (arraylist != null)
            {
                ll_free.setVisibility(8);
            } else
            {
                ll_free.setVisibility(0);
            }
            detailscroll.fullScroll(33);
            app.asyncLoadImage(model.getIcon(), appdetailicon);
            app.asyncLoadImage(model.getIcon(), appdetailicon1);
            appdetailtitle.setText(model.getTitle());
            appdetailtitle1.setText(model.getTitle());
            appdetailauthortitle.setText(model.getAuthor_title());
            appdetailratingbar.setRating(model.getRating().floatValue());
            version.setText((new StringBuilder("Version:")).append(model.getVersion()).toString());
            date.setText(model.getRelease_date());
            device.setText(model.getSize());
            downloads.setText((new StringBuilder("Downloads:")).append(model.getDownloads()).toString());
            detail.setText((new StringBuilder(String.valueOf(model.getDetail()))).append("\n").toString());
            tv_rating_count.setText((new StringBuilder("(")).append(model.getSetCount()).append(")").toString());
            tv_short_desc.setText(model.getPpshort_desc());
            appdetailtitle.setTypeface(typeFace);
            appdetailtitle1.setTypeface(typeFace);
            appdetailauthortitle.setTypeface(typeFace2);
            if (!model.getPrice().equals("FREE")) goto _L2; else goto _L1
_L1:
            tv_price.setVisibility(8);
_L6:
            arraylist = model.getIs_official();
            if (!arraylist.equals("1")) goto _L4; else goto _L3
_L3:
            detailplaytop.setVisibility(0);
_L8:
            try
            {
                mygallery.setAdapter(new ImageGalleryAdapter(AppDetailsActivity.this));
                mygallery.setSelection(1);
            }
            // Misplaced declaration of an exception variable
            catch (ArrayList arraylist) { }
            try
            {
                progress_wheel.setVisibility(8);
                if (model.getHas_apk().equals("1"))
                {
                    downloadapk.setVisibility(0);
                    return;
                }
            }
            // Misplaced declaration of an exception variable
            catch (ArrayList arraylist)
            {
                return;
            }
            break MISSING_BLOCK_LABEL_1038;
            namenotfoundexception;
            namenotfoundexception.printStackTrace();
              goto _L5
_L2:
            tv_price.setText(model.getPrice());
            tv_price.getPaint().setFlags(16);
              goto _L6
_L4:
            if (!arraylist.equals("0")) goto _L8; else goto _L7
_L7:
            detailplaytop.setVisibility(8);
              goto _L8
            arraylist;
              goto _L8
            model.getHas_apk().equals("0");
            return;
              goto _L6
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            progress_wheel.setVisibility(0);
        }

        Mya1()
        {
            this$0 = AppDetailsActivity.this;
            super();
        }
    }

    class Myagv extends AsyncTask
    {

        final AppDetailsActivity this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient String doInBackground(Void avoid[])
        {
            String s = publicTools.getUrl("http://android.downloadatoz.com/_201409/market/app_list_more_test.php?tab=aio_ad_1");
            avoid = s;
            if (s == null)
            {
                avoid = null;
            }
            return avoid;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((String)obj);
        }

        protected void onPostExecute(String s)
        {
            if (s == null)
            {
                return;
            } else
            {
                ShowResult(s);
                detailline.setVisibility(0);
                return;
            }
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            progress_wheel.setVisibility(0);
        }

        Myagv()
        {
            this$0 = AppDetailsActivity.this;
            super();
        }
    }

    class Myagv1 extends AsyncTask
    {

        final AppDetailsActivity this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient String doInBackground(Void avoid[])
        {
            String s = publicTools.getUrl("http://android.downloadatoz.com/_201409/market/app_list_more_test.php?tab=aio_ad_2");
            avoid = s;
            if (s == null)
            {
                avoid = null;
            }
            return avoid;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((String)obj);
        }

        protected void onPostExecute(String s)
        {
            if (s == null)
            {
                return;
            } else
            {
                ShowResult1(s);
                detaillinewyc1.setVisibility(0);
                return;
            }
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            progress_wheel.setVisibility(0);
        }

        Myagv1()
        {
            this$0 = AppDetailsActivity.this;
            super();
        }
    }

    class Myagv2 extends AsyncTask
    {

        final AppDetailsActivity this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient String doInBackground(Void avoid[])
        {
            String s = publicTools.getUrl("http://android.downloadatoz.com/_201409/market/app_list_more_test.php?tab=aio_ad_3");
            avoid = s;
            if (s == null)
            {
                avoid = null;
            }
            return avoid;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((String)obj);
        }

        protected void onPostExecute(String s)
        {
            if (s == null)
            {
                return;
            } else
            {
                ShowResult2(s);
                detaillinewyc2.setVisibility(0);
                return;
            }
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            progress_wheel.setVisibility(0);
        }

        Myagv2()
        {
            this$0 = AppDetailsActivity.this;
            super();
        }
    }


    public static CookieManager cookieManager;
    public static final String secret = "this_is_mobile_2014";
    private final String ACTION_NAME_UPDATE_UPDATE = "setbroadUpdate";
    private File AIOBATTERY;
    private File AIOBATTERYAPK;
    private File AIOCALLERAPK;
    private File AIOCALLERDOWN;
    private File AIOCRUSHAPK;
    private File AIOCRUSHSWF;
    private File AIOFREE;
    private File AIOFREEAPK;
    private final String PDTPAUSE = "pdtpause";
    private final String PDTSTART = "pdtstart";
    private File PRO_DIR;
    private File PRO_DIR_FOME;
    private File PRO_DIR_TO;
    private com.facebook.ads.AdView adView;
    private Home_Gridview_Adapter adapter;
    private MyApplcation app;
    private Drawable appIcon2;
    private String appName;
    private RatingBar app_ratingbar;
    private TextView appauthortitle;
    private BroadcastReceiver appdetail;
    private TextView appdetailauthortitle;
    private LImageButton appdetaildown;
    private GridView appdetailgv;
    private MyGridView appdetailgvwyc1;
    private MyGridView appdetailgvwyc2;
    private ImageView appdetailicon;
    private ImageView appdetailicon1;
    private RatingBar appdetailratingbar;
    private LImageButton appdetailsearch;
    private TextView appdetailtitle;
    private TextView appdetailtitle1;
    private RelativeLayout appdetailtop;
    private ImageView appicon;
    private TextView apptitle;
    private BadgeView badgedownimg;
    private LinearLayout banner;
    private String banner_type_name;
    private Button bt_caller;
    private Button bt_dea_download;
    private int caocao;
    private TextView date;
    private FinalDBChen db;
    private TypeDbUtils dbUtils;
    private HashMap default_options;
    private BroadcastReceiver delete;
    private TextView desctv;
    private TextView detail;
    private LImageButton detailfan;
    private LinearLayout detailline;
    private LinearLayout detaillinewyc1;
    private LinearLayout detaillinewyc2;
    private ImageView detailplaytop;
    private ScrollView detailscroll;
    private ImageView detailtogift;
    private RelativeLayout detailtopre2;
    private RelativeLayout detailtoprel;
    private TextView device;
    private TextView downloadapk;
    private TextView downloadapk1;
    private TextView downloadapk_install;
    private TextView downloadapk_start;
    private TextView downloads;
    private List ds;
    private ArrayList gvlist;
    private ArrayList gvlist1;
    private ArrayList gvlist2;
    Handler handler;
    private BroadcastReceiver hidegvappdetail;
    private String id;
    private String imbdownurl;
    private LayoutInflater inflate;
    private RelativeLayout inmobtop;
    private BroadcastReceiver intent_pause;
    private BroadcastReceiver intent_start;
    private boolean isfbshow;
    private boolean isshowinmobi;
    private ImageView iv_del_fb_yuansheng;
    private ImageView iv_del_fb_yuansheng1;
    private String linkurl1;
    private ArrayList list;
    private LinearLayout ll_dea_download;
    private LinearLayout ll_dea_sh;
    private RelativeLayout ll_free;
    private LinearLayout ll_gall;
    private ImageView mAnimImageView;
    private Animation mAnimation;
    private int mRandom;
    private DownloadMovieItem model;
    private String myUpver;
    private String myVer;
    private HorizontalListView mygallery;
    private int myjpush;
    private NativeAd nativeAd;
    private NativeAd nativeAdfb;
    PackageInfo packageInfo;
    private BroadcastReceiver pdt_del;
    private BroadcastReceiver pdt_failure;
    private int pdt_pro;
    private int pdt_pro_cru;
    private ProgressBar pdt_progressBar1;
    private ProgressWheel progress_wheel;
    private publicTools publictools;
    private RelativeLayout rl_sad;
    private RelativeLayout rl_yuancheng;
    private boolean shoufengqing;
    private BroadcastReceiver showgvappdetail;
    private SharedPreferences sp_config;
    private SharedPreferences spnetworkre;
    private String stringExtra;
    private BroadcastReceiver successful;
    private Timer timer2;
    private RelativeLayout topredetail;
    private RelativeLayout topredetailwyc1;
    private RelativeLayout topredetailwyc2;
    private Boolean tuijianboolean;
    private TextView tv_price;
    private TextView tv_rating_count;
    private TextView tv_readmore;
    private TextView tv_short_desc;
    private Typeface typeFace;
    private Typeface typeFace2;
    private TextView version;
    private View view1;
    private View view2;
    private View view3;
    private View view4;
    private boolean widgetdetailfan;
    private int wocao;
    private String wycmyid;

    public AppDetailsActivity()
    {
        AIOFREE = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("freestore.swf").toString());
        AIOFREEAPK = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("freestore.apk").toString());
        AIOCALLERDOWN = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("caller.swf").toString());
        AIOCALLERAPK = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("caller.apk").toString());
        AIOCRUSHSWF = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("crush.swf").toString());
        AIOCRUSHAPK = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("crush.apk").toString());
        AIOBATTERY = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("battery.swf").toString());
        AIOBATTERYAPK = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("battery.apk").toString());
        mRandom = 0;
        pdt_pro = 90;
        pdt_pro_cru = 0;
        showgvappdetail = new BroadcastReceiver() {

            final AppDetailsActivity this$0;

            public void onReceive(Context context, Intent intent)
            {
                progress_wheel.setVisibility(0);
            }

            
            {
                this$0 = AppDetailsActivity.this;
                super();
            }
        };
        hidegvappdetail = new BroadcastReceiver() {

            final AppDetailsActivity this$0;

            public void onReceive(Context context, Intent intent)
            {
                progress_wheel.setVisibility(8);
            }

            
            {
                this$0 = AppDetailsActivity.this;
                super();
            }
        };
        packageInfo = null;
        successful = new BroadcastReceiver() {

            final AppDetailsActivity this$0;

            public void onReceive(Context context, Intent intent)
            {
                stringExtra = intent.getStringExtra("downpath");
                downloadapk_install.setVisibility(0);
                downloadapk1.setVisibility(8);
                pdt_progressBar1.setProgress(100);
            }

            
            {
                this$0 = AppDetailsActivity.this;
                super();
            }
        };
        delete = new BroadcastReceiver() {

            final AppDetailsActivity this$0;

            public void onReceive(Context context, Intent intent)
            {
                detailtopre2.setVisibility(8);
                detailtoprel.setVisibility(0);
                if (timer2 != null)
                {
                    timer2.cancel();
                }
                pdt_progressBar1.setProgress(0);
            }

            
            {
                this$0 = AppDetailsActivity.this;
                super();
            }
        };
        pdt_del = new BroadcastReceiver() {

            final AppDetailsActivity this$0;

            public void onReceive(Context context, Intent intent)
            {
                detailtopre2.setVisibility(8);
                detailtoprel.setVisibility(0);
                if (timer2 != null)
                {
                    timer2.cancel();
                }
                pdt_progressBar1.setProgress(0);
            }

            
            {
                this$0 = AppDetailsActivity.this;
                super();
            }
        };
        pdt_failure = new BroadcastReceiver() {

            final AppDetailsActivity this$0;

            public void onReceive(Context context, Intent intent)
            {
                detailtopre2.performClick();
                detailtopre2.setVisibility(8);
                downloadapk_start.setVisibility(0);
                downloadapk_start.setText("Retry");
            }

            
            {
                this$0 = AppDetailsActivity.this;
                super();
            }
        };
        intent_start = new BroadcastReceiver() {

            final AppDetailsActivity this$0;

            public void onReceive(Context context, Intent intent)
            {
                downloadapk_start.performClick();
            }

            
            {
                this$0 = AppDetailsActivity.this;
                super();
            }
        };
        intent_pause = new BroadcastReceiver() {

            final AppDetailsActivity this$0;

            public void onReceive(Context context, Intent intent)
            {
                downloadapk1.performClick();
            }

            
            {
                this$0 = AppDetailsActivity.this;
                super();
            }
        };
        appdetail = new BroadcastReceiver() {

            final AppDetailsActivity this$0;

            public void onReceive(Context context, Intent intent)
            {
                try
                {
                    db = new FinalDBChen(AppDetailsActivity.this, getDatabasePath("download2.db").getAbsolutePath());
                    ds = db.findItemsByWhereAndWhereValue(null, null, com/aio/downloader/mydownload/DownloadMovieItem, "downloadtask2", null);
                    (new AsyncTask() {

                        final _cls9 this$1;

                        protected volatile transient Object doInBackground(Object aobj[])
                        {
                            return doInBackground((Void[])aobj);
                        }

                        protected transient String doInBackground(Void avoid[])
                        {
                            return String.valueOf(ds.size());
                        }

                        protected volatile void onPostExecute(Object obj)
                        {
                            onPostExecute((String)obj);
                        }

                        protected void onPostExecute(String s)
                        {
                            super.onPostExecute(s);
                            mAnimImageView.setVisibility(0);
                            mAnimImageView.startAnimation(mAnimation);
                            badgedownimg.setText(s);
                            badgedownimg.show();
                        }

            
            {
                this$1 = _cls9.this;
                super();
            }
                    }).execute(new Void[0]);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Context context)
                {
                    return;
                }
            }


            
            {
                this$0 = AppDetailsActivity.this;
                super();
            }
        };
        handler = new Handler() {

            final AppDetailsActivity this$0;

            public void handleMessage(Message message)
            {
                super.handleMessage(message);
                message.what;
                JVM INSTR lookupswitch 4: default 52
            //                           1: 53
            //                           2: 67
            //                           3: 75
            //                           30000: 191;
                   goto _L1 _L2 _L3 _L4 _L5
_L1:
                return;
_L2:
                Toast.makeText(AppDetailsActivity.this, "Failed to connect server.", 0).show();
                return;
_L3:
                Mydialog();
                return;
_L4:
                if (wocao == 0)
                {
                    Toast.makeText(AppDetailsActivity.this, (new StringBuilder("'")).append(model.getTitle()).append("' is added to download queue.").toString(), 0).show();
                } else
                {
                    Toast.makeText(AppDetailsActivity.this, (new StringBuilder("'")).append(appName).append("' is added to download queue.").toString(), 0).show();
                }
                message = new Intent();
                message.setAction("appdetail");
                sendBroadcast(message);
                return;
_L5:
                if (System.currentTimeMillis() > SharedPreferencesConfig.GetClickTime(getApplicationContext()))
                {
                    detailtogift.setImageResource(0x7f0200d8);
                    message = AnimationUtils.loadAnimation(getApplicationContext(), 0x7f04001e);
                    detailtogift.startAnimation(message);
                    return;
                }
                if (true) goto _L1; else goto _L6
_L6:
            }

            
            {
                this$0 = AppDetailsActivity.this;
                super();
            }
        };
        tuijianboolean = Boolean.valueOf(false);
        publictools = null;
        dbUtils = null;
        sp_config = null;
        shoufengqing = true;
        typeFace = null;
        widgetdetailfan = false;
        isfbshow = false;
        PRO_DIR_FOME = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/cleaner/cleaner.apk").toString());
        PRO_DIR_TO = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/cleaner/cleaner.swf").toString());
        PRO_DIR = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/cleaner").toString());
        isshowinmobi = false;
        linkurl1 = "";
        wocao = 0;
    }

    private void Mydialog()
    {
        (new android.app.AlertDialog.Builder(this)).setTitle(getString(0x7f0b0034)).setMessage("It has been in downloading list already.").setPositiveButton("Ok", new android.content.DialogInterface.OnClickListener() {

            final AppDetailsActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

            
            {
                this$0 = AppDetailsActivity.this;
                super();
            }
        }).show();
    }

    private void ShowResult(String s)
    {
        gvlist = new ArrayList();
        gvlist.addAll(Myutils.parseApplist(s));
        adapter = new Home_Gridview_Adapter(getApplicationContext(), gvlist, "appdetail");
        appdetailgv.setAdapter(adapter);
    }

    private void ShowResult1(String s)
    {
        gvlist1 = new ArrayList();
        gvlist1.addAll(Myutils.parseApplist(s));
        adapter = new Home_Gridview_Adapter(getApplicationContext(), gvlist1, "appdetail");
        appdetailgvwyc1.setAdapter(adapter);
    }

    private void ShowResult2(String s)
    {
        gvlist2 = new ArrayList();
        gvlist2.addAll(Myutils.parseApplist(s));
        adapter = new Home_Gridview_Adapter(getApplicationContext(), gvlist2, "appdetail");
        appdetailgvwyc2.setAdapter(adapter);
    }

    private void apprecentlistViewbottom()
    {
        android.widget.RelativeLayout.LayoutParams layoutparams = (android.widget.RelativeLayout.LayoutParams)detailscroll.getLayoutParams();
        layoutparams.setMargins(0, 0, 0, DisplayUtil.dip2px(getApplicationContext(), 50F));
        detailscroll.setLayoutParams(layoutparams);
    }

    private void buildListener()
    {
        topredetail.setOnClickListener(this);
        detailtogift.setOnClickListener(this);
        appdetailsearch.setOnClickListener(this);
        appdetaildown.setOnClickListener(this);
        topredetailwyc1.setOnClickListener(this);
        topredetailwyc2.setOnClickListener(this);
        mAnimation.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

            final AppDetailsActivity this$0;

            public void onAnimationEnd(Animation animation)
            {
                mAnimImageView.setVisibility(4);
            }

            public void onAnimationRepeat(Animation animation)
            {
            }

            public void onAnimationStart(Animation animation)
            {
            }

            
            {
                this$0 = AppDetailsActivity.this;
                super();
            }
        });
    }

    private void downwifi()
    {
        final LianwangDialog dialog = new LianwangDialog(this, 0x7f0c000e);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        Button button = (Button)dialog.findViewById(0x7f070141);
        Button button1 = (Button)dialog.findViewById(0x7f070142);
        button.setOnClickListener(new android.view.View.OnClickListener() {

            final AppDetailsActivity this$0;
            private final LianwangDialog val$dialog;

            public void onClick(View view)
            {
                dialog.dismiss();
            }

            
            {
                this$0 = AppDetailsActivity.this;
                dialog = lianwangdialog;
                super();
            }
        });
        button1.setOnClickListener(new android.view.View.OnClickListener() {

            final AppDetailsActivity this$0;
            private final LianwangDialog val$dialog;

            public void onClick(View view)
            {
                startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
                dialog.dismiss();
            }

            
            {
                this$0 = AppDetailsActivity.this;
                dialog = lianwangdialog;
                super();
            }
        });
    }

    public static Bitmap drawableToBitmap(Drawable drawable)
    {
        int i = drawable.getIntrinsicWidth();
        int j = drawable.getIntrinsicHeight();
        Object obj;
        Canvas canvas;
        if (drawable.getOpacity() != -1)
        {
            obj = android.graphics.Bitmap.Config.ARGB_8888;
        } else
        {
            obj = android.graphics.Bitmap.Config.RGB_565;
        }
        obj = Bitmap.createBitmap(i, j, ((android.graphics.Bitmap.Config) (obj)));
        canvas = new Canvas(((Bitmap) (obj)));
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return ((Bitmap) (obj));
    }

    private void facebookad()
    {
        nativeAdfb.registerViewForInteraction(detailtogift);
    }

    private void facebookad_free()
    {
        NativeAd.downloadAndDisplayImage(nativeAd.getAdCoverImage(), iv_del_fb_yuansheng);
        nativeAd.registerViewForInteraction(iv_del_fb_yuansheng);
    }

    private void failfile()
    {
        publicTools.app_detail_handler = new Handler() {

            private String content;
            private String id;
            private String size;
            final AppDetailsActivity this$0;
            private String type;

            public void handleMessage(Message message)
            {
                type = message.getData().getString("type");
                id = message.getData().getString("id");
                content = message.getData().getString("content");
                size = message.getData().getString("size");
                message.what;
                JVM INSTR tableswitch 1212 1212: default 76
            //                           1212 82;
                   goto _L1 _L2
_L1:
                super.handleMessage(message);
                return;
_L2:
                (new Thread(new Runnable() {

                    final _cls11 this$1;

                    public void run()
                    {
                        publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/hits.php?type=action=download_invalid&type=app&id=")).append(id).append("&size=").append(size).append("&content=").append(content).toString());
                    }

            
            {
                this$1 = _cls11.this;
                super();
            }
                })).start();
                if (true) goto _L1; else goto _L3
_L3:
            }




            
            {
                this$0 = AppDetailsActivity.this;
                super();
            }
        };
    }

    private void init()
    {
        widgetdetailfan = getIntent().getBooleanExtra("widgetdetailfan", false);
        detailtoprel = (RelativeLayout)findViewById(0x7f0700a2);
        detailtopre2 = (RelativeLayout)findViewById(0x7f0700ac);
        detailline = (LinearLayout)findViewById(0x7f0700c8);
        desctv = (TextView)findViewById(0x7f0700df);
        view1 = findViewById(0x7f0700b4);
        view2 = findViewById(0x7f0700d7);
        view3 = findViewById(0x7f0700de);
        view4 = findViewById(0x7f0700e1);
        ll_gall = (LinearLayout)findViewById(0x7f0700b8);
        desctv.setTypeface(typeFace);
        topredetail = (RelativeLayout)findViewById(0x7f0700c9);
        detailtogift = (ImageView)findViewById(0x7f07009b);
        detailscroll = (ScrollView)findViewById(0x7f07009d);
        appdetailgv = (GridView)findViewById(0x7f0700cc);
        appdetailsearch = (LImageButton)findViewById(0x7f07009a);
        appdetaildown = (LImageButton)findViewById(0x7f07009c);
        mAnimImageView = (ImageView)findViewById(0x7f070073);
        inmobtop = (RelativeLayout)findViewById(0x7f0700c2);
        apptitle = (TextView)findViewById(0x7f0700c4);
        appauthortitle = (TextView)findViewById(0x7f0700c6);
        appicon = (ImageView)findViewById(0x7f0700c3);
        app_ratingbar = (RatingBar)findViewById(0x7f0700be);
        rl_sad = (RelativeLayout)findViewById(0x7f0700a1);
        mAnimation = AnimationUtils.loadAnimation(this, 0x7f040007);
        badgedownimg = new BadgeView(getApplicationContext(), appdetaildown);
        publictools = new publicTools(this);
        detailfan = (LImageButton)findViewById(0x7f070098);
        banner = (LinearLayout)findViewById(0x7f070059);
        sp_config = getSharedPreferences("banner_type", 0);
        iv_del_fb_yuansheng = (ImageView)findViewById(0x7f07009f);
        rl_yuancheng = (RelativeLayout)findViewById(0x7f07009e);
        iv_del_fb_yuansheng1 = (ImageView)findViewById(0x7f0700a0);
        iv_del_fb_yuansheng1.setOnClickListener(new android.view.View.OnClickListener() {

            final AppDetailsActivity this$0;

            public void onClick(View view)
            {
                view = null;
                PackageInfo packageinfo = getPackageManager().getPackageInfo("com.freepezzle.hexcrush", 0);
                view = packageinfo;
_L1:
                if (view != null)
                {
                    break MISSING_BLOCK_LABEL_207;
                }
                android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
                try
                {
                    if (AIOCRUSHAPK.exists() && getFileSizes(AIOCRUSHAPK) >= 0x19ee4cL)
                    {
                        view = new Intent("android.intent.action.VIEW");
                        view.setDataAndType(Uri.parse((new StringBuilder("file://")).append(AIOCRUSHAPK).toString()), "application/vnd.android.package-archive");
                        startActivity(view);
                        return;
                    }
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    view.printStackTrace();
                    return;
                }
                break MISSING_BLOCK_LABEL_115;
                namenotfoundexception;
                namenotfoundexception.printStackTrace();
                  goto _L1
                if (AIOCRUSHSWF.exists() && getFileSizes(AIOCRUSHSWF) >= 0x19ee4cL)
                {
                    (new AsyncTask() {

                        final _cls18 this$1;

                        protected volatile transient Object doInBackground(Object aobj[])
                        {
                            return doInBackground((Void[])aobj);
                        }

                        protected transient Void doInBackground(Void avoid[])
                        {
                            Myutils.copyfile(AIOCRUSHSWF, AIOCRUSHAPK, Boolean.valueOf(false));
                            return null;
                        }

                        protected volatile void onPostExecute(Object obj)
                        {
                            onPostExecute((Void)obj);
                        }

                        protected void onPostExecute(Void void1)
                        {
                            super.onPostExecute(void1);
                            void1 = new Intent("android.intent.action.VIEW");
                            void1.setDataAndType(Uri.parse((new StringBuilder("file://")).append(AIOCRUSHAPK).toString()), "application/vnd.android.package-archive");
                            startActivity(void1);
                        }

            
            {
                this$1 = _cls18.this;
                super();
            }
                    }).execute(new Void[0]);
                    return;
                }
                view = new Intent(getApplicationContext(), com/aio/downloader/activity/AppDetailsActivity);
                view.putExtra("myid", "com.freepezzle.hexcrush");
                startActivity(view);
                return;
                view = getPackageManager().getLaunchIntentForPackage("com.freepezzle.hexcrush");
                startActivity(view);
                return;
            }


            
            {
                this$0 = AppDetailsActivity.this;
                super();
            }
        });
        detailfan.setOnClickListener(new android.view.View.OnClickListener() {

            final AppDetailsActivity this$0;

            public void onClick(View view)
            {
                if (caocao == 1 || myjpush == 1)
                {
                    view = new Intent(getApplicationContext(), com/aio/downloader/activity/MyMainActivity);
                    view.putExtra("acquire_url_start", "");
                    startActivity(view);
                    finish();
                    return;
                } else
                {
                    finish();
                    return;
                }
            }

            
            {
                this$0 = AppDetailsActivity.this;
                super();
            }
        });
        default_options = new HashMap();
        default_options.put("save_cookie", Integer.valueOf(0));
        default_options.put("send_cookie", Integer.valueOf(0));
        default_options.put("show_header", Integer.valueOf(0));
        default_options.put("redirect", Integer.valueOf(1));
        try
        {
            db = new FinalDBChen(getmContext(), getDatabasePath("download2.db").getAbsolutePath());
            ds = db.findItemsByWhereAndWhereValue(null, null, com/aio/downloader/mydownload/DownloadMovieItem, "downloadtask2", null);
        }
        catch (Exception exception1) { }
        spnetworkre = getSharedPreferences("network", 0);
        try
        {
            if (dbUtils == null)
            {
                dbUtils = new TypeDbUtils(this);
            }
        }
        catch (Exception exception) { }
        app = (MyApplcation)getApplicationContext();
        progress_wheel = (ProgressWheel)findViewById(0x7f070072);
        appdetailicon = (ImageView)findViewById(0x7f0700a3);
        appdetailicon1 = (ImageView)findViewById(0x7f0700ad);
        appdetailtitle = (TextView)findViewById(0x7f0700a4);
        appdetailtitle1 = (TextView)findViewById(0x7f0700ae);
        detailplaytop = (ImageView)findViewById(0x7f0700a5);
        device = (TextView)findViewById(0x7f0700a9);
        appdetailauthortitle = (TextView)findViewById(0x7f0700a6);
        appdetailratingbar = (RatingBar)findViewById(0x7f0700a7);
        version = (TextView)findViewById(0x7f0700d9);
        date = (TextView)findViewById(0x7f0700da);
        downloads = (TextView)findViewById(0x7f0700dc);
        detail = (TextView)findViewById(0x7f0700e0);
        mygallery = (HorizontalListView)findViewById(0x7f0700b9);
        downloadapk = (TextView)findViewById(0x7f0700aa);
        downloadapk1 = (TextView)findViewById(0x7f0700b1);
        downloadapk_start = (TextView)findViewById(0x7f0700b2);
        downloadapk_install = (TextView)findViewById(0x7f0700b3);
        tv_rating_count = (TextView)findViewById(0x7f0700a8);
        tv_price = (TextView)findViewById(0x7f0700ab);
        tv_short_desc = (TextView)findViewById(0x7f0700b6);
        bt_dea_download = (Button)findViewById(0x7f0700e3);
        ll_dea_download = (LinearLayout)findViewById(0x7f0700e2);
        detaillinewyc1 = (LinearLayout)findViewById(0x7f0700cd);
        topredetailwyc1 = (RelativeLayout)findViewById(0x7f0700ce);
        appdetailgvwyc1 = (MyGridView)findViewById(0x7f0700d1);
        detaillinewyc2 = (LinearLayout)findViewById(0x7f0700d2);
        topredetailwyc2 = (RelativeLayout)findViewById(0x7f0700d3);
        appdetailgvwyc2 = (MyGridView)findViewById(0x7f0700d6);
        ll_dea_sh = (LinearLayout)findViewById(0x7f0700b5);
        ll_free = (RelativeLayout)findViewById(0x7f0700ba);
        bt_caller = (Button)findViewById(0x7f0700bf);
        pdt_progressBar1 = (ProgressBar)findViewById(0x7f0700af);
        findViewById(0x7f0700cb).setOnClickListener(this);
        findViewById(0x7f0700d0).setOnClickListener(this);
        downloadapk1.setOnClickListener(new android.view.View.OnClickListener() {

            final AppDetailsActivity this$0;

            public void onClick(View view)
            {
                downloadapk1.setVisibility(8);
                downloadapk_start.setVisibility(0);
                if (timer2 != null)
                {
                    timer2.cancel();
                }
                view = new Intent("pdtpause");
                view.putExtra("type", "pause");
                sendBroadcast(view);
            }

            
            {
                this$0 = AppDetailsActivity.this;
                super();
            }
        });
        downloadapk_start.setOnClickListener(new android.view.View.OnClickListener() {

            final AppDetailsActivity this$0;

            public void onClick(View view)
            {
                downloadapk1.setVisibility(0);
                downloadapk_start.setVisibility(8);
                pdt_progressBar1.setProgress(pdt_pro_cru);
                timer2 = null;
                timer2 = new Timer();
                timer2.schedule(new TimerTask() {

                    final _cls21 this$1;

                    public void run()
                    {
                        runOnUiThread(new Runnable() {

                            final _cls1 this$2;

                            public void run()
                            {
                                if (pdt_progressBar1.getProgress() >= pdt_pro)
                                {
                                    if (timer2 != null)
                                    {
                                        timer2.cancel();
                                    }
                                    return;
                                } else
                                {
                                    pdt_progressBar1.setProgress(pdt_progressBar1.getProgress() + 1);
                                    AppDetailsActivity appdetailsactivity = _fld0;
                                    appdetailsactivity.pdt_pro_cru = appdetailsactivity.pdt_pro_cru + 1;
                                    return;
                                }
                            }

            
            {
                this$2 = _cls1.this;
                super();
            }
                        });
                    }


            
            {
                this$1 = _cls21.this;
                super();
            }
                }, 1000L, 600L);
                view = new Intent("pdtpause");
                view.putExtra("type", "resume");
                sendBroadcast(view);
            }


            
            {
                this$0 = AppDetailsActivity.this;
                super();
            }
        });
        downloadapk_install.setOnClickListener(new android.view.View.OnClickListener() {

            final AppDetailsActivity this$0;

            public void onClick(View view)
            {
                MyAppInfo myappinfo;
                try
                {
                    view = getPackageManager().getPackageInfo(wycmyid, 0);
                }
                catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
                {
                    view = null;
                    namenotfoundexception.printStackTrace();
                }
                myappinfo = new MyAppInfo(getApplicationContext());
                try
                {
                    myVer = myappinfo.getAppVersion(wycmyid);
                }
                catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception1)
                {
                    namenotfoundexception1.printStackTrace();
                }
                if (view == null)
                {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setDataAndType(Uri.parse((new StringBuilder("file://")).append(stringExtra).toString()), "application/vnd.android.package-archive");
                    startActivity(intent);
                } else
                {
                    try
                    {
                        Intent intent1 = getPackageManager().getLaunchIntentForPackage(wycmyid);
                        intent1.addFlags(0x10000000);
                        startActivity(intent1);
                    }
                    catch (Exception exception2)
                    {
                        Toast.makeText(AppDetailsActivity.this, "This program is protected", 0).show();
                    }
                }
                if (wocao != 1)
                {
                    break MISSING_BLOCK_LABEL_174;
                }
                if (!myUpver.equals(myVer) || view == null)
                {
                    break MISSING_BLOCK_LABEL_261;
                }
                view = getPackageManager().getLaunchIntentForPackage(wycmyid);
                view.addFlags(0x10000000);
                startActivity(view);
                return;
                view;
                Toast.makeText(AppDetailsActivity.this, "This program is protected", 0).show();
                return;
                view = new Intent("android.intent.action.VIEW");
                view.setDataAndType(Uri.parse((new StringBuilder("file://")).append(stringExtra).toString()), "application/vnd.android.package-archive");
                startActivity(view);
                return;
            }

            
            {
                this$0 = AppDetailsActivity.this;
                super();
            }
        });
        bt_caller.setOnClickListener(new android.view.View.OnClickListener() {

            final AppDetailsActivity this$0;

            public void onClick(View view)
            {
                view = null;
                PackageInfo packageinfo = getPackageManager().getPackageInfo("com.freepezzle.hexcrush", 0);
                view = packageinfo;
_L1:
                if (view != null)
                {
                    break MISSING_BLOCK_LABEL_207;
                }
                android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
                try
                {
                    if (AIOCRUSHAPK.exists() && getFileSizes(AIOCRUSHAPK) >= 0x19ee4cL)
                    {
                        view = new Intent("android.intent.action.VIEW");
                        view.setDataAndType(Uri.parse((new StringBuilder("file://")).append(AIOCRUSHAPK).toString()), "application/vnd.android.package-archive");
                        startActivity(view);
                        return;
                    }
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    view.printStackTrace();
                    return;
                }
                break MISSING_BLOCK_LABEL_115;
                namenotfoundexception;
                namenotfoundexception.printStackTrace();
                  goto _L1
                if (AIOCRUSHSWF.exists() && getFileSizes(AIOCRUSHSWF) >= 0x19ee4cL)
                {
                    (new AsyncTask() {

                        final _cls23 this$1;

                        protected volatile transient Object doInBackground(Object aobj[])
                        {
                            return doInBackground((Void[])aobj);
                        }

                        protected transient Void doInBackground(Void avoid[])
                        {
                            Myutils.copyfile(AIOCRUSHSWF, AIOCRUSHAPK, Boolean.valueOf(false));
                            return null;
                        }

                        protected volatile void onPostExecute(Object obj)
                        {
                            onPostExecute((Void)obj);
                        }

                        protected void onPostExecute(Void void1)
                        {
                            super.onPostExecute(void1);
                            void1 = new Intent("android.intent.action.VIEW");
                            void1.setDataAndType(Uri.parse((new StringBuilder("file://")).append(AIOCRUSHAPK).toString()), "application/vnd.android.package-archive");
                            startActivity(void1);
                        }

            
            {
                this$1 = _cls23.this;
                super();
            }
                    }).execute(new Void[0]);
                    return;
                }
                view = new Intent(getApplicationContext(), com/aio/downloader/activity/AppDetailsActivity);
                view.putExtra("myid", "com.freepezzle.hexcrush");
                startActivity(view);
                return;
                view = getPackageManager().getLaunchIntentForPackage("com.freepezzle.hexcrush");
                startActivity(view);
                return;
            }


            
            {
                this$0 = AppDetailsActivity.this;
                super();
            }
        });
        ll_free.setOnClickListener(new android.view.View.OnClickListener() {

            final AppDetailsActivity this$0;

            public void onClick(View view)
            {
                MobclickAgent.onEvent(AppDetailsActivity.this, "pdt_caller_click");
                view = null;
                PackageInfo packageinfo = getPackageManager().getPackageInfo("com.freepezzle.hexcrush", 0);
                view = packageinfo;
_L1:
                if (view != null)
                {
                    break MISSING_BLOCK_LABEL_216;
                }
                android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
                try
                {
                    if (AIOCRUSHAPK.exists() && getFileSizes(AIOCRUSHAPK) >= 0x19ee4cL)
                    {
                        view = new Intent("android.intent.action.VIEW");
                        view.setDataAndType(Uri.parse((new StringBuilder("file://")).append(AIOCRUSHAPK).toString()), "application/vnd.android.package-archive");
                        startActivity(view);
                        return;
                    }
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    view.printStackTrace();
                    return;
                }
                break MISSING_BLOCK_LABEL_124;
                namenotfoundexception;
                namenotfoundexception.printStackTrace();
                  goto _L1
                if (AIOCRUSHSWF.exists() && getFileSizes(AIOCRUSHSWF) >= 0x19ee4cL)
                {
                    (new AsyncTask() {

                        final _cls24 this$1;

                        protected volatile transient Object doInBackground(Object aobj[])
                        {
                            return doInBackground((Void[])aobj);
                        }

                        protected transient Void doInBackground(Void avoid[])
                        {
                            Myutils.copyfile(AIOCRUSHSWF, AIOCRUSHAPK, Boolean.valueOf(false));
                            return null;
                        }

                        protected volatile void onPostExecute(Object obj)
                        {
                            onPostExecute((Void)obj);
                        }

                        protected void onPostExecute(Void void1)
                        {
                            super.onPostExecute(void1);
                            void1 = new Intent("android.intent.action.VIEW");
                            void1.setDataAndType(Uri.parse((new StringBuilder("file://")).append(AIOCRUSHAPK).toString()), "application/vnd.android.package-archive");
                            startActivity(void1);
                        }

            
            {
                this$1 = _cls24.this;
                super();
            }
                    }).execute(new Void[0]);
                    return;
                }
                view = new Intent(getApplicationContext(), com/aio/downloader/activity/AppDetailsActivity);
                view.putExtra("myid", "com.freepezzle.hexcrush");
                startActivity(view);
                return;
                view = getPackageManager().getLaunchIntentForPackage("com.freepezzle.hexcrush");
                startActivity(view);
                return;
            }


            
            {
                this$0 = AppDetailsActivity.this;
                super();
            }
        });
        tv_readmore = (TextView)findViewById(0x7f0700b7);
        tv_readmore.setOnClickListener(new android.view.View.OnClickListener() {

            final AppDetailsActivity this$0;

            public void onClick(View view)
            {
                view = new Intent(getApplicationContext(), com/aio/downloader/activity/AppDetatils_moreActivity);
                view.putExtra("dea_title", model.getTitle());
                view.putExtra("dea_sheart", model.getPpshort_desc());
                view.putExtra("dea_dea", model.getDetail());
                view.putExtra("dea_up", model.getRelease_date());
                view.putExtra("dea_ver", model.getVersion());
                view.putExtra("dea_down", model.getDownloads());
                view.putExtra("dea_size", model.getSize());
                startActivity(view);
            }

            
            {
                this$0 = AppDetailsActivity.this;
                super();
            }
        });
        bt_dea_download.setOnClickListener(new android.view.View.OnClickListener() {

            final AppDetailsActivity this$0;

            public void onClick(View view)
            {
                Log.e("logg", (new StringBuilder("linkurl1=")).append(linkurl1).append("wocao=").append(wocao).toString());
                if (wocao != 0)
                {
                    break MISSING_BLOCK_LABEL_390;
                }
                if (!model.getHas_apk().equals("1")) goto _L2; else goto _L1
_L1:
                (new AsyncTask() {

                    final _cls26 this$1;

                    protected volatile transient Object doInBackground(Object aobj[])
                    {
                        return doInBackground((Void[])aobj);
                    }

                    protected transient Void doInBackground(Void avoid[])
                    {
                        try
                        {
                            publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/hits.php?type=app&id=")).append(id).append("&from=apk").toString());
                        }
                        // Misplaced declaration of an exception variable
                        catch (Void avoid[]) { }
                        return null;
                    }

            
            {
                this$1 = _cls26.this;
                super();
            }
                }).execute(new Void[0]);
                if (!spnetworkre.getBoolean("isopen", false) || NetWorkUtil.getAPNType(getApplicationContext()) == 1) goto _L4; else goto _L3
_L3:
                downwifi();
_L6:
                return;
_L4:
                if (dbUtils.queryfile(model.getId()) == null)
                {
                    MydownloadApk(model.getId(), model.getTitle(), model.getIcon(), model.getSerial());
                    Log.e("bbb", (new StringBuilder(String.valueOf(model.getTitle()))).append("+").append(model.getIcon()).append("+").append(model.getSerial()).toString());
                    bt_dea_download.setBackgroundResource(0x7f02006e);
                    bt_dea_download.setText("Downloading");
                    return;
                } else
                {
                    Mydialog();
                    return;
                }
_L2:
                if (!model.getHas_apk().equals("0")) goto _L6; else goto _L5
_L5:
                (new Thread(new Runnable() {

                    final _cls26 this$1;

                    public void run()
                    {
                        try
                        {
                            publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/hits.php?type=app&id=")).append(model.getId()).append("&from=google").toString());
                            return;
                        }
                        catch (Exception exception)
                        {
                            return;
                        }
                    }

            
            {
                this$1 = _cls26.this;
                super();
            }
                })).start();
                bt_dea_download.setBackgroundResource(0x7f02006e);
                view = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("https://play.google.com/store/apps/details?id=")).append(model.getId()).toString()));
                startActivity(view);
                return;
                Log.e("qqq", (new StringBuilder("dbUtils.queryfile(wycmyid)=")).append(dbUtils.queryfile(wycmyid)).append("=========").append(db.findItemsByWhereAndWhereValue("file_id", wycmyid, com/aio/downloader/mydownload/DownloadMovieItem, "downloadtask2", null).size()).toString());
                if (dbUtils.queryfile(wycmyid) == null && db.findItemsByWhereAndWhereValue("file_id", wycmyid, com/aio/downloader/mydownload/DownloadMovieItem, "downloadtask2", null).size() == 0)
                {
                    view = new MyAppInfo(getApplicationContext());
                    try
                    {
                        appName = view.getAppName(wycmyid);
                        appIcon2 = view.getAppIcon(wycmyid);
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        view.printStackTrace();
                    }
                    MydownloadApk_Update(wycmyid, appName, myUpver, 110, AppDetailsActivity.drawableToBitmap(appIcon2));
                    bt_dea_download.setBackgroundResource(0x7f02006e);
                    view = new Intent("setbroadUpdate");
                    sendBroadcast(view);
                    return;
                } else
                {
                    view = new Message();
                    view.what = 2;
                    handler.sendMessage(view);
                    return;
                }
            }


            
            {
                this$0 = AppDetailsActivity.this;
                super();
            }
        });
        downloadapk.setOnClickListener(new android.view.View.OnClickListener() {

            final AppDetailsActivity this$0;

            public void onClick(View view)
            {
                Log.e("logg", (new StringBuilder("linkurl1=")).append(linkurl1).append("wocao=").append(wocao).toString());
                if (wocao != 0)
                {
                    break MISSING_BLOCK_LABEL_390;
                }
                if (!model.getHas_apk().equals("1")) goto _L2; else goto _L1
_L1:
                (new AsyncTask() {

                    final _cls27 this$1;

                    protected volatile transient Object doInBackground(Object aobj[])
                    {
                        return doInBackground((Void[])aobj);
                    }

                    protected transient Void doInBackground(Void avoid[])
                    {
                        try
                        {
                            publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/hits.php?type=app&id=")).append(id).append("&from=apk").toString());
                        }
                        // Misplaced declaration of an exception variable
                        catch (Void avoid[]) { }
                        return null;
                    }

            
            {
                this$1 = _cls27.this;
                super();
            }
                }).execute(new Void[0]);
                if (!spnetworkre.getBoolean("isopen", false) || NetWorkUtil.getAPNType(getApplicationContext()) == 1) goto _L4; else goto _L3
_L3:
                downwifi();
_L6:
                return;
_L4:
                if (dbUtils.queryfile(model.getId()) == null)
                {
                    MydownloadApk(model.getId(), model.getTitle(), model.getIcon(), model.getSerial());
                    Log.e("bbb", (new StringBuilder(String.valueOf(model.getTitle()))).append("+").append(model.getIcon()).append("+").append(model.getSerial()).toString());
                    bt_dea_download.setBackgroundResource(0x7f02006e);
                    bt_dea_download.setText("Downloading");
                    return;
                } else
                {
                    Mydialog();
                    return;
                }
_L2:
                if (!model.getHas_apk().equals("0")) goto _L6; else goto _L5
_L5:
                (new Thread(new Runnable() {

                    final _cls27 this$1;

                    public void run()
                    {
                        try
                        {
                            publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/hits.php?type=app&id=")).append(model.getId()).append("&from=google").toString());
                            return;
                        }
                        catch (Exception exception)
                        {
                            return;
                        }
                    }

            
            {
                this$1 = _cls27.this;
                super();
            }
                })).start();
                bt_dea_download.setBackgroundResource(0x7f02006e);
                view = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("https://play.google.com/store/apps/details?id=")).append(model.getId()).toString()));
                startActivity(view);
                return;
                Log.e("qqq", (new StringBuilder("dbUtils.queryfile(wycmyid)=")).append(dbUtils.queryfile(wycmyid)).append("=========").append(db.findItemsByWhereAndWhereValue("file_id", wycmyid, com/aio/downloader/mydownload/DownloadMovieItem, "downloadtask2", null).size()).toString());
                if (dbUtils.queryfile(wycmyid) == null && db.findItemsByWhereAndWhereValue("file_id", wycmyid, com/aio/downloader/mydownload/DownloadMovieItem, "downloadtask2", null).size() == 0)
                {
                    view = new MyAppInfo(getApplicationContext());
                    try
                    {
                        appName = view.getAppName(wycmyid);
                        appIcon2 = view.getAppIcon(wycmyid);
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        view.printStackTrace();
                    }
                    MydownloadApk_Update(wycmyid, appName, myUpver, 110, AppDetailsActivity.drawableToBitmap(appIcon2));
                    bt_dea_download.setBackgroundResource(0x7f02006e);
                    view = new Intent("setbroadUpdate");
                    sendBroadcast(view);
                    return;
                } else
                {
                    view = new Message();
                    view.what = 2;
                    handler.sendMessage(view);
                    return;
                }
            }


            
            {
                this$0 = AppDetailsActivity.this;
                super();
            }
        });
        appdetailtop = (RelativeLayout)findViewById(0x7f070097);
    }

    private void installApk()
    {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(Uri.parse((new StringBuilder("file://")).append(PRO_DIR).append(File.separator).append("cleaner.apk").toString()), "application/vnd.android.package-archive");
        startActivity(intent);
    }

    public void MydownloadApk(final String id, final String title, String s, int i)
    {
        publicTools.keyid = id;
        final long final_l = (long)Math.floor(System.currentTimeMillis() / 1000L);
        final String final_s1 = publicTools.getCode(id, final_l);
        if (final_s1.equals(""))
        {
            Toast.makeText(this, "Failed to connect server. Please try again.", 0).show();
            return;
        } else
        {
            (new AsyncTask(s, i) {

                String content;
                DownloadMovieItem d;
                HashMap options;
                final AppDetailsActivity this$0;
                String url;
                private final int val$appserial;
                private final String val$icon;
                private final String val$id;
                private final String val$title;

                protected volatile transient Object doInBackground(Object aobj[])
                {
                    return doInBackground((Void[])aobj);
                }

                protected transient Void doInBackground(Void avoid[])
                {
                    options = default_options;
                    options.put("show_header", Integer.valueOf(1));
                    options.put("redirect", Integer.valueOf(0));
                    options.put("send_cookie", Integer.valueOf(0));
                    content = publicTools.getDataFromURL(url, options);
                    if (!content.contains("Location"))
                    {
                        url = (new StringBuilder(String.valueOf(url))).append("&debug=1").toString();
                        options.put("redirect", Integer.valueOf(1));
                        content = publicTools.getDataFromURL(url, options);
                    }
                    avoid = "";
                    Matcher matcher = Pattern.compile("aio_swf_download_link: ([^\n\r\t]+)").matcher(content);
                    if (matcher.find())
                    {
                        avoid = matcher.group(1);
                    } else
                    {
                        Matcher matcher1 = Pattern.compile("Location: ([^\n\r\t]+)").matcher(content);
                        if (matcher1.find())
                        {
                            avoid = matcher1.group(1);
                        }
                    }
                    Log.v("bbbb", (new StringBuilder(String.valueOf(avoid))).append("*********").toString());
                    if (TextUtils.isEmpty(avoid))
                    {
                        avoid = new Message();
                        avoid.what = 1;
                        handler.sendMessage(avoid);
                        if (content.length() > 100)
                        {
                            avoid = content.substring(0, 100);
                        } else
                        {
                            avoid = content;
                        }
                        publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/hits.php?type=downloading&id=")).append(id).append("&status=fail_get_url&version=").append("3.3.9").append("&content=").append(avoid).toString());
                    } else
                    if (db.findItemsByWhereAndWhereValue("downloadUrl", avoid, com/aio/downloader/mydownload/DownloadMovieItem, "downloadtask2", null).size() > 0)
                    {
                        avoid = new Message();
                        avoid.what = 2;
                        handler.sendMessage(avoid);
                    } else
                    {
                        String s1 = (new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getAbsolutePath()))).append(File.separator).append(getPackageName()).toString(), (new StringBuilder(String.valueOf(id))).append(".apk").toString())).getAbsolutePath();
                        d.setDownloadUrl(avoid);
                        d.setFilePath(s1);
                        d.setDownloadState(Integer.valueOf(4));
                        d.setMovieName(title);
                        d.setMovieHeadImagePath(icon);
                        d.setFile_id(id);
                        d.setType("app");
                        d.setCat("app");
                        d.setTitle(title);
                        d.setSerial(appserial);
                        d.setCreate_time(Long.valueOf(System.currentTimeMillis()));
                        toDownload(d);
                        Myutils.getInstance();
                        Myutils.list.add(d);
                        avoid = new Message();
                        avoid.what = 3;
                        handler.sendMessage(avoid);
                    }
                    return null;
                }

                protected volatile void onPostExecute(Object obj)
                {
                    onPostExecute((Void)obj);
                }

                protected void onPostExecute(Void void1)
                {
                    super.onPostExecute(void1);
                    progress_wheel.setVisibility(8);
                    detailtoprel.setVisibility(8);
                    detailtopre2.setVisibility(0);
                    timer2 = null;
                    timer2 = new Timer();
                    timer2.schedule(new TimerTask() {

                        final _cls29 this$1;

                        public void run()
                        {
                            runOnUiThread(new Runnable() {

                                final _cls1 this$2;

                                public void run()
                                {
                                    if (pdt_progressBar1.getProgress() >= pdt_pro)
                                    {
                                        if (timer2 != null)
                                        {
                                            timer2.cancel();
                                        }
                                        return;
                                    } else
                                    {
                                        pdt_progressBar1.setProgress(pdt_progressBar1.getProgress() + 1);
                                        AppDetailsActivity appdetailsactivity = _fld0;
                                        appdetailsactivity.pdt_pro_cru = appdetailsactivity.pdt_pro_cru + 1;
                                        return;
                                    }
                                }

            
            {
                this$2 = _cls1.this;
                super();
            }
                            });
                        }


            
            {
                this$1 = _cls29.this;
                super();
            }
                    }, 400L, 400L);
                }

                protected void onPreExecute()
                {
                    super.onPreExecute();
                    progress_wheel.setVisibility(0);
                }


            
            {
                this$0 = AppDetailsActivity.this;
                id = s;
                title = s2;
                icon = s3;
                appserial = i;
                super();
                d = new DownloadMovieItem();
                url = (new StringBuilder("http://android.downloadatoz.com/_201409/market/app_get_apk.php?id=")).append(s).append("&stamp=").append(final_s1).append("&time=").append(final_l).append("&version=").append("3.3.9").toString();
                options = new HashMap();
                content = "";
            }
            }).execute(new Void[0]);
            return;
        }
    }

    public void MydownloadApk_Update(final String id, final String title, final String icon, int i, Bitmap bitmap)
    {
        publicTools.keyid = id;
        final long final_l = (long)Math.floor(System.currentTimeMillis() / 1000L);
        final String final_s1 = publicTools.getCode(id, final_l);
        if (final_s1.equals(""))
        {
            Toast.makeText(this, "Failed to connect server. Please try again.", 0).show();
            return;
        } else
        {
            (new AsyncTask(i, bitmap) {

                String content;
                DownloadMovieItem d;
                HashMap options;
                final AppDetailsActivity this$0;
                String url;
                private final int val$appserial;
                private final String val$icon;
                private final String val$id;
                private final Bitmap val$mIcon;
                private final String val$title;

                protected volatile transient Object doInBackground(Object aobj[])
                {
                    return doInBackground((Void[])aobj);
                }

                protected transient Void doInBackground(Void avoid[])
                {
                    options = default_options;
                    options.put("show_header", Integer.valueOf(1));
                    options.put("redirect", Integer.valueOf(0));
                    options.put("send_cookie", Integer.valueOf(0));
                    content = publicTools.getDataFromURL(url, options);
                    if (!content.contains("Location"))
                    {
                        url = (new StringBuilder(String.valueOf(url))).append("&debug=1").toString();
                        options.put("redirect", Integer.valueOf(1));
                        content = publicTools.getDataFromURL(url, options);
                    }
                    avoid = "";
                    Matcher matcher = Pattern.compile("aio_swf_download_link: ([^\n\r\t]+)").matcher(content);
                    if (matcher.find())
                    {
                        avoid = matcher.group(1);
                    } else
                    {
                        Matcher matcher1 = Pattern.compile("Location: ([^\n\r\t]+)").matcher(content);
                        if (matcher1.find())
                        {
                            avoid = matcher1.group(1);
                        }
                    }
                    Log.v("bbbb", (new StringBuilder(String.valueOf(avoid))).append("*****").toString());
                    if (dbUtils.queryfile(id) != null)
                    {
                        avoid = new Message();
                        avoid.what = 2;
                        handler.sendMessage(avoid);
                    } else
                    {
                        avoid = (new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getAbsolutePath()))).append(File.separator).append(getPackageName()).toString(), (new StringBuilder(String.valueOf(id))).append(".apk").toString())).getAbsolutePath();
                        d.setDownloadUrl(linkurl1);
                        d.setId(id);
                        d.setFilePath(avoid);
                        d.setDownloadState(Integer.valueOf(4));
                        d.setMovieName(title);
                        d.setMovieHeadImagePath(icon);
                        d.setFile_id(id);
                        d.setType("app");
                        d.setCat("app");
                        d.setTitle(title);
                        d.setSerial(appserial);
                        d.setCreate_time(Long.valueOf(System.currentTimeMillis()));
                        d.setMovieHeadImage(mIcon);
                        toDownload(d);
                        Myutils.getInstance();
                        Myutils.list.add(d);
                        avoid = new Message();
                        avoid.what = 3;
                        handler.sendMessage(avoid);
                    }
                    return null;
                }

                protected volatile void onPostExecute(Object obj)
                {
                    onPostExecute((Void)obj);
                }

                protected void onPostExecute(Void void1)
                {
                    super.onPostExecute(void1);
                    progress_wheel.setVisibility(8);
                    detailtopre2.setVisibility(0);
                    detailtoprel.setVisibility(8);
                    timer2 = null;
                    timer2 = new Timer();
                    timer2.schedule(new TimerTask() {

                        final _cls38 this$1;

                        public void run()
                        {
                            runOnUiThread(new Runnable() {

                                final _cls1 this$2;

                                public void run()
                                {
                                    if (pdt_progressBar1.getProgress() >= 90)
                                    {
                                        if (timer2 != null)
                                        {
                                            timer2.cancel();
                                        }
                                        return;
                                    } else
                                    {
                                        pdt_progressBar1.setProgress(pdt_progressBar1.getProgress() + 1);
                                        return;
                                    }
                                }

            
            {
                this$2 = _cls1.this;
                super();
            }
                            });
                        }


            
            {
                this$1 = _cls38.this;
                super();
            }
                    }, 1000L, 600L);
                }

                protected void onPreExecute()
                {
                    super.onPreExecute();
                    progress_wheel.setVisibility(0);
                }


            
            {
                this$0 = AppDetailsActivity.this;
                id = s;
                title = s2;
                icon = s3;
                appserial = i;
                mIcon = bitmap;
                super();
                d = new DownloadMovieItem();
                url = (new StringBuilder("http://android.downloadatoz.com/_201409/market/app_get_apk.php?id=")).append(s).append("&stamp=").append(final_s1).append("&time=").append(final_l).append("&version=").append("3.3.9").toString();
                options = new HashMap();
                content = "";
            }
            }).execute(new Void[0]);
            return;
        }
    }

    public long getFileSizes(File file)
        throws Exception
    {
        if (file.exists())
        {
            return (long)(new FileInputStream(file)).available();
        } else
        {
            file.createNewFile();
            return 0L;
        }
    }

    public void initView()
    {
        super.initView();
        try
        {
            new FinalDBChen(getmContext(), "download2.db", new DownloadMovieItem(), "downloadtask2", null);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public void onAdClicked(Ad ad)
    {
        SharedPreferencesConfig.SetClickTime(getApplicationContext(), System.currentTimeMillis() + 30000L);
        detailtogift.setImageResource(0x7f0200d7);
    }

    public void onAdLoaded(Ad ad)
    {
        Log.e("qwer", (new StringBuilder("Ad=")).append(ad).toString());
        if (nativeAdfb != ad) goto _L2; else goto _L1
_L1:
        if (nativeAdfb != null && nativeAdfb == ad) goto _L4; else goto _L3
_L3:
        return;
_L4:
        nativeAdfb.unregisterView();
        facebookad();
        isfbshow = true;
        Log.e("qwer", "onAdLoaded");
        Log.e("qwer", (new StringBuilder("nativeAd=")).append(nativeAd).toString());
        return;
_L2:
        if (nativeAd == ad && nativeAd != null && nativeAd == ad)
        {
            Log.e("qwer", "onAdLoaded_nativeAd");
            nativeAd.unregisterView();
            iv_del_fb_yuansheng.setVisibility(0);
            iv_del_fb_yuansheng1.setVisibility(8);
            facebookad_free();
            return;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    public void onClick(View view)
    {
        view.getId();
        JVM INSTR lookupswitch 6: default 64
    //                   2131165338: 65
    //                   2131165339: 85
    //                   2131165340: 1038
    //                   2131165385: 1022
    //                   2131165387: 1074
    //                   2131165392: 1058;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        return;
_L2:
        startActivity(new Intent(this, com/aio/downloader/activity/AppRecommendKeywordsActivity));
        finish();
        return;
_L3:
        SharedPreferencesConfig.SetClickTime(getApplicationContext(), System.currentTimeMillis() + 30000L);
        detailtogift.setImageResource(0x7f0200d7);
        if (isfbshow)
        {
            Toast.makeText(getApplicationContext(), "facebook", 1).show();
            return;
        }
        mRandom = (int)(Math.random() * 4D) + 1;
        if (mRandom == 1)
        {
            try
            {
                packageInfo = getPackageManager().getPackageInfo("com.evzapp.cleanmaster", 0);
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                view.printStackTrace();
            }
            if (packageInfo == null)
            {
                if (PRO_DIR_FOME.exists())
                {
                    view = new Intent("android.intent.action.VIEW");
                    view.setDataAndType(Uri.parse((new StringBuilder("file://")).append(PRO_DIR).append(File.separator).append("cleaner.apk").toString()), "application/vnd.android.package-archive");
                    view.addFlags(0x10000000);
                    startActivity(view);
                    return;
                }
                if (PRO_DIR_TO.exists())
                {
                    (new AsyncTask() {

                        final AppDetailsActivity this$0;

                        protected volatile transient Object doInBackground(Object aobj[])
                        {
                            return doInBackground((Void[])aobj);
                        }

                        protected transient Void doInBackground(Void avoid[])
                        {
                            Myutils.copyfile(PRO_DIR_TO, PRO_DIR_FOME, Boolean.valueOf(false));
                            return null;
                        }

                        protected volatile void onPostExecute(Object obj)
                        {
                            onPostExecute((Void)obj);
                        }

                        protected void onPostExecute(Void void1)
                        {
                            super.onPostExecute(void1);
                            void1 = new Intent("android.intent.action.VIEW");
                            void1.setDataAndType(Uri.parse((new StringBuilder("file://")).append(PRO_DIR).append(File.separator).append("cleaner.apk").toString()), "application/vnd.android.package-archive");
                            void1.addFlags(0x10000000);
                            startActivity(void1);
                        }

            
            {
                this$0 = AppDetailsActivity.this;
                super();
            }
                    }).execute(new Void[0]);
                    return;
                } else
                {
                    view = new Intent(getApplicationContext(), com/aio/downloader/activity/AppDetailsActivity);
                    view.putExtra("myid", "com.evzapp.cleanmaster");
                    view.addFlags(0x10000000);
                    startActivity(view);
                    return;
                }
            } else
            {
                view = getPackageManager().getLaunchIntentForPackage("com.evzapp.cleanmaster");
                view.addFlags(0x10000000);
                startActivity(view);
                return;
            }
        }
        if (mRandom != 2) goto _L9; else goto _L8
_L8:
        try
        {
            packageInfo = getApplicationContext().getPackageManager().getPackageInfo("com.freepezzle.hexcrush", 0);
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            view.printStackTrace();
        }
        if (packageInfo != null) goto _L11; else goto _L10
_L10:
        try
        {
            if (AIOCRUSHAPK.exists() && getFileSizes(AIOCRUSHAPK) >= 0x19ee4cL)
            {
                view = new Intent("android.intent.action.VIEW");
                view.setDataAndType(Uri.parse((new StringBuilder("file://")).append(AIOCRUSHAPK).toString()), "application/vnd.android.package-archive");
                startActivity(view);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            view.printStackTrace();
            return;
        }
        if (AIOCRUSHSWF.exists() && getFileSizes(AIOCRUSHSWF) >= 0x19ee4cL)
        {
            (new AsyncTask() {

                final AppDetailsActivity this$0;

                protected volatile transient Object doInBackground(Object aobj[])
                {
                    return doInBackground((Void[])aobj);
                }

                protected transient Void doInBackground(Void avoid[])
                {
                    Myutils.copyfile(AIOCRUSHSWF, AIOCRUSHAPK, Boolean.valueOf(false));
                    return null;
                }

                protected volatile void onPostExecute(Object obj)
                {
                    onPostExecute((Void)obj);
                }

                protected void onPostExecute(Void void1)
                {
                    super.onPostExecute(void1);
                    void1 = new Intent("android.intent.action.VIEW");
                    void1.setDataAndType(Uri.parse((new StringBuilder("file://")).append(AIOCRUSHAPK).toString()), "application/vnd.android.package-archive");
                    startActivity(void1);
                }

            
            {
                this$0 = AppDetailsActivity.this;
                super();
            }
            }).execute(new Void[0]);
            return;
        }
        view = new Intent(getApplicationContext(), com/aio/downloader/activity/AppDetailsActivity);
        view.putExtra("myid", "com.freepezzle.hexcrush");
        startActivity(view);
        return;
_L11:
        startActivity(getPackageManager().getLaunchIntentForPackage("com.freepezzle.hexcrush"));
        return;
_L9:
        if (mRandom != 3)
        {
            continue; /* Loop/switch isn't completed */
        }
        try
        {
            packageInfo = getPackageManager().getPackageInfo("com.allinone.callerid", 0);
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            view.printStackTrace();
        }
        if (packageInfo != null) goto _L13; else goto _L12
_L12:
        try
        {
            if (AIOCALLERAPK.exists() && getFileSizes(AIOCALLERAPK) >= 0x357458L)
            {
                view = new Intent("android.intent.action.VIEW");
                view.setDataAndType(Uri.parse((new StringBuilder("file://")).append(AIOCALLERAPK).toString()), "application/vnd.android.package-archive");
                view.addFlags(0x10000000);
                startActivity(view);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            view.printStackTrace();
            return;
        }
        if (AIOCALLERDOWN.exists() && getFileSizes(AIOCALLERDOWN) >= 0x357458L)
        {
            (new AsyncTask() {

                final AppDetailsActivity this$0;

                protected volatile transient Object doInBackground(Object aobj[])
                {
                    return doInBackground((Void[])aobj);
                }

                protected transient Void doInBackground(Void avoid[])
                {
                    Myutils.copyfile(AIOCALLERDOWN, AIOCALLERAPK, Boolean.valueOf(false));
                    return null;
                }

                protected volatile void onPostExecute(Object obj)
                {
                    onPostExecute((Void)obj);
                }

                protected void onPostExecute(Void void1)
                {
                    super.onPostExecute(void1);
                    void1 = new Intent("android.intent.action.VIEW");
                    void1.setDataAndType(Uri.parse((new StringBuilder("file://")).append(AIOCALLERAPK).toString()), "application/vnd.android.package-archive");
                    void1.addFlags(0x10000000);
                    startActivity(void1);
                }

            
            {
                this$0 = AppDetailsActivity.this;
                super();
            }
            }).execute(new Void[0]);
            return;
        }
        view = new Intent(getApplicationContext(), com/aio/downloader/activity/AppDetailsActivity);
        view.putExtra("myid", "com.allinone.callerid");
        view.addFlags(0x10000000);
        startActivity(view);
        return;
_L13:
        view = getPackageManager().getLaunchIntentForPackage("com.allinone.callerid");
        view.addFlags(0x10000000);
        startActivity(view);
        return;
        if (mRandom != 4) goto _L1; else goto _L14
_L14:
        try
        {
            packageInfo = getPackageManager().getPackageInfo("com.aioapp.battery", 0);
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            view.printStackTrace();
        }
        if (packageInfo != null) goto _L16; else goto _L15
_L15:
        try
        {
            if (AIOBATTERYAPK.exists() && getFileSizes(AIOBATTERYAPK) >= 0x377effL)
            {
                view = new Intent("android.intent.action.VIEW");
                view.setDataAndType(Uri.parse((new StringBuilder("file://")).append(AIOBATTERYAPK).toString()), "application/vnd.android.package-archive");
                view.addFlags(0x10000000);
                startActivity(view);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            view.printStackTrace();
            return;
        }
        if (AIOBATTERY.exists() && getFileSizes(AIOBATTERY) >= 0x377effL)
        {
            (new AsyncTask() {

                final AppDetailsActivity this$0;

                protected volatile transient Object doInBackground(Object aobj[])
                {
                    return doInBackground((Void[])aobj);
                }

                protected transient Void doInBackground(Void avoid[])
                {
                    Myutils.copyfile(AIOBATTERY, AIOBATTERYAPK, Boolean.valueOf(false));
                    return null;
                }

                protected volatile void onPostExecute(Object obj)
                {
                    onPostExecute((Void)obj);
                }

                protected void onPostExecute(Void void1)
                {
                    super.onPostExecute(void1);
                    void1 = new Intent("android.intent.action.VIEW");
                    void1.setDataAndType(Uri.parse((new StringBuilder("file://")).append(AIOBATTERYAPK).toString()), "application/vnd.android.package-archive");
                    void1.addFlags(0x10000000);
                    startActivity(void1);
                }

            
            {
                this$0 = AppDetailsActivity.this;
                super();
            }
            }).execute(new Void[0]);
            return;
        }
        view = new Intent(getApplicationContext(), com/aio/downloader/activity/AppDetailsActivity);
        view.putExtra("myid", "com.aioapp.battery");
        view.addFlags(0x10000000);
        startActivity(view);
        return;
_L16:
        view = getPackageManager().getLaunchIntentForPackage("com.aioapp.battery");
        view.addFlags(0x10000000);
        startActivity(view);
        return;
_L5:
        startActivity(new Intent(this, com/aio/downloader/activity/AppActivity1));
        return;
_L4:
        startActivity(new Intent(this, com/aio/downloader/activity/DownloadAppManager));
        finish();
        return;
_L7:
        startActivity(new Intent(this, com/aio/downloader/activity/MusthaveActivity));
        return;
_L6:
        startActivity(new Intent(this, com/aio/downloader/activity/PaidforFreeActivity1));
        return;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030011);
        setmContext(this);
        Myutils.getInstance();
        Myutils.type_current = "app_detail";
        PackageInfo packageinfo;
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        try
        {
            linkurl1 = getIntent().getStringExtra("linkurl");
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle) { }
        try
        {
            wycmyid = getIntent().getStringExtra("myid");
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle) { }
        try
        {
            myUpver = getIntent().getStringExtra("myupver");
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle) { }
        wocao = getIntent().getIntExtra("wocao", 0);
        caocao = getIntent().getIntExtra("caocao", 0);
        myjpush = getIntent().getIntExtra("myjpush", 0);
        bundle = new IntentFilter();
        bundle.addAction("appdetail");
        registerReceiver(appdetail, bundle);
        bundle = new IntentFilter();
        bundle.addAction("showgvappdetail");
        registerReceiver(showgvappdetail, bundle);
        bundle = new IntentFilter();
        bundle.addAction("hidegvappdetail");
        registerReceiver(hidegvappdetail, bundle);
        bundle = new IntentFilter();
        bundle.addAction("successful");
        getApplicationContext().registerReceiver(successful, bundle);
        bundle = new IntentFilter();
        bundle.addAction("pdt_del");
        getApplicationContext().registerReceiver(pdt_del, bundle);
        bundle = new IntentFilter();
        bundle.addAction("intent_start");
        getApplicationContext().registerReceiver(intent_start, bundle);
        bundle = new IntentFilter();
        bundle.addAction("intent_pause");
        getApplicationContext().registerReceiver(intent_pause, bundle);
        bundle = new IntentFilter();
        bundle.addAction("delete");
        getApplicationContext().registerReceiver(delete, bundle);
        bundle = new IntentFilter();
        bundle.addAction("pdt_failure");
        getApplicationContext().registerReceiver(pdt_failure, bundle);
        init();
        buildListener();
        try
        {
            initView();
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle) { }
        try
        {
            id = getIntent().getStringExtra("myid");
            tuijianboolean = Boolean.valueOf(getIntent().getBooleanExtra("tuijianboolean", false));
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle) { }
        if (publicTools.isNetworkAvailable(getApplicationContext()))
        {
            try
            {
                (new Mya1()).execute(new Void[0]);
                (new Myagv2()).execute(new Void[0]);
                (new Myagv1()).execute(new Void[0]);
                (new Myagv()).execute(new Void[0]);
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                Log.e("gak", "catch!!!");
            }
        }
        failfile();
        banner_type_name = sp_config.getString("banner_type", "admob");
        if (banner_type_name.equals("admob"))
        {
            bundle = new AdView(this, AdSize.SMART_BANNER, "ca-app-pub-2192624499353475/5842010949");
            banner.addView(bundle);
            bundle.loadAd(new AdRequest());
        }
        try
        {
            adView = new com.facebook.ads.AdView(this, "340186902832477_407365439447956", com.facebook.ads.AdSize.BANNER_HEIGHT_50);
            banner.addView(adView);
            adView.setAdListener(new AdListener() {

                final AppDetailsActivity this$0;

                public void onAdClicked(Ad ad)
                {
                }

                public void onAdLoaded(Ad ad)
                {
                }

                public void onError(Ad ad, AdError aderror)
                {
                    Log.e("rtrtr", (new StringBuilder()).append(aderror).toString());
                }

            
            {
                this$0 = AppDetailsActivity.this;
                super();
            }
            });
            adView.loadAd();
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle) { }
        mygallery.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final AppDetailsActivity this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                Log.e("www", (new StringBuilder("(Serializable) list")).append(list).toString());
                adapterview = new Intent(AppDetailsActivity.this, com/aio/downloader/activity/ImagePagerActivity);
                adapterview.putExtra("screenshotlist", list);
                adapterview.putExtra("screenshotpos", i);
                startActivity(adapterview);
            }

            
            {
                this$0 = AppDetailsActivity.this;
                super();
            }
        });
        appdetailgv.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final AppDetailsActivity this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                adapterview = new Intent(AppDetailsActivity.this, com/aio/downloader/activity/AppDetailsActivity);
                adapterview.putExtra("myid", ((DownloadMovieItem)gvlist.get(i)).getId());
                startActivity(adapterview);
            }

            
            {
                this$0 = AppDetailsActivity.this;
                super();
            }
        });
        appdetailgvwyc1.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final AppDetailsActivity this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                adapterview = new Intent(AppDetailsActivity.this, com/aio/downloader/activity/AppDetailsActivity);
                adapterview.putExtra("myid", ((DownloadMovieItem)gvlist1.get(i)).getId());
                startActivity(adapterview);
            }

            
            {
                this$0 = AppDetailsActivity.this;
                super();
            }
        });
        appdetailgvwyc2.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final AppDetailsActivity this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                adapterview = new Intent(AppDetailsActivity.this, com/aio/downloader/activity/AppDetailsActivity);
                adapterview.putExtra("myid", ((DownloadMovieItem)gvlist2.get(i)).getId());
                startActivity(adapterview);
            }

            
            {
                this$0 = AppDetailsActivity.this;
                super();
            }
        });
        nativeAdfb = new NativeAd(this, "340186902832477_401790893338744");
        nativeAdfb.setAdListener(this);
        nativeAdfb.loadAd(com.facebook.ads.NativeAd.MediaCacheFlag.ALL);
        nativeAd = new NativeAd(this, "340186902832477_411793712338462");
        nativeAd.setAdListener(this);
        nativeAd.loadAd(com.facebook.ads.NativeAd.MediaCacheFlag.ALL);
        try
        {
            typeFace = Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf");
            typeFace2 = Typeface.createFromAsset(getAssets(), "Roboto-Condensed.ttf");
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle) { }
        tv_short_desc.setTypeface(typeFace);
        if (getIntent().getIntExtra("xiazaidianchi", 0) != 1) goto _L2; else goto _L1
_L1:
        bundle = null;
        packageinfo = getPackageManager().getPackageInfo("com.aioapp.battery", 0);
        bundle = packageinfo;
_L6:
        if (bundle != null) goto _L2; else goto _L3
_L3:
        (new AsyncTask() {

            final AppDetailsActivity this$0;

            protected volatile transient Object doInBackground(Object aobj[])
            {
                return doInBackground((Void[])aobj);
            }

            protected transient Void doInBackground(Void avoid[])
            {
                try
                {
                    publicTools.getUrl("http://android.downloadatoz.com/_201409/market/hits.php?type=app&id=com.freeapp.batterysaver&from=apk");
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[]) { }
                return null;
            }

            protected volatile void onPostExecute(Object obj)
            {
                onPostExecute((Void)obj);
            }

            protected void onPostExecute(Void void1)
            {
                super.onPostExecute(void1);
            }

            
            {
                this$0 = AppDetailsActivity.this;
                super();
            }
        }).execute(new Void[0]);
        if (!spnetworkre.getBoolean("isopen", false) || NetWorkUtil.getAPNType(getApplicationContext()) == 1) goto _L5; else goto _L4
_L4:
        downwifi();
_L8:
        return;
        namenotfoundexception;
        namenotfoundexception.printStackTrace();
          goto _L6
        bundle;
_L2:
        if (ll_free.getVisibility() != 0) goto _L8; else goto _L7
_L7:
        MobclickAgent.onEvent(getApplicationContext(), "pdt_caller");
        return;
_L5:
        if (dbUtils.queryfile("com.freeapp.batterysaver") != null) goto _L2; else goto _L9
_L9:
        MydownloadApk("com.freeapp.batterysaver", "Battery Saver", "https://lh6.ggpht.com/ydrkz1lV1GLQHwjwcyabk6TDxOdpi3MHlv-hl1kU1SP5eQqZ304XoY5rq_2ECjJwNxs=w300", 0x123983);
          goto _L2
    }

    public void onError(Ad ad, AdError aderror)
    {
        inmobtop.setVisibility(8);
        Log.e("qwer", "onError");
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (i == 4)
        {
            if (widgetdetailfan && !Myutils.detail_save || caocao == 1 || myjpush == 1)
            {
                Intent intent = new Intent(getApplicationContext(), com/aio/downloader/activity/MyMainActivity);
                intent.putExtra("acquire_url_start", "");
                startActivity(intent);
                finish();
            } else
            {
                finish();
            }
        }
        return super.onKeyDown(i, keyevent);
    }

    protected void onPause()
    {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    protected void onResume()
    {
        int i;
        super.onResume();
        MobclickAgent.onResume(this);
        PackageInfo packageinfo;
        MyAppInfo myappinfo;
        try
        {
            packageinfo = getPackageManager().getPackageInfo(wycmyid, 0);
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            packageinfo = null;
            namenotfoundexception.printStackTrace();
        }
        myappinfo = new MyAppInfo(getApplicationContext());
        try
        {
            myVer = myappinfo.getAppVersion(wycmyid);
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception1)
        {
            namenotfoundexception1.printStackTrace();
        }
        if (packageinfo == null)
        {
            downloadapk_install.setText("Install");
        } else
        {
            downloadapk_install.setText("Open");
        }
        if (wocao != 1) goto _L2; else goto _L1
_L1:
        if (!myUpver.equals(myVer) || packageinfo == null) goto _L4; else goto _L3
_L3:
        try
        {
            downloadapk_install.setText("Open");
        }
        catch (Exception exception) { }
_L2:
        db = new FinalDBChen(this, getDatabasePath("download2.db").getAbsolutePath());
        ds = db.findItemsByWhereAndWhereValue(null, null, com/aio/downloader/mydownload/DownloadMovieItem, "downloadtask2", null);
        i = ds.size();
        {
            if (i == 0)
            {
                break; /* Loop/switch isn't completed */
            }
            try
            {
                badgedownimg.setText(String.valueOf(i));
                badgedownimg.show();
            }
            catch (Exception exception1) { }
        }
        (new Timer()).schedule(new TimerTask() {

            final AppDetailsActivity this$0;

            public void run()
            {
                Message message = new Message();
                message.what = 30000;
                handler.sendMessage(message);
            }

            
            {
                this$0 = AppDetailsActivity.this;
                super();
            }
        }, 3000L, 10000L);
        return;
_L4:
        downloadapk_install.setText("Update");
        if (true) goto _L2; else goto _L5
_L5:
        if (i != 0)
        {
            break MISSING_BLOCK_LABEL_169;
        }
        badgedownimg.hide();
        break MISSING_BLOCK_LABEL_169;
    }

    public void toDownload(DownloadMovieItem downloadmovieitem)
    {
        downloadmovieitem.setDownloadState(Integer.valueOf(7));
        getMyApp().setStartDownloadMovieItem(downloadmovieitem);
        sendBroadcast((new Intent()).setAction("download_aio"));
        if (db.findItemsByWhereAndWhereValue("movieName", downloadmovieitem.getMovieName(), com/aio/downloader/mydownload/DownloadMovieItem, "downloadtask2", null).size() == 0)
        {
            db.insertObject(downloadmovieitem, "downloadtask2");
            return;
        } else
        {
            db.updateValuesByJavaBean("downloadtask2", "movieName=?", new String[] {
                downloadmovieitem.getMovieName()
            }, downloadmovieitem);
            return;
        }
    }































































































}
