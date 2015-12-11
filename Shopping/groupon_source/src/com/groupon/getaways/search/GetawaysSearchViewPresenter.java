// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.getaways.search;

import com.groupon.models.hotel.Destination;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.groupon.getaways.search:
//            GetawaysSearchView, GetawaysSearchViewLogger, GeoService, DestinationsData

public class GetawaysSearchViewPresenter
{
    private class GeoServiceDestinationsCallback
        implements GeoService.Callback
    {

        private final String query;
        final GetawaysSearchViewPresenter this$0;

        public void onDestinationsData(DestinationsData destinationsdata)
        {
            if (destinationsdata.error == null && destinationsdata.destinations != null)
            {
                cachedDestinations.put(query, destinationsdata.destinations);
                if (view != null && query.equals(state.query))
                {
                    view.showAutocompleteDestinations(destinationsdata.destinations);
                    return;
                }
            }
        }

        public GeoServiceDestinationsCallback(String s)
        {
            this$0 = GetawaysSearchViewPresenter.this;
            super();
            query = s;
        }
    }

    private static final class SearchType extends Enum
    {

        private static final SearchType $VALUES[];
        public static final SearchType BY_CURRENT_LOCATION;
        public static final SearchType BY_DESTINATION;
        public static final SearchType BY_QUERY;

        public static SearchType valueOf(String s)
        {
            return (SearchType)Enum.valueOf(com/groupon/getaways/search/GetawaysSearchViewPresenter$SearchType, s);
        }

        public static SearchType[] values()
        {
            return (SearchType[])$VALUES.clone();
        }

        static 
        {
            BY_DESTINATION = new SearchType("BY_DESTINATION", 0);
            BY_QUERY = new SearchType("BY_QUERY", 1);
            BY_CURRENT_LOCATION = new SearchType("BY_CURRENT_LOCATION", 2);
            $VALUES = (new SearchType[] {
                BY_DESTINATION, BY_QUERY, BY_CURRENT_LOCATION
            });
        }

        private SearchType(String s, int i)
        {
            super(s, i);
        }
    }

    static class State
        implements Serializable
    {

        private Date checkInDate;
        private Date checkOutDate;
        private Destination destination;
        private SearchType lastSearchType;
        private String query;
        private boolean shouldRedoLastSearch;



/*
        static Date access$002(State state1, Date date)
        {
            state1.checkInDate = date;
            return date;
        }

*/



/*
        static Date access$102(State state1, Date date)
        {
            state1.checkOutDate = date;
            return date;
        }

*/



/*
        static String access$202(State state1, String s)
        {
            state1.query = s;
            return s;
        }

*/



/*
        static Destination access$302(State state1, Destination destination1)
        {
            state1.destination = destination1;
            return destination1;
        }

*/



/*
        static SearchType access$402(State state1, SearchType searchtype)
        {
            state1.lastSearchType = searchtype;
            return searchtype;
        }

*/



/*
        static boolean access$502(State state1, boolean flag)
        {
            state1.shouldRedoLastSearch = flag;
            return flag;
        }

*/

        State()
        {
        }
    }


    private static final int MIN_QUERY_LENGTH = 3;
    public static final String RECENTLY_SEARCHED_DESTINATIONS_LIST = "RECENTLY_SEARCHED_DESTINATIONS_LIST";
    private final Map cachedDestinations = new HashMap();
    private final GeoService geoService;
    private final GetawaysSearchViewLogger logger;
    private final List recentlySearchedDestinations;
    private final State state = new State();
    private GetawaysSearchView view;

    public GetawaysSearchViewPresenter(GeoService geoservice, List list, GetawaysSearchViewLogger getawayssearchviewlogger)
    {
        geoService = geoservice;
        recentlySearchedDestinations = list;
        logger = getawayssearchviewlogger;
    }

