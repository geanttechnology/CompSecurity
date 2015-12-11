// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.groupon.Channel;
import com.groupon.activity.PoGSearch;
import com.groupon.manager.UniversalSyncManager;
import com.groupon.models.Place;
import com.groupon.models.nst.PoGGenericMetadata;
import com.groupon.service.LocationService;
import com.groupon.util.BaseRecyclerViewDelegate;
import com.groupon.util.LocationsAutocompleteServiceWrapper;
import com.groupon.util.LoggingUtils;
import com.groupon.v3.adapter.UniversalListAdapter;
import com.groupon.v3.adapter.callback.IViewCallback;
import com.groupon.v3.adapter.decoration.SimpleDividerItemDecoration;
import com.groupon.v3.adapter.mapping.LocationAutocompleteMapping;
import com.groupon.v3.loader.UniversalListLoadResultData;
import com.groupon.v3.loader.UniversalLoaderCallbacks;
import com.groupon.v3.view.list_view.PoGLocationWrapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

// Referenced classes of package com.groupon.fragment:
//            BaseRecyclerViewFragment

public class PoGLocationAutocomplete extends BaseRecyclerViewFragment
    implements IViewCallback
{
    public static interface LocationCallback
    {

        public abstract void onLocationSelected(Place place);
    }


    protected LocationCallback locationCallback;
    LocationService locationService;
    protected LocationsAutocompleteServiceWrapper locationsAutocompleteServiceWrapper;

    public PoGLocationAutocomplete()
    {
        super(Channel.POT_OF_GOLD, (new StringBuilder()).append(Channel.POT_OF_GOLD.name()).append(com/groupon/fragment/PoGLocationAutocomplete.getSimpleName()).toString());
    }

    protected void configureLoaderAndAdapter(UniversalListAdapter universallistadapter, UniversalLoaderCallbacks universalloadercallbacks)
    {
        universallistadapter.registerOverrideMapping((new LocationAutocompleteMapping(locationsAutocompleteServiceWrapper)).registerCallback(com/groupon/v3/adapter/callback/IViewCallback, this));
    }

    protected void configureSyncManager(UniversalSyncManager universalsyncmanager)
    {
    }

    protected boolean enablePullToRefresh()
    {
        return false;
    }

    protected List getListItemDecorations()
    {
        return Arrays.asList(new android.support.v7.widget.RecyclerView.ItemDecoration[] {
            new SimpleDividerItemDecoration(activity)
        });
    }

    public android.support.v7.widget.RecyclerView.OnScrollListener getRecyclerOnScrollListener()
    {
        return new android.support.v7.widget.RecyclerView.OnScrollListener() {

            final PoGLocationAutocomplete this$0;

            public void onScrollStateChanged(RecyclerView recyclerview, int i)
            {
                super.onScrollStateChanged(recyclerview, i);
            }

            public void onScrolled(RecyclerView recyclerview, int i, int j)
            {
                super.onScrolled(recyclerview, i, j);
                if (activity instanceof PoGSearch)
                {
                    ((PoGSearch)activity).dismissKeyboard();
                }
            }

            
            {
                this$0 = PoGLocationAutocomplete.this;
                super();
            }
        };
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        locationCallback = (LocationCallback)getActivity();
        locationsAutocompleteServiceWrapper = (LocationsAutocompleteServiceWrapper)RoboGuice.getInjector(getActivity()).getInstance(com/groupon/util/LocationsAutocompleteServiceWrapper);
    }

    public void onLoaderDataChanged(UniversalListLoadResultData universallistloadresultdata, boolean flag)
    {
    }

    public void onViewBound(int i, Object obj)
    {
    }

    public void onViewClick(View view)
    {
        view = (PoGLocationWrapper)view.getTag(0x7f100001);
        PoGGenericMetadata poggenericmetadata = new PoGGenericMetadata();
        poggenericmetadata.placeName = ((PoGLocationWrapper) (view)).place.name;
        poggenericmetadata.lat = Double.valueOf(((PoGLocationWrapper) (view)).place.lat);
        poggenericmetadata.lng = Double.valueOf(((PoGLocationWrapper) (view)).place.lng);
        poggenericmetadata.placement = Integer.valueOf(((PoGLocationWrapper) (view)).position);
        loggingUtils.logClickWithMetadata("", "pog_location_selection_click", Channel.GLOBAL_SEARCH.toString(), poggenericmetadata);
        locationCallback.onLocationSelected(((PoGLocationWrapper) (view)).place);
    }

    public void setAutocompleteList(List list)
    {
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i < list.size(); i++)
        {
            arraylist.add(new PoGLocationWrapper((Place)list.get(i), i));
        }

        baseRecyclerViewDelegate.getDataAdapter().setList(arraylist);
    }

    protected boolean syncAutomaticallyOnResume()
    {
        return false;
    }
}
