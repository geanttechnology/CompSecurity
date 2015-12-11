// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.text.TextUtils;

// Referenced classes of package com.google.android.gms.internal:
//            zzby, zzbu

public final class zzbr
{

    private String zzuc;
    private int zzud;

    public zzbr()
    {
        this((String)zzby.zzul.zzde(), -1);
    }

    public zzbr(String s)
    {
        this(s, -1);
    }

    public zzbr(String s, int i)
    {
        zzud = -1;
        if (TextUtils.isEmpty(s))
        {
            s = (String)zzby.zzul.zzde();
        }
        zzuc = s;
        zzud = i;
    }

    public String zzdc()
    {
        return zzuc;
    }

    public int zzdd()
    {
        return zzud;
    }
}
