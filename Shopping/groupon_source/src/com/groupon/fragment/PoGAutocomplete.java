// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.app.LoaderManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.groupon.Channel;
import com.groupon.activity.IntentFactory;
import com.groupon.activity.PoGSearch;
import com.groupon.db.events.UniversalUpdateEvent;
import com.groupon.db.models.BusinessSummary;
import com.groupon.db.models.Pagination;
import com.groupon.manager.UniversalInfo;
import com.groupon.manager.UniversalSyncManager;
import com.groupon.manager.sync_process.AbstractSyncManagerProcess;
import com.groupon.manager.sync_process.PoGBusinessSearchSyncManagerProcess;
import com.groupon.models.Place;
import com.groupon.models.nst.PoGGenericMetadata;
import com.groupon.util.LoggingUtils;
import com.groupon.v3.adapter.UniversalListAdapter;
import com.groupon.v3.adapter.callback.IViewCallback;
import com.groupon.v3.adapter.decoration.SimpleDividerItemDecoration;
import com.groupon.v3.adapter.mapping.GenericHeaderCardMapping;
import com.groupon.v3.adapter.mapping.PoGBussinessAutocompleteMapping;
import com.groupon.v3.loader.UniversalLoaderCallbacks;
import com.groupon.v3.processor.BackgroundDataProcessor;
import com.groupon.v3.processor.PoGBusinessLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.fragment:
//            BaseRecyclerViewFragment

public class PoGAutocomplete extends BaseRecyclerViewFragment
    implements IViewCallback
{
    public class SearchRunnable
        implements Runnable
    {

        final PoGAutocomplete this$0;

        public void run()
        {
            universalSyncManager.requestSync(PoGAutocomplete.this, (new UniversalInfo()).put("query", latestQuery).put("place", latestLocation));
        }

        public SearchRunnable()
        {
            this$0 = PoGAutocomplete.this;
            super();
        }
    }


    protected final int TYPE_DELAY_IN_MILLIS = 500;
    protected String context;
    Handler handler;
    protected long lastRequestedSearchTime;
    protected Place latestLocation;
    protected String latestQuery;
    protected SearchRunnable searchRunnable;
    protected String targetUrl;

    public PoGAutocomplete()
    {
        super(Channel.POT_OF_GOLD, (new StringBuilder()).append(Channel.POT_OF_GOLD.name()).append(com/groupon/fragment/PoGAutocomplete.getSimpleName()).toString());
        searchRunnable = new SearchRunnable();
    }

    protected void configureLoaderAndAdapter(UniversalListAdapter universallistadapter, UniversalLoaderCallbacks universalloadercallbacks)
    {
        universalloadercallbacks.setBackgroundDataProcessors(new BackgroundDataProcessor[] {
            new PoGBusinessLoader(getActivity(), dbChannel, null)
        });
        getLoaderManager().initLoader(0, null, universalloadercallbacks);
        universallistadapter.registerOverrideMapping((new PoGBussinessAutocompleteMapping()).registerCallback(com/groupon/v3/adapter/callback/IViewCallback, this));
        universallistadapter.registerOverrideMapping(new GenericHeaderCardMapping());
    }

    protected void configureSyncManager(UniversalSyncManager universalsyncmanager)
    {
        universalsyncmanager.configurePaginatedSyncManager(null, Arrays.asList(new AbstractSyncManagerProcess[] {
            new PoGBusinessSearchSyncManagerProcess(getActivity(), dbChannel)
        }), new UniversalUpdateEvent(dbChannel));
    }

    public void doSearch(String s, Place place)
    {
        if (Strings.isEmpty(s))
        {
            return;
        } else
        {
            latestQuery = s;
            latestLocation = place;
            s = new ArrayList();
            s.add(new Pagination());
            setList(s);
            lastRequestedSearchTime = System.currentTimeMillis();
            handler.removeCallbacks(searchRunnable);
            handler.postDelayed(searchRunnable, 500L);
            return;
        }
    }

    protected boolean enablePullToRefresh()
    {
        return false;
    }

    public int getEmptyViewLayoutId()
    {
        return 0x7f03018f;
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

            final PoGAutocomplete this$0;

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
                this$0 = PoGAutocomplete.this;
                super();
            }
        };
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public void onDestroy()
    {
        handler.removeCallbacks(searchRunnable);
        super.onDestroy();
    }

    public void onViewBound(int i, Object obj)
    {
    }

    public void onViewClick(View view)
    {
        view = (BusinessSummary)view.getTag(0x7f100001);
        PoGGenericMetadata poggenericmetadata = new PoGGenericMetadata();
        poggenericmetadata.merchantId = ((BusinessSummary) (view)).remoteId;
        poggenericmetadata.placement = view.getIntAttr("position", Integer.valueOf(0));
        poggenericmetadata.query = latestQuery;
        loggingUtils.logClickWithMetadata("", "pog_autocomplete_selection_click", Channel.GLOBAL_SEARCH.name().toLowerCase(), poggenericmetadata);
        startActivity(intentFactory.newPoGWebview(((BusinessSummary) (view)).remoteId, context, targetUrl));
    }

    protected boolean syncAutomaticallyOnResume()
    {
        return false;
    }
}
