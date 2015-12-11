// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.service;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.Window;
import com.aio.downloader.activity.AppDetailsActivity;
import com.aio.downloader.dialog.GralleryDialog;
import com.aio.downloader.dialog.InstallfirstDialog;
import com.aio.downloader.utils.Myutils;
import com.aio.downloader.utils.SharedPreferencesConfig;
import com.aio.downloader.utils.publicTools;
import com.umeng.analytics.MobclickAgent;
import java.io.File;
import java.io.FileInputStream;

public class ServiceGallery extends Service
{

    protected static final String STATUS_BAR_COVER_CLICK_UPDATE = "update";
    protected static final String STATUS_BAR_COVER_PAID = "paid";
    protected static final String STATUS_BAR_COVER_PICK = "pick";
    protected static final String STATUS_BAR_COVER_PICK_BIG = "pick_big";
    protected static final String STATUS_BAR_DOWNLOAD_INSTALL = "status_bar_download_install";
    protected static final String STATUS_BAR_DOWNLOAD_SUCCESS = "status_bar_download_success";
    private File AIOGALLERY;
    private File AIOGALLERYAPK;
    private File PRO_DIR;
    private File PRO_DIR_FOME;
    private File PRO_DIR_TO;
    private InstallfirstDialog dialog;
    private GralleryDialog gralleryDialog;
    private Handler handler;
    android.view.View.OnClickListener itemsOnClick;
    private android.view.View.OnClickListener itemsOnClick4;

