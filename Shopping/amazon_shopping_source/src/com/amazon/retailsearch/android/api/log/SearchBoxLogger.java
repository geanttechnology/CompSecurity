// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.api.log;

import com.amazon.searchapp.retailsearch.client.PersonalizedSuggestionsServiceCall;
import java.util.Map;

public interface SearchBoxLogger
{

    public abstract void recordEntryVoiceInvoked();

    public abstract void recordFlowInvoked();

    public abstract void recordQueryBuilderUsage();

    public abstract void recordRecentSearchCleared();

    public abstract void recordScanItInvoked();

    public abstract void recordSnapItInvoked();

    public abstract void searchSRDSPersonalizedISSError(String s, Throwable throwable, PersonalizedSuggestionsServiceCall personalizedsuggestionsservicecall);

    public abstract void searchSuggestionsEngagment(Map map);

    public abstract void searchSuggestionsFirstEntryShowed();

    public abstract void searchSuggestionsFirstKeyStroke();
}
