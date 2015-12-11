// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.location.Location;
import com.google.android.gms.ads.mediation.NetworkExtras;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

// Referenced classes of package com.google.android.gms.internal:
//            af

public static final class eR
{

    private Date d;
    private int eL;
    private Location eM;
    private boolean eN;
    private String eP;
    private int eR;
    private final HashSet eT = new HashSet();
    private final HashMap eU = new HashMap();
    private final HashSet eV = new HashSet();

    static Date a(eR er)
    {
        return er.d;
    }

    static int b(d d1)
    {
        return d1.eL;
    }

    static HashSet c(eL el)
    {
        return el.eT;
    }

    static Location d(eT et)
    {
        return et.eM;
    }

    static boolean e(eM em)
    {
        return em.eN;
    }

    static HashMap f(eN en)
    {
        return en.eU;
    }

    static String g(eU eu)
    {
        return eu.eP;
    }

    static int h(eP ep)
    {
        return ep.eR;
    }

    static HashSet i(eR er)
    {
        return er.eV;
    }

    public void a(Location location)
    {
        eM = location;
    }

    public void a(NetworkExtras networkextras)
    {
        eU.put(networkextras.getClass(), networkextras);
    }

    public void a(Date date)
    {
        d = date;
    }

    public void d(int j)
    {
        eL = j;
    }

    public void d(boolean flag)
    {
        eN = flag;
    }

    public void e(boolean flag)
    {
        int j;
        if (flag)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        eR = j;
    }

    public void g(String s)
    {
        eT.add(s);
    }

    public void h(String s)
    {
        eV.add(s);
    }

    public void i(String s)
    {
        eP = s;
    }

    public NetworkExtras()
    {
        eL = -1;
        eN = false;
        eR = -1;
    }
}
