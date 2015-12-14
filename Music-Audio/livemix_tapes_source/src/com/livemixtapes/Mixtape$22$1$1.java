// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.app.DownloadManager;
import android.content.DialogInterface;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.view.View;
import android.widget.TextView;
import com.livemixtapes.ui.BaseActivity;
import java.io.File;
import java.util.Map;
import net.lingala.zip4j.core.ZipFile;
import org.json.JSONObject;

// Referenced classes of package com.livemixtapes:
//            Mixtape, console, App

class this._cls2
    implements android.content..OnClickListener
{

    final dismiss this$2;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
    }

    HttpCallback()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/livemixtapes/Mixtape$22

/* anonymous class */
    class Mixtape._cls22 extends AsyncHttp.AsyncHttpCallback
    {

        final Mixtape this$0;
        private final View val$downloadZipView;

        protected void always()
        {
        }

        protected void exception(Exception exception1)
        {
            console.log(new Object[] {
                exception1
            });
        }

        protected void success(final String unzip_filename, String s, int i)
        {
            String s1;
            console.log(new Object[] {
                (new StringBuilder("download response: ")).append(Mixtape.access$38(Mixtape.this)).toString(), unzip_filename, s, Integer.valueOf(i)
            });
            s = "download unavailable";
            s1 = "file.zip";
            unzip_filename = (new JSONObject(unzip_filename)).getString("download_url");
            s = unzip_filename;
            console.log(new Object[] {
                (new StringBuilder("zip url: ")).append(unzip_filename).toString()
            });
            s = unzip_filename;
            String as[] = unzip_filename.split("/");
            s = unzip_filename;
            String s2 = as[as.length - 1];
            s = unzip_filename;
            unzip_filename = s2;
_L2:
            if (s.equals("download unavailable"))
            {
                ((BaseActivity)mContext).runOnUiThread(new Mixtape._cls22._cls1());
                return;
            }
            downloadStatus = (TextView)downloadZipView.findViewById(0x7f080077);
            s = new android.app.DownloadManager.Request(Uri.parse(s));
            s.setAllowedNetworkTypes(3).setAllowedOverRoaming(false).setTitle((String)mixtape.get("title")).setDescription("Downloading mixtape zip file...").setDestinationInExternalPublicDir(Environment.DIRECTORY_MUSIC, unzip_filename);
            console.log(new Object[] {
                (new StringBuilder("DOWNLOADING: ")).append(unzip_filename).toString()
            });
            final long zipdownloadid = downloadManager.enqueue(s);
            if (unzip_filename.contains("?"))
            {
                unzip_filename = unzip_filename.split("\\?")[0];
            }
            (new Thread(new Mixtape._cls22._cls2())).start();
            return;
            unzip_filename;
            unzip_filename = s1;
            if (true) goto _L2; else goto _L1
_L1:
        }


            
            {
                this$0 = final_mixtape;
                downloadZipView = View.this;
                super();
            }

        // Unreferenced inner class com/livemixtapes/Mixtape$22$2

/* anonymous class */
        class Mixtape._cls22._cls2
            implements Runnable
        {

            final Mixtape._cls22 this$1;
            private final String val$unzip_filename;
            private final long val$zipdownloadid;

            public void run()
            {
                boolean flag = true;
_L2:
                Object obj;
                String s;
                int i;
                int j;
                if (!flag)
                {
                    return;
                }
                obj = new android.app.DownloadManager.Query();
                ((android.app.DownloadManager.Query) (obj)).setFilterById(new long[] {
                    zipdownloadid
                });
                obj = downloadManager.query(((android.app.DownloadManager.Query) (obj)));
                ((Cursor) (obj)).moveToFirst();
                i = ((Cursor) (obj)).getInt(((Cursor) (obj)).getColumnIndex("bytes_so_far"));
                j = ((Cursor) (obj)).getInt(((Cursor) (obj)).getColumnIndex("total_size"));
                if (((Cursor) (obj)).getInt(((Cursor) (obj)).getColumnIndex("status")) != 8)
                {
                    break MISSING_BLOCK_LABEL_327;
                }
                flag = false;
                ((BaseActivity)mContext).runOnUiThread(new Mixtape._cls22._cls2._cls1());
                console.log(new Object[] {
                    (new StringBuilder("UNZIPPING: ")).append(unzip_filename).toString()
                });
                ((BaseActivity)mContext).runOnUiThread(new Mixtape._cls22._cls2._cls2());
                s = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC).toString();
                ZipFile zipfile = new ZipFile((new StringBuilder(String.valueOf(s))).append("/").append(unzip_filename).toString());
                zipfile.isEncrypted();
                zipfile.extractAll(s);
                try
                {
                    (new File((new StringBuilder(String.valueOf(s))).append("/").append(unzip_filename).toString())).delete();
                    s = unzip_filename.replace(".zip", "");
                    Mixtape.access$39(this$0, s);
                    App.isUnzipping = false;
                    ((BaseActivity)mContext).runOnUiThread(new Mixtape._cls22._cls2._cls3());
                }
                catch (Exception exception1)
                {
                    try
                    {
                        exception1.printStackTrace();
                    }
                    catch (Exception exception2)
                    {
                        exception2.printStackTrace();
                    }
                }
                i = (int)(((long)i * 100L) / (long)j);
                ((BaseActivity)mContext).runOnUiThread(new Mixtape._cls22._cls2._cls4());
                ((Cursor) (obj)).close();
                if (true) goto _L2; else goto _L1
_L1:
            }


                    
                    {
                        this$1 = Mixtape._cls22.this;
                        zipdownloadid = l;
                        unzip_filename = s;
                        super();
                    }
        }


        // Unreferenced inner class com/livemixtapes/Mixtape$22$2$1

