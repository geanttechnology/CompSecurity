// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.cleaner;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.aio.downloader.activity.DownloadAppManager;
import com.aio.downloader.db.TypeDbUtils;
import com.aio.downloader.dialog.LianwangDialog;
import com.aio.downloader.mydownload.BaseActivity;
import com.aio.downloader.mydownload.DownloadMovieItem;
import com.aio.downloader.mydownload.MyApplcation;
import com.aio.downloader.utils.Myutils;
import com.aio.downloader.utils.NetWorkUtil;
import com.aio.downloader.utils.ProgressWheel;
import com.aio.downloader.utils.publicTools;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.tsz.afinal.FinalDBChen;

public class ShowCleanActivity_Rub extends BaseActivity
{

    private Button btnfinish;
    private String cleanSize;
    private double cont;
    private FinalDBChen db;
    private TypeDbUtils dbUtils;
    private HashMap default_options;
    private List ds;
    private boolean flag;
    Handler handler;
    private Handler handlerdonghua;
    private ImageView header_left_showclean;
    private ProgressWheel progress_wheel;
    private publicTools publictools;
    private RelativeLayout relaquan;
    private Double roundDouble1;
    private SharedPreferences spnetworkre;
    private TextView tv_jieguo;

    public ShowCleanActivity_Rub()
    {
        handler = new Handler() {

            final ShowCleanActivity_Rub this$0;

            public void handleMessage(Message message)
            {
                super.handleMessage(message);
                switch (message.what)
                {
                default:
                    return;

                case 1: // '\001'
                    Toast.makeText(ShowCleanActivity_Rub.this, "Failed to connect server.", 0).show();
                    return;

                case 2: // '\002'
                    Mydialog();
                    return;

                case 3: // '\003'
                    Toast.makeText(ShowCleanActivity_Rub.this, "'AIO Cleaner' is added to download queue.", 0).show();
                    break;
                }
                finish();
                message = new Intent(ShowCleanActivity_Rub.this, com/aio/downloader/activity/DownloadAppManager);
                message.setFlags(0x10000000);
                startActivity(message);
                publicTools.cleanertag = false;
            }

            
            {
                this$0 = ShowCleanActivity_Rub.this;
                super();
            }
        };
        dbUtils = null;
        publictools = null;
        flag = true;
        cont = 0.0D;
        handlerdonghua = new Handler() {

            final ShowCleanActivity_Rub this$0;

            public void handleMessage(Message message)
            {
                super.handleMessage(message);
                relaquan.setVisibility(0);
            }

            
            {
                this$0 = ShowCleanActivity_Rub.this;
                super();
            }
        };
    }

