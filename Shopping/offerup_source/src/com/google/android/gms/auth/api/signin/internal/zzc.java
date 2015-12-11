// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.auth.api.signin.internal;


public class zzc
{

    static int zzTo = 31;
    private int zzTp;

    public zzc()
    {
        zzTp = 1;
    }

    public zzc zzP(boolean flag)
    {
        int j = zzTo;
        int k = zzTp;
        int i;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        zzTp = i + k * j;
        return this;
    }

    public zzc zzl(Object obj)
    {
        int j = zzTo;
        int k = zzTp;
        int i;
        if (obj == null)
        {
            i = 0;
        } else
        {
            i = obj.hashCode();
        }
        zzTp = i + k * j;
        return this;
    }

    public int zzmd()
    {
        return zzTp;
    }

}
