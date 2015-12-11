// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import com.google.android.gms.common.internal.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.d:
//            iy, iz, ii

public final class ix
{

    public final iz a;
    public final ii b;
    public boolean c;
    public long d;
    public long e;
    public long f;
    public boolean g;
    final Map h;
    final List i;
    private long j;
    private long k;

    private ix(ix ix1)
    {
        a = ix1.a;
        b = ix1.b;
        d = ix1.d;
        e = ix1.e;
        f = ix1.f;
        j = ix1.j;
        k = ix1.k;
        i = new ArrayList(ix1.i);
        h = new HashMap(ix1.h.size());
        java.util.Map.Entry entry;
        iy iy1;
        for (ix1 = ix1.h.entrySet().iterator(); ix1.hasNext(); h.put(entry.getKey(), iy1))
        {
            entry = (java.util.Map.Entry)ix1.next();
            iy1 = c((Class)entry.getKey());
            ((iy)entry.getValue()).a(iy1);
        }

    }

    ix(iz iz, ii ii)
    {
        w.a(iz);
        w.a(ii);
        a = iz;
        b = ii;
        j = 0x1b7740L;
        k = 0xb43e9400L;
        h = new HashMap();
        i = new ArrayList();
    }

    private static iy c(Class class1)
    {
        try
        {
            class1 = (iy)class1.newInstance();
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            throw new IllegalArgumentException("dataType doesn't have default constructor", class1);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            throw new IllegalArgumentException("dataType default constructor is not accessible", class1);
        }
        return class1;
    }

    public final ix a()
    {
        return new ix(this);
    }

    public final iy a(Class class1)
    {
        return (iy)h.get(class1);
    }

    public final void a(iy iy1)
    {
        w.a(iy1);
        Class class1 = iy1.getClass();
        if (class1.getSuperclass() != com/google/android/gms/d/iy)
        {
            throw new IllegalArgumentException();
        } else
        {
            iy1.a(b(class1));
            return;
        }
    }

    public final iy b(Class class1)
    {
        iy iy2 = (iy)h.get(class1);
        iy iy1 = iy2;
        if (iy2 == null)
        {
            iy1 = c(class1);
            h.put(class1, iy1);
        }
        return iy1;
    }
}
