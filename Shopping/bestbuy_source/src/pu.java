// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Base64;
import android.util.Log;
import android.util.TypedValue;
import com.google.android.gms.common.ErrorDialogFragment;
import com.google.android.gms.common.SupportErrorDialogFragment;
import java.util.Arrays;
import java.util.Set;

public final class pu
{

    public static boolean a = false;
    public static boolean b = false;
    private static int c = -1;
    private static final Object d = new Object();

    public static int a(Context context)
    {
        Object obj;
        Object obj1;
label0:
        {
            obj = context.getPackageManager();
            if (!acv.a)
            {
                try
                {
                    context.getResources().getString(com.google.android.gms.R.string.common_google_play_services_unknown_issue);
                }
                // Misplaced declaration of an exception variable
                catch (Object obj1)
                {
                    Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
                }
            }
            if (!acv.a)
            {
                e(context);
            }
            try
            {
                obj1 = ((PackageManager) (obj)).getPackageInfo("com.google.android.gms", 64);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
                return 1;
            }
            if (aee.c(((PackageInfo) (obj1)).versionCode))
            {
                int i;
                if (a())
                {
                    i = 0;
                } else
                {
                    i = 1;
                }
                if (a(((PackageInfo) (obj1)), new byte[][] {
    rg.a[i], rg.g[i], rg.f[i]
}) == null)
                {
                    Log.w("GooglePlayServicesUtil", "Google Play Services signature invalid on Glass.");
                    return 9;
                }
                context = context.getPackageName();
                try
                {
                    PackageInfo packageinfo = ((PackageManager) (obj)).getPackageInfo(context, 64);
                    if (a(((PackageManager) (obj)), packageinfo))
                    {
                        break label0;
                    }
                    Log.w("GooglePlayServicesUtil", (new StringBuilder()).append("Calling package ").append(packageinfo.packageName).append(" signature invalid on Glass.").toString());
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    Log.w("GooglePlayServicesUtil", (new StringBuilder()).append("Could not get info for calling package: ").append(context).toString());
                    return 9;
                }
                return 9;
            }
            if (aee.a(context))
            {
                if (a(((PackageInfo) (obj1)), rg.a) == null)
                {
                    Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                    return 9;
                }
            } else
            {
                try
                {
                    context = ((PackageManager) (obj)).getPackageInfo("com.android.vending", 64);
                }
                // Misplaced declaration of an exception variable
                catch (Context context)
                {
                    Log.w("GooglePlayServicesUtil", "Google Play Store is missing.");
                    return 9;
                }
                context = a(((PackageInfo) (context)), rg.a);
                if (context == null)
                {
                    Log.w("GooglePlayServicesUtil", "Google Play Store signature invalid.");
                    return 9;
                }
                if (a(((PackageInfo) (obj1)), new byte[][] {
    context
}) == null)
                {
                    Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                    return 9;
                }
            }
        }
        int j = aee.a(0x648278);
        if (aee.a(((PackageInfo) (obj1)).versionCode) < j)
        {
            Log.w("GooglePlayServicesUtil", (new StringBuilder()).append("Google Play services out of date.  Requires 6587000 but found ").append(((PackageInfo) (obj1)).versionCode).toString());
            return 2;
        }
        try
        {
            context = ((PackageManager) (obj)).getApplicationInfo("com.google.android.gms", 0);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.");
            context.printStackTrace();
            return 1;
        }
        return ((ApplicationInfo) (context)).enabled ? 0 : 3;
    }

    public static String a(int i)
    {
        switch (i)
        {
        default:
            return "UNKNOWN_ERROR_CODE";

        case 0: // '\0'
            return "SUCCESS";

        case 1: // '\001'
            return "SERVICE_MISSING";

        case 2: // '\002'
            return "SERVICE_VERSION_UPDATE_REQUIRED";

        case 3: // '\003'
            return "SERVICE_DISABLED";

        case 4: // '\004'
            return "SIGN_IN_REQUIRED";

        case 5: // '\005'
            return "INVALID_ACCOUNT";

        case 6: // '\006'
            return "RESOLUTION_REQUIRED";

        case 7: // '\007'
            return "NETWORK_ERROR";

        case 8: // '\b'
            return "INTERNAL_ERROR";

        case 9: // '\t'
            return "SERVICE_INVALID";

        case 10: // '\n'
            return "DEVELOPER_ERROR";

        case 11: // '\013'
            return "LICENSE_CHECK_FAILED";
        }
    }

