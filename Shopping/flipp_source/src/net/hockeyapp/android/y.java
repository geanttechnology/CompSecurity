// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.hockeyapp.android;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import java.lang.ref.WeakReference;
import net.hockeyapp.android.d.a;

// Referenced classes of package net.hockeyapp.android:
//            a, z

public final class y
{

    private static a a = null;
    private static z b = null;

    public static Boolean a()
    {
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return Boolean.valueOf(flag);
        NoClassDefFoundError noclassdeffounderror;
        noclassdeffounderror;
        return Boolean.valueOf(false);
    }

    public static Boolean a(WeakReference weakreference)
    {
        weakreference = (Activity)weakreference.get();
        if (weakreference != null)
        {
            weakreference = weakreference.getResources().getConfiguration();
            boolean flag;
            if ((((Configuration) (weakreference)).screenLayout & 0xf) == 3 || (((Configuration) (weakreference)).screenLayout & 0xf) == 4)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            return Boolean.valueOf(flag);
        } else
        {
            return Boolean.valueOf(false);
        }
    }

    public static void a(Activity activity, String s)
    {
label0:
        {
            b = null;
            activity = new WeakReference(activity);
            if (a().booleanValue())
            {
                Activity activity1 = (Activity)activity.get();
                boolean flag;
                if (activity1 != null)
                {
                    if (activity1.getFragmentManager().findFragmentByTag("hockey_update_dialog") != null)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                } else
                {
                    flag = false;
                }
                if (flag)
                {
                    break label0;
                }
            }
            if (!b(activity))
            {
                if (a == null || a.getStatus() == android.os.AsyncTask.Status.FINISHED)
                {
                    activity = new a(activity, "https://sdk.hockeyapp.net/", s);
                    a = activity;
                    activity.execute(new String[0]);
                } else
                {
                    s = a;
                    s.c = (Activity)activity.get();
                    if (((a) (s)).c != null)
                    {
                        net.hockeyapp.android.a.a(((a) (s)).c);
                        return;
                    }
                }
            }
        }
    }

    public static z b()
    {
        return b;
    }

    private static boolean b(WeakReference weakreference)
    {
        boolean flag;
        boolean flag1;
        flag1 = true;
        flag = false;
        weakreference = (Activity)weakreference.get();
        if (weakreference == null) goto _L2; else goto _L1
_L1:
        weakreference = weakreference.getPackageManager().getInstallerPackageName(weakreference.getPackageName());
        if (android.os.Build.VERSION.SDK_INT < 9) goto _L4; else goto _L3
_L3:
        if (weakreference == null) goto _L6; else goto _L5
_L5:
        if (weakreference.isEmpty()) goto _L6; else goto _L7
_L7:
        flag = true;
          goto _L2
_L4:
        if (weakreference == null) goto _L9; else goto _L8
_L8:
        int i;
        try
        {
            i = weakreference.length();
        }
        // Misplaced declaration of an exception variable
        catch (WeakReference weakreference)
        {
            return false;
        }
        if (i <= 0) goto _L9; else goto _L10
_L10:
        flag = flag1;
_L11:
        return flag;
_L9:
        flag = false;
        if (true) goto _L11; else goto _L2
_L2:
        return flag;
_L6:
        flag = false;
        if (true) goto _L2; else goto _L12
_L12:
    }

}
