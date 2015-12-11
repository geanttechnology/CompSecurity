// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;


public class jx
{

    private final byte ZR[] = new byte[256];
    private int ZS;
    private int ZT;

    public jx(byte abyte0[])
    {
        for (int i = 0; i < 256; i++)
        {
            ZR[i] = (byte)i;
        }

        int k = 0;
        for (int j = 0; j < 256; j++)
        {
            k = k + ZR[j] + abyte0[j % abyte0.length] & 0xff;
            byte byte0 = ZR[j];
            ZR[j] = ZR[k];
            ZR[k] = byte0;
        }

        ZS = 0;
        ZT = 0;
    }

    public void m(byte abyte0[])
    {
        int k = ZS;
        int j = ZT;
        for (int i = 0; i < abyte0.length; i++)
        {
            k = k + 1 & 0xff;
            j = j + ZR[k] & 0xff;
            byte byte0 = ZR[k];
            ZR[k] = ZR[j];
            ZR[j] = byte0;
            abyte0[i] = (byte)(abyte0[i] ^ ZR[ZR[k] + ZR[j] & 0xff]);
        }

        ZS = k;
        ZT = j;
    }
}