    public static String a(Context context, int i)
    {
        Resources resources = context.getResources();
        switch (i)
        {
        default:
            return resources.getString(com.google.android.gms.R.string.common_google_play_services_unknown_issue);

        case 1: // '\001'
            if (a(context.getResources()))
            {
                return resources.getString(com.google.android.gms.R.string.common_google_play_services_install_text_tablet);
            } else
            {
                return resources.getString(com.google.android.gms.R.string.common_google_play_services_install_text_phone);
            }

        case 3: // '\003'
            return resources.getString(com.google.android.gms.R.string.common_google_play_services_enable_text);

        case 2: // '\002'
            return resources.getString(com.google.android.gms.R.string.common_google_play_services_update_text);

        case 42: // '*'
            return resources.getString(com.google.android.gms.R.string.common_android_wear_update_text);

        case 9: // '\t'
            return resources.getString(com.google.android.gms.R.string.common_google_play_services_unsupported_text);

        case 7: // '\007'
            return resources.getString(com.google.android.gms.R.string.common_google_play_services_network_error_text);

        case 5: // '\005'
            return resources.getString(com.google.android.gms.R.string.common_google_play_services_invalid_account_text);
        }
    }

    public static boolean a()
    {
        if (a)
        {
            return b;
        } else
        {
            return "user".equals(Build.TYPE);
        }
    }

    public static boolean a(int i, Activity activity, int j)
    {
        return a(i, activity, j, null);
    }

    public static boolean a(int i, Activity activity, int j, android.content.DialogInterface.OnCancelListener oncancellistener)
    {
        return a(i, activity, null, j, oncancellistener);
    }

