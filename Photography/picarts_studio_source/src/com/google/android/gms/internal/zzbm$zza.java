// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.util.Base64OutputStream;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

class zzsu
{

    ByteArrayOutputStream zzsu;
    Base64OutputStream zzsv;

    public String toString()
    {
        String s;
        try
        {
            zzsv.close();
        }
        catch (IOException ioexception)
        {
            zzb.zzb("HashManager: Unable to convert to Base64.", ioexception);
        }
        zzsu.close();
        s = zzsu.toString();
        zzsu = null;
        zzsv = null;
        return s;
        Object obj;
        obj;
        zzb.zzb("HashManager: Unable to convert to Base64.", ((Throwable) (obj)));
        zzsu = null;
        zzsv = null;
        return "";
        obj;
        zzsu = null;
        zzsv = null;
        throw obj;
    }

    public void write(byte abyte0[])
    {
        zzsv.write(abyte0);
    }

    public client.zzb()
    {
        zzsu = new ByteArrayOutputStream(4096);
        zzsv = new Base64OutputStream(zzsu, 10);
    }
}
