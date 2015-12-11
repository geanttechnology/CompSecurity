// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.c.b;

import com.google.ads.mediation.NetworkExtras;
import java.util.HashMap;

public final class b
    implements NetworkExtras
{

    private final HashMap a = new HashMap();

    public b()
    {
    }

    public final Object a(String s)
    {
        return a.get(s);
    }
}
