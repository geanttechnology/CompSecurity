// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.data.sims;

import com.amazon.retailsearch.client.AndroidRetailSearchClient;
import com.amazon.retailsearch.log.AppLog;
import com.amazon.retailsearch.log.MessageLogger;
import com.amazon.searchapp.retailsearch.client.RetailSearchClient;
import com.amazon.searchapp.retailsearch.client.SimsServiceCall;
import com.amazon.searchapp.retailsearch.client.web.AbstractServiceCallListener;
import java.io.IOException;

public class SimilaritiesLoader
{

    private static final MessageLogger log = AppLog.getLog(com/amazon/retailsearch/data/sims/SimilaritiesLoader);

    public SimilaritiesLoader()
    {
    }

    public void getSims(AbstractServiceCallListener abstractservicecalllistener, String s)
    {
        s = AndroidRetailSearchClient.getClient().similarities(abstractservicecalllistener, s);
        try
        {
            s.execute();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            log.error(s.getMessage());
        }
        abstractservicecalllistener.error(s);
    }

}
