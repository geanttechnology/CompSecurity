// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.appdatasearch;

import android.accounts.Account;

public final class 
{

    private Account zzQv;
    private boolean zzQw;
    private boolean zzQx;
    private boolean zzQy;
    private String zzQz;

    public final  zzL(boolean flag)
    {
        zzQx = flag;
        return this;
    }

    public final zzQx zzby(String s)
    {
        zzQz = s;
        return this;
    }

    public final zzQz zzlr()
    {
        return new t>(zzQv, zzQw, zzQx, zzQy, zzQz);
    }

    public ()
    {
    }
}
