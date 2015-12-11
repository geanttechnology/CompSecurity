// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import io.presage.Presage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class d
{

    private static d a = null;
    private Context b;
    private ArrayList c;

    private d()
    {
        b();
    }

    public static d a()
    {
        if (a == null)
        {
            a = new d();
        }
        return a;
    }

    private void b()
    {
        c = new ArrayList();
        if (b == null)
        {
            b = Presage.getInstance().getContext();
        }
        Iterator iterator = b.getPackageManager().getInstalledPackages(0).iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s = ((PackageInfo)iterator.next()).packageName;
            if (!c.contains(s))
            {
                c.add(s);
            }
        } while (true);
    }

    public final boolean a(String s)
    {
        return c.contains(s);
    }

}