    private void Mydialog()
    {
        (new android.app.AlertDialog.Builder(this)).setTitle(getString(0x7f0b0034)).setMessage("It has been in downloading list already.").setPositiveButton("Ok", new android.content.DialogInterface.OnClickListener() {

            final ShowCleanActivity_Rub this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
                dialoginterface = new Intent(getApplicationContext(), com/aio/downloader/activity/DownloadAppManager);
                startActivity(dialoginterface);
                publicTools.cleanertag = false;
                finish();
            }

            
            {
                this$0 = ShowCleanActivity_Rub.this;
                super();
            }
        }).show();
    }

    private void downwifi()
    {
        final LianwangDialog dialog = new LianwangDialog(this, 0x7f0c000e);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        Button button = (Button)dialog.findViewById(0x7f070141);
        Button button1 = (Button)dialog.findViewById(0x7f070142);
        button.setOnClickListener(new android.view.View.OnClickListener() {

            final ShowCleanActivity_Rub this$0;
            private final LianwangDialog val$dialog;

            public void onClick(View view)
            {
                dialog.dismiss();
            }

            
            {
                this$0 = ShowCleanActivity_Rub.this;
                dialog = lianwangdialog;
                super();
            }
        });
        button1.setOnClickListener(new android.view.View.OnClickListener() {

            final ShowCleanActivity_Rub this$0;
            private final LianwangDialog val$dialog;

            public void onClick(View view)
            {
                startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
                dialog.dismiss();
            }

            
            {
                this$0 = ShowCleanActivity_Rub.this;
                dialog = lianwangdialog;
                super();
            }
        });
    }

    private void init()
    {
        progress_wheel = (ProgressWheel)findViewById(0x7f070072);
        publictools = new publicTools(this);
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
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public static Double roundDouble(double d, int i)
    {
        double d1 = i;
        try
        {
            d1 = Math.pow(10D, d1);
            d = Math.floor(d * d1 + 0.5D) / d1;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return null;
        }
        return Double.valueOf(d);
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
                final ShowCleanActivity_Rub this$0;
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
                }

                protected void onPreExecute()
                {
                    super.onPreExecute();
                    progress_wheel.setVisibility(0);
                }

            
            {
                this$0 = ShowCleanActivity_Rub.this;
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

    protected void onCreate(Bundle bundle)
    {
        requestWindowFeature(1);
        super.onCreate(bundle);
        setContentView(0x7f0300b1);
        init();
        initView();
        relaquan = (RelativeLayout)findViewById(0x7f0703cb);
        relaquan.setOnClickListener(new android.view.View.OnClickListener() {

            final ShowCleanActivity_Rub this$0;

            public void onClick(View view)
            {
                try
                {
                    (new AsyncTask() {

                        final _cls3 this$1;

                        protected volatile transient Object doInBackground(Object aobj[])
                        {
                            return doInBackground((Void[])aobj);
                        }

                        protected transient Void doInBackground(Void avoid[])
                        {
                            try
                            {
                                publicTools.getUrl("http://android.downloadatoz.com/_201409/market/hits.php?type=app&id=com.evzapp.cleanmaster&from=apk");
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
                this$1 = _cls3.this;
                super();
            }
                    }).execute(new Void[0]);
                    if (spnetworkre.getBoolean("isopen", false) && NetWorkUtil.getAPNType(getApplicationContext()) != 1)
                    {
                        downwifi();
                        return;
                    }
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    return;
                }
                if (dbUtils.queryfile("com.evzapp.cleanmaster") == null)
                {
                    MydownloadApk("com.evzapp.cleanmaster", "AIO Cleaner & Speed Booster", "https://lh3.googleusercontent.com/b8eWJD74_yw7BqWv0FER9nnJXX_7ihY1Y3pjxJ111xH6q_syFWRVGvcatpgiDaXiJk9l=w300", 0x149a37);
                    return;
                }
                Mydialog();
                return;
            }

            
            {
                this$0 = ShowCleanActivity_Rub.this;
                super();
            }
        });
        btnfinish = (Button)findViewById(0x7f0703b5);
        btnfinish.setOnClickListener(new android.view.View.OnClickListener() {

            final ShowCleanActivity_Rub this$0;

            public void onClick(View view)
            {
                view = new Intent(getApplicationContext(), com/aio/downloader/activity/DownloadAppManager);
                startActivity(view);
                publicTools.cleanertag = false;
                finish();
            }

            
            {
                this$0 = ShowCleanActivity_Rub.this;
                super();
            }
        });
        header_left_showclean = (ImageView)findViewById(0x7f0703b0);
        header_left_showclean.setOnClickListener(new android.view.View.OnClickListener() {

            final ShowCleanActivity_Rub this$0;

            public void onClick(View view)
            {
                view = new Intent(getApplicationContext(), com/aio/downloader/activity/DownloadAppManager);
                startActivity(view);
                publicTools.cleanertag = false;
                finish();
            }

            
            {
                this$0 = ShowCleanActivity_Rub.this;
                super();
            }
        });
        tv_jieguo = (TextView)findViewById(0x7f0703b4);
        cleanSize = getIntent().getStringExtra("clean");
        roundDouble1 = roundDouble((double)getIntent().getIntExtra("juti", 0) / 1024D, 2);
        Log.e("fff", (new StringBuilder()).append(roundDouble1).append("------").toString());
        (new Thread() {

            final ShowCleanActivity_Rub this$0;

            public void run()
            {
                super.run();
                do
                {
                    do
                    {
                        if (!flag)
                        {
                            return;
                        }
                        ShowCleanActivity_Rub showcleanactivity_rub = ShowCleanActivity_Rub.this;
                        showcleanactivity_rub.cont = showcleanactivity_rub.cont + 1.1000000000000001D;
                        cont = ShowCleanActivity_Rub.roundDouble(cont, 2).doubleValue();
                        tv_jieguo.post(new Runnable() {

                            final _cls6 this$1;

                            public void run()
                            {
                                tv_jieguo.setText((new StringBuilder(String.valueOf(cont))).append("MB").toString());
                            }

            
            {
                this$1 = _cls6.this;
                super();
            }
                        });
                        try
                        {
                            sleep(7L);
                        }
                        catch (InterruptedException interruptedexception)
                        {
                            interruptedexception.printStackTrace();
                        }
                    } while (cont < roundDouble1.doubleValue());
                    flag = false;
                } while (true);
            }


            
            {
                this$0 = ShowCleanActivity_Rub.this;
                super();
            }
        }).start();
        bundle = AnimationUtils.loadAnimation(this, 0x7f040020);
        relaquan.startAnimation(bundle);
        (new Thread() {

            final ShowCleanActivity_Rub this$0;

            public void run()
            {
                super.run();
                Message message;
                try
                {
                    sleep(2000L);
                }
                catch (InterruptedException interruptedexception)
                {
                    interruptedexception.printStackTrace();
                }
                message = new Message();
                handlerdonghua.sendMessage(message);
            }

            
            {
                this$0 = ShowCleanActivity_Rub.this;
                super();
            }
        }).start();
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        startActivity(new Intent(getApplicationContext(), com/aio/downloader/activity/DownloadAppManager));
        publicTools.cleanertag = false;
        finish();
        return super.onKeyDown(i, keyevent);
    }

    public void toDownload(DownloadMovieItem downloadmovieitem)
    {
        downloadmovieitem.setDownloadState(Integer.valueOf(7));
        getMyApp().setStartDownloadMovieItem(downloadmovieitem);
        sendBroadcast((new Intent()).setAction("download"));
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
