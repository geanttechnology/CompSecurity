// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.e.a.a;

import com.target.mothership.services.f.a.c;
import com.target.mothership.services.f.a.e;

public class a extends e
{

    private static final c APP_CONFIG_ENDPOINT;

    public a(com.target.mothership.services.f.b.a a1)
    {
        super(a1);
    }

    public com.target.mothership.services.f.a.b.b a()
    {
        return a(APP_CONFIG_ENDPOINT, null, null, null, null);
    }

    static 
    {
        APP_CONFIG_ENDPOINT = new c(com.target.mothership.services.f.a.d.a.GET, com.target.mothership.services.f.b.a.TGTAppData, "/v1/config/android");
    }
}
