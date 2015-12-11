// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.app.Activity;
import android.content.SharedPreferences;
import android.location.Location;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.widget.Button;
import com.groupon.Channel;
import com.groupon.activity.IntentFactory;
import com.groupon.db.events.UniversalUpdateEvent;
import com.groupon.db.models.CouponCategory;
import com.groupon.db.models.CouponMerchant;
import com.groupon.db.models.CouponSummary;
import com.groupon.manager.UniversalSyncManager;
import com.groupon.manager.sync_process.CouponListSyncManagerProcess;
import com.groupon.manager.sync_process.CouponNearbyMerchantSyncManagerProcess;
import com.groupon.manager.sync_process.CouponTopCategorySyncManagerProcess;
import com.groupon.manager.sync_process.CouponTopMerchantSyncManagerProcess;
import com.groupon.models.country.Country;
import com.groupon.models.division.Division;
import com.groupon.models.nst.CouponGenericMetadata;
import com.groupon.service.LocationService;
import com.groupon.service.core.UserManager;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.service.countryanddivision.CurrentDivisionManager;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.GeoPoint;
import com.groupon.util.LoggingUtils;
import com.groupon.v3.adapter.UniversalListAdapter;
import com.groupon.v3.adapter.callback.IViewCallback;
import com.groupon.v3.adapter.mapping.CouponCardMapping;
import com.groupon.v3.adapter.mapping.CouponHeaderCardMapping;
import com.groupon.v3.adapter.mapping.CouponTopItemCardMapping;
import com.groupon.v3.loader.UniversalListLoadResultData;
import com.groupon.v3.loader.UniversalLoaderCallbacks;
import com.groupon.v3.processor.BackgroundDataProcessor;
import com.groupon.v3.processor.CouponLoader;
import com.groupon.v3.processor.PaginationInserter;
import com.groupon.v3.util.ScrollToolBarHelperV3;
import com.groupon.v3.view.list_view.CouponListItemType;
import com.groupon.v3.view.list_view.CouponSummaryWrapper;
import com.groupon.v3.view.list_view.CouponTopItemType;
import com.groupon.view.PagerSlidingTabStrip;
import com.groupon.view.widgetcards.CouponTopItem;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.groupon.fragment:
//            BaseRecyclerViewFragment

