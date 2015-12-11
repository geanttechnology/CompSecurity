// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import com.groupon.Channel;
import com.groupon.activity.CouponSearch;
import com.groupon.activity.IntentFactory;
import com.groupon.db.events.UniversalUpdateEvent;
import com.groupon.db.models.CouponMerchant;
import com.groupon.db.models.Pagination;
import com.groupon.manager.UniversalInfo;
import com.groupon.manager.UniversalSyncManager;
import com.groupon.manager.sync_process.AbstractSyncManagerProcess;
import com.groupon.manager.sync_process.CouponAutoCompleteSyncManagerProcess;
import com.groupon.models.nst.CouponGenericMetadata;
import com.groupon.util.BaseRecyclerViewDelegate;
import com.groupon.util.LoggingUtils;
import com.groupon.v3.adapter.UniversalListAdapter;
import com.groupon.v3.adapter.callback.IViewCallback;
import com.groupon.v3.adapter.mapping.CouponHeaderCardMapping;
import com.groupon.v3.adapter.mapping.CouponSearchMerchantMapping;
import com.groupon.v3.adapter.mapping.Mapping;
import com.groupon.v3.adapter.mapping.NextPageTriggerMapping;
import com.groupon.v3.adapter.mapping.PendingViewMapping;
import com.groupon.v3.loader.UniversalListLoadResultData;
import com.groupon.v3.loader.UniversalLoaderCallbacks;
import com.groupon.v3.processor.BackgroundDataProcessor;
import com.groupon.v3.processor.CouponSearchAutoCompleteLoader;
import com.groupon.v3.view.callbacks.DealCallbacks;
import com.groupon.v3.view.list_view.CouponMerchantWrapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.fragment:
//            BaseRecyclerViewFragment

public class CouponSearchAutoComplete extends BaseRecyclerViewFragment
    implements IViewCallback, commonlib.manager.SyncManager.SyncUiCallbacks
{
    public class SearchRunnable
        implements Runnable
    {

        final CouponSearchAutoComplete this$0;

        public void run()
        {
            universalSyncManager.requestSync(CouponSearchAutoComplete.this, (new UniversalInfo()).put("query", latestQuery));
        }

        public SearchRunnable()
        {
            this$0 = CouponSearchAutoComplete.this;
            super();
        }
    }


    protected final int TYPE_DELAY_IN_MILLIS = 500;
    Handler handler;
    protected long lastRequestedSearchTime;
    protected volatile String latestQuery;
    protected SearchRunnable searchRunnable;

    public CouponSearchAutoComplete()
    {
        super(Channel.COUPONS, (new StringBuilder()).append(Channel.COUPONS.toString()).append(com/groupon/fragment/CouponSearchAutoComplete.getSimpleName()).toString());
        searchRunnable = new SearchRunnable();
    }

    private void logMerchantImpression(int i, CouponMerchantWrapper couponmerchantwrapper)
    {
        CouponGenericMetadata coupongenericmetadata = new CouponGenericMetadata();
        coupongenericmetadata.merchantId = couponmerchantwrapper.getCouponMerchant().getRemoteId();
        coupongenericmetadata.pageId = com/groupon/activity/CouponSearch.getSimpleName();
        coupongenericmetadata.pageSection = "matching_stores";
        loggingUtils.logImpression("", "freebies_impression", Channel.COUPONS.toString(), Integer.toString(i - 1), coupongenericmetadata);
    }

    protected void configureEmptyView(View view)
    {
        TextView textview = (TextView)view.findViewById(0x7f1001d8);
        view = (TextView)view.findViewById(0x7f1001d9);
        textview.setText(getString(0x7f0800eb));
        view.setText(getString(0x7f0800ea));
    }

    protected void configureLoaderAndAdapter(UniversalListAdapter universallistadapter, UniversalLoaderCallbacks universalloadercallbacks)
    {
        universallistadapter.registerOverrideMapping((new CouponSearchMerchantMapping()).registerCallback(com/groupon/v3/view/callbacks/DealCallbacks, this).registerCallback(com/groupon/v3/adapter/callback/IViewCallback, this));
        universallistadapter.registerOverrideMapping(new CouponHeaderCardMapping());
        universallistadapter.registerOverrideMapping(new PendingViewMapping());
        universallistadapter.registerOverrideMapping(new NextPageTriggerMapping(this));
        universalloadercallbacks.setBackgroundDataProcessors(new BackgroundDataProcessor[] {
            new CouponSearchAutoCompleteLoader(getActivity(), dbChannel)
        });
    }

    protected void configureSyncManager(UniversalSyncManager universalsyncmanager)
    {
        universalsyncmanager.configurePaginatedSyncManager(null, Arrays.asList(new AbstractSyncManagerProcess[] {
            new CouponAutoCompleteSyncManagerProcess(getActivity(), dbChannel)
        }), new UniversalUpdateEvent(dbChannel));
    }

    protected boolean enablePullToRefresh()
    {
        return false;
    }

    public int getEmptyViewLayoutId()
    {
        return 0x7f030075;
    }

    public void handleSyncError(Runnable runnable, Exception exception)
    {
        super.handleSyncError(runnable, exception);
        setList(new ArrayList());
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

    public void onLoaderDataChanged(UniversalListLoadResultData universallistloadresultdata, boolean flag)
    {
        baseRecyclerViewDelegate.onLoaderDataChanged(universallistloadresultdata, flag);
        if (emptyView.getVisibility() == 0)
        {
            universallistloadresultdata = new CouponGenericMetadata();
            universallistloadresultdata.pageId = com/groupon/activity/CouponSearch.getSimpleName();
            loggingUtils.logPageView("", "freebies_no_results", universallistloadresultdata);
        }
    }

    public void onViewBound(int i, Object obj)
    {
        if (obj instanceof CouponMerchantWrapper)
        {
            logMerchantImpression(i, (CouponMerchantWrapper)obj);
        }
    }

    public void onViewClick(View view)
    {
        view = (CouponMerchantWrapper)view.getTag(0x7f100001);
        CouponGenericMetadata coupongenericmetadata = new CouponGenericMetadata();
        coupongenericmetadata.pageId = getActivity().getClass().getSimpleName();
        coupongenericmetadata.merchantId = view.getCouponMerchant().getRemoteId();
        coupongenericmetadata.position = Integer.toString(view.getVerticalPosition());
        loggingUtils.logClickWithMetadata("", "autocomplete_selection_click", Channel.COUPONS.toString(), coupongenericmetadata);
        startActivity(intentFactory.newCouponMerchantFilterPageIntent(view.getCouponMerchant()));
    }

    public void search(String s)
    {
        if (Strings.isEmpty(s))
        {
            return;
        } else
        {
            latestQuery = s;
            s = new ArrayList();
            s.add(new Pagination());
            setList(s);
            lastRequestedSearchTime = System.currentTimeMillis();
            handler.removeCallbacks(searchRunnable);
            handler.postDelayed(searchRunnable, 500L);
            return;
        }
    }

    protected boolean syncAutomaticallyOnResume()
    {
        return false;
    }
}
