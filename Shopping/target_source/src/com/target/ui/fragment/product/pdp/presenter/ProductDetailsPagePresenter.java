// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.pdp.presenter;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.google.a.a.e;
import com.target.mothership.common.a.g;
import com.target.mothership.common.coupon_wallets.CouponPromotionId;
import com.target.mothership.common.params.ProductRecommendationsParam;
import com.target.mothership.common.product.ProductIdentifier;
import com.target.mothership.common.product.Tcin;
import com.target.mothership.common.product.d;
import com.target.mothership.common.product.m;
import com.target.mothership.model.dvm.interfaces.DvmDataResponse;
import com.target.mothership.model.dvm.interfaces.DvmRemoteData;
import com.target.mothership.model.product.interfaces.Product;
import com.target.mothership.model.product.interfaces.ProductCallout;
import com.target.mothership.model.product.interfaces.ProductCartWheel;
import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.mothership.model.product.interfaces.ProductDetailsWrapper;
import com.target.mothership.model.product.interfaces.ProductGuestReview;
import com.target.mothership.model.product.interfaces.ProductImage;
import com.target.mothership.model.product.interfaces.ProductLimitedAvailability;
import com.target.mothership.model.product.interfaces.ProductOnlineInfo;
import com.target.mothership.model.product.interfaces.ProductPromotion;
import com.target.mothership.model.product.interfaces.ProductRecommendations;
import com.target.mothership.model.product.interfaces.ProductStoreInfo;
import com.target.mothership.model.registries.interfaces.RegistryDetails;
import com.target.mothership.model.registries.interfaces.RegistryProductDetails;
import com.target.mothership.model.store.interfaces.RelevantStoreSummary;
import com.target.mothership.model.store.interfaces.Store;
import com.target.mothership.model.store.interfaces.StoreSummary;
import com.target.mothership.services.x;
import com.target.mothership.util.o;
import com.target.ui.common.ProductFulfillmentOptions;
import com.target.ui.common.c;
import com.target.ui.common.f;
import com.target.ui.fragment.product.pdp.a.b;
import com.target.ui.g.a;
import com.target.ui.helper.product.ProductVariationModelHelper;
import com.target.ui.helper.product.h;
import com.target.ui.model.product.GridItem;
import com.target.ui.model.product.ListItem;
import com.target.ui.model.product.ProductVariationModel;
import com.target.ui.service.provider.l;
import com.target.ui.service.provider.p;
import com.target.ui.service.provider.s;
import com.target.ui.util.q;
import com.target.ui.view.BitmapImageView;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.ui.fragment.product.pdp.presenter:
//            b

