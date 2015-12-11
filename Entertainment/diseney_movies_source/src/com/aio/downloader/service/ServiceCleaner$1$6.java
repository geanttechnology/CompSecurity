// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.service;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
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

// Referenced classes of package com.aio.downloader.service:
//            ServiceCleaner

class this._cls1
    implements android.view.r
{

    final tActivity this$1;

    public void onClick(View view)
    {
        MobclickAgent.onEvent(getApplicationContext(), "interpolate_click");
        if (!ServiceCleaner.access$8(_fld0).exists() || getFileSizes(ServiceCleaner.access$8(_fld0)) < 0x19ee4cL) goto _L2; else goto _L1
_L1:
        view = new Intent("android.intent.action.VIEW");
        view.setDataAndType(Uri.parse((new StringBuilder("file://")).append(ServiceCleaner.access$8(_fld0)).toString()), "application/vnd.android.package-archive");
        view.addFlags(0x10000000);
        startActivity(view);
_L4:
        ituidialog.dismiss();
        return;
_L2:
        if (ServiceCleaner.access$9(_fld0).exists() && getFileSizes(ServiceCleaner.access$9(_fld0)) >= 0x19ee4cL)
        {
            (new AsyncTask() {

                final ServiceCleaner._cls1._cls6 this$2;

                protected volatile transient Object doInBackground(Object aobj[])
                {
                    return doInBackground((Void[])aobj);
                }

                protected transient Void doInBackground(Void avoid[])
                {
                    Myutils.copyfile(ServiceCleaner.access$9(this$0), ServiceCleaner.access$8(this$0), Boolean.valueOf(false));
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
                    void1.setDataAndType(Uri.parse((new StringBuilder("file://")).append(ServiceCleaner.access$8(this$0)).toString()), "application/vnd.android.package-archive");
                    void1.addFlags(0x10000000);
                    startActivity(void1);
                }

            
            {
                this$2 = ServiceCleaner._cls1._cls6.this;
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


    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/aio/downloader/service/ServiceCleaner$1

/* anonymous class */
    class ServiceCleaner._cls1
        implements Runnable
    {

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
            iv_neituicha.setOnClickListener(new ServiceCleaner._cls1._cls1());
            ServiceCleaner.access$0(ServiceCleaner.this, (int)(Math.random() * 3D) + 1);
            Log.e("tag", (new StringBuilder("mRandom=")).append(ServiceCleaner.access$1(ServiceCleaner.this)).toString());
            android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
            if (ServiceCleaner.access$1(ServiceCleaner.this) == 1 && packageinfo == null)
            {
                ServiceCleaner.access$2(ServiceCleaner.this, false);
                iv_neitui_cover.setBackgroundResource(0x7f020151);
                iv_neitui_icon.setBackgroundResource(0x7f0200f7);
                tv_neitui_title.setText("Caller ID & Block");
                tv_neitui_body.setText("Identify unknown calls and block unwanted calls!");
                tv_neitui_bt.setText("Try Now");
                lf_neitui.setOnClickListener(new ServiceCleaner._cls1._cls2());
            } else
            if (ServiceCleaner.access$1(ServiceCleaner.this) == 2 && obj == null)
            {
                ServiceCleaner.access$2(ServiceCleaner.this, false);
                iv_neitui_cover.setBackgroundResource(0x7f020152);
                iv_neitui_icon.setBackgroundResource(0x7f0200f8);
                tv_neitui_title.setText("Cleaner&Speed Booster");
                tv_neitui_body.setText("Keep your Android Phone clean, safe and fast!");
                tv_neitui_bt.setText("Free to Boost");
                lf_neitui.setOnClickListener(new ServiceCleaner._cls1._cls3());
            } else
            if (ServiceCleaner.access$1(ServiceCleaner.this) == 3 && obj1 == null)
            {
                ServiceCleaner.access$2(ServiceCleaner.this, false);
                iv_neitui_cover.setBackgroundResource(0x7f020153);
                iv_neitui_icon.setBackgroundResource(0x7f0200d0);
                tv_neitui_title.setText("HEX Crush");
                tv_neitui_body.setText("An easy to understand yet fun to master puzzle game.");
                tv_neitui_bt.setText("Free to Play");
                lf_neitui.setOnClickListener(new ServiceCleaner._cls1._cls4());
            }
            if (!ServiceCleaner.access$10(ServiceCleaner.this)) goto _L2; else goto _L3
_L3:
            if (obj != null) goto _L5; else goto _L4
_L4:
            iv_neitui_cover.setBackgroundResource(0x7f020152);
            iv_neitui_icon.setBackgroundResource(0x7f0200f8);
            tv_neitui_title.setText("Cleaner&Speed Booster");
            tv_neitui_body.setText("Keep your Android Phone clean, safe and fast!");
            tv_neitui_bt.setText("Free to Boost");
            lf_neitui.setOnClickListener(new ServiceCleaner._cls1._cls5());
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
                lf_neitui.setOnClickListener(new ServiceCleaner._cls1._cls6());
                return;
            }
            if (packageinfo != null) goto _L2; else goto _L8
_L8:
            iv_neitui_cover.setBackgroundResource(0x7f020151);
            iv_neitui_icon.setBackgroundResource(0x7f0200f7);
            tv_neitui_title.setText("Caller ID & Block");
            tv_neitui_body.setText("Identify unknown calls and block unwanted calls!");
            tv_neitui_bt.setText("Try Now");
            lf_neitui.setOnClickListener(new ServiceCleaner._cls1._cls7());
            return;
            if (true) goto _L10; else goto _L9
_L9:
        }



            
            {
                this$0 = ServiceCleaner.this;
                super();
            }

        // Unreferenced inner class com/aio/downloader/service/ServiceCleaner$1$1

/* anonymous class */
        class ServiceCleaner._cls1._cls1
            implements android.view.View.OnClickListener
        {

            final ServiceCleaner._cls1 this$1;

            public void onClick(View view)
            {
                neituidialog.dismiss();
            }

                    
                    {
                        this$1 = ServiceCleaner._cls1.this;
                        super();
                    }
        }


        // Unreferenced inner class com/aio/downloader/service/ServiceCleaner$1$2

/* anonymous class */
        class ServiceCleaner._cls1._cls2
            implements android.view.View.OnClickListener
        {

            final ServiceCleaner._cls1 this$1;

            public void onClick(View view)
            {
                MobclickAgent.onEvent(getApplicationContext(), "interpolate_click");
                if (!ServiceCleaner.access$3(this$0).exists() || getFileSizes(ServiceCleaner.access$3(this$0)) < 0x4e87bdL) goto _L2; else goto _L1
_L1:
                view = new Intent("android.intent.action.VIEW");
                view.setDataAndType(Uri.parse((new StringBuilder("file://")).append(ServiceCleaner.access$3(this$0)).toString()), "application/vnd.android.package-archive");
                view.addFlags(0x10000000);
                startActivity(view);
_L4:
                neituidialog.dismiss();
                return;
_L2:
                if (ServiceCleaner.access$4(this$0).exists() && getFileSizes(ServiceCleaner.access$4(this$0)) >= 0x4e87bdL)
                {
                    (new ServiceCleaner._cls1._cls2._cls1()).execute(new Void[0]);
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
                        this$1 = ServiceCleaner._cls1.this;
                        super();
                    }
        }


        // Unreferenced inner class com/aio/downloader/service/ServiceCleaner$1$2$1

/* anonymous class */
        class ServiceCleaner._cls1._cls2._cls1 extends AsyncTask
        {

            final ServiceCleaner._cls1._cls2 this$2;

            protected volatile transient Object doInBackground(Object aobj[])
            {
                return doInBackground((Void[])aobj);
            }

            protected transient Void doInBackground(Void avoid[])
            {
                Myutils.copyfile(ServiceCleaner.access$4(this$0), ServiceCleaner.access$3(this$0), Boolean.valueOf(false));
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
                void1.setDataAndType(Uri.parse((new StringBuilder("file://")).append(ServiceCleaner.access$3(this$0)).toString()), "application/vnd.android.package-archive");
                void1.addFlags(0x10000000);
                startActivity(void1);
            }

                    
                    {
                        this$2 = ServiceCleaner._cls1._cls2.this;
                        super();
                    }
        }


        // Unreferenced inner class com/aio/downloader/service/ServiceCleaner$1$3

/* anonymous class */
        class ServiceCleaner._cls1._cls3
            implements android.view.View.OnClickListener
        {

            final ServiceCleaner._cls1 this$1;

            public void onClick(View view)
            {
                MobclickAgent.onEvent(getApplicationContext(), "interpolate_click");
                if (ServiceCleaner.access$5(this$0).exists())
                {
                    view = new Intent("android.intent.action.VIEW");
                    view.setDataAndType(Uri.parse((new StringBuilder("file://")).append(ServiceCleaner.access$6(this$0)).append(File.separator).append("cleaner.apk").toString()), "application/vnd.android.package-archive");
                    view.addFlags(0x10000000);
                    startActivity(view);
                } else
                if (ServiceCleaner.access$7(this$0).exists())
                {
                    (new ServiceCleaner._cls1._cls3._cls1()).execute(new Void[0]);
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
                        this$1 = ServiceCleaner._cls1.this;
                        super();
                    }
        }


        // Unreferenced inner class com/aio/downloader/service/ServiceCleaner$1$3$1

/* anonymous class */
        class ServiceCleaner._cls1._cls3._cls1 extends AsyncTask
        {

            final ServiceCleaner._cls1._cls3 this$2;

            protected volatile transient Object doInBackground(Object aobj[])
            {
                return doInBackground((Void[])aobj);
            }

            protected transient Void doInBackground(Void avoid[])
            {
                Myutils.copyfile(ServiceCleaner.access$7(this$0), ServiceCleaner.access$5(this$0), Boolean.valueOf(false));
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
                void1.setDataAndType(Uri.parse((new StringBuilder("file://")).append(ServiceCleaner.access$6(this$0)).append(File.separator).append("cleaner.apk").toString()), "application/vnd.android.package-archive");
                void1.addFlags(0x10000000);
                startActivity(void1);
            }

                    
                    {
                        this$2 = ServiceCleaner._cls1._cls3.this;
                        super();
                    }
        }


        // Unreferenced inner class com/aio/downloader/service/ServiceCleaner$1$4

/* anonymous class */
        class ServiceCleaner._cls1._cls4
            implements android.view.View.OnClickListener
        {

            final ServiceCleaner._cls1 this$1;

            public void onClick(View view)
            {
                MobclickAgent.onEvent(getApplicationContext(), "interpolate_click");
                if (!ServiceCleaner.access$8(this$0).exists() || getFileSizes(ServiceCleaner.access$8(this$0)) < 0x19ee4cL) goto _L2; else goto _L1
_L1:
                view = new Intent("android.intent.action.VIEW");
                view.setDataAndType(Uri.parse((new StringBuilder("file://")).append(ServiceCleaner.access$8(this$0)).toString()), "application/vnd.android.package-archive");
                view.addFlags(0x10000000);
                startActivity(view);
_L4:
                neituidialog.dismiss();
                return;
_L2:
                if (ServiceCleaner.access$9(this$0).exists() && getFileSizes(ServiceCleaner.access$9(this$0)) >= 0x19ee4cL)
                {
                    (new ServiceCleaner._cls1._cls4._cls1()).execute(new Void[0]);
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
                        this$1 = ServiceCleaner._cls1.this;
                        super();
                    }
        }


        // Unreferenced inner class com/aio/downloader/service/ServiceCleaner$1$4$1

/* anonymous class */
        class ServiceCleaner._cls1._cls4._cls1 extends AsyncTask
        {

            final ServiceCleaner._cls1._cls4 this$2;

            protected volatile transient Object doInBackground(Object aobj[])
            {
                return doInBackground((Void[])aobj);
            }

            protected transient Void doInBackground(Void avoid[])
            {
                Myutils.copyfile(ServiceCleaner.access$9(this$0), ServiceCleaner.access$8(this$0), Boolean.valueOf(false));
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
                void1.setDataAndType(Uri.parse((new StringBuilder("file://")).append(ServiceCleaner.access$8(this$0)).toString()), "application/vnd.android.package-archive");
                void1.addFlags(0x10000000);
                startActivity(void1);
            }

                    
                    {
                        this$2 = ServiceCleaner._cls1._cls4.this;
                        super();
                    }
        }


        // Unreferenced inner class com/aio/downloader/service/ServiceCleaner$1$5

/* anonymous class */
        class ServiceCleaner._cls1._cls5
            implements android.view.View.OnClickListener
        {

            final ServiceCleaner._cls1 this$1;

            public void onClick(View view)
            {
                MobclickAgent.onEvent(getApplicationContext(), "interpolate_click");
                if (ServiceCleaner.access$5(this$0).exists())
                {
                    view = new Intent("android.intent.action.VIEW");
                    view.setDataAndType(Uri.parse((new StringBuilder("file://")).append(ServiceCleaner.access$6(this$0)).append(File.separator).append("cleaner.apk").toString()), "application/vnd.android.package-archive");
                    view.addFlags(0x10000000);
                    startActivity(view);
                } else
                if (ServiceCleaner.access$7(this$0).exists())
                {
                    (new ServiceCleaner._cls1._cls5._cls1()).execute(new Void[0]);
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
                        this$1 = ServiceCleaner._cls1.this;
                        super();
                    }
        }


        // Unreferenced inner class com/aio/downloader/service/ServiceCleaner$1$5$1

/* anonymous class */
        class ServiceCleaner._cls1._cls5._cls1 extends AsyncTask
        {

            final ServiceCleaner._cls1._cls5 this$2;

            protected volatile transient Object doInBackground(Object aobj[])
            {
                return doInBackground((Void[])aobj);
            }

            protected transient Void doInBackground(Void avoid[])
            {
                Myutils.copyfile(ServiceCleaner.access$7(this$0), ServiceCleaner.access$5(this$0), Boolean.valueOf(false));
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
                void1.setDataAndType(Uri.parse((new StringBuilder("file://")).append(ServiceCleaner.access$6(this$0)).append(File.separator).append("cleaner.apk").toString()), "application/vnd.android.package-archive");
                void1.addFlags(0x10000000);
                startActivity(void1);
            }

                    
                    {
                        this$2 = ServiceCleaner._cls1._cls5.this;
                        super();
                    }
        }


        // Unreferenced inner class com/aio/downloader/service/ServiceCleaner$1$7

/* anonymous class */
        class ServiceCleaner._cls1._cls7
            implements android.view.View.OnClickListener
        {

            final ServiceCleaner._cls1 this$1;

            public void onClick(View view)
            {
                MobclickAgent.onEvent(getApplicationContext(), "interpolate_click");
                if (!ServiceCleaner.access$3(this$0).exists() || getFileSizes(ServiceCleaner.access$3(this$0)) < 0x4e87bdL) goto _L2; else goto _L1
_L1:
                view = new Intent("android.intent.action.VIEW");
                view.setDataAndType(Uri.parse((new StringBuilder("file://")).append(ServiceCleaner.access$3(this$0)).toString()), "application/vnd.android.package-archive");
                view.addFlags(0x10000000);
                startActivity(view);
_L4:
                neituidialog.dismiss();
                return;
_L2:
                if (ServiceCleaner.access$4(this$0).exists() && getFileSizes(ServiceCleaner.access$4(this$0)) >= 0x4e87bdL)
                {
                    (new ServiceCleaner._cls1._cls7._cls1()).execute(new Void[0]);
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
                        this$1 = ServiceCleaner._cls1.this;
                        super();
                    }
        }


        // Unreferenced inner class com/aio/downloader/service/ServiceCleaner$1$7$1

/* anonymous class */
        class ServiceCleaner._cls1._cls7._cls1 extends AsyncTask
        {

            final ServiceCleaner._cls1._cls7 this$2;

            protected volatile transient Object doInBackground(Object aobj[])
            {
                return doInBackground((Void[])aobj);
            }

            protected transient Void doInBackground(Void avoid[])
            {
                Myutils.copyfile(ServiceCleaner.access$4(this$0), ServiceCleaner.access$3(this$0), Boolean.valueOf(false));
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
                void1.setDataAndType(Uri.parse((new StringBuilder("file://")).append(ServiceCleaner.access$3(this$0)).toString()), "application/vnd.android.package-archive");
                void1.addFlags(0x10000000);
                startActivity(void1);
            }

                    
                    {
                        this$2 = ServiceCleaner._cls1._cls7.this;
                        super();
                    }
        }

    }

}
