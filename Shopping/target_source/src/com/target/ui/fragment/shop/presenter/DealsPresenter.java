// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.shop.presenter;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuInflater;
import com.google.a.a.e;
import com.target.mothership.common.params.ProductSummaryParam;
import com.target.mothership.common.product.p;
import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.common.weeklyad.PromotionRequest;
import com.target.mothership.model.coupons.interfaces.AvailableCouponOffer;
import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.mothership.model.product.interfaces.ProductEntry;
import com.target.mothership.model.product.interfaces.ProductSummary;
import com.target.mothership.model.product.interfaces.ProductSummaryWrapper;
import com.target.mothership.model.store.interfaces.RelevantStoreSummary;
import com.target.mothership.model.store.interfaces.Store;
import com.target.mothership.services.x;
import com.target.ui.analytics.a.az;
import com.target.ui.analytics.h;
import com.target.ui.g.a;
import com.target.ui.model.refine.ProductRefineModel;
import com.target.ui.model.refine.ProductSortModel;
import com.target.ui.model.shop.AggregateDealsData;
import com.target.ui.service.provider.b;
import com.target.ui.service.provider.n;
import com.target.ui.util.q;
import com.target.ui.view.product.PlpAvailableCouponOfferView;
import com.target.ui.view.product.PlpListItemView;
import com.target.ui.view.shop.DealsHeaderView;
import com.target.ui.view.shop.WeeklyAdCardView;
import java.util.ArrayList;
import java.util.List;

