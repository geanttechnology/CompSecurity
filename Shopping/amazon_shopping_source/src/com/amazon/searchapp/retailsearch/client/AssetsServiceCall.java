// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client;

import com.amazon.searchapp.retailsearch.client.web.HttpMethod;
import com.amazon.searchapp.retailsearch.client.web.ServiceCallListener;
import com.amazon.searchapp.retailsearch.model.Assets;

// Referenced classes of package com.amazon.searchapp.retailsearch.client:
//            RetailSearchServiceCall, RetailSearchClient

public class AssetsServiceCall extends RetailSearchServiceCall
{

    public AssetsServiceCall(RetailSearchClient retailsearchclient, ServiceCallListener servicecalllistener)
    {
        super(retailsearchclient, servicecalllistener, HttpMethod.GET.getName(), "/s/assets/", com/amazon/searchapp/retailsearch/model/Assets);
    }
}
