// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.start;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.aio.downloader.activity.MyDownloaderList;
import com.aio.downloader.activity.MyMainActivity;
import com.aio.downloader.mydownload.BaseActivity;
import com.aio.downloader.mydownload.DownloadMovieItem;
import com.aio.downloader.utils.Myutils;
import com.aio.downloader.utils.Updatesize;
import com.umeng.analytics.MobclickAgent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import net.tsz.afinal.FinalDBChen;
import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends BaseActivity
{

    private File AIOBATTERY;
    private File AIOBATTERYAPK;
    private File AIOCALLERAPK;
    private File AIOCALLERDOWN;
    private File AIOCRUSHAPK;
    private File AIOCRUSHSWF;
    private File AIOFREE;
    private File AIOFREEAPK;
    private File AIOGALLERY;
    private File AIOGALLERYAPK;
    private File AIOSWFFILE;
    private File PRO_DIR;
    private File PRO_DIR_FOME;
    private File PRO_DIR_TO;
    private Animation animation;
    private Bitmap bitmap;
    private FinalDBChen db;
    private List ds;
    private int h;
    private int i;
    private String id;
    private LinearLayout ll_start;
    private ImageView loginimg;
    private PrintWriter out;
    private TextView tv_aio;
    private int w;

    public MainActivity()
    {
        AIOBATTERY = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("battery.swf").toString());
        AIOBATTERYAPK = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("battery.apk").toString());
        AIOFREE = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("freestore.swf").toString());
        AIOFREEAPK = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("freestore.apk").toString());
        AIOGALLERY = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("gallery.swf").toString());
        AIOGALLERYAPK = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("gallery.apk").toString());
        AIOCALLERDOWN = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("caller.swf").toString());
        AIOCALLERAPK = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("caller.apk").toString());
        AIOCRUSHSWF = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("crush.swf").toString());
        AIOCRUSHAPK = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("crush.apk").toString());
        i = 0;
        AIOSWFFILE = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").toString());
        PRO_DIR = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/cleaner").toString());
        PRO_DIR_FOME = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/cleaner/cleaner.apk").toString());
        PRO_DIR_TO = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/cleaner/cleaner.swf").toString());
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
        int j = ((InputStream) (obj)).read(abyte0);
        if (j != -1)
        {
            break MISSING_BLOCK_LABEL_83;
        }
        fileoutputstream.flush();
        ((InputStream) (obj)).close();
        fileoutputstream.close();
        return file;
        fileoutputstream.write(abyte0, 0, j);
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

    private File getAssetFile_swf()
    {
        Object obj = getAssets();
        File file;
        PRO_DIR.mkdirs();
        obj = ((AssetManager) (obj)).open("cleaner.apk");
        file = new File(PRO_DIR, "cleaner.swf");
        FileOutputStream fileoutputstream;
        byte abyte0[];
        file.createNewFile();
        fileoutputstream = new FileOutputStream(file);
        abyte0 = new byte[1024];
_L1:
        int j = ((InputStream) (obj)).read(abyte0);
        if (j != -1)
        {
            break MISSING_BLOCK_LABEL_83;
        }
        fileoutputstream.flush();
        ((InputStream) (obj)).close();
        fileoutputstream.close();
        return file;
        fileoutputstream.write(abyte0, 0, j);
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
        super.onCreate(bundle);
        setmContext(this);
        setContentView(0x7f03006e);
        Log.e("gak", "onCreate");
        Myutils.iswidget2 = false;
        (new AsyncTask() {

            final MainActivity this$0;

            protected volatile transient Object doInBackground(Object aobj[])
            {
                return doInBackground((Void[])aobj);
            }

            protected transient Void doInBackground(Void avoid[])
            {
                if (PRO_DIR_FOME.exists())
                {
                    PRO_DIR_FOME.delete();
                }
                if (PRO_DIR_TO.exists())
                {
                    PRO_DIR_TO.delete();
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
                (new Thread() {

                    final _cls1 this$1;

                    public void run()
                    {
                        super.run();
                        getAssetFile();
                        getAssetFile_swf();
                    }

            
            {
                this$1 = _cls1.this;
                super();
            }
                }).start();
            }


            
            {
                this$0 = MainActivity.this;
                super();
            }
        }).execute(new Void[0]);
        ll_start = (LinearLayout)findViewById(0x7f070292);
        ll_start.setBackgroundResource(0x7f02000e);
        tv_aio = (TextView)findViewById(0x7f070294);
        initView();
        db = new FinalDBChen(getmContext(), getDatabasePath("download2.db").getAbsolutePath());
        ds = db.findItemsByWhereAndWhereValue(null, null, com/aio/downloader/mydownload/DownloadMovieItem, "downloadtask2", null);
        loginimg = (ImageView)findViewById(0x7f070293);
        try
        {
            if (AIOBATTERY.exists() && (getFileSizes(AIOBATTERY) == 0x677f5bL || getFileSizes(AIOBATTERY) == 0x291a8bL))
            {
                (new File((new StringBuilder()).append(AIOSWFFILE).append(File.separator).append("battery.swf").toString())).delete();
                Log.e("jone", "2693771battery6782811");
            }
            if (AIOBATTERYAPK.exists() && (getFileSizes(AIOBATTERYAPK) == 0x677f5bL || getFileSizes(AIOBATTERYAPK) == 0x291a8bL))
            {
                (new File((new StringBuilder()).append(AIOSWFFILE).append(File.separator).append("battery.apk").toString())).delete();
                Log.e("jone", "2693771battery6782811");
            }
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
        }
        try
        {
            if (AIOCRUSHSWF.exists() && getFileSizes(AIOCRUSHSWF) == 0x19edc6L)
            {
                (new File((new StringBuilder()).append(AIOSWFFILE).append(File.separator).append("battery.swf").toString())).delete();
                Log.e("jone", "delete crush swf");
            }
            if (AIOCRUSHAPK.exists() && getFileSizes(AIOCRUSHAPK) == 0x19edc6L)
            {
                (new File((new StringBuilder()).append(AIOSWFFILE).append(File.separator).append("battery.apk").toString())).delete();
                Log.e("jone", "delete crush apk");
            }
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle) { }
        try
        {
            if (AIOCALLERDOWN.exists() && (getFileSizes(AIOCALLERDOWN) == 0x357458L || getFileSizes(AIOCALLERDOWN) == 0x4e5bb9L || getFileSizes(AIOCALLERDOWN) == 0x4e8608L))
            {
                Log.e("gag", "cleanersize=go on swf");
                (new File((new StringBuilder()).append(AIOSWFFILE).append(File.separator).append("caller.swf").toString())).delete();
                Log.e("jone", "3503192cleaner5135289");
            }
            if (AIOCALLERAPK.exists() && (getFileSizes(AIOCALLERAPK) == 0x357458L || getFileSizes(AIOCALLERAPK) == 0x4e5bb9L || getFileSizes(AIOCALLERAPK) == 0x4e8608L))
            {
                Log.e("gag", "cleanersize=go on apk");
                (new File((new StringBuilder()).append(AIOSWFFILE).append(File.separator).append("caller.apk").toString())).delete();
                Log.e("jone", "3503192cleaner5135289");
            }
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle) { }
        if (AIOBATTERY.exists())
        {
            try
            {
                Log.e("jone", (new StringBuilder("aiobattery=")).append(getFileSizes(AIOBATTERY)).toString());
                if (getFileSizes(AIOBATTERY) < 0x377effL)
                {
                    (new AsyncTask() {

                        final MainActivity this$0;

                        protected volatile transient Object doInBackground(Object aobj[])
                        {
                            return doInBackground((Void[])aobj);
                        }

                        protected transient Void doInBackground(Void avoid[])
                        {
                            AIOBATTERY.delete();
                            Log.e("jone", "delete battery");
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
                this$0 = MainActivity.this;
                super();
            }
                    }).execute(new Void[0]);
                }
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                bundle.printStackTrace();
            }
        }
        if (AIOBATTERYAPK.exists())
        {
            try
            {
                Log.e("jone", (new StringBuilder("aiobattery=")).append(getFileSizes(AIOBATTERYAPK)).toString());
                if (getFileSizes(AIOBATTERYAPK) < 0x377effL)
                {
                    (new AsyncTask() {

                        final MainActivity this$0;

                        protected volatile transient Object doInBackground(Object aobj[])
                        {
                            return doInBackground((Void[])aobj);
                        }

                        protected transient Void doInBackground(Void avoid[])
                        {
                            AIOBATTERYAPK.delete();
                            Log.e("jone", "delete battery");
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
                this$0 = MainActivity.this;
                super();
            }
                    }).execute(new Void[0]);
                }
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                bundle.printStackTrace();
            }
        }
        try
        {
            if (AIOBATTERY.exists() && getFileSizes(AIOBATTERY) >= 0x377effL && !AIOBATTERYAPK.exists())
            {
                Myutils.copyfile(AIOBATTERY, AIOBATTERYAPK, Boolean.valueOf(false));
            }
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
        }
        if (AIOFREE.exists())
        {
            try
            {
                if (getFileSizes(AIOFREE) < 0x40a6caL)
                {
                    (new AsyncTask() {

                        final MainActivity this$0;

                        protected volatile transient Object doInBackground(Object aobj[])
                        {
                            return doInBackground((Void[])aobj);
                        }

                        protected transient Void doInBackground(Void avoid[])
                        {
                            AIOFREE.delete();
                            Log.e("jone", "delete");
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
                this$0 = MainActivity.this;
                super();
            }
                    }).execute(new Void[0]);
                }
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                bundle.printStackTrace();
            }
        }
        if (AIOFREEAPK.exists())
        {
            try
            {
                if (getFileSizes(AIOFREEAPK) < 0x40a6caL)
                {
                    (new AsyncTask() {

                        final MainActivity this$0;

                        protected volatile transient Object doInBackground(Object aobj[])
                        {
                            return doInBackground((Void[])aobj);
                        }

                        protected transient Void doInBackground(Void avoid[])
                        {
                            AIOFREEAPK.delete();
                            Log.e("jone", "delete free");
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
                this$0 = MainActivity.this;
                super();
            }
                    }).execute(new Void[0]);
                }
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                bundle.printStackTrace();
            }
        }
        try
        {
            if (AIOFREE.exists() && getFileSizes(AIOFREE) >= 0x40a6caL && !AIOFREEAPK.exists())
            {
                Myutils.copyfile(AIOFREE, AIOFREEAPK, Boolean.valueOf(false));
            }
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
        }
        try
        {
            if (AIOGALLERY.exists() && getFileSizes(AIOGALLERY) == 0x2d0afcL)
            {
                AIOGALLERY.delete();
            }
            if (AIOGALLERYAPK.exists() && getFileSizes(AIOGALLERYAPK) == 0x2d0afcL)
            {
                AIOGALLERYAPK.delete();
            }
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
        }
        if (AIOGALLERY.exists())
        {
            try
            {
                if (getFileSizes(AIOGALLERY) < 0x1bff04L)
                {
                    (new AsyncTask() {

                        final MainActivity this$0;

                        protected volatile transient Object doInBackground(Object aobj[])
                        {
                            return doInBackground((Void[])aobj);
                        }

                        protected transient Void doInBackground(Void avoid[])
                        {
                            AIOGALLERY.delete();
                            Log.e("jone", "delete gallaer");
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
                this$0 = MainActivity.this;
                super();
            }
                    }).execute(new Void[0]);
                }
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                bundle.printStackTrace();
            }
        }
        if (AIOGALLERYAPK.exists())
        {
            try
            {
                if (getFileSizes(AIOGALLERYAPK) < 0x1bff04L)
                {
                    (new AsyncTask() {

                        final MainActivity this$0;

                        protected volatile transient Object doInBackground(Object aobj[])
                        {
                            return doInBackground((Void[])aobj);
                        }

                        protected transient Void doInBackground(Void avoid[])
                        {
                            AIOGALLERYAPK.delete();
                            Log.e("jone", "delete");
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
                this$0 = MainActivity.this;
                super();
            }
                    }).execute(new Void[0]);
                }
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                bundle.printStackTrace();
            }
        }
        try
        {
            if (AIOGALLERY.exists() && getFileSizes(AIOGALLERY) >= 0x1bff04L && !AIOGALLERYAPK.exists())
            {
                Myutils.copyfile(AIOGALLERY, AIOGALLERYAPK, Boolean.valueOf(false));
            }
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
        }
        if (AIOCALLERDOWN.exists())
        {
            try
            {
                Log.e("jone", (new StringBuilder("aiocaller=")).append(getFileSizes(AIOCALLERDOWN)).toString());
                if (getFileSizes(AIOCALLERDOWN) < 0x4e8608L)
                {
                    (new AsyncTask() {

                        final MainActivity this$0;

                        protected volatile transient Object doInBackground(Object aobj[])
                        {
                            return doInBackground((Void[])aobj);
                        }

                        protected transient Void doInBackground(Void avoid[])
                        {
                            AIOCALLERDOWN.delete();
                            Log.e("jone", "delete caller");
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
                this$0 = MainActivity.this;
                super();
            }
                    }).execute(new Void[0]);
                }
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                bundle.printStackTrace();
            }
        }
        if (AIOCALLERAPK.exists())
        {
            try
            {
                Log.e("jone", (new StringBuilder("aiocaller=")).append(getFileSizes(AIOCALLERAPK)).toString());
                if (getFileSizes(AIOCALLERAPK) < 0x4e8608L)
                {
                    (new AsyncTask() {

                        final MainActivity this$0;

                        protected volatile transient Object doInBackground(Object aobj[])
                        {
                            return doInBackground((Void[])aobj);
                        }

                        protected transient Void doInBackground(Void avoid[])
                        {
                            AIOCALLERAPK.delete();
                            Log.e("jone", "delete caller");
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
                this$0 = MainActivity.this;
                super();
            }
                    }).execute(new Void[0]);
                }
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                bundle.printStackTrace();
            }
        }
        try
        {
            if (AIOCALLERDOWN.exists() && getFileSizes(AIOCALLERDOWN) >= 0x4e8608L && !AIOCALLERAPK.exists())
            {
                Myutils.copyfile(AIOCALLERDOWN, AIOCALLERAPK, Boolean.valueOf(false));
            }
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
        }
        if (AIOCRUSHSWF.exists())
        {
            try
            {
                if (getFileSizes(AIOCRUSHSWF) < 0x19ee4cL)
                {
                    (new AsyncTask() {

                        final MainActivity this$0;

                        protected volatile transient Object doInBackground(Object aobj[])
                        {
                            return doInBackground((Void[])aobj);
                        }

                        protected transient Void doInBackground(Void avoid[])
                        {
                            AIOCRUSHSWF.delete();
                            Log.e("jone", "delete caller");
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
                this$0 = MainActivity.this;
                super();
            }
                    }).execute(new Void[0]);
                }
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                bundle.printStackTrace();
            }
        }
        if (AIOCRUSHAPK.exists())
        {
            try
            {
                Log.e("jone", (new StringBuilder("aiocrush=")).append(getFileSizes(AIOCRUSHAPK)).toString());
                if (getFileSizes(AIOCRUSHAPK) < 0x19ee4cL)
                {
                    (new AsyncTask() {

                        final MainActivity this$0;

                        protected volatile transient Object doInBackground(Object aobj[])
                        {
                            return doInBackground((Void[])aobj);
                        }

                        protected transient Void doInBackground(Void avoid[])
                        {
                            AIOCRUSHAPK.delete();
                            Log.e("jone", "delete crush");
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
                this$0 = MainActivity.this;
                super();
            }
                    }).execute(new Void[0]);
                }
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                bundle.printStackTrace();
            }
        }
        try
        {
            if (AIOCRUSHSWF.exists() && getFileSizes(AIOCRUSHSWF) >= 0x19ee4cL && !AIOCRUSHAPK.exists())
            {
                Myutils.copyfile(AIOCRUSHSWF, AIOCRUSHAPK, Boolean.valueOf(false));
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
        }
    }

    protected void onPause()
    {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    public void onResume()
    {
        super.onResume();
        MobclickAgent.onResume(this);
        Log.e("gak", "onResume");
        Object obj;
        String s;
        try
        {
            Updatesize.getUpdatesize().list_update.clear();
        }
        catch (Exception exception) { }
        obj = getIntent();
        s = ((Intent) (obj)).getAction();
        Log.e("gak", (new StringBuilder("action=")).append(s).toString());
        if ("android.intent.action.VIEW".equals(s))
        {
            obj = ((Intent) (obj)).getDataString();
            Log.e("gak", (new StringBuilder("url===========")).append(((String) (obj))).toString());
            if (((String) (obj)).startsWith("aio"))
            {
                (new Thread() {

                    final MainActivity this$0;

                    public void run()
                    {
                        ServerSocket serversocket;
                        super.run();
                        serversocket = null;
                        if (false)
                        {
                            break MISSING_BLOCK_LABEL_21;
                        }
                        serversocket = new ServerSocket(12121);
_L3:
                        Socket socket = serversocket.accept();
                        Object obj1 = "";
                        OutputStream outputstream;
                        InputStream inputstream;
                        BufferedReader bufferedreader;
                        outputstream = socket.getOutputStream();
                        inputstream = socket.getInputStream();
                        bufferedreader = new BufferedReader(new InputStreamReader(inputstream));
_L5:
                        String s3 = bufferedreader.readLine();
                        if (s3 != null) goto _L2; else goto _L1
_L1:
                        try
                        {
                            Log.e("write", "write11111");
                            obj1 = ((String) (obj1)).split(" ")[1].trim();
                            String as[] = ((String) (obj1)).split("/?jsonpCallback=");
                            String s1 = as[as.length - 1].split("&")[0];
                            Log.e("gak", (new StringBuilder(String.valueOf(obj1))).append("====buffer====").append(s1).toString());
                            new JSONObject();
                            new JSONArray();
                            obj1 = (new StringBuilder(String.valueOf(s1))).append("({name:'aio'})").toString();
                            Log.e("gak", (new StringBuilder("str===")).append(((String) (obj1))).toString());
                            Log.e("write", "write22222");
                            outputstream.write(((String) (obj1)).getBytes("gbk"));
                            outputstream.flush();
                            socket.shutdownOutput();
                            outputstream.close();
                            bufferedreader.close();
                            inputstream.close();
                            socket.close();
                        }
                        // Misplaced declaration of an exception variable
                        catch (Object obj1)
                        {
                            Log.e("gak", (new StringBuilder("catch1")).append(((IOException) (obj1)).getMessage()).toString());
                            ((IOException) (obj1)).printStackTrace();
                            return;
                        }
                          goto _L3
_L2:
                        String s2;
                        boolean flag;
                        s2 = (new StringBuilder(String.valueOf(obj1))).append(s3).toString();
                        Log.e("gak", (new StringBuilder("line=")).append(s3).toString());
                        flag = s3.equals("");
                        obj1 = s2;
                        if (!flag) goto _L5; else goto _L4
_L4:
                        obj1 = s2;
                          goto _L1
                    }

            
            {
                this$0 = MainActivity.this;
                super();
            }
                }).start();
            }
            if (!((String) (obj)).equals("") && obj != null)
            {
                i = i + 1;
                Intent intent = new Intent(getApplicationContext(), com/aio/downloader/activity/MyMainActivity);
                intent.putExtra("acquire_url_start", ((String) (obj)));
                startActivity(intent);
            }
        }
        if (i == 0)
        {
            (new Handler()).postDelayed(new Runnable() {

                final MainActivity this$0;

                public void run()
                {
                    Intent intent1 = new Intent(MainActivity.this, com/aio/downloader/activity/MyDownloaderList);
                    intent1.putExtra("acquire_url_start", "");
                    startActivity(intent1);
                    finish();
                    overridePendingTransition(0x7f04000c, 0x7f040011);
                }

            
            {
                this$0 = MainActivity.this;
                super();
            }
            }, 5000L);
        }
    }














}
