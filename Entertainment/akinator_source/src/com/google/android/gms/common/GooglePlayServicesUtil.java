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
import android.os.UserManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzh;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzml;
import com.google.android.gms.internal.zzmx;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.google.android.gms.common:
//            GoogleApiAvailability, ConnectionResult, zzd, SupportErrorDialogFragment, 
//            ErrorDialogFragment, GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException, zzc

public final class GooglePlayServicesUtil
{

    public static final String GMS_ERROR_DIALOG = "GooglePlayServicesErrorDialog";
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = zzns();
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
    public static boolean zzaal = false;
    public static boolean zzaam = false;
    private static int zzaan = -1;
    private static String zzaao = null;
    private static Integer zzaap = null;
    static final AtomicBoolean zzaaq = new AtomicBoolean();
    private static final AtomicBoolean zzaar = new AtomicBoolean();
    private static final Object zzpy = new Object();

    private GooglePlayServicesUtil()
    {
    }

    public static Dialog getErrorDialog(int i, Activity activity, int j)
    {
        return getErrorDialog(i, activity, j, null);
    }

    public static Dialog getErrorDialog(int i, Activity activity, int j, android.content.DialogInterface.OnCancelListener oncancellistener)
    {
        return zza(i, activity, null, j, oncancellistener);
    }

    public static PendingIntent getErrorPendingIntent(int i, Context context, int j)
    {
        return GoogleApiAvailability.getInstance().getErrorResolutionPendingIntent(context, i, j);
    }

