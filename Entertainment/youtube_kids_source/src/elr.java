// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.zip.Checksum;

final class elr extends elo
{

    private final Checksum a;
    private elq b;

    elr(elq elq1, Checksum checksum)
    {
        b = elq1;
        super();
        a = (Checksum)f.b(checksum);
    }

    public final els a()
    {
        long l = a.getValue();
        if (elq.a(b) == 32)
        {
            return a.i((int)l);
        } else
        {
            return a.a(l);
        }
    }

    protected final void a(byte byte0)
    {
        a.update(byte0);
    }

    protected final void a(byte abyte0[], int i, int j)
    {
        a.update(abyte0, i, j);
    }
}
