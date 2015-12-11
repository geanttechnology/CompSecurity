// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.advert.d;

import com.shazam.b.a.a;
import com.shazam.model.store.AvailableProviders;
import com.shazam.o.k;
import com.shazam.server.response.config.Advertising;
import com.shazam.server.response.config.AmpConfig;
import com.shazam.server.response.config.Provider;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.shazam.android.advert.d:
//            d

public final class c
    implements a
{

    public c()
    {
    }

    private static Provider a()
    {
        return com.shazam.server.response.config.Provider.Builder.provider().withName("No_Ads_Enabled").withSites(com.shazam.android.advert.d.d.a("0")).build();
    }

    private static Provider a(Provider provider, Provider provider1, boolean flag)
    {
        Provider provider2 = provider;
        if ("No_Ads_Enabled".equals(provider.getName()))
        {
            provider2 = provider;
            if (flag)
            {
                provider2 = provider;
                if (k.a(provider1.getSites()))
                {
                    provider2 = provider1;
                }
            }
        }
        return provider2;
    }

    private static boolean a(Provider provider, String s)
    {
        return s.equals(provider.getName());
    }

    public final Object a(Object obj)
    {
        Object obj1 = (AmpConfig)obj;
        Provider provider1 = a();
        Provider provider = a();
        obj = a();
        for (obj1 = ((AmpConfig) (obj1)).getAdvertising().getProviders().iterator(); ((Iterator) (obj1)).hasNext();)
        {
            Provider provider2 = (Provider)((Iterator) (obj1)).next();
            provider1 = a(provider1, provider2, "appnexus".equals(provider2.getName()));
            provider = a(provider, provider2, a(provider2, "facebook"));
            obj = a(((Provider) (obj)), provider2, a(provider2, "adcolony"));
        }

        obj1 = com.shazam.model.store.AvailableProviders.Builder.a();
        obj1.primary = provider1;
        obj1.facebook = provider;
        obj1.adColony = ((Provider) (obj));
        return new AvailableProviders(((com.shazam.model.store.AvailableProviders.Builder) (obj1)), null);
    }
}
