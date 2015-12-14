// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import com.cyberlink.youcammakeup.Globals;
import com.pf.common.utility.m;
import java.util.Iterator;
import java.util.List;

public class al
{

    public static ActivityInfo a(PackageManager packagemanager, String s, String s1, String s2)
    {
        if (packagemanager == null || s == null)
        {
            throw new IllegalArgumentException("packageManager or packageName can not be null.");
        }
        Object obj;
        Object obj1;
        boolean flag;
        if (s1 == null)
        {
            obj = new Intent();
        } else
        {
            obj = new Intent(s1);
        }
        ((Intent) (obj)).addCategory(s2);
        packagemanager = packagemanager.queryIntentActivities(((Intent) (obj)), 64).iterator();
_L2:
        do
        {
            if (!packagemanager.hasNext())
            {
                break MISSING_BLOCK_LABEL_151;
            }
            obj1 = (ResolveInfo)packagemanager.next();
            obj = ((ResolveInfo) (obj1)).activityInfo;
            obj1 = ((ResolveInfo) (obj1)).filter;
        } while (obj1 == null);
        if (!((IntentFilter) (obj1)).hasAction(s1) || !((IntentFilter) (obj1)).hasCategory(s2)) goto _L2; else goto _L1
_L1:
        flag = ((ActivityInfo) (obj)).packageName.equals(s);
        if (flag)
        {
            return ((ActivityInfo) (obj));
        }
          goto _L2
        packagemanager;
        m.b("PackageUtils", "findPackage", packagemanager);
        return null;
    }

    public static ActivityInfo a(PackageManager packagemanager, String s, String s1, String s2, String s3)
    {
        if (packagemanager == null || s == null)
        {
            throw new IllegalArgumentException("packageManager or packageName can not be null.");
        }
        Object obj;
        boolean flag;
        if (s1 == null)
        {
            obj = new Intent();
        } else
        {
            obj = new Intent(s1);
        }
        ((Intent) (obj)).addCategory(s2);
        if (s3 != null)
        {
            ((Intent) (obj)).setType(s3);
        }
        packagemanager = packagemanager.queryIntentActivities(((Intent) (obj)), 64).iterator();
_L2:
        do
        {
            if (!packagemanager.hasNext())
            {
                break MISSING_BLOCK_LABEL_197;
            }
            obj = (ResolveInfo)packagemanager.next();
            s3 = ((ResolveInfo) (obj)).activityInfo;
            obj = ((ResolveInfo) (obj)).filter;
        } while (obj == null);
        if (!((IntentFilter) (obj)).hasAction(s1) || !((IntentFilter) (obj)).hasCategory(s2)) goto _L2; else goto _L1
_L1:
        obj = ((ActivityInfo) (s3)).packageName;
        Globals.d().e((new StringBuilder()).append("PackageUtils.findPackage()").append(String.valueOf(obj)).toString());
        flag = ((String) (obj)).equals(s);
        if (flag)
        {
            return s3;
        }
          goto _L2
        packagemanager;
        m.b("PackageUtils", "findPackage", packagemanager);
        return null;
    }

    public static boolean a(Context context, String s)
    {
        PackageManager packagemanager = context.getPackageManager();
        try
        {
            s = packagemanager.getLaunchIntentForPackage(s);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return false;
        }
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_23;
        }
        throw new android.content.pm.PackageManager.NameNotFoundException();
        s.addCategory("android.intent.category.LAUNCHER");
        context.startActivity(s);
        return true;
    }

    public static boolean a(PackageManager packagemanager)
    {
        return a(packagemanager, "com.cyberlink.youperfect", "android.media.action.IMAGE_CAPTURE", "android.intent.category.DEFAULT") != null;
    }

    public static boolean a(String s)
    {
        PackageManager packagemanager = Globals.d().getPackageManager();
        boolean flag;
        try
        {
            packagemanager.getPackageInfo(s, 1);
            flag = packagemanager.getApplicationInfo(s, 0).enabled;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return false;
        }
        catch (Exception exception1)
        {
            try
            {
                packagemanager.getPackageGids(s);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return false;
            }
            catch (Exception exception)
            {
                m.b("PackageUtils", (new StringBuilder()).append("Ignore package name:").append(s).toString(), exception);
                return false;
            }
            return true;
        }
        return flag;
    }

    public static int b(String s)
    {
        PackageManager packagemanager = Globals.d().getPackageManager();
        int i;
        try
        {
            i = packagemanager.getPackageInfo(s, 0).versionCode;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return 0;
        }
        return i;
    }
}
