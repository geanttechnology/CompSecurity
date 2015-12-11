// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.app.Activity;
import android.content.ComponentName;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.SparseArray;
import android.util.SparseIntArray;

// Referenced classes of package com.flurry.android:
//            n, cy

final class fd
{

    private static final SparseArray gM;
    private static final String gm = com/flurry/android/fd.getSimpleName();

    fd()
    {
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
            (new StringBuilder()).append("cannot find info for activity: ").append(componentname).toString();
            return null;
        }
        return packagemanager;
    }

    public static void a(Activity activity, int i)
    {
        if (activity != null)
        {
            activity.setRequestedOrientation(i);
        }
    }

    public static boolean a(Activity activity, int i, boolean flag)
    {
        if (activity == null)
        {
            return false;
        }
        ActivityInfo activityinfo;
        int j;
        int k;
        if (activity == null)
        {
            activityinfo = null;
        } else
        {
            activityinfo = a(activity.getPackageManager(), activity.getComponentName());
        }
        j = a(activityinfo);
        if ((j & 0x80) == 0)
        {
            j = 0;
        } else
        if ((j & 0x400) == 0)
        {
            j = 0;
        } else
        {
            j = 1;
        }
        k = i;
        if (j == 0)
        {
            if (activity == null)
            {
                j = -1;
            } else
            {
                j = activity.getResources().getConfiguration().orientation;
                SparseIntArray sparseintarray = (SparseIntArray)gM.get(j);
                if (sparseintarray != null)
                {
                    j = sparseintarray.get(i, -1);
                } else
                {
                    j = -1;
                }
            }
            if (-1 == j)
            {
                (new StringBuilder()).append("cannot set requested orientation without restarting activity, requestedOrientation = ").append(i).toString();
                cy.d(gm, (new StringBuilder()).append("cannot set requested orientation without restarting activity. It is recommended to add keyboardHidden|orientation|screenSize for android:configChanges attribute for activity: ").append(activity.getComponentName().getClassName()).toString());
                return false;
            }
            k = j;
        }
        activity.setRequestedOrientation(k);
        return true;
    }

    public static int bf()
    {
        byte byte0 = 1;
        if (n.SDK_INT >= 9)
        {
            byte0 = 7;
        }
        return byte0;
    }

    static 
    {
        SparseArray sparsearray = new SparseArray();
        int i = bf();
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
        sparsearray.put(1, sparseintarray);
        if (n.SDK_INT >= 9)
        {
            i = 6;
        } else
        {
            i = 0;
        }
        sparseintarray = new SparseIntArray();
        sparseintarray.put(-1, i);
        sparseintarray.put(2, i);
        sparseintarray.put(3, i);
        sparseintarray.put(4, i);
        sparseintarray.put(0, 0);
        sparseintarray.put(5, 5);
        sparseintarray.put(6, 6);
        sparseintarray.put(8, 8);
        sparseintarray.put(10, 6);
        sparsearray.put(2, sparseintarray);
        gM = sparsearray;
    }
}
