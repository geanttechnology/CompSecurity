// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.fastBrowse;

import com.amazon.retailsearch.client.AndroidRetailSearchClient;
import com.amazon.retailsearch.log.AppLog;
import com.amazon.retailsearch.log.MessageLogger;
import com.amazon.searchapp.retailsearch.client.RefinementsServiceCall;
import com.amazon.searchapp.retailsearch.client.RetailSearchClient;
import com.amazon.searchapp.retailsearch.client.web.AbstractServiceCallListener;
import com.amazon.searchapp.retailsearch.model.SearchResult;
import java.io.IOException;

public class RefinementsLoader
{
    public static interface RefinementResultListener
    {

        public abstract void onError(Exception exception);

        public abstract void onResult(SearchResult searchresult);
    }

    private class RequestListener extends AbstractServiceCallListener
    {

        final RefinementsLoader this$0;

        public void endRequest()
        {
        }

        public void error(Exception exception)
        {
            RefinementsLoader.log.error("Refinements request ended with an exception", exception);
            listener.onError(exception);
        }

        public void result(SearchResult searchresult)
        {
            if (searchresult == null || searchresult.getRefinements() == null)
            {
                RefinementsLoader.log.error("RefinementsLoader result came back null");
            }
            listener.onResult(searchresult);
        }

        public volatile void result(Object obj)
        {
            result((SearchResult)obj);
        }

        public void startRequest()
        {
        }

        private RequestListener()
        {
            this$0 = RefinementsLoader.this;
            super();
        }

    }


    private static final MessageLogger log = AppLog.getLog(com/amazon/retailsearch/android/fastBrowse/RefinementsLoader);
    private final RefinementResultListener listener;
    private String path;

    public RefinementsLoader(RefinementResultListener refinementresultlistener, String s)
    {
        listener = refinementresultlistener;
        path = s;
    }

    public void getRefinements()
    {
        RefinementsServiceCall refinementsservicecall = AndroidRetailSearchClient.getClient().refinements(new RequestListener(), path);
        try
        {
            refinementsservicecall.execute();
            return;
        }
        catch (IOException ioexception)
        {
            log.error("Could not load refinements", ioexception);
        }
    }



}
