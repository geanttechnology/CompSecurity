// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.location.Location;
import com.google.android.gms.ads.mediation.NetworkExtras;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

public final class p
{

    final HashSet a = new HashSet();
    final HashMap b = new HashMap();
    final HashSet c = new HashSet();
    public Date d;
    public int e;
    public Location f;
    public boolean g;
    public String h;
    int i;

    public p()
    {
        e = -1;
        g = false;
        i = -1;
    }

    public final void a(NetworkExtras networkextras)
    {
        b.put(networkextras.getClass(), networkextras);
    }

    public final void a(String s)
    {
        a.add(s);
    }

    public final void a(boolean flag)
    {
        int j;
        if (flag)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        i = j;
    }

    public final void b(String s)
    {
        c.add(s);
    }
}
