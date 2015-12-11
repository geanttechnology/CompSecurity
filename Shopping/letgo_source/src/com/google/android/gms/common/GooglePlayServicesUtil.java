// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common;

import android.app.Activity;
import android.app.AppOpsManager;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.g;
import android.support.v7.vl;
import android.support.v7.vs;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.internal.i;
import com.google.android.gms.common.internal.j;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.x;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.google.android.gms.common:
//            ConnectionResult, j, e, a, 
//            d, c, i

public final class GooglePlayServicesUtil
{
    private static class a extends Handler
    {

        private final Context a;

        public void handleMessage(Message message)
        {
            message.what;
            JVM INSTR tableswitch 1 1: default 24
        //                       1 53;
               goto _L1 _L2
_L1:
            Log.w("GooglePlayServicesUtil", (new StringBuilder()).append("Don't know how to handle this message: ").append(message.what).toString());
_L4:
            return;
_L2:
            int k = GooglePlayServicesUtil.isGooglePlayServicesAvailable(a);
            if (GooglePlayServicesUtil.isUserRecoverableError(k))
            {
                GooglePlayServicesUtil.zzb(k, a);
                return;
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        a(Context context)
        {
            Looper looper;
            if (Looper.myLooper() == null)
            {
                looper = Looper.getMainLooper();
            } else
            {
                looper = Looper.myLooper();
            }
            super(looper);
            a = context.getApplicationContext();
        }
    }


    public static final String GMS_ERROR_DIALOG = "GooglePlayServicesErrorDialog";
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = zzmW();
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
    public static boolean zzYu = false;
    public static boolean zzYv = false;
    private static int zzYw = -1;
    private static String zzYx = null;
    private static Integer zzYy = null;
    static final AtomicBoolean zzYz = new AtomicBoolean();
    private static final Object zzpm = new Object();

    private GooglePlayServicesUtil()
    {
    }

    public static Dialog getErrorDialog(int k, Activity activity, int l)
    {
        return getErrorDialog(k, activity, l, null);
    }

    public static Dialog getErrorDialog(int k, Activity activity, int l, android.content.DialogInterface.OnCancelListener oncancellistener)
    {
        return zza(k, activity, null, l, oncancellistener);
    }

    public static PendingIntent getErrorPendingIntent(int k, Context context, int l)
    {
        Intent intent = zzbc(k);
        if (intent == null)
        {
            return null;
        } else
        {
            return PendingIntent.getActivity(context, l, intent, 0x10000000);
        }
    }

    public static String getErrorString(int k)
    {
        return ConnectionResult.a(k);
    }

    public static String getOpenSourceSoftwareLicenseInfo(Context context)
    {
        Object obj = (new android.net.Uri.Builder()).scheme("android.resource").authority("com.google.android.gms").appendPath("raw").appendPath("oss_notice").build();
        InputStream inputstream = context.getContentResolver().openInputStream(((android.net.Uri) (obj)));
        try
        {
            context = (new Scanner(inputstream)).useDelimiter("\\A").next();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            if (inputstream == null)
            {
                break MISSING_BLOCK_LABEL_97;
            }
            try
            {
                inputstream.close();
                break MISSING_BLOCK_LABEL_97;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                obj = null;
            }
            break MISSING_BLOCK_LABEL_95;
        }
        finally
        {
            if (inputstream == null) goto _L0; else goto _L0
        }
        obj = context;
        if (inputstream == null)
        {
            break MISSING_BLOCK_LABEL_95;
        }
        inputstream.close();
        return context;
        inputstream.close();
        throw context;
        return ((String) (obj));
        return null;
    }

    public static Context getRemoteContext(Context context)
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

    public static Resources getRemoteResource(Context context)
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

    public static int isGooglePlayServicesAvailable(Context context)
    {
        Object obj;
        PackageManager packagemanager;
        if (f.a)
        {
            return 0;
        }
        packagemanager = context.getPackageManager();
        com.google.android.gms.common.j j1;
        try
        {
            context.getResources().getString(android.support.v7.ks.b.common_google_play_services_unknown_issue);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
        }
        if (!"com.google.android.gms".equals(context.getPackageName()))
        {
            zzad(context);
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
        if (vl.c(((PackageInfo) (obj)).versionCode) || vl.a(context))
        {
            if (j1.a(((PackageInfo) (obj)), i.aw.a) == null)
            {
                Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                return 9;
            }
            break MISSING_BLOCK_LABEL_230;
        }
        Object obj1;
        try
        {
            obj1 = j1.a(packagemanager.getPackageInfo("com.android.vending", 64), i.aw.a);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            if (zzh(context, "com.android.vending"))
            {
                Log.w("GooglePlayServicesUtil", "Google Play Store is updating.");
                if (j1.a(((PackageInfo) (obj)), i.aw.a) == null)
                {
                    Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                    return 9;
                }
            } else
            {
                Log.w("GooglePlayServicesUtil", "Google Play Store is neither installed nor updating.");
                return 9;
            }
            break MISSING_BLOCK_LABEL_230;
        }
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_190;
        }
        Log.w("GooglePlayServicesUtil", "Google Play Store signature invalid.");
        return 9;
        if (j1.a(((PackageInfo) (obj)), new i.a[] {
    obj1
}) != null)
        {
            break MISSING_BLOCK_LABEL_230;
        }
        Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
        return 9;
        int k = vl.a(GOOGLE_PLAY_SERVICES_VERSION_CODE);
        if (vl.a(((PackageInfo) (obj)).versionCode) < k)
        {
            Log.w("GooglePlayServicesUtil", (new StringBuilder()).append("Google Play services out of date.  Requires ").append(GOOGLE_PLAY_SERVICES_VERSION_CODE).append(" but found ").append(((PackageInfo) (obj)).versionCode).toString());
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

    public static boolean isUserRecoverableError(int k)
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

    public static boolean showErrorDialogFragment(int k, Activity activity, int l)
    {
        return showErrorDialogFragment(k, activity, l, null);
    }

    public static boolean showErrorDialogFragment(int k, Activity activity, int l, android.content.DialogInterface.OnCancelListener oncancellistener)
    {
        return showErrorDialogFragment(k, activity, null, l, oncancellistener);
    }

    public static boolean showErrorDialogFragment(int k, Activity activity, Fragment fragment, int l, android.content.DialogInterface.OnCancelListener oncancellistener)
    {
        boolean flag;
        flag = false;
        fragment = zza(k, activity, fragment, l, oncancellistener);
        if (fragment == null)
        {
            return false;
        }
        boolean flag1 = activity instanceof g;
        flag = flag1;
_L2:
        if (flag)
        {
            activity = ((g)activity).f();
            e.a(fragment, oncancellistener).a(activity, "GooglePlayServicesErrorDialog");
        } else
        if (vs.a())
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

    public static void showErrorNotification(int k, Context context)
    {
        int l = k;
        if (vl.a(context))
        {
            l = k;
            if (k == 2)
            {
                l = 42;
            }
        }
        if (zzd(context, l) || zzf(context, l))
        {
            zzae(context);
            return;
        } else
        {
            zza(l, context);
            return;
        }
    }

    private static Dialog zza(int k, Activity activity, Fragment fragment, int l, android.content.DialogInterface.OnCancelListener oncancellistener)
    {
        android.app.AlertDialog.Builder builder1 = null;
        if (k == 0)
        {
            return null;
        }
        int i1 = k;
        if (vl.a(activity))
        {
            i1 = k;
            if (k == 2)
            {
                i1 = 42;
            }
        }
        android.app.AlertDialog.Builder builder = builder1;
        if (vs.c())
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
        builder1.setMessage(i.a(activity, i1, zzaf(activity)));
        if (oncancellistener != null)
        {
            builder1.setOnCancelListener(oncancellistener);
        }
        oncancellistener = zzbc(i1);
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

    private static void zza(int k, Context context)
    {
        zza(k, context, null);
    }

    private static void zza(int k, Context context, String s)
    {
        Resources resources = context.getResources();
        String s2 = zzaf(context);
        String s1 = i.c(context, k);
        Object obj = s1;
        if (s1 == null)
        {
            obj = resources.getString(android.support.v7.ks.b.common_google_play_services_notification_ticker);
        }
        s2 = i.b(context, k, s2);
        PendingIntent pendingintent = getErrorPendingIntent(k, context, 0);
        if (vl.a(context))
        {
            x.a(vs.d());
            obj = (new android.app.Notification.Builder(context)).setSmallIcon(android.support.v7.ks.a.common_ic_googleplayservices).setPriority(2).setAutoCancel(true).setStyle((new android.app.Notification.BigTextStyle()).bigText((new StringBuilder()).append(((String) (obj))).append(" ").append(s2).toString())).addAction(android.support.v7.ks.a.common_full_open_on_phone, resources.getString(android.support.v7.ks.b.common_open_on_phone), pendingintent).build();
        } else
        {
            Object obj1 = resources.getString(android.support.v7.ks.b.common_google_play_services_notification_ticker);
            if (vs.a())
            {
                obj = (new android.app.Notification.Builder(context)).setSmallIcon(0x108008a).setContentTitle(((CharSequence) (obj))).setContentText(s2).setContentIntent(pendingintent).setTicker(((CharSequence) (obj1))).setAutoCancel(true);
                if (vs.h())
                {
                    ((android.app.Notification.Builder) (obj)).setLocalOnly(true);
                }
                if (vs.d())
                {
                    ((android.app.Notification.Builder) (obj)).setStyle((new android.app.Notification.BigTextStyle()).bigText(s2));
                    obj = ((android.app.Notification.Builder) (obj)).build();
                } else
                {
                    obj = ((android.app.Notification.Builder) (obj)).getNotification();
                }
                if (android.os.Build.VERSION.SDK_INT == 19)
                {
                    ((Notification) (obj)).extras.putBoolean("android.support.localOnly", true);
                }
            } else
            {
                obj1 = new Notification(0x108008a, ((CharSequence) (obj1)), System.currentTimeMillis());
                obj1.flags = ((Notification) (obj1)).flags | 0x10;
                ((Notification) (obj1)).setLatestEventInfo(context, ((CharSequence) (obj)), s2, pendingintent);
                obj = obj1;
            }
        }
        if (zzbd(k))
        {
            zzYz.set(false);
            k = 10436;
        } else
        {
            k = 39789;
        }
        context = (NotificationManager)context.getSystemService("notification");
        if (s != null)
        {
            context.notify(s, k, ((Notification) (obj)));
            return;
        } else
        {
            context.notify(k, ((Notification) (obj)));
            return;
        }
    }

    public static boolean zza(Context context, int k, String s)
    {
label0:
        {
            {
                boolean flag1 = false;
                if (!vs.g())
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

    public static void zzaa(Context context)
        throws d, c
    {
        int k = isGooglePlayServicesAvailable(context);
        if (k != 0)
        {
            context = zzbc(k);
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

    public static void zzac(Context context)
    {
        if (zzYz.getAndSet(true))
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

    private static void zzad(Context context)
    {
        Object obj = zzpm;
        obj;
        JVM INSTR monitorenter ;
        if (zzYx != null) goto _L2; else goto _L1
_L1:
        zzYx = context.getPackageName();
        context = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
        if (context == null) goto _L4; else goto _L3
_L3:
        zzYy = Integer.valueOf(context.getInt("com.google.android.gms.version"));
_L5:
        context = zzYy;
        obj;
        JVM INSTR monitorexit ;
        if (context == null)
        {
            throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
        }
        break MISSING_BLOCK_LABEL_163;
_L4:
        zzYy = null;
          goto _L5
        context;
        Log.wtf("GooglePlayServicesUtil", "This should never happen.", context);
          goto _L5
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
_L2:
        if (zzYx.equals(context.getPackageName())) goto _L5; else goto _L6
_L6:
        throw new IllegalArgumentException((new StringBuilder()).append("isGooglePlayServicesAvailable should only be called with Context from your application's package. A previous call used package '").append(zzYx).append("' and this call used package '").append(context.getPackageName()).append("'.").toString());
        if (context.intValue() != GOOGLE_PLAY_SERVICES_VERSION_CODE)
        {
            throw new IllegalStateException((new StringBuilder()).append("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected ").append(GOOGLE_PLAY_SERVICES_VERSION_CODE).append(" but").append(" found ").append(context).append(".  You must have the").append(" following declaration within the <application> element: ").append("    <meta-data android:name=\"").append("com.google.android.gms.version").append("\" android:value=\"@integer/google_play_services_version\" />").toString());
        } else
        {
            return;
        }
    }

    private static void zzae(Context context)
    {
        context = new a(context);
        context.sendMessageDelayed(context.obtainMessage(1), 0x1d4c0L);
    }

    public static String zzaf(Context context)
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

    public static boolean zzag(Context context)
    {
        context = context.getPackageManager();
        return vs.j() && context.hasSystemFeature("com.google.sidewinder");
    }

    static void zzb(int k, Context context)
    {
        zza(k, context);
    }

    public static boolean zzb(PackageManager packagemanager)
    {
        Object obj = zzpm;
        obj;
        JVM INSTR monitorenter ;
        int k = zzYw;
        if (k != -1) goto _L2; else goto _L1
_L1:
        packagemanager = packagemanager.getPackageInfo("com.google.android.gms", 64);
        if (j.a().a(packagemanager, new i.a[] {
            i.b[1]
        }) == null) goto _L4; else goto _L3
_L3:
        zzYw = 1;
_L2:
        obj;
        JVM INSTR monitorexit ;
        return zzYw != 0;
_L4:
        zzYw = 0;
          goto _L2
        packagemanager;
        zzYw = 0;
          goto _L2
        packagemanager;
        obj;
        JVM INSTR monitorexit ;
        throw packagemanager;
    }

    public static boolean zzb(PackageManager packagemanager, String s)
    {
        return j.a().a(packagemanager, s);
    }

    public static Intent zzbc(int k)
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

    private static boolean zzbd(int k)
    {
        switch (k)
        {
        default:
            return false;

        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 18: // '\022'
        case 42: // '*'
            return true;
        }
    }

    public static boolean zzc(PackageManager packagemanager)
    {
        return zzb(packagemanager) || !zzmX();
    }

    public static boolean zzd(Context context, int k)
    {
        if (k == 18)
        {
            return true;
        }
        if (k == 1)
        {
            return zzh(context, "com.google.android.gms");
        } else
        {
            return false;
        }
    }

    public static boolean zze(Context context, int k)
    {
        return zza(context, k, "com.google.android.gms") && zzb(context.getPackageManager(), "com.google.android.gms");
    }

    public static boolean zzf(Context context, int k)
    {
        if (k == 9)
        {
            return zzh(context, "com.android.vending");
        } else
        {
            return false;
        }
    }

    public static boolean zzh(Context context, String s)
    {
        if (vs.j())
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

    private static int zzmW()
    {
        return 0x7877d8;
    }

    public static boolean zzmX()
    {
        if (zzYu)
        {
            return zzYv;
        } else
        {
            return "user".equals(Build.TYPE);
        }
    }

}
