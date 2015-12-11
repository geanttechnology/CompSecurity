// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.aio.downloader.db.TypeDbUtils;
import com.aio.downloader.dialog.LianwangDialog;
import com.aio.downloader.mydownload.BaseActivity;
import com.aio.downloader.mydownload.DownloadMovieItem;
import com.aio.downloader.mydownload.MyApplcation;
import com.aio.downloader.utils.Myutils;
import com.aio.downloader.utils.ProgressWheel;
import com.aio.downloader.utils.publicTools;
import com.umeng.analytics.MobclickAgent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.tsz.afinal.FinalDBChen;

// Referenced classes of package com.aio.downloader.activity:
//            DownloadAppManager

public class AnzhuangActivity extends BaseActivity
    implements android.view.View.OnClickListener
{

    private File PRO_DIR;
    private File PRO_DIR_FOME;
    private File PRO_DIR_TO;
    private String appid;
    private String appname;
    private String appsize;
    private Button cleanercancel;
    private Button cleanerupdate;
    private FinalDBChen db;
    private TypeDbUtils dbUtils;
    private HashMap default_options;
    private TextView descriptiontv;
    private List ds;
    Handler handler;
    private ImageView iv_icon_ins;
    PackageInfo pI;
    private ProgressWheel progress_wheel;
    private publicTools publictools;
    private SharedPreferences spnetworkre;

    public AnzhuangActivity()
    {
        handler = new Handler() {

            final AnzhuangActivity this$0;

            public void handleMessage(Message message)
            {
                super.handleMessage(message);
                switch (message.what)
                {
                default:
                    return;

                case 1: // '\001'
                    Toast.makeText(AnzhuangActivity.this, "Failed to connect server.", 0).show();
                    return;

                case 2: // '\002'
                    Mydialog();
                    return;

                case 3: // '\003'
                    Toast.makeText(AnzhuangActivity.this, "'AIO Cleaner' is added to download queue.", 0).show();
                    break;
                }
                finish();
                message = new Intent(AnzhuangActivity.this, com/aio/downloader/activity/DownloadAppManager);
                message.setFlags(0x10000000);
                startActivity(message);
            }

            
            {
                this$0 = AnzhuangActivity.this;
                super();
            }
        };
        dbUtils = null;
        publictools = null;
        pI = null;
        PRO_DIR_FOME = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/cleaner/cleaner.apk").toString());
        PRO_DIR_TO = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/cleaner/cleaner.swf").toString());
        PRO_DIR = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/cleaner").toString());
    }

    private void Mydialog()
    {
        (new android.app.AlertDialog.Builder(this)).setTitle(getString(0x7f0b0034)).setMessage("It has been in downloading list already.").setPositiveButton("Ok", new android.content.DialogInterface.OnClickListener() {

            final AnzhuangActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
                finish();
            }

            
            {
                this$0 = AnzhuangActivity.this;
                super();
            }
        }).show();
    }

    private void buildListener()
    {
        cleanercancel.setOnClickListener(this);
        cleanerupdate.setOnClickListener(this);
    }

    private void downwifi()
    {
        final LianwangDialog dialog = new LianwangDialog(this, 0x7f0c000e);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        Button button = (Button)dialog.findViewById(0x7f070141);
        Button button1 = (Button)dialog.findViewById(0x7f070142);
        button.setOnClickListener(new android.view.View.OnClickListener() {

            final AnzhuangActivity this$0;
            private final LianwangDialog val$dialog;

            public void onClick(View view)
            {
                dialog.dismiss();
            }

            
            {
                this$0 = AnzhuangActivity.this;
                dialog = lianwangdialog;
                super();
            }
        });
        button1.setOnClickListener(new android.view.View.OnClickListener() {

            final AnzhuangActivity this$0;
            private final LianwangDialog val$dialog;

            public void onClick(View view)
            {
                startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
                dialog.dismiss();
            }

            
            {
                this$0 = AnzhuangActivity.this;
                dialog = lianwangdialog;
                super();
            }
        });
    }

    private File getAssetFile()
    {
        Object obj = getAssets();
        File file;
        PRO_DIR.mkdirs();
        obj = ((AssetManager) (obj)).open("cleaner.apk");
        file = new File(PRO_DIR, "cleaner.apk");
        FileOutputStream fileoutputstream;
        byte abyte0[];
        file.createNewFile();
        fileoutputstream = new FileOutputStream(file);
        abyte0 = new byte[1024];
_L1:
        int i = ((InputStream) (obj)).read(abyte0);
        if (i != -1)
        {
            break MISSING_BLOCK_LABEL_83;
        }
        fileoutputstream.flush();
        ((InputStream) (obj)).close();
        fileoutputstream.close();
        return file;
        fileoutputstream.write(abyte0, 0, i);
          goto _L1
        IOException ioexception;
        ioexception;
_L3:
        ioexception.printStackTrace();
        return null;
        ioexception;
        if (true) goto _L3; else goto _L2
_L2:
    }

    private void init()
    {
        appname = getIntent().getStringExtra("appname");
        appsize = getIntent().getStringExtra("size");
        appid = getIntent().getStringExtra("appid");
        pI = getPackageManager().getPackageInfo(appid, 0);
_L1:
        android.graphics.drawable.Drawable drawable = pI.applicationInfo.loadIcon(getPackageManager());
        iv_icon_ins.setBackgroundDrawable(drawable);
        descriptiontv = (TextView)findViewById(0x7f070093);
        descriptiontv.setText(Html.fromHtml((new StringBuilder("<font color='#3463b4'> <b>")).append(appname).append("</b></font> installed, you can delete its unneeded apk file to save <font color='#3261b4'><b>").append(appsize).append(".</b></font>").toString()));
_L2:
        cleanercancel = (Button)findViewById(0x7f070090);
        cleanerupdate = (Button)findViewById(0x7f070092);
        progress_wheel = (ProgressWheel)findViewById(0x7f070072);
        publictools = new publicTools(this);
        default_options = new HashMap();
        default_options.put("save_cookie", Integer.valueOf(0));
        default_options.put("send_cookie", Integer.valueOf(0));
        default_options.put("show_header", Integer.valueOf(0));
        default_options.put("redirect", Integer.valueOf(1));
        Object obj;
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
        obj;
        ((android.content.pm.PackageManager.NameNotFoundException) (obj)).printStackTrace();
          goto _L1
        obj;
          goto _L2
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
                final AnzhuangActivity this$0;
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
                this$0 = AnzhuangActivity.this;
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

    public void onClick(View view)
    {
        switch (view.getId())
        {
        case 2131165329: 
        default:
            return;

        case 2131165328: 
            finish();
            return;

        case 2131165330: 
            MobclickAgent.onEvent(getApplicationContext(), "Installpop_click");
            break;
        }
        (new Thread() {

            final AnzhuangActivity this$0;

            public void run()
            {
                super.run();
                publicTools.getUrl("http://android.downloadatoz.com/_201409/market/hits.php?type=pop&action=install_click");
            }

            
            {
                this$0 = AnzhuangActivity.this;
                super();
            }
        }).start();
        view = null;
        PackageInfo packageinfo = getPackageManager().getPackageInfo("com.evzapp.cleanmaster", 0);
        view = packageinfo;
_L1:
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        if (view == null)
        {
            if (PRO_DIR_FOME.exists())
            {
                installApk();
            } else
            if (PRO_DIR_TO.exists())
            {
                (new AsyncTask() {

                    final AnzhuangActivity this$0;

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
                        installApk();
                    }

            
            {
                this$0 = AnzhuangActivity.this;
                super();
            }
                }).execute(new Void[0]);
            }
        } else
        {
            startActivity(getPackageManager().getLaunchIntentForPackage("com.evzapp.cleanmaster"));
        }
        finish();
        return;
        namenotfoundexception;
        namenotfoundexception.printStackTrace();
          goto _L1
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(0x7f030010);
        iv_icon_ins = (ImageView)findViewById(0x7f070095);
        initView();
        init();
        buildListener();
        (new Thread() {

            final AnzhuangActivity this$0;

            public void run()
            {
                super.run();
                publicTools.getUrl("http://android.downloadatoz.com/_201409/market/hits.php?type=pop&action=install");
            }

            
            {
                this$0 = AnzhuangActivity.this;
                super();
            }
        }).start();
        MobclickAgent.onEvent(getApplicationContext(), "Installpop");
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
