// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common;

import android.app.Activity;
import android.app.AppOpsManager;
import android.app.Dialog;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.f;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import com.google.android.gms.b.cz;
import com.google.android.gms.b.dj;
import com.google.android.gms.common.internal.g;
import com.google.android.gms.common.internal.i;
import com.google.android.gms.common.internal.j;
import com.google.android.gms.common.internal.p;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.google.android.gms.common:
//            j, SupportErrorDialogFragment, a, i, 
//            d, c

public final class e
{

    public static final int a = b();
    public static boolean b = false;
    public static boolean c = false;
    static final AtomicBoolean d = new AtomicBoolean();
    private static int e = -1;
    private static final Object f = new Object();
    private static String g = null;
    private static Integer h = null;

    public static int a(Context context)
    {
        Object obj;
        PackageManager packagemanager;
        if (g.a)
        {
            return 0;
        }
        packagemanager = context.getPackageManager();
        com.google.android.gms.common.j j1;
        try
        {
            context.getResources().getString(com.google.android.gms.a.a.common_google_play_services_unknown_issue);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
        }
        if (!"com.google.android.gms".equals(context.getPackageName()))
        {
            g(context);
        }
        try
        {
            obj = packagemanager.getPackageInfo("com.google.android.gms", 64);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 1;
        }
        j1 = j.a();
        if (cz.c(((PackageInfo) (obj)).versionCode) || cz.a(context))
        {
            if (j1.a(((PackageInfo) (obj)), i.am.a) == null)
            {
                Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                return 9;
            }
            break MISSING_BLOCK_LABEL_228;
        }
        Object obj1;
        try
        {
            obj1 = j1.a(packagemanager.getPackageInfo("com.android.vending", 64), i.am.a);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            if (a(context, "com.android.vending"))
            {
                Log.w("GooglePlayServicesUtil", "Google Play Store is updating.");
                if (j1.a(((PackageInfo) (obj)), i.am.a) == null)
                {
                    Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                    return 9;
                }
            } else
            {
                Log.w("GooglePlayServicesUtil", "Google Play Store is neither installed nor updating.");
                return 9;
            }
            break MISSING_BLOCK_LABEL_228;
        }
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_189;
        }
        Log.w("GooglePlayServicesUtil", "Google Play Store signature invalid.");
        return 9;
        if (j1.a(((PackageInfo) (obj)), new i.a[] {
    obj1
}) != null)
        {
            break MISSING_BLOCK_LABEL_228;
        }
        Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
        return 9;
        int k = cz.a(a);
        if (cz.a(((PackageInfo) (obj)).versionCode) < k)
        {
            Log.w("GooglePlayServicesUtil", (new StringBuilder()).append("Google Play services out of date.  Requires ").append(a).append(" but found ").append(((PackageInfo) (obj)).versionCode).toString());
            return 2;
        }
        obj = ((PackageInfo) (obj)).applicationInfo;
        context = ((Context) (obj));
        if (obj == null)
        {
            try
            {
                context = packagemanager.getApplicationInfo("com.google.android.gms", 0);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.");
                context.printStackTrace();
                return 1;
            }
        }
        return ((ApplicationInfo) (context)).enabled ? 0 : 3;
    }

    public static Intent a(int k)
    {
        switch (k)
        {
        default:
            return null;

        case 1: // '\001'
        case 2: // '\002'
            return p.b("com.google.android.gms");

        case 42: // '*'
            return p.a();

        case 3: // '\003'
            return p.a("com.google.android.gms");
        }
    }

    public static boolean a()
    {
        if (b)
        {
            return c;
        } else
        {
            return "user".equals(Build.TYPE);
        }
    }

    public static boolean a(int k, Activity activity, Fragment fragment, int l, android.content.DialogInterface.OnCancelListener oncancellistener)
    {
        boolean flag;
        flag = false;
        fragment = b(k, activity, fragment, l, oncancellistener);
        if (fragment == null)
        {
            return false;
        }
        boolean flag1 = activity instanceof f;
        flag = flag1;
_L2:
        if (flag)
        {
            activity = ((f)activity).f();
            SupportErrorDialogFragment.a(fragment, oncancellistener).show(activity, "GooglePlayServicesErrorDialog");
        } else
        if (dj.a())
        {
            activity = activity.getFragmentManager();
            com.google.android.gms.common.a.a(fragment, oncancellistener).show(activity, "GooglePlayServicesErrorDialog");
        } else
        {
            throw new RuntimeException("This Activity does not support Fragments.");
        }
        return true;
        NoClassDefFoundError noclassdeffounderror;
        noclassdeffounderror;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static boolean a(Context context, int k)
    {
        return a(context, k, "com.google.android.gms") && a(context.getPackageManager(), "com.google.android.gms");
    }

    public static boolean a(Context context, int k, String s)
    {
label0:
        {
            {
                boolean flag1 = false;
                if (!dj.e())
                {
                    break label0;
                }
                context = (AppOpsManager)context.getSystemService("appops");
                boolean flag;
                try
                {
                    context.checkPackage(k, s);
                }
                // Misplaced declaration of an exception variable
                catch (Context context)
                {
                    return false;
                }
                flag = true;
            }
            return flag;
        }
        context = context.getPackageManager().getPackagesForUid(k);
        flag = flag1;
        if (s == null)
        {
            continue;
        }
        flag = flag1;
        if (context == null)
        {
            continue;
        }
        k = 0;
        do
        {
            flag = flag1;
            if (k >= context.length)
            {
                continue;
            }
            if (s.equals(context[k]))
            {
                return true;
            }
            k++;
        } while (true);
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_28;
_L1:
    }

    public static boolean a(Context context, String s)
    {
        if (dj.g())
        {
            context = context.getPackageManager().getPackageInstaller().getAllSessions().iterator();
            do
            {
                if (!context.hasNext())
                {
                    break MISSING_BLOCK_LABEL_76;
                }
            } while (!s.equals(((android.content.pm.PackageInstaller.SessionInfo)context.next()).getAppPackageName()));
            return true;
        }
        context = context.getPackageManager();
        boolean flag = context.getApplicationInfo(s, 8192).enabled;
        if (flag)
        {
            return true;
        }
        break MISSING_BLOCK_LABEL_76;
        context;
        return false;
    }

    public static boolean a(PackageManager packagemanager)
    {
        Object obj = f;
        obj;
        JVM INSTR monitorenter ;
        int k = e;
        if (k != -1) goto _L2; else goto _L1
_L1:
        packagemanager = packagemanager.getPackageInfo("com.google.android.gms", 64);
        if (j.a().a(packagemanager, new i.a[] {
            i.b[1]
        }) == null) goto _L4; else goto _L3
_L3:
        e = 1;
_L2:
        obj;
        JVM INSTR monitorexit ;
        return e != 0;
_L4:
        e = 0;
          goto _L2
        packagemanager;
        e = 0;
          goto _L2
        packagemanager;
        obj;
        JVM INSTR monitorexit ;
        throw packagemanager;
    }

    public static boolean a(PackageManager packagemanager, String s)
    {
        return j.a().a(packagemanager, s);
    }

    private static int b()
    {
        return 0x738638;
    }

    private static Dialog b(int k, Activity activity, Fragment fragment, int l, android.content.DialogInterface.OnCancelListener oncancellistener)
    {
        android.app.AlertDialog.Builder builder1 = null;
        if (k == 0)
        {
            return null;
        }
        int i1 = k;
        if (cz.a(activity))
        {
            i1 = k;
            if (k == 2)
            {
                i1 = 42;
            }
        }
        android.app.AlertDialog.Builder builder = builder1;
        if (dj.c())
        {
            TypedValue typedvalue = new TypedValue();
            activity.getTheme().resolveAttribute(0x1010309, typedvalue, true);
            builder = builder1;
            if ("Theme.Dialog.Alert".equals(activity.getResources().getResourceEntryName(typedvalue.resourceId)))
            {
                builder = new android.app.AlertDialog.Builder(activity, 5);
            }
        }
        builder1 = builder;
        if (builder == null)
        {
            builder1 = new android.app.AlertDialog.Builder(activity);
        }
        builder1.setMessage(i.a(activity, i1, f(activity)));
        if (oncancellistener != null)
        {
            builder1.setOnCancelListener(oncancellistener);
        }
        oncancellistener = a(i1);
        if (fragment == null)
        {
            fragment = new j(activity, oncancellistener, l);
        } else
        {
            fragment = new j(fragment, oncancellistener, l);
        }
        oncancellistener = i.b(activity, i1);
        if (oncancellistener != null)
        {
            builder1.setPositiveButton(oncancellistener, fragment);
        }
        activity = i.a(activity, i1);
        if (activity != null)
        {
            builder1.setTitle(activity);
        }
        return builder1.create();
    }

    public static void b(Context context)
        throws d, c
    {
        int k = a(context);
        if (k != 0)
        {
            context = a(k);
            Log.e("GooglePlayServicesUtil", (new StringBuilder()).append("GooglePlayServices not available due to error ").append(k).toString());
            if (context == null)
            {
                throw new c(k);
            } else
            {
                throw new d(k, "Google Play Services not available", context);
            }
        } else
        {
            return;
        }
    }

    public static boolean b(int k)
    {
        switch (k)
        {
        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
        case 8: // '\b'
        default:
            return false;

        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 9: // '\t'
            return true;
        }
    }

    public static boolean b(Context context, int k)
    {
        if (k == 18)
        {
            return true;
        }
        if (k == 1)
        {
            return a(context, "com.google.android.gms");
        } else
        {
            return false;
        }
    }

    public static boolean b(PackageManager packagemanager)
    {
        return a(packagemanager) || !a();
    }

    public static void c(Context context)
    {
        if (d.getAndSet(true))
        {
            return;
        }
        try
        {
            ((NotificationManager)context.getSystemService("notification")).cancel(10436);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
    }

    public static Resources d(Context context)
    {
        try
        {
            context = context.getPackageManager().getResourcesForApplication("com.google.android.gms");
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return null;
        }
        return context;
    }

    public static Context e(Context context)
    {
        try
        {
            context = context.createPackageContext("com.google.android.gms", 3);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return null;
        }
        return context;
    }

    public static String f(Context context)
    {
        String s1 = context.getApplicationInfo().name;
        String s = s1;
        if (TextUtils.isEmpty(s1))
        {
            s = context.getPackageName();
            PackageManager packagemanager = context.getApplicationContext().getPackageManager();
            try
            {
                context = packagemanager.getApplicationInfo(context.getPackageName(), 0);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                context = null;
            }
            if (context != null)
            {
                s = packagemanager.getApplicationLabel(context).toString();
            }
        }
        return s;
    }

    private static void g(Context context)
    {
        Object obj = f;
        obj;
        JVM INSTR monitorenter ;
        if (g != null) goto _L2; else goto _L1
_L1:
        g = context.getPackageName();
        context = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
        if (context == null) goto _L4; else goto _L3
_L3:
        h = Integer.valueOf(context.getInt("com.google.android.gms.version"));
_L5:
        context = h;
        obj;
        JVM INSTR monitorexit ;
        if (context == null)
        {
            throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
        }
        break MISSING_BLOCK_LABEL_163;
_L4:
        h = null;
          goto _L5
        context;
        Log.wtf("GooglePlayServicesUtil", "This should never happen.", context);
          goto _L5
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
_L2:
        if (g.equals(context.getPackageName())) goto _L5; else goto _L6
_L6:
        throw new IllegalArgumentException((new StringBuilder()).append("isGooglePlayServicesAvailable should only be called with Context from your application's package. A previous call used package '").append(g).append("' and this call used package '").append(context.getPackageName()).append("'.").toString());
        if (context.intValue() != a)
        {
            throw new IllegalStateException((new StringBuilder()).append("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected ").append(a).append(" but").append(" found ").append(context).append(".  You must have the").append(" following declaration within the <application> element: ").append("    <meta-data android:name=\"").append("com.google.android.gms.version").append("\" android:value=\"@integer/google_play_services_version\" />").toString());
        } else
        {
            return;
        }
    }

}
