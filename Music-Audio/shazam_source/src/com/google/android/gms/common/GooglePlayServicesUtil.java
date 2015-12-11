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
import android.support.v4.app.i;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.internal.j;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.d.ig;
import com.google.android.gms.d.ik;
import com.google.android.gms.d.io;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.google.android.gms.common:
//            ConnectionResult, j, e, a, 
//            c, d, i

public final class GooglePlayServicesUtil
{
    private static final class a extends Handler
    {

        private final Context a;

        public final void handleMessage(Message message)
        {
            message.what;
            JVM INSTR tableswitch 1 1: default 24
        //                       1 42;
               goto _L1 _L2
_L1:
            (new StringBuilder("Don't know how to handle this message: ")).append(message.what);
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
        byte byte0 = 9;
        if (!f.a) goto _L2; else goto _L1
_L1:
        int k = 0;
_L6:
        return k;
_L2:
        Object obj;
        PackageManager packagemanager;
        packagemanager = context.getPackageManager();
        try
        {
            context.getResources().getString(com.google.android.gms.a.b.common_google_play_services_unknown_issue);
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
            return 1;
        }
        j.a();
        if (!ig.b(((PackageInfo) (obj)).versionCode) && !ig.a(context)) goto _L4; else goto _L3
_L3:
        k = byte0;
        if (j.a(((PackageInfo) (obj)), i.aw.a) == null) goto _L6; else goto _L5
_L5:
        k = ig.a(GOOGLE_PLAY_SERVICES_VERSION_CODE);
        if (ig.a(((PackageInfo) (obj)).versionCode) < k)
        {
            (new StringBuilder("Google Play services out of date.  Requires ")).append(GOOGLE_PLAY_SERVICES_VERSION_CODE).append(" but found ").append(((PackageInfo) (obj)).versionCode);
            return 2;
        }
        break MISSING_BLOCK_LABEL_229;
_L4:
        i.a a1 = j.a(packagemanager.getPackageInfo("com.android.vending", 64), i.aw.a);
        k = byte0;
        if (a1 == null) goto _L6; else goto _L7
_L7:
        a1 = j.a(((PackageInfo) (obj)), new i.a[] {
            a1
        });
        if (a1 == null)
        {
            return 9;
        }
          goto _L5
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        k = byte0;
        if (!zzh(context, "com.android.vending")) goto _L6; else goto _L8
_L8:
        if (j.a(((PackageInfo) (obj)), i.aw.a) == null)
        {
            return 9;
        }
          goto _L5
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
        fragment = zza(k, activity, fragment, l, oncancellistener);
        if (fragment == null)
        {
            return false;
        }
        if (activity instanceof i)
        {
            activity = ((i)activity).getSupportFragmentManager();
            e.a(fragment, oncancellistener).a(activity, "GooglePlayServicesErrorDialog");
        } else
        if (io.a(11))
        {
            activity = activity.getFragmentManager();
            com.google.android.gms.common.a.a(fragment, oncancellistener).show(activity, "GooglePlayServicesErrorDialog");
        } else
        {
            throw new RuntimeException("This Activity does not support Fragments.");
        }
        return true;
    }

