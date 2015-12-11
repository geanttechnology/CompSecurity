// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.google.android.gms.common.internal.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package android.support.v7:
//            wd, wf, vn, we

public final class wb
{

    private final we a;
    private final vn b;
    private boolean c;
    private long d;
    private long e;
    private long f;
    private long g;
    private long h;
    private boolean i;
    private final Map j;
    private final List k;

    wb(wb wb1)
    {
        a = wb1.a;
        b = wb1.b;
        d = wb1.d;
        e = wb1.e;
        f = wb1.f;
        g = wb1.g;
        h = wb1.h;
        k = new ArrayList(wb1.k);
        j = new HashMap(wb1.j.size());
        java.util.Map.Entry entry;
        wd wd1;
        for (wb1 = wb1.j.entrySet().iterator(); wb1.hasNext(); j.put(entry.getKey(), wd1))
        {
            entry = (java.util.Map.Entry)wb1.next();
            wd1 = c((Class)entry.getKey());
            ((wd)entry.getValue()).a(wd1);
        }

    }

    wb(we we1, vn vn1)
    {
        x.a(we1);
        x.a(vn1);
        a = we1;
        b = vn1;
        g = 0x1b7740L;
        h = 0xb43e9400L;
        j = new HashMap();
        k = new ArrayList();
    }

    private static wd c(Class class1)
    {
        try
        {
            class1 = (wd)class1.newInstance();
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

    public wb a()
    {
        return new wb(this);
    }

    public wd a(Class class1)
    {
        return (wd)j.get(class1);
    }

    public void a(long l)
    {
        e = l;
    }

    public void a(wd wd1)
    {
        x.a(wd1);
        Class class1 = wd1.getClass();
        if (class1.getSuperclass() != android/support/v7/wd)
        {
            throw new IllegalArgumentException();
        } else
        {
            wd1.a(b(class1));
            return;
        }
    }

    public wd b(Class class1)
    {
        wd wd2 = (wd)j.get(class1);
        wd wd1 = wd2;
        if (wd2 == null)
        {
            wd1 = c(class1);
            j.put(class1, wd1);
        }
        return wd1;
    }

    public Collection b()
    {
        return j.values();
    }

    public List c()
    {
        return k;
    }

    public long d()
    {
        return d;
    }

    public void e()
    {
        i().a(this);
    }

    public boolean f()
    {
        return c;
    }

    void g()
    {
        f = b.b();
        if (e != 0L)
        {
            d = e;
        } else
        {
            d = b.a();
        }
        c = true;
    }

    we h()
    {
        return a;
    }

    wf i()
    {
        return a.m();
    }

    boolean j()
    {
        return i;
    }

    void k()
    {
        i = true;
    }
}