    public static boolean a(int i, Activity activity, Fragment fragment, int j, android.content.DialogInterface.OnCancelListener oncancellistener)
    {
        boolean flag;
        flag = false;
        fragment = b(i, activity, fragment, j, oncancellistener);
        if (fragment == null)
        {
            return false;
        }
        boolean flag1 = activity instanceof FragmentActivity;
        flag = flag1;
_L2:
        if (flag)
        {
            activity = ((FragmentActivity)activity).getSupportFragmentManager();
            SupportErrorDialogFragment.a(fragment, oncancellistener).show(activity, "GooglePlayServicesErrorDialog");
        } else
        if (aej.a())
        {
            activity = activity.getFragmentManager();
            ErrorDialogFragment.a(fragment, oncancellistener).show(activity, "GooglePlayServicesErrorDialog");
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

    public static boolean a(PackageManager packagemanager)
    {
        Object obj = d;
        obj;
        JVM INSTR monitorenter ;
        int i = c;
        if (i != -1) goto _L2; else goto _L1
_L1:
        if (a(packagemanager.getPackageInfo("com.google.android.gms", 64), new byte[][] {
            rg.E[1]
        }) == null) goto _L4; else goto _L3
_L3:
        c = 1;
_L2:
        obj;
        JVM INSTR monitorexit ;
        return c != 0;
_L4:
        c = 0;
          goto _L2
        packagemanager;
        c = 0;
          goto _L2
        packagemanager;
        obj;
        JVM INSTR monitorexit ;
        throw packagemanager;
    }

    public static boolean a(PackageManager packagemanager, PackageInfo packageinfo)
    {
        boolean flag = true;
        boolean flag2 = false;
        boolean flag1 = false;
        if (packageinfo != null)
        {
            if (b(packagemanager))
            {
                if (a(packageinfo, true) == null)
                {
                    flag = false;
                }
                return flag;
            }
            flag = flag2;
            if (a(packageinfo, false) != null)
            {
                flag = true;
            }
            flag1 = flag;
            if (!flag)
            {
                flag1 = flag;
                if (a(packageinfo, true) != null)
                {
                    Log.w("GooglePlayServicesUtil", "Test-keys aren't accepted on this build.");
                    return flag;
                }
            }
        }
        return flag1;
    }

    public static boolean a(Resources resources)
    {
        if (resources != null)
        {
            boolean flag;
            if ((resources.getConfiguration().screenLayout & 0xf) > 3)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (aej.a() && flag || b(resources))
            {
                return true;
            }
        }
        return false;
    }

    private static byte[] a(PackageInfo packageinfo, boolean flag)
    {
        if (packageinfo.signatures.length != 1)
        {
            Log.w("GooglePlayServicesUtil", "Package has more than one signature.");
            return null;
        }
        byte abyte0[] = packageinfo.signatures[0].toByteArray();
        if (flag)
        {
            packageinfo = rg.a();
        } else
        {
            packageinfo = rg.b();
        }
        if (packageinfo.contains(abyte0))
        {
            return abyte0;
        }
        if (Log.isLoggable("GooglePlayServicesUtil", 2))
        {
            Log.v("GooglePlayServicesUtil", (new StringBuilder()).append("Signature not valid.  Found: \n").append(Base64.encodeToString(abyte0, 0)).toString());
        }
        return null;
    }

    private static transient byte[] a(PackageInfo packageinfo, byte abyte0[][])
    {
        if (packageinfo.signatures.length != 1)
        {
            Log.w("GooglePlayServicesUtil", "Package has more than one signature.");
            return null;
        }
        packageinfo = packageinfo.signatures[0].toByteArray();
        for (int i = 0; i < abyte0.length; i++)
        {
            byte abyte1[] = abyte0[i];
            if (Arrays.equals(abyte1, packageinfo))
            {
                return abyte1;
            }
        }

        if (Log.isLoggable("GooglePlayServicesUtil", 2))
        {
            Log.v("GooglePlayServicesUtil", (new StringBuilder()).append("Signature not valid.  Found: \n").append(Base64.encodeToString(packageinfo, 0)).toString());
        }
        return null;
    }

    private static Dialog b(int i, Activity activity, Fragment fragment, int j, android.content.DialogInterface.OnCancelListener oncancellistener)
    {
        int k;
        k = i;
        if (aee.a(activity))
        {
            k = i;
            if (i == 2)
            {
                k = 42;
            }
        }
        if (!aej.c()) goto _L2; else goto _L1
_L1:
        Object obj;
        obj = new TypedValue();
        activity.getTheme().resolveAttribute(0x1010309, ((TypedValue) (obj)), true);
        if (!"Theme.Dialog.Alert".equals(activity.getResources().getResourceEntryName(((TypedValue) (obj)).resourceId))) goto _L2; else goto _L3
_L3:
        obj = new android.app.AlertDialog.Builder(activity, 5);
_L5:
        android.app.AlertDialog.Builder builder = ((android.app.AlertDialog.Builder) (obj));
        if (obj == null)
        {
            builder = new android.app.AlertDialog.Builder(activity);
        }
        builder.setMessage(a(activity, k));
        if (oncancellistener != null)
        {
            builder.setOnCancelListener(oncancellistener);
        }
        oncancellistener = b(k);
        if (fragment == null)
        {
            fragment = new acw(activity, oncancellistener, j);
        } else
        {
            fragment = new acw(fragment, oncancellistener, j);
        }
        activity = b(((Context) (activity)), k);
        if (activity != null)
        {
            builder.setPositiveButton(activity, fragment);
        }
        switch (k)
        {
        default:
            Log.e("GooglePlayServicesUtil", (new StringBuilder()).append("Unexpected error code ").append(k).toString());
            return builder.create();

        case 0: // '\0'
            return null;

        case 4: // '\004'
        case 6: // '\006'
            return builder.create();

        case 1: // '\001'
            return builder.setTitle(com.google.android.gms.R.string.common_google_play_services_install_title).create();

        case 3: // '\003'
            return builder.setTitle(com.google.android.gms.R.string.common_google_play_services_enable_title).create();

        case 2: // '\002'
            return builder.setTitle(com.google.android.gms.R.string.common_google_play_services_update_title).create();

        case 42: // '*'
            return builder.setTitle(com.google.android.gms.R.string.common_android_wear_update_title).create();

        case 9: // '\t'
            Log.e("GooglePlayServicesUtil", "Google Play services is invalid. Cannot recover.");
            return builder.setTitle(com.google.android.gms.R.string.common_google_play_services_unsupported_title).create();

        case 7: // '\007'
            Log.e("GooglePlayServicesUtil", "Network error occurred. Please retry request later.");
            return builder.setTitle(com.google.android.gms.R.string.common_google_play_services_network_error_title).create();

        case 8: // '\b'
            Log.e("GooglePlayServicesUtil", "Internal error occurred. Please see logs for detailed information");
            return builder.create();

        case 10: // '\n'
            Log.e("GooglePlayServicesUtil", "Developer error occurred. Please see logs for detailed information");
            return builder.create();

        case 5: // '\005'
            Log.e("GooglePlayServicesUtil", "An invalid account was specified when connecting. Please provide a valid account.");
            return builder.setTitle(com.google.android.gms.R.string.common_google_play_services_invalid_account_title).create();

        case 11: // '\013'
            Log.e("GooglePlayServicesUtil", "The application is not licensed to the user.");
            break;
        }
        return builder.create();
_L2:
        obj = null;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public static Intent b(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 1: // '\001'
        case 2: // '\002'
            return adk.b("com.google.android.gms");

        case 42: // '*'
            return adk.a();

        case 3: // '\003'
            return adk.a("com.google.android.gms");
        }
    }

    public static String b(Context context, int i)
    {
        context = context.getResources();
        switch (i)
        {
        default:
            return context.getString(0x104000a);

        case 1: // '\001'
            return context.getString(com.google.android.gms.R.string.common_google_play_services_install_button);

        case 3: // '\003'
            return context.getString(com.google.android.gms.R.string.common_google_play_services_enable_button);

        case 2: // '\002'
        case 42: // '*'
            return context.getString(com.google.android.gms.R.string.common_google_play_services_update_button);
        }
    }

    public static void b(Context context)
    {
        int i = a(context);
        if (i != 0)
        {
            context = b(i);
            Log.e("GooglePlayServicesUtil", (new StringBuilder()).append("GooglePlayServices not available due to error ").append(i).toString());
            if (context == null)
            {
                throw new ps(i);
            } else
            {
                throw new pt(i, "Google Play Services not available", context);
            }
        } else
        {
            return;
        }
    }

    public static boolean b(PackageManager packagemanager)
    {
        return a(packagemanager) || !a();
    }

    private static boolean b(Resources resources)
    {
        boolean flag1 = false;
        resources = resources.getConfiguration();
        boolean flag = flag1;
        if (aej.b())
        {
            flag = flag1;
            if ((((Configuration) (resources)).screenLayout & 0xf) <= 3)
            {
                flag = flag1;
                if (((Configuration) (resources)).smallestScreenWidthDp >= 600)
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    public static Resources c(Context context)
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

    public static boolean c(int i)
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

    public static boolean c(Context context, int i)
    {
        if (i != 1)
        {
            break MISSING_BLOCK_LABEL_30;
        }
        context = context.getPackageManager();
        boolean flag = context.getApplicationInfo("com.google.android.gms", 8192).enabled;
        if (flag)
        {
            return true;
        }
        break MISSING_BLOCK_LABEL_30;
        context;
        return false;
    }

    public static Context d(Context context)
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

    private static void e(Context context)
    {
        Object obj = null;
        try
        {
            context = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.wtf("GooglePlayServicesUtil", "This should never happen.", context);
            context = obj;
        }
        context = ((ApplicationInfo) (context)).metaData;
        if (context != null)
        {
            int i = context.getInt("com.google.android.gms.version");
            if (i == 0x648278)
            {
                return;
            } else
            {
                throw new IllegalStateException((new StringBuilder()).append("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected 6587000 but found ").append(i).append(".  You must have the").append(" following declaration within the <application> element: ").append("    <meta-data android:name=\"").append("com.google.android.gms.version").append("\" android:value=\"@integer/google_play_services_version\" />").toString());
            }
        } else
        {
            throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
        }
    }

}
