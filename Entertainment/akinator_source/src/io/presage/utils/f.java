// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.utils;

import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package io.presage.utils:
//            g, e

public final class f
{

    private static final HashMap a = new g();
    private int b;
    private String c[];
    private PackageInfo d;

    public f(PackageManager packagemanager, String s)
    {
        try
        {
            d = packagemanager.getPackageInfo(s, 4135);
        }
        // Misplaced declaration of an exception variable
        catch (PackageManager packagemanager)
        {
            e.c(new String[] {
                packagemanager.getMessage()
            });
            return;
        }
        c();
    }

    private static void a(String s)
    {
        throw new RuntimeException(s);
    }

    private void c()
    {
        boolean flag = false;
        if (d.requestedPermissions != null)
        {
            ArrayList arraylist = new ArrayList();
            b = 0;
            String as[] = d.requestedPermissions;
            int k = as.length;
            for (int i = 0; i < k; i++)
            {
                String s1 = as[i];
                Integer integer = (Integer)a.get(s1);
                if (integer != null)
                {
                    int l = b;
                    b = integer.intValue() | l;
                }
                arraylist.add(s1);
            }

            k = arraylist.size();
            c = new String[k];
            int j = ((flag) ? 1 : 0);
            while (j < k) 
            {
                String s = (String)arraylist.get(j);
                c[j] = s.substring(s.lastIndexOf(".") + 1);
                j++;
            }
        }
    }

    public final boolean a(int i)
    {
        return (b & i) == i;
    }

    public final String[] a()
    {
        return c;
    }

    public final void b()
    {
        if (d != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
label0:
        {
            if (!a(1))
            {
                a("[Missing permission] : INTERNET");
            }
            if (d.activities == null)
            {
                a("[Missing Activity] : PresageActivity");
            }
            ActivityInfo aactivityinfo[] = d.activities;
            int j1 = aactivityinfo.length;
            int i = 0;
            while (i < j1) 
            {
                ActivityInfo activityinfo = aactivityinfo[i];
                if (activityinfo.name.equals("io.presage.activities.PresageActivity") && activityinfo.launchMode == 0)
                {
                    char c1;
                    if (android.os.Build.VERSION.SDK_INT < 13)
                    {
                        c1 = '\260';
                    } else
                    {
                        c1 = '\u04B0';
                    }
                    if ((activityinfo.configChanges & c1) == c1)
                    {
                        break label0;
                    }
                    a("[Issue on Activity] : PresageActivity must be : android:configChanges=\"keyboard|keyboardHidden|orientation|screenSize\"");
                } else
                if (activityinfo.name.equals("io.presage.activities.PresageActivity") && activityinfo.launchMode != 0)
                {
                    a("[Issue on Activity] : PresageActivity - bad launch mode, remove any launchMode from the manifest");
                }
                i++;
            }
            a("[Missing Activity] : PresageActivity");
        }
label1:
        {
            if (d.receivers == null)
            {
                a("[Missing Receiver] : BootReceiver");
            }
            ActivityInfo aactivityinfo1[] = d.receivers;
            int l = aactivityinfo1.length;
            for (int j = 0; j < l; j++)
            {
                if (aactivityinfo1[j].name.equals("io.presage.receivers.BootReceiver"))
                {
                    break label1;
                }
            }

            a("[Missing Receiver] : BootReceiver");
        }
        if (d.services == null)
        {
            a("[Missing Service] : PresageServiceImp");
        }
        ServiceInfo aserviceinfo[] = d.services;
        int i1 = aserviceinfo.length;
        int k = 0;
label2:
        do
        {
label3:
            {
                if (k >= i1)
                {
                    break label3;
                }
                if (aserviceinfo[k].name.equals("io.presage.services.PresageServiceImp"))
                {
                    break label2;
                }
                k++;
            }
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
        a("[Missing Service] : PresageServiceImp");
        return;
    }

}
