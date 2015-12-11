// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.flurry.android.impl.ads.protocol.v13.ScreenOrientationType;

// Referenced classes of package com.flurry.sdk:
//            gd

public final class cn
{

    private static final String a = com/flurry/sdk/cn.getSimpleName();
    private static final SparseArray b = c();

    public cn()
    {
    }

    public static int a()
    {
        return 7;
    }

    public static int a(Activity activity, int i, int j)
    {
        if (activity == null)
        {
            return -1;
        }
        activity = (SparseIntArray)b.get(j);
        if (activity != null)
        {
            i = activity.get(i, -1);
        } else
        {
            i = -1;
        }
        return i;
    }

    public static int a(Activity activity, ScreenOrientationType screenorientationtype)
    {
        int i = 0;
        if (!ScreenOrientationType.PORTRAIT.equals(screenorientationtype)) goto _L2; else goto _L1
_L1:
        i = 1;
_L4:
        return a(activity, -1, i);
_L2:
        if (ScreenOrientationType.LANDSCAPE.equals(screenorientationtype))
        {
            i = 2;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static int a(ActivityInfo activityinfo)
    {
        int i;
        if (activityinfo == null)
        {
            i = 0;
        } else
        {
            int j = activityinfo.configChanges;
            i = j;
            if (activityinfo.applicationInfo.targetSdkVersion < 13)
            {
                return j | 0xc00;
            }
        }
        return i;
    }

    public static ActivityInfo a(Activity activity)
    {
        if (activity == null)
        {
            return null;
        } else
        {
            return a(activity.getPackageManager(), activity.getComponentName());
        }
    }

    public static ActivityInfo a(PackageManager packagemanager, ComponentName componentname)
    {
        if (packagemanager == null || componentname == null)
        {
            return null;
        }
        try
        {
            packagemanager = packagemanager.getActivityInfo(componentname, 0);
        }
        // Misplaced declaration of an exception variable
        catch (PackageManager packagemanager)
        {
            gd.a(5, a, (new StringBuilder()).append("cannot find info for activity: ").append(componentname).toString());
            return null;
        }
        return packagemanager;
    }

    public static void a(Activity activity, int i)
    {
        if (activity == null)
        {
            gd.b(a, "Context is null. Cannot set requested orientation.");
            return;
        }
        if (a(((Context) (activity))))
        {
            gd.b(a, "setOrientation SCREEN_ORIENTATION_SENSOR");
            activity.setRequestedOrientation(4);
            return;
        } else
        {
            gd.b(a, (new StringBuilder()).append("setOrientation ").append(i).toString());
            activity.setRequestedOrientation(i);
            return;
        }
    }

    public static boolean a(Activity activity, int i, boolean flag)
    {
        boolean flag1 = true;
        if (activity == null)
        {
            flag1 = false;
        } else
        {
            int j = i;
            if (!b(activity))
            {
                j = b(activity, i);
                if (-1 == j)
                {
                    gd.a(5, a, (new StringBuilder()).append("cannot set requested orientation without restarting activity, requestedOrientation = ").append(i).toString());
                    gd.b(a, (new StringBuilder()).append("cannot set requested orientation without restarting activity. It is recommended to add keyboardHidden|orientation|screenSize for android:configChanges attribute for activity: ").append(activity.getComponentName().getClassName()).toString());
                    return false;
                }
                flag = true;
            }
            activity.setRequestedOrientation(j);
            if (!flag)
            {
                activity.setRequestedOrientation(-1);
                return true;
            }
        }
        return flag1;
    }

    public static boolean a(Context context)
    {
        boolean flag;
        if ((context.getResources().getConfiguration().screenLayout & 0xf) >= 3)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        gd.b(a, (new StringBuilder()).append("isTablet ").append(flag).toString());
        return flag;
    }

    public static int b()
    {
        return 6;
    }

    public static int b(Activity activity, int i)
    {
        if (activity == null)
        {
            return -1;
        } else
        {
            return a(activity, i, activity.getResources().getConfiguration().orientation);
        }
    }

    public static boolean b(Activity activity)
    {
        for (int i = a(a(activity)); (i & 0x80) == 0 || (i & 0x400) == 0;)
        {
            return false;
        }

        return true;
    }

    private static SparseArray c()
    {
        SparseArray sparsearray = new SparseArray();
        sparsearray.put(1, d());
        sparsearray.put(2, e());
        return sparsearray;
    }

    private static SparseIntArray d()
    {
        int i = a();
        SparseIntArray sparseintarray = new SparseIntArray();
        sparseintarray.put(-1, i);
        sparseintarray.put(2, i);
        sparseintarray.put(3, i);
        sparseintarray.put(4, i);
        sparseintarray.put(1, 1);
        sparseintarray.put(5, 5);
        sparseintarray.put(7, 7);
        sparseintarray.put(9, 9);
        sparseintarray.put(10, 7);
        return sparseintarray;
    }

    private static SparseIntArray e()
    {
        int i = b();
        SparseIntArray sparseintarray = new SparseIntArray();
        sparseintarray.put(-1, i);
        sparseintarray.put(2, i);
        sparseintarray.put(3, i);
        sparseintarray.put(4, i);
        sparseintarray.put(0, 0);
        sparseintarray.put(5, 5);
        sparseintarray.put(6, 6);
        sparseintarray.put(8, 8);
        sparseintarray.put(10, 6);
        return sparseintarray;
    }

}
