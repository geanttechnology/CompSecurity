// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Toast;
import com.c.a.b.f;
import com.c.a.b.h;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import com.flurry.android.FlurryAgent;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.smule.a;
import com.smule.android.c.aa;
import com.smule.android.c.w;
import com.smule.android.d.g;
import com.smule.android.f.j;
import com.smule.android.f.p;
import com.smule.android.network.managers.LocalizationManager;
import com.smule.android.network.managers.UserManager;
import com.smule.android.network.managers.al;
import com.smule.android.network.managers.am;
import com.smule.android.network.managers.ap;
import com.smule.android.network.managers.i;
import com.smule.pianoandroid.data.db.b;
import com.smule.pianoandroid.data.model.AchievementDefinition;
import com.smule.pianoandroid.data.model.AchievementState;
import com.smule.pianoandroid.e.c;
import com.smule.pianoandroid.magicpiano.a.d;
import com.smule.pianoandroid.utils.k;
import com.smule.pianoandroid.utils.l;
import com.smule.pianoandroid.utils.m;
import com.smule.pianoandroid.utils.v;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipFile;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ac, x, av, ah

public class MagicApplication extends a
{

    static final int LOW_MEM_MSG_INTERVAL = 60000;
    private static final String TAG = com/smule/pianoandroid/magicpiano/MagicApplication.getName();
    private static Boolean sAdvertisingEnabled = Boolean.valueOf(true);
    private static Context sContext;
    private static b sDatabaseHelper = null;
    public static boolean sInitialized = false;
    public static boolean sInitializing = false;
    private static MagicApplication sInstance = null;
    private static j sOperationLoader = new j();
    public static boolean sShowWhatsNew = false;
    final Handler mHandler = new Handler();
    private al mStoreManagerOptionalMethodsDelegate;
    private am mStoreRequiredMethodsDelegate;

    public MagicApplication()
    {
        mStoreRequiredMethodsDelegate = new am() {

            final MagicApplication a;

            public String a()
            {
                return "store.minipiano_android";
            }

            
            {
                a = MagicApplication.this;
                super();
            }
        };
        mStoreManagerOptionalMethodsDelegate = new al() {

            final MagicApplication a;

            public boolean a()
            {
                return true;
            }

            public boolean b()
            {
                return false;
            }

            public int c()
            {
                return -1;
            }

            public String d()
            {
                return null;
            }

            
            {
                a = MagicApplication.this;
                super();
            }
        };
    }

