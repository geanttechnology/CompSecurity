// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.b;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.e;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

// Referenced classes of package com.google.android.gms.b:
//            bz, bv, bq, aa, 
//            l, m, k

public class bu
{

    private final Object a = new Object();
    private final String b;
    private final bv c;
    private BigInteger d;
    private final HashSet e = new HashSet();
    private final HashMap f = new HashMap();
    private boolean g;
    private boolean h;
    private int i;
    private boolean j;
    private Context k;
    private VersionInfoParcel l;
    private aa m;
    private boolean n;
    private l o;
    private m p;
    private k q;
    private final LinkedList r = new LinkedList();
    private final bq s = null;
    private Boolean t;
    private String u;

    public bu(bz bz1)
    {
        d = BigInteger.ONE;
        g = false;
        h = true;
        i = 0;
        j = false;
        m = null;
        n = true;
        o = null;
        p = null;
        q = null;
        t = null;
        b = bz1.b();
        c = new bv(b);
    }

    public String a()
    {
        String s1;
        synchronized (a)
        {
            s1 = u;
        }
        return s1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public String a(int i1, String s1)
    {
        Resources resources;
        if (l.e)
        {
            resources = k.getResources();
        } else
        {
            resources = com.google.android.gms.common.e.d(k);
        }
        if (resources == null)
        {
            return s1;
        } else
        {
            return resources.getString(i1);
        }
    }

    public void a(Boolean boolean1)
    {
        synchronized (a)
        {
            t = boolean1;
        }
        return;
        boolean1;
        obj;
        JVM INSTR monitorexit ;
        throw boolean1;
    }

    public void a(Throwable throwable, boolean flag)
    {
        (new bq(k, l, null, null)).a(throwable, flag);
    }

    public Boolean b()
    {
        Boolean boolean1;
        synchronized (a)
        {
            boolean1 = t;
        }
        return boolean1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