    public static void showErrorNotification(int k, Context context)
    {
        int l = k;
        if (ig.a(context))
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
        Object obj1;
        int i1;
        obj1 = null;
        if (k == 0)
        {
            return null;
        }
        i1 = k;
        if (ig.a(activity))
        {
            i1 = k;
            if (k == 2)
            {
                i1 = 42;
            }
        }
        if (!io.a(14)) goto _L2; else goto _L1
_L1:
        Object obj;
        obj = new TypedValue();
        activity.getTheme().resolveAttribute(0x1010309, ((TypedValue) (obj)), true);
        if (!"Theme.Dialog.Alert".equals(activity.getResources().getResourceEntryName(((TypedValue) (obj)).resourceId))) goto _L2; else goto _L3
_L3:
        obj = new android.app.AlertDialog.Builder(activity, 5);
_L21:
        android.app.AlertDialog.Builder builder = ((android.app.AlertDialog.Builder) (obj));
        if (obj == null)
        {
            builder = new android.app.AlertDialog.Builder(activity);
        }
        builder.setMessage(com.google.android.gms.common.internal.i.a(activity, i1, zzaf(activity)));
        if (oncancellistener != null)
        {
            builder.setOnCancelListener(oncancellistener);
        }
        oncancellistener = zzbc(i1);
        if (fragment == null)
        {
            fragment = new j(activity, oncancellistener, l);
        } else
        {
            fragment = new j(fragment, oncancellistener, l);
        }
        oncancellistener = com.google.android.gms.common.internal.i.a(activity, i1);
        if (oncancellistener != null)
        {
            builder.setPositiveButton(oncancellistener, fragment);
        }
        fragment = activity.getResources();
        activity = obj1;
        i1;
        JVM INSTR lookupswitch 15: default 328
    //                   1: 388
    //                   2: 421
    //                   3: 399
    //                   4: 356
    //                   5: 517
    //                   6: 356
    //                   7: 464
    //                   8: 485
    //                   9: 443
    //                   10: 501
    //                   11: 538
    //                   16: 554
    //                   17: 570
    //                   18: 410
    //                   42: 432;
           goto _L4 _L5 _L6 _L7 _L8 _L9 _L8 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18
_L8:
        break; /* Loop/switch isn't completed */
_L4:
        Log.e("GoogleApiAvailability", (new StringBuilder("Unexpected error code ")).append(i1).toString());
        activity = obj1;
_L19:
        if (activity != null)
        {
            builder.setTitle(activity);
        }
        return builder.create();
_L5:
        activity = fragment.getString(com.google.android.gms.a.b.common_google_play_services_install_title);
        continue; /* Loop/switch isn't completed */
_L7:
        activity = fragment.getString(com.google.android.gms.a.b.common_google_play_services_enable_title);
        continue; /* Loop/switch isn't completed */
_L17:
        activity = fragment.getString(com.google.android.gms.a.b.common_google_play_services_updating_title);
        continue; /* Loop/switch isn't completed */
_L6:
        activity = fragment.getString(com.google.android.gms.a.b.common_google_play_services_update_title);
        continue; /* Loop/switch isn't completed */
_L18:
        activity = fragment.getString(com.google.android.gms.a.b.common_android_wear_update_title);
        continue; /* Loop/switch isn't completed */
_L12:
        Log.e("GoogleApiAvailability", "Google Play services is invalid. Cannot recover.");
        activity = fragment.getString(com.google.android.gms.a.b.common_google_play_services_unsupported_title);
        continue; /* Loop/switch isn't completed */
_L10:
        Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
        activity = fragment.getString(com.google.android.gms.a.b.common_google_play_services_network_error_title);
        continue; /* Loop/switch isn't completed */
_L11:
        Log.e("GoogleApiAvailability", "Internal error occurred. Please see logs for detailed information");
        activity = obj1;
        continue; /* Loop/switch isn't completed */
_L13:
        Log.e("GoogleApiAvailability", "Developer error occurred. Please see logs for detailed information");
        activity = obj1;
        continue; /* Loop/switch isn't completed */
_L9:
        Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
        activity = fragment.getString(com.google.android.gms.a.b.common_google_play_services_invalid_account_title);
        continue; /* Loop/switch isn't completed */
_L14:
        Log.e("GoogleApiAvailability", "The application is not licensed to the user.");
        activity = obj1;
        continue; /* Loop/switch isn't completed */
_L15:
        Log.e("GoogleApiAvailability", "One of the API components you attempted to connect to is not available.");
        activity = obj1;
        continue; /* Loop/switch isn't completed */
_L16:
        Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
        activity = fragment.getString(com.google.android.gms.a.b.common_google_play_services_sign_in_failed_title);
        if (true) goto _L19; else goto _L2
_L2:
        obj = null;
        if (true) goto _L21; else goto _L20
_L20:
    }

    private static void zza(int k, Context context)
    {
        zza(k, context, null);
    }