    private void doUpgrade(int i1, int j1)
    {
        if (i1 == 121)
        {
            com.smule.android.notifications.a.a().d(this);
        }
        if (i1 <= 124)
        {
            com.smule.pianoandroid.magicpiano.c.a.a().k();
        }
        if (i1 <= 138)
        {
            c.a().a(null);
        }
        if (i1 <= 141)
        {
            try
            {
                com.smule.pianoandroid.e.a.a().d();
                c.a().c();
            }
            catch (SQLException sqlexception)
            {
                aa.b(TAG, "Failed to migrate achievements", sqlexception);
            }
        }
        if (i1 <= 215)
        {
            Iterator iterator = com.smule.pianoandroid.e.a.a().c().iterator();
            j1 = 0;
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                AchievementDefinition achievementdefinition = (AchievementDefinition)iterator.next();
                if (achievementdefinition.state.completed && !achievementdefinition.state.claimed)
                {
                    j1++;
                }
            } while (true);
            aa.a(TAG, (new StringBuilder()).append("notifications = ").append(j1).toString());
            com.smule.pianoandroid.magicpiano.ac.a().b("NOTIFICATION_ACHIEVEMENTS", j1);
        }
        if (i1 <= 219)
        {
            i.a().b();
            com.smule.pianoandroid.utils.aa.a();
            com.smule.pianoandroid.utils.aa.d();
            com.smule.pianoandroid.utils.aa.c();
        }
        if (i1 <= 220)
        {
            com.smule.pianoandroid.utils.aa.c();
        }
        if (i1 <= 224)
        {
            com.smule.pianoandroid.utils.aa.b();
        }
    }

    public static String getAdColonyAppID()
    {
        return getContext().getString(0x7f0c0020);
    }

    public static String getAppUID()
    {
        int i1;
        if (k.a(getContext()) == l.b)
        {
            i1 = 0x7f0c0028;
        } else
        {
            i1 = 0x7f0c012c;
        }
        return getContext().getString(i1);
    }

    public static Context getContext()
    {
        return sContext;
    }

    public static b getHelper()
    {
        if (sDatabaseHelper == null)
        {
            sDatabaseHelper = (b)OpenHelperManager.getHelper(getContext(), com/smule/pianoandroid/data/db/b);
        }
        return sDatabaseHelper;
    }

    public static MagicApplication getInstance()
    {
        return sInstance;
    }

    public static j getLoader()
    {
        return sOperationLoader;
    }

    public static String getSponsorpayAppID()
    {
        int i1;
        if (k.a(getContext()) == l.b)
        {
            i1 = 0x7f0c026e;
        } else
        {
            i1 = 0x7f0c026f;
        }
        return getContext().getString(i1);
    }

    private void initBilling()
    {
        g.a("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAhJcMunEqa5q+4n10FUkiBJmu+gTVUjbQPOC4npJsu8PkpdUs/89q+pxT/tXQ1h50kTpYJUhBMB2vvjKs+u1k21dUJbu7H41hMcaYVSpXUG8lU3/soEIgol1jdnlIjodA1gTMpsWsryKHskzzPsJkWoinXGSCTS11PkZGkM7me3vF5uQxlH8ekCm+PS5dUKBTFwDlktWkx6Gi7E+yT+HNVwlLTQOVzXcxj7VJhc5qAlEhTn6CuXUZAkxOcab//Uy/ZhYoC5uQFSHs2zXVc+guKTMSRMgXBWpSAu8cBlZEcYqRpzjL6kuXh7h6y7W2gQHyJcpCxgSgUovTsQjlZ5i9gwIDAQAB");
        ap.a().a(this);
        ap.a().a(null);
    }

    public static Boolean isAdvertisingEnabled()
    {
        return sAdvertisingEnabled;
    }

    public static Boolean isDebug()
    {
        return Boolean.valueOf(sInstance.getResources().getBoolean(0x7f070007));
    }

    public static void onActivityStart(Activity activity)
    {
        w.a(activity);
        m.a(activity);
        com.smule.android.notifications.a.a().c(activity);
    }

    public static void onActivityStop(Activity activity)
    {
        w.b(activity);
    }

    public static byte[] readFile(String s)
    {
        Object obj = getContext().getApplicationInfo().sourceDir;
        byte abyte0[];
        int i1;
        try
        {
            obj = new ZipFile(new File(((String) (obj))));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        s = ((ZipFile) (obj)).getEntry(s);
        try
        {
            s = ((ZipFile) (obj)).getInputStream(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        obj = new ByteArrayOutputStream();
        abyte0 = new byte[16384];
        try
        {
            i1 = s.read(abyte0, 0, abyte0.length);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        if (i1 == -1)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        ((ByteArrayOutputStream) (obj)).write(abyte0, 0, i1);
        break MISSING_BLOCK_LABEL_52;
        ((ByteArrayOutputStream) (obj)).flush();
        return ((ByteArrayOutputStream) (obj)).toByteArray();
    }

    private void registerBroadcastReceiver(long l1)
    {
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction("android.intent.action.DEVICE_STORAGE_LOW");
        getApplicationContext().registerReceiver(new x(this, l1), intentfilter);
    }

    public static void setContext(Context context)
    {
        sContext = context;
    }

    public void checkForUpgrade()
    {
        android.content.SharedPreferences.Editor editor;
        int i1;
        int j1;
        try
        {
            i1 = com.smule.pianoandroid.magicpiano.av.a(this);
            j1 = getPackageManager().getPackageInfo(getPackageName(), 0).versionCode;
        }
        catch (Exception exception)
        {
            aa.b(TAG, "Error getting package info!", exception);
            return;
        }
        if (i1 == j1)
        {
            break MISSING_BLOCK_LABEL_77;
        }
        if (i1 == 0)
        {
            break MISSING_BLOCK_LABEL_72;
        }
        sShowWhatsNew = true;
        doUpgrade(i1, j1);
        editor = getApplicationContext().getSharedPreferences("startup_prefs", 0).edit();
        editor.putInt("prev_version", i1);
        p.a(editor);
        com.smule.pianoandroid.magicpiano.av.a(this, j1);
    }

    public boolean isApplicationSentToBackground()
    {
        List list = ((ActivityManager)getSystemService("activity")).getRunningTasks(1);
        if (list.isEmpty())
        {
            return false;
        }
        boolean flag;
        if (!((android.app.ActivityManager.RunningTaskInfo)list.get(0)).topActivity.getPackageName().equals(getPackageName()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return flag;
    }

    public void onCreate()
    {
        super.onCreate();
        Log.i(TAG, "onCreate");
        FlurryAgent.init(this, getString(0x7f0c0111));
        com.smule.android.console.b.a(new d());
        com.smule.android.console.b.a(new com.smule.pianoandroid.magicpiano.a.b());
        com.smule.android.console.b.a(new com.smule.pianoandroid.magicpiano.registration.a());
        com.smule.android.console.b.a(new com.smule.pianoandroid.e.k());
        com.smule.android.console.b.a(new com.smule.pianoandroid.magicpiano.a.c());
        com.smule.android.console.b.a(new com.smule.pianoandroid.e.j());
        com.smule.android.console.b.a(new v(this));
        sInstance = this;
        sContext = this;
        com.c.a.b.g g1;
        boolean flag;
        if ("true".compareTo(getResources().getString(0x7f0c0023)) == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        sAdvertisingEnabled = Boolean.valueOf(flag);
        FacebookSdk.setLegacyTokenUpgradeSupported(true);
        FacebookSdk.sdkInitialize(getApplicationContext());
        if (getResources().getBoolean(0x7f070009))
        {
            FacebookSdk.addLoggingBehavior(LoggingBehavior.INCLUDE_ACCESS_TOKENS);
            FacebookSdk.addLoggingBehavior(LoggingBehavior.GRAPH_API_DEBUG_INFO);
            FacebookSdk.addLoggingBehavior(LoggingBehavior.REQUESTS);
            FacebookSdk.addLoggingBehavior(LoggingBehavior.GRAPH_API_DEBUG_WARNING);
            FacebookSdk.addLoggingBehavior(LoggingBehavior.CACHE);
            FacebookSdk.addLoggingBehavior(LoggingBehavior.INCLUDE_RAW_RESPONSES);
            FacebookSdk.addLoggingBehavior(LoggingBehavior.APP_EVENTS);
            FacebookSdk.addLoggingBehavior(LoggingBehavior.DEVELOPER_ERRORS);
            FacebookSdk.setIsDebugEnabled(true);
        }
        registerBroadcastReceiver(SystemClock.uptimeMillis());
        com.smule.android.network.core.b.a(new ah());
        UserManager.a(this);
        initBilling();
        g1 = (new h(getApplicationContext())).a(new com.c.a.a.b.a.c(0x200000)).a(0x200000).b(0x3200000).c(1000).a();
        com.c.a.c.c.a();
        f.a().a(g1);
        LocalizationManager.a(this);
        com.smule.pianoandroid.magicpiano.c.a.a().b();
        aa.c(TAG, (new StringBuilder()).append("Device UUID: ").append(com.smule.android.f.g.a(this)).toString());
        com.smule.android.notifications.a.a();
        com.smule.android.notifications.a.a(0x7f02013d);
        Log.i(TAG, "end onCreate");
    }

    public void onPause()
    {
    }

    public void onResume()
    {
    }

    public void showToast(String s, int i1)
    {
        s = new Runnable(s, i1) {

            final String a;
            final int b;
            final MagicApplication c;

            public void run()
            {
                Toast.makeText(c, a, b).show();
            }

            
            {
                c = MagicApplication.this;
                a = s;
                b = i1;
                super();
            }
        };
        mHandler.post(s);
    }



}
