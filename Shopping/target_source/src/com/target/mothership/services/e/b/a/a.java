// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.e.b.a;

import com.target.mothership.services.f.a.c;
import com.target.mothership.services.f.a.e;

public class a extends e
{

    private static final c ALL_ADJACENCIES;

    public a(com.target.mothership.services.f.b.a a1)
    {
        super(a1);
    }

    public com.target.mothership.services.f.a.b.b a()
    {
        return a(ALL_ADJACENCIES, null, null, null, null);
    }

    static 
    {
        ALL_ADJACENCIES = new c(com.target.mothership.services.f.a.d.a.GET, com.target.mothership.services.f.b.a.TGTAppData, "/v1/indoor-location/adjacencies.json");
    }
}