    public ServiceGallery()
    {
        AIOGALLERY = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("gallery.swf").toString());
        AIOGALLERYAPK = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("gallery.apk").toString());
        PRO_DIR_FOME = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/cleaner/cleaner.apk").toString());
        PRO_DIR_TO = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/cleaner/cleaner.swf").toString());
        PRO_DIR = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/cleaner").toString());
        handler = new Handler() {

            private String icon0;
            private String icon1;
            private String icon2;
            private String icon3;
            private String icon4;
            private String icon5;
            private String icon6;
            private String icon7;
            final ServiceGallery this$0;

            public void handleMessage(Message message)
            {
                super.handleMessage(message);
                switch (message.what)
                {
                default:
                    return;

                case 30: // '\036'
                    MobclickAgent.onEvent(getApplicationContext(), "first_insall_cleaner");
                    break;
                }
                dialog.show();
            }

            
            {
                this$0 = ServiceGallery.this;
                super();
            }
        };
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

    public IBinder onBind(Intent intent)
    {
        return null;
    }

    public void onCreate()
    {
        super.onCreate();
        itemsOnClick = new android.view.View.OnClickListener() {

            final ServiceGallery this$0;

            public void onClick(View view)
            {
                switch (view.getId())
                {
                default:
                    return;

                case 2131165718: 
                    gralleryDialog.dismiss();
                    return;

                case 2131165719: 
                    Log.e("qwer", "ll_gallery_onclick");
                    break;
                }
                (new Thread() {

                    final _cls2 this$1;

                    public void run()
                    {
                        super.run();
                        publicTools.getUrl("http://android.downloadatoz.com/_201409/market/hits.php?type=pop&action=gallery_click");
                    }

            
            {
                this$1 = _cls2.this;
                super();
            }
                }).start();
                MobclickAgent.onEvent(getApplicationContext(), "gallery_click");
                gralleryDialog.dismiss();
                try
                {
                    if (AIOGALLERYAPK.exists() && getFileSizes(AIOGALLERYAPK) >= 0x1bff04L)
                    {
                        view = new Intent("android.intent.action.VIEW");
                        view.setDataAndType(Uri.parse((new StringBuilder("file://")).append(AIOGALLERYAPK).toString()), "application/vnd.android.package-archive");
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
                if (AIOGALLERY.exists() && getFileSizes(AIOGALLERY) >= 0x1bff04L)
                {
                    (new AsyncTask() {

                        final _cls2 this$1;

                        protected volatile transient Object doInBackground(Object aobj[])
                        {
                            return doInBackground((Void[])aobj);
                        }

                        protected transient Void doInBackground(Void avoid[])
                        {
                            Myutils.copyfile(AIOGALLERY, AIOGALLERYAPK, Boolean.valueOf(false));
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
                            void1.setDataAndType(Uri.parse((new StringBuilder("file://")).append(AIOGALLERYAPK).toString()), "application/vnd.android.package-archive");
                            void1.addFlags(0x10000000);
                            startActivity(void1);
                        }

            
            {
                this$1 = _cls2.this;
                super();
            }
                    }).execute(new Void[0]);
                    return;
                }
                view = new Intent(getApplicationContext(), com/aio/downloader/activity/AppDetailsActivity);
                view.putExtra("myid", "com.androidapp.gallary3d");
                view.addFlags(0x10000000);
                startActivity(view);
                return;
            }


            
            {
                this$0 = ServiceGallery.this;
                super();
            }
        };
        gralleryDialog = new GralleryDialog(getApplicationContext(), 0x7f0c0010, itemsOnClick);
        gralleryDialog.setCanceledOnTouchOutside(true);
        gralleryDialog.getWindow().setType(2003);
        android.content.pm.PackageInfo packageinfo;
        int i;
        try
        {
            getPackageManager().getPackageInfo("com.aioapp.gallery", 0);
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            namenotfoundexception.printStackTrace();
        }
        Log.e("qwer", (new StringBuilder("time=")).append(SharedPreferencesConfig.GetGalleryClickTime(this)).toString());
        i = getSharedPreferences("countName_first", 0).getInt("first", 0);
        Log.e("zxcv", (new StringBuilder("gallerycishu=")).append(i % 2).toString());
        try
        {
            packageinfo = getPackageManager().getPackageInfo("com.evzapp.cleanmaster", 0);
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception1)
        {
            namenotfoundexception = null;
            namenotfoundexception1.printStackTrace();
        }
        if (i == 1 && packageinfo == null)
        {
            itemsOnClick4 = new android.view.View.OnClickListener() {

                final ServiceGallery this$0;

                public void onClick(View view)
                {
                    view.getId();
                    JVM INSTR tableswitch 2131165516 2131165517: default 28
                //                               2131165516 281
                //                               2131165517 29;
                       goto _L1 _L2 _L3
_L1:
                    return;
_L3:
                    MobclickAgent.onEvent(getApplicationContext(), "first_install_cleaner_click");
                    (new Thread() {

                        final _cls3 this$1;

                        public void run()
                        {
                            super.run();
                            publicTools.getUrl("http://android.downloadatoz.com/_201409/market/hits.php?type=pop&action=install_click");
                        }

            
            {
                this$1 = _cls3.this;
                super();
            }
                    }).start();
                    view = null;
                    android.content.pm.PackageInfo packageinfo1;
                    try
                    {
                        packageinfo1 = getPackageManager().getPackageInfo("com.evzapp.cleanmaster", 0);
                    }
                    catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception2)
                    {
                        namenotfoundexception2.printStackTrace();
                        continue; /* Loop/switch isn't completed */
                    }
                    view = packageinfo1;
_L5:
                    if (view == null)
                    {
                        if (PRO_DIR_FOME.exists())
                        {
                            view = new Intent("android.intent.action.VIEW");
                            view.setDataAndType(Uri.parse((new StringBuilder("file://")).append(PRO_DIR).append(File.separator).append("cleaner.apk").toString()), "application/vnd.android.package-archive");
                            view.addFlags(0x10000000);
                            startActivity(view);
                        } else
                        if (PRO_DIR_TO.exists())
                        {
                            (new AsyncTask() {

                                final _cls3 this$1;

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
                this$1 = _cls3.this;
                super();
            }
                            }).execute(new Void[0]);
                        } else
                        {
                            view = new Intent(getApplicationContext(), com/aio/downloader/activity/AppDetailsActivity);
                            view.putExtra("myid", "com.evzapp.cleanmaster");
                            view.addFlags(0x10000000);
                            startActivity(view);
                        }
                    } else
                    {
                        view = getPackageManager().getLaunchIntentForPackage("com.evzapp.cleanmaster");
                        view.addFlags(0x10000000);
                        startActivity(view);
                    }
                    dialog.dismiss();
                    return;
_L2:
                    dialog.dismiss();
                    return;
                    if (true) goto _L5; else goto _L4
_L4:
                }


            
            {
                this$0 = ServiceGallery.this;
                super();
            }
            };
            dialog = new InstallfirstDialog(getApplicationContext(), 0x7f0c0010, itemsOnClick4);
            dialog.setCanceledOnTouchOutside(true);
            dialog.getWindow().setType(2003);
            (new Thread() {

                final ServiceGallery this$0;

                public void run()
                {
                    super.run();
                    try
                    {
                        sleep(0x1d4c0L);
                        Message message = new Message();
                        message.what = 30;
                        handler.sendMessage(message);
                        return;
                    }
                    catch (InterruptedException interruptedexception)
                    {
                        interruptedexception.printStackTrace();
                    }
                }

            
            {
                this$0 = ServiceGallery.this;
                super();
            }
            }).start();
        }
    }

    public void onDestroy()
    {
        super.onDestroy();
    }








}
