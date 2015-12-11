// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.unstall;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;
import com.aio.downloader.db.TypeDbUtilsBackup;
import java.io.File;
import java.util.List;

// Referenced classes of package com.aio.downloader.unstall:
//            BackupNoRootAdapterlist, Info

class this._cls2
    implements Runnable
{

    final ._cls0 this$2;

    public void run()
    {
        BackupNoRootAdapterlist.access$6(_fld0).dismiss();
        Toast.makeText(BackupNoRootAdapterlist.access$1(_fld0), "Backup successfully", 0).show();
    }

    position()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/aio/downloader/unstall/BackupNoRootAdapterlist$1

/* anonymous class */
    class BackupNoRootAdapterlist._cls1
        implements android.view.View.OnClickListener
    {

        private File apkFile;
        private File backupFile;
        final BackupNoRootAdapterlist this$0;
        private final int val$position;

        public void onClick(View view)
        {
            if (BackupNoRootAdapterlist.access$0(BackupNoRootAdapterlist.this) == null)
            {
                BackupNoRootAdapterlist.access$2(BackupNoRootAdapterlist.this, new TypeDbUtilsBackup(BackupNoRootAdapterlist.access$1(BackupNoRootAdapterlist.this)));
            }
            view = null;
            PackageInfo packageinfo = BackupNoRootAdapterlist.access$1(BackupNoRootAdapterlist.this).getPackageManager().getPackageInfo(((Info)BackupNoRootAdapterlist.access$3(BackupNoRootAdapterlist.this).get(position)).getPackagename(), 0);
            view = packageinfo;
_L1:
            if (view != null)
            {
                String s = ((PackageInfo) (view)).applicationInfo.loadLabel(BackupNoRootAdapterlist.access$1(BackupNoRootAdapterlist.this).getPackageManager()).toString();
                Object obj = ((PackageInfo) (view)).applicationInfo.loadIcon(BackupNoRootAdapterlist.access$1(BackupNoRootAdapterlist.this).getPackageManager());
                String s1 = String.valueOf(((PackageInfo) (view)).versionName);
                long l = (new File(((PackageInfo) (view)).applicationInfo.publicSourceDir)).length() / 1024L;
                float f = (float)((double)(int)(((double)l / 1024D) * 100D) / 100D);
                android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
                if (l >= 1024L)
                {
                    view = (new StringBuilder(String.valueOf(f))).append("MB").toString();
                } else
                {
                    view = (new StringBuilder(String.valueOf(l))).append("KB").toString();
                }
                obj = BackupNoRootAdapterlist.bitmaptoString(BackupNoRootAdapterlist.access$4(BackupNoRootAdapterlist.this, ((android.graphics.drawable.Drawable) (obj))));
                BackupNoRootAdapterlist.access$0(BackupNoRootAdapterlist.this).insertApk(((Info)BackupNoRootAdapterlist.access$3(BackupNoRootAdapterlist.this).get(position)).getPackagename(), s, "game_app", ((String) (obj)), view, s1);
            }
            (new BackupNoRootAdapterlist._cls1._cls1()).execute(new Void[0]);
            return;
            namenotfoundexception;
            namenotfoundexception.printStackTrace();
              goto _L1
        }


            
            {
                this$0 = final_backupnorootadapterlist;
                position = I.this;
                super();
            }
    }


    // Unreferenced inner class com/aio/downloader/unstall/BackupNoRootAdapterlist$1$1

/* anonymous class */
    class BackupNoRootAdapterlist._cls1._cls1 extends AsyncTask
    {

        final BackupNoRootAdapterlist._cls1 this$1;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            return null;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Void)obj);
        }

        protected void onPostExecute(Void void1)
        {
            super.onPostExecute(void1);
            (new Handler()).postDelayed(new BackupNoRootAdapterlist._cls1._cls1._cls1(), 2500L);
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            BackupNoRootAdapterlist.access$5(this$0, ProgressDialog.show(BackupNoRootAdapterlist.access$1(this$0), "", "Waiting for backup...", true));
            BackupNoRootAdapterlist.access$6(this$0).setCancelable(true);
        }


            
            {
                this$1 = BackupNoRootAdapterlist._cls1.this;
                super();
            }
    }

}
