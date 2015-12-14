// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;


public class zzrv
{

    private final byte zzbhX[] = new byte[256];
    private int zzbhY;
    private int zzbhZ;

    public zzrv(byte abyte0[])
    {
        for (int i = 0; i < 256; i++)
        {
            zzbhX[i] = (byte)i;
        }

        int k = 0;
        for (int j = 0; j < 256; j++)
        {
            k = k + zzbhX[j] + abyte0[j % abyte0.length] & 0xff;
            byte byte0 = zzbhX[j];
            zzbhX[j] = zzbhX[k];
            zzbhX[k] = byte0;
        }

        zzbhY = 0;
        zzbhZ = 0;
    }

    public void zzA(byte abyte0[])
    {
        int k = zzbhY;
        int j = zzbhZ;
        for (int i = 0; i < abyte0.length; i++)
        {
            k = k + 1 & 0xff;
            j = j + zzbhX[k] & 0xff;
            byte byte0 = zzbhX[k];
            zzbhX[k] = zzbhX[j];
            zzbhX[j] = byte0;
            abyte0[i] = (byte)(abyte0[i] ^ zzbhX[zzbhX[k] + zzbhX[j] & 0xff]);
        }

        zzbhY = k;
        zzbhZ = j;
    }
}
