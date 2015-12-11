// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.getaways.search;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.binder.AnnotatedBindingBuilder;
import com.google.inject.binder.LinkedBindingBuilder;
import com.google.inject.name.Names;

// Referenced classes of package com.groupon.getaways.search:
//            GeoService, GeoServiceClient, SharedPrefsLruDestinationList

public class GetawaysSearchModule extends AbstractModule
{

    public GetawaysSearchModule()
    {
    }

    protected void configure()
    {
        bind(com/groupon/getaways/search/GeoService).to(com/groupon/getaways/search/GeoServiceClient);
        bind(new TypeLiteral() {

            final GetawaysSearchModule this$0;

            
            {
                this$0 = GetawaysSearchModule.this;
                super();
            }
        }).annotatedWith(Names.named("RECENTLY_SEARCHED_DESTINATIONS_LIST")).to(com/groupon/getaways/search/SharedPrefsLruDestinationList);
    }
}
