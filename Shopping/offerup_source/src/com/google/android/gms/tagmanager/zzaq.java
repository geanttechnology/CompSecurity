// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import android.text.TextUtils;

class zzaq
{

    private final long zzPg;
    private final long zzaXb;
    private final long zzaXc;
    private String zzaXd;

    zzaq(long l, long l1, long l2)
    {
        zzaXb = l;
        zzPg = l1;
        zzaXc = l2;
    }

    long zzCV()
    {
        return zzaXb;
    }

    long zzCW()
    {
        return zzaXc;
    }

    String zzCX()
    {
        return zzaXd;
    }

    void zzeQ(String s)
    {
        if (s == null || TextUtils.isEmpty(s.trim()))
        {
            return;
        } else
        {
            zzaXd = s;
            return;
        }
    }
}
