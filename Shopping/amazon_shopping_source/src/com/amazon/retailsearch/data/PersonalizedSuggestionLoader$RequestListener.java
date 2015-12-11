// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.data;

import com.amazon.retailsearch.android.api.log.SearchBoxLogger;
import com.amazon.searchapp.retailsearch.client.PersonalizedSuggestionsServiceCall;
import com.amazon.searchapp.retailsearch.client.web.AbstractServiceCallListener;

// Referenced classes of package com.amazon.retailsearch.data:
//            PersonalizedSuggestionLoader

private class <init> extends AbstractServiceCallListener
{

    private PersonalizedSuggestionsServiceCall serviceCall;
    final PersonalizedSuggestionLoader this$0;

    public void error(Exception exception)
    {
        PersonalizedSuggestionLoader.access$200(PersonalizedSuggestionLoader.this).searchSRDSPersonalizedISSError("Personalized ISS request error", exception, serviceCall);
    }


/*
    static PersonalizedSuggestionsServiceCall access$102(l l, PersonalizedSuggestionsServiceCall personalizedsuggestionsservicecall)
    {
        l.serviceCall = personalizedsuggestionsservicecall;
        return personalizedsuggestionsservicecall;
    }

*/

    private serviceCall()
    {
        this$0 = PersonalizedSuggestionLoader.this;
        super();
    }

    init>(init> init>)
    {
        this();
    }
}
