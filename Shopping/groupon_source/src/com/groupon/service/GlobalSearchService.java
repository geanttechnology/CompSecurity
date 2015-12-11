// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.content.Context;
import com.groupon.http.Http;
import com.groupon.util.Function1;
import com.groupon.util.LocationsAutocompleteServiceWrapper;
import java.util.ArrayList;
import java.util.List;

public class GlobalSearchService
{

    private static final String TEXT_SUGGESTION_URL = "https:/deals/autocomplete";
    private final String LOCATION_SUGGESTION_URL = "https:/locations/autocomplete";
    private Context context;
    private LocationsAutocompleteServiceWrapper locationAutocompleteServiceWrapper;

    public GlobalSearchService()
    {
    }

    public void getLocationSuggestions(Function1 function1, Function1 function1_1, ArrayList arraylist)
    {
        (new Http("https:/locations/autocomplete", arraylist.toArray(), function1, function1_1) {

            final GlobalSearchService this$0;
            final Function1 val$exceptionListener;
            final Function1 val$successListener;

            protected void onException(Exception exception)
            {
                exceptionListener.execute(exception);
            }

            protected void onSuccess(com.groupon.models.LocationSuggestion.List list)
                throws Exception
            {
                successListener.execute(list.locationsAutocompleteResults);
            }

            protected volatile void onSuccess(Object obj)
                throws Exception
            {
                onSuccess((com.groupon.models.LocationSuggestion.List)obj);
            }

            protected boolean shouldRetry()
            {
                return false;
            }

            transient 
            {
                this$0 = GlobalSearchService.this;
                successListener = function1;
                exceptionListener = function1_1;
                super(final_context1, final_class1, s, aobj);
            }
        }).execute();
    }

    public void getTextSuggestions(Function1 function1, String s)
    {
        s = locationAutocompleteServiceWrapper.getSuggestionsRequestParameters(s);
        (new Http(com/groupon/models/SearchSuggestion$List, "https:/deals/autocomplete", s.toArray(), function1) {

            final GlobalSearchService this$0;
            final Function1 val$listener;

            protected void onException(Exception exception)
            {
            }

            protected void onSuccess(com.groupon.models.SearchSuggestion.List list)
                throws Exception
            {
                listener.execute(list.dealsAutocompleteResults);
            }

            protected volatile void onSuccess(Object obj)
                throws Exception
            {
                onSuccess((com.groupon.models.SearchSuggestion.List)obj);
            }

            transient 
            {
                this$0 = GlobalSearchService.this;
                listener = function1;
                super(final_context1, class1, s, aobj);
            }
        }).execute();
    }
}
