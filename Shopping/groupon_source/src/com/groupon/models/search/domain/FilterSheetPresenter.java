// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.search.domain;

import android.os.Parcel;
import android.os.Parcelable;
import com.groupon.Channel;
import com.groupon.models.nst.SearchFilterCountExtraInfo;
import com.groupon.models.nst.SearchFilterFacetValueSelectedExtraInfo;
import com.groupon.models.nst.SearchFilterSortValueSelectedExtraInfo;
import com.groupon.models.search.data.Facet;
import com.groupon.models.search.data.FacetValue;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.OnSearchFilterUpdatedListener;

// Referenced classes of package com.groupon.models.search.domain:
//            SearchFilterDomainModelListener, SearchFilterDomainModel, FilterSheetView, SortMethodWrapper

public class FilterSheetPresenter
    implements Parcelable, SearchFilterDomainModelListener, OnSearchFilterUpdatedListener
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public FilterSheetPresenter createFromParcel(Parcel parcel)
        {
            return new FilterSheetPresenter(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public FilterSheetPresenter[] newArray(int i)
        {
            return new FilterSheetPresenter[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private static final String FILTERSHEET_RESET_CLICK = "filtersheet_reset_click";
    private static final String FILTER_ICON_POST_SEARCH_CLICK = "filtericon_post_search_click";
    private static final String FILTER_SELECT_CLICK = "filter_select_click";
    private static final String FILTER_SORT_CLICK = "filter_sort_click";
    private FilterSheetView filterSheetView;
    private boolean isLoading;
    private SearchFilterDomainModel searchFilterDomainModel;

    protected FilterSheetPresenter(Parcel parcel)
    {
        boolean flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isLoading = flag;
    }

    public FilterSheetPresenter(FilterSheetView filtersheetview)
    {
        filterSheetView = filtersheetview;
    }

    public int describeContents()
    {
        return 0;
    }

    public void facetValueSelectionChanged(Facet facet, FacetValue facetvalue, boolean flag)
    {
        searchFilterDomainModel.facetValueSelectionChanged(facet, facetvalue, flag);
        filterSheetView.setFilterCount(searchFilterDomainModel.getFilteredFacetCount());
        facet = filterSheetView;
        if (searchFilterDomainModel.getFilteredFacetCount() == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        facet.updateResetButtonState(flag);
    }

    public void facetValueSelectionChanged(Logger logger, Channel channel, String s, Facet facet, FacetValue facetvalue, boolean flag)
    {
        facetValueSelectionChanged(facet, facetvalue, flag);
        logger.logClick("", "filter_select_click", channel.toString(), Logger.NULL_NST_FIELD, new SearchFilterFacetValueSelectedExtraInfo(s, facet.id, facetvalue.id));
    }

    public void filterButtonTapped(String s, Channel channel, Logger logger)
    {
        logger.logClick("", "filtericon_post_search_click", channel.toString(), Logger.NULL_NST_FIELD, new SearchFilterCountExtraInfo(s, searchFilterDomainModel.getFilteredFacetCount()));
    }

    public void onDealCountUpdated(int i)
    {
        filterSheetView.setDealCount(searchFilterDomainModel.getDealCount());
    }

    public void onDestroy()
    {
        filterSheetView = null;
    }

    public void onFacetsUpdated()
    {
        isLoading = false;
        filterSheetView.setIsRefreshing(false);
        filterSheetView.updateFacets(searchFilterDomainModel.getFacets(), searchFilterDomainModel.sortMethods);
    }

    public void onSearchFilterDomainModelSyncCompleted()
    {
        isLoading = false;
        filterSheetView.setIsRefreshing(false);
    }

    public void onSearchFilterDomainModelSyncRequested()
    {
        isLoading = true;
        filterSheetView.setIsRefreshing(true);
    }

    public void pause()
    {
        searchFilterDomainModel.removeSearchFilterDomainModelListener(this);
    }

    public void requestMenuItemUpdate()
    {
        filterSheetView.setFilterCount(searchFilterDomainModel.getFilteredFacetCount());
        FilterSheetView filtersheetview = filterSheetView;
        boolean flag;
        if (searchFilterDomainModel.getFilteredFacetCount() == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        filtersheetview.updateResetButtonState(flag);
    }

    public void reset()
    {
        searchFilterDomainModel.reset();
        filterSheetView.setFilterCount(searchFilterDomainModel.getFilteredFacetCount());
        FilterSheetView filtersheetview = filterSheetView;
        boolean flag;
        if (searchFilterDomainModel.getFilteredFacetCount() == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        filtersheetview.updateResetButtonState(flag);
    }

    public void reset(Logger logger, String s)
    {
        reset();
        logger.logClick("", "filtersheet_reset_click", s, Logger.NULL_NST_FIELD, Logger.NULL_NST_FIELD);
    }

    public void resume(FilterSheetView filtersheetview)
    {
        filterSheetView = filtersheetview;
        filterSheetView.setIsRefreshing(isLoading);
        filterSheetView.setDealCount(searchFilterDomainModel.getDealCount());
        filterSheetView.updateFacets(searchFilterDomainModel.getFacets(), searchFilterDomainModel.sortMethods);
        searchFilterDomainModel.addSearchFilterDomainModelListener(this);
    }

    public void setSearchFilterDomainModel(SearchFilterDomainModel searchfilterdomainmodel)
    {
        searchFilterDomainModel = searchfilterdomainmodel;
    }

    public void sortValueSelected(SortMethodWrapper sortmethodwrapper)
    {
        searchFilterDomainModel.sortValueSelected(sortmethodwrapper);
        filterSheetView.setFilterCount(searchFilterDomainModel.getFilteredFacetCount());
        sortmethodwrapper = filterSheetView;
        boolean flag;
        if (searchFilterDomainModel.getFilteredFacetCount() == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        sortmethodwrapper.updateResetButtonState(flag);
    }

    public void sortValueSelected(Logger logger, Channel channel, String s, SortMethodWrapper sortmethodwrapper)
    {
        sortValueSelected(sortmethodwrapper);
        logger.logClick("", "filter_sort_click", channel.toString(), Logger.NULL_NST_FIELD, new SearchFilterSortValueSelectedExtraInfo(s, sortmethodwrapper.sortMethod));
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        if (isLoading)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
    }

}