public class DealsPresenter
    implements com.target.ui.adapter.h.a.b, az, com.target.ui.fragment.product.refine.ProductSummaryRefineFragment.b, a, com.target.ui.helper.p.a.a, com.target.ui.helper.p.a.b, com.target.ui.helper.p.a.d
{
    public static class SavedState
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public SavedState a(Parcel parcel)
            {
                return new SavedState(parcel);
            }

            public SavedState[] a(int i1)
            {
                return new SavedState[i1];
            }

            public Object createFromParcel(Parcel parcel)
            {
                return a(parcel);
            }

            public Object[] newArray(int i1)
            {
                return a(i1);
            }

        };
        List additionalProductDetails;
        AggregateDealsData aggregateDealsData;
        ProductSummary currentProductSummary;
        boolean guestCompletedCouponsSignUpByLastRequest;
        int productsCurrentPage;
        int productsTotalPages;
        ProductRefineModel refineModel;
        ProductSummaryParam refinedProductSummaryParam;
        List selectedFacets;
        com.target.ui.model.refine.ProductSortModel.SortLabel sortLabel;

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i1)
        {
            byte byte0;
            if (guestCompletedCouponsSignUpByLastRequest)
            {
                byte0 = 1;
            } else
            {
                byte0 = 0;
            }
            parcel.writeByte(byte0);
            parcel.writeInt(productsCurrentPage);
            parcel.writeInt(productsTotalPages);
            parcel.writeParcelable(aggregateDealsData, i1);
            parcel.writeList(additionalProductDetails);
            parcel.writeList(selectedFacets);
            parcel.writeParcelable(refineModel, i1);
            parcel.writeParcelable(currentProductSummary, i1);
            parcel.writeParcelable(refinedProductSummaryParam, i1);
            parcel.writeParcelable(sortLabel, i1);
        }


        public SavedState()
        {
            productsCurrentPage = 0;
            productsTotalPages = 0;
            additionalProductDetails = new ArrayList();
            selectedFacets = new ArrayList();
        }

        private SavedState(Parcel parcel)
        {
            boolean flag = true;
            super();
            productsCurrentPage = 0;
            productsTotalPages = 0;
            additionalProductDetails = new ArrayList();
            selectedFacets = new ArrayList();
            if (parcel.readByte() != 1)
            {
                flag = false;
            }
            guestCompletedCouponsSignUpByLastRequest = flag;
            productsCurrentPage = parcel.readInt();
            productsTotalPages = parcel.readInt();
            aggregateDealsData = (AggregateDealsData)parcel.readParcelable(com/target/ui/model/shop/AggregateDealsData.getClassLoader());
            additionalProductDetails = new ArrayList();
            parcel.readList(additionalProductDetails, com/target/mothership/model/product/interfaces/ProductDetails.getClassLoader());
            selectedFacets = new ArrayList();
            parcel.readList(selectedFacets, com/target/mothership/model/product/interfaces/ProductEntry.getClassLoader());
            refineModel = (ProductRefineModel)parcel.readParcelable(com/target/ui/model/refine/ProductRefineModel.getClassLoader());
            currentProductSummary = (ProductSummary)parcel.readParcelable(com/target/mothership/model/product/interfaces/ProductSummary.getClassLoader());
            refinedProductSummaryParam = (ProductSummaryParam)parcel.readParcelable(com/target/mothership/common/params/ProductSummaryParam.getClassLoader());
            sortLabel = (com.target.ui.model.refine.ProductSortModel.SortLabel)parcel.readParcelable(com/target/ui/model/refine/ProductSortModel$SortLabel.getClassLoader());
        }

    }


    static final String CARTWHEEL_PACKAGE_NAME = "com.target.socsav";
    static final Uri CARTWHEEL_URI = Uri.parse("https://cartwheel-secure.target.com/mycartwheel");
    static final String MOBILE_COUPONS_PACKAGE_NAME = "com.target.ui";
    static final Uri MOBILE_COUPONS_URI = Uri.parse("target://coupons");
    private static final int PRODUCT_PAGINATION_REQUEST_OFFSET = 3;
    public static final String TAG = com/target/ui/fragment/shop/presenter/DealsPresenter.getSimpleName();
    private List mAdditionalProductDetails;
    private b mConnectivityProvider;
    private ProductSummary mCurrentProductSummary;
    private RelevantStoreSummary mCurrentStoreSummary;
    private com.target.ui.helper.p.a mDealsFullDataHelper;
    private boolean mGuestCompletedCouponsSignUpByLastRequest;
    private h mLoadingTimestamp;
    private boolean mMuteViewEvents;
    private n mParcelableCopyProvider;
    private com.target.ui.fragment.shop.c.a mPresentation;
    private int mProductsCurrentPage;
    private int mProductsTotalPages;
    private ProductRefineModel mRefineModel;
    private ProductSummaryParam mRefinedProductSummaryParam;
    private boolean mRequestingAdditionalPages;
    private AggregateDealsData mSavedData;
    private List mSelectedFacets;
    private boolean mShouldScrollToTopOfProductList;
    private com.target.ui.model.refine.ProductSortModel.SortLabel mSortLabel;
    private PromotionRequest mWeeklyAdPromotionRequest;

    public DealsPresenter(com.target.ui.helper.p.a a1, b b1, n n1, RelevantStoreSummary relevantstoresummary, PromotionRequest promotionrequest, boolean flag, Parcelable parcelable)
    {
        mGuestCompletedCouponsSignUpByLastRequest = false;
        mShouldScrollToTopOfProductList = false;
        mRequestingAdditionalPages = false;
        mProductsCurrentPage = 0;
        mProductsTotalPages = 0;
        mAdditionalProductDetails = new ArrayList();
        mSelectedFacets = new ArrayList();
        mLoadingTimestamp = new h();
        mDealsFullDataHelper = a1;
        mConnectivityProvider = b1;
        mParcelableCopyProvider = n1;
        mCurrentStoreSummary = relevantstoresummary;
        mWeeklyAdPromotionRequest = promotionrequest;
        mMuteViewEvents = flag;
        if (parcelable != null)
        {
            a(parcelable);
        }
    }

    private void a(AggregateDealsData aggregatedealsdata, Store store, com.target.ui.model.refine.ProductSortModel.SortLabel sortlabel)
    {
        boolean flag1 = true;
        int j1 = 0x7f0902d8;
        int i1 = j1;
        if (sortlabel != null)
        {
            i1 = j1;
            if (!sortlabel.a().equals(p.RELEVANCE))
            {
                i1 = sortlabel.b();
            }
        }
        mPresentation.a(aggregatedealsdata, i1);
        sortlabel = mPresentation;
        boolean flag;
        if (!aggregatedealsdata.b().b())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        sortlabel.c(flag);
        aggregatedealsdata = mPresentation;
        if (store == null)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        aggregatedealsdata.d(flag);
    }

    private boolean a(RelevantStoreSummary relevantstoresummary, RelevantStoreSummary relevantstoresummary1)
    {
        if (relevantstoresummary != null || relevantstoresummary1 != null)
        {
            if (relevantstoresummary == null || relevantstoresummary1 == null)
            {
                return true;
            }
            boolean flag1 = relevantstoresummary.getStoreId().a().equals(relevantstoresummary1.getStoreId().a());
            boolean flag;
            if (relevantstoresummary.a() == relevantstoresummary1.a())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag1 || !flag)
            {
                return true;
            }
        }
        return false;
    }

    private void b(ProductSummaryWrapper productsummarywrapper)
    {
        if (productsummarywrapper == null)
        {
            mProductsCurrentPage = 0;
            mProductsTotalPages = 0;
            mAdditionalProductDetails.clear();
        } else
        {
            mCurrentProductSummary = productsummarywrapper.a();
            mProductsCurrentPage = mCurrentProductSummary.h();
            mProductsTotalPages = mCurrentProductSummary.g();
            if (mProductsCurrentPage > 1)
            {
                mAdditionalProductDetails.addAll(mCurrentProductSummary.a());
                return;
            }
        }
    }

    private void i()
    {
        mAdditionalProductDetails.clear();
        mSavedData = null;
        mSelectedFacets.clear();
        mRefinedProductSummaryParam = null;
        mRefineModel = null;
        mProductsCurrentPage = 0;
        mProductsTotalPages = 0;
        mSortLabel = null;
    }

    private ProductSummaryParam j()
    {
        if (mRefinedProductSummaryParam != null)
        {
            return mRefinedProductSummaryParam;
        } else
        {
            return mDealsFullDataHelper.a(mCurrentStoreSummary);
        }
    }

    private void k()
    {
        if (!mConnectivityProvider.a())
        {
            mPresentation.a(com.target.ui.view.common.b.a.ERROR_NO_NETWORK, true);
            return;
        }
        if (mSavedData == null)
        {
            mPresentation.e(true);
        }
        mGuestCompletedCouponsSignUpByLastRequest = mDealsFullDataHelper.b();
        mLoadingTimestamp = new h();
        mDealsFullDataHelper.a(mCurrentStoreSummary, mRefinedProductSummaryParam, mWeeklyAdPromotionRequest, this);
    }

    private void l()
    {
        if (mSavedData == null)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        if (mGuestCompletedCouponsSignUpByLastRequest || !mDealsFullDataHelper.b()) goto _L2; else goto _L1
_L1:
        i();
        k();
_L4:
        return;
_L2:
        a(mSavedData, mCurrentStoreSummary, mSortLabel);
        if (!mAdditionalProductDetails.isEmpty())
        {
            mPresentation.a(mAdditionalProductDetails);
        }
        if (mMuteViewEvents) goto _L4; else goto _L3
_L3:
        mPresentation.i();
        return;
        k();
        return;
    }

    public void a(int i1, int j1)
    {
        if (i1 >= j1 - 3)
        {
            f();
        }
    }

    public void a(Parcelable parcelable)
    {
        parcelable = (SavedState)parcelable;
        mGuestCompletedCouponsSignUpByLastRequest = ((SavedState) (parcelable)).guestCompletedCouponsSignUpByLastRequest;
        mSavedData = ((SavedState) (parcelable)).aggregateDealsData;
        mAdditionalProductDetails = ((SavedState) (parcelable)).additionalProductDetails;
        mProductsCurrentPage = ((SavedState) (parcelable)).productsCurrentPage;
        mProductsTotalPages = ((SavedState) (parcelable)).productsTotalPages;
        mSelectedFacets = ((SavedState) (parcelable)).selectedFacets;
        mRefineModel = ((SavedState) (parcelable)).refineModel;
        mCurrentProductSummary = ((SavedState) (parcelable)).currentProductSummary;
        mRefinedProductSummaryParam = ((SavedState) (parcelable)).refinedProductSummaryParam;
        mSortLabel = ((SavedState) (parcelable)).sortLabel;
    }

    public void a(Menu menu, MenuInflater menuinflater)
    {
    }

    public void a(ProductSummaryParam productsummaryparam, ArrayList arraylist)
    {
        if (mRefineModel != null)
        {
            mSortLabel = (com.target.ui.model.refine.ProductSortModel.SortLabel)mRefineModel.b().c().d();
        }
        mSavedData = null;
        mAdditionalProductDetails.clear();
        mSelectedFacets.clear();
        mRefinedProductSummaryParam = productsummaryparam;
        mSelectedFacets.addAll(arraylist);
        mShouldScrollToTopOfProductList = true;
        if (mPresentation == null)
        {
            return;
        } else
        {
            k();
            return;
        }
    }

    public void a(AvailableCouponOffer availablecouponoffer)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.a(0x7f0902aa, availablecouponoffer);
            return;
        }
    }

    public void a(AvailableCouponOffer availablecouponoffer, PlpAvailableCouponOfferView plpavailablecouponofferview)
    {
        mPresentation.b(availablecouponoffer);
    }

    public void a(com.target.mothership.model.coupons.interfaces.a.a a1, AvailableCouponOffer availablecouponoffer)
    {
        if (mPresentation == null)
        {
            return;
        }
        static class _cls1
        {

            static final int $SwitchMap$com$target$mothership$model$coupons$interfaces$error$AddOnDemandCouponFailure$AddOnDemandCouponFailureReason[];

            static 
            {
                $SwitchMap$com$target$mothership$model$coupons$interfaces$error$AddOnDemandCouponFailure$AddOnDemandCouponFailureReason = new int[com.target.mothership.model.coupons.interfaces.a.a.a.values().length];
                try
                {
                    $SwitchMap$com$target$mothership$model$coupons$interfaces$error$AddOnDemandCouponFailure$AddOnDemandCouponFailureReason[com.target.mothership.model.coupons.interfaces.a.a.a.COUPON_ERR_PRE_ASSIGNED.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror) { }
            }
        }

        switch (_cls1..SwitchMap.com.target.mothership.model.coupons.interfaces.error.AddOnDemandCouponFailure.AddOnDemandCouponFailureReason[((com.target.mothership.model.coupons.interfaces.a.a.a)a1.e()).ordinal()])
        {
        default:
            mPresentation.b(0x7f0902ad);
            return;

        case 1: // '\001'
            mPresentation.a(0x7f0902ab, availablecouponoffer);
            break;
        }
    }

    public void a(ProductDetails productdetails, PlpListItemView plplistitemview)
    {
        mPresentation.b(productdetails, plplistitemview);
    }

    public void a(ProductSummaryWrapper productsummarywrapper)
    {
        mRequestingAdditionalPages = false;
        if (mPresentation == null)
        {
            return;
        } else
        {
            b(productsummarywrapper);
            mPresentation.f(false);
            mPresentation.a(productsummarywrapper.a().a());
            return;
        }
    }

    public void a(RelevantStoreSummary relevantstoresummary)
    {
        if (!a(mCurrentStoreSummary, relevantstoresummary))
        {
            return;
        } else
        {
            mCurrentStoreSummary = relevantstoresummary;
            i();
            mDealsFullDataHelper.a();
            k();
            return;
        }
    }

    public void a(x x)
    {
        mRequestingAdditionalPages = false;
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.f(false);
            mPresentation.g(true);
            return;
        }
    }

    public void a(com.target.ui.fragment.shop.c.a a1)
    {
        mPresentation = a1;
        l();
    }

    public void a(com.target.ui.helper.p.a.c c1)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.e(false);
            mPresentation.a(com.target.ui.view.common.b.a.ERROR_DEFAULT, true);
            return;
        }
    }

    public void a(AggregateDealsData aggregatedealsdata)
    {
        if (mPresentation != null)
        {
            if (mRefineModel != null && !mRefineModel.e().isEmpty())
            {
                aggregatedealsdata.a().clear();
            }
            mSavedData = aggregatedealsdata;
            mAdditionalProductDetails.clear();
            b((ProductSummaryWrapper)aggregatedealsdata.b().d());
            mPresentation.e(false);
            if (!mMuteViewEvents)
            {
                mPresentation.b(mLoadingTimestamp);
            }
            a(aggregatedealsdata, ((Store) (mCurrentStoreSummary)), mSortLabel);
            if (mShouldScrollToTopOfProductList)
            {
                mPresentation.j();
                mShouldScrollToTopOfProductList = false;
                return;
            }
        }
    }

    public void a(DealsHeaderView dealsheaderview, WeeklyAdCardView weeklyadcardview)
    {
        if (mCurrentStoreSummary == null)
        {
            mPresentation.h();
            return;
        } else
        {
            mPresentation.a(dealsheaderview, weeklyadcardview, mCurrentStoreSummary);
            return;
        }
    }

    public volatile void a(Object obj)
    {
        a((com.target.ui.fragment.shop.c.a)obj);
    }

    public void a(boolean flag)
    {
        mMuteViewEvents = flag;
    }

    public void b()
    {
        mPresentation.a(1);
        mPresentation.b(CARTWHEEL_URI, "com.target.socsav");
    }

    public void b(AvailableCouponOffer availablecouponoffer)
    {
        mDealsFullDataHelper.a(availablecouponoffer, this);
    }

    public void c()
    {
        mPresentation.a(2);
        mPresentation.b(MOBILE_COUPONS_URI, "com.target.ui");
    }

    public void c(AvailableCouponOffer availablecouponoffer)
    {
        mPresentation.b(availablecouponoffer);
    }

    public void d()
    {
        mPresentation.h();
    }

    public void e()
    {
        while (mPresentation == null || mMuteViewEvents) 
        {
            return;
        }
        mPresentation.i();
    }

    public void f()
    {
        int i1;
        if (!mRequestingAdditionalPages)
        {
            if ((i1 = mProductsCurrentPage + 1) <= mProductsTotalPages)
            {
                mRequestingAdditionalPages = true;
                mPresentation.f(true);
                ProductSummaryParam productsummaryparam = j();
                productsummaryparam.c(Integer.valueOf(i1));
                mDealsFullDataHelper.a(productsummaryparam, this);
                return;
            }
        }
    }

    public void g()
    {
        if (mCurrentProductSummary == null)
        {
            q.a(TAG, "Refine button clicked when there is no product summary data available");
            return;
        }
        ProductSummary productsummary = mCurrentProductSummary;
        ProductSummaryParam productsummaryparam = (ProductSummaryParam)mParcelableCopyProvider.a(j(), com/target/mothership/common/params/ProductSummaryParam.getClassLoader());
        if (mRefineModel == null)
        {
            mRefineModel = new ProductRefineModel(productsummary.c(), productsummary.b());
        }
        ProductRefineModel productrefinemodel = mRefineModel;
        productrefinemodel.b(productsummary.c());
        productrefinemodel.a(productsummary.b());
        productrefinemodel.c(mSelectedFacets);
        productrefinemodel.b().a(mSortLabel);
        mPresentation.a(productrefinemodel, productsummaryparam);
    }

    public void h()
    {
        k();
    }

    public void v_()
    {
        mDealsFullDataHelper = null;
        mConnectivityProvider = null;
        mParcelableCopyProvider = null;
    }

    public void z_()
    {
        mRequestingAdditionalPages = false;
        mDealsFullDataHelper.a();
        mPresentation = null;
    }

}
