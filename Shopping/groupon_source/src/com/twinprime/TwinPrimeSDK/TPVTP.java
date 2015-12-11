// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.TwinPrimeSDK;


class TPVTP
{

    String host;
    short nat_port;
    int refcount;

    TPVTP()
    {
    }

    public String toString()
    {
        return (new StringBuilder()).append("VTP(").append(super.toString()).append("): host: ").append(host).append(" nat_port: ").append(nat_port).append(" refcnt: ").append(refcount).toString();
    }
}
