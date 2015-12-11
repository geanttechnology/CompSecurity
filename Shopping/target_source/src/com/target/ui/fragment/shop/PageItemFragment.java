// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.shop;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.a.a.e;
import com.target.mothership.common.page_item.PageIdentifier;
import com.target.mothership.common.page_item.d;
import com.target.mothership.common.params.PageItemParams;
import com.target.mothership.common.params.ProductSummaryParam;
import com.target.mothership.common.product.EndecaId;
import com.target.mothership.common.product.ProductIdentifier;
import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.common.weeklyad.PromotionRequest;
import com.target.mothership.model.dvm.interfaces.DvmDataResponse;
import com.target.mothership.model.dvm.interfaces.DvmRemoteData;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.page_item.interfaces.Action;
import com.target.mothership.model.page_item.interfaces.CustomAction;
import com.target.mothership.model.page_item.interfaces.DigitalVendorMarketing;
import com.target.mothership.model.page_item.interfaces.DisplayDates;
import com.target.mothership.model.page_item.interfaces.ImageInfo;
import com.target.mothership.model.page_item.interfaces.PageItem;
import com.target.mothership.model.page_item.interfaces.PageItemCollection;
import com.target.mothership.model.page_item.interfaces.TrackingInfo;
import com.target.mothership.model.store.interfaces.RelevantStoreSummary;
import com.target.mothership.model.store.interfaces.Store;
import com.target.mothership.model.store.interfaces.StoreSummary;
import com.target.mothership.services.x;
import com.target.mothership.util.o;
import com.target.ui.analytics.a.ac;
import com.target.ui.analytics.a.az;
import com.target.ui.analytics.h;
import com.target.ui.fragment.account.AuthenticateDialog;
import com.target.ui.fragment.common.BaseStoreChooserFragment;
import com.target.ui.fragment.common.ErrorDialogFragment;
import com.target.ui.fragment.common.SimpleThankYouDialogFragment;
import com.target.ui.fragment.product.common.PageItemHierarchy;
import com.target.ui.fragment.product.pdp.ProductDetailsPageFragment;
import com.target.ui.fragment.product.plp.ProductSummaryPageFragment;
import com.target.ui.fragment.weekly_ad.WeeklyAdFragment;
import com.target.ui.helper.g.a;
import com.target.ui.helper.q.b;
import com.target.ui.model.weekly_ad.WeeklyAdHomepageData;
import com.target.ui.service.k;
import com.target.ui.util.ae;
import com.target.ui.util.ai;
import com.target.ui.util.deep_link.PromotionParams;
import com.target.ui.util.deep_link.f;
import com.target.ui.util.deep_link.g;
import com.target.ui.util.j;
import com.target.ui.util.m;
import com.target.ui.util.q;
import com.target.ui.util.y;
import com.target.ui.view.BitmapImageView;
import com.target.ui.view.common.c;
import com.target.ui.view.shop.PageItemLayout;
import com.target.ui.view.shop.PageItemView;
import com.target.ui.view.shop.ShopDvmView;
import com.target.ui.view.shop.WeeklyAdCardView;
import com.target.ui.view.shop.WeeklyAdView;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.target.ui.fragment.shop:
//            ChildPageItemFragment, PageItemCustomActionDialogFragment

