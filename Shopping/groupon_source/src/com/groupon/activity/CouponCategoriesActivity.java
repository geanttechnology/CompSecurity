// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.os.Bundle;
import android.view.View;
import com.groupon.Channel;
import com.groupon.db.events.UniversalUpdateEvent;
import com.groupon.db.models.CouponCategory;
import com.groupon.manager.UniversalSyncManager;
import com.groupon.manager.sync_process.CouponCategorySyncManagerProcess;
import com.groupon.manager.sync_process.CouponTopCategorySyncManagerProcess;
import com.groupon.models.nst.CouponGenericMetadata;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.LoggingUtils;
import com.groupon.v3.adapter.UniversalListAdapter;
import com.groupon.v3.adapter.callback.IViewCallback;
import com.groupon.v3.adapter.mapping.CouponCategorySeeAllMapping;
import com.groupon.v3.adapter.mapping.GenericHeaderCardMapping;
import com.groupon.v3.adapter.mapping.Mapping;
import com.groupon.v3.loader.UniversalLoaderCallbacks;
import com.groupon.v3.processor.BackgroundDataProcessor;
import com.groupon.v3.processor.CouponCategoryLoader;
import com.groupon.v3.view.callbacks.DealCallbacks;
import com.groupon.v3.view.list_view.CouponCategoryWrapper;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.groupon.activity:
//            BaseRecyclerViewActivity, IntentFactory

public class CouponCategoriesActivity extends BaseRecyclerViewActivity
    implements IViewCallback
{

    public CouponCategoriesActivity()
    {
    }

    protected void configureLoaderAndAdapter(UniversalListAdapter universallistadapter, UniversalLoaderCallbacks universalloadercallbacks)
    {
        universalloadercallbacks.setBackgroundDataProcessors(new BackgroundDataProcessor[] {
            new CouponCategoryLoader(this, Channel.encodePath(new String[] {
                dbChannel, "TOP"
            }), com.groupon.v3.view.list_view.CouponCategoryWrapper.CouponCategoryType.TOP_CATEGORIES, getString(0x7f080107)), new CouponCategoryLoader(this, dbChannel, com.groupon.v3.view.list_view.CouponCategoryWrapper.CouponCategoryType.ALL, getString(0x7f0800cf))
        });
        universallistadapter.registerOverrideMapping((new CouponCategorySeeAllMapping()).registerCallback(com/groupon/v3/view/callbacks/DealCallbacks, this).registerCallback(com/groupon/v3/adapter/callback/IViewCallback, this));
        universallistadapter.registerOverrideMapping(new GenericHeaderCardMapping());
    }

    protected void configureSyncManager(UniversalSyncManager universalsyncmanager)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(new CouponTopCategorySyncManagerProcess(this, Channel.encodePath(new String[] {
            dbChannel, "TOP"
        }), true));
        arraylist.add(new CouponCategorySyncManagerProcess(this, dbChannel));
        universalsyncmanager.configurePaginatedSyncManager(null, arraylist, new UniversalUpdateEvent(dbChannel));
    }

    public int getEmptyViewLayoutId()
    {
        return 0x7f03006d;
    }

    protected void initActionBar(Bundle bundle)
    {
        super.initActionBar(bundle);
        setToolbarTitle(getString(0x7f0800a4));
    }

    public void logMerchantImpression(CouponCategoryWrapper couponcategorywrapper)
    {
        Object obj = couponcategorywrapper.getCouponCategory();
        CouponGenericMetadata coupongenericmetadata = new CouponGenericMetadata();
        coupongenericmetadata.pageId = getClass().getSimpleName();
        coupongenericmetadata.categoryId = ((CouponCategory) (obj)).getSlug();
        if (((com.groupon.v3.view.list_view.CouponCategoryWrapper.CouponCategoryType)couponcategorywrapper.getType()).equals(com.groupon.v3.view.list_view.CouponCategoryWrapper.CouponCategoryType.ALL))
        {
            obj = "all_categories";
        } else
        {
            obj = "top_categories";
        }
        coupongenericmetadata.pageSection = ((String) (obj));
        loggingUtils.logImpression("", "freebies_impression", Channel.COUPONS.toString(), (new StringBuilder()).append(couponcategorywrapper.getPosition()).append(",0").toString(), coupongenericmetadata);
    }

    public void onViewBound(int i, Object obj)
    {
        if (obj instanceof CouponCategoryWrapper)
        {
            logMerchantImpression((CouponCategoryWrapper)obj);
        }
    }

    public void onViewClick(View view)
    {
        view = ((View) (view.getTag(0x7f100001)));
        if (view.getClass() == com/groupon/v3/view/list_view/CouponCategoryWrapper)
        {
            view = (CouponCategoryWrapper)view;
            CouponCategory couponcategory = view.getCouponCategory();
            CouponGenericMetadata coupongenericmetadata = new CouponGenericMetadata();
            coupongenericmetadata.pageId = getClass().getSimpleName();
            coupongenericmetadata.categoryId = couponcategory.getSlug();
            coupongenericmetadata.position = Integer.toString(view.getPosition());
            logger.logClick("", "coupon_see_all_category_click", Channel.COUPONS.toString(), coupongenericmetadata, coupongenericmetadata);
            startActivity(intentFactory.newCouponCategoryFilterPageIntent(couponcategory));
        }
    }
}
