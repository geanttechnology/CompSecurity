// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import java.io.IOException;
import java.nio.ByteBuffer;

// Referenced classes of package com.google.android.gms.d:
//            lb, ku, kv, ld

public abstract class lc
{

    protected volatile int s;

    public lc()
    {
        s = -1;
    }

    public static final lc a(lc lc1, byte abyte0[], int i)
    {
        try
        {
            abyte0 = new ku(abyte0, i);
            lc1.a(((ku) (abyte0)));
            abyte0.a(0);
        }
        // Misplaced declaration of an exception variable
        catch (lc lc1)
        {
            throw lc1;
        }
        // Misplaced declaration of an exception variable
        catch (lc lc1)
        {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
        return lc1;
    }

    public static final byte[] a(lc lc1)
    {
        byte abyte0[] = new byte[lc1.f()];
        int i = abyte0.length;
        try
        {
            kv kv1 = kv.a(abyte0, i);
            lc1.a(kv1);
            if (kv1.a.remaining() != 0)
            {
                throw new IllegalStateException("Did not write as much data as expected.");
            }
        }
        // Misplaced declaration of an exception variable
        catch (lc lc1)
        {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", lc1);
        }
        return abyte0;
    }

    protected int a()
    {
        return 0;
    }

    public abstract lc a(ku ku1);

    public void a(kv kv1)
    {
    }

    public Object clone()
    {
        return d();
    }

    public lc d()
    {
        return (lc)super.clone();
    }

    public final int e()
    {
        if (s < 0)
        {
            f();
        }
        return s;
    }

    public final int f()
    {
        int i = a();
        s = i;
        return i;
    }

    public String toString()
    {
        return ld.a(this);
    }
}