public abstract class PageItemFragment extends BaseStoreChooserFragment
    implements com.target.ui.adapter.h.b.b, com.target.ui.adapter.h.b.c, com.target.ui.adapter.h.b.d, az, com.target.ui.fragment.account.BaseAccountDialog.b, PageItemCustomActionDialogFragment.a, com.target.ui.fragment.shop.a.a.a, com.target.ui.service.k.c, c
{
    static class Views extends com.target.ui.view.a
    {

        PageItemLayout pageItemLayout;

        Views(View view)
        {
            super(view);
        }
    }

    private class a
        implements com.target.ui.fragment.account.BaseAccountDialog.a
    {

        final PageItemFragment this$0;

        public void a(Guest guest)
        {
            if (com.target.ui.fragment.shop.PageItemFragment.a(PageItemFragment.this) == null)
            {
                return;
            } else
            {
                com.target.ui.fragment.shop.PageItemFragment.a(PageItemFragment.this, getString(0x7f0903f3));
                return;
            }
        }

        public void a(String s1)
        {
            if (com.target.ui.fragment.shop.PageItemFragment.a(PageItemFragment.this) == null)
            {
                return;
            } else
            {
                com.target.ui.fragment.shop.PageItemFragment.a(PageItemFragment.this, getString(0x7f09006c));
                return;
            }
        }

        public void b(Object obj)
        {
            if (com.target.ui.fragment.shop.PageItemFragment.a(PageItemFragment.this) == null)
            {
                return;
            } else
            {
                com.target.ui.fragment.shop.PageItemFragment.a(PageItemFragment.this, true);
                return;
            }
        }

        public void b(String s1)
        {
            if (com.target.ui.fragment.shop.PageItemFragment.a(PageItemFragment.this) == null)
            {
                return;
            } else
            {
                com.target.ui.fragment.shop.PageItemFragment.a(PageItemFragment.this, getString(0x7f090074));
                return;
            }
        }

        public void c()
        {
        }

        public void n_()
        {
        }

        private a()
        {
            this$0 = PageItemFragment.this;
            super();
        }

    }

    public static final class b extends Enum
    {

        private static final b $VALUES[];
        public static final b CATEGORIES;
        public static final b CUSTOM;
        public static final b DEALS;
        public static final b FEATURED;

        public static b valueOf(String s1)
        {
            return (b)Enum.valueOf(com/target/ui/fragment/shop/PageItemFragment$b, s1);
        }

        public static b[] values()
        {
            return (b[])$VALUES.clone();
        }

        static 
        {
            CATEGORIES = new b("CATEGORIES", 0);
            CUSTOM = new b("CUSTOM", 1);
            DEALS = new b("DEALS", 2);
            FEATURED = new b("FEATURED", 3);
            $VALUES = (new b[] {
                CATEGORIES, CUSTOM, DEALS, FEATURED
            });
        }

        private b(String s1, int i1)
        {
            super(s1, i1);
        }
    }


    private static final String ARG_MUTE_VIEW_EVENTS = "muteViewEvents";
    private static final String ARG_PAGE_IDENTIFIER = "pageIdentifier";
    private static final String ARG_PAGE_ITEM_HIERARCHY = "pageItemHierarchy";
    private static final String ARG_PAGE_ITEM_PARAMS = "pageItemParams";
    private static final String ARG_PROMOTION_APPLIED = "promotionApplied";
    private static final String ARG_PROMOTION_PARAMS = "promotionParams";
    private static final String ARG_WEEKLY_AD_PROMOTION_REQUEST = "weeklyAdRequestParams";
    private static final long DATA_REFRESH_INTERVAL_MS = 0xdbba00L;
    private static final boolean MUTE_VIEW_EVENTS_DEFAULT = true;
    public static final String TAG = com/target/ui/fragment/shop/PageItemFragment.getSimpleName();
    private com.target.mothership.model.coupon_wallets.c mCouponWalletsManager;
    private e mCurrentStore;
    private com.target.ui.helper.g.a mDvmDataHelper;
    private Map mDvmDataMap;
    private Date mLastUpdatedDate;
    private h mLoadingTimestamp;
    private PageIdentifier mPageIdentifier;
    private com.target.mothership.model.page_item.c mPageItemManager;
    private PageItemParams mPageItemParamsOverride;
    private final com.target.mothership.model.h mPageItemReceiver = new com.target.mothership.model.h() {

        final PageItemFragment this$0;

        public String a()
        {
            return com.target.ui.fragment.shop.PageItemFragment.d(PageItemFragment.this);
        }

        public void a(PageItemCollection pageitemcollection)
        {
            if (com.target.ui.fragment.shop.PageItemFragment.a(PageItemFragment.this) == null)
            {
                return;
            } else
            {
                com.target.ui.fragment.shop.PageItemFragment.a(PageItemFragment.this, pageitemcollection);
                PageItemFragment.this.c();
                com.target.ui.fragment.shop.PageItemFragment.a(PageItemFragment.this).pageItemLayout.a(false);
                com.target.ui.fragment.shop.PageItemFragment.b(PageItemFragment.this, pageitemcollection);
                PageItemFragment.this.a(pageitemcollection.a());
                PageItemFragment.this.a(com.target.ui.fragment.shop.PageItemFragment.a(PageItemFragment.this, com.target.ui.fragment.shop.PageItemFragment.f(PageItemFragment.this)));
                com.target.ui.fragment.shop.PageItemFragment.c(PageItemFragment.this, pageitemcollection);
                com.target.ui.fragment.shop.PageItemFragment.g(PageItemFragment.this);
                return;
            }
        }

        public void a(x x1)
        {
            if (com.target.ui.fragment.shop.PageItemFragment.a(PageItemFragment.this) == null)
            {
                return;
            }
            if (com.target.ui.fragment.shop.PageItemFragment.h(PageItemFragment.this) != null && com.target.ui.fragment.shop.PageItemFragment.h(PageItemFragment.this).d().b())
            {
                x1 = com.target.ui.fragment.shop.PageItemFragment.a(PageItemFragment.this, (Store)com.target.ui.fragment.shop.PageItemFragment.e(PageItemFragment.this).d(), com.target.ui.fragment.shop.PageItemFragment.h(PageItemFragment.this));
                if (x1.b())
                {
                    x1 = ae.a(((StoreIdentifier)x1.c()).a());
                } else
                {
                    x1 = null;
                }
                x1 = new ProductSummaryParam(x1, null, (EndecaId)com.target.ui.fragment.shop.PageItemFragment.h(PageItemFragment.this).d().c(), null);
                m().i(ProductSummaryPageFragment.a(x1, false));
                return;
            } else
            {
                com.target.ui.fragment.shop.PageItemFragment.a(PageItemFragment.this, x1);
                return;
            }
        }

        public volatile void a(Object obj)
        {
            a((PageItemCollection)obj);
        }

        public void b(Object obj)
        {
            a((x)obj);
        }

            
            {
                this$0 = PageItemFragment.this;
                super();
            }
    };
    private List mPageItems;
    private boolean mPromotionApplied;
    private PromotionParams mPromotionParams;
    private a mReauthDialogListenerDelegate;
    private String mRequestTag;
    private PageItemCollection mSavedPage;
    private List mSavedWeeklyAdData;
    private com.target.ui.e.f mScrollingTabCoordinator;
    private com.target.ui.view.common.h mSnackBar;
    private Views mViews;
    private com.target.ui.helper.q.b mWeeklyAdFullDataHelper;
    private PromotionRequest mWeeklyAdPromotionRequest;

    public PageItemFragment()
    {
        mLoadingTimestamp = new h();
        mPromotionApplied = false;
        mCurrentStore = com.google.a.a.e.e();
    }

    static long a(PageItemFragment pageitemfragment, h h1)
    {
        return pageitemfragment.a(h1);
    }

    private e a(Store store, PageItemParams pageitemparams)
    {
        Object obj = null;
        if (pageitemparams == null || !pageitemparams.c().b()) goto _L2; else goto _L1
_L1:
        pageitemparams = (StoreIdentifier)pageitemparams.c().c();
_L4:
        return com.google.a.a.e.c(pageitemparams);
_L2:
        pageitemparams = obj;
        if (store != null)
        {
            pageitemparams = store.getStoreId();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    static e a(PageItemFragment pageitemfragment, Store store, PageItemParams pageitemparams)
    {
        return pageitemfragment.a(store, pageitemparams);
    }

    static PageItemCollection a(PageItemFragment pageitemfragment, PageItemCollection pageitemcollection)
    {
        pageitemfragment.mSavedPage = pageitemcollection;
        return pageitemcollection;
    }

    static Views a(PageItemFragment pageitemfragment)
    {
        return pageitemfragment.mViews;
    }

    static List a(PageItemFragment pageitemfragment, List list)
    {
        pageitemfragment.mSavedWeeklyAdData = list;
        return list;
    }

    private void a(final DvmRemoteData dvmRemoteData)
    {
        mDvmDataHelper.a(dvmRemoteData, new com.target.ui.helper.g.a.a() {

            final PageItemFragment this$0;
            final DvmRemoteData val$dvmRemoteData;

            public void b(DvmDataResponse dvmdataresponse)
            {
                if (com.target.ui.fragment.shop.PageItemFragment.a(PageItemFragment.this) == null)
                {
                    return;
                } else
                {
                    com.target.ui.fragment.shop.PageItemFragment.b(PageItemFragment.this).put(dvmRemoteData.a(), dvmdataresponse);
                    com.target.ui.fragment.shop.PageItemFragment.a(PageItemFragment.this).pageItemLayout.a(dvmRemoteData.a(), dvmdataresponse);
                    return;
                }
            }

            public void b(x x1)
            {
                com.target.ui.util.q.a(PageItemFragment.TAG, "Error retrieving dvm data");
            }

            public void n()
            {
                if (com.target.ui.fragment.shop.PageItemFragment.c(PageItemFragment.this) != null)
                {
                    com.target.ui.fragment.shop.PageItemFragment.b(PageItemFragment.this, getString(0x7f0902fc));
                }
            }

            
            {
                this$0 = PageItemFragment.this;
                dvmRemoteData = dvmremotedata;
                super();
            }
        });
    }

    private void a(Guest guest, final com.target.mothership.services.o retryable, final String errorMessage)
    {
        if (guest.isAnonymous())
        {
            com.target.ui.service.a.a().a(guest, new com.target.mothership.model.h() {

                final PageItemFragment this$0;
                final String val$errorMessage;
                final com.target.mothership.services.o val$retryable;

                public void a(Guest guest1)
                {
                    if (com.target.ui.fragment.shop.PageItemFragment.a(PageItemFragment.this) == null)
                    {
                        return;
                    }
                    if (retryable == null)
                    {
                        com.target.ui.fragment.shop.PageItemFragment.b(PageItemFragment.this, errorMessage);
                        return;
                    }
                    try
                    {
                        retryable.a();
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (Guest guest1)
                    {
                        com.target.ui.util.q.a(PageItemFragment.TAG, (new StringBuilder()).append("NullPointerException : ").append(guest1.getMessage()).toString());
                    }
                    com.target.ui.fragment.shop.PageItemFragment.b(PageItemFragment.this, errorMessage);
                }

                public void a(x x1)
                {
                    if (com.target.ui.fragment.shop.PageItemFragment.a(PageItemFragment.this) == null)
                    {
                        return;
                    } else
                    {
                        com.target.ui.fragment.shop.PageItemFragment.b(PageItemFragment.this, errorMessage);
                        return;
                    }
                }

                public volatile void a(Object obj)
                {
                    a((Guest)obj);
                }

                public void b(Object obj)
                {
                    a((x)obj);
                }

            
            {
                this$0 = PageItemFragment.this;
                retryable = o1;
                errorMessage = s1;
                super();
            }
            });
            return;
        }
        guest = AuthenticateDialog.a(guest, this);
        if (retryable != null)
        {
            guest.a(retryable);
        }
        guest.show(getFragmentManager(), AuthenticateDialog.TAG);
    }

    private void a(PageItem pageitem)
    {
        ChildPageItemFragment childpageitemfragment = com.target.ui.fragment.shop.ChildPageItemFragment.a(pageitem, t());
        childpageitemfragment.a(com.target.ui.util.y.a(pageitem, p()));
        m().d(childpageitemfragment);
    }

    private void a(PageItem pageitem, int i1, int j1)
    {
        if (!pageitem.j().b())
        {
            return;
        } else
        {
            ac.a((TrackingInfo)pageitem.j().c(), i1, j1).e();
            return;
        }
    }

    private void a(PageItemCollection pageitemcollection)
    {
        pageitemcollection = pageitemcollection.a().iterator();
_L4:
        if (!pageitemcollection.hasNext()) goto _L2; else goto _L1
_L1:
        if (!((PageItem)pageitemcollection.next()).k().b()) goto _L4; else goto _L3
_L3:
        boolean flag;
        for (flag = true; !flag || !i() || !mCurrentStore.b();)
        {
            return;
        }

        mSavedWeeklyAdData = null;
        mWeeklyAdFullDataHelper.a(((RelevantStoreSummary)mCurrentStore.c()).getStoreId(), mWeeklyAdPromotionRequest, new com.target.ui.helper.q.b.b() {

            final PageItemFragment this$0;

            public void a(com.target.mothership.model.weeklyad.interfaces.a.b b1)
            {
                if (com.target.ui.fragment.shop.PageItemFragment.a(PageItemFragment.this) == null)
                {
                    return;
                } else
                {
                    com.target.ui.util.q.a(PageItemFragment.TAG, "Error retrieving multi-weekly store slug.");
                    return;
                }
            }

            public void a(com.target.ui.helper.q.b.a a1, List list)
            {
                if (com.target.ui.fragment.shop.PageItemFragment.a(PageItemFragment.this) != null)
                {
                    com.target.ui.util.q.a(PageItemFragment.TAG, "Error retrieving multi-weekly ad page information.");
                    if (list.size() > 0)
                    {
                        com.target.ui.fragment.shop.PageItemFragment.a(PageItemFragment.this).pageItemLayout.setWeeklyAdData(list);
                        return;
                    }
                }
            }

            public void a(List list)
            {
                if (com.target.ui.fragment.shop.PageItemFragment.a(PageItemFragment.this) == null)
                {
                    return;
                } else
                {
                    com.target.ui.fragment.shop.PageItemFragment.a(PageItemFragment.this, list);
                    com.target.ui.fragment.shop.PageItemFragment.a(PageItemFragment.this).pageItemLayout.setWeeklyAdData(list);
                    return;
                }
            }

            
            {
                this$0 = PageItemFragment.this;
                super();
            }
        });
        return;
_L2:
        flag = false;
        if (true) goto _L3; else goto _L5
_L5:
    }

    private void a(x x1)
    {
        mViews.pageItemLayout.a(false);
        if (mSavedPage == null)
        {
            mViews.pageItemLayout.a(com.target.ui.view.common.b.a.ERROR_DEFAULT, true);
        }
        if (x1 != null)
        {
            com.target.ui.util.q.d(TAG, x1.getMessage());
        }
    }

    private void a(ProductDetailsPageFragment productdetailspagefragment, BitmapImageView bitmapimageview, String s1)
    {
        bitmapimageview = new com.target.ui.f.a(getActivity(), this, bitmapimageview, productdetailspagefragment.a());
        bitmapimageview.a(s1);
        (new com.target.ui.f.b(m())).a(productdetailspagefragment, bitmapimageview);
    }

    private void a(b b1, PageItemParams pageitemparams, PageIdentifier pageidentifier)
    {
        boolean flag;
        flag = true;
        if (mSavedPage == null)
        {
            mViews.pageItemLayout.a(true);
        }
        mLoadingTimestamp = new h();
        static class _cls9
        {

            static final int $SwitchMap$com$target$mothership$model$coupon_wallets$interfaces$error$AddCouponToWalletFailure$AddCouponToWalletFailureReason[];
            static final int $SwitchMap$com$target$ui$fragment$shop$PageItemFragment$RequestType[];
            static final int $SwitchMap$com$target$ui$util$deep_link$DeepLinkReport$CustomAction[];
            static final int $SwitchMap$com$target$ui$util$deep_link$DeepLinkReport$ReportType[];

            static 
            {
                $SwitchMap$com$target$ui$fragment$shop$PageItemFragment$RequestType = new int[b.values().length];
                try
                {
                    $SwitchMap$com$target$ui$fragment$shop$PageItemFragment$RequestType[b.CATEGORIES.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    $SwitchMap$com$target$ui$fragment$shop$PageItemFragment$RequestType[b.CUSTOM.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$com$target$ui$fragment$shop$PageItemFragment$RequestType[b.DEALS.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$com$target$ui$fragment$shop$PageItemFragment$RequestType[b.FEATURED.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                $SwitchMap$com$target$ui$util$deep_link$DeepLinkReport$CustomAction = new int[com.target.ui.util.deep_link.f.a.values().length];
                try
                {
                    $SwitchMap$com$target$ui$util$deep_link$DeepLinkReport$CustomAction[com.target.ui.util.deep_link.f.a.PROMOTION.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                $SwitchMap$com$target$ui$util$deep_link$DeepLinkReport$ReportType = new int[com.target.ui.util.deep_link.f.b.values().length];
                try
                {
                    $SwitchMap$com$target$ui$util$deep_link$DeepLinkReport$ReportType[com.target.ui.util.deep_link.f.b.FRAGMENT.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$target$ui$util$deep_link$DeepLinkReport$ReportType[com.target.ui.util.deep_link.f.b.CUSTOM_ACTION.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$target$ui$util$deep_link$DeepLinkReport$ReportType[com.target.ui.util.deep_link.f.b.DIALOG_FRAGMENT.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$target$ui$util$deep_link$DeepLinkReport$ReportType[com.target.ui.util.deep_link.f.b.NONE.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                $SwitchMap$com$target$mothership$model$coupon_wallets$interfaces$error$AddCouponToWalletFailure$AddCouponToWalletFailureReason = new int[com.target.mothership.model.coupon_wallets.interfaces.a.a.a.values().length];
                try
                {
                    $SwitchMap$com$target$mothership$model$coupon_wallets$interfaces$error$AddCouponToWalletFailure$AddCouponToWalletFailureReason[com.target.mothership.model.coupon_wallets.interfaces.a.a.a.ERR_TOKEN_EXPIRED.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$target$mothership$model$coupon_wallets$interfaces$error$AddCouponToWalletFailure$AddCouponToWalletFailureReason[com.target.mothership.model.coupon_wallets.interfaces.a.a.a.ERR_INVALID_COUPON_PROMOTION_ID.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$target$mothership$model$coupon_wallets$interfaces$error$AddCouponToWalletFailure$AddCouponToWalletFailureReason[com.target.mothership.model.coupon_wallets.interfaces.a.a.a.ERR_PROMOTION_NOT_AVAILABLE_AT_THIS_TIME.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$mothership$model$coupon_wallets$interfaces$error$AddCouponToWalletFailure$AddCouponToWalletFailureReason[com.target.mothership.model.coupon_wallets.interfaces.a.a.a.ERR_UNKNOWN.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls9..SwitchMap.com.target.ui.fragment.shop.PageItemFragment.RequestType[b1.ordinal()];
        JVM INSTR tableswitch 1 4: default 72
    //                   1 115
    //                   2 130
    //                   3 165
    //                   4 180;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        com.target.ui.util.q.a(TAG, "Invalid request type");
        flag = false;
_L7:
        if (!flag)
        {
            mViews.pageItemLayout.a(false);
            mViews.pageItemLayout.a(com.target.ui.view.common.b.a.ERROR_DEFAULT, false);
        }
        return;
_L2:
        mPageItemManager.a(pageitemparams, mPageItemReceiver);
        continue; /* Loop/switch isn't completed */
_L3:
        if (pageidentifier == null)
        {
            com.target.ui.util.q.a(TAG, "Tried to request custom page with no page identifier");
            flag = false;
        } else
        {
            mPageItemManager.a(pageidentifier, pageitemparams, mPageItemReceiver);
        }
        continue; /* Loop/switch isn't completed */
_L4:
        mPageItemManager.b(pageitemparams, mPageItemReceiver);
        continue; /* Loop/switch isn't completed */
_L5:
        mPageItemManager.c(pageitemparams, mPageItemReceiver);
        if (true) goto _L7; else goto _L6
_L6:
    }

    static void a(PageItemFragment pageitemfragment, Guest guest, com.target.mothership.services.o o1, String s1)
    {
        pageitemfragment.a(guest, o1, s1);
    }

    static void a(PageItemFragment pageitemfragment, x x1)
    {
        pageitemfragment.a(x1);
    }

    static void a(PageItemFragment pageitemfragment, PromotionParams promotionparams, Guest guest)
    {
        pageitemfragment.a(promotionparams, guest);
    }

    static void a(PageItemFragment pageitemfragment, f f1)
    {
        pageitemfragment.b(f1);
    }

    static void a(PageItemFragment pageitemfragment, String s1)
    {
        pageitemfragment.c(s1);
    }

    static void a(PageItemFragment pageitemfragment, boolean flag)
    {
        pageitemfragment.o(flag);
    }

    private void a(final PromotionParams promotionParams, final Guest guest)
    {
        if (!com.target.mothership.util.b.a().b())
        {
            b(getString(0x7f0903df));
            return;
        } else
        {
            o(true);
            mCouponWalletsManager.a(guest, promotionParams.a(), new com.target.mothership.model.d() {

                final PageItemFragment this$0;
                final Guest val$guest;
                final PromotionParams val$promotionParams;

                public void a(com.target.mothership.model.coupon_wallets.interfaces.a.a a1)
                {
                    if (com.target.ui.fragment.shop.PageItemFragment.a(PageItemFragment.this) == null)
                    {
                        return;
                    }
                    com.target.ui.fragment.shop.PageItemFragment.c(PageItemFragment.this, false);
                    _cls9..SwitchMap.com.target.mothership.model.coupon_wallets.interfaces.error.AddCouponToWalletFailure.AddCouponToWalletFailureReason[((com.target.mothership.model.coupon_wallets.interfaces.a.a.a)a1.e()).ordinal()];
                    JVM INSTR tableswitch 1 4: default 64
                //                               1 83
                //                               2 114
                //                               3 120
                //                               4 126;
                       goto _L1 _L2 _L3 _L4 _L5
_L1:
                    int i1 = 0x7f090495;
_L7:
                    com.target.ui.fragment.shop.PageItemFragment.b(PageItemFragment.this, getString(i1));
                    return;
_L2:
                    com.target.ui.fragment.shop.PageItemFragment.a(PageItemFragment.this, guest, (com.target.mothership.services.o)c().d(), getString(0x7f090495));
                    return;
_L3:
                    i1 = 0x7f090493;
                    continue; /* Loop/switch isn't completed */
_L4:
                    i1 = 0x7f090494;
                    continue; /* Loop/switch isn't completed */
_L5:
                    i1 = 0x7f090495;
                    if (true) goto _L7; else goto _L6
_L6:
                }

                public volatile void a(Object obj)
                {
                    a((Void)obj);
                }

                public void a(Void void1)
                {
                    while (com.target.ui.fragment.shop.PageItemFragment.a(PageItemFragment.this) == null || Z()) 
                    {
                        return;
                    }
                    com.target.ui.fragment.shop.PageItemFragment.b(PageItemFragment.this, false);
                    void1 = (Uri)promotionParams.b().d();
                    if (void1 != null)
                    {
                        com.target.ui.fragment.shop.PageItemFragment.a(PageItemFragment.this, com.target.ui.util.deep_link.g.a(void1, (Store)com.target.ui.fragment.shop.PageItemFragment.e(PageItemFragment.this).d()));
                        return;
                    } else
                    {
                        SimpleThankYouDialogFragment.a(getString(0x7f090500)).show(getFragmentManager(), SimpleThankYouDialogFragment.TAG);
                        return;
                    }
                }

                public void b(Object obj)
                {
                    a((com.target.mothership.model.coupon_wallets.interfaces.a.a)obj);
                }

            
            {
                this$0 = PageItemFragment.this;
                promotionParams = promotionparams;
                guest = guest1;
                super();
            }
            });
            return;
        }
    }

    private void a(f f1)
    {
        com.target.ui.util.deep_link.f.a a1 = (com.target.ui.util.deep_link.f.a)f1.a().c();
        switch (_cls9..SwitchMap.com.target.ui.util.deep_link.DeepLinkReport.CustomAction[a1.ordinal()])
        {
        default:
            ai.a(this, "Sorry, we could not process the given link");
            return;

        case 1: // '\001'
            (new com.target.ui.fragment.shop.a.b(this)).a((PromotionParams)f1.b().c().c());
            break;
        }
    }

    private final void a(String s1)
    {
        mDvmDataHelper.a(s1, new com.target.ui.helper.g.a.b() {

            final PageItemFragment this$0;

            public void a(Void void1)
            {
                com.target.ui.util.q.d(PageItemFragment.TAG, "Dvm click registered with google successfully");
            }

            public void c(x x1)
            {
                com.target.ui.util.q.a(PageItemFragment.TAG, "Dvm click failed to register with google");
            }

            
            {
                this$0 = PageItemFragment.this;
                super();
            }
        });
    }

    private boolean a(e e1, e e2)
    {
        boolean flag;
        boolean flag1;
        if (e2.b())
        {
            e2 = (RelevantStoreSummary)e2.c();
        } else
        {
            e2 = null;
        }
        if (e1.b())
        {
            e1 = (RelevantStoreSummary)e1.c();
        } else
        {
            e1 = null;
        }
        if (e1 == null && e2 == null)
        {
            return false;
        }
        if (e1 == null || e2 == null)
        {
            return true;
        }
        flag1 = e1.getStoreId().a().equals(e2.getStoreId().a());
        if (e1.a() == e2.a())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag1 || !flag)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        return flag1;
    }

    protected static Bundle b(PageItemParams pageitemparams)
    {
        return b(pageitemparams, ((PageIdentifier) (null)));
    }

    protected static Bundle b(PageItemParams pageitemparams, PageIdentifier pageidentifier)
    {
        Bundle bundle = new Bundle();
        bundle.putParcelable("pageItemParams", pageitemparams);
        bundle.putParcelable("pageIdentifier", pageidentifier);
        return bundle;
    }

    protected static Bundle b(PromotionRequest promotionrequest)
    {
        Bundle bundle = new Bundle();
        bundle.putParcelable("weeklyAdRequestParams", promotionrequest);
        return bundle;
    }

    protected static Bundle b(PromotionParams promotionparams)
    {
        Bundle bundle = new Bundle();
        bundle.putParcelable("promotionParams", promotionparams);
        return bundle;
    }

    static Map b(PageItemFragment pageitemfragment)
    {
        return pageitemfragment.mDvmDataMap;
    }

    private void b(Uri uri, String s1)
    {
        uri = (Fragment)com.target.ui.util.deep_link.g.a(uri, (Store)mCurrentStore.d()).d().d();
        if (uri == null)
        {
            com.target.ui.util.q.a(TAG, "No Fragment resulted after parsing the deep link");
            return;
        } else
        {
            a(s1);
            m().d(uri);
            return;
        }
    }

    private void b(PageItem pageitem)
    {
        pageitem = com.target.ui.fragment.shop.PageItemCustomActionDialogFragment.a((CustomAction)pageitem.d().c());
        pageitem.setTargetFragment(this, 0);
        pageitem.show(getFragmentManager(), PageItemCustomActionDialogFragment.TAG);
    }

    private void b(PageItem pageitem, PageItemView pageitemview)
    {
        if (Z())
        {
            return;
        }
        Object obj = (Action)pageitem.a().c();
        Object obj1 = Uri.parse(((Action) (obj)).b());
        if (!com.target.ui.util.deep_link.g.c(((Uri) (obj1))))
        {
            a(((Uri) (obj1)), (String)((Action) (obj)).a().d());
            return;
        }
        obj = com.target.ui.util.deep_link.g.a(((Uri) (obj1)), (Store)mCurrentStore.d());
        switch (_cls9..SwitchMap.com.target.ui.util.deep_link.DeepLinkReport.ReportType[((f) (obj)).e().ordinal()])
        {
        default:
            b(((f) (obj)));
            return;

        case 1: // '\001'
            obj1 = (Fragment)((f) (obj)).d().c();
            break;
        }
        if (com.target.ui.util.j.b() && pageitem.h().b() && (obj1 instanceof ProductDetailsPageFragment))
        {
            obj1 = (ProductDetailsPageFragment)obj1;
            pageitem = ((ImageInfo)pageitem.h().c()).b();
            a(((ProductDetailsPageFragment) (obj1)), pageitemview.getImage(), pageitem);
            c(((f) (obj)));
            return;
        }
        if (obj1 instanceof ProductSummaryPageFragment)
        {
            pageitemview = (ProductSummaryPageFragment)obj1;
            if (t() != null)
            {
                pageitemview.a(t());
                pageitemview.a(com.target.ui.util.y.a(pageitem, p()));
            }
            m().d(pageitemview);
            return;
        } else
        {
            m().d(((Fragment) (obj1)));
            return;
        }
    }

    private void b(PageItemCollection pageitemcollection)
    {
        Object obj = pageitemcollection.a();
        pageitemcollection = new ArrayList();
        obj = ((List) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            PageItem pageitem = (PageItem)((Iterator) (obj)).next();
            if (pageitem.e().b())
            {
                pageitemcollection.add(((DigitalVendorMarketing)pageitem.e().c()).a());
            }
        } while (true);
        if (!pageitemcollection.isEmpty())
        {
            pageitemcollection = pageitemcollection.iterator();
            while (pageitemcollection.hasNext()) 
            {
                DvmRemoteData dvmremotedata = m.a((String)pageitemcollection.next());
                if (dvmremotedata != null)
                {
                    a(dvmremotedata);
                }
            }
        }
    }

    private void b(StoreSummary storesummary)
    {
        m().d(WeeklyAdFragment.b(storesummary));
    }

    static void b(PageItemFragment pageitemfragment, PageItemCollection pageitemcollection)
    {
        pageitemfragment.b(pageitemcollection);
    }

    static void b(PageItemFragment pageitemfragment, String s1)
    {
        pageitemfragment.b(s1);
    }

    static void b(PageItemFragment pageitemfragment, boolean flag)
    {
        pageitemfragment.o(flag);
    }

    private void b(f f1)
    {
        switch (_cls9..SwitchMap.com.target.ui.util.deep_link.DeepLinkReport.ReportType[f1.e().ordinal()])
        {
        default:
            return;

        case 2: // '\002'
            a(f1);
            return;

        case 3: // '\003'
            f1 = (DialogFragment)f1.c().c();
            f1.show(getFragmentManager(), f1.getClass().getSimpleName());
            return;

        case 1: // '\001'
            m().d((Fragment)f1.d().c());
            return;

        case 4: // '\004'
            com.target.ui.util.q.a(TAG, "Could not handle deep link");
            break;
        }
    }

    private void b(String s1)
    {
        if (Z())
        {
            com.target.ui.util.q.a(TAG, "Attempted to call error dialog after saved instance state called");
            return;
        } else
        {
            ErrorDialogFragment.a(s1).show(getFragmentManager(), ErrorDialogFragment.TAG);
            return;
        }
    }

    private void b(List list)
    {
        StoreIdentifier storeidentifier;
        if (mCurrentStore.b())
        {
            storeidentifier = ((RelevantStoreSummary)mCurrentStore.c()).getStoreId();
        } else
        {
            storeidentifier = null;
        }
        if (storeidentifier == null)
        {
            mViews.pageItemLayout.setWeeklyAdData(null);
            return;
        }
        StoreIdentifier storeidentifier1;
        if (list != null && list.size() > 0)
        {
            storeidentifier1 = ((WeeklyAdHomepageData)list.get(0)).b();
        } else
        {
            storeidentifier1 = null;
        }
        if (storeidentifier1 != null && storeidentifier1.equals(storeidentifier))
        {
            mViews.pageItemLayout.setWeeklyAdData(list);
            return;
        } else
        {
            a(mSavedPage);
            return;
        }
    }

    static PageItemCollection c(PageItemFragment pageitemfragment)
    {
        return pageitemfragment.mSavedPage;
    }

    private List c(List list)
    {
        ArrayList arraylist = new ArrayList();
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            PageItem pageitem = (PageItem)list.next();
            boolean flag = true;
            if (pageitem.f().b())
            {
                DisplayDates displaydates = (DisplayDates)pageitem.f().c();
                flag = com.target.ui.util.g.a(com.target.ui.util.g.a(), (Date)displaydates.b().d(), (Date)displaydates.a().d());
            }
            if (flag)
            {
                arraylist.add(pageitem);
            }
        } while (true);
        return arraylist;
    }

    private void c(PageItem pageitem)
    {
        pageitem = com.target.ui.service.k.a().c();
        if (pageitem.b())
        {
            b((StoreSummary)pageitem.c());
            return;
        } else
        {
            h();
            return;
        }
    }

    static void c(PageItemFragment pageitemfragment, PageItemCollection pageitemcollection)
    {
        pageitemfragment.a(pageitemcollection);
    }

    static void c(PageItemFragment pageitemfragment, boolean flag)
    {
        pageitemfragment.o(flag);
    }

    private void c(f f1)
    {
        f1 = f1.b();
        if (f1.b() == null)
        {
            return;
        } else
        {
            ac.a((ProductIdentifier)f1.b().d()).e();
            return;
        }
    }

    private void c(String s1)
    {
        if (mSnackBar == null || !com.target.mothership.util.o.g(s1))
        {
            return;
        } else
        {
            mSnackBar.c(s1);
            return;
        }
    }

    static String d(PageItemFragment pageitemfragment)
    {
        return pageitemfragment.mRequestTag;
    }

    private void d()
    {
        if (mPromotionParams != null && !mPromotionApplied)
        {
            mPromotionApplied = true;
            c(mPromotionParams);
        }
    }

    static e e(PageItemFragment pageitemfragment)
    {
        return pageitemfragment.mCurrentStore;
    }

    static h f(PageItemFragment pageitemfragment)
    {
        return pageitemfragment.mLoadingTimestamp;
    }

    static void g(PageItemFragment pageitemfragment)
    {
        pageitemfragment.d();
    }

    static PageItemParams h(PageItemFragment pageitemfragment)
    {
        return pageitemfragment.mPageItemParamsOverride;
    }

    protected static Bundle j()
    {
        return new Bundle();
    }

    private List t()
    {
        if (b.FEATURED.equals(b()))
        {
            return null;
        } else
        {
            return mPageItems;
        }
    }

    private void u()
    {
        if (mDvmDataMap != null && !mDvmDataMap.isEmpty())
        {
            Iterator iterator = mPageItems.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Object obj = (PageItem)iterator.next();
                if (((PageItem) (obj)).e().b())
                {
                    obj = ((DigitalVendorMarketing)((PageItem) (obj)).e().c()).a();
                    Iterator iterator1 = mDvmDataMap.entrySet().iterator();
                    boolean flag = false;
                    do
                    {
                        if (!iterator1.hasNext())
                        {
                            break;
                        }
                        java.util.Map.Entry entry = (java.util.Map.Entry)iterator1.next();
                        if (((String) (obj)).equals(((URL)entry.getKey()).toString()))
                        {
                            mViews.pageItemLayout.a((URL)entry.getKey(), (DvmDataResponse)entry.getValue());
                            flag = true;
                        }
                    } while (true);
                    if (!flag)
                    {
                        a(m.a(((String) (obj))));
                    }
                }
            } while (true);
        } else
        {
            b(mSavedPage);
        }
    }

    private boolean v()
    {
        return a(mCurrentStore, com.target.ui.service.k.a().c());
    }

    private void w()
    {
        mCurrentStore = com.target.ui.service.k.a().c();
    }

    private void x()
    {
        if (z())
        {
            a(mSavedPage.a());
            b(mSavedWeeklyAdData);
            u();
            d();
            return;
        } else
        {
            mLastUpdatedDate = new Date();
            y_();
            return;
        }
    }

    private void y()
    {
        mViews.pageItemLayout.setShouldUseCustomWeeklyAdTile(i());
        mViews.pageItemLayout.setOnItemClickListener(this);
        mViews.pageItemLayout.setOnWeeklyAdCardViewClickListener(this);
        mViews.pageItemLayout.setOnDvmViewClickListener(this);
        mViews.pageItemLayout.setErrorViewTryAgainListener(this);
        mViews.pageItemLayout.setScrollingTabCoordinator(mScrollingTabCoordinator);
    }

    private boolean z()
    {
        boolean flag;
        boolean flag1;
        if (mSavedPage != null && mSavedPage.a().size() > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (mLastUpdatedDate != null)
        {
            Date date = new Date(mLastUpdatedDate.getTime() + 0xdbba00L);
            flag1 = com.target.ui.util.g.a().after(date);
        } else
        {
            flag1 = false;
        }
        return flag && !flag1 && !v();
    }

    public void A_()
    {
        y_();
    }

    public void J()
    {
    }

    protected void a(long l1)
    {
    }

    public void a(e e1)
    {
        while (mViews == null || mPageItemParamsOverride != null && mPageItemParamsOverride.c().b() || !a(mCurrentStore, e1)) 
        {
            return;
        }
        mCurrentStore = e1;
        y_();
    }

    public void a(Action action)
    {
        Uri uri = Uri.parse(action.b());
        if (!com.target.ui.util.deep_link.g.c(uri))
        {
            a(uri, (String)action.a().d());
            return;
        } else
        {
            b(com.target.ui.util.deep_link.g.a(uri, (Store)mCurrentStore.d()));
            return;
        }
    }

    public void a(PageItem pageitem, PageItemView pageitemview)
    {
        if (pageitem == null)
        {
            com.target.ui.util.q.a(TAG, "Card clicked with null featured item");
            return;
        }
        if (pageitem.j().b())
        {
            a(pageitem, pageitemview.getGridPositionRow(), pageitemview.getGridPositionColumn());
        }
        if (pageitem.c().b())
        {
            a(pageitem);
            return;
        }
        if (pageitem.d().b())
        {
            b(pageitem);
            return;
        }
        if (pageitem.k().b())
        {
            c(pageitem);
            return;
        }
        if (!pageitem.a().b())
        {
            com.target.ui.util.q.a(TAG, "Card clicked with no obvious action");
            return;
        } else
        {
            b(pageitem, pageitemview);
            return;
        }
    }

    public void a(PageItem pageitem, WeeklyAdView weeklyadview, WeeklyAdCardView weeklyadcardview)
    {
        if (pageitem.j().b())
        {
            a(pageitem, weeklyadview.getGridPositionRow(), weeklyadview.getGridPositionColumn());
        }
        if (!mCurrentStore.b())
        {
            h();
            return;
        }
        pageitem = ((RelevantStoreSummary)mCurrentStore.c()).getStoreId();
        if (!weeklyadcardview.getViewModel().b() || !((com.target.ui.view.shop.WeeklyAdCardView.a)weeklyadcardview.getViewModel().c()).d().b())
        {
            pageitem = WeeklyAdFragment.b((StoreSummary)mCurrentStore.c());
            weeklyadview = null;
        } else
        {
            weeklyadview = (String)((com.target.ui.view.shop.WeeklyAdCardView.a)weeklyadcardview.getViewModel().c()).c().d();
            WeeklyAdHomepageData weeklyadhomepagedata = (WeeklyAdHomepageData)((com.target.ui.view.shop.WeeklyAdCardView.a)weeklyadcardview.getViewModel().c()).d().c();
            if (weeklyadhomepagedata.b().equals(((RelevantStoreSummary)mCurrentStore.c()).getStoreId()))
            {
                pageitem = WeeklyAdFragment.a(weeklyadhomepagedata);
            } else
            {
                pageitem = WeeklyAdFragment.a(pageitem, weeklyadhomepagedata.a());
            }
        }
        if (com.target.ui.util.j.b())
        {
            com.target.ui.f.b b1 = new com.target.ui.f.b(m());
            weeklyadcardview = new com.target.ui.f.a(getActivity(), this, weeklyadcardview.getBitmapImageView(), "weeklyAdFragmentTransitionTag");
            weeklyadcardview.a(weeklyadview);
            b1.a(pageitem, weeklyadcardview);
            return;
        } else
        {
            m().d(pageitem);
            return;
        }
    }

    public void a(StoreSummary storesummary)
    {
        com.target.ui.service.k.a().a(storesummary.getStoreId());
    }

    public void a(PageItemHierarchy pageitemhierarchy)
    {
        getArguments().putParcelable("pageItemHierarchy", pageitemhierarchy);
    }

    public void a(ShopDvmView shopdvmview)
    {
        DvmDataResponse dvmdataresponse = (DvmDataResponse)shopdvmview.getDvmContent().d();
        if (dvmdataresponse != null)
        {
            shopdvmview = dvmdataresponse.c();
        } else
        {
            shopdvmview = null;
        }
        if (shopdvmview == null)
        {
            com.target.ui.util.q.a(TAG, "DVM tile clicked with no DVM URI");
            return;
        } else
        {
            b(Uri.parse(shopdvmview), dvmdataresponse.b());
            return;
        }
    }

    protected void a(List list)
    {
        mPageItems = c(list);
        mViews.pageItemLayout.setData(mPageItems);
    }

    public void a(boolean flag)
    {
        getArguments().putBoolean("muteViewEvents", flag);
    }

    protected abstract b b();

    protected void c()
    {
        j(r());
    }

    public void c(final PromotionParams promotionParams)
    {
        Guest guest = (Guest)com.target.ui.service.a.a().c().d();
        if (guest != null)
        {
            a(promotionParams, guest);
            return;
        } else
        {
            com.target.ui.service.a.a().a(new com.target.mothership.model.h() {

                final PageItemFragment this$0;
                final PromotionParams val$promotionParams;

                public String a()
                {
                    return com.target.ui.fragment.shop.PageItemFragment.d(PageItemFragment.this);
                }

                public void a(Guest guest1)
                {
                    com.target.ui.fragment.shop.PageItemFragment.a(PageItemFragment.this, promotionParams, guest1);
                }

                public void a(x x1)
                {
                    com.target.ui.fragment.shop.PageItemFragment.b(PageItemFragment.this, getString(0x7f090495));
                }

                public volatile void a(Object obj)
                {
                    a((Guest)obj);
                }

                public void b(Object obj)
                {
                    a((x)obj);
                }

            
            {
                this$0 = PageItemFragment.this;
                promotionParams = promotionparams;
                super();
            }
            });
            return;
        }
    }

    public void e()
    {
    }

    public com.target.ui.fragment.store.StoreChooserDialogFragment.d g()
    {
        return com.target.ui.fragment.store.StoreChooserDialogFragment.d.NEARBY_STORES;
    }

    protected boolean i()
    {
        return false;
    }

    public com.target.ui.fragment.account.BaseAccountDialog.a k()
    {
        return mReauthDialogListenerDelegate;
    }

    public com.target.ui.fragment.account.BaseAccountDialog.c l()
    {
        return mReauthDialogListenerDelegate;
    }

    public com.target.ui.fragment.account.BaseAccountDialog.e n()
    {
        return k();
    }

    public void o()
    {
        if (mPageItemManager != null)
        {
            mPageItemManager.a(TAG);
        }
        if (mWeeklyAdFullDataHelper != null)
        {
            mWeeklyAdFullDataHelper.a();
        }
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        for (activity = getParentFragment(); activity == null || !(activity instanceof com.target.ui.e.f);)
        {
            return;
        }

        mScrollingTabCoordinator = (com.target.ui.e.f)activity;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (getArguments() != null)
        {
            mPageItemParamsOverride = (PageItemParams)getArguments().getParcelable("pageItemParams");
            mPageIdentifier = (PageIdentifier)getArguments().getParcelable("pageIdentifier");
            mPromotionParams = (PromotionParams)getArguments().getParcelable("promotionParams");
            mWeeklyAdPromotionRequest = (PromotionRequest)getArguments().getParcelable("weeklyAdRequestParams");
            mCouponWalletsManager = new com.target.mothership.model.coupon_wallets.c();
            mPageItemManager = new com.target.mothership.model.page_item.c();
            mRequestTag = String.valueOf(hashCode());
            mWeeklyAdFullDataHelper = new com.target.ui.helper.q.b();
            mDvmDataHelper = new com.target.ui.helper.g.a();
            mSnackBar = new com.target.ui.view.common.h(getActivity());
            mReauthDialogListenerDelegate = new a();
            mDvmDataMap = new android.support.v4.f.a();
            if (bundle != null)
            {
                mPromotionApplied = bundle.getBoolean("promotionApplied");
                return;
            }
        }
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        if (!isAdded())
        {
            return;
        } else
        {
            super.onCreateOptionsMenu(menu, menuinflater);
            c();
            b(false);
            return;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030069, viewgroup, false);
        mViews = new Views(layoutinflater);
        w();
        y();
        x();
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
        mSnackBar = null;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        o(false);
        if (mViews != null)
        {
            mViews.pageItemLayout.setOnItemClickListener(null);
        }
        o();
        mViews = null;
    }

    public void onDetach()
    {
        super.onDetach();
        mScrollingTabCoordinator = null;
    }

    public void onPause()
    {
        super.onPause();
        com.target.ui.service.k.a().b(this);
        mSnackBar.a();
    }

    public void onResume()
    {
        super.onResume();
        com.target.ui.service.k.a().a(this);
        if (z())
        {
            a(new Runnable() {

                final PageItemFragment this$0;

                public void run()
                {
                    e();
                }

            
            {
                this$0 = PageItemFragment.this;
                super();
            }
            });
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("promotionApplied", mPromotionApplied);
    }

    public PageItemHierarchy p()
    {
        return (PageItemHierarchy)getArguments().get("pageItemHierarchy");
    }

    public Store q()
    {
        return (Store)mCurrentStore.d();
    }

    protected String r()
    {
        String s2 = "";
        String s1 = s2;
        if (mSavedPage != null)
        {
            s1 = s2;
            if (mSavedPage.b().b())
            {
                s1 = (String)mSavedPage.b().c();
            }
        }
        return s1;
    }

    protected boolean s()
    {
        Bundle bundle = getArguments();
        if (bundle == null || !bundle.containsKey("muteViewEvents"))
        {
            return true;
        } else
        {
            return bundle.getBoolean("muteViewEvents");
        }
    }

    protected void y_()
    {
        Object obj = null;
        if (!com.target.mothership.util.b.a().b())
        {
            if (mSavedPage == null)
            {
                mViews.pageItemLayout.a(com.target.ui.view.common.b.a.ERROR_NO_NETWORK, true);
            }
            return;
        }
        StoreIdentifier storeidentifier = (StoreIdentifier)a((Store)mCurrentStore.d(), mPageItemParamsOverride).d();
        d d1;
        EndecaId endecaid;
        b b1;
        PageItemParams pageitemparams;
        if (mPageItemParamsOverride != null && mPageItemParamsOverride.b().b())
        {
            d1 = (d)mPageItemParamsOverride.b().c();
        } else
        if (mCurrentStore.b())
        {
            if (((RelevantStoreSummary)mCurrentStore.c()).a())
            {
                d1 = d.INSIDE;
            } else
            {
                d1 = d.OUTSIDE;
            }
        } else
        {
            d1 = null;
        }
        endecaid = ((EndecaId) (obj));
        if (mPageItemParamsOverride != null)
        {
            endecaid = ((EndecaId) (obj));
            if (mPageItemParamsOverride.d().b())
            {
                endecaid = (EndecaId)mPageItemParamsOverride.d().c();
            }
        }
        obj = new android.support.v4.f.a();
        if (mPageItemParamsOverride != null)
        {
            obj = mPageItemParamsOverride.a();
        }
        b1 = b();
        if (mPageIdentifier != null)
        {
            b1 = b.CUSTOM;
        }
        pageitemparams = new PageItemParams();
        pageitemparams.a(((Map) (obj)));
        pageitemparams.a(d1);
        pageitemparams.a(storeidentifier);
        pageitemparams.a(endecaid);
        a(b1, pageitemparams, mPageIdentifier);
    }

}
