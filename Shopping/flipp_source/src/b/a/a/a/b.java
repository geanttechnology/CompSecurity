// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.a;

import b.a.a.c.g;
import b.a.a.d.aa;
import b.a.a.d.d;
import b.a.a.z;
import java.util.Date;

public abstract class b
    implements z
{

    public b()
    {
    }

    public final int a(z z1)
    {
        if (this != z1)
        {
            long l = z1.a();
            long l1 = a();
            if (l1 != l)
            {
                return l1 >= l ? 1 : -1;
            }
        }
        return 0;
    }

    public final Date c()
    {
        return new Date(a());
    }

    public int compareTo(Object obj)
    {
        return a((z)obj);
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof z))
            {
                return false;
            }
            obj = (z)obj;
            if (a() != ((z) (obj)).a() || !g.a(b(), ((z) (obj)).b()))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return (int)(a() ^ a() >>> 32) + b().hashCode();
    }

    public String toString()
    {
        return aa.b().a(this);
    }
}
