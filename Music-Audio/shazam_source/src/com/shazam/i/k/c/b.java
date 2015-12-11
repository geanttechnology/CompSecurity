// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.i.k.c;

import android.content.Context;
import com.shazam.android.ag.g.a;
import com.shazam.android.v.r;
import com.shazam.i.b.ah.f;
import com.shazam.i.b.c;
import com.shazam.model.store.OrderingStoresAnalyticsDecorator;
import com.shazam.model.store.StoresAnalyticsDecorator;

public final class b
{

    public static StoresAnalyticsDecorator a(com.shazam.b.a.a a1)
    {
        return new OrderingStoresAnalyticsDecorator(com.shazam.i.b.n.b.x(), new com.shazam.android.ag.g.b(com.shazam.i.b.n.b.x(), f.a(), c.a().getString(0x7f09023c)), a1, new a(com.shazam.i.b.n.b.x(), new r()));
    }
}
