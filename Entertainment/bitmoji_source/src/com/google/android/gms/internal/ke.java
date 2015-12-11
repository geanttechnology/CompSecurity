// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;

// Referenced classes of package com.google.android.gms.internal:
//            kd, jz, jy, kf

public abstract class ke
{

    protected int DY;

    public ke()
    {
        DY = -1;
    }

    public static final ke a(ke ke1, byte abyte0[])
        throws kd
    {
        return b(ke1, abyte0, 0, abyte0.length);
    }

    public static final void a(ke ke1, byte abyte0[], int i, int j)
    {
        try
        {
            abyte0 = jz.b(abyte0, i, j);
            ke1.a(((jz) (abyte0)));
            abyte0.kN();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ke ke1)
        {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", ke1);
        }
    }

    public static final ke b(ke ke1, byte abyte0[], int i, int j)
        throws kd
    {
        try
        {
            abyte0 = jy.a(abyte0, i, j);
            ke1.b(((jy) (abyte0)));
            abyte0.cu(0);
        }
        // Misplaced declaration of an exception variable
        catch (ke ke1)
        {
            throw ke1;
        }
        // Misplaced declaration of an exception variable
        catch (ke ke1)
        {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
        return ke1;
    }

    public static final byte[] d(ke ke1)
    {
        byte abyte0[] = new byte[ke1.c()];
        a(ke1, abyte0, 0, abyte0.length);
        return abyte0;
    }

    public void a(jz jz1)
        throws IOException
    {
    }

    public abstract ke b(jy jy1)
        throws IOException;

    public int c()
    {
        DY = 0;
        return 0;
    }

    public int eW()
    {
        if (DY < 0)
        {
            c();
        }
        return DY;
    }

    public String toString()
    {
        return kf.e(this);
    }
}