    private void onDestinationClicked(Destination destination)
    {
        state.destination = destination;
        recentlySearchedDestinations.add(destination);
        if (view == null)
        {
            return;
        } else
        {
            view.updateRecentSearches(new ArrayList(recentlySearchedDestinations));
            view.showSearchByDestinationResults(destination, state.checkInDate, state.checkOutDate);
            state.lastSearchType = SearchType.BY_DESTINATION;
            return;
        }
    }

    private void setDates(Date date, Date date1)
    {
        state.checkInDate = date;
        state.checkOutDate = date1;
        if (view == null)
        {
            return;
        } else
        {
            view.updateDates(date, date1);
            return;
        }
    }

    public void attachView(GetawaysSearchView getawayssearchview)
    {
        view = getawayssearchview;
        getawayssearchview.updateDates(state.checkInDate, state.checkOutDate);
        if (recentlySearchedDestinations.isEmpty())
        {
            getawayssearchview.hideRecentSearches();
        } else
        {
            getawayssearchview.updateRecentSearches(new ArrayList(recentlySearchedDestinations));
            getawayssearchview.showRecentSearches();
        }
        if (state.query != null && !state.query.isEmpty())
        {
            getawayssearchview.hideRecentSearches();
            if (cachedDestinations.containsKey(state.query))
            {
                getawayssearchview.showAutocompleteDestinations((List)cachedDestinations.get(state.query));
            }
        }
    }

    public void detachView(GetawaysSearchView getawayssearchview)
    {
        if (view != getawayssearchview)
        {
            throw new IllegalArgumentException("Cannot detach a view that hasn't been attached previously");
        } else
        {
            view = null;
            return;
        }
    }

    public State getState()
    {
        return state;
    }

    public void onAutocompleteDestinationClicked(Destination destination)
    {
        logger.logAutocompleteDestinationClick(destination, state.checkInDate, state.checkOutDate);
        onDestinationClicked(destination);
    }

