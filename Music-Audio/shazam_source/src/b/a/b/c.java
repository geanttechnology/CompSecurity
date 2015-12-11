// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.b;

import java.util.Date;

// Referenced classes of package b.a.b:
//            b

public final class c extends b
{

    public c(boolean flag)
    {
        super(flag);
    }

    protected final long a(Date date)
    {
        return super.a(date) / 1000L;
    }

    protected final Date a(long l)
    {
        return super.a(1000L * l);
    }
}
