// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.IOException;

public abstract class aha
{

    protected volatile int p;

    public aha()
    {
        p = -1;
    }

    public static final aha a(aha aha1, byte abyte0[])
    {
        return b(aha1, abyte0, 0, abyte0.length);
    }

    public static final void a(aha aha1, byte abyte0[], int i, int j)
    {
        try
        {
            abyte0 = ags.a(abyte0, i, j);
            aha1.a(((ags) (abyte0)));
            abyte0.b();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (aha aha1)
        {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", aha1);
        }
    }

    public static final byte[] a(aha aha1)
    {
        byte abyte0[] = new byte[aha1.f()];
        a(aha1, abyte0, 0, abyte0.length);
        return abyte0;
    }

    public static final aha b(aha aha1, byte abyte0[], int i, int j)
    {
        try
        {
            abyte0 = agr.a(abyte0, i, j);
            aha1.b(((agr) (abyte0)));
            abyte0.a(0);
        }
        // Misplaced declaration of an exception variable
        catch (aha aha1)
        {
            throw aha1;
        }
        // Misplaced declaration of an exception variable
        catch (aha aha1)
        {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
        return aha1;
    }

    public void a(ags ags1)
    {
    }

    public abstract aha b(agr agr1);

    protected int c()
    {
        return 0;
    }

    public int e()
    {
        if (p < 0)
        {
            f();
        }
        return p;
    }

    public int f()
    {
        int i = c();
        p = i;
        return i;
    }

    public String toString()
    {
        return ahb.a(this);
    }
}
