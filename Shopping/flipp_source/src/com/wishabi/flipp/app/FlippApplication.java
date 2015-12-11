// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.app.Activity;
import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.content.CursorLoader;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.amazon.device.messaging.ADM;
import com.facebook.AppEventsLogger;
import com.facebook.Settings;
import com.google.analytics.tracking.android.ak;
import com.localytics.android.LocalyticsActivityLifecycleCallbacks;
import com.wishabi.flipp.b.a;
import com.wishabi.flipp.b.g;
import com.wishabi.flipp.b.h;
import com.wishabi.flipp.b.u;
import com.wishabi.flipp.content.SearchTermProvider;
import com.wishabi.flipp.content.i;
import com.wishabi.flipp.util.p;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;
import net.hockeyapp.android.b;
import net.hockeyapp.android.y;

// Referenced classes of package com.wishabi.flipp.app:
//            d, aw, az, ba, 
//            ay, c, ax

public class FlippApplication extends Application
    implements android.app.Application.ActivityLifecycleCallbacks, d
{

    private static final String a = com/wishabi/flipp/app/FlippApplication.getSimpleName();
    private static Context c;
    private static Handler d;
    private c b;
    private final android.content.SharedPreferences.OnSharedPreferenceChangeListener e = new aw(this);
    private CursorLoader f;

    public FlippApplication()
    {
    }

    static void a(FlippApplication flippapplication)
    {
        Object obj;
        Object obj1;
        SharedPreferences sharedpreferences;
        sharedpreferences = flippapplication.getSharedPreferences("com.wishabi.flipp.preferences", 0);
        String s = flippapplication.c();
        String.format("GCM token:%s", new Object[] {
            s
        });
        obj1 = "https://backflipp.wishabi.com/flipp/gcm/registration";
        obj = s;
        if (s == null)
        {
            obj = flippapplication.d();
            obj1 = "https://backflipp.wishabi.com/flipp/adm/registration";
        }
        if (obj != null) goto _L2; else goto _L1
_L1:
        (new az(flippapplication)).execute(new Void[0]);
        Class.forName("com.amazon.device.messaging.ADM");
        (new ADM(flippapplication)).startRegister();
_L4:
        return;
_L2:
        Object obj2 = sharedpreferences.getString("postal_code", null);
        if (obj2 == null) goto _L4; else goto _L3
_L3:
        obj1 = Uri.parse(((String) (obj1))).buildUpon();
        ((android.net.Uri.Builder) (obj1)).appendPath(((String) (obj)));
        ((android.net.Uri.Builder) (obj1)).appendQueryParameter("locale", Locale.getDefault().toString());
        ((android.net.Uri.Builder) (obj1)).appendQueryParameter("postal_code", ((String) (obj2)));
        if (sharedpreferences.contains("allow_push"))
        {
            if (sharedpreferences.getBoolean("allow_push", true))
            {
                obj = "true";
            } else
            {
                obj = "false";
            }
            ((android.net.Uri.Builder) (obj1)).appendQueryParameter("allow_push", ((String) (obj)));
        }
        obj2 = new ArrayList();
        obj = flippapplication.getContentResolver().query(i.f, new String[] {
            "_id"
        }, null, null, null);
_L6:
        if (obj == null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (!((Cursor) (obj)).moveToNext())
        {
            break; /* Loop/switch isn't completed */
        }
        ((ArrayList) (obj2)).add(((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndexOrThrow("_id")));
        if (true) goto _L6; else goto _L5
        flippapplication;
_L8:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw flippapplication;
_L5:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        if (!((ArrayList) (obj2)).isEmpty())
        {
            ((android.net.Uri.Builder) (obj1)).appendQueryParameter("merchant_ids", TextUtils.join(",", ((Iterable) (obj2))));
        }
        obj = ((android.net.Uri.Builder) (obj1)).build();
        if (obj == null) goto _L4; else goto _L7
_L7:
        try
        {
            obj = new URL(((Uri) (obj)).toString());
        }
        // Misplaced declaration of an exception variable
        catch (FlippApplication flippapplication)
        {
            return;
        }
        (new ba(flippapplication, ((URL) (obj)))).execute(new Void[0]);
        return;
        flippapplication;
        obj = null;
          goto _L8
        flippapplication;
    }

    public static boolean a(Runnable runnable)
    {
        com/wishabi/flipp/app/FlippApplication;
        JVM INSTR monitorenter ;
        boolean flag;
        if (d != null && d.post(runnable))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        com/wishabi/flipp/app/FlippApplication;
        JVM INSTR monitorexit ;
        return flag;
        runnable;
        com/wishabi/flipp/app/FlippApplication;
        JVM INSTR monitorexit ;
        throw runnable;
    }

    public static Context b()
    {
        return c;
    }

    private String c()
    {
        SharedPreferences sharedpreferences = getSharedPreferences("com.wishabi.flipp.preferences", 0);
        String s = sharedpreferences.getString("gcm_registration_id", null);
        if (s != null)
        {
            int j = sharedpreferences.getInt("gcm_application_version_id", 0);
            if (getPackageManager() != null)
            {
                int k;
                try
                {
                    k = getPackageManager().getPackageInfo(getPackageName(), 0).versionCode;
                }
                catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
                {
                    return null;
                }
                if (k == j)
                {
                    return s;
                }
            }
        }
        return null;
    }

    private String d()
    {
        String s;
        try
        {
            Class.forName("com.amazon.device.messaging.ADM");
            s = (new ADM(this)).getRegistrationId();
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            return null;
        }
        return s;
    }

    public final void a()
    {
        a.a.a(null, null);
    }

    public void onActivityCreated(Activity activity, Bundle bundle)
    {
        y.a(activity, "d13259c95a0a44508d6479c605ca9ca2");
    }

    public void onActivityDestroyed(Activity activity)
    {
    }

    public void onActivityPaused(Activity activity)
    {
    }

    public void onActivityResumed(Activity activity)
    {
        boolean flag1 = false;
        net.hockeyapp.android.b.a(activity, "d13259c95a0a44508d6479c605ca9ca2", new ay(this));
        activity = a.a;
        activity.c();
        SharedPreferences sharedpreferences = ((a) (activity)).b.getSharedPreferences("com.wishabi.flipp.preferences", 0);
        if (!sharedpreferences.getBoolean("install_sent", false))
        {
            String s = sharedpreferences.getString("referrer", null);
            if (s != null)
            {
                if (!s.equals("none"))
                {
                    HashMap hashmap = new HashMap();
                    hashmap.put("referrer", s);
                    activity.a("app_install", hashmap, false);
                }
                sharedpreferences.edit().putBoolean("install_sent", true).commit();
            }
        }
        activity = b;
        long l = System.nanoTime();
        sharedpreferences = p.a();
        boolean flag;
        if (sharedpreferences != null && l - sharedpreferences.getLong("app_open_last_recreate_nano", 0L) > ((c) (activity)).a)
        {
            sharedpreferences.edit().putLong("app_open_last_recreate_nano", 0L).commit();
            flag = false;
        } else
        {
            flag = true;
        }
        if (l - ((c) (activity)).d <= ((c) (activity)).a)
        {
            flag1 = true;
        }
        if (!((c) (activity)).c && !flag)
        {
            activity.c = true;
            if (!flag1 && ((c) (activity)).e != null)
            {
                ((c) (activity)).e.a();
                return;
            }
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle)
    {
    }

    public void onActivityStarted(Activity activity)
    {
        b.b = new WeakReference(activity);
    }

    public void onActivityStopped(Activity activity)
    {
        c c1 = b;
        Activity activity1 = null;
        if (c1.b != null)
        {
            activity1 = (Activity)c1.b.get();
        }
        if (activity1 == activity)
        {
            c1.c = false;
        }
        c1.d = System.nanoTime();
    }

    public void onCreate()
    {
        super.onCreate();
        c = this;
        d = new Handler(Looper.getMainLooper());
        registerActivityLifecycleCallbacks(this);
        a a1 = a.a;
        a1.b = this;
        a1.p = Calendar.getInstance().getTimeZone().getDisplayName(false, 0);
        a1.n = android.provider.Settings.Secure.getString(a1.b.getContentResolver(), "android_id");
        Object obj;
        PackageManager packagemanager;
        String s;
        if (a1.b.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") == 0)
        {
            obj = ((TelephonyManager)a1.b.getSystemService("phone")).getDeviceId();
        } else
        {
            obj = null;
        }
        a1.o = ((String) (obj));
        a1.e = ak.a(a1.b).a("UA-43421620-4", "UA-43421620-4");
        obj = p.a();
        ((SharedPreferences) (obj)).registerOnSharedPreferenceChangeListener(new g(a1));
        a1.h = ((SharedPreferences) (obj)).getString("advertising_id", null);
        a1.i = ((SharedPreferences) (obj)).getBoolean("is_lat", false);
        a1.k = ((SharedPreferences) (obj)).getString("postal_code", null);
        a1.q = ((SharedPreferences) (obj)).getString("nan_hash", null);
        if (a1.q == null)
        {
            a1.q = UUID.randomUUID().toString().replaceAll("-", "");
            ((SharedPreferences) (obj)).edit().putString("nan_hash", a1.q).commit();
        }
        a1.m = a1.b.getContentResolver();
        ((WindowManager)a1.b.getSystemService("window")).getDefaultDisplay().getSize(a1.l);
        packagemanager = a1.b.getPackageManager();
        s = a1.b.getPackageName();
        if (packagemanager != null)
        {
            try
            {
                a1.j = packagemanager.getPackageInfo(s, 0).versionName;
            }
            catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
            {
                namenotfoundexception.printStackTrace();
            }
            (new h(a1, ((SharedPreferences) (obj)))).execute(new Void[0]);
            a1.f = AppEventsLogger.newLogger(a1.b, "576005129150479");
            Settings.setAppVersion(a1.j);
            registerActivityLifecycleCallbacks(new LocalyticsActivityLifecycleCallbacks(a1.b));
        }
        obj = u.a;
        obj.b = this;
        obj.c = new Handler(((u) (obj)).b.getMainLooper());
        obj = p.a();
        if (obj != null)
        {
            ((SharedPreferences) (obj)).registerOnSharedPreferenceChangeListener(e);
            SearchTermProvider.a(((SharedPreferences) (obj)).getBoolean("keep_search_history", true));
        }
        f = new CursorLoader(this, i.f, null, null, null, null);
        f.registerListener(0, new ax(this));
        f.startLoading();
        b = new c(this);
    }

}
