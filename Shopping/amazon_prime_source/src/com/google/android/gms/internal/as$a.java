// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

// Referenced classes of package com.google.android.gms.internal:
//            as

public static final class mf
{

    private Date d;
    private Location h;
    private String lY;
    private int lZ;
    private boolean ma;
    private String md;
    private int mf;
    private final HashSet mh = new HashSet();
    private final HashMap mi = new HashMap();
    private final HashMap mj = new HashMap();
    private final HashSet mk = new HashSet();

    static Date a(mf mf1)
    {
        return mf1.d;
    }

    static String b(d d1)
    {
        return d1.lY;
    }

    static int c(lY ly)
    {
        return ly.lZ;
    }

    static HashSet d(lZ lz)
    {
        return lz.mh;
    }

    static Location e(mh mh1)
    {
        return mh1.h;
    }

    static boolean f(h h1)
    {
        return h1.ma;
    }

    static HashMap g(ma ma1)
    {
        return ma1.mi;
    }

    static HashMap h(mi mi1)
    {
        return mi1.mj;
    }

    static String i(mj mj1)
    {
        return mj1.md;
    }

    static int j(md md1)
    {
        return md1.mf;
    }

    static HashSet k(mf mf1)
    {
        return mf1.mk;
    }

    public void a(Class class1, Bundle bundle)
    {
        mi.put(class1, bundle);
    }

    public void a(Date date)
    {
        d = date;
    }

    public void d(int l)
    {
        lZ = l;
    }

    public void g(String s)
    {
        mh.add(s);
    }

    public void g(boolean flag)
    {
        int l;
        if (flag)
        {
            l = 1;
        } else
        {
            l = 0;
        }
        mf = l;
    }

    public void h(String s)
    {
        mk.add(s);
    }

    public ()
    {
        lZ = -1;
        ma = false;
        mf = -1;
    }
}
