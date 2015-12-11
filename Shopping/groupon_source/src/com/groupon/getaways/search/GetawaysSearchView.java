// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.getaways.search;

import com.groupon.models.hotel.Destination;
import java.util.Date;
import java.util.List;

public interface GetawaysSearchView
{

    public abstract void clearAutocompleteDestinations();

    public abstract void hideRecentSearches();

    public abstract void showAutocompleteDestinations(List list);

    public abstract void showCalendar(Date date, Date date1);

    public abstract void showEmptyQueryWarning();

    public abstract void showRecentSearches();

    public abstract void showSearchByCurrentLocationResults(Date date, Date date1);

    public abstract void showSearchByDestinationResults(Destination destination, Date date, Date date1);

    public abstract void showSearchByQueryResults(String s);

    public abstract void updateDates(Date date, Date date1);

    public abstract void updateRecentSearches(List list);
}
