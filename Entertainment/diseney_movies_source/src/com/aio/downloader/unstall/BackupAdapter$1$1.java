// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.unstall;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Environment;
import android.view.View;
import android.widget.Toast;
import com.aio.downloader.utils.Myutils;
import java.io.File;
import java.util.List;

// Referenced classes of package com.aio.downloader.unstall:
//            BackupAdapter, Info

class this._cls1 extends AsyncTask
{

    final is._cls0 this$1;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        Myutils.copyfile(kFile, ckupFile, Boolean.valueOf(false));
        return null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        super.onPostExecute(void1);
        BackupAdapter.access$3(_fld0).dismiss();
        if (kFile.exists())
        {
            Toast.makeText(BackupAdapter.access$1(_fld0), "Backup successfully", 0).show();
        }
        void1 = new Intent("backup");
        BackupAdapter.access$1(_fld0).sendBroadcast(void1);
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        BackupAdapter.access$2(_fld0, ProgressDialog.show(BackupAdapter.access$1(_fld0), "", "Waitting for backup...", true));
        BackupAdapter.access$3(_fld0).setCancelable(true);
    }

    l.position()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/aio/downloader/unstall/BackupAdapter$1

/* anonymous class */
    class BackupAdapter._cls1
        implements android.view.View.OnClickListener
    {

        private File apkFile;
        private File backupFile;
        final BackupAdapter this$0;
        private final int val$position;

        public void onClick(View view)
        {
            view = ((Info)BackupAdapter.access$0(BackupAdapter.this).get(position)).getPackagename();
            apkFile = new File((new StringBuilder("/data/app/")).append(view).append("-1.apk").toString());
            try
            {
                if (!apkFile.exists())
                {
                    apkFile = new File((new StringBuilder("/data/app/")).append(view).append("-2.apk").toString());
                    if (!apkFile.exists())
                    {
                        Toast.makeText(BackupAdapter.access$1(BackupAdapter.this), "This app does not support backup.", 0).show();
                    }
                }
            }
            catch (Exception exception) { }
            backupFile = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIO_BACKUPAPP").append(File.separator).append(view).append(".apk").toString());
            (new BackupAdapter._cls1._cls1()).execute(new Void[0]);
        }




            
            {
                this$0 = final_backupadapter;
                position = I.this;
                super();
            }
    }

}
