// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.groupon.abtest.RapiAbTestHelper;
import com.groupon.activity.GlobalSearchResult;
import com.groupon.callbacks.MapViewDealClickCallback;
import com.groupon.db.models.DealSummary;
import com.groupon.mapview.DealsMapView;
import com.groupon.models.Place;
import com.groupon.models.RapiSearchResponse;
import com.groupon.models.search.domain.ReloadSearchEvent;
import com.groupon.models.search.domain.SortMethod;
import com.groupon.service.SearchHelper;
import com.groupon.util.RapiRequestProperties;
import com.groupon.util.RapiResponseListener;
import com.groupon.util.ResultsAvailableListener;
import com.groupon.util.SearchServiceInterface;
import com.groupon.view.SpinnerButton;
import com.squareup.otto.Bus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

// Referenced classes of package com.groupon.fragment:
//            RapiSearchResultFragment

public class RapiSearchResultContainerFragment extends Fragment
    implements RapiResponseListener, ResultsAvailableListener, SearchServiceInterface
{

    private static final String BUNDLE_SEARCH_PROPERTIES = "BUNDLE_SEARCH_PROPERTIES";
    private Bus bus;
    View filterSheetBackgroundTouchInterceptor;
    SpinnerButton globalSearchMapRefreshButton;
    private Place place;
    private RapiAbTestHelper rapiAbTestHelper;
    private RapiResponseListener rapiResponseListener;
    private RapiSearchResultFragment resultFragment;
    private SearchHelper searchHelper;
    View searchListSection;
    View searchMapSection;
    DealsMapView searchMapView;

    public RapiSearchResultContainerFragment()
    {
    }

    private void enableMyLocation(boolean flag)
    {
        GoogleMap googlemap = searchMapView.getGoogleMap();
        if (googlemap != null)
        {
            googlemap.setMyLocationEnabled(flag);
            googlemap.getUiSettings().setMyLocationButtonEnabled(false);
            googlemap.getUiSettings().setCompassEnabled(flag);
        }
    }

    private void initGlobalSearchResultFragment()
    {
        String s = com/groupon/fragment/RapiSearchResultFragment.getName();
        resultFragment = (RapiSearchResultFragment)getChildFragmentManager().findFragmentById(0x7f100322);
        if (resultFragment == null)
        {
            resultFragment = (RapiSearchResultFragment)RapiSearchResultFragment.instantiate(getActivity(), s, getArguments());
        }
        resultFragment.setResultsListener(this);
        resultFragment.setRapiResponseListener(this);
        getChildFragmentManager().beginTransaction().replace(0x7f100322, resultFragment).commit();
    }

    public GlobalSearchResult getGlobalSearchResultActivity()
    {
        return (GlobalSearchResult)getActivity();
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        MapsInitializer.initialize(getActivity());
        searchMapView.onCreate(bundle);
        searchMapView.resetInternalStates();
        searchMapView.setDealClickListener(new MapViewDealClickCallback(getActivity()));
        searchMapSection.setVisibility(8);
        globalSearchMapRefreshButton.setProgress(getResources().getDrawable(0x7f0202bb));
        globalSearchMapRefreshButton.setOnClickListener(new android.view.View.OnClickListener() {

            final RapiSearchResultContainerFragment this$0;

            public void onClick(View view)
            {
                view = searchMapView.getCenterCoordinates();
                resultFragment.updateSearchLocation(new Place("", ((LatLng) (view)).latitude, ((LatLng) (view)).longitude));
                reloadDeals();
            }

            
            {
                this$0 = RapiSearchResultContainerFragment.this;
                super();
            }
        });
        searchHelper.init(searchListSection, searchMapSection, searchMapView);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f0301bc, viewgroup, false);
        ButterKnife.bind(this, layoutinflater);
        RoboGuice.getInjector(getActivity()).injectMembers(this);
        place = (Place)getArguments().getParcelable("selected_place");
        initGlobalSearchResultFragment();
        return layoutinflater;
    }

    public void onDestroyView()
    {
        if (searchMapView != null)
        {
            searchMapView.release();
        }
        if (resultFragment != null)
        {
            resultFragment.setResultsListener(null);
        }
        ButterKnife.unbind(this);
        super.onDestroyView();
    }

    public void onLowMemory()
    {
        super.onLowMemory();
        if (searchMapView != null)
        {
            searchMapView.onLowMemory();
        }
    }

    public void onPause()
    {
        super.onPause();
        searchMapView.onPause();
        enableMyLocation(false);
        if (rapiAbTestHelper.isDTFforEitherHBWOrFDEnabled(place))
        {
            bus.unregister(this);
        }
    }

    public void onRapiResponseAvailable(RapiSearchResponse rapisearchresponse)
    {
        if (rapiResponseListener != null)
        {
            rapiResponseListener.onRapiResponseAvailable(rapisearchresponse);
        }
    }

    public void onResume()
    {
        super.onResume();
        searchMapView.onResume();
        if (!getGlobalSearchResultActivity().isListMode())
        {
            switchToMap();
        } else
        {
            switchToList();
        }
        if (rapiAbTestHelper.isDTFforEitherHBWOrFDEnabled(place))
        {
            bus.register(this);
        }
    }

    public void reloadDeals()
    {
        globalSearchMapRefreshButton.startSpinning();
        searchMapView.clearDeals();
        reloadFragment();
    }

    protected void reloadFragment()
    {
        this;
        JVM INSTR monitorenter ;
        resultFragment.forceReload();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void rerequest(ReloadSearchEvent reloadsearchevent)
    {
        resetSearch();
        reloadDeals();
    }

    public void resetSearch()
    {
        resultFragment.resetSearch();
    }

    public void resultsAvailable(List list)
    {
        ArrayList arraylist = new ArrayList();
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            Object obj = list.next();
            if (obj instanceof DealSummary)
            {
                arraylist.add((DealSummary)obj);
            }
        } while (true);
        list = (RapiRequestProperties)getArguments().getParcelable("BUNDLE_SEARCH_PROPERTIES");
        searchMapView.clearDeals();
        searchHelper.addDealsToMap(((RapiRequestProperties) (list)).expressedLocation, arraylist);
        globalSearchMapRefreshButton.stopSpinning();
    }

    public void setRapiResponseListener(RapiResponseListener rapiresponselistener)
    {
        rapiResponseListener = rapiresponselistener;
    }

    public void showFilterSheetBackgroundTouchInterceptor(boolean flag)
    {
        if (filterSheetBackgroundTouchInterceptor != null)
        {
            View view = filterSheetBackgroundTouchInterceptor;
            int i;
            if (flag)
            {
                i = 0;
            } else
            {
                i = 8;
            }
            view.setVisibility(i);
        }
    }

    public void switchToList()
    {
        searchHelper.switchToList();
    }

    public void switchToMap()
    {
        searchHelper.switchToMap();
    }

    public void updateFacetFilters(List list)
    {
        resultFragment.updateFacetFilters(list);
    }

    public void updateSortMethod(SortMethod sortmethod)
    {
        resultFragment.updateSortMethod(sortmethod);
    }

}
