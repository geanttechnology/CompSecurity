// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.metrics;

import com.amazon.retailsearch.android.api.log.SearchBoxLogger;
import com.amazon.searchapp.retailsearch.client.PersonalizedSuggestionsServiceCall;
import java.util.Map;

public class NullSearchBoxLogger
    implements SearchBoxLogger
{

    public NullSearchBoxLogger()
    {
    }

    public void recordEntryVoiceInvoked()
    {
    }

    public void recordFlowInvoked()
    {
    }

    public void recordQueryBuilderUsage()
    {
    }

    public void recordRecentSearchCleared()
    {
    }

    public void recordScanItInvoked()
    {
    }

    public void recordSnapItInvoked()
    {
    }

    public void searchSRDSPersonalizedISSError(String s, Throwable throwable, PersonalizedSuggestionsServiceCall personalizedsuggestionsservicecall)
    {
    }

    public void searchSuggestionsEngagment(Map map)
    {
    }

    public void searchSuggestionsFirstEntryShowed()
    {
    }

    public void searchSuggestionsFirstKeyStroke()
    {
    }
}
