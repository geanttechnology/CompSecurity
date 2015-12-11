// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.e.g.a;

import com.google.a.a.e;
import com.target.mothership.common.params.RegistryDetailsParam;
import com.target.mothership.common.registries.RegistryId;
import com.target.mothership.common.registries.h;
import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.model.store.interfaces.Store;
import com.target.mothership.services.f.a.b;
import com.target.mothership.services.f.a.c;
import java.util.Map;

public class a extends b
{

    private static final com.target.mothership.services.f.a.b.a CHANNEL = new com.target.mothership.services.f.a.b.a("channel");
    private static final com.target.mothership.services.f.a.b.a INCLUDE_ITEMS = new com.target.mothership.services.f.a.b.a("includeItems");
    private static final com.target.mothership.services.f.a.b.a LIMIT = new com.target.mothership.services.f.a.b.a("limit");
    private static final com.target.mothership.services.f.a.b.a OFFSET = new com.target.mothership.services.f.a.b.a("offset");
    private static c REGISTRY_DETAIL;
    private static final com.target.mothership.services.f.a.b.a REGISTRY_ID = new com.target.mothership.services.f.a.b.a("registry-id");
    private static final com.target.mothership.services.f.a.b.a STORE_ID = new com.target.mothership.services.f.a.b.a("storeId");
    private static final com.target.mothership.services.f.a.b.a SUB_CHANNEL = new com.target.mothership.services.f.a.b.a("subchannel");

    public a(com.target.mothership.services.f.b.a a1)
    {
        super(a1);
    }

    public com.target.mothership.services.f.a.b.b a(RegistryDetailsParam registrydetailsparam)
    {
        android.support.v4.f.a a1 = new android.support.v4.f.a();
        a1.put(REGISTRY_ID.b(), registrydetailsparam.b().a());
        android.support.v4.f.a a2 = new android.support.v4.f.a();
        if (registrydetailsparam.a().b())
        {
            a2.put(STORE_ID.a(), ((Store)registrydetailsparam.a().c()).getStoreId().a());
        }
        a2.put(CHANNEL.a(), registrydetailsparam.c().toString());
        a2.put(SUB_CHANNEL.a(), registrydetailsparam.d().toString());
        a2.put(INCLUDE_ITEMS.a(), registrydetailsparam.g());
        a2.put(OFFSET.a(), Integer.toString(registrydetailsparam.f()));
        a2.put(LIMIT.a(), Integer.toString(registrydetailsparam.e()));
        return a(REGISTRY_DETAIL, null, ((Map) (a1)), ((Map) (a2)), null);
    }

    static 
    {
        REGISTRY_DETAIL = new c(com.target.mothership.services.f.a.d.a.GET, com.target.mothership.services.f.b.a.TGTAppData, "/v1/registry/view/{registry-id}");
    }
}
