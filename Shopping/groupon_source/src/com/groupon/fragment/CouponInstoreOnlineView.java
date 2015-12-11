// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.groupon.Channel;
import com.groupon.activity.CouponInstoreOnlinePage;
import com.groupon.activity.IntentFactory;
import com.groupon.db.events.UniversalUpdateEvent;
import com.groupon.db.models.CouponCategory;
import com.groupon.db.models.CouponMerchant;
import com.groupon.db.models.CouponSummary;
import com.groupon.manager.UniversalSyncManager;
import com.groupon.manager.sync_process.CouponResultSyncManagerProcess;
import com.groupon.manager.sync_process.CouponSingleCategorySyncManagerProcess;
import com.groupon.models.nst.CouponGenericMetadata;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.LoggingUtils;
import com.groupon.v3.adapter.UniversalListAdapter;
import com.groupon.v3.adapter.callback.IViewCallback;
import com.groupon.v3.adapter.mapping.CouponCardMapping;
import com.groupon.v3.adapter.mapping.NextPageTriggerMapping;
import com.groupon.v3.adapter.mapping.PendingViewMapping;
import com.groupon.v3.loader.UniversalListLoadResultData;
import com.groupon.v3.loader.UniversalLoaderCallbacks;
import com.groupon.v3.processor.BackgroundDataProcessor;
import com.groupon.v3.processor.PaginationInserter;
import com.groupon.v3.processor.SingleListCouponLoader;
import com.groupon.v3.view.list_view.CouponSummaryWrapper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.fragment:
//            BaseRecyclerViewFragment

