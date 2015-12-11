// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.d;

import java.lang.reflect.Constructor;
import java.util.Date;

// Referenced classes of package org.simpleframework.xml.d:
//            ag, m, o

final class n
    implements ag
{

    private final m a;

    public n(Class class1)
    {
        a = new m(class1);
    }

    public final Object a(String s)
    {
        return b(s);
    }

    public final volatile String a(Object obj)
    {
        return a((Date)obj);
    }

    public final String a(Date date)
    {
        this;
        JVM INSTR monitorenter ;
        date = o.a(date);
        this;
        JVM INSTR monitorexit ;
        return date;
        date;
        throw date;
    }

    public final Date b(String s)
    {
        this;
        JVM INSTR monitorenter ;
        long l = o.a(s).getTime();
        s = (Date)a.a.newInstance(new Object[] {
            Long.valueOf(l)
        });
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        throw s;
    }
}
