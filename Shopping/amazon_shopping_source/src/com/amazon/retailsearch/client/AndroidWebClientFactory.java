// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.client;

import com.amazon.retailsearch.android.api.experimentation.FeatureConfiguration;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.searchapp.retailsearch.client.web.WebClient;
import com.amazon.searchapp.retailsearch.client.web.WebClientFactory;
import com.amazon.searchapp.retailsearch.client.web.apache40.ApacheWebClient;
import com.amazon.searchapp.retailsearch.client.web.jnet.NetWebClient;

public class AndroidWebClientFactory
    implements WebClientFactory
{

    FeatureConfiguration featureConfig;

    public AndroidWebClientFactory()
    {
        RetailSearchDaggerGraphController.inject(this);
    }

    public WebClient getWebClient()
    {
        if (featureConfig != null && "T1".equals(featureConfig.getFeatureState("SX_Shop_Android_Web_Client_GTE_5.1")))
        {
            return new NetWebClient();
        } else
        {
            return new ApacheWebClient();
        }
    }
}
