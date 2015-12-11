// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.a.a;

import com.google.api.a.g.b.d;
import com.google.api.a.g.b.e;
import com.google.api.a.g.v;
import java.io.Serializable;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package com.google.api.a.a.a:
//            i

public final class p
    implements Serializable
{

    public static final String a = com/google/api/a/a/a/p.getSimpleName();
    private final Lock b;
    private String c;
    private Long d;
    private String e;

    public p()
    {
        b = new ReentrantLock();
    }

    public p(i j)
    {
        b = new ReentrantLock();
        a(j.a());
        b(j.b());
        a(j.c());
    }

    private p a(Long long1)
    {
        b.lock();
        d = long1;
        b.unlock();
        return this;
        long1;
        b.unlock();
        throw long1;
    }

    private p a(String s)
    {
        b.lock();
        c = s;
        b.unlock();
        return this;
        s;
        b.unlock();
        throw s;
    }

    public static d a(e e1)
    {
        return e1.a(a);
    }

    private p b(String s)
    {
        b.lock();
        e = s;
        b.unlock();
        return this;
        s;
        b.unlock();
        throw s;
    }

    public final String a()
    {
        b.lock();
        String s = c;
        b.unlock();
        return s;
        Exception exception;
        exception;
        b.unlock();
        throw exception;
    }

    public final Long b()
    {
        b.lock();
        Long long1 = d;
        b.unlock();
        return long1;
        Exception exception;
        exception;
        b.unlock();
        throw exception;
    }

    public final String c()
    {
        b.lock();
        String s = e;
        b.unlock();
        return s;
        Exception exception;
        exception;
        b.unlock();
        throw exception;
    }

    public final boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof p))
            {
                return false;
            }
            obj = (p)obj;
            if (!v.a(a(), ((p) (obj)).a()) || !v.a(c(), ((p) (obj)).c()) || !v.a(b(), ((p) (obj)).b()))
            {
                return false;
            }
        }
        return true;
    }

    public final int hashCode()
    {
        return Arrays.hashCode(new Object[] {
            a(), c(), b()
        });
    }

    public final String toString()
    {
        String s = com/google/api/a/a/a/p.getClass().getName().replaceAll("\\$[0-9]+", "\\$");
        int k = s.lastIndexOf('$');
        int j = k;
        if (k == -1)
        {
            j = s.lastIndexOf('.');
        }
        return (new com.google.api.a.g.v.a(new com.google.api.a.f.a.a.a.a.b.a(s.substring(j + 1), (byte)0))).a("accessToken", a()).a("refreshToken", c()).a("expirationTimeMilliseconds", b()).toString();
    }

}
