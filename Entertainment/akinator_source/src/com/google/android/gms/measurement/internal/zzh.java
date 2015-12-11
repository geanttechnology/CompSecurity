// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.zzx;

class zzh
{

    final String mName;
    final String zzaLl;
    final long zzaMe;
    final long zzaMf;
    final long zzaMg;

    zzh(String s, String s1, long l, long l1, long l2)
    {
        boolean flag1 = true;
        super();
        zzx.zzcr(s);
        zzx.zzcr(s1);
        boolean flag;
        if (l >= 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzaa(flag);
        if (l1 >= 0L)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        zzx.zzaa(flag);
        zzaLl = s;
        mName = s1;
        zzaMe = l;
        zzaMf = l1;
        zzaMg = l2;
    }

    zzh zzO(long l)
    {
        return new zzh(zzaLl, mName, zzaMe + 1L, zzaMf + 1L, l);
    }
}
