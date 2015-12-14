// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.appdatasearch;

import android.accounts.Account;

// Referenced classes of package com.google.android.gms.appdatasearch:
//            GetRecentContextCall

public static final class 
{

    private Account zzPq;
    private boolean zzPr;
    private boolean zzPs;
    private boolean zzPt;
    private String zzPu;

    public  zzL(boolean flag)
    {
        zzPs = flag;
        return this;
    }

    public zzPs zzbw(String s)
    {
        zzPu = s;
        return this;
    }

    public zzPu zzlb()
    {
        return new t>(zzPq, zzPr, zzPs, zzPt, zzPu);
    }

    public ()
    {
    }
}
