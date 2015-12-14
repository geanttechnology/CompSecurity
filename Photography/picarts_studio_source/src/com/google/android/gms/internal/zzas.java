// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;

// Referenced classes of package com.google.android.gms.internal:
//            zzaq, zzrx

class zzas
    implements zzaq
{

    private zzrx zznG;
    private byte zznH[];
    private final int zznI;

    public zzas(int i)
    {
        zznI = i;
        reset();
    }

    public void reset()
    {
        zznH = new byte[zznI];
        zznG = zzrx.zzC(zznH);
    }

    public byte[] zzac()
    {
        int i = zznG.zzFD();
        if (i < 0)
        {
            throw new IOException();
        }
        if (i == 0)
        {
            return zznH;
        } else
        {
            byte abyte0[] = new byte[zznH.length - i];
            System.arraycopy(zznH, 0, abyte0, 0, abyte0.length);
            return abyte0;
        }
    }

    public void zzb(int i, long l)
    {
        zznG.zzb(i, l);
    }

    public void zzb(int i, String s)
    {
        zznG.zzb(i, s);
    }
}
