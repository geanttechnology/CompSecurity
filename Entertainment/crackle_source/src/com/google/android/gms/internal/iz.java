// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;

// Referenced classes of package com.google.android.gms.internal:
//            iy, ix, iw, ja

public abstract class iz
{

    protected int rw;

    public iz()
    {
        rw = -1;
    }

    public static final iz a(iz iz1, byte abyte0[])
        throws iy
    {
        return b(iz1, abyte0, 0, abyte0.length);
    }

    public static final void a(iz iz1, byte abyte0[], int i, int j)
    {
        try
        {
            abyte0 = ix.b(abyte0, i, j);
            iz1.a(((ix) (abyte0)));
            abyte0.gf();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (iz iz1)
        {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", iz1);
        }
    }

    public static final byte[] a(iz iz1)
    {
        byte abyte0[] = new byte[iz1.cP()];
        a(iz1, abyte0, 0, abyte0.length);
        return abyte0;
    }

    public static final iz b(iz iz1, byte abyte0[], int i, int j)
        throws iy
    {
        try
        {
            abyte0 = iw.a(abyte0, i, j);
            iz1.b(((iw) (abyte0)));
            abyte0.bI(0);
        }
        // Misplaced declaration of an exception variable
        catch (iz iz1)
        {
            throw iz1;
        }
        // Misplaced declaration of an exception variable
        catch (iz iz1)
        {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
        return iz1;
    }

    public abstract void a(ix ix1)
        throws IOException;

    public abstract iz b(iw iw1)
        throws IOException;

    public int cP()
    {
        rw = 0;
        return 0;
    }

    public String toString()
    {
        return ja.b(this);
    }
}
