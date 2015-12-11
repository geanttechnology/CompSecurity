// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.app.LoaderManager;
import android.view.LayoutInflater;
import android.view.View;
import com.groupon.Channel;
import com.groupon.activity.CouponSearch;
import com.groupon.activity.IntentFactory;
import com.groupon.db.events.UniversalUpdateEvent;
import com.groupon.db.models.CouponMerchant;
import com.groupon.manager.UniversalSyncManager;
import com.groupon.manager.sync_process.CouponTopMerchantSyncManagerProcess;
import com.groupon.models.nst.CouponGenericMetadata;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.LoggingUtils;
import com.groupon.v3.adapter.UniversalListAdapter;
import com.groupon.v3.adapter.callback.IViewCallback;
import com.groupon.v3.adapter.mapping.CouponHeaderCardMapping;
import com.groupon.v3.adapter.mapping.CouponSearchMerchantMapping;
import com.groupon.v3.adapter.mapping.Mapping;
import com.groupon.v3.loader.IUniversalCallback;
import com.groupon.v3.loader.UniversalListLoadResultData;
import com.groupon.v3.loader.UniversalLoaderCallbacks;
import com.groupon.v3.processor.BackgroundDataProcessor;
import com.groupon.v3.processor.CouponSearchLoader;
import com.groupon.v3.view.callbacks.DealCallbacks;
import com.groupon.v3.view.list_view.CouponMerchantWrapper;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.groupon.fragment:
//            BaseRecyclerViewFragment

public class CouponSearchSuggestion extends BaseRecyclerViewFragment
    implements IViewCallback, IUniversalCallback
{

    protected UniversalLoaderCallbacks callbacks;
    protected LayoutInflater inflater;
    protected IntentFactory intentFactory;
    protected Logger logger;

    public CouponSearchSuggestion()
    {
        super(Channel.COUPONS, (new StringBuilder()).append(Channel.COUPONS.toString()).append(com/groupon/fragment/CouponSearchSuggestion.getSimpleName()).toString());
    }

    protected void configureLoaderAndAdapter(UniversalListAdapter universallistadapter, UniversalLoaderCallbacks universalloadercallbacks)
    {
        universalloadercallbacks.setBackgroundDataProcessors(new BackgroundDataProcessor[] {
            new CouponSearchLoader(getActivity(), dbChannel)
        });
        getLoaderManager().initLoader(0, null, universalloadercallbacks);
        universallistadapter.registerOverrideMapping((new CouponSearchMerchantMapping()).registerCallback(com/groupon/v3/view/callbacks/DealCallbacks, this).registerCallback(com/groupon/v3/adapter/callback/IViewCallback, this));
        universallistadapter.registerOverrideMapping(new CouponHeaderCardMapping());
    }

    protected void configureSyncManager(UniversalSyncManager universalsyncmanager)
    {
        CouponTopMerchantSyncManagerProcess coupontopmerchantsyncmanagerprocess = new CouponTopMerchantSyncManagerProcess(getActivity(), dbChannel, true);
        coupontopmerchantsyncmanagerprocess.setRequestLimit(50);
        ArrayList arraylist = new ArrayList();
        arraylist.add(coupontopmerchantsyncmanagerprocess);
        universalsyncmanager.configurePaginatedSyncManager(null, arraylist, new UniversalUpdateEvent(dbChannel));
    }

    public int getEmptyViewLayoutId()
    {
        return 0x7f030079;
    }

    public void logMerchantImpression(int i, CouponMerchantWrapper couponmerchantwrapper)
    {
        CouponGenericMetadata coupongenericmetadata = new CouponGenericMetadata();
        coupongenericmetadata.merchantId = couponmerchantwrapper.getCouponMerchant().getRemoteId();
        coupongenericmetadata.pageId = com/groupon/activity/CouponSearch.getSimpleName();
        coupongenericmetadata.pageSection = "top_stores";
        loggingUtils.logImpression("", "freebies_impression", Channel.COUPONS.toString(), Integer.toString(couponmerchantwrapper.getVerticalPosition()), coupongenericmetadata);
    }

    public void onLoaderDataChanged(UniversalListLoadResultData universallistloadresultdata, boolean flag)
    {
        super.onLoaderDataChanged(universallistloadresultdata, flag);
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
        coupongenericmetadata.pageId = com/groupon/activity/CouponSearch.getSimpleName();
        coupongenericmetadata.merchantId = view.getCouponMerchant().getRemoteId();
        coupongenericmetadata.position = Integer.toString(view.getVerticalPosition());
        logger.logClick("", "coupon_see_all_category_click", Channel.COUPONS.toString(), coupongenericmetadata);
        startActivity(intentFactory.newCouponMerchantFilterPageIntent(view.getCouponMerchant()));
    }
}
