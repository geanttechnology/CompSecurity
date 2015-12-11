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
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.aio.downloader.activity.AppDetailsActivity;
import com.aio.downloader.dialog.NeituiDialog;
import com.aio.downloader.utils.Myutils;
import com.aio.downloader.utils.SharedPreferencesConfig;
import com.aio.downloader.views.LFrameLayout;
import com.umeng.analytics.MobclickAgent;
import java.io.File;
import java.io.FileInputStream;

public class ServiceCleaner extends Service
{

    private File AIOCALLERAPK;
    private File AIOCALLERDOWN;
    private File AIOCRUSHAPK;
    private File AIOCRUSHSWF;
    private File PRO_DIR;
    private File PRO_DIR_FOME;
    private File PRO_DIR_TO;
    private boolean biaoshi;
    private int mRandom;

    public ServiceCleaner()
    {
        PRO_DIR_FOME = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/cleaner/cleaner.apk").toString());
        PRO_DIR_TO = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/cleaner/cleaner.swf").toString());
        PRO_DIR = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/cleaner").toString());
        AIOCALLERDOWN = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("caller.swf").toString());
        AIOCALLERAPK = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("caller.apk").toString());
        AIOCRUSHSWF = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("crush.swf").toString());
        AIOCRUSHAPK = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("crush.apk").toString());
        mRandom = 0;
        biaoshi = true;
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
        int i = getSharedPreferences("countName_first", 0).getInt("first", 0);
        Log.e("zxcv", (new StringBuilder("cichu=")).append(i % 2).toString());
        if (System.currentTimeMillis() > SharedPreferencesConfig.Getneitui(getApplicationContext()) && i % 2 == 0)
        {
            (new Handler()).postDelayed(new Runnable() {

                private ImageView iv_neitui_cover;
                private ImageView iv_neitui_icon;
                private ImageView iv_neituicha;
                private LFrameLayout lf_neitui;
                private NeituiDialog neituidialog;
                final ServiceCleaner this$0;
                private TextView tv_neitui_body;
                private TextView tv_neitui_bt;
                private TextView tv_neitui_title;

                public void run()
                {
                    android.content.pm.PackageInfo packageinfo;
                    Object obj;
                    Object obj1;
                    packageinfo = null;
                    android.content.pm.PackageInfo packageinfo1;
                    try
                    {
                        obj = getPackageManager().getPackageInfo("com.allinone.callerid", 0);
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        ((android.content.pm.PackageManager.NameNotFoundException) (obj)).printStackTrace();
                        continue; /* Loop/switch isn't completed */
                    }
                    packageinfo = ((android.content.pm.PackageInfo) (obj));
_L10:
                    obj = null;
                    obj1 = getPackageManager().getPackageInfo("com.evzapp.cleanmaster", 0);
                    obj = obj1;
_L6:
                    obj1 = null;
                    packageinfo1 = getPackageManager().getPackageInfo("com.freepezzle.hexcrush", 0);
                    obj1 = packageinfo1;
_L7:
                    if (packageinfo != null && obj != null && obj1 != null) goto _L2; else goto _L1
_L1:
                    MobclickAgent.onEvent(getApplicationContext(), "interpolate_show");
                    SharedPreferencesConfig.Setneitui(getApplicationContext(), System.currentTimeMillis() + 0x2932e00L);
                    neituidialog = new NeituiDialog(getApplicationContext(), 0x7f0c000e);
                    neituidialog.setCanceledOnTouchOutside(true);
                    neituidialog.getWindow().setType(2003);
                    neituidialog.show();
                    iv_neitui_cover = (ImageView)neituidialog.findViewById(0x7f070361);
                    iv_neitui_icon = (ImageView)neituidialog.findViewById(0x7f070363);
                    tv_neitui_title = (TextView)neituidialog.findViewById(0x7f070364);
                    tv_neitui_bt = (TextView)neituidialog.findViewById(0x7f070367);
                    tv_neitui_body = (TextView)neituidialog.findViewById(0x7f070365);
                    lf_neitui = (LFrameLayout)neituidialog.findViewById(0x7f070366);
                    iv_neituicha = (ImageView)neituidialog.findViewById(0x7f070362);
                    iv_neituicha.setOnClickListener(new android.view.View.OnClickListener() {

                        final _cls1 this$1;

                        public void onClick(View view)
                        {
                            neituidialog.dismiss();
                        }

            
            {
                this$1 = _cls1.this;
                super();
            }
                    });
                    mRandom = (int)(Math.random() * 3D) + 1;
                    Log.e("tag", (new StringBuilder("mRandom=")).append(mRandom).toString());
                    android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
                    if (mRandom == 1 && packageinfo == null)
                    {
                        biaoshi = false;
                        iv_neitui_cover.setBackgroundResource(0x7f020151);
                        iv_neitui_icon.setBackgroundResource(0x7f0200f7);
                        tv_neitui_title.setText("Caller ID & Block");
                        tv_neitui_body.setText("Identify unknown calls and block unwanted calls!");
                        tv_neitui_bt.setText("Try Now");
                        lf_neitui.setOnClickListener(new android.view.View.OnClickListener() {

                            final _cls1 this$1;

                            public void onClick(View view)
                            {
                                MobclickAgent.onEvent(getApplicationContext(), "interpolate_click");
                                if (!AIOCALLERAPK.exists() || getFileSizes(AIOCALLERAPK) < 0x4e87bdL) goto _L2; else goto _L1
_L1:
                                view = new Intent("android.intent.action.VIEW");
                                view.setDataAndType(Uri.parse((new StringBuilder("file://")).append(AIOCALLERAPK).toString()), "application/vnd.android.package-archive");
                                view.addFlags(0x10000000);
                                startActivity(view);
_L4:
                                neituidialog.dismiss();
                                return;
_L2:
                                if (AIOCALLERDOWN.exists() && getFileSizes(AIOCALLERDOWN) >= 0x4e87bdL)
                                {
                                    (new AsyncTask() {

                                        final _cls2 this$2;

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
                this$2 = _cls2.this;
                super();
            }
                                    }).execute(new Void[0]);
                                    continue; /* Loop/switch isn't completed */
                                }
                                try
                                {
                                    view = new Intent(getApplicationContext(), com/aio/downloader/activity/AppDetailsActivity);
                                    view.putExtra("myid", "com.allinone.callerid");
                                    view.addFlags(0x10000000);
                                    startActivity(view);
                                }
                                // Misplaced declaration of an exception variable
                                catch (View view)
                                {
                                    view.printStackTrace();
                                }
                                if (true) goto _L4; else goto _L3
_L3:
                            }


            
            {
                this$1 = _cls1.this;
                super();
            }
                        });
                    } else
                    if (mRandom == 2 && obj == null)
                    {
                        biaoshi = false;
                        iv_neitui_cover.setBackgroundResource(0x7f020152);
                        iv_neitui_icon.setBackgroundResource(0x7f0200f8);
                        tv_neitui_title.setText("Cleaner&Speed Booster");
                        tv_neitui_body.setText("Keep your Android Phone clean, safe and fast!");
                        tv_neitui_bt.setText("Free to Boost");
                        lf_neitui.setOnClickListener(new android.view.View.OnClickListener() {

                            final _cls1 this$1;

                            public void onClick(View view)
                            {
                                MobclickAgent.onEvent(getApplicationContext(), "interpolate_click");
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

                                        final _cls3 this$2;

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
                this$2 = _cls3.this;
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
                                neituidialog.dismiss();
                            }


            
            {
                this$1 = _cls1.this;
                super();
            }
                        });
                    } else
                    if (mRandom == 3 && obj1 == null)
                    {
                        biaoshi = false;
                        iv_neitui_cover.setBackgroundResource(0x7f020153);
                        iv_neitui_icon.setBackgroundResource(0x7f0200d0);
                        tv_neitui_title.setText("HEX Crush");
                        tv_neitui_body.setText("An easy to understand yet fun to master puzzle game.");
                        tv_neitui_bt.setText("Free to Play");
                        lf_neitui.setOnClickListener(new android.view.View.OnClickListener() {

                            final _cls1 this$1;

                            public void onClick(View view)
                            {
                                MobclickAgent.onEvent(getApplicationContext(), "interpolate_click");
                                if (!AIOCRUSHAPK.exists() || getFileSizes(AIOCRUSHAPK) < 0x19ee4cL) goto _L2; else goto _L1
_L1:
                                view = new Intent("android.intent.action.VIEW");
                                view.setDataAndType(Uri.parse((new StringBuilder("file://")).append(AIOCRUSHAPK).toString()), "application/vnd.android.package-archive");
                                view.addFlags(0x10000000);
                                startActivity(view);
_L4:
                                neituidialog.dismiss();
                                return;
_L2:
                                if (AIOCRUSHSWF.exists() && getFileSizes(AIOCRUSHSWF) >= 0x19ee4cL)
                                {
                                    (new AsyncTask() {

                                        final _cls4 this$2;

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
                                            void1.addFlags(0x10000000);
                                            startActivity(void1);
                                        }

            
            {
                this$2 = _cls4.this;
                super();
            }
                                    }).execute(new Void[0]);
                                    continue; /* Loop/switch isn't completed */
                                }
                                try
                                {
                                    view = new Intent(getApplicationContext(), com/aio/downloader/activity/AppDetailsActivity);
                                    view.putExtra("myid", "com.freepezzle.hexcrush");
                                    view.addFlags(0x10000000);
                                    startActivity(view);
                                }
                                // Misplaced declaration of an exception variable
                                catch (View view)
                                {
                                    view.printStackTrace();
                                }
                                if (true) goto _L4; else goto _L3
_L3:
                            }


            
            {
                this$1 = _cls1.this;
                super();
            }
                        });
                    }
                    if (!biaoshi) goto _L2; else goto _L3
_L3:
                    if (obj != null) goto _L5; else goto _L4
_L4:
                    iv_neitui_cover.setBackgroundResource(0x7f020152);
                    iv_neitui_icon.setBackgroundResource(0x7f0200f8);
                    tv_neitui_title.setText("Cleaner&Speed Booster");
                    tv_neitui_body.setText("Keep your Android Phone clean, safe and fast!");
                    tv_neitui_bt.setText("Free to Boost");
                    lf_neitui.setOnClickListener(new android.view.View.OnClickListener() {

                        final _cls1 this$1;

                        public void onClick(View view)
                        {
                            MobclickAgent.onEvent(getApplicationContext(), "interpolate_click");
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

                                    final _cls5 this$2;

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
                this$2 = _cls5.this;
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
                            neituidialog.dismiss();
                        }


            
            {
                this$1 = _cls1.this;
                super();
            }
                    });
_L2:
                    return;
                    obj1;
                    ((android.content.pm.PackageManager.NameNotFoundException) (obj1)).printStackTrace();
                      goto _L6
                    namenotfoundexception;
                    namenotfoundexception.printStackTrace();
                      goto _L7
_L5:
                    if (obj1 == null)
                    {
                        iv_neitui_cover.setBackgroundResource(0x7f020153);
                        iv_neitui_icon.setBackgroundResource(0x7f0200d0);
                        tv_neitui_title.setText("HEX Crush");
                        tv_neitui_body.setText("An easy to understand yet fun to master puzzle game.");
                        tv_neitui_bt.setText("Free to Play");
                        lf_neitui.setOnClickListener(new android.view.View.OnClickListener() {

                            final _cls1 this$1;

                            public void onClick(View view)
                            {
                                MobclickAgent.onEvent(getApplicationContext(), "interpolate_click");
                                if (!AIOCRUSHAPK.exists() || getFileSizes(AIOCRUSHAPK) < 0x19ee4cL) goto _L2; else goto _L1
_L1:
                                view = new Intent("android.intent.action.VIEW");
                                view.setDataAndType(Uri.parse((new StringBuilder("file://")).append(AIOCRUSHAPK).toString()), "application/vnd.android.package-archive");
                                view.addFlags(0x10000000);
                                startActivity(view);
_L4:
                                neituidialog.dismiss();
                                return;
_L2:
                                if (AIOCRUSHSWF.exists() && getFileSizes(AIOCRUSHSWF) >= 0x19ee4cL)
                                {
                                    (new AsyncTask() {

                                        final _cls6 this$2;

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
                                            void1.addFlags(0x10000000);
                                            startActivity(void1);
                                        }

            
            {
                this$2 = _cls6.this;
                super();
            }
                                    }).execute(new Void[0]);
                                    continue; /* Loop/switch isn't completed */
                                }
                                try
                                {
                                    view = new Intent(getApplicationContext(), com/aio/downloader/activity/AppDetailsActivity);
                                    view.putExtra("myid", "com.freepezzle.hexcrush");
                                    view.addFlags(0x10000000);
                                    startActivity(view);
                                }
                                // Misplaced declaration of an exception variable
                                catch (View view)
                                {
                                    view.printStackTrace();
                                }
                                if (true) goto _L4; else goto _L3
_L3:
                            }


            
            {
                this$1 = _cls1.this;
                super();
            }
                        });
                        return;
                    }
                    if (packageinfo != null) goto _L2; else goto _L8
_L8:
                    iv_neitui_cover.setBackgroundResource(0x7f020151);
                    iv_neitui_icon.setBackgroundResource(0x7f0200f7);
                    tv_neitui_title.setText("Caller ID & Block");
                    tv_neitui_body.setText("Identify unknown calls and block unwanted calls!");
                    tv_neitui_bt.setText("Try Now");
                    lf_neitui.setOnClickListener(new android.view.View.OnClickListener() {

                        final _cls1 this$1;

                        public void onClick(View view)
                        {
                            MobclickAgent.onEvent(getApplicationContext(), "interpolate_click");
                            if (!AIOCALLERAPK.exists() || getFileSizes(AIOCALLERAPK) < 0x4e87bdL) goto _L2; else goto _L1
_L1:
                            view = new Intent("android.intent.action.VIEW");
                            view.setDataAndType(Uri.parse((new StringBuilder("file://")).append(AIOCALLERAPK).toString()), "application/vnd.android.package-archive");
                            view.addFlags(0x10000000);
                            startActivity(view);
_L4:
                            neituidialog.dismiss();
                            return;
_L2:
                            if (AIOCALLERDOWN.exists() && getFileSizes(AIOCALLERDOWN) >= 0x4e87bdL)
                            {
                                (new AsyncTask() {

                                    final _cls7 this$2;

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
                this$2 = _cls7.this;
                super();
            }
                                }).execute(new Void[0]);
                                continue; /* Loop/switch isn't completed */
                            }
                            try
                            {
                                view = new Intent(getApplicationContext(), com/aio/downloader/activity/AppDetailsActivity);
                                view.putExtra("myid", "com.allinone.callerid");
                                view.addFlags(0x10000000);
                                startActivity(view);
                            }
                            // Misplaced declaration of an exception variable
                            catch (View view)
                            {
                                view.printStackTrace();
                            }
                            if (true) goto _L4; else goto _L3
_L3:
                        }


            
            {
                this$1 = _cls1.this;
                super();
            }
                    });
                    return;
                    if (true) goto _L10; else goto _L9
_L9:
                }



            
            {
                this$0 = ServiceCleaner.this;
                super();
            }
            }, 0x2bf20L);
        }
    }

    public void onDestroy()
    {
        super.onDestroy();
    }











}