    private static void zza(int k, Context context, String s)
    {
        Object obj;
        Object obj1;
        Object obj2;
        Object obj3;
        Resources resources;
        obj1 = null;
        obj2 = context.getResources();
        obj3 = zzaf(context);
        resources = context.getResources();
        obj = obj1;
        k;
        JVM INSTR lookupswitch 15: default 156
    //                   1: 448
    //                   2: 484
    //                   3: 460
    //                   4: 183
    //                   5: 584
    //                   6: 183
    //                   7: 530
    //                   8: 552
    //                   9: 508
    //                   10: 568
    //                   11: 606
    //                   16: 622
    //                   17: 638
    //                   18: 472
    //                   42: 496;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L5 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15
_L5:
        break; /* Loop/switch isn't completed */
_L1:
        Log.e("GoogleApiAvailability", (new StringBuilder("Unexpected error code ")).append(k).toString());
        obj = obj1;
_L27:
        obj1 = obj;
        if (obj == null)
        {
            obj1 = ((Resources) (obj2)).getString(com.google.android.gms.a.b.common_google_play_services_notification_ticker);
        }
        obj = context.getResources();
        k;
        JVM INSTR lookupswitch 10: default 296
    //                   1: 660
    //                   2: 727
    //                   3: 767
    //                   5: 818
    //                   7: 807
    //                   9: 787
    //                   16: 829
    //                   17: 849
    //                   18: 707
    //                   42: 747;
           goto _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24 _L25 _L26
_L24:
        break MISSING_BLOCK_LABEL_849;
_L16:
        obj = ((Resources) (obj)).getString(com.google.android.gms.a.b.common_google_play_services_unknown_issue);
_L28:
        obj3 = getErrorPendingIntent(k, context, 0);
        if (ig.a(context))
        {
            w.a(io.a(16));
            obj = (new android.app.Notification.Builder(context)).setSmallIcon(com.google.android.gms.a.a.common_ic_googleplayservices).setPriority(2).setAutoCancel(true).setStyle((new android.app.Notification.BigTextStyle()).bigText((new StringBuilder()).append(((String) (obj1))).append(" ").append(((String) (obj))).toString())).addAction(com.google.android.gms.a.a.common_full_open_on_phone, ((Resources) (obj2)).getString(com.google.android.gms.a.b.common_open_on_phone), ((PendingIntent) (obj3))).build();
        } else
        {
            obj2 = ((Resources) (obj2)).getString(com.google.android.gms.a.b.common_google_play_services_notification_ticker);
            if (io.a(11))
            {
                obj1 = (new android.app.Notification.Builder(context)).setSmallIcon(0x108008a).setContentTitle(((CharSequence) (obj1))).setContentText(((CharSequence) (obj))).setContentIntent(((PendingIntent) (obj3))).setTicker(((CharSequence) (obj2))).setAutoCancel(true);
                if (io.a(20))
                {
                    ((android.app.Notification.Builder) (obj1)).setLocalOnly(true);
                }
                if (io.a(16))
                {
                    ((android.app.Notification.Builder) (obj1)).setStyle((new android.app.Notification.BigTextStyle()).bigText(((CharSequence) (obj))));
                    obj = ((android.app.Notification.Builder) (obj1)).build();
                } else
                {
                    obj = ((android.app.Notification.Builder) (obj1)).getNotification();
                }
                if (android.os.Build.VERSION.SDK_INT == 19)
                {
                    ((Notification) (obj)).extras.putBoolean("android.support.localOnly", true);
                }
            } else
            {
                obj2 = new Notification(0x108008a, ((CharSequence) (obj2)), System.currentTimeMillis());
                obj2.flags = ((Notification) (obj2)).flags | 0x10;
                ((Notification) (obj2)).setLatestEventInfo(context, ((CharSequence) (obj1)), ((CharSequence) (obj)), ((PendingIntent) (obj3)));
                obj = obj2;
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
_L2:
        obj = resources.getString(com.google.android.gms.a.b.common_google_play_services_install_title);
          goto _L27
_L4:
        obj = resources.getString(com.google.android.gms.a.b.common_google_play_services_enable_title);
          goto _L27
_L14:
        obj = resources.getString(com.google.android.gms.a.b.common_google_play_services_updating_title);
          goto _L27
_L3:
        obj = resources.getString(com.google.android.gms.a.b.common_google_play_services_update_title);
          goto _L27
_L15:
        obj = resources.getString(com.google.android.gms.a.b.common_android_wear_update_title);
          goto _L27
_L9:
        Log.e("GoogleApiAvailability", "Google Play services is invalid. Cannot recover.");
        obj = resources.getString(com.google.android.gms.a.b.common_google_play_services_unsupported_title);
          goto _L27
_L7:
        Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
        obj = resources.getString(com.google.android.gms.a.b.common_google_play_services_network_error_title);
          goto _L27
_L8:
        Log.e("GoogleApiAvailability", "Internal error occurred. Please see logs for detailed information");
        obj = obj1;
          goto _L27
_L10:
        Log.e("GoogleApiAvailability", "Developer error occurred. Please see logs for detailed information");
        obj = obj1;
          goto _L27
_L6:
        Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
        obj = resources.getString(com.google.android.gms.a.b.common_google_play_services_invalid_account_title);
          goto _L27
_L11:
        Log.e("GoogleApiAvailability", "The application is not licensed to the user.");
        obj = obj1;
          goto _L27
_L12:
        Log.e("GoogleApiAvailability", "One of the API components you attempted to connect to is not available.");
        obj = obj1;
          goto _L27
_L13:
        Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
        obj = resources.getString(com.google.android.gms.a.b.common_google_play_services_sign_in_failed_title);
          goto _L27
_L17:
        if (ik.a(((Resources) (obj))))
        {
            obj = ((Resources) (obj)).getString(com.google.android.gms.a.b.common_google_play_services_install_text_tablet, new Object[] {
                obj3
            });
        } else
        {
            obj = ((Resources) (obj)).getString(com.google.android.gms.a.b.common_google_play_services_install_text_phone, new Object[] {
                obj3
            });
        }
          goto _L28
_L25:
        obj = ((Resources) (obj)).getString(com.google.android.gms.a.b.common_google_play_services_updating_text, new Object[] {
            obj3
        });
          goto _L28
_L18:
        obj = ((Resources) (obj)).getString(com.google.android.gms.a.b.common_google_play_services_update_text, new Object[] {
            obj3
        });
          goto _L28
_L26:
        obj = ((Resources) (obj)).getString(com.google.android.gms.a.b.common_android_wear_notification_needs_update_text, new Object[] {
            obj3
        });
          goto _L28
_L19:
        obj = ((Resources) (obj)).getString(com.google.android.gms.a.b.common_google_play_services_enable_text, new Object[] {
            obj3
        });
          goto _L28
_L22:
        obj = ((Resources) (obj)).getString(com.google.android.gms.a.b.common_google_play_services_unsupported_text, new Object[] {
            obj3
        });
          goto _L28
_L21:
        obj = ((Resources) (obj)).getString(com.google.android.gms.a.b.common_google_play_services_network_error_text);
          goto _L28
_L20:
        obj = ((Resources) (obj)).getString(com.google.android.gms.a.b.common_google_play_services_invalid_account_text);
          goto _L28
_L23:
        obj = ((Resources) (obj)).getString(com.google.android.gms.a.b.common_google_play_services_api_unavailable_text, new Object[] {
            obj3
        });
          goto _L28
        obj = ((Resources) (obj)).getString(com.google.android.gms.a.b.common_google_play_services_sign_in_failed_text);
          goto _L28
    }

    public static boolean zza(Context context, int k, String s)
    {
label0:
        {
            {
                boolean flag1 = false;
                if (!io.a(19))
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
        break MISSING_BLOCK_LABEL_30;
_L1:
    }

    public static void zzaa(Context context)
    {
        int k = isGooglePlayServicesAvailable(context);
        if (k != 0)
        {
            context = zzbc(k);
            Log.e("GooglePlayServicesUtil", (new StringBuilder("GooglePlayServices not available due to error ")).append(k).toString());
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
        break MISSING_BLOCK_LABEL_161;
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
        throw new IllegalArgumentException((new StringBuilder("isGooglePlayServicesAvailable should only be called with Context from your application's package. A previous call used package '")).append(zzYx).append("' and this call used package '").append(context.getPackageName()).append("'.").toString());
        if (context.intValue() != GOOGLE_PLAY_SERVICES_VERSION_CODE)
        {
            throw new IllegalStateException((new StringBuilder("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected ")).append(GOOGLE_PLAY_SERVICES_VERSION_CODE).append(" but found ").append(context).append(".  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />").toString());
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
        return io.a(21) && context.hasSystemFeature("com.google.sidewinder");
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
        j.a();
        if (j.a(packagemanager, new i.a[] {
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
        j.a();
        return j.a(packagemanager, s);
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
        if (io.a(21))
        {
            context = context.getPackageManager().getPackageInstaller().getAllSessions().iterator();
            do
            {
                if (!context.hasNext())
                {
                    break MISSING_BLOCK_LABEL_78;
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
        break MISSING_BLOCK_LABEL_78;
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
