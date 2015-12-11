// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client;

import com.amazon.searchapp.retailsearch.client.airstream.AirstreamFavoritesRequest;
import com.amazon.searchapp.retailsearch.client.airstream.AirstreamFavoritesServiceCall;
import com.amazon.searchapp.retailsearch.client.airstream.AirstreamRequest;
import com.amazon.searchapp.retailsearch.client.airstream.AirstreamServiceCall;
import com.amazon.searchapp.retailsearch.client.favorites.AddFavoritesRequest;
import com.amazon.searchapp.retailsearch.client.favorites.AddFavoritesServiceCall;
import com.amazon.searchapp.retailsearch.client.favorites.RemoveFavoritesRequest;
import com.amazon.searchapp.retailsearch.client.favorites.RemoveFavoritesServiceCall;
import com.amazon.searchapp.retailsearch.client.web.ServiceCallListener;

// Referenced classes of package com.amazon.searchapp.retailsearch.client:
//            SearchListener, SearchServiceCall, AssetsServiceCall, LocationServiceCall, 
//            MetricsServiceCall, PersonalizedSuggestionsServiceCall, RefinementsServiceCall, SearchRequest, 
//            SimsServiceCall

public interface RetailSearchClientApi
{

    public abstract AddFavoritesServiceCall addFavorites(AddFavoritesRequest addfavoritesrequest);

    public abstract AddFavoritesServiceCall addFavorites(AddFavoritesRequest addfavoritesrequest, ServiceCallListener servicecalllistener);

    public abstract AirstreamServiceCall airstream(AirstreamRequest airstreamrequest);

    public abstract AirstreamServiceCall airstream(AirstreamRequest airstreamrequest, SearchListener searchlistener);

    public abstract AirstreamFavoritesServiceCall airstreamFavorites(AirstreamFavoritesRequest airstreamfavoritesrequest);

    public abstract AirstreamFavoritesServiceCall airstreamFavorites(AirstreamFavoritesRequest airstreamfavoritesrequest, SearchListener searchlistener);

    public abstract SearchServiceCall aliasKeywordSearch(String s, String s1);

    public abstract SearchServiceCall aliasKeywordSearch(String s, String s1, SearchListener searchlistener);

    public abstract AssetsServiceCall assets();

    public abstract AssetsServiceCall assets(ServiceCallListener servicecalllistener);

    public abstract SearchServiceCall keywordSearch(String s);

    public abstract SearchServiceCall keywordSearch(String s, SearchListener searchlistener);

    public abstract LocationServiceCall location(ServiceCallListener servicecalllistener, String s);

    public abstract MetricsServiceCall metrics();

    public abstract MetricsServiceCall metrics(ServiceCallListener servicecalllistener);

    public abstract PersonalizedSuggestionsServiceCall personalizedSuggestions();

    public abstract PersonalizedSuggestionsServiceCall personalizedSuggestions(ServiceCallListener servicecalllistener);

    public abstract PersonalizedSuggestionsServiceCall personalizedSuggestions(String s, String s1, ServiceCallListener servicecalllistener);

    public abstract RefinementsServiceCall refinements();

    public abstract RefinementsServiceCall refinements(ServiceCallListener servicecalllistener, String s);

    public abstract RemoveFavoritesServiceCall removeFavorites(RemoveFavoritesRequest removefavoritesrequest);

    public abstract RemoveFavoritesServiceCall removeFavorites(RemoveFavoritesRequest removefavoritesrequest, ServiceCallListener servicecalllistener);

    public abstract SearchServiceCall search(SearchRequest searchrequest);

    public abstract SearchServiceCall search(SearchRequest searchrequest, SearchListener searchlistener);

    public abstract SimsServiceCall similarities(ServiceCallListener servicecalllistener, String s, int i, String s1);
}
