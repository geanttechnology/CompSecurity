// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.app.LoaderManager;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.groupon.Channel;
import com.groupon.activity.IntentFactory;
import com.groupon.activity.PoGSearch;
import com.groupon.db.events.UniversalUpdateEvent;
import com.groupon.db.models.BusinessSummary;
import com.groupon.manager.UniversalInfo;
import com.groupon.manager.UniversalSyncManager;
import com.groupon.manager.sync_process.AbstractSyncManagerProcess;
import com.groupon.manager.sync_process.PoGBusinessSearchSyncManagerProcess;
import com.groupon.models.nst.PoGGenericMetadata;
import com.groupon.util.LoggingUtils;
import com.groupon.v3.adapter.UniversalListAdapter;
import com.groupon.v3.adapter.callback.IViewCallback;
import com.groupon.v3.adapter.mapping.GenericHeaderCardMapping;
import com.groupon.v3.adapter.mapping.PoGBusinessSearchRecommendationMapping;
import com.groupon.v3.loader.UniversalLoaderCallbacks;
import com.groupon.v3.processor.BackgroundDataProcessor;
import com.groupon.v3.processor.PoGBusinessLoader;
import java.util.Arrays;

// Referenced classes of package com.groupon.fragment:
//            BaseRecyclerViewFragment

public class PoGRecommendation extends BaseRecyclerViewFragment
    implements IViewCallback
{

    protected String context;
    protected String targetUrl;

    public PoGRecommendation()
    {
        super(Channel.POT_OF_GOLD, (new StringBuilder()).append(Channel.POT_OF_GOLD.name()).append(com/groupon/fragment/PoGRecommendation.getSimpleName()).toString());
    }

    protected void configureLoaderAndAdapter(UniversalListAdapter universallistadapter, UniversalLoaderCallbacks universalloadercallbacks)
    {
        universalloadercallbacks.setBackgroundDataProcessors(new BackgroundDataProcessor[] {
            new PoGBusinessLoader(getActivity(), dbChannel, getString(0x7f080507))
        });
        getLoaderManager().initLoader(0, null, universalloadercallbacks);
        universallistadapter.registerOverrideMapping((new PoGBusinessSearchRecommendationMapping()).registerCallback(com/groupon/v3/adapter/callback/IViewCallback, this));
        universallistadapter.registerOverrideMapping(new GenericHeaderCardMapping());
    }

    protected void configureSyncManager(UniversalSyncManager universalsyncmanager)
    {
        universalsyncmanager.configurePaginatedSyncManager(null, Arrays.asList(new AbstractSyncManagerProcess[] {
            new PoGBusinessSearchSyncManagerProcess(getActivity(), dbChannel)
        }), new UniversalUpdateEvent(dbChannel));
    }

    protected boolean enablePullToRefresh()
    {
        return false;
    }

    public int getEmptyViewLayoutId()
    {
        return 0x7f03018f;
    }

    public UniversalInfo getInfoForSync()
    {
        return (new UniversalInfo()).put("query", "");
    }

    public android.support.v7.widget.RecyclerView.OnScrollListener getRecyclerOnScrollListener()
    {
        return new android.support.v7.widget.RecyclerView.OnScrollListener() {

            final PoGRecommendation this$0;

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
                this$0 = PoGRecommendation.this;
                super();
            }
        };
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        universalSyncManager.requestSync(this, null);
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
        loggingUtils.logClickWithMetadata("", "pog_popular_nearby_selection_click", Channel.GLOBAL_SEARCH.name().toLowerCase(), poggenericmetadata);
        startActivity(intentFactory.newPoGWebview(((BusinessSummary) (view)).remoteId, context, targetUrl));
    }

    protected boolean syncAutomaticallyOnResume()
    {
        return false;
    }
}
