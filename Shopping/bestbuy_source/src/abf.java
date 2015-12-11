// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Bundle;
import android.os.SystemClock;
import com.google.android.gms.internal.av;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class abf
{

    private final abi a;
    private final LinkedList b;
    private final Object c;
    private final String d;
    private final String e;
    private long f;
    private long g;
    private boolean h;
    private long i;
    private long j;
    private long k;
    private long l;

    public abf(abi abi1, String s, String s1)
    {
        c = new Object();
        f = -1L;
        g = -1L;
        h = false;
        i = -1L;
        j = 0L;
        k = -1L;
        l = -1L;
        a = abi1;
        d = s;
        e = s1;
        b = new LinkedList();
    }

    public abf(String s, String s1)
    {
        this(abi.a(), s, s1);
    }

    public void a()
    {
        synchronized (c)
        {
            if (l != -1L && g == -1L)
            {
                g = SystemClock.elapsedRealtime();
                a.a(this);
            }
            abi abi1 = a;
            abi.f().c();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void a(long l1)
    {
        synchronized (c)
        {
            l = l1;
            if (l != -1L)
            {
                a.a(this);
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void a(av av)
    {
        synchronized (c)
        {
            k = SystemClock.elapsedRealtime();
            abi abi1 = a;
            abi.f().a(av, k);
        }
        return;
        av;
        obj;
        JVM INSTR monitorexit ;
        throw av;
    }

    public void a(boolean flag)
    {
        Object obj = c;
        obj;
        JVM INSTR monitorenter ;
        if (l == -1L)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        i = SystemClock.elapsedRealtime();
        if (flag)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        g = i;
        a.a(this);
        obj;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void b()
    {
        synchronized (c)
        {
            if (l != -1L)
            {
                Object obj1 = new abg();
                ((abg) (obj1)).c();
                b.add(obj1);
                j = j + 1L;
                obj1 = a;
                abi.f().b();
                a.a(this);
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void b(long l1)
    {
        synchronized (c)
        {
            if (l != -1L)
            {
                f = l1;
                a.a(this);
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void b(boolean flag)
    {
        synchronized (c)
        {
            if (l != -1L)
            {
                h = flag;
                a.a(this);
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void c()
    {
        synchronized (c)
        {
            if (l != -1L && !b.isEmpty())
            {
                abg abg1 = (abg)b.getLast();
                if (abg1.a() == -1L)
                {
                    abg1.b();
                    a.a(this);
                }
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Bundle d()
    {
        Object obj = c;
        obj;
        JVM INSTR monitorenter ;
        Object obj1;
        ArrayList arraylist;
        obj1 = new Bundle();
        ((Bundle) (obj1)).putString("seq_num", d);
        ((Bundle) (obj1)).putString("slotid", e);
        ((Bundle) (obj1)).putBoolean("ismediation", h);
        ((Bundle) (obj1)).putLong("treq", k);
        ((Bundle) (obj1)).putLong("tresponse", l);
        ((Bundle) (obj1)).putLong("timp", g);
        ((Bundle) (obj1)).putLong("tload", i);
        ((Bundle) (obj1)).putLong("pcc", j);
        ((Bundle) (obj1)).putLong("tfetch", f);
        arraylist = new ArrayList();
        for (Iterator iterator = b.iterator(); iterator.hasNext(); arraylist.add(((abg)iterator.next()).d())) { }
        break MISSING_BLOCK_LABEL_158;
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        ((Bundle) (obj1)).putParcelableArrayList("tclick", arraylist);
        obj;
        JVM INSTR monitorexit ;
        return ((Bundle) (obj1));
    }
}
