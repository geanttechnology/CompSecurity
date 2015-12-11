// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.cleaner;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.view.View;
import com.aio.downloader.utils.Myutils;
import java.io.File;

// Referenced classes of package com.aio.downloader.cleaner:
//            ShowCleanActivity1

class this._cls1 extends AsyncTask
{

    final tActivity this$1;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        Myutils.copyfile(ShowCleanActivity1.access$25(_fld0), ShowCleanActivity1.access$23(_fld0), Boolean.valueOf(false));
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
        void1.setDataAndType(Uri.parse((new StringBuilder("file://")).append(ShowCleanActivity1.access$24(_fld0)).append(File.separator).append("cleaner.apk").toString()), "application/vnd.android.package-archive");
        void1.addFlags(0x10000000);
        startActivity(void1);
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/aio/downloader/cleaner/ShowCleanActivity1$5

/* anonymous class */
    class ShowCleanActivity1._cls5
        implements android.view.View.OnClickListener
    {

        final ShowCleanActivity1 this$0;

        public void onClick(View view)
        {
            view = null;
            android.content.pm.PackageInfo packageinfo;
            try
            {
                packageinfo = getPackageManager().getPackageInfo("com.evzapp.cleanmaster", 0);
            }
            catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
            {
                namenotfoundexception.printStackTrace();
                continue; /* Loop/switch isn't completed */
            }
            view = packageinfo;
_L6:
            if (view != null)
            {
                break MISSING_BLOCK_LABEL_142;
            }
            if (!ShowCleanActivity1.access$23(ShowCleanActivity1.this).exists()) goto _L2; else goto _L1
_L1:
            view = new Intent("android.intent.action.VIEW");
            view.setDataAndType(Uri.parse((new StringBuilder("file://")).append(ShowCleanActivity1.access$24(ShowCleanActivity1.this)).append(File.separator).append("cleaner.apk").toString()), "application/vnd.android.package-archive");
            view.addFlags(0x10000000);
            startActivity(view);
_L4:
            return;
_L2:
            if (!ShowCleanActivity1.access$25(ShowCleanActivity1.this).exists()) goto _L4; else goto _L3
_L3:
            (new ShowCleanActivity1._cls5._cls1()).execute(new Void[0]);
            return;
            view = getPackageManager().getLaunchIntentForPackage("com.evzapp.cleanmaster");
            view.addFlags(0x10000000);
            startActivity(view);
            return;
            if (true) goto _L6; else goto _L5
_L5:
        }


            
            {
                this$0 = ShowCleanActivity1.this;
                super();
            }
    }

}
