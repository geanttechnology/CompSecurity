// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.getaways.search;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Resources;
import android.location.Location;
import android.os.Bundle;
import android.text.Spannable;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.ButterKnife;
import com.google.inject.Injector;
import com.groupon.Channel;
import com.groupon.abtest.SearchAbTestHelper;
import com.groupon.activity.GlobalSearchResult;
import com.groupon.activity.HotelSearchCalendarActivity;
import com.groupon.models.Place;
import com.groupon.models.hotel.Destination;
import com.groupon.service.LocationService;
import com.groupon.util.GlobalSearchUtil;
import com.groupon.util.MarketRateUtil;
import com.groupon.util.ViewUtils;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.apmem.tools.layouts.FlowLayout;
import roboguice.RoboGuice;

// Referenced classes of package com.groupon.getaways.search:
//            GetawaysSearchView, DestinationsAdapter, GetawaysSearchViewPresenter

public class GetawaysSearchFragment extends Fragment
    implements GetawaysSearchView
{
    private class OnAutocompleteListViewItemClickListener
        implements android.widget.AdapterView.OnItemClickListener
    {

        final GetawaysSearchFragment this$0;

        public void onItemClick(AdapterView adapterview, View view, int i, long l)
        {
            adapterview = destinationsAdapter.getItem(i);
            if (destinationsAdapter.isCurrentLocationPosition(i))
            {
                presenter.onCurrentLocationClicked();
                return;
            } else
            {
                presenter.onAutocompleteDestinationClicked(adapterview);
                return;
            }
        }

        private OnAutocompleteListViewItemClickListener()
        {
            this$0 = GetawaysSearchFragment.this;
            super();
        }

    }

    private class OnDatesSelectorClickListener
        implements android.view.View.OnClickListener
    {

        final GetawaysSearchFragment this$0;

        public void onClick(View view)
        {
            presenter.onDatesSelectorClicked();
        }

        private OnDatesSelectorClickListener()
        {
            this$0 = GetawaysSearchFragment.this;
            super();
        }

    }

    private class OnRecentSearchesScrollViewTouchListener
        implements android.view.View.OnTouchListener
    {

        final GetawaysSearchFragment this$0;

        public boolean onTouch(View view, MotionEvent motionevent)
        {
            ViewUtils.setSoftKeyboardState(getActivity(), true, recentSearchesScrollView);
            return false;
        }

        private OnRecentSearchesScrollViewTouchListener()
        {
            this$0 = GetawaysSearchFragment.this;
            super();
        }

    }

    private class OnRecentlySearchedDestinationClickListener
        implements android.view.View.OnClickListener
    {

        private final Destination destination;
        final GetawaysSearchFragment this$0;

        public void onClick(View view)
        {
            presenter.onRecentlySearchedDestinationClicked(destination);
        }

        private OnRecentlySearchedDestinationClickListener(Destination destination1)
        {
            this$0 = GetawaysSearchFragment.this;
            super();
            destination = destination1;
        }

    }

    public static class PresenterHolderFragment extends Fragment
    {

        private GetawaysSearchViewPresenter presenter;

        public GetawaysSearchViewPresenter getPresenter()
        {
            return presenter;
        }

        public void onCreate(Bundle bundle)
        {
            super.onCreate(bundle);
            setRetainInstance(true);
        }

        public void setPresenter(GetawaysSearchViewPresenter getawayssearchviewpresenter)
        {
            presenter = getawayssearchviewpresenter;
        }

        public PresenterHolderFragment()
        {
        }
    }


    private static final int GETAWAYS_SEARCH_CALENDAR_ACTIVITY = 1;
    private static final int GETAWAYS_SEARCH_RESULTS_ACTIVITY = 2;
    private static final String PRESENTER_HOLDER_FRAGMENT_TAG = "presenterHolderFragmentTag";
    private static final String PRESENTER_STATE = "presenterState";
    private static final String QUERY = "query";
    private static final String SEARCH_NEARBY_TONIGHT_RESULTS_ALREADY_SHOWN = "searchNearbyTonightResultsAlreadyShown";
    private static final String SHOW_SEARCH_NEARBY_TONIGHT_RESULTS = "showSearchNearbyTonightResults";
    ListView autocompleteListView;
    View datesSelector;
    TextView datesSelectorTextView;
    private DestinationsAdapter destinationsAdapter;
    private GlobalSearchUtil globalSearchUtil;
    private boolean isGlobalSearchRedesign1505;
    private LocationService locationService;
    View oldRecentSearchesContainer;
    LinearLayout oldRecentSearchesView;
    String optional;
    private GetawaysSearchViewPresenter presenter;
    View recentSearchesContainer;
    ScrollView recentSearchesScrollView;
    FlowLayout recentSearchesView;
    private SearchAbTestHelper searchAbTestHelper;
    private boolean searchNearbyTonightResultsAlreadyShown;
    String selectDates;
    private Spannable selectDatesOptional;

    public GetawaysSearchFragment()
    {
    }

    public static GetawaysSearchFragment newInstance(String s)
    {
        return newInstance(s, false);
    }

    private static GetawaysSearchFragment newInstance(String s, boolean flag)
    {
        GetawaysSearchFragment getawayssearchfragment = new GetawaysSearchFragment();
        Bundle bundle = new Bundle();
        bundle.putString("query", s);
        bundle.putBoolean("showSearchNearbyTonightResults", flag);
        getawayssearchfragment.setArguments(bundle);
        return getawayssearchfragment;
    }

    public static GetawaysSearchFragment newInstanceWithSearchNearbyTonightResults()
    {
        return newInstance(null, true);
    }

    private void setRecentSearchesVisible(boolean flag)
    {
        boolean flag1 = false;
        int i = 0;
        if (isGlobalSearchRedesign1505)
        {
            View view = oldRecentSearchesContainer;
            if (!flag)
            {
                i = 8;
            }
            view.setVisibility(i);
            return;
        }
        View view1 = recentSearchesContainer;
        if (flag)
        {
            i = ((flag1) ? 1 : 0);
        } else
        {
            i = 8;
        }
        view1.setVisibility(i);
    }

    private void setUpDatesSelectorView()
    {
        datesSelector.setOnClickListener(new OnDatesSelectorClickListener());
        selectDatesOptional = android.text.Spannable.Factory.getInstance().newSpannable(String.format("%s %s", new Object[] {
            selectDates, optional
        }));
        selectDatesOptional.setSpan(new ForegroundColorSpan(getResources().getColor(0x7f0e00c2)), 0, selectDates.length(), 18);
        selectDatesOptional.setSpan(new StyleSpan(1), 0, selectDates.length(), 18);
    }

    private void setUpDestinationsView()
    {
        autocompleteListView.setDivider(getResources().getDrawable(0x7f020246));
        autocompleteListView.addFooterView(new View(getActivity()), null, false);
        autocompleteListView.setAdapter(destinationsAdapter);
        autocompleteListView.setOnItemClickListener(new OnAutocompleteListViewItemClickListener());
    }

    private void setUpRecentSearchesView()
    {
        recentSearchesScrollView.setOnTouchListener(new OnRecentSearchesScrollViewTouchListener());
        if (isGlobalSearchRedesign1505)
        {
            recentSearchesContainer.setVisibility(8);
            return;
        } else
        {
            oldRecentSearchesContainer.setVisibility(8);
            return;
        }
    }

    private void showGlobalSearchResults(String s, Place place)
    {
        Intent intent = new Intent(getActivity(), com/groupon/activity/GlobalSearchResult);
        intent.putExtra("sourceChannel", Channel.GETAWAYS);
        intent.putExtra("global_search_channel_filter", globalSearchUtil.filterStringForChannel(Channel.GETAWAYS));
        intent.putExtra("fromGlobalSearch", true);
        if (s != null)
        {
            intent.putExtra("search_term", s);
        }
        if (place != null)
        {
            s = new Bundle();
            s.putParcelable("selected_place", place);
            intent.putExtra("selected_place_bundle", s);
        }
        startActivity(intent);
        getActivity().overridePendingTransition(0, 0);
    }

    private void updateRecentSearches(List list, View view, ViewGroup viewgroup, int i, int j)
    {
        viewgroup.removeAllViews();
        view = LayoutInflater.from(view.getContext());
        View view1;
        for (list = list.iterator(); list.hasNext(); viewgroup.addView(view1))
        {
            Destination destination = (Destination)list.next();
            view1 = view.inflate(i, viewgroup, false);
            ((TextView)view1.findViewById(j)).setText(destination.name);
            view1.setOnClickListener(new OnRecentlySearchedDestinationClickListener(destination));
        }

    }

    public void clearAutocompleteDestinations()
    {
        destinationsAdapter.clear();
        destinationsAdapter.notifyDataSetChanged();
    }

    public void hideRecentSearches()
    {
        setRecentSearchesVisible(false);
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        i;
        JVM INSTR tableswitch 1 2: default 24
    //                   1 25
    //                   2 65;
           goto _L1 _L2 _L3
_L1:
        return;
_L2:
        if (j == 1)
        {
            intent = HotelSearchCalendarActivity.parseResultData(intent);
            presenter.onBackFromCalendar((Date)((Pair) (intent)).first, (Date)((Pair) (intent)).second);
            return;
        } else
        {
            presenter.onBackFromCalendar();
            return;
        }
_L3:
        if (j == 1)
        {
            presenter.onShowCalendarRequestedFromSearchResults();
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        roboguice.inject.ContextScopedRoboInjector contextscopedroboinjector = RoboGuice.getInjector(getActivity());
        contextscopedroboinjector.injectMembers(this);
        isGlobalSearchRedesign1505 = searchAbTestHelper.isUniversalSearchRedesignEnabled();
        destinationsAdapter = new DestinationsAdapter(getActivity());
        PresenterHolderFragment presenterholderfragment1 = (PresenterHolderFragment)getFragmentManager().findFragmentByTag("presenterHolderFragmentTag");
        PresenterHolderFragment presenterholderfragment = presenterholderfragment1;
        if (presenterholderfragment1 == null)
        {
            presenterholderfragment = new PresenterHolderFragment();
            getFragmentManager().beginTransaction().add(presenterholderfragment, "presenterHolderFragmentTag").commit();
        }
        if (presenterholderfragment.getPresenter() == null)
        {
            GetawaysSearchViewPresenter getawayssearchviewpresenter = (GetawaysSearchViewPresenter)contextscopedroboinjector.getInstance(com/groupon/getaways/search/GetawaysSearchViewPresenter);
            if (bundle != null)
            {
                getawayssearchviewpresenter.setState((GetawaysSearchViewPresenter.State)bundle.getSerializable("presenterState"));
            }
            presenterholderfragment.setPresenter(getawayssearchviewpresenter);
        }
        presenter = presenterholderfragment.getPresenter();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f0300eb, viewgroup, false);
        ButterKnife.bind(this, layoutinflater);
        return layoutinflater;
    }

    public void onDestroyView()
    {
        presenter.detachView(this);
        ButterKnife.unbind(this);
        super.onDestroyView();
    }

    public void onResume()
    {
        super.onResume();
        destinationsAdapter.setCurrentLocationEnabled(locationService.isAGpsProviderEnabled());
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("searchNearbyTonightResultsAlreadyShown", searchNearbyTonightResultsAlreadyShown);
        bundle.putSerializable("presenterState", presenter.getState());
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        setUpDestinationsView();
        setUpDatesSelectorView();
        setUpRecentSearchesView();
        presenter.attachView(this);
        if (bundle == null)
        {
            if (getArguments() != null)
            {
                setQuery(getArguments().getString("query"));
            }
        } else
        {
            searchNearbyTonightResultsAlreadyShown = bundle.getBoolean("searchNearbyTonightResultsAlreadyShown");
        }
        if (!searchNearbyTonightResultsAlreadyShown && getArguments() != null && getArguments().getBoolean("showSearchNearbyTonightResults"))
        {
            searchNearbyTonightResultsAlreadyShown = true;
            presenter.onSearchNearbyTonight();
        }
    }

    public void search()
    {
        presenter.onSearch();
    }

    public void setQuery(String s)
    {
        presenter.onQueryChanged(s);
    }

    public void showAutocompleteDestinations(List list)
    {
        destinationsAdapter.clear();
        destinationsAdapter.addAll(list);
        destinationsAdapter.notifyDataSetChanged();
    }

    public void showCalendar(Date date, Date date1)
    {
        startActivityForResult(HotelSearchCalendarActivity.newIntent(getActivity(), date, date1), 1);
    }

    public void showEmptyQueryWarning()
    {
        Toast.makeText(getActivity().getApplicationContext(), 0x7f08014f, 1).show();
    }

    public void showRecentSearches()
    {
        setRecentSearchesVisible(true);
    }

    public void showSearchByCurrentLocationResults(Date date, Date date1)
    {
        if (date != null && date1 != null)
        {
            startActivityForResult((new GetawaysSearchResultsActivity.IntentBuilder(getActivity())).dates(date, date1).build(), 2);
            getActivity().overridePendingTransition(0, 0);
            return;
        } else
        {
            date = locationService.getLocation();
            showGlobalSearchResults(null, new Place(getString(0x7f080118), date.getLatitude(), date.getLongitude()));
            return;
        }
    }

    public void showSearchByDestinationResults(Destination destination, Date date, Date date1)
    {
        if (date != null && date1 != null)
        {
            startActivityForResult((new GetawaysSearchResultsActivity.IntentBuilder(getActivity())).destination(destination).dates(date, date1).build(), 2);
            getActivity().overridePendingTransition(0, 0);
            return;
        } else
        {
            showGlobalSearchResults(null, new Place(destination.name, destination.lat, destination.lng));
            return;
        }
    }

    public void showSearchByQueryResults(String s)
    {
        showGlobalSearchResults(s, null);
    }

    public void updateDates(Date date, Date date1)
    {
        if (date != null && date1 != null)
        {
            datesSelectorTextView.setText(MarketRateUtil.getReservationDatesString(getActivity(), date, date1));
            return;
        } else
        {
            datesSelectorTextView.setText(selectDatesOptional);
            return;
        }
    }

    public void updateRecentSearches(List list)
    {
        if (isGlobalSearchRedesign1505)
        {
            updateRecentSearches(list, oldRecentSearchesContainer, ((ViewGroup) (oldRecentSearchesView)), 0x7f03010c, 0x7f10031d);
            return;
        } else
        {
            updateRecentSearches(list, recentSearchesContainer, ((ViewGroup) (recentSearchesView)), 0x7f030113, 0x7f10031d);
            return;
        }
    }


}