/* anonymous class */
        class Mixtape._cls22._cls2._cls1
            implements Runnable
        {

            final Mixtape._cls22._cls2 this$2;

            public void run()
            {
            }

                    
                    {
                        this$2 = Mixtape._cls22._cls2.this;
                        super();
                    }
        }


        // Unreferenced inner class com/livemixtapes/Mixtape$22$2$2

/* anonymous class */
        class Mixtape._cls22._cls2._cls2
            implements Runnable
        {

            final Mixtape._cls22._cls2 this$2;

            public void run()
            {
                (new android.app.AlertDialog.Builder(mContext)).setTitle("Mixtape Unzipping").setMessage("Your mixtape is downloaded and it is now unzipping...please wait.").setPositiveButton("OK", new Mixtape._cls22._cls2._cls2._cls1()).setIcon(0x1080027).show();
            }

                    
                    {
                        this$2 = Mixtape._cls22._cls2.this;
                        super();
                    }
        }


        // Unreferenced inner class com/livemixtapes/Mixtape$22$2$2$1

/* anonymous class */
        class Mixtape._cls22._cls2._cls2._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final Mixtape._cls22._cls2._cls2 this$3;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$3 = Mixtape._cls22._cls2._cls2.this;
                        super();
                    }
        }


        // Unreferenced inner class com/livemixtapes/Mixtape$22$2$3

/* anonymous class */
        class Mixtape._cls22._cls2._cls3
            implements Runnable
        {

            final Mixtape._cls22._cls2 this$2;

            public void run()
            {
                (new android.app.AlertDialog.Builder(mContext)).setTitle("Download Complete").setMessage("Your mixtape has finished downloading!  We extracted the zip for you too!").setPositiveButton("Thanks!", new Mixtape._cls22._cls2._cls3._cls1()).setIcon(0x1080027).show();
            }

                    
                    {
                        this$2 = Mixtape._cls22._cls2.this;
                        super();
                    }
        }


        // Unreferenced inner class com/livemixtapes/Mixtape$22$2$3$1

/* anonymous class */
        class Mixtape._cls22._cls2._cls3._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final Mixtape._cls22._cls2._cls3 this$3;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$3 = Mixtape._cls22._cls2._cls3.this;
                        super();
                    }
        }


        // Unreferenced inner class com/livemixtapes/Mixtape$22$2$4

/* anonymous class */
        class Mixtape._cls22._cls2._cls4
            implements Runnable
        {

            final Mixtape._cls22._cls2 this$2;

            public void run()
            {
            }

                    
                    {
                        this$2 = Mixtape._cls22._cls2.this;
                        super();
                    }
        }

    }


    // Unreferenced inner class com/livemixtapes/Mixtape$22$1

/* anonymous class */
    class Mixtape._cls22._cls1
        implements Runnable
    {

        final Mixtape._cls22 this$1;

        public void run()
        {
            (new android.app.AlertDialog.Builder(mContext)).setTitle("Download Unavailable").setMessage("This mixtape cannot be downloaded yet.").setPositiveButton("OK", new Mixtape._cls22._cls1._cls1()).setIcon(0x1080027).show();
        }

            
            {
                this$1 = Mixtape._cls22.this;
                super();
            }
    }

}