    public void onBackFromCalendar()
    {
        if (view == null || !state.shouldRedoLastSearch)
        {
            return;
        }
        static class _cls1
        {

            static final int $SwitchMap$com$groupon$getaways$search$GetawaysSearchViewPresenter$SearchType[];

            static 
            {
                $SwitchMap$com$groupon$getaways$search$GetawaysSearchViewPresenter$SearchType = new int[SearchType.values().length];
                try
                {
                    $SwitchMap$com$groupon$getaways$search$GetawaysSearchViewPresenter$SearchType[SearchType.BY_DESTINATION.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$groupon$getaways$search$GetawaysSearchViewPresenter$SearchType[SearchType.BY_QUERY.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$groupon$getaways$search$GetawaysSearchViewPresenter$SearchType[SearchType.BY_CURRENT_LOCATION.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.groupon.getaways.search.GetawaysSearchViewPresenter.SearchType[state.lastSearchType.ordinal()];
        JVM INSTR tableswitch 1 3: default 60
    //                   1 70
    //                   2 103
    //                   3 110;
           goto _L1 _L2 _L3 _L4
_L1:
        state.shouldRedoLastSearch = false;
        return;
_L2:
        view.showSearchByDestinationResults(state.destination, state.checkInDate, state.checkOutDate);
        continue; /* Loop/switch isn't completed */
_L3:
        onSearch();
        continue; /* Loop/switch isn't completed */
_L4:
        view.showSearchByCurrentLocationResults(state.checkInDate, state.checkOutDate);
        if (true) goto _L1; else goto _L5
_L5:
    }

    public void onBackFromCalendar(Date date, Date date1)
    {
        setDates(date, date1);
        onBackFromCalendar();
    }

    public void onCurrentLocationClicked()
    {
        if (view == null)
        {
            return;
        } else
        {
            logger.logCurrentLocationClick(state.checkInDate, state.checkOutDate);
            view.showSearchByCurrentLocationResults(state.checkInDate, state.checkOutDate);
            state.lastSearchType = SearchType.BY_CURRENT_LOCATION;
            return;
        }
    }

    public void onDatesSelectorClicked()
    {
        if (view == null)
        {
            return;
        } else
        {
            logger.logDateSelectorClick();
            view.showCalendar(state.checkInDate, state.checkOutDate);
            return;
        }
    }

    public void onQueryChanged(String s)
    {
        int i;
        state.query = s;
        if (s != null)
        {
            i = s.length();
        } else
        {
            i = 0;
        }
        if (i != 0) goto _L2; else goto _L1
_L1:
        if (view != null) goto _L4; else goto _L3
_L3:
        return;
_L4:
        if (!recentlySearchedDestinations.isEmpty())
        {
            view.showRecentSearches();
        }
        view.clearAutocompleteDestinations();
        return;
_L2:
        if (i < 3) goto _L3; else goto _L5
_L5:
        if (cachedDestinations.containsKey(s))
        {
            continue; /* Loop/switch isn't completed */
        }
        geoService.destinations(s, new GeoServiceDestinationsCallback(s));
        if (view == null) goto _L3; else goto _L6
_L6:
        view.hideRecentSearches();
        return;
        if (view == null) goto _L3; else goto _L7
_L7:
        view.hideRecentSearches();
        s = (List)cachedDestinations.get(s);
        view.showAutocompleteDestinations(s);
        return;
    }

    public void onRecentlySearchedDestinationClicked(Destination destination)
    {
        logger.logRecentlySearchedDestinationClick(destination, state.checkInDate, state.checkOutDate);
        onDestinationClicked(destination);
    }

    public void onSearch()
    {
        if (view == null)
        {
            return;
        }
        if (state.query == null)
        {
            view.showEmptyQueryWarning();
            return;
        }
        if (cachedDestinations.containsKey(state.query))
        {
            Object obj = (List)cachedDestinations.get(state.query);
            if (((List) (obj)).isEmpty())
            {
                view.showSearchByQueryResults(state.query);
                state.lastSearchType = SearchType.BY_QUERY;
                return;
            }
            obj = (Destination)((List) (obj)).get(0);
            state.destination = ((Destination) (obj));
            logger.logFreeSearchWithDestinationsAvailable(((Destination) (obj)), state.checkInDate, state.checkOutDate);
            if (state.checkInDate != null && state.checkOutDate != null)
            {
                view.showSearchByDestinationResults(((Destination) (obj)), state.checkInDate, state.checkOutDate);
                state.lastSearchType = SearchType.BY_DESTINATION;
                return;
            } else
            {
                view.showSearchByQueryResults(state.query);
                state.lastSearchType = SearchType.BY_QUERY;
                return;
            }
        } else
        {
            view.showSearchByQueryResults(state.query);
            state.lastSearchType = SearchType.BY_QUERY;
            return;
        }
    }

    public void onSearchNearbyTonight()
    {
        if (view == null)
        {
            return;
        } else
        {
            Object obj = Calendar.getInstance();
            ((Calendar) (obj)).set(11, 0);
            ((Calendar) (obj)).set(12, 0);
            ((Calendar) (obj)).set(13, 0);
            ((Calendar) (obj)).set(14, 0);
            Date date = ((Calendar) (obj)).getTime();
            ((Calendar) (obj)).add(5, 1);
            obj = ((Calendar) (obj)).getTime();
            setDates(date, ((Date) (obj)));
            view.showSearchByCurrentLocationResults(date, ((Date) (obj)));
            state.lastSearchType = SearchType.BY_CURRENT_LOCATION;
            return;
        }
    }

    public void onShowCalendarRequestedFromSearchResults()
    {
        if (view == null)
        {
            return;
        } else
        {
            view.showCalendar(state.checkInDate, state.checkOutDate);
            state.shouldRedoLastSearch = true;
            return;
        }
    }

    public void setState(State state1)
    {
        setDates(state1.checkInDate, state1.checkOutDate);
        onQueryChanged(state1.query);
        state.destination = state1.destination;
        state.lastSearchType = state1.lastSearchType;
        state.shouldRedoLastSearch = state1.shouldRedoLastSearch;
    }



}