public abstract class CouponInstoreOnlineView extends BaseRecyclerViewFragment
    implements IViewCallback
{

    private static final String COUPON_LIST_ITEM_TYPE = "coupon_list_item_type";
    private static final String COUPON_SLUG = "coupon_slug";
    private static final String TITLE = "title";
    protected String categoryOrMerchantTitle;
    protected com.groupon.v3.view.list_view.CouponListItemType.ListItemType couponListItemType;
    protected String couponSlug;
    protected String filterId;
    protected int pageCount;

    public CouponInstoreOnlineView()
    {
        pageCount = 0;
    }

    public CouponInstoreOnlineView(String s, Channel channel, String s1, com.groupon.v3.view.list_view.CouponListItemType.ListItemType listitemtype, String s2, String s3)
    {
        super(channel, (new StringBuilder()).append(Channel.COUPONS).append(s1).append(s2).toString());
        pageCount = 0;
        filterId = s;
        couponListItemType = listitemtype;
        couponSlug = s2;
        categoryOrMerchantTitle = s3;
    }

    private List filterCouponMerchantAndCategory(List list)
    {
        CouponCategory couponcategory = null;
        Object obj = null;
        ArrayList arraylist = new ArrayList();
        Iterator iterator = list.iterator();
        list = obj;
        while (iterator.hasNext()) 
        {
            Object obj1 = iterator.next();
            if (obj1 instanceof CouponCategory)
            {
                couponcategory = (CouponCategory)obj1;
            } else
            if (obj1 instanceof CouponMerchant)
            {
                list = (CouponMerchant)obj1;
            } else
            {
                arraylist.add(obj1);
            }
        }
        if (isCouponMerchant() && list != null)
        {
            setCouponMerchant(list);
        } else
        if (couponcategory != null)
        {
            setCouponCategory(couponcategory);
            return arraylist;
        }
        return arraylist;
    }

    private void logImpressionCouponSummary(CouponSummaryWrapper couponsummarywrapper)
    {
        Object obj = couponsummarywrapper.getCouponSummary();
        CouponGenericMetadata coupongenericmetadata = new CouponGenericMetadata();
        coupongenericmetadata.couponId = ((CouponSummary) (obj)).remoteId;
        coupongenericmetadata.pageId = com/groupon/activity/CouponInstoreOnlinePage.getSimpleName();
        if (isInstorePage())
        {
            obj = "coupon_instore_view";
        } else
        {
            obj = "coupon_online_view";
        }
        coupongenericmetadata.pageSection = ((String) (obj));
        if (isCouponMerchant())
        {
            obj = null;
        } else
        {
            obj = couponSlug;
        }
        coupongenericmetadata.categoryId = ((String) (obj));
        loggingUtils.redirectLogImpression(getClass().getSimpleName(), "", "freebies_impression", Channel.COUPONS.toString(), (new StringBuilder()).append(couponsummarywrapper.getPosition()).append(",0").toString(), coupongenericmetadata);
    }

    private void logPageView()
    {
        CouponGenericMetadata coupongenericmetadata = new CouponGenericMetadata();
        String s;
        if (isInstorePage())
        {
            s = "coupon_instore_view";
        } else
        {
            s = "coupon_online_view";
        }
        coupongenericmetadata.pageSection = s;
        if (isCouponMerchant())
        {
            coupongenericmetadata.merchantId = filterId;
        } else
        {
            coupongenericmetadata.categoryId = couponSlug;
        }
        loggingUtils.redirectLogPageView(getClass().getSimpleName(), "", com/groupon/activity/CouponInstoreOnlinePage.getSimpleName(), coupongenericmetadata);
    }

    private void setCount(int i)
    {
        CouponInstoreOnlinePage couponinstoreonlinepage = (CouponInstoreOnlinePage)getActivity();
        if (isInstorePage())
        {
            couponinstoreonlinepage.setInstoreCount(i);
            return;
        } else
        {
            couponinstoreonlinepage.setOnlineCount(i);
            return;
        }
    }

    private void updateDetails(String s, int i, int j)
    {
        CouponInstoreOnlinePage couponinstoreonlinepage = (CouponInstoreOnlinePage)getActivity();
        if (couponinstoreonlinepage == null)
        {
            return;
        }
        if (Strings.isEmpty(categoryOrMerchantTitle))
        {
            categoryOrMerchantTitle = s;
        }
        configureEmptyView(emptyView);
        couponinstoreonlinepage.setTitle(categoryOrMerchantTitle);
        if (!isCouponMerchant() && isInstorePage())
        {
            couponinstoreonlinepage.setOnlineCount(j);
            couponinstoreonlinepage.setInstoreCount(i);
        }
        couponinstoreonlinepage.updateDeeplinkSelection(j, i);
    }

    protected void configureEmptyView(View view)
    {
        TextView textview = (TextView)view.findViewById(0x7f1001d8);
        view = (TextView)view.findViewById(0x7f1001d9);
        if (isInstorePage())
        {
            textview.setText(getString(0x7f0800e7));
            view.setText(String.format(getString(0x7f0800e6), new Object[] {
                categoryOrMerchantTitle
            }));
            return;
        } else
        {
            textview.setText(getString(0x7f0800e9));
            view.setText(String.format(getString(0x7f0800e8), new Object[] {
                categoryOrMerchantTitle
            }));
            return;
        }
    }

    protected void configureLoaderAndAdapter(UniversalListAdapter universallistadapter, UniversalLoaderCallbacks universalloadercallbacks)
    {
        boolean flag = true;
        PaginationInserter paginationinserter = new PaginationInserter();
        universalloadercallbacks.setBackgroundDataProcessors(new BackgroundDataProcessor[] {
            new SingleListCouponLoader(getActivity(), dbChannel, isCouponMerchant()), paginationinserter
        });
        if (!isInstorePage() || !isCouponMerchant())
        {
            flag = false;
        }
        universallistadapter.registerOverrideMapping((new CouponCardMapping(flag)).registerCallback(com/groupon/v3/adapter/callback/IViewCallback, this));
        universallistadapter.registerOverrideMapping(new PendingViewMapping());
        universallistadapter.registerOverrideMapping(new NextPageTriggerMapping(this));
    }

    protected void configureSyncManager(UniversalSyncManager universalsyncmanager)
    {
        ArrayList arraylist = new ArrayList();
        if (!isCouponMerchant() && isInstorePage())
        {
            arraylist.add(new CouponSingleCategorySyncManagerProcess(getActivity(), dbChannel, couponSlug));
        }
        universalsyncmanager.configurePaginatedSyncManager(new CouponResultSyncManagerProcess(getActivity(), dbChannel, couponListItemType, getPageType(), couponSlug, isCouponMerchant()), arraylist, new UniversalUpdateEvent(dbChannel));
    }

    public int getEmptyViewLayoutId()
    {
        return 0x7f030075;
    }

    public abstract com.groupon.activity.CouponInstoreOnlinePage.PageType getPageType();

    public boolean isCouponMerchant()
    {
        return com.groupon.v3.view.list_view.CouponListItemType.ListItemType.COUPON_MERCHANT.equals(couponListItemType);
    }

    public boolean isInstorePage()
    {
        return com.groupon.activity.CouponInstoreOnlinePage.PageType.INSTORE.equals(getPageType());
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
    }

    public void onCouponClick(CouponSummaryWrapper couponsummarywrapper)
    {
        CouponSummary couponsummary = couponsummarywrapper.getCouponSummary();
        CouponGenericMetadata coupongenericmetadata = new CouponGenericMetadata();
        coupongenericmetadata.position = (new StringBuilder()).append(couponsummarywrapper.getPosition()).append(",0").toString();
        coupongenericmetadata.pageId = com/groupon/activity/CouponInstoreOnlinePage.getSimpleName();
        coupongenericmetadata.couponId = couponsummary.remoteId;
        Logger logger = this.logger;
        if (isInstorePage())
        {
            couponsummarywrapper = "coupon_instore_click";
        } else
        {
            couponsummarywrapper = "coupon_online_click";
        }
        logger.logClick("", couponsummarywrapper, Channel.COUPONS.toString(), coupongenericmetadata);
        startActivity(intentFactory.newCouponDetailsIntent(couponsummary.remoteId, Channel.COUPONS));
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (bundle != null)
        {
            couponListItemType = (com.groupon.v3.view.list_view.CouponListItemType.ListItemType)bundle.getSerializable("coupon_list_item_type");
            couponSlug = bundle.getString("coupon_slug");
            categoryOrMerchantTitle = bundle.getString("title");
        }
    }

    public void onLoaderDataChanged(UniversalListLoadResultData universallistloadresultdata, boolean flag)
    {
        super.onLoaderDataChanged(new UniversalListLoadResultData(filterCouponMerchantAndCategory(universallistloadresultdata.getListData()), universallistloadresultdata.getDealSubsetAttribute(), universallistloadresultdata.getPagination()), flag);
        if (emptyView.getVisibility() == 0)
        {
            setCount(0);
            CouponGenericMetadata coupongenericmetadata = new CouponGenericMetadata();
            coupongenericmetadata.pageId = com/groupon/activity/CouponInstoreOnlinePage.getSimpleName();
            if (isInstorePage())
            {
                universallistloadresultdata = "coupon_instore_view";
            } else
            {
                universallistloadresultdata = "coupon_online_view";
            }
            coupongenericmetadata.pageSection = universallistloadresultdata;
            loggingUtils.redirectLogPageView(getClass().getSimpleName(), "", "freebies_no_results", coupongenericmetadata);
        }
    }

    public void onResume()
    {
        super.onResume();
        logPageView();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("coupon_list_item_type", couponListItemType);
        bundle.putString("coupon_slug", couponSlug);
        bundle.putString("title", categoryOrMerchantTitle);
    }

    public void onViewBound(int i, Object obj)
    {
        if (obj instanceof CouponSummaryWrapper)
        {
            logImpressionCouponSummary((CouponSummaryWrapper)obj);
        }
    }

    public void onViewClick(View view)
    {
        view = ((View) (view.getTag(0x7f100001)));
        if (view.getClass() == com/groupon/v3/view/list_view/CouponSummaryWrapper)
        {
            onCouponClick((CouponSummaryWrapper)view);
        }
    }

    public void setCouponCategory(CouponCategory couponcategory)
    {
        int i;
        if (isInstorePage())
        {
            i = couponcategory.instoreCouponsCount;
        } else
        {
            i = couponcategory.onlineCouponsCount;
        }
        pageCount = i;
        if (isInstorePage() || !isInstorePage() && couponcategory.instoreCouponsCount == 0)
        {
            updateDetails(couponcategory.getTitle(), couponcategory.instoreCouponsCount, couponcategory.onlineCouponsCount);
        }
    }

    public void setCouponMerchant(CouponMerchant couponmerchant)
    {
        int i;
        if (isInstorePage())
        {
            i = couponmerchant.instoreCouponsCount;
        } else
        {
            i = couponmerchant.onlineCouponsCount;
        }
        pageCount = i;
        if (isInstorePage() || !isInstorePage() && couponmerchant.instoreCouponsCount == 0)
        {
            updateDetails(couponmerchant.getTitle(), couponmerchant.instoreCouponsCount, couponmerchant.onlineCouponsCount);
        }
        if (isInstorePage())
        {
            i = couponmerchant.instoreCouponsCount;
        } else
        {
            i = couponmerchant.onlineCouponsCount;
        }
        setCount(i);
    }

    public void setTitle(String s)
    {
        if (Strings.isEmpty(categoryOrMerchantTitle))
        {
            categoryOrMerchantTitle = s;
            configureEmptyView(emptyView);
        }
    }
}
