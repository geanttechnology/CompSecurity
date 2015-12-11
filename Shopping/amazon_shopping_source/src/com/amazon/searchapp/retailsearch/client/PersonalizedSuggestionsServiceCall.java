// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client;

import com.amazon.searchapp.retailsearch.client.web.CollectionMap;
import com.amazon.searchapp.retailsearch.client.web.HttpMethod;
import com.amazon.searchapp.retailsearch.client.web.ServiceCallListener;
import com.amazon.searchapp.retailsearch.model.PersonalizedSuggestionsResult;

// Referenced classes of package com.amazon.searchapp.retailsearch.client:
//            RetailSearchServiceCall, RetailSearchClient

public class PersonalizedSuggestionsServiceCall extends RetailSearchServiceCall
{

    private String deleteParamK;
    private String deleteParamR;

    public PersonalizedSuggestionsServiceCall(RetailSearchClient retailsearchclient, ServiceCallListener servicecalllistener)
    {
        super(retailsearchclient, servicecalllistener, HttpMethod.GET.getName(), "/s/suggestions", com/amazon/searchapp/retailsearch/model/PersonalizedSuggestionsResult);
    }

    public PersonalizedSuggestionsServiceCall(RetailSearchClient retailsearchclient, String s, String s1, ServiceCallListener servicecalllistener)
    {
        super(retailsearchclient, servicecalllistener, HttpMethod.GET.getName(), "/s/suggestions", com/amazon/searchapp/retailsearch/model/PersonalizedSuggestionsResult);
        deleteParamR = s;
        deleteParamK = s1;
    }

    protected void buildParameters(CollectionMap collectionmap)
    {
        if (deleteParamR != null)
        {
            collectionmap.set("r", deleteParamR);
        }
        if (deleteParamK != null)
        {
            collectionmap.set("k", deleteParamK);
        }
        super.buildParameters(collectionmap);
    }
}