    public static String getErrorString(int i)
    {
        return ConnectionResult.getStatusString(i);
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
        com.google.android.gms.common.zzd zzd1;
        if (zzd.zzaeK)
        {
            return 0;
        }
        packagemanager = context.getPackageManager();
        try
        {
            context.getResources().getString(com.google.android.gms.R.string.common_google_play_services_unknown_issue);
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
        zzd1 = com.google.android.gms.common.zzd.zznu();
        if (zzml.zzcb(((PackageInfo) (obj)).versionCode) || zzml.zzan(context))
        {
            if (zzd1.zza(((PackageInfo) (obj)), zzc.zzbz.zzaak) == null)
            {
                Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                return 9;
            }
            break MISSING_BLOCK_LABEL_189;
        }
        try
        {
            context = zzd1.zza(packagemanager.getPackageInfo("com.android.vending", 8256), zzc.zzbz.zzaak);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.w("GooglePlayServicesUtil", "Google Play Store is neither installed nor updating.");
            return 9;
        }
        if (context != null)
        {
            break MISSING_BLOCK_LABEL_162;
        }
        Log.w("GooglePlayServicesUtil", "Google Play Store signature invalid.");
        return 9;
        if (zzd1.zza(((PackageInfo) (obj)), new zzc.zza[] {
    context
}) != null)
        {
            break MISSING_BLOCK_LABEL_189;
        }
        Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
        return 9;
        int i = zzml.zzca(GOOGLE_PLAY_SERVICES_VERSION_CODE);
        if (zzml.zzca(((PackageInfo) (obj)).versionCode) < i)
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
                Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.", context);
                return 1;
            }
        }
        return ((ApplicationInfo) (context)).enabled ? 0 : 3;
    }

    public static boolean isUserRecoverableError(int i)
    {
        switch (i)
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

    public static boolean showErrorDialogFragment(int i, Activity activity, int j)
    {
        return showErrorDialogFragment(i, activity, j, null);
    }

    public static boolean showErrorDialogFragment(int i, Activity activity, int j, android.content.DialogInterface.OnCancelListener oncancellistener)
    {
        return showErrorDialogFragment(i, activity, null, j, oncancellistener);
    }

    public static boolean showErrorDialogFragment(int i, Activity activity, Fragment fragment, int j, android.content.DialogInterface.OnCancelListener oncancellistener)
    {
        fragment = zza(i, activity, fragment, j, oncancellistener);
        if (fragment == null)
        {
            return false;
        } else
        {
            zza(activity, oncancellistener, "GooglePlayServicesErrorDialog", fragment);
            return true;
        }
    }

    public static void showErrorNotification(int i, Context context)
    {
        int j = i;
        if (zzml.zzan(context))
        {
            j = i;
            if (i == 2)
            {
                j = 42;
            }
        }
        if (zzd(context, j) || zzf(context, j))
        {
            zzae(context);
            return;
        } else
        {
            zza(j, context);
            return;
        }
    }

    private static Dialog zza(int i, Activity activity, Fragment fragment, int j, android.content.DialogInterface.OnCancelListener oncancellistener)
    {
        android.app.AlertDialog.Builder builder1 = null;
        if (i == 0)
        {
            return null;
        }
        int k = i;
        if (zzml.zzan(activity))
        {
            k = i;
            if (i == 2)
            {
                k = 42;
            }
        }
        android.app.AlertDialog.Builder builder = builder1;
        if (zzmx.zzqx())
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
        builder1.setMessage(zzg.zzc(activity, k, zzaf(activity)));
        if (oncancellistener != null)
        {
            builder1.setOnCancelListener(oncancellistener);
        }
        oncancellistener = GoogleApiAvailability.getInstance().zza(activity, k, "d");
        if (fragment == null)
        {
            fragment = new zzh(activity, oncancellistener, j);
        } else
        {
            fragment = new zzh(fragment, oncancellistener, j);
        }
        oncancellistener = zzg.zzh(activity, k);
        if (oncancellistener != null)
        {
            builder1.setPositiveButton(oncancellistener, fragment);
        }
        activity = zzg.zzg(activity, k);
        if (activity != null)
        {
            builder1.setTitle(activity);
        }
        return builder1.create();
    }

    private static void zza(int i, Context context)
    {
        zza(i, context, null);
    }

    private static void zza(int i, Context context, String s)
    {
        Object obj1 = context.getResources();
        Object obj2 = zzaf(context);
        String s1 = zzg.zzi(context, i);
        Object obj = s1;
        if (s1 == null)
        {
            obj = ((Resources) (obj1)).getString(com.google.android.gms.R.string.common_google_play_services_notification_ticker);
        }
        s1 = zzg.zzd(context, i, ((String) (obj2)));
        obj2 = GoogleApiAvailability.getInstance().zza(context, i, 0, "n");
        if (zzml.zzan(context))
        {
            zzx.zzZ(zzmx.zzqy());
            obj = (new android.app.Notification.Builder(context)).setSmallIcon(com.google.android.gms.R.drawable.common_ic_googleplayservices).setPriority(2).setAutoCancel(true).setStyle((new android.app.Notification.BigTextStyle()).bigText((new StringBuilder()).append(((String) (obj))).append(" ").append(s1).toString())).addAction(com.google.android.gms.R.drawable.common_full_open_on_phone, ((Resources) (obj1)).getString(com.google.android.gms.R.string.common_open_on_phone), ((PendingIntent) (obj2))).build();
        } else
        {
            obj1 = ((Resources) (obj1)).getString(com.google.android.gms.R.string.common_google_play_services_notification_ticker);
            if (zzmx.zzqu())
            {
                obj = (new android.app.Notification.Builder(context)).setSmallIcon(0x108008a).setContentTitle(((CharSequence) (obj))).setContentText(s1).setContentIntent(((PendingIntent) (obj2))).setTicker(((CharSequence) (obj1))).setAutoCancel(true);
                if (zzmx.zzqC())
                {
                    ((android.app.Notification.Builder) (obj)).setLocalOnly(true);
                }
                if (zzmx.zzqy())
                {
                    ((android.app.Notification.Builder) (obj)).setStyle((new android.app.Notification.BigTextStyle()).bigText(s1));
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
                obj = (new android.support.v4.app.NotificationCompat.Builder(context)).setSmallIcon(0x108008a).setTicker(((CharSequence) (obj1))).setWhen(System.currentTimeMillis()).setAutoCancel(true).setContentIntent(((PendingIntent) (obj2))).setContentTitle(((CharSequence) (obj))).setContentText(s1).build();
            }
        }
        if (zzbk(i))
        {
            zzaaq.set(false);
            i = 10436;
        } else
        {
            i = 39789;
        }
        context = (NotificationManager)context.getSystemService("notification");
        if (s != null)
        {
            context.notify(s, i, ((Notification) (obj)));
            return;
        } else
        {
            context.notify(i, ((Notification) (obj)));
            return;
        }
    }

    public static void zza(Activity activity, android.content.DialogInterface.OnCancelListener oncancellistener, String s, Dialog dialog)
    {
        boolean flag;
        try
        {
            flag = activity instanceof FragmentActivity;
        }
        catch (NoClassDefFoundError noclassdeffounderror)
        {
            flag = false;
        }
        if (flag)
        {
            activity = ((FragmentActivity)activity).getSupportFragmentManager();
            SupportErrorDialogFragment.newInstance(dialog, oncancellistener).show(activity, s);
            return;
        }
        if (zzmx.zzqu())
        {
            activity = activity.getFragmentManager();
            ErrorDialogFragment.newInstance(dialog, oncancellistener).show(activity, s);
            return;
        } else
        {
            throw new RuntimeException("This Activity does not support Fragments.");
        }
    }

    public static void zzaa(Context context)
        throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException
    {
        int i = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context);
        if (i != 0)
        {
            context = GoogleApiAvailability.getInstance().zza(context, i, "e");
            Log.e("GooglePlayServicesUtil", (new StringBuilder()).append("GooglePlayServices not available due to error ").append(i).toString());
            if (context == null)
            {
                throw new GooglePlayServicesNotAvailableException(i);
            } else
            {
                throw new GooglePlayServicesRepairableException(i, "Google Play Services not available", context);
            }
        } else
        {
            return;
        }
    }

    public static void zzac(Context context)
    {
        if (zzaaq.getAndSet(true))
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
        if (!zzaar.get()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj = zzpy;
        obj;
        JVM INSTR monitorenter ;
        if (zzaao != null) goto _L4; else goto _L3
_L3:
        zzaao = context.getPackageName();
        context = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
        if (context == null) goto _L6; else goto _L5
_L5:
        zzaap = Integer.valueOf(context.getInt("com.google.android.gms.version"));
_L7:
        context = zzaap;
        obj;
        JVM INSTR monitorexit ;
        if (context == null)
        {
            throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
        }
        continue; /* Loop/switch isn't completed */
_L6:
        zzaap = null;
          goto _L7
        context;
        Log.wtf("GooglePlayServicesUtil", "This should never happen.", context);
          goto _L7
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
_L4:
        if (zzaao.equals(context.getPackageName())) goto _L7; else goto _L8
_L8:
        throw new IllegalArgumentException((new StringBuilder()).append("isGooglePlayServicesAvailable should only be called with Context from your application's package. A previous call used package '").append(zzaao).append("' and this call used package '").append(context.getPackageName()).append("'.").toString());
        if (context.intValue() == GOOGLE_PLAY_SERVICES_VERSION_CODE) goto _L1; else goto _L9
_L9:
        throw new IllegalStateException((new StringBuilder()).append("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected ").append(GOOGLE_PLAY_SERVICES_VERSION_CODE).append(" but").append(" found ").append(context).append(".  You must have the").append(" following declaration within the <application> element: ").append("    <meta-data android:name=\"").append("com.google.android.gms.version").append("\" android:value=\"@integer/google_play_services_version\" />").toString());
    }

    private static void zzae(Context context)
    {
    /* block-local class not found */
    class zza {}

        context = new zza(context);
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
        return zzmx.zzqD() && context.hasSystemFeature("com.google.sidewinder");
    }

    public static boolean zzah(Context context)
    {
        if (zzmx.zzqA())
        {
            context = ((UserManager)context.getSystemService("user")).getApplicationRestrictions(context.getPackageName());
            if (context != null && "true".equals(context.getString("restricted_profile")))
            {
                return true;
            }
        }
        return false;
    }

    static void zzb(int i, Context context)
    {
        zza(i, context);
    }

    public static boolean zzb(Context context, int i, String s)
    {
label0:
        {
            {
                boolean flag1 = false;
                if (!zzmx.zzqB())
                {
                    break label0;
                }
                context = (AppOpsManager)context.getSystemService("appops");
                boolean flag;
                try
                {
                    context.checkPackage(i, s);
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
        context = context.getPackageManager().getPackagesForUid(i);
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
        i = 0;
        do
        {
            flag = flag1;
            if (i >= context.length)
            {
                continue;
            }
            if (s.equals(context[i]))
            {
                return true;
            }
            i++;
        } while (true);
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_28;
_L1:
    }

    public static boolean zzb(PackageManager packagemanager)
    {
        boolean flag = true;
        Object obj = zzpy;
        obj;
        JVM INSTR monitorenter ;
        int i = zzaan;
        if (i != -1) goto _L2; else goto _L1
_L1:
        packagemanager = packagemanager.getPackageInfo("com.google.android.gms", 64);
        if (com.google.android.gms.common.zzd.zznu().zza(packagemanager, new zzc.zza[] {
            zzc.zzaad[1]
        }) == null) goto _L4; else goto _L3
_L3:
        zzaan = 1;
_L2:
        if (zzaan == 0)
        {
            flag = false;
        }
        obj;
        JVM INSTR monitorexit ;
        return flag;
_L4:
        zzaan = 0;
          goto _L2
        packagemanager;
        zzaan = 0;
          goto _L2
        packagemanager;
        obj;
        JVM INSTR monitorexit ;
        throw packagemanager;
    }

    public static boolean zzb(PackageManager packagemanager, String s)
    {
        return com.google.android.gms.common.zzd.zznu().zzb(packagemanager, s);
    }

    public static Intent zzbj(int i)
    {
        return GoogleApiAvailability.getInstance().zza(null, i, null);
    }

    private static boolean zzbk(int i)
    {
        switch (i)
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
        return zzb(packagemanager) || !zznt();
    }

    public static boolean zzd(Context context, int i)
    {
        if (i == 18)
        {
            return true;
        }
        if (i == 1)
        {
            return zzj(context, "com.google.android.gms");
        } else
        {
            return false;
        }
    }

    public static boolean zze(Context context, int i)
    {
        return zzb(context, i, "com.google.android.gms") && zzb(context.getPackageManager(), "com.google.android.gms");
    }

    public static boolean zzf(Context context, int i)
    {
        if (i == 9)
        {
            return zzj(context, "com.android.vending");
        } else
        {
            return false;
        }
    }

    static boolean zzj(Context context, String s)
    {
label0:
        {
            if (!zzmx.zzqD())
            {
                break label0;
            }
            Iterator iterator = context.getPackageManager().getPackageInstaller().getAllSessions().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
            } while (!s.equals(((android.content.pm.PackageInstaller.SessionInfo)iterator.next()).getAppPackageName()));
            return true;
        }
        if (zzah(context))
        {
            return false;
        }
        context = context.getPackageManager();
        boolean flag;
        try
        {
            flag = context.getApplicationInfo(s, 8192).enabled;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return false;
        }
        return flag;
    }

    private static int zzns()
    {
        return 0x7bd338;
    }

    public static boolean zznt()
    {
        if (zzaal)
        {
            return zzaam;
        } else
        {
            return "user".equals(Build.TYPE);
        }
    }

}
