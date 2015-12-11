// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ImageView;
import com.aio.downloader.utils.Myutils;
import com.aio.downloader.utils.SharedPreferencesConfig;
import java.io.File;

// Referenced classes of package com.aio.downloader.activity:
//            PaidforFreeActivity1, AppDetailsActivity

class this._cls1 extends AsyncTask
{

    final tActivity this$1;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        Myutils.copyfile(PaidforFreeActivity1.access$13(_fld0), PaidforFreeActivity1.access$11(_fld0), Boolean.valueOf(false));
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
        void1.setDataAndType(Uri.parse((new StringBuilder("file://")).append(PaidforFreeActivity1.access$12(_fld0)).append(File.separator).append("cleaner.apk").toString()), "application/vnd.android.package-archive");
        void1.addFlags(0x10000000);
        startActivity(void1);
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/aio/downloader/activity/PaidforFreeActivity1$6

/* anonymous class */
    class PaidforFreeActivity1._cls6
        implements android.view.View.OnClickListener
    {

        final PaidforFreeActivity1 this$0;

        public void onClick(View view)
        {
            SharedPreferencesConfig.SetClickTime(getApplicationContext(), System.currentTimeMillis() + 30000L);
            PaidforFreeActivity1.access$0(PaidforFreeActivity1.this).setImageResource(0x7f0200d7);
            if (PaidforFreeActivity1.access$8(PaidforFreeActivity1.this)) goto _L2; else goto _L1
_L1:
            PaidforFreeActivity1.access$9(PaidforFreeActivity1.this, (int)(Math.random() * 4D) + 1);
            if (PaidforFreeActivity1.access$10(PaidforFreeActivity1.this) != 1) goto _L4; else goto _L3
_L3:
            try
            {
                packageInfo = getPackageManager().getPackageInfo("com.evzapp.cleanmaster", 0);
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                view.printStackTrace();
            }
            if (packageInfo != null) goto _L6; else goto _L5
_L5:
            if (!PaidforFreeActivity1.access$11(PaidforFreeActivity1.this).exists()) goto _L8; else goto _L7
_L7:
            view = new Intent("android.intent.action.VIEW");
            view.setDataAndType(Uri.parse((new StringBuilder("file://")).append(PaidforFreeActivity1.access$12(PaidforFreeActivity1.this)).append(File.separator).append("cleaner.apk").toString()), "application/vnd.android.package-archive");
            view.addFlags(0x10000000);
            startActivity(view);
_L2:
            return;
_L8:
            if (PaidforFreeActivity1.access$13(PaidforFreeActivity1.this).exists())
            {
                (new PaidforFreeActivity1._cls6._cls1()).execute(new Void[0]);
                return;
            } else
            {
                view = new Intent(getApplicationContext(), com/aio/downloader/activity/AppDetailsActivity);
                view.putExtra("myid", "com.evzapp.cleanmaster");
                view.addFlags(0x10000000);
                startActivity(view);
                return;
            }
_L6:
            view = getPackageManager().getLaunchIntentForPackage("com.evzapp.cleanmaster");
            view.addFlags(0x10000000);
            startActivity(view);
            return;
_L4:
            if (PaidforFreeActivity1.access$10(PaidforFreeActivity1.this) != 2)
            {
                break MISSING_BLOCK_LABEL_539;
            }
            try
            {
                packageInfo = getApplicationContext().getPackageManager().getPackageInfo("com.freepezzle.hexcrush", 0);
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                view.printStackTrace();
            }
            if (packageInfo != null)
            {
                break MISSING_BLOCK_LABEL_517;
            }
            try
            {
                if (PaidforFreeActivity1.access$14(PaidforFreeActivity1.this).exists() && getFileSizes(PaidforFreeActivity1.access$14(PaidforFreeActivity1.this)) >= 0x19ee4cL)
                {
                    view = new Intent("android.intent.action.VIEW");
                    view.setDataAndType(Uri.parse((new StringBuilder("file://")).append(PaidforFreeActivity1.access$14(PaidforFreeActivity1.this)).toString()), "application/vnd.android.package-archive");
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
            if (PaidforFreeActivity1.access$15(PaidforFreeActivity1.this).exists() && getFileSizes(PaidforFreeActivity1.access$15(PaidforFreeActivity1.this)) >= 0x19ee4cL)
            {
                (new PaidforFreeActivity1._cls6._cls2()).execute(new Void[0]);
                return;
            }
            view = new Intent(getApplicationContext(), com/aio/downloader/activity/AppDetailsActivity);
            view.putExtra("myid", "com.freepezzle.hexcrush");
            startActivity(view);
            return;
            view = getPackageManager().getLaunchIntentForPackage("com.freepezzle.hexcrush");
            startActivity(view);
            return;
            if (PaidforFreeActivity1.access$10(PaidforFreeActivity1.this) != 3)
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
            if (packageInfo != null)
            {
                break MISSING_BLOCK_LABEL_779;
            }
            try
            {
                if (PaidforFreeActivity1.access$16(PaidforFreeActivity1.this).exists() && getFileSizes(PaidforFreeActivity1.access$16(PaidforFreeActivity1.this)) >= 0x357458L)
                {
                    view = new Intent("android.intent.action.VIEW");
                    view.setDataAndType(Uri.parse((new StringBuilder("file://")).append(PaidforFreeActivity1.access$16(PaidforFreeActivity1.this)).toString()), "application/vnd.android.package-archive");
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
            if (PaidforFreeActivity1.access$17(PaidforFreeActivity1.this).exists() && getFileSizes(PaidforFreeActivity1.access$17(PaidforFreeActivity1.this)) >= 0x357458L)
            {
                (new PaidforFreeActivity1._cls6._cls3()).execute(new Void[0]);
                return;
            }
            view = new Intent(getApplicationContext(), com/aio/downloader/activity/AppDetailsActivity);
            view.putExtra("myid", "com.allinone.callerid");
            view.addFlags(0x10000000);
            startActivity(view);
            return;
            view = getPackageManager().getLaunchIntentForPackage("com.allinone.callerid");
            view.addFlags(0x10000000);
            startActivity(view);
            return;
            if (PaidforFreeActivity1.access$10(PaidforFreeActivity1.this) != 4) goto _L2; else goto _L9
_L9:
            try
            {
                packageInfo = getPackageManager().getPackageInfo("com.aioapp.battery", 0);
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                view.printStackTrace();
            }
            if (packageInfo != null)
            {
                break MISSING_BLOCK_LABEL_1048;
            }
            try
            {
                if (PaidforFreeActivity1.access$18(PaidforFreeActivity1.this).exists() && getFileSizes(PaidforFreeActivity1.access$18(PaidforFreeActivity1.this)) >= 0x377effL)
                {
                    view = new Intent("android.intent.action.VIEW");
                    view.setDataAndType(Uri.parse((new StringBuilder("file://")).append(PaidforFreeActivity1.access$18(PaidforFreeActivity1.this)).toString()), "application/vnd.android.package-archive");
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
            if (PaidforFreeActivity1.access$19(PaidforFreeActivity1.this).exists() && getFileSizes(PaidforFreeActivity1.access$19(PaidforFreeActivity1.this)) >= 0x377effL)
            {
                (new PaidforFreeActivity1._cls6._cls4()).execute(new Void[0]);
                return;
            }
            view = new Intent(getApplicationContext(), com/aio/downloader/activity/AppDetailsActivity);
            view.putExtra("myid", "com.aioapp.battery");
            view.addFlags(0x10000000);
            startActivity(view);
            return;
            view = getPackageManager().getLaunchIntentForPackage("com.aioapp.battery");
            view.addFlags(0x10000000);
            startActivity(view);
            return;
        }


            
            {
                this$0 = PaidforFreeActivity1.this;
                super();
            }

        // Unreferenced inner class com/aio/downloader/activity/PaidforFreeActivity1$6$2

/* anonymous class */
        class PaidforFreeActivity1._cls6._cls2 extends AsyncTask
        {

            final PaidforFreeActivity1._cls6 this$1;

            protected volatile transient Object doInBackground(Object aobj[])
            {
                return doInBackground((Void[])aobj);
            }

            protected transient Void doInBackground(Void avoid[])
            {
                Myutils.copyfile(PaidforFreeActivity1.access$15(this$0), PaidforFreeActivity1.access$14(this$0), Boolean.valueOf(false));
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
                void1.setDataAndType(Uri.parse((new StringBuilder("file://")).append(PaidforFreeActivity1.access$14(this$0)).toString()), "application/vnd.android.package-archive");
                startActivity(void1);
            }

                    
                    {
                        this$1 = PaidforFreeActivity1._cls6.this;
                        super();
                    }
        }


        // Unreferenced inner class com/aio/downloader/activity/PaidforFreeActivity1$6$3

/* anonymous class */
        class PaidforFreeActivity1._cls6._cls3 extends AsyncTask
        {

            final PaidforFreeActivity1._cls6 this$1;

            protected volatile transient Object doInBackground(Object aobj[])
            {
                return doInBackground((Void[])aobj);
            }

            protected transient Void doInBackground(Void avoid[])
            {
                Myutils.copyfile(PaidforFreeActivity1.access$17(this$0), PaidforFreeActivity1.access$16(this$0), Boolean.valueOf(false));
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
                void1.setDataAndType(Uri.parse((new StringBuilder("file://")).append(PaidforFreeActivity1.access$16(this$0)).toString()), "application/vnd.android.package-archive");
                void1.addFlags(0x10000000);
                startActivity(void1);
            }

                    
                    {
                        this$1 = PaidforFreeActivity1._cls6.this;
                        super();
                    }
        }


        // Unreferenced inner class com/aio/downloader/activity/PaidforFreeActivity1$6$4

/* anonymous class */
        class PaidforFreeActivity1._cls6._cls4 extends AsyncTask
        {

            final PaidforFreeActivity1._cls6 this$1;

            protected volatile transient Object doInBackground(Object aobj[])
            {
                return doInBackground((Void[])aobj);
            }

            protected transient Void doInBackground(Void avoid[])
            {
                Myutils.copyfile(PaidforFreeActivity1.access$19(this$0), PaidforFreeActivity1.access$18(this$0), Boolean.valueOf(false));
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
                void1.setDataAndType(Uri.parse((new StringBuilder("file://")).append(PaidforFreeActivity1.access$18(this$0)).toString()), "application/vnd.android.package-archive");
                void1.addFlags(0x10000000);
                startActivity(void1);
            }

                    
                    {
                        this$1 = PaidforFreeActivity1._cls6.this;
                        super();
                    }
        }

    }

}