public class Coupons extends BaseRecyclerViewFragment
    implements IViewCallback
{

    CurrentCountryManager currentCountryManager;
    protected CurrentDivisionManager currentDivisionManager;
    protected LocationService locationService;
    protected SharedPreferences prefs;
    protected UserManager userManager;
    protected ViewStub viewStub;

    public Coupons()
    {
        super(Channel.COUPONS, Channel.COUPONS.toString());
    }

    protected void configureEmptyView(View view)
    {
        ((Button)view.findViewById(0x7f1001ba)).setOnClickListener(new android.view.View.OnClickListener() {

            final Coupons this$0;

            public void onClick(View view1)
            {
                forceReload();
            }

            
            {
                this$0 = Coupons.this;
                super();
            }
        });
    }

    protected void configureLoaderAndAdapter(UniversalListAdapter universallistadapter, UniversalLoaderCallbacks universalloadercallbacks)
    {
        universalloadercallbacks.setBackgroundDataProcessors(new BackgroundDataProcessor[] {
            new CouponLoader(getActivity(), dbChannel, Channel.encodePath(new String[] {
                dbChannel, "TOP"
            }), currentCountryManager.getCurrentCountry().isUnitedStates()), new PaginationInserter(true)
        });
        universallistadapter.registerOverrideMapping((new CouponCardMapping(false)).registerCallback(com/groupon/v3/adapter/callback/IViewCallback, this));
        universallistadapter.registerOverrideMapping((new CouponTopItemCardMapping()).registerCallback(com/groupon/v3/adapter/callback/IViewCallback, this));
        universallistadapter.registerOverrideMapping((new CouponHeaderCardMapping()).registerCallback(com/groupon/v3/adapter/callback/IViewCallback, this));
    }

    protected void configureSyncManager(UniversalSyncManager universalsyncmanager)
    {
        ArrayList arraylist;
        Location location;
        arraylist = new ArrayList();
        arraylist.add(new CouponListSyncManagerProcess(getActivity(), dbChannel));
        arraylist.add(new CouponTopCategorySyncManagerProcess(getActivity(), Channel.encodePath(new String[] {
            dbChannel, "TOP"
        }), false));
        arraylist.add(new CouponTopMerchantSyncManagerProcess(getActivity(), Channel.encodePath(new String[] {
            dbChannel, "TOP"
        }), false));
        location = locationService.getLocation();
        if (!currentCountryManager.getCurrentCountry().isUnitedStates()) goto _L2; else goto _L1
_L1:
        if (location == null) goto _L4; else goto _L3
_L3:
        arraylist.add(new CouponNearbyMerchantSyncManagerProcess(getActivity(), Channel.encodePath(new String[] {
            dbChannel, "NEARBY"
        }), location.getLatitude(), location.getLongitude()));
_L2:
        universalsyncmanager.configurePaginatedSyncManager(null, arraylist, new UniversalUpdateEvent(dbChannel));
        return;
_L4:
        GeoPoint geopoint = currentDivisionManager.getCurrentDivision().geoPoint;
        if (geopoint != null)
        {
            arraylist.add(new CouponNearbyMerchantSyncManagerProcess(getActivity(), Channel.encodePath(new String[] {
                dbChannel, "NEARBY"
            }), geopoint.getLatitudeDegrees(), geopoint.getLongitudeDegrees()));
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public int getEmptyViewLayoutId()
    {
        return 0x7f03006c;
    }

    public int getLayoutId()
    {
        return 0x7f03007d;
    }

    protected void logImpressionCouponSummary(CouponSummaryWrapper couponsummarywrapper)
    {
        CouponSummary couponsummary = couponsummarywrapper.getCouponSummary();
        CouponGenericMetadata coupongenericmetadata = new CouponGenericMetadata();
        coupongenericmetadata.couponId = couponsummary.remoteId;
        coupongenericmetadata.pageId = getClass().getSimpleName();
        loggingUtils.redirectLogImpression(getClass().getSimpleName(), "", "freebies_impression", Channel.COUPONS.toString(), Integer.toString(couponsummarywrapper.getPosition()), coupongenericmetadata);
    }

    public void logImpressionsForCouponTopItemType(CouponTopItemType coupontopitemtype)
    {
        ArrayList arraylist = coupontopitemtype.getItems();
        int i = 0;
        while (i < arraylist.size()) 
        {
            if (coupontopitemtype.isType(com.groupon.v3.view.list_view.CouponTopItemType.ItemType.NEARBY) || coupontopitemtype.isType(com.groupon.v3.view.list_view.CouponTopItemType.ItemType.TOP_MERCHANT))
            {
                Object obj = (CouponMerchant)arraylist.get(i);
                CouponGenericMetadata coupongenericmetadata = new CouponGenericMetadata();
                coupongenericmetadata.merchantId = ((CouponMerchant) (obj)).getRemoteId();
                coupongenericmetadata.pageId = getClass().getSimpleName();
                if (coupontopitemtype.isType(com.groupon.v3.view.list_view.CouponTopItemType.ItemType.NEARBY))
                {
                    obj = "nearby_stores";
                } else
                {
                    obj = "top_stores";
                }
                coupongenericmetadata.pageSection = ((String) (obj));
                loggingUtils.redirectLogImpression(getClass().getSimpleName(), "", "freebies_impression", Channel.COUPONS.toString(), (new StringBuilder()).append(coupontopitemtype.getPosition()).append(",").append(i).toString(), coupongenericmetadata);
            } else
            {
                CouponCategory couponcategory = (CouponCategory)arraylist.get(i);
                CouponGenericMetadata coupongenericmetadata1 = new CouponGenericMetadata();
                coupongenericmetadata1.pageId = getClass().getSimpleName();
                coupongenericmetadata1.categoryId = couponcategory.getSlug();
                loggingUtils.redirectLogImpression(getClass().getSimpleName(), "", "freebies_impression", Channel.COUPONS.toString(), (new StringBuilder()).append(coupontopitemtype.getPosition()).append(",").append(i).toString(), coupongenericmetadata1);
            }
            i++;
        }
    }

    public void onActivityCreated(final Bundle inflated)
    {
        super.onActivityCreated(inflated);
        if (!userManager.hasSeenCouponsIntroScreen())
        {
            inflated = viewStub.inflate();
            recyclerView.setVisibility(8);
            inflated.findViewById(0x7f1001e7).setOnClickListener(new android.view.View.OnClickListener() {

                final Coupons this$0;
                final View val$inflated;

                public void onClick(View view)
                {
                    ((ViewGroup)inflated.getParent()).removeView(inflated);
                    userManager.setHasSeenCouponsIntroScreen();
                    recyclerView.setVisibility(0);
                }

            
            {
                this$0 = Coupons.this;
                inflated = view;
                super();
            }
            });
            getView().getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

                final Coupons this$0;
                final View val$inflated;

                public void onGlobalLayout()
                {
                    Object obj = (Toolbar)getActivity().findViewById(0x7f100180);
                    int i = ((PagerSlidingTabStrip)getActivity().findViewById(0x7f1000a9)).getHeight();
                    int j = ((Toolbar) (obj)).getHeight();
                    obj = (android.widget.RelativeLayout.LayoutParams)inflated.findViewById(0x7f1001e1).getLayoutParams();
                    ((android.widget.RelativeLayout.LayoutParams) (obj)).setMargins(0, i + j, 0, 0);
                    inflated.findViewById(0x7f1001e1).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
                    getView().getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }

            
            {
                this$0 = Coupons.this;
                inflated = view;
                super();
            }
            });
        }
    }

    public void onCouponClick(CouponSummaryWrapper couponsummarywrapper)
    {
        CouponSummary couponsummary = couponsummarywrapper.getCouponSummary();
        CouponGenericMetadata coupongenericmetadata = new CouponGenericMetadata();
        coupongenericmetadata.pageId = getClass().getSimpleName();
        coupongenericmetadata.couponId = couponsummary.remoteId;
        coupongenericmetadata.position = Integer.toString(couponsummarywrapper.getPosition());
        loggingUtils.logClickWithMetadata("", "coupon_click", Channel.COUPONS.toString(), coupongenericmetadata);
        startActivity(intentFactory.newCouponDetailsIntent(couponsummary.remoteId, Channel.COUPONS));
    }

    public void onLoaderDataChanged(UniversalListLoadResultData universallistloadresultdata, boolean flag)
    {
        super.onLoaderDataChanged(universallistloadresultdata, flag);
        universallistloadresultdata = new CouponGenericMetadata();
        universallistloadresultdata.pageId = "coupon_landing";
        if (emptyView.getVisibility() == 0)
        {
            loggingUtils.redirectLogPageView(getClass().getSimpleName(), "", "freebies_no_results", universallistloadresultdata);
        }
    }

    public void onTopItemChicletClick(CouponTopItem coupontopitem)
    {
        CouponGenericMetadata coupongenericmetadata = new CouponGenericMetadata();
        coupongenericmetadata.pageId = getClass().getSimpleName();
        coupongenericmetadata.position = String.format("%d,%d", new Object[] {
            Integer.valueOf(coupontopitem.getVerticalPosition()), Integer.valueOf(coupontopitem.getHorizontalPosition())
        });
        if (coupontopitem instanceof CouponMerchant)
        {
            coupongenericmetadata.merchantId = coupontopitem.getRemoteId();
            Logger logger = this.logger;
            String s;
            if (com.groupon.v3.view.list_view.CouponTopItemType.ItemType.NEARBY.equals(coupontopitem.getItemType()))
            {
                s = "nearby_stores_click";
            } else
            {
                s = "top_merchant_click";
            }
            logger.logClick("", s, Channel.COUPONS.toString(), coupongenericmetadata);
            startActivity(intentFactory.newCouponMerchantFilterPageIntent((CouponMerchant)coupontopitem));
        } else
        if (coupontopitem instanceof CouponCategory)
        {
            coupongenericmetadata.categoryId = coupontopitem.getRemoteId();
            this.logger.logClick("", "top_category_click", Channel.COUPONS.toString(), coupongenericmetadata);
            startActivity(intentFactory.newCouponCategoryFilterPageIntent((CouponCategory)coupontopitem));
            return;
        }
    }

    public void onViewBound(int i, Object obj)
    {
        if (obj instanceof CouponSummaryWrapper)
        {
            logImpressionCouponSummary((CouponSummaryWrapper)obj);
        } else
        if (obj instanceof CouponTopItemType)
        {
            logImpressionsForCouponTopItemType((CouponTopItemType)obj);
            return;
        }
    }

    public void onViewClick(View view)
    {
        view = ((View) (view.getTag(0x7f100001)));
        if (view.getClass() == com/groupon/v3/view/list_view/CouponSummaryWrapper)
        {
            onCouponClick((CouponSummaryWrapper)view);
        } else
        {
            if (view.getClass() == com/groupon/db/models/CouponCategory || view.getClass() == com/groupon/db/models/CouponMerchant)
            {
                onTopItemChicletClick((CouponTopItem)view);
                return;
            }
            if (view.getClass() == com/groupon/v3/view/list_view/CouponListItemType)
            {
                view = (CouponListItemType)view;
                CouponGenericMetadata coupongenericmetadata = new CouponGenericMetadata();
                coupongenericmetadata.pageId = getClass().getSimpleName();
                if (view.isType(com.groupon.v3.view.list_view.CouponListItemType.ListItemType.COUPON_LIST_HEADER_MERCHANTS))
                {
                    loggingUtils.logClickWithMetadata("", "search_store_click", Channel.COUPONS.toString(), coupongenericmetadata);
                    startActivity(intentFactory.newCouponSearchIntent());
                    return;
                }
                if (view.isType(com.groupon.v3.view.list_view.CouponListItemType.ListItemType.COUPON_LIST_HEADER_CATEGORIES))
                {
                    loggingUtils.logClickWithMetadata("", "see_all_click", Channel.COUPONS.toString(), coupongenericmetadata);
                    startActivity(intentFactory.newCouponCategoryNavigateIntent());
                    return;
                }
            }
        }
    }

    public void setUserVisibleHint(boolean flag)
    {
        super.setUserVisibleHint(flag);
        if (flag)
        {
            String s = getClass().getSimpleName();
            logger.logPageView("", s, Logger.NULL_NST_FIELD);
            if (!userManager.hasSeenCouponsIntroScreen())
            {
                scrollToolBarHelper.snapDown();
            }
        }
    }
}
