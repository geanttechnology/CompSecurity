// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client.suggestions;

import com.amazon.searchapp.retailsearch.client.web.ServiceCallListener;
import com.amazon.searchapp.retailsearch.model.Suggestion;
import java.util.List;

public interface SearchSuggestionsListener
    extends ServiceCallListener
{

    public abstract void suggestion(Suggestion suggestion1);

    public abstract void suggestionList(List list);
}
