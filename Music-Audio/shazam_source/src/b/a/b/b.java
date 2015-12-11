// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.b;

import com.google.b.d.a;
import com.google.b.d.c;
import com.google.b.x;
import java.util.Date;

public class b extends x
{

    private final boolean a;

    public b(boolean flag)
    {
        a = flag;
    }

    protected long a(Date date)
    {
        return date.getTime();
    }

    public final Object a(a a1)
    {
        long l = a1.m();
        if (l >= 0L || a)
        {
            return a(l);
        } else
        {
            return null;
        }
    }

    protected Date a(long l)
    {
        return new Date(l);
    }

    public final void a(c c1, Object obj)
    {
        obj = (Date)obj;
        if (((Date) (obj)).getTime() >= 0L || a)
        {
            c1.a(a(((Date) (obj))));
            return;
        } else
        {
            c1.f();
            return;
        }
    }
}
