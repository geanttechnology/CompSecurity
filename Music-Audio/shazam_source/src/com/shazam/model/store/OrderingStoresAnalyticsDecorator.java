// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.store;

import com.shazam.b.a.a;
import com.shazam.model.configuration.StoresConfiguration;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.shazam.model.store:
//            StoresAnalyticsDecorator, StoreActionsMerger, StoreOrderingDecider, Stores, 
//            Store, StoreChoice, StoreAnalyticsInfo, ParameterizedStores

public class OrderingStoresAnalyticsDecorator
    implements StoresAnalyticsDecorator
{

    private final StoreActionsMerger storeActionsMerger;
    private final a storeChoiceToBuyButtonUrlConverter;
    private final StoreOrderingDecider storeOrderingDecider;
    private final StoresConfiguration storesConfiguration;

    public OrderingStoresAnalyticsDecorator(StoresConfiguration storesconfiguration, StoreOrderingDecider storeorderingdecider, a a1, StoreActionsMerger storeactionsmerger)
    {
        storesConfiguration = storesconfiguration;
        storeOrderingDecider = storeorderingdecider;
        storeChoiceToBuyButtonUrlConverter = a1;
        storeActionsMerger = storeactionsmerger;
    }

    public final Stores a(ParameterizedStores parameterizedstores, StoreAnalyticsInfo storeanalyticsinfo)
    {
        Stores.Builder builder;
        Iterator iterator;
        parameterizedstores = storeActionsMerger.a(parameterizedstores);
        parameterizedstores = storeOrderingDecider.a(parameterizedstores).stores;
        builder = com.shazam.model.store.Stores.Builder.a();
        iterator = parameterizedstores.iterator();
_L2:
        String s;
        Object obj;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = (Store)iterator.next();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_255;
        }
        parameterizedstores = storesConfiguration.a(((Store) (obj)).key);
        if (parameterizedstores == null)
        {
            break MISSING_BLOCK_LABEL_255;
        }
        s = ((StoreChoice) (parameterizedstores)).id;
        parameterizedstores = (String)storeChoiceToBuyButtonUrlConverter.a(parameterizedstores);
_L3:
        if (obj == null || parameterizedstores == null || ((Store) (obj)).intents.isEmpty())
        {
            builder.a(null);
        } else
        {
            obj = com.shazam.model.store.Store.Builder.a(((Store) (obj)));
            obj.iconUrl = parameterizedstores;
            obj.screenOrigin = storeanalyticsinfo.origin;
            obj.providerName = s;
            obj.cardType = storeanalyticsinfo.cardType;
            obj.eventId = storeanalyticsinfo.eventId;
            obj.screenName = storeanalyticsinfo.screenName;
            obj.trackCategory = storeanalyticsinfo.trackCategory;
            obj.trackStyle = storeanalyticsinfo.trackStyle;
            obj.trackId = storeanalyticsinfo.trackId;
            obj.beaconKey = storeanalyticsinfo.beaconKey;
            obj.campaign = storeanalyticsinfo.campaign;
            builder.a(((Store.Builder) (obj)).b());
        }
        if (true) goto _L2; else goto _L1
_L1:
        return builder.b();
        parameterizedstores = null;
        s = null;
          goto _L3
    }
}
