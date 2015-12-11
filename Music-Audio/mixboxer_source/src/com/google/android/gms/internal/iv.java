// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;


public class iv
{

    private final byte Hm[] = new byte[256];
    private int Hn;
    private int Ho;

    public iv(byte abyte0[])
    {
        for (int i = 0; i < 256; i++)
        {
            Hm[i] = (byte)i;
        }

        int k = 0;
        for (int j = 0; j < 256; j++)
        {
            k = k + Hm[j] + abyte0[j % abyte0.length] & 0xff;
            byte byte0 = Hm[j];
            Hm[j] = Hm[k];
            Hm[k] = byte0;
        }

        Hn = 0;
        Ho = 0;
    }

    public void h(byte abyte0[])
    {
        int k = Hn;
        int j = Ho;
        for (int i = 0; i < abyte0.length; i++)
        {
            k = k + 1 & 0xff;
            j = j + Hm[k] & 0xff;
            byte byte0 = Hm[k];
            Hm[k] = Hm[j];
            Hm[j] = byte0;
            abyte0[i] = (byte)(abyte0[i] ^ Hm[Hm[k] + Hm[j] & 0xff]);
        }

        Hn = k;
        Ho = j;
    }
}
