// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.IOException;

public abstract class eug
{

    public eug()
    {
    }

    private eug a(byte abyte0[], int i, int j)
    {
        try
        {
            abyte0 = new eud(abyte0, 0, j);
            a(((eud) (abyte0)));
            abyte0.a(0);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw abyte0;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
        return this;
    }

    public static boolean a(eud eud1, int i)
    {
        return eud1.b(i);
    }

    public abstract int a();

    public abstract eug a(eud eud1);

    public final eug a(byte abyte0[])
    {
        return a(abyte0, 0, abyte0.length);
    }

    public abstract void a(eue eue1);

    public abstract int b();

    public final byte[] c()
    {
        Object obj = new byte[b()];
        int i = obj.length;
        try
        {
            eue eue1 = new eue(((byte []) (obj)), 0, i);
            a(eue1);
            if (eue1.a - eue1.b != 0)
            {
                throw new IllegalStateException("Did not write as much data as expected.");
            }
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).");
        }
        return ((byte []) (obj));
    }
}
