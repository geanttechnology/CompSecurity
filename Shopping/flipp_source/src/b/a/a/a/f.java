// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.a;

import b.a.a.ab;
import b.a.a.l;
import b.a.a.m;
import b.a.a.v;
import b.a.a.z;
import java.io.Serializable;

public abstract class f
    implements ab, Serializable, Comparable
{

    public volatile int p;

    public f(int i)
    {
        p = i;
    }

    public static int a(z z1, z z2, m m1)
    {
        if (z1 == null || z2 == null)
        {
            throw new IllegalArgumentException("ReadableInstant objects must not be null");
        } else
        {
            return m1.a(b.a.a.f.b(z1)).b(z2.a(), z1.a());
        }
    }

    public abstract m a();

    public abstract v b();

    public final m c()
    {
        return a();
    }

    public int compareTo(Object obj)
    {
        obj = (f)obj;
        if (obj.getClass() != getClass())
        {
            throw new ClassCastException((new StringBuilder()).append(getClass()).append(" cannot be compared to ").append(obj.getClass()).toString());
        }
        int i = ((f) (obj)).p;
        int j = p;
        if (j > i)
        {
            return 1;
        }
        return j >= i ? 0 : -1;
    }

    public final int d()
    {
        return p;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof ab))
            {
                return false;
            }
            obj = (ab)obj;
            if (((ab) (obj)).b() != b() || ((ab) (obj)).d() != p)
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return (p + 459) * 27 + a().hashCode();
    }
}
