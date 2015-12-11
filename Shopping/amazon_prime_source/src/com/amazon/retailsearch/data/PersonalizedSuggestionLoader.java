// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.data;

import android.text.TextUtils;
import com.amazon.retailsearch.android.api.log.RetailSearchLoggingProvider;
import com.amazon.retailsearch.android.api.log.SearchBoxLogger;
import com.amazon.retailsearch.client.AndroidRetailSearchClient;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.searchapp.retailsearch.client.PersonalizedSuggestionsServiceCall;
import com.amazon.searchapp.retailsearch.client.RetailSearchClient;
import com.amazon.searchapp.retailsearch.client.web.AbstractServiceCallListener;
import com.amazon.searchapp.retailsearch.model.PersonalizedSuggestions;
import com.amazon.searchapp.retailsearch.model.PersonalizedSuggestionsResult;
import java.io.IOException;

public class PersonalizedSuggestionLoader
{
    private class RequestListener extends AbstractServiceCallListener
    {

        private PersonalizedSuggestionsServiceCall serviceCall;
        final PersonalizedSuggestionLoader this$0;

        public void error(Exception exception)
        {
            searchBoxLogger.searchSRDSPersonalizedISSError("Personalized ISS request error", exception, serviceCall);
        }


/*
        static PersonalizedSuggestionsServiceCall access$102(RequestListener requestlistener, PersonalizedSuggestionsServiceCall personalizedsuggestionsservicecall)
        {
            requestlistener.serviceCall = personalizedsuggestionsservicecall;
            return personalizedsuggestionsservicecall;
        }

*/

        private RequestListener()
        {
            this$0 = PersonalizedSuggestionLoader.this;
            super();
        }

    }


    private String clientID;
    private SearchBoxLogger searchBoxLogger;

    public PersonalizedSuggestionLoader()
    {
        searchBoxLogger = RetailSearchLoggingProvider.getInstance().getSearchBoxLogger();
        RetailSearchDaggerGraphController.inject(this);
    }

    public PersonalizedSuggestions deletePersonalizedSuggestions(String s, String s1)
    {
        if (!TextUtils.isEmpty(s) && !TextUtils.isEmpty(s1)) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        RequestListener requestlistener;
        RetailSearchClient retailsearchclient = AndroidRetailSearchClient.getClient();
        requestlistener = new RequestListener();
        s = retailsearchclient.personalizedSuggestions(s, s1, requestlistener);
        if (s == null) goto _L1; else goto _L3
_L3:
        requestlistener.serviceCall = s;
        try
        {
            s = (PersonalizedSuggestionsResult)s.execute();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        if (s == null) goto _L1; else goto _L4
_L4:
        s = s.getSearchSuggestion();
        return s;
    }

    public String getClientID()
    {
        return clientID;
    }

    public PersonalizedSuggestions getPersonalizedSuggestions()
    {
        Object obj = AndroidRetailSearchClient.getClient().personalizedSuggestions(new RequestListener());
        if (obj != null) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        try
        {
            obj = (PersonalizedSuggestionsResult)((PersonalizedSuggestionsServiceCall) (obj)).execute();
        }
        catch (IOException ioexception)
        {
            return null;
        }
        if (obj == null) goto _L1; else goto _L3
_L3:
        obj = ((PersonalizedSuggestionsResult) (obj)).getSearchSuggestion();
        return ((PersonalizedSuggestions) (obj));
    }

    public PersonalizedSuggestionLoader setClientID(String s)
    {
        clientID = s;
        return this;
    }

}
