// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
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
import android.util.Base64;
import android.util.Log;
import android.util.TypedValue;
import java.util.Arrays;
import java.util.Set;

public final class avw
{

    private static boolean a = false;
    private static boolean b = false;
    private static int c = -1;
    private static final Object d = new Object();

    public static int a(Context context)
    {
        PackageManager packagemanager;
        packagemanager = context.getPackageManager();
        Object obj;
        ApplicationInfo applicationinfo;
        int i;
        if (!axg.a)
        {
            try
            {
                context.getResources().getString(0x7f0b0071);
            }
            catch (Throwable throwable)
            {
                Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
            }
        }
        if (axg.a)
        {
            break MISSING_BLOCK_LABEL_145;
        }
        obj = null;
        applicationinfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        obj = applicationinfo;
_L1:
        obj = ((ApplicationInfo) (obj)).metaData;
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        if (obj != null)
        {
            i = ((Bundle) (obj)).getInt("com.google.android.gms.version");
            if (i != 0x5e3530)
            {
                throw new IllegalStateException((new StringBuilder("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected 6174000 but found ")).append(i).append(".  You must have the following declaration within the <application> element: ").append("    <meta-data android:name=\"com.google.android.gms.version").append("\" android:value=\"@integer/google_play_services_version\" />").toString());
            }
        } else
        {
            throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
        }
        break MISSING_BLOCK_LABEL_145;
        namenotfoundexception;
        Log.wtf("GooglePlayServicesUtil", "This should never happen.", namenotfoundexception);
          goto _L1
        Object obj1;
        int j;
        try
        {
            obj1 = packagemanager.getPackageInfo("com.google.android.gms", 64);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 1;
        }
        if (!aye.b(((PackageInfo) (obj1)).versionCode)) goto _L3; else goto _L2
_L2:
        if (a())
        {
            j = 0;
        } else
        {
            j = 1;
        }
        if (a(((PackageInfo) (obj1)), new byte[][] {
    axc.a[j], axc.c[j], axc.b[j]
}) == null)
        {
            Log.w("GooglePlayServicesUtil", "Google Play Services signature invalid on Glass.");
            return 9;
        }
        context = context.getPackageName();
        PackageInfo packageinfo;
        try
        {
            packageinfo = packagemanager.getPackageInfo(context, 64);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            Log.w("GooglePlayServicesUtil", (new StringBuilder("Could not get info for calling package: ")).append(context).toString());
            return 9;
        }
        if (packageinfo != null) goto _L5; else goto _L4
_L4:
        j = 0;
_L9:
        if (j != 0) goto _L7; else goto _L6
_L6:
        Log.w("GooglePlayServicesUtil", (new StringBuilder("Calling package ")).append(packageinfo.packageName).append(" signature invalid on Glass.").toString());
        return 9;
_L5:
        boolean flag;
        if (a(packagemanager) || !a())
        {
            j = 1;
        } else
        {
            j = 0;
        }
        if (j == 0)
        {
            break MISSING_BLOCK_LABEL_332;
        }
        if (a(packageinfo, true) != null)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        continue; /* Loop/switch isn't completed */
        if (a(packageinfo, false) != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        j = ((flag) ? 1 : 0);
        if (flag)
        {
            continue; /* Loop/switch isn't completed */
        }
        j = ((flag) ? 1 : 0);
        if (a(packageinfo, true) == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        Log.w("GooglePlayServicesUtil", "Test-keys aren't accepted on this build.");
        j = ((flag) ? 1 : 0);
        continue; /* Loop/switch isn't completed */
_L3:
        if (aye.a(context))
        {
            if (a(((PackageInfo) (obj1)), axc.a) == null)
            {
                Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                return 9;
            }
        } else
        {
            try
            {
                context = packagemanager.getPackageInfo("com.android.vending", 64);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                Log.w("GooglePlayServicesUtil", "Google Play Store is missing.");
                return 9;
            }
            context = a(((PackageInfo) (context)), axc.a);
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
_L7:
        j = aye.a(0x5e3530);
        if (aye.a(((PackageInfo) (obj1)).versionCode) < j)
        {
            Log.w("GooglePlayServicesUtil", (new StringBuilder("Google Play services out of date.  Requires 6174000 but found ")).append(((PackageInfo) (obj1)).versionCode).toString());
            return 2;
        }
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
        if (!((ApplicationInfo) (context)).enabled)
        {
            return 3;
        }
        return 0;
        if (true) goto _L9; else goto _L8
_L8:
    }

    private static boolean a()
    {
        return "user".equals(Build.TYPE);
    }

    public static boolean a(int i)
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

    public static boolean a(int i, Activity activity, j j, int k, android.content.DialogInterface.OnCancelListener oncancellistener)
    {
        int l;
        l = i;
        if (aye.a(activity))
        {
            l = i;
            if (i == 2)
            {
                l = 42;
            }
        }
        if (!a.a(14)) goto _L2; else goto _L1
_L1:
        Object obj;
        obj = new TypedValue();
        activity.getTheme().resolveAttribute(0x1010309, ((TypedValue) (obj)), true);
        if (!"Theme.Dialog.Alert".equals(activity.getResources().getResourceEntryName(((TypedValue) (obj)).resourceId))) goto _L2; else goto _L3
_L3:
        obj = new android.app.AlertDialog.Builder(activity, 5);
_L34:
        android.app.AlertDialog.Builder builder;
        builder = ((android.app.AlertDialog.Builder) (obj));
        if (obj == null)
        {
            builder = new android.app.AlertDialog.Builder(activity);
        }
        obj = activity.getResources();
        l;
        JVM INSTR lookupswitch 7: default 176
    //                   1: 452
    //                   2: 601
    //                   3: 588
    //                   5: 653
    //                   7: 640
    //                   9: 627
    //                   42: 614;
           goto _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L4:
        obj = ((Resources) (obj)).getString(0x7f0b0071);
_L29:
        builder.setMessage(((CharSequence) (obj)));
        if (oncancellistener != null)
        {
            builder.setOnCancelListener(oncancellistener);
        }
        obj = b(l);
        Object obj1;
        if (j == null)
        {
            obj = new axh(activity, ((Intent) (obj)), k);
        } else
        {
            obj = new axh(j, ((Intent) (obj)), k);
        }
        j = activity.getResources();
        l;
        JVM INSTR lookupswitch 4: default 280
    //                   1: 682
    //                   2: 704
    //                   3: 693
    //                   42: 704;
           goto _L12 _L13 _L14 _L15 _L14
_L12:
        j = j.getString(0x104000a);
_L31:
        if (j != null)
        {
            builder.setPositiveButton(j, ((android.content.DialogInterface.OnClickListener) (obj)));
        }
        l;
        JVM INSTR lookupswitch 13: default 416
    //                   0: 715
    //                   1: 729
    //                   2: 759
    //                   3: 744
    //                   4: 720
    //                   5: 873
    //                   6: 720
    //                   7: 813
    //                   8: 837
    //                   9: 789
    //                   10: 855
    //                   11: 897
    //                   42: 774;
           goto _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L21 _L23 _L24 _L25 _L26 _L27 _L28
_L27:
        break MISSING_BLOCK_LABEL_897;
_L16:
        Log.e("GooglePlayServicesUtil", (new StringBuilder("Unexpected error code ")).append(l).toString());
        j = builder.create();
_L32:
        if (j == null)
        {
            return false;
        }
        break MISSING_BLOCK_LABEL_915;
_L5:
        obj1 = activity.getResources();
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_570;
        }
        if ((((Resources) (obj1)).getConfiguration().screenLayout & 0xf) > 3)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (!a.a(11) || i == 0)
        {
            obj1 = ((Resources) (obj1)).getConfiguration();
            if (a.a(13))
            {
                if ((((Configuration) (obj1)).screenLayout & 0xf) <= 3 && ((Configuration) (obj1)).smallestScreenWidthDp >= 600)
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
            } else
            {
                i = 0;
            }
            if (i == 0)
            {
                break MISSING_BLOCK_LABEL_570;
            }
        }
        i = 1;
_L30:
        if (i != 0)
        {
            obj = ((Resources) (obj)).getString(0x7f0b0064);
        } else
        {
            obj = ((Resources) (obj)).getString(0x7f0b0063);
        }
          goto _L29
        i = 0;
          goto _L30
_L7:
        obj = ((Resources) (obj)).getString(0x7f0b0067);
          goto _L29
_L6:
        obj = ((Resources) (obj)).getString(0x7f0b006b);
          goto _L29
_L11:
        obj = ((Resources) (obj)).getString(0x7f0b006c);
          goto _L29
_L10:
        obj = ((Resources) (obj)).getString(0x7f0b0073);
          goto _L29
_L9:
        obj = ((Resources) (obj)).getString(0x7f0b006e);
          goto _L29
_L8:
        obj = ((Resources) (obj)).getString(0x7f0b0070);
          goto _L29
_L13:
        j = j.getString(0x7f0b0065);
          goto _L31
_L15:
        j = j.getString(0x7f0b0068);
          goto _L31
_L14:
        j = j.getString(0x7f0b0074);
          goto _L31
_L17:
        j = null;
          goto _L32
_L21:
        j = builder.create();
          goto _L32
_L18:
        j = builder.setTitle(0x7f0b0062).create();
          goto _L32
_L20:
        j = builder.setTitle(0x7f0b0066).create();
          goto _L32
_L19:
        j = builder.setTitle(0x7f0b0069).create();
          goto _L32
_L28:
        j = builder.setTitle(0x7f0b006a).create();
          goto _L32
_L25:
        Log.e("GooglePlayServicesUtil", "Google Play services is invalid. Cannot recover.");
        j = builder.setTitle(0x7f0b0072).create();
          goto _L32
_L23:
        Log.e("GooglePlayServicesUtil", "Network error occurred. Please retry request later.");
        j = builder.setTitle(0x7f0b006d).create();
          goto _L32
_L24:
        Log.e("GooglePlayServicesUtil", "Internal error occurred. Please see logs for detailed information");
        j = builder.create();
          goto _L32
_L26:
        Log.e("GooglePlayServicesUtil", "Developer error occurred. Please see logs for detailed information");
        j = builder.create();
          goto _L32
_L22:
        Log.e("GooglePlayServicesUtil", "An invalid account was specified when connecting. Please provide a valid account.");
        j = builder.setTitle(0x7f0b006f).create();
          goto _L32
        Log.e("GooglePlayServicesUtil", "The application is not licensed to the user.");
        j = builder.create();
          goto _L32
        if (activity instanceof m)
        {
            activity = ((m)activity).b;
            avx.a(j, oncancellistener).a(activity, "GooglePlayServicesErrorDialog");
        } else
        if (a.a(11))
        {
            activity = activity.getFragmentManager();
            avr.a(j, oncancellistener).show(activity, "GooglePlayServicesErrorDialog");
        } else
        {
            throw new RuntimeException("This Activity does not support Fragments.");
        }
        return true;
_L2:
        obj = null;
        if (true) goto _L34; else goto _L33
_L33:
    }

    private static boolean a(PackageManager packagemanager)
    {
        Object obj = d;
        obj;
        JVM INSTR monitorenter ;
        int i = c;
        if (i != -1) goto _L2; else goto _L1
_L1:
        if (a(packagemanager.getPackageInfo("com.google.android.gms", 64), new byte[][] {
            axc.d[1]
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
            packageinfo = axc.a();
        } else
        {
            packageinfo = axc.b();
        }
        if (packageinfo.contains(abyte0))
        {
            return abyte0;
        }
        if (Log.isLoggable("GooglePlayServicesUtil", 2))
        {
            (new StringBuilder("Signature not valid.  Found: \n")).append(Base64.encodeToString(abyte0, 0));
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
            (new StringBuilder("Signature not valid.  Found: \n")).append(Base64.encodeToString(packageinfo, 0));
        }
        return null;
    }

    private static Intent b(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 1: // '\001'
        case 2: // '\002'
            return axv.b("com.google.android.gms");

        case 42: // '*'
            return axv.a();

        case 3: // '\003'
            return axv.a("com.google.android.gms");
        }
    }

    public static void b(Context context)
    {
        int i = a(context);
        if (i != 0)
        {
            context = b(i);
            Log.e("GooglePlayServicesUtil", (new StringBuilder("GooglePlayServices not available due to error ")).append(i).toString());
            if (context == null)
            {
                throw new avu(i);
            } else
            {
                throw new avv(i, "Google Play Services not available", context);
            }
        } else
        {
            return;
        }
    }

    public static Context c(Context context)
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

}
