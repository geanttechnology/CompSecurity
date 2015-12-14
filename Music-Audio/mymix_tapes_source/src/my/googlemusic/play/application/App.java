// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.application;

import android.app.Application;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.support.multidex.MultiDex;
import com.applovin.sdk.AppLovinSdk;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.github.hiteshsondhi88.libffmpeg.FFmpeg;
import com.github.hiteshsondhi88.libffmpeg.LoadBinaryResponseHandler;
import com.github.hiteshsondhi88.libffmpeg.exceptions.FFmpegNotSupportedException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.inmobi.sdk.InMobiSdk;
import com.parse.Parse;
import com.parse.PushService;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import my.googlemusic.play.activities.LoginActivity;
import my.googlemusic.play.interfaces.Server;
import my.googlemusic.play.servers.ServerHelper;

public class App extends Application
{

    private static final String ENCRYPTION_KEY[] = {
        "8Rv", "d10", "5ER", "GvI", "80W", "1Uc", "8A2", "HvG", "D32", "D1L"
    };
    private static App sInstance;
    private Gson gson;
    private FFmpeg mFfmpeg;
    private Server mServer;

    public App()
    {
    }

    public static Gson getGson()
    {
        return getInstance().gson;
    }

    public static App getInstance()
    {
        return sInstance;
    }

    public static SharedPreferences getPreferences()
    {
        return PreferenceManager.getDefaultSharedPreferences(sInstance);
    }

    private void initParse()
    {
        Parse.initialize(this, "GVaEWPD2uZWZQlodoAAYQAOGFOzgib80On9bDhU1", "3NBRyNw32d4KbKrNCSfh10avBq25QvpKkzaVlAyK");
        PushService.setDefaultPushCallback(this, my/googlemusic/play/activities/LoginActivity);
        System.out.println("parse initlized");
    }

    private void loadFFMpegBinary()
    {
        try
        {
            savePreferences("support_ffmpeg", true);
            mFfmpeg.loadBinary(new LoadBinaryResponseHandler() {

                final App this$0;

                public void onFailure()
                {
                    App.savePreferences("support_ffmpeg", false);
                }

            
            {
                this$0 = App.this;
                super();
            }
            });
            return;
        }
        catch (FFmpegNotSupportedException ffmpegnotsupportedexception)
        {
            savePreferences("support_ffmpeg", false);
        }
    }

    public static void savePreferences(String s, String s1)
    {
        android.content.SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(sInstance).edit();
        editor.putString(s, s1);
        editor.apply();
    }

    public static void savePreferences(String s, boolean flag)
    {
        android.content.SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(sInstance).edit();
        editor.putBoolean(s, flag);
        editor.apply();
    }

    private void saveWaterMarkImage()
    {
        Object obj;
        Object obj2;
        File file;
        Bitmap bitmap;
        obj = new File((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/MyMixtapez/").toString());
        if (!((File) (obj)).exists())
        {
            ((File) (obj)).mkdir();
        }
        file = new File((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/MyMixtapez/").append("watermark.png").toString());
        if (getPreferences().getString("watermark_path", null) == null && file.exists())
        {
            file.delete();
        }
        if (file.exists())
        {
            break MISSING_BLOCK_LABEL_153;
        }
        obj = null;
        obj2 = null;
        bitmap = BitmapFactory.decodeResource(getResources(), 0x7f0200ce);
        Object obj1 = new FileOutputStream(file);
        bitmap.compress(android.graphics.Bitmap.CompressFormat.PNG, 100, ((java.io.OutputStream) (obj1)));
        try
        {
            ((FileOutputStream) (obj1)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((IOException) (obj)).printStackTrace();
            savePreferences("watermark_path", ((String) (null)));
        }
_L1:
        savePreferences("watermark_path", file.getAbsolutePath());
        return;
        obj;
        obj1 = obj2;
        obj2 = obj;
_L4:
        obj = obj1;
        ((FileNotFoundException) (obj2)).printStackTrace();
        obj = obj1;
        savePreferences("watermark_path", ((String) (null)));
        try
        {
            ((FileOutputStream) (obj1)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((IOException) (obj)).printStackTrace();
            savePreferences("watermark_path", ((String) (null)));
        }
          goto _L1
        obj1;
_L3:
        try
        {
            ((FileOutputStream) (obj)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((IOException) (obj)).printStackTrace();
            savePreferences("watermark_path", ((String) (null)));
        }
        throw obj1;
        obj2;
        obj = obj1;
        obj1 = obj2;
        if (true) goto _L3; else goto _L2
_L2:
        obj2;
          goto _L4
    }

    public String decrypt(String s)
    {
        String s1 = "";
        List list = Arrays.asList(ENCRYPTION_KEY);
        String s2 = s1;
        if (s != null)
        {
            int i = 0;
            do
            {
                s2 = s1;
                if (i >= s.length())
                {
                    break;
                }
                s2 = s.substring(i, i + 3);
                s1 = (new StringBuilder()).append(s1).append(list.indexOf(s2)).toString();
                i += 3;
            } while (true);
        }
        return s2;
    }

    public String encrypt(String s)
    {
        String s2 = "";
        String s1 = s2;
        if (s != null)
        {
            char ac[] = s.toCharArray();
            int j = ac.length;
            int i = 0;
            s = s2;
            do
            {
                s1 = s;
                if (i >= j)
                {
                    break;
                }
                int k = Character.getNumericValue(ac[i]);
                s = (new StringBuilder()).append(s).append(ENCRYPTION_KEY[k]).toString();
                i++;
            } while (true);
        }
        return s1;
    }

    public FFmpeg getFFmpeg()
    {
        return mFfmpeg;
    }

    public Server getServer()
    {
        return mServer;
    }

    public void onCreate()
    {
        super.onCreate();
        sInstance = this;
        gson = (new GsonBuilder()).setDateFormat("yyyy-MM-dd hh:mm:ss.S").create();
        MultiDex.install(this);
        initParse();
        mServer = ServerHelper.with(this);
        mFfmpeg = FFmpeg.getInstance(getApplicationContext());
        loadFFMpegBinary();
        Fresco.initialize(this);
        saveWaterMarkImage();
        AppLovinSdk.initializeSdk(this);
        InMobiSdk.init(this, "f886e7eaf04a4bf1813d2d0ce6e78522");
    }

}
