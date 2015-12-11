// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.mediation.customevent;

import android.support.v7.kq;
import java.util.HashMap;

public final class CustomEventExtras
    implements kq
{

    private final HashMap zzJL = new HashMap();

    public CustomEventExtras()
    {
    }

    public Object getExtra(String s)
    {
        return zzJL.get(s);
    }

    public void setExtra(String s, Object obj)
    {
        zzJL.put(s, obj);
    }
}
