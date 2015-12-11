// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;

// Referenced classes of package com.google.android.gms.internal:
//            k, ix

class m
    implements k
{

    private ix dR;
    private byte dS[];
    private final int dT;

    public m(int i)
    {
        dT = i;
        reset();
    }

    public void b(int i, long l)
        throws IOException
    {
        dR.b(i, l);
    }

    public void b(int i, String s)
        throws IOException
    {
        dR.b(i, s);
    }

    public byte[] h()
        throws IOException
    {
        int i = dR.ge();
        if (i < 0)
        {
            throw new IOException();
        }
        if (i == 0)
        {
            return dS;
        } else
        {
            byte abyte0[] = new byte[dS.length - i];
            System.arraycopy(dS, 0, abyte0, 0, abyte0.length);
            return abyte0;
        }
    }

    public void reset()
    {
        dS = new byte[dT];
        dR = ix.i(dS);
    }
}
