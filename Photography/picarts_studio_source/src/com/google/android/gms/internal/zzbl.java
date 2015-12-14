// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class zzbl
{

    private static MessageDigest zzso = null;
    protected Object zzpd;

    public zzbl()
    {
        zzpd = new Object();
    }

    protected MessageDigest zzcy()
    {
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        MessageDigest messagedigest;
        if (zzso == null)
        {
            break MISSING_BLOCK_LABEL_21;
        }
        messagedigest = zzso;
        return messagedigest;
        int i = 0;
        while (i < 2) 
        {
            MessageDigest messagedigest1;
            Exception exception;
            try
            {
                zzso = MessageDigest.getInstance("MD5");
            }
            catch (NoSuchAlgorithmException nosuchalgorithmexception) { }
            finally { }
            i++;
        }
        messagedigest1 = zzso;
        obj;
        JVM INSTR monitorexit ;
        return messagedigest1;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    abstract byte[] zzz(String s);

}
