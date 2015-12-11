// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.Serializable;
import java.util.zip.Checksum;

final class elq extends elw
    implements Serializable
{

    private static final long serialVersionUID = 0L;
    private final egf a;
    private final int b;
    private final String c;

    elq(egf egf1, int i, String s)
    {
        a = (egf)f.b(egf1);
        boolean flag;
        if (i == 32 || i == 64)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        f.a(flag, "bits (%s) must be either 32 or 64", new Object[] {
            Integer.valueOf(i)
        });
        b = i;
        c = (String)f.b(s);
    }

    static int a(elq elq1)
    {
        return elq1.b;
    }

    public final elx a()
    {
        return new elr(this, (Checksum)a.get());
    }

    public final String toString()
    {
        return c;
    }
}
