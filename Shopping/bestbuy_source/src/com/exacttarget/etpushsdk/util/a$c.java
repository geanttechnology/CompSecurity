// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk.util;

import android.util.Base64;
import javax.crypto.SecretKey;

class b
{

    private SecretKey a;
    private SecretKey b;

    public SecretKey a()
    {
        return a;
    }

    public void a(SecretKey secretkey)
    {
        a = secretkey;
    }

    public SecretKey b()
    {
        return b;
    }

    public void b(SecretKey secretkey)
    {
        b = secretkey;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null)
            {
                return false;
            }
            if (getClass() != obj.getClass())
            {
                return false;
            }
            obj = (b)obj;
            if (!b.equals(((b) (obj)).b))
            {
                return false;
            }
            if (!a.equals(((a) (obj)).a))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return (a.hashCode() + 31) * 31 + b.hashCode();
    }

    public String toString()
    {
        return (new StringBuilder()).append(Base64.encodeToString(a().getEncoded(), 2)).append(":").append(Base64.encodeToString(b().getEncoded(), 2)).toString();
    }

    public (SecretKey secretkey, SecretKey secretkey1)
    {
        a(secretkey);
        b(secretkey1);
    }
}
