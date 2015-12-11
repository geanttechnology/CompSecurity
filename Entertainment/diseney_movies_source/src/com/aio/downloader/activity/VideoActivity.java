// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.aio.downloader.adapter.VideoListviewAdapter;
import com.aio.downloader.dialog.ErrorDialog;
import com.aio.downloader.dialog.RestaryDownloadDialog;
import com.aio.downloader.dialog.VideoDownloadDialog;
import com.aio.downloader.model.VideoModel;
import com.aio.downloader.mydownload.BaseActivity;
import com.aio.downloader.mydownload.DownloadMovieItem;
import com.aio.downloader.mydownload.MyApplcation;
import com.aio.downloader.utils.DisplayUtil;
import com.aio.downloader.utils.Myutils;
import com.aio.downloader.utils.ProgressWheel;
import com.aio.downloader.utils.publicTools;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;
import com.umeng.analytics.MobclickAgent;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.tsz.afinal.FinalDBChen;
import org.json.JSONArray;
import org.json.JSONObject;

public class VideoActivity extends BaseActivity
    implements android.view.View.OnClickListener
{
    class MyAsyncTask extends AsyncTask
    {

        final VideoActivity this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient ArrayList doInBackground(Void avoid[])
        {
            Object obj;
            obj = publicTools.getUrl(video_info_url);
            avoid = new ArrayList();
            if (obj != null) goto _L2; else goto _L1
_L1:
            Error_dialog();
_L6:
            return avoid;
_L2:
            HashMap hashmap = new HashMap();
            hashmap.put("content", obj);
            obj = publicTools.doHttpPost("http://android.downloadatoz.com/_201409/market/youtube_parse.php", hashmap);
            String s;
            String s1;
            Object obj1;
            obj1 = new JSONObject(((String) (obj)));
            if (((JSONObject) (obj1)).getInt("status") != 1)
            {
                continue; /* Loop/switch isn't completed */
            }
            obj = ((JSONObject) (obj1)).getString("img");
            s = ((JSONObject) (obj1)).getString("id");
            s1 = ((JSONObject) (obj1)).getString("title");
            if (s == null)
            {
                try
                {
                    Error_dialog();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    ((Exception) (obj)).printStackTrace();
                    return avoid;
                }
                return avoid;
            }
            obj1 = ((JSONObject) (obj1)).getJSONArray("downloads");
            int i = 0;
_L4:
            if (i >= ((JSONArray) (obj1)).length())
            {
                continue; /* Loop/switch isn't completed */
            }
            model = new VideoModel();
            Object obj2 = ((JSONArray) (obj1)).getJSONObject(i);
            model.setVideo_item_format(((JSONObject) (obj2)).getString("format"));
            model.setVideo_item_type(((JSONObject) (obj2)).getString("type"));
            model.setVideo_item_title(s1);
            model.setVideo_item_id(s);
            model.setVideo_item_img(((String) (obj)));
            obj2 = ((JSONObject) (obj2)).getString("url");
            model.setVideo_item_url(((String) (obj2)));
            avoid.add(model);
            i++;
            if (true) goto _L4; else goto _L3
_L3:
            if (true) goto _L6; else goto _L5
_L5:
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((ArrayList)obj);
        }

        protected void onPostExecute(ArrayList arraylist)
        {
            super.onPostExecute(arraylist);
            tvloading.setVisibility(8);
            progressWheel.setVisibility(8);
            if (arraylist.size() == 0)
            {
                final RestaryDownloadDialog restarydialog = new RestaryDownloadDialog(VideoActivity.this, 0x7f0c000e);
                restarydialog.setCanceledOnTouchOutside(false);
                restarydialog.show();
                Button button = (Button)restarydialog.findViewById(0x7f07038b);
                Button button1 = (Button)restarydialog.findViewById(0x7f07038c);
                button.setOnClickListener(restarydialog. new android.view.View.OnClickListener() {

                    final MyAsyncTask this$1;
                    private final RestaryDownloadDialog val$restarydialog;

                    public void onClick(View view)
                    {
                        restarydialog.dismiss();
                    }

            
            {
                this$1 = final_myasynctask;
                restarydialog = RestaryDownloadDialog.this;
                super();
            }
                });
                button1.setOnClickListener(arraylist. new android.view.View.OnClickListener() {

                    final MyAsyncTask this$1;
                    private final ArrayList val$list;
                    private final RestaryDownloadDialog val$restarydialog;

                    public void onClick(View view)
                    {
                        restarydialog.dismiss();
                        (new MyAsyncTask()).execute(new Void[0]);
                        dowload_video(list);
                    }

            
            {
                this$1 = final_myasynctask;
                restarydialog = restarydownloaddialog;
                list = ArrayList.this;
                super();
            }
                });
                return;
            } else
            {
                dowload_video(arraylist);
                return;
            }
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            progressWheel.setVisibility(0);
            tvloading.setVisibility(0);
        }


        MyAsyncTask()
        {
            this$0 = VideoActivity.this;
            super();
        }
    }

    public class Mywebview extends WebViewClient
    {

        final VideoActivity this$0;

        public void onPageFinished(WebView webview, String s)
        {
            progressWheel.setVisibility(8);
            super.onPageFinished(webview, s);
        }

        public void onPageStarted(WebView webview, String s, Bitmap bitmap)
        {
            progressWheel.setVisibility(0);
            super.onPageStarted(webview, s, bitmap);
        }

        public void onReceivedError(WebView webview, int i, String s, String s1)
        {
            super.onReceivedError(webview, i, s, s1);
            videowebview.loadData("", "text/html", "UTF-8");
            net_hint_img_list.setVisibility(0);
        }

        public WebResourceResponse shouldInterceptRequest(WebView webview, String s)
        {
            if (!s.contains("//m.youtube.com")) goto _L2; else goto _L1
_L1:
            Matcher matcher;
            Log.v("lklk", (new StringBuilder("load:")).append(s).toString());
            matcher = Pattern.compile("/watch\\?.*v=([^&]+)").matcher(s);
            if (!matcher.find()) goto _L4; else goto _L3
_L3:
            Log.v("cvcv", (new StringBuilder("GOOD:")).append(s).append("     id:").append(matcher.group(1)).toString());
            Message message1 = new Message();
            message1.what = 1;
            hander.sendMessage(message1);
            video_info_url = (new StringBuilder("http://www.youtube.com/get_video_info?&video_id=")).append(matcher.group(1)).append("&asv=3&el=detailpage&hl=en_US").toString();
            Log.i("getUrl", video_info_url);
_L2:
            return super.shouldInterceptRequest(webview, s);
_L4:
            if (!s.contains("/feed") && !s.contains("/_get_ads") && !s.contains("/guide_ajax"))
            {
                Log.v("cvcv", (new StringBuilder("BAD:")).append(s).toString());
                Message message = new Message();
                message.what = 2;
                hander.sendMessage(message);
            }
            if (true) goto _L2; else goto _L5
_L5:
        }

        public Mywebview()
        {
            this$0 = VideoActivity.this;
            super();
        }
    }


    private static Typeface typeFace = null;
    private AdView adView;
    private VideoListviewAdapter adapter;
    private MyApplcation app;
    private String banner_type_name;
    private FinalDBChen db;
    private ImageView fan;
    Handler hander;
    private LinearLayout lieshow;
    private VideoModel model;
    private ImageView mychafan;
    private ImageView net_hint_img_list;
    private ProgressWheel progressWheel;
    private SharedPreferences sp_config;
    private TextView tvloading;
    private ImageView video_download_img;
    private ListView video_download_item_listview;
    private String video_home_url;
    private String video_info_url;
    private TextView video_title;
    private LinearLayout videobanner;
    private Button videodownloader;
    private Button videodownloader2;
    private RelativeLayout videojianpan;
    private Button videoreload;
    private TextView videotitle;
    private WebView videowebview;
    private Mywebview webviewclient;

    public VideoActivity()
    {
        hander = new Handler() {

            final VideoActivity this$0;

            public void handleMessage(Message message)
            {
                super.handleMessage(message);
                switch (message.what)
                {
                default:
                    return;

                case 1: // '\001'
                    videodownloader.setVisibility(0);
                    videodownloader2.setVisibility(8);
                    tvloading.setVisibility(8);
                    progressWheel.setVisibility(8);
                    return;

                case 2: // '\002'
                    videodownloader2.setVisibility(0);
                    videodownloader.setVisibility(8);
                    return;

                case 3: // '\003'
                    adapter.notifyDataSetChanged();
                    break;
                }
            }

            
            {
                this$0 = VideoActivity.this;
                super();
            }
        };
        video_home_url = "http://m.youtube.com/";
        video_info_url = "";
        progressWheel = null;
        sp_config = null;
    }

    private void Bottom2()
    {
        android.widget.LinearLayout.LayoutParams layoutparams = (android.widget.LinearLayout.LayoutParams)lieshow.getLayoutParams();
        layoutparams.setMargins(0, 0, 0, 0);
        lieshow.setLayoutParams(layoutparams);
    }

    private void Error_dialog()
    {
        final ErrorDialog dialog = new ErrorDialog(this, 0x7f0c000e);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        ((Button)dialog.findViewById(0x7f07001e)).setOnClickListener(new android.view.View.OnClickListener() {

            final VideoActivity this$0;
            private final ErrorDialog val$dialog;

            public void onClick(View view)
            {
                dialog.dismiss();
            }

            
            {
                this$0 = VideoActivity.this;
                dialog = errordialog;
                super();
            }
        });
    }

    private void Mydialog()
    {
        (new android.app.AlertDialog.Builder(this)).setTitle(getString(0x7f0b0034)).setMessage("It has been in downloading list already.").setPositiveButton("Ok", new android.content.DialogInterface.OnClickListener() {

            final VideoActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

            
            {
                this$0 = VideoActivity.this;
                super();
            }
        }).show();
    }

    private void Mywebview1()
    {
        android.widget.RelativeLayout.LayoutParams layoutparams = (android.widget.RelativeLayout.LayoutParams)videowebview.getLayoutParams();
        layoutparams.setMargins(0, 0, 0, DisplayUtil.dip2px(this, 88F));
        videowebview.setLayoutParams(layoutparams);
    }

    private void Mywebview2()
    {
        android.widget.RelativeLayout.LayoutParams layoutparams = (android.widget.RelativeLayout.LayoutParams)videowebview.getLayoutParams();
        layoutparams.setMargins(0, 0, 0, DisplayUtil.dip2px(this, 38F));
        videowebview.setLayoutParams(layoutparams);
    }

    private void buildListener()
    {
        fan.setOnClickListener(this);
        mychafan.setOnClickListener(this);
        videodownloader.setOnClickListener(this);
        videodownloader2.setOnClickListener(this);
        videoreload.setOnClickListener(this);
        videowebview.setOnKeyListener(new android.view.View.OnKeyListener() {

            final VideoActivity this$0;

            public boolean onKey(View view, int i, KeyEvent keyevent)
            {
label0:
                {
label1:
                    {
                        if (keyevent.getAction() != 0 || i != 4 || !videowebview.canGoBack())
                        {
                            break label0;
                        }
                        videowebview.goBack();
                        if (videowebview.getUrl().contains("//m.youtube.com"))
                        {
                            if (!videowebview.getUrl().contains("v="))
                            {
                                break label1;
                            }
                            view = new Message();
                            view.what = 1;
                            hander.sendMessage(view);
                        }
                        return true;
                    }
                    view = new Message();
                    view.what = 2;
                    hander.sendMessage(view);
                    return true;
                }
                return false;
            }

            
            {
                this$0 = VideoActivity.this;
                super();
            }
        });
    }

    private void dowload_video(final ArrayList list)
    {
        final VideoDownloadDialog dialog = new VideoDownloadDialog(this, 0x7f0c000e);
        dialog.setCanceledOnTouchOutside(false);
        if (list.size() > 0)
        {
            dialog.show();
            video_download_img = (ImageView)dialog.findViewById(0x7f070403);
            videotitle = (TextView)dialog.findViewById(0x7f070404);
            video_download_item_listview = (ListView)dialog.findViewById(0x7f070405);
            app.asyncLoadImage(model.getVideo_item_img(), video_download_img);
            videotitle.setText(model.getVideo_item_title());
            (new Thread(new Runnable() {

                final VideoActivity this$0;
                private final ArrayList val$list;

                public void run()
                {
                    int i = 0;
                    do
                    {
                        if (i >= list.size())
                        {
                            return;
                        }
                        try
                        {
                            Object obj = (HttpURLConnection)(new URL(((VideoModel)list.get(i)).getVideo_item_url())).openConnection();
                            ((HttpURLConnection) (obj)).setRequestProperty("Accept-Encoding", "identity");
                            ((HttpURLConnection) (obj)).connect();
                            obj = (new StringBuilder(String.valueOf(((HttpURLConnection) (obj)).getContentLength()))).toString();
                            Log.v("sss", (new StringBuilder(String.valueOf(((VideoModel)list.get(i)).getVideo_item_url()))).append(":").append(((String) (obj))).toString());
                            ((VideoModel)list.get(i)).setVideo_item_size(((String) (obj)));
                            obj = new Message();
                            obj.what = 3;
                            hander.sendMessage(((Message) (obj)));
                        }
                        catch (Exception exception)
                        {
                            exception.printStackTrace();
                        }
                        i++;
                    } while (true);
                }

            
            {
                this$0 = VideoActivity.this;
                list = arraylist;
                super();
            }
            })).start();
            adapter = new VideoListviewAdapter(this, list);
            video_download_item_listview.setAdapter(adapter);
            video_download_item_listview.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

                final VideoActivity this$0;
                private final VideoDownloadDialog val$dialog;
                private final ArrayList val$list;

                public void onItemClick(AdapterView adapterview, View view, int i, long l)
                {
                    try
                    {
                        VideoDownload(((VideoModel)list.get(i)).getVideo_item_id(), ((VideoModel)list.get(i)).getVideo_item_title(), ((VideoModel)list.get(i)).getVideo_item_url(), ((VideoModel)list.get(i)).getVideo_item_img());
                        (new Thread(i. new Runnable() {

                            final _cls4 this$1;
                            private final ArrayList val$list;
                            private final int val$position;

                            public void run()
                            {
                                publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/hits.php?type=youtube&id=")).append(((VideoModel)list.get(position)).getVideo_item_id()).toString());
                            }

            
            {
                this$1 = final__pcls4;
                list = arraylist;
                position = I.this;
                super();
            }
                        })).start();
                    }
                    // Misplaced declaration of an exception variable
                    catch (AdapterView adapterview)
                    {
                        adapterview.printStackTrace();
                    }
                    dialog.dismiss();
                }

            
            {
                this$0 = VideoActivity.this;
                list = arraylist;
                dialog = videodownloaddialog;
                super();
            }
            });
        }
    }

    private void init()
    {
        videojianpan = (RelativeLayout)findViewById(0x7f0703f7);
        sp_config = getSharedPreferences("banner_type", 0);
        fan = (ImageView)findViewById(0x7f0703f8);
        tvloading = (TextView)findViewById(0x7f0703fd);
        video_title = (TextView)findViewById(0x7f0703f9);
        videowebview = (WebView)findViewById(0x7f0703fc);
        mychafan = (ImageView)findViewById(0x7f0703fa);
        videobanner = (LinearLayout)findViewById(0x7f070402);
        progressWheel = (ProgressWheel)findViewById(0x7f070072);
        net_hint_img_list = (ImageView)findViewById(0x7f070274);
        net_hint_img_list.setVisibility(8);
        videodownloader = (Button)findViewById(0x7f0703ff);
        videodownloader2 = (Button)findViewById(0x7f070400);
        videoreload = (Button)findViewById(0x7f070401);
        lieshow = (LinearLayout)findViewById(0x7f0703fe);
        app = (MyApplcation)getApplicationContext();
        if (typeFace == null)
        {
            typeFace = Typeface.createFromAsset(getAssets(), "font.ttf");
        }
        video_title.setTypeface(typeFace);
        banner_type_name = sp_config.getString("banner_type", "admob");
        if (banner_type_name.equals("admob"))
        {
            adView = new AdView(this, AdSize.SMART_BANNER, "ca-app-pub-2192624499353475/5842010949");
            videobanner.addView(adView);
            adView.loadAd(new AdRequest());
            Mywebview1();
            return;
        } else
        {
            Bottom2();
            Mywebview2();
            return;
        }
    }

    public void VideoDownload(String s, String s1, String s2, String s3)
    {
        DownloadMovieItem downloadmovieitem = new DownloadMovieItem();
        if (db.findItemsByWhereAndWhereValue("file_id", s, com/aio/downloader/mydownload/DownloadMovieItem, "downloadtask2", null).size() > 0)
        {
            Mydialog();
            return;
        } else
        {
            String s4 = (new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getAbsolutePath()))).append(File.separator).append(getPackageName()).toString(), (new StringBuilder(String.valueOf(s))).append(".").append(model.getVideo_item_format()).toString())).getAbsolutePath();
            downloadmovieitem.setDownloadUrl(s2);
            Log.v("erer", s2);
            downloadmovieitem.setFilePath(s4);
            downloadmovieitem.setDownloadState(Integer.valueOf(4));
            downloadmovieitem.setMovieName(s1);
            downloadmovieitem.setFile_id(s);
            Log.v("sdsd", (new StringBuilder(String.valueOf(s2))).append("********").append(s).append("*********").append(s1).append("**********").append(model.getVideo_item_format()).toString());
            downloadmovieitem.setMovieHeadImagePath(s3);
            downloadmovieitem.setType("video");
            downloadmovieitem.setCreate_time(Long.valueOf(System.currentTimeMillis()));
            toDownload(downloadmovieitem);
            Myutils.getInstance();
            Myutils.list.add(downloadmovieitem);
            Toast.makeText(getApplicationContext(), (new StringBuilder("'")).append(downloadmovieitem.getMovieName()).append("' is added to download queue.").toString(), 0).show();
            return;
        }
    }

    public void initView()
    {
        super.initView();
        new FinalDBChen(getmContext(), "download2.db", new DownloadMovieItem(), "downloadtask2", null);
    }

    public void onClick(View view)
    {
        view.getId();
        JVM INSTR lookupswitch 4: default 48
    //                   2131166200: 49
    //                   2131166202: 149
    //                   2131166207: 154
    //                   2131166209: 171;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return;
_L2:
        if (videowebview.canGoBack())
        {
            videowebview.goBack();
            if (videowebview.getUrl().contains("//m.youtube.com"))
            {
                if (videowebview.getUrl().contains("v="))
                {
                    view = new Message();
                    view.what = 1;
                    hander.sendMessage(view);
                    return;
                } else
                {
                    view = new Message();
                    view.what = 2;
                    hander.sendMessage(view);
                    return;
                }
            }
        } else
        {
            finish();
            return;
        }
          goto _L1
_L3:
        finish();
        return;
_L4:
        (new MyAsyncTask()).execute(new Void[0]);
        return;
_L5:
        videowebview.loadUrl(videowebview.getUrl());
        return;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0300bd);
        db = new FinalDBChen(getmContext(), getDatabasePath("download2.db").getAbsolutePath());
        initView();
        init();
        buildListener();
        videowebview.getSettings().setJavaScriptEnabled(true);
        webviewclient = new Mywebview();
        videowebview.setWebViewClient(webviewclient);
        videowebview.loadUrl(video_home_url);
        videodownloader2.setVisibility(0);
        videodownloader.setVisibility(8);
        videowebview.setBackgroundColor(Color.argb(0, 0, 0, 0));
    }

    protected void onPause()
    {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    protected void onResume()
    {
        super.onResume();
        MobclickAgent.onResume(this);
    }

    public void toDownload(DownloadMovieItem downloadmovieitem)
    {
        Log.v("mymy", "ssssss");
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
