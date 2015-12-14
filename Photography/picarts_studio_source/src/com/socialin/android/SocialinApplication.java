// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.os.Environment;
import android.os.IBinder;
import android.os.StatFs;
import android.support.multidex.MultiDexApplication;
import com.adjust.sdk.Adjust;
import com.adjust.sdk.AdjustConfig;
import com.adjust.sdk.LogLevel;
import com.facebook.FacebookSdk;
import com.firegnom.rat.ExceptionHandler;
import com.flurry.android.FlurryAgent;
import com.picsart.studio.PicsartContext;
import com.picsart.upload.UploadService;
import com.socialin.android.activity.ExceptionReportActivity;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.log.EventLoggingService;
import com.socialin.android.apiv3.model.Settings;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.photo.clipart.SyncClipartsService;
import com.socialin.android.photo.exif.ExifTool;
import com.socialin.android.photo.imgop.ImageOp;
import com.socialin.android.photo.imgop.ImageOpCommon;
import com.socialin.android.photo.imgop.ImageResize;
import com.socialin.android.photo.imgop.RenderScriptOp;
import com.socialin.android.photo.imgop.b;
import com.socialin.android.photo.notifications.NotificationsService;
import com.socialin.android.util.ClassLoaderInjector;
import com.socialin.android.util.Utils;
import com.socialin.asyncnet.cache.CacheManager;
import dalvik.system.PathClassLoader;
import io.branch.referral.Branch;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ThreadPoolExecutor;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android:
//            d

public class SocialinApplication extends MultiDexApplication
{

    public static boolean a = false;
    public static boolean b = false;
    public static boolean c = false;
    private static String e = (new StringBuilder()).append(com/socialin/android/SocialinApplication.getSimpleName()).append(" - ").toString();
    private static String f = "socialin";
    public ThreadPoolExecutor d;
    private SocialinV3 g;
    private boolean h;

    public SocialinApplication()
    {
        h = false;
    }