public class ProductDetailsPagePresenter
    implements a, com.target.ui.helper.e.a.a, com.target.ui.helper.g.a.a, com.target.ui.helper.g.a.b, com.target.ui.helper.product.g.c, com.target.ui.helper.product.g.d, com.target.ui.helper.product.h.a
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
        boolean couponApplied;
        DvmDataResponse dvmData;
        ProductDetails parentProductDetails;
        ProductDetails productDetails;
        List productDetailsList;
        ProductVariationModel productVariationModel;
        ProductRecommendations recommendations;
        RelevantStoreSummary storeSummary;

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i1)
        {
            byte byte0;
            if (couponApplied)
            {
                byte0 = 1;
            } else
            {
                byte0 = 0;
            }
            parcel.writeByte(byte0);
            parcel.writeParcelable(productDetails, 0);
            parcel.writeParcelable(parentProductDetails, 0);
            parcel.writeList(productDetailsList);
            parcel.writeParcelable(productVariationModel, 0);
            parcel.writeParcelable(dvmData, 0);
            parcel.writeParcelable(storeSummary, 0);
            parcel.writeParcelable(recommendations, 0);
        }


        public SavedState()
        {
        }

        protected SavedState(Parcel parcel)
        {
            boolean flag = true;
            super();
            if (parcel.readByte() != 1)
            {
                flag = false;
            }
            couponApplied = flag;
            productDetails = (ProductDetails)parcel.readParcelable(com/target/mothership/model/product/interfaces/ProductDetails.getClassLoader());
            parentProductDetails = (ProductDetails)parcel.readParcelable(com/target/mothership/model/product/interfaces/ProductDetails.getClassLoader());
            productDetailsList = new ArrayList();
            parcel.readList(productDetailsList, com/target/mothership/model/product/interfaces/ProductDetails.getClassLoader());
            productVariationModel = (ProductVariationModel)parcel.readParcelable(com/target/ui/model/product/ProductVariationModel.getClassLoader());
            dvmData = (DvmDataResponse)parcel.readParcelable(com/target/mothership/model/dvm/interfaces/DvmDataResponse.getClassLoader());
            storeSummary = (RelevantStoreSummary)parcel.readParcelable(com/target/mothership/model/store/interfaces/RelevantStoreSummary.getClassLoader());
            recommendations = (ProductRecommendations)parcel.readParcelable(com/target/mothership/model/product/interfaces/ProductRecommendations.getClassLoader());
        }
    }


    private static final String ARG_COUPON_PROMOTION_ID = "argCouponPromotionId";
    private static final int PRODUCT_DETAIL_DEFAULT_INDEX = 0;
    private static final int PRODUCT_MAX_RECOMMENDATION = 8;
    private static final int PRODUCT_MIN_RECOMMENDATION = 6;
    private static final String TAG = com/target/ui/fragment/product/pdp/presenter/ProductDetailsPagePresenter.getSimpleName();
    private boolean mCouponApplied;
    private com.target.ui.helper.e.a mCouponWalletsDataHelper;
    private l mDeviceOsProvider;
    private com.target.ui.helper.g.a mDvmDataHelper;
    private com.target.ui.fragment.product.pdp.presenter.a.a mExpressCheckoutFeature;
    private com.target.ui.service.provider.m mGuestProvider;
    private b mPresentation;
    private com.target.ui.helper.product.g mProductDataHelper;
    private com.target.ui.fragment.product.pdp.presenter.b mProductDetailsRequestParam;
    private p mProductUtilsProvider;
    private ProductVariationModelHelper mProductVariationModelHelper;
    private DvmDataResponse mSavedDvmData;
    private ProductDetails mSavedParentProductDetails;
    private ProductDetails mSavedProductDetails;
    private List mSavedProductDetailsList;
    private ProductVariationModel mSavedProductVariationModel;
    private ProductRecommendations mSavedRecommendations;
    private RelevantStoreSummary mSavedStoreSummary;
    private boolean mShowShareAs;
    private h mStoreDataHelper;
    private s mStringResProvider;

    public ProductDetailsPagePresenter(com.target.ui.helper.product.g g1, h h1, com.target.ui.helper.g.a a1, com.target.ui.helper.e.a a2, ProductVariationModelHelper productvariationmodelhelper, l l1, p p1, 
            s s1, com.target.ui.fragment.product.pdp.presenter.b b1, com.target.ui.fragment.product.pdp.presenter.a.a a3, com.target.ui.service.provider.m m1, Parcelable parcelable)
    {
        mCouponApplied = false;
        mShowShareAs = false;
        mCouponWalletsDataHelper = a2;
        mDvmDataHelper = a1;
        mStoreDataHelper = h1;
        mProductDataHelper = g1;
        mProductVariationModelHelper = productvariationmodelhelper;
        mDeviceOsProvider = l1;
        mProductUtilsProvider = p1;
        mStringResProvider = s1;
        mProductDetailsRequestParam = b1;
        mExpressCheckoutFeature = a3;
        mGuestProvider = m1;
        if (parcelable != null)
        {
            a(parcelable);
        }
    }

    private ProductFulfillmentOptions A()
    {
        ProductFulfillmentOptions productfulfillmentoptions = new ProductFulfillmentOptions();
        productfulfillmentoptions.e(true);
        productfulfillmentoptions.a(0x7f0903e6);
        productfulfillmentoptions.l(false);
        productfulfillmentoptions.c(true);
        productfulfillmentoptions.d(0x7f0903e7);
        productfulfillmentoptions.n(false);
        productfulfillmentoptions.h(true);
        productfulfillmentoptions.e(0x7f0900d4);
        productfulfillmentoptions.o(true);
        return productfulfillmentoptions;
    }

    private void B()
    {
        mPresentation.B();
    }

    private void C()
    {
        mPresentation.g();
        if (mSavedStoreSummary == null)
        {
            F();
        }
        if (mSavedRecommendations == null)
        {
            E();
        }
        D();
    }

    private void D()
    {
        if (mProductDetailsRequestParam.b().b())
        {
            a((Product)mProductDetailsRequestParam.b().c(), (Store)mProductDetailsRequestParam.a().d());
        } else
        {
            if (mProductDetailsRequestParam.c().b())
            {
                a((ProductIdentifier)mProductDetailsRequestParam.c().c(), (Store)mProductDetailsRequestParam.a().d());
                return;
            }
            if (mProductDetailsRequestParam.d().b())
            {
                a((RegistryProductDetails)mProductDetailsRequestParam.d().c(), (Store)mProductDetailsRequestParam.a().d());
                return;
            }
        }
    }

    private void E()
    {
        if (mProductDetailsRequestParam.b().b())
        {
            a((Product)mProductDetailsRequestParam.b().c());
        } else
        {
            if (mProductDetailsRequestParam.c().b())
            {
                a((ProductIdentifier)mProductDetailsRequestParam.c().c());
                return;
            }
            if (mProductDetailsRequestParam.d().b())
            {
                a((Product)mProductDetailsRequestParam.d().c());
                return;
            }
        }
    }

    private void F()
    {
        mStoreDataHelper.a((Store)mProductDetailsRequestParam.a().d(), this);
    }

    private void G()
    {
        mPresentation.a(0x7f09042a, 0x7f090429, true);
    }

    private void H()
    {
        mPresentation.h();
    }

    private g a(ProductDetails productdetails)
    {
        if ((productdetails.c().a() && productdetails.c().e().equals(m.ShipToStore) || productdetails.c().e().equals(m.PickUpInStore)) && productdetails.u().a() && productdetails.u().d().equals(m.ShipToStore))
        {
            return g.SHIP_TO_STORE;
        } else
        {
            return g.PICK_UP_IN_STORE;
        }
    }

    private ProductRecommendationsParam a(Tcin tcin)
    {
        ProductRecommendationsParam productrecommendationsparam = new ProductRecommendationsParam();
        productrecommendationsparam.a(6);
        productrecommendationsparam.b(8);
        productrecommendationsparam.a(mGuestProvider.a());
        productrecommendationsparam.a(com.target.mothership.common.params.ProductRecommendationsParam.a.PDP_RECOMMENDATIONS);
        ArrayList arraylist = new ArrayList();
        arraylist.add(tcin);
        productrecommendationsparam.a(arraylist);
        return productrecommendationsparam;
    }

    private void a(Uri uri, String s1)
    {
        a(s1);
        mPresentation.a(uri, (Store)mProductDetailsRequestParam.a().d());
    }

    private void a(ProductRecommendationsParam productrecommendationsparam)
    {
        mProductDataHelper.a(productrecommendationsparam, this);
    }

    private void a(ProductIdentifier productidentifier)
    {
        if (productidentifier instanceof Tcin)
        {
            a(a((Tcin)productidentifier));
            return;
        } else
        {
            com.target.ui.util.q.a(TAG, "Recommendations : non TCIN type request");
            return;
        }
    }

    private void a(ProductIdentifier productidentifier, Store store)
    {
        mProductDataHelper.a(productidentifier, store, this);
    }

    private void a(DvmDataResponse dvmdataresponse, boolean flag)
    {
        if (dvmdataresponse == null)
        {
            mPresentation.y();
            return;
        } else
        {
            mPresentation.a(dvmdataresponse, flag);
            return;
        }
    }

    private void a(Product product)
    {
        a(a(product.k_()));
    }

    private void a(Product product, Store store)
    {
        mProductDataHelper.a(product, store, this);
    }

    private void a(ProductDetails productdetails, RelevantStoreSummary relevantstoresummary, boolean flag, boolean flag1)
    {
        b(productdetails, relevantstoresummary, flag1);
        a(productdetails, flag1);
        b(productdetails, flag1);
        c(productdetails, relevantstoresummary, flag1);
        a(productdetails, relevantstoresummary, flag1);
        e(productdetails, flag1);
        a(productdetails, flag, flag1);
    }

    private void a(ProductDetails productdetails, com.target.ui.helper.product.b b1)
    {
        if (b1.equals(com.target.ui.helper.product.b.EXPRESS_CHECKOUT))
        {
            return;
        }
        static class _cls1
        {

            static final int $SwitchMap$com$target$ui$helper$product$AddToCartItemType[];

            static 
            {
                $SwitchMap$com$target$ui$helper$product$AddToCartItemType = new int[com.target.ui.helper.product.b.values().length];
                try
                {
                    $SwitchMap$com$target$ui$helper$product$AddToCartItemType[com.target.ui.helper.product.b.PICK_UP.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$ui$helper$product$AddToCartItemType[com.target.ui.helper.product.b.SHIP.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.target.ui.helper.product.AddToCartItemType[b1.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            b(productdetails);
            return;

        case 2: // '\002'
            c(productdetails);
            break;
        }
    }

    private void a(ProductDetails productdetails, ProductVariationModel productvariationmodel, RelevantStoreSummary relevantstoresummary, ProductRecommendations productrecommendations, DvmDataResponse dvmdataresponse, boolean flag, boolean flag1)
    {
        b(productdetails, relevantstoresummary, flag1);
        a(productdetails, flag1);
        a(productdetails, productvariationmodel, relevantstoresummary, flag, flag1);
        a(productrecommendations, flag1);
        a(dvmdataresponse, flag1);
        z();
        y();
    }

    private void a(ProductDetails productdetails, ProductVariationModel productvariationmodel, RelevantStoreSummary relevantstoresummary, boolean flag, boolean flag1)
    {
        e(productdetails);
        b(productdetails, flag1);
        c(productdetails, relevantstoresummary, flag1);
        a(productdetails, relevantstoresummary, flag1);
        d(productdetails, flag1);
        e(productdetails, flag1);
        a(productvariationmodel, flag1);
        a(productdetails, flag, flag1);
        f(productdetails, flag1);
        g(productdetails, flag1);
        h(productdetails, flag1);
    }

    private void a(ProductDetails productdetails, boolean flag)
    {
        productdetails = productdetails.g();
        if (!com.target.mothership.util.o.g(productdetails))
        {
            mPresentation.p();
            return;
        }
        productdetails = new com.target.ui.common.h(productdetails);
        if (q())
        {
            a(((com.target.ui.common.h) (productdetails)), (RegistryProductDetails)mProductDetailsRequestParam.d().c());
        }
        mPresentation.a(productdetails, flag);
    }

    private void a(ProductDetails productdetails, boolean flag, boolean flag1)
    {
        productdetails = new com.target.ui.common.g(productdetails);
        productdetails.a(flag);
        if (!productdetails.a())
        {
            mPresentation.u();
            return;
        } else
        {
            mPresentation.a(productdetails, flag1);
            return;
        }
    }

    private void a(ProductRecommendations productrecommendations, boolean flag)
    {
        if (productrecommendations == null)
        {
            mPresentation.x();
            return;
        } else
        {
            mPresentation.a(productrecommendations, flag);
            return;
        }
    }

    private void a(RegistryProductDetails registryproductdetails, Store store)
    {
        mProductDataHelper.a(registryproductdetails, store, this);
    }

    private void a(com.target.ui.common.e e1, ProductDetails productdetails)
    {
        productdetails = productdetails.x().iterator();
        ProductCallout productcallout;
        do
        {
            if (productdetails.hasNext())
            {
                productcallout = (ProductCallout)productdetails.next();
                if (!productcallout.a().equals(com.target.mothership.common.product.a.ONLY_AT_TARGET))
                {
                    continue;
                }
                e1.a(productcallout.a());
            }
            return;
        } while (!productcallout.a().equals(com.target.mothership.common.product.a.NEW_AT_TARGET));
        e1.a(productcallout.a());
    }

    private void a(com.target.ui.common.e e1, ProductDetails productdetails, StoreSummary storesummary)
    {
        c c1;
        if (storesummary != null)
        {
            if ((c1 = new c(productdetails)).c())
            {
                e1.b((String)c1.a().d());
                e1.a(mProductUtilsProvider.a((d)c1.b().d()));
                e1.a(storesummary.getName());
                e1.a(productdetails.u().c());
                return;
            }
        }
    }

    private void a(com.target.ui.common.h h1, RegistryProductDetails registryproductdetails)
    {
        int j1 = registryproductdetails.L();
        int k1 = registryproductdetails.K();
        int i1;
        if (j1 == k1)
        {
            i1 = 0x7f0f00ec;
            registryproductdetails = mStringResProvider.a(0x7f0904b0);
        } else
        {
            i1 = 0x7f0f00f6;
            registryproductdetails = String.format(mStringResProvider.a(0x7f0904aa), new Object[] {
                Integer.valueOf(j1), Integer.valueOf(k1)
            });
        }
        h1.a(registryproductdetails);
        h1.a(i1);
    }

    private void a(ProductVariationModel productvariationmodel, boolean flag)
    {
        if (productvariationmodel == null || productvariationmodel.a().equals(com.target.ui.model.product.ProductVariationModel.a.NONE))
        {
            mPresentation.t();
            return;
        } else
        {
            mPresentation.a(productvariationmodel, flag);
            return;
        }
    }

    private void a(String s1)
    {
        mDvmDataHelper.a(s1, this);
    }

    private void a(List list)
    {
        list = com.target.ui.i.c.b.a(list);
        mPresentation.a(list);
    }

    private void a(List list, ProductDetails productdetails, RelevantStoreSummary relevantstoresummary)
    {
        b(productdetails, relevantstoresummary, false);
        a(productdetails, false);
        a(list);
        a(productdetails, relevantstoresummary, false);
    }

    private ProductDetails b(ProductDetailsWrapper productdetailswrapper)
    {
        return (ProductDetails)productdetailswrapper.b().get(0);
    }

    private void b(ProductDetails productdetails)
    {
        mPresentation.a(productdetails, com.target.ui.analytics.a.al.a.PickUp);
    }

    private void b(ProductDetails productdetails, RelevantStoreSummary relevantstoresummary, boolean flag)
    {
        com.target.ui.common.e e1 = new com.target.ui.common.e();
        a(e1, productdetails);
        a(e1, productdetails, relevantstoresummary);
        e1.a((ProductLimitedAvailability)productdetails.c().d().d());
        e1.a((RegistryDetails)mProductDetailsRequestParam.e().d());
        e1.a(productdetails.i());
        e1.b(productdetails.c().c());
        mPresentation.a(e1, flag);
    }

    private void b(ProductDetails productdetails, boolean flag)
    {
        if (!productdetails.r().b())
        {
            mPresentation.q();
            return;
        } else
        {
            mPresentation.a((ProductImage)productdetails.r().c(), flag);
            return;
        }
    }

    private void b(ProductRecommendations productrecommendations)
    {
        mSavedRecommendations = productrecommendations;
        b(mSavedRecommendations, true);
    }

    private void b(ProductRecommendations productrecommendations, boolean flag)
    {
        mPresentation.a(productrecommendations, flag);
    }

    private void b(RelevantStoreSummary relevantstoresummary)
    {
        mSavedStoreSummary = relevantstoresummary;
    }

    private void b(ListItem listitem, GridItem griditem)
    {
        if (listitem != null || griditem != null)
        {
            String s1 = ProductVariationModelHelper.a(mSavedProductVariationModel.a(), listitem, griditem);
            listitem = ProductVariationModelHelper.b(mSavedProductVariationModel.a(), listitem, griditem);
            if (s1 != null || listitem != null)
            {
                griditem = mSavedParentProductDetails.A();
                if (griditem != null && !griditem.isEmpty())
                {
                    mSavedProductDetailsList = ProductVariationModelHelper.a(mSavedParentProductDetails, s1);
                    listitem = (ProductDetails)mSavedProductDetailsList.get(0);
                    a(mSavedProductDetailsList, listitem, mSavedStoreSummary);
                    z();
                    return;
                }
                mSavedProductDetailsList = null;
                mSavedProductDetails = ProductVariationModelHelper.a(mSavedParentProductDetails, s1, listitem);
                if (mSavedProductDetails == null)
                {
                    x();
                    v();
                    return;
                } else
                {
                    a(mSavedProductDetails, mSavedStoreSummary, mCouponApplied, false);
                    z();
                    return;
                }
            }
        }
    }

    private void c(DvmDataResponse dvmdataresponse)
    {
        mSavedDvmData = dvmdataresponse;
        a(mSavedDvmData, true);
    }

    private void c(ProductDetails productdetails)
    {
        mPresentation.a(productdetails, com.target.ui.analytics.a.al.a.ShipIt);
    }

    private void c(ProductDetails productdetails, RelevantStoreSummary relevantstoresummary, boolean flag)
    {
        boolean flag1;
        if (relevantstoresummary != null && relevantstoresummary.a())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        relevantstoresummary = com.target.ui.i.c.b.b(productdetails, flag1);
        mPresentation.a(relevantstoresummary, flag);
        c(productdetails, flag);
    }

    private void c(ProductDetails productdetails, boolean flag)
    {
        mExpressCheckoutFeature.a(productdetails, q(), flag);
    }

    private void c(ProductDetailsWrapper productdetailswrapper)
    {
        mSavedParentProductDetails = b(productdetailswrapper);
        mSavedProductDetails = mSavedParentProductDetails;
        mSavedProductVariationModel = mProductVariationModelHelper.a(mSavedProductDetails);
        a(mSavedProductDetails, mSavedProductVariationModel, mSavedStoreSummary, mSavedRecommendations, mSavedDvmData, mCouponApplied, true);
    }

    private void c(GridItem griditem)
    {
        if (griditem != null)
        {
            if ((griditem = ProductVariationModelHelper.a(griditem)) != null)
            {
                ArrayList arraylist = new ArrayList();
                arraylist.add(griditem.toString());
                mPresentation.a(arraylist, false);
                return;
            }
        }
    }

    private void d(ProductDetails productdetails)
    {
        mPresentation.a(productdetails, com.target.ui.analytics.a.al.a.AddToList);
    }

    private void d(ProductDetails productdetails, boolean flag)
    {
        productdetails = (ProductGuestReview)productdetails.j().d();
        if (productdetails == null)
        {
            mPresentation.r();
            return;
        } else
        {
            mPresentation.a(productdetails, flag);
            return;
        }
    }

    private void e(CouponPromotionId couponpromotionid)
    {
        com.target.mothership.model.guest.interfaces.Guest guest = mGuestProvider.a();
        if (guest == null)
        {
            com.target.ui.util.q.a(TAG, "Null guest encountered when attempting to apply coupon");
            return;
        } else
        {
            mPresentation.f();
            mCouponWalletsDataHelper.a(guest, couponpromotionid, this);
            return;
        }
    }

    private void e(ProductDetails productdetails)
    {
        mPresentation.c(productdetails);
    }

    private void e(ProductDetails productdetails, boolean flag)
    {
        if (!productdetails.c().f().b())
        {
            mPresentation.s();
            return;
        } else
        {
            mPresentation.a((Date)productdetails.c().f().c(), flag);
            return;
        }
    }

    private Bundle f(CouponPromotionId couponpromotionid)
    {
        Bundle bundle = new Bundle();
        bundle.putParcelable("argCouponPromotionId", couponpromotionid);
        return bundle;
    }

    private void f(ProductDetails productdetails)
    {
        if (!productdetails.C().b())
        {
            return;
        } else
        {
            productdetails = (DvmRemoteData)productdetails.C().c();
            mDvmDataHelper.a(productdetails, this);
            return;
        }
    }

    private void f(ProductDetails productdetails, boolean flag)
    {
        mPresentation.a(new f(productdetails), flag);
    }

    private void g(ProductDetails productdetails, boolean flag)
    {
        if (productdetails.m().isEmpty())
        {
            mPresentation.v();
            return;
        } else
        {
            mPresentation.a(flag);
            return;
        }
    }

    private void h(ProductDetails productdetails, boolean flag)
    {
        productdetails = com.target.ui.i.c.a.a(productdetails);
        if (!productdetails.a())
        {
            mPresentation.w();
            return;
        } else
        {
            mPresentation.a(productdetails, flag);
            return;
        }
    }

    private boolean p()
    {
        return mSavedProductDetails != null;
    }

    private boolean q()
    {
        return mProductDetailsRequestParam.d().b() && mProductDetailsRequestParam.e().b();
    }

    private boolean r()
    {
        return mProductDetailsRequestParam.f().b() && mProductDetailsRequestParam.h().b();
    }

    private e s()
    {
        Object obj = null;
        if (mSavedProductDetails == null || !mSavedProductDetails.q().b()) goto _L2; else goto _L1
_L1:
        ProductDetails productdetails = mSavedProductDetails;
_L4:
        return com.google.a.a.e.c(productdetails);
_L2:
        productdetails = obj;
        if (mSavedParentProductDetails != null)
        {
            productdetails = obj;
            if (mSavedParentProductDetails.q().b())
            {
                productdetails = mSavedParentProductDetails;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void t()
    {
        Object obj = (ProductDetails)s().d();
        if (obj == null)
        {
            return;
        } else
        {
            obj = (URL)((ProductDetails) (obj)).q().c();
            mPresentation.a(0x7f0901b6, 0x7f0904fb, ((URL) (obj)));
            return;
        }
    }

    private void u()
    {
        mPresentation.a((Bitmap)mProductDetailsRequestParam.f().c(), (String)mProductDetailsRequestParam.h().c(), (String)mProductDetailsRequestParam.g().d());
    }

    private void v()
    {
        mPresentation.o();
    }

    private void x()
    {
        ProductFulfillmentOptions productfulfillmentoptions = A();
        mPresentation.a(productfulfillmentoptions, false);
        c(null, false);
    }

    private void y()
    {
        mPresentation.i();
    }

    private void z()
    {
        boolean flag = s().b();
        if (flag == mShowShareAs)
        {
            return;
        } else
        {
            mShowShareAs = flag;
            mPresentation.j();
            return;
        }
    }

    public void a(Bundle bundle)
    {
        e((CouponPromotionId)bundle.getParcelable("argCouponPromotionId"));
    }

    public void a(Parcelable parcelable)
    {
        parcelable = (SavedState)parcelable;
        mCouponApplied = ((SavedState) (parcelable)).couponApplied;
        mSavedProductDetails = ((SavedState) (parcelable)).productDetails;
        mSavedParentProductDetails = ((SavedState) (parcelable)).parentProductDetails;
        mSavedProductDetailsList = ((SavedState) (parcelable)).productDetailsList;
        mSavedProductVariationModel = ((SavedState) (parcelable)).productVariationModel;
        mSavedDvmData = ((SavedState) (parcelable)).dvmData;
        mSavedStoreSummary = ((SavedState) (parcelable)).storeSummary;
        mSavedRecommendations = ((SavedState) (parcelable)).recommendations;
    }

    public void a(Menu menu)
    {
        menu = menu.findItem(0x7f10060b);
        if (menu == null)
        {
            return;
        } else
        {
            mPresentation.a(menu, mShowShareAs);
            return;
        }
    }

    public void a(Menu menu, MenuInflater menuinflater)
    {
        mPresentation.a(menu, menuinflater, 0x7f120012);
        mPresentation.a("");
    }

    public void a(CouponPromotionId couponpromotionid)
    {
        e(couponpromotionid);
    }

    public void a(DvmDataResponse dvmdataresponse)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            a(Uri.parse(dvmdataresponse.c()), dvmdataresponse.b());
            return;
        }
    }

    public void a(ProductCartWheel productcartwheel)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.b(productcartwheel.b());
            return;
        }
    }

    protected void a(ProductDetails productdetails, RelevantStoreSummary relevantstoresummary, String s1, boolean flag)
    {
        boolean flag1;
        if (relevantstoresummary != null && relevantstoresummary.a())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        productdetails = com.target.ui.i.c.c.a(productdetails, flag1, com.target.ui.i.c.c.a.REGULAR, s1);
        if (productdetails.j() && relevantstoresummary != null)
        {
            productdetails.e(relevantstoresummary.getName());
        }
        productdetails.d(false);
        mPresentation.a(productdetails, flag);
    }

    protected void a(ProductDetails productdetails, RelevantStoreSummary relevantstoresummary, boolean flag)
    {
        a(productdetails, relevantstoresummary, ((String) (null)), flag);
    }

    public void a(ProductDetails productdetails, ProductVariationModel productvariationmodel)
    {
        mSavedProductDetails = productdetails;
        mSavedProductVariationModel = productvariationmodel;
    }

    public void a(ProductDetailsWrapper productdetailswrapper)
    {
        if (mPresentation == null || productdetailswrapper == null || productdetailswrapper.b().isEmpty())
        {
            return;
        } else
        {
            c(productdetailswrapper);
            f(b(productdetailswrapper));
            return;
        }
    }

    public void a(ProductPromotion productpromotion)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.a(productpromotion);
            return;
        }
    }

    public void a(ProductRecommendations productrecommendations)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            b(productrecommendations);
            return;
        }
    }

    public void a(RelevantStoreSummary relevantstoresummary)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            b(relevantstoresummary);
            return;
        }
    }

    public void a(x x1)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            G();
            return;
        }
    }

    public void a(com.target.ui.common.a a1)
    {
        if (mPresentation != null)
        {
            if ((a1 = a1.b()).b())
            {
                mPresentation.a((String)a1.c(), 0x7f09042b);
                return;
            }
        }
    }

    public void a(b b1)
    {
        mPresentation = b1;
        mExpressCheckoutFeature.a(b1);
        if (mDeviceOsProvider.a())
        {
            mPresentation.b();
            if (r())
            {
                u();
            }
        }
        if (p())
        {
            a(mSavedProductDetails, mSavedProductVariationModel, mSavedStoreSummary, mSavedRecommendations, mSavedDvmData, mCouponApplied, false);
            return;
        } else
        {
            C();
            return;
        }
    }

    public void a(com.target.ui.helper.product.b b1)
    {
        if (mPresentation == null)
        {
            return;
        }
        if (q())
        {
            a(mSavedProductDetails, b1);
            mPresentation.a(mSavedProductDetails, (RegistryDetails)mProductDetailsRequestParam.e().c(), b1, (Store)mProductDetailsRequestParam.a().d(), a(mSavedProductDetails), mSavedParentProductDetails, mSavedProductVariationModel);
            return;
        }
        if (mSavedProductDetailsList != null)
        {
            ProductDetails productdetails = ProductVariationModelHelper.a(b1, mSavedProductDetailsList);
            a(productdetails, b1);
            mPresentation.a(productdetails, b1, (Store)mProductDetailsRequestParam.a().d(), g.PICK_UP_IN_STORE, mSavedParentProductDetails, mSavedProductVariationModel);
            return;
        } else
        {
            a(mSavedProductDetails, b1);
            mPresentation.a(mSavedProductDetails, b1, (Store)mProductDetailsRequestParam.a().d(), a(mSavedProductDetails), mSavedParentProductDetails, mSavedProductVariationModel);
            return;
        }
    }

    public void a(GridItem griditem)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            c(griditem);
            return;
        }
    }

    public void a(ListItem listitem, GridItem griditem)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            b(listitem, griditem);
            return;
        }
    }

    public void a(ProductVariationModel productvariationmodel)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mSavedProductVariationModel = productvariationmodel;
            a(mSavedProductVariationModel, false);
            b(productvariationmodel.f(), productvariationmodel.g());
            return;
        }
    }

    public void a(BitmapImageView bitmapimageview, ProductDetails productdetails)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            productdetails = new com.target.ui.c.d.d(productdetails);
            productdetails.a(bitmapimageview);
            productdetails.a((Store)mProductDetailsRequestParam.a().d());
            mPresentation.a(productdetails);
            return;
        }
    }

    public volatile void a(Object obj)
    {
        a((b)obj);
    }

    public void a(Void void1)
    {
        com.target.ui.util.q.d(TAG, "Dvm : click registered with google successfully");
    }

    public boolean a(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return false;

        case 2131756555: 
            t();
            break;
        }
        return true;
    }

    public void b(CouponPromotionId couponpromotionid)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mCouponApplied = true;
            mPresentation.d();
            return;
        }
    }

    public void b(DvmDataResponse dvmdataresponse)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            c(dvmdataresponse);
            return;
        }
    }

    public void b(x x1)
    {
    }

    public void b(GridItem griditem)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            c(griditem);
            return;
        }
    }

    public void c()
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.a(mSavedParentProductDetails, mSavedProductVariationModel, (Store)mProductDetailsRequestParam.a().d());
            return;
        }
    }

    public void c(CouponPromotionId couponpromotionid)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.e();
            mPresentation.a(0x7f09041e, f(couponpromotionid));
            return;
        }
    }

    public void c(x x1)
    {
        com.target.ui.util.q.a(TAG, "Dvm : click registration failure");
    }

    public void d()
    {
        if (mPresentation == null)
        {
            return;
        }
        ProductDetails productdetails;
        if (mSavedProductDetails != null)
        {
            productdetails = mSavedProductDetails;
        } else
        {
            productdetails = mSavedParentProductDetails;
        }
        d(productdetails);
        mPresentation.a(productdetails);
    }

    public void d(CouponPromotionId couponpromotionid)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.e();
            mPresentation.a(0x7f09041d, f(couponpromotionid));
            return;
        }
    }

    public void d(x x1)
    {
    }

    public void e()
    {
        C();
    }

    public void f()
    {
        if (mPresentation == null)
        {
            return;
        }
        B();
        Store store = (Store)mProductDetailsRequestParam.a().d();
        if (store == null)
        {
            com.target.ui.util.q.a(TAG, "We don't have store info when aisle location is shown, This should not happen");
            return;
        } else
        {
            mPresentation.a(mSavedProductDetails, store);
            return;
        }
    }

    public void g()
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mSavedProductDetails = mSavedParentProductDetails;
            mSavedProductDetailsList = null;
            a(mSavedProductDetails, mSavedStoreSummary, mCouponApplied, false);
            z();
            return;
        }
    }

    public void h()
    {
        if (mPresentation == null)
        {
            return;
        }
        ProductDetails productdetails;
        if (mSavedProductDetails == null)
        {
            productdetails = mSavedParentProductDetails;
        } else
        {
            productdetails = mSavedProductDetails;
        }
        mPresentation.b(productdetails, (Store)mProductDetailsRequestParam.a().d());
    }

    public void i()
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.b(mSavedParentProductDetails);
            return;
        }
    }

    public void j()
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.a(mSavedParentProductDetails, mSavedProductVariationModel, (Store)mProductDetailsRequestParam.a().d());
            return;
        }
    }

    public void k()
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.A();
            return;
        }
    }

    public void l()
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.b(mSavedParentProductDetails, (Store)mProductDetailsRequestParam.a().d());
            return;
        }
    }

    public Parcelable m()
    {
        SavedState savedstate = new SavedState();
        savedstate.couponApplied = mCouponApplied;
        savedstate.productDetails = mSavedProductDetails;
        savedstate.parentProductDetails = mSavedParentProductDetails;
        savedstate.productDetailsList = mSavedProductDetailsList;
        savedstate.productVariationModel = mSavedProductVariationModel;
        savedstate.dvmData = mSavedDvmData;
        savedstate.storeSummary = mSavedStoreSummary;
        savedstate.recommendations = mSavedRecommendations;
        return savedstate;
    }

    public void n()
    {
    }

    public void o()
    {
    }

    public void t_()
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            H();
            return;
        }
    }

    public void v_()
    {
        mDvmDataHelper = null;
        mStoreDataHelper = null;
        mProductDataHelper = null;
        mDeviceOsProvider = null;
        mProductUtilsProvider = null;
        mStringResProvider = null;
        mProductDetailsRequestParam = null;
        mProductVariationModelHelper = null;
    }

    public void w()
    {
    }

    public void z_()
    {
        mDvmDataHelper.a();
        mStoreDataHelper.a();
        mProductDataHelper.a();
        mPresentation.c();
        mPresentation = null;
    }

}