    private boolean a(File file, String s)
    {
        Object obj;
        obj = null;
        IOException ioexception;
        int i;
        try
        {
            s = new BufferedInputStream(getAssets().open(s));
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            s = null;
            continue; /* Loop/switch isn't completed */
        }
        file = new BufferedOutputStream(new FileOutputStream(file));
        obj = new byte[8192];
_L3:
        i = s.read(((byte []) (obj)), 0, 8192);
        if (i <= 0) goto _L2; else goto _L1
_L1:
        file.write(((byte []) (obj)), 0, i);
          goto _L3
        ioexception;
        obj = s;
        s = file;
        file = ioexception;
_L5:
        if (s != null)
        {
            try
            {
                s.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                com.socialin.android.d.b(e, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(file.getMessage()).toString()
                });
            }
        }
        if (obj != null)
        {
            try
            {
                ((BufferedInputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                com.socialin.android.d.b(e, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(file.getMessage()).toString()
                });
            }
        }
        return false;
_L2:
        file.flush();
        file.close();
        s.close();
        return true;
        file;
        Object obj1 = null;
        obj = s;
        s = obj1;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public void onCreate()
    {
        Object obj;
        super.onCreate();
        FlurryAgent.setLogEnabled(false);
        AnalyticUtils.getInstance(getApplicationContext());
        FlurryAgent.init(this, AnalyticUtils.FLURRY_ANALYTICS_KEY);
        FacebookSdk.sdkInitialize(this);
        bindService(new Intent(this, com/socialin/android/apiv3/log/EventLoggingService), new ServiceConnection() {

            public final void onServiceConnected(ComponentName componentname, IBinder ibinder)
            {
            }

            public final void onServiceDisconnected(ComponentName componentname)
            {
            }

        }, 1);
        bindService(new Intent(this, com/socialin/android/photo/clipart/SyncClipartsService), new ServiceConnection() {

            public final void onServiceConnected(ComponentName componentname, IBinder ibinder)
            {
            }

            public final void onServiceDisconnected(ComponentName componentname)
            {
            }

        }, 1);
        obj = getApplicationContext().getPackageManager();
        Object obj2;
        int i;
        obj = ((PackageManager) (obj)).getPackageInfo(getPackageName(), 128);
        obj2 = getSharedPreferences("appVersionPreferences", 0);
        i = ((SharedPreferences) (obj2)).getInt("appVersionKey", 0);
        if (i != 0) goto _L2; else goto _L1
_L1:
        b = false;
        a = true;
_L5:
        if (i < ((PackageInfo) (obj)).versionCode)
        {
            obj2 = ((SharedPreferences) (obj2)).edit();
            ((android.content.SharedPreferences.Editor) (obj2)).putInt("appVersionKey", ((PackageInfo) (obj)).versionCode);
            ((android.content.SharedPreferences.Editor) (obj2)).apply();
        }
          goto _L3
_L2:
        if (i >= ((PackageInfo) (obj)).versionCode) goto _L5; else goto _L4
_L4:
        b = true;
        a = false;
        obj3 = getSharedPreferences("appState", 4).edit();
        ((android.content.SharedPreferences.Editor) (obj3)).putBoolean("UPDATE_INSTALL", b);
        ((android.content.SharedPreferences.Editor) (obj3)).apply();
          goto _L5
        exception;
        com.socialin.android.d.b(e, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(exception.getMessage()).toString()
        });
_L3:
        CacheManager cachemanager;
        obj2 = Utils.k(this);
        obj = new ArrayList();
        if (!ImageOpCommon.a)
        {
            ((ArrayList) (obj)).add("imageopcommon");
        }
        if (!ImageResize.a)
        {
            ((ArrayList) (obj)).add("imageresize");
        }
        if (!ExifTool.a)
        {
            ((ArrayList) (obj)).add("exif_tool");
        }
        if ("com.picsart.studio".equalsIgnoreCase(((String) (obj2))))
        {
            if (!ImageOp.a)
            {
                ((ArrayList) (obj)).add("imageop");
            }
            if (!RenderScriptOp.a)
            {
                ((ArrayList) (obj)).add("RenderScriptOp");
            }
        }
        if (((ArrayList) (obj)).size() > 0)
        {
            obj2 = com.socialin.android.photo.imgop.b.a(this, ((ArrayList) (obj)));
            i = 0;
            while (i < ((ArrayList) (obj)).size()) 
            {
                Object obj3 = (String)((ArrayList) (obj)).get(i);
                Exception exception;
                boolean flag;
                if (((HashMap) (obj2)).containsKey(obj3) && ((Boolean)((HashMap) (obj2)).get(obj3)).booleanValue())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (((String) (obj3)).compareTo("imageopcommon") == 0)
                {
                    ImageOpCommon.a = flag;
                    ImageOpCommon.a();
                } else
                if (((String) (obj3)).compareTo("imageresize") == 0)
                {
                    ImageResize.a = flag;
                } else
                if (((String) (obj3)).compareTo("exif_tool") == 0)
                {
                    ExifTool.a = flag;
                } else
                if (((String) (obj3)).compareTo("imageop") == 0)
                {
                    ImageOp.a = flag;
                    ImageOp.b();
                } else
                if (((String) (obj3)).compareTo("RenderScriptOp") == 0)
                {
                    RenderScriptOp.a = flag;
                }
                i++;
            }
        }
        cachemanager = CacheManager.a();
        obj2 = cachemanager.c;
        obj2;
        JVM INSTR monitorenter ;
        CacheManager.b = (new StringBuilder()).append(Environment.getExternalStorageDirectory().getPath()).append("/Android/data/").append(getPackageName()).append("/.cache/").toString();
        exception = getPackageManager().getPackageInfo(getPackageName(), 0);
_L6:
        if (exception != null)
        {
            break MISSING_BLOCK_LABEL_679;
        }
        i = 1;
_L7:
        cachemanager.d = i;
        cachemanager.b();
        obj2;
        JVM INSTR monitorexit ;
        g = new SocialinV3(this);
        if (b)
        {
            g.requestWhatsNewData();
        }
        if (!m.a(this, "string", "si_app_uid"))
        {
            throw new IllegalStateException("missing 'si_app_uid' in props.xml");
        }
        break MISSING_BLOCK_LABEL_693;
        exception;
        com.socialin.android.d.a(new Object[] {
            CacheManager.a, (new StringBuilder("Got unexpected exception: ")).append(exception.getMessage()).toString()
        });
        exception = null;
          goto _L6
        i = ((PackageInfo) (exception)).versionCode;
          goto _L7
        Exception exception1;
        exception1;
        obj2;
        JVM INSTR monitorexit ;
        throw exception1;
        f = getString(m.b(this, "string", "si_app_uid"));
        System.setProperty("packageName", getPackageName());
        com.socialin.android.d.b(e, new Object[] {
            "onCreate() appId:", f, " gameSecret:", "puzzle"
        });
        Object obj1 = new StatFs(Environment.getExternalStorageDirectory().getPath());
        long l = ((StatFs) (obj1)).getBlockSize();
        l = ((long)((StatFs) (obj1)).getAvailableBlocks() * l) / 0x100000L;
        com.socialin.android.d.b(e, new Object[] {
            "onCreate() - SDcardAvailableSizeInMB - ", Long.valueOf(l)
        });
        if (getFilesDir() != null)
        {
            obj1 = new StatFs(getFilesDir().getPath());
            long l1 = ((StatFs) (obj1)).getBlockSize();
            l1 = ((long)((StatFs) (obj1)).getAvailableBlocks() * l1) / 0x100000L;
            com.socialin.android.d.b(e, new Object[] {
                "onCreate() - InternalStorageAvailableSizeInMB - ", Long.valueOf(l1)
            });
        }
        AnalyticUtils.getInstance(this).startAnalytics();
        AnalyticUtils.getInstance(this).resetLocalTracker();
        AnalyticUtils.getInstance(this).trackLocalAction("app:OnCreate");
        boolean flag1;
        if ((getApplicationInfo().flags & 2) != 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        h = flag1;
        com.socialin.android.d.b = h;
        ExceptionHandler.register(this, com/socialin/android/activity/ExceptionReportActivity);
        Utils.a();
        if (!com.socialin.android.d.b);
        obj1 = new Intent(this, com/socialin/android/photo/notifications/NotificationsService);
        ((Intent) (obj1)).setAction("actoion.get.picsart.news");
        startService(((Intent) (obj1)));
        try
        {
            obj1 = getSharedPreferences("appVersionPreferences", 0);
            if (((SharedPreferences) (obj1)).getInt("appVersionKey", 0) < 40)
            {
                g.updateInventory();
                obj1 = ((SharedPreferences) (obj1)).edit();
                ((android.content.SharedPreferences.Editor) (obj1)).putInt("appVersionKey", 40);
                ((android.content.SharedPreferences.Editor) (obj1)).apply();
            }
        }
        catch (Exception exception2)
        {
            com.socialin.android.d.b(e, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(exception2.getMessage()).toString()
            });
        }
        obj1 = new Intent(this, com/picsart/upload/UploadService);
        ((Intent) (obj1)).setAction("picsart.upload.check");
        startService(((Intent) (obj1)));
        try
        {
            FlurryAgent.setContinueSessionMillis(0x30d40L);
            File file = new File(getDir("dex", 0), "encoder_dex.apk");
            if (!file.exists() || a || b || h)
            {
                a(file, "encoder_dex.apk");
            }
            com.socialin.android.d.a("Found secondary dex. Attempting to inject");
            ClassLoaderInjector.add(file, getDir("outdex", 0), (PathClassLoader)getBaseContext().getClassLoader());
        }
        catch (Exception exception3)
        {
            try
            {
                FlurryAgent.onError("start", "inject", exception3);
            }
            catch (Exception exception4)
            {
                exception4.printStackTrace();
            }
            com.socialin.android.d.a("Failed with secondary dex. Going ahead with normal startup");
        }
        PicsartContext.a(this);
        if (Branch.a() == null)
        {
            Branch.c(this);
        }
        if (SocialinV3.getInstance().getSettings().isAdjustEnabled())
        {
            try
            {
                AdjustConfig adjustconfig = new AdjustConfig(this, getString(0x7f0808a1), "sandbox");
                adjustconfig.setLogLevel(LogLevel.VERBOSE);
                Adjust.onCreate(adjustconfig);
                com.socialin.android.d.a(e, "Adjust is initialized");
                return;
            }
            catch (Exception exception5)
            {
                com.socialin.android.d.b(e, "intiAdjust: Fail", exception5);
            }
            return;
        }
        com.socialin.android.d.a(e, "Adjust is disabled !");
        return;
          goto _L5
    }

    public void onLowMemory()
    {
        com.socialin.android.d.b(e, new Object[] {
            "onLowMemory() gameId:", f, " gameSecret:", "puzzle"
        });
        super.onLowMemory();
    }

    public void onTerminate()
    {
        com.socialin.android.d.b(e, new Object[] {
            "onTerminate() gameId:", f, " gameSecret:", "puzzle"
        });
        super.onTerminate();
    }

}
