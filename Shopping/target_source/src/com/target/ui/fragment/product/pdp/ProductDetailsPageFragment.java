// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.pdp;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.target.mothership.common.coupon_wallets.CouponPromotionId;
import com.target.mothership.common.product.ProductIdentifier;
import com.target.mothership.model.dvm.interfaces.DvmDataResponse;
import com.target.mothership.model.list.interfaces.ListSummary;
import com.target.mothership.model.product.interfaces.Product;
import com.target.mothership.model.product.interfaces.ProductCartWheel;
import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.mothership.model.product.interfaces.ProductGuestReview;
import com.target.mothership.model.product.interfaces.ProductImage;
import com.target.mothership.model.product.interfaces.ProductPromotion;
import com.target.mothership.model.product.interfaces.ProductRecommendations;
import com.target.mothership.model.registries.interfaces.RegistryDetails;
import com.target.mothership.model.registries.interfaces.RegistryProductDetails;
import com.target.mothership.model.store.interfaces.Store;
import com.target.ui.analytics.a.ah;
import com.target.ui.analytics.a.ak;
import com.target.ui.analytics.b.j;
import com.target.ui.c.c.a;
import com.target.ui.c.d.d;
import com.target.ui.common.ProductFulfillmentOptions;
import com.target.ui.f.c;
import com.target.ui.fragment.common.BaseNavigationFragment;
import com.target.ui.fragment.common.GenericRetryErrorDialogFragment;
import com.target.ui.fragment.common.TargetWebFragment;
import com.target.ui.fragment.product.common.PageItemHierarchy;
import com.target.ui.fragment.product.dialog.ProductFiatsDialogFragment;
import com.target.ui.fragment.product.pdp.a.b;
import com.target.ui.fragment.product.pdp.presenter.ProductDetailsPagePresenter;
import com.target.ui.fragment.product.reviews.ProductReadReviewFragment;
import com.target.ui.helper.product.ProductVariationModelHelper;
import com.target.ui.helper.product.g;
import com.target.ui.helper.product.h;
import com.target.ui.model.product.GridItem;
import com.target.ui.model.product.ListItem;
import com.target.ui.model.product.ProductVariationModel;
import com.target.ui.service.provider.DefaultStringResourceProvider;
import com.target.ui.service.provider.e;
import com.target.ui.service.provider.f;
import com.target.ui.service.provider.i;
import com.target.ui.util.ad;
import com.target.ui.util.aj;
import com.target.ui.util.al;
import com.target.ui.util.n;
import com.target.ui.util.q;
import com.target.ui.view.BitmapImageView;
import com.target.ui.view.common.TargetErrorView;
import com.target.ui.view.product.PdpCartwheelAndPromotionView;
import com.target.ui.view.product.PdpChokingHazardView;
import com.target.ui.view.product.PdpDvmView;
import com.target.ui.view.product.PdpFulfillmentView;
import com.target.ui.view.product.PdpHeaderView;
import com.target.ui.view.product.PdpOtherLayoutView;
import com.target.ui.view.product.PdpPhonePlanPricingView;
import com.target.ui.view.product.PdpPreOrderDateView;
import com.target.ui.view.product.PdpPriceInfoView;
import com.target.ui.view.product.PdpRecommendationsView;
import com.target.ui.view.product.PdpTitleView;
import com.target.ui.view.product.PdpVariationView;
import com.target.ui.view.product.ProductViewPager;
import java.net.URL;
import java.util.Date;
import java.util.List;

// Referenced classes of package com.target.ui.fragment.product.pdp:
//            ProductShippingAndReturnsPageFragment, ProductPromotionPageFragment, ProductDescriptionPageFragment

public class ProductDetailsPageFragment extends BaseNavigationFragment
    implements com.target.ui.fragment.account.BaseAccountDialog.f, com.target.ui.fragment.common.GenericRetryErrorDialogFragment.a, com.target.ui.fragment.product.dialog.BaseProductDialogFragment.b, com.target.ui.fragment.product.dialog.ProductAddToCartErrorDialog.c, com.target.ui.fragment.product.dialog.ProductAddToListDialogFragment.c, com.target.ui.fragment.product.pdp.a.b
{
    static class Views extends com.target.ui.view.a
    {

        PdpCartwheelAndPromotionView cartwheelAndPromotionView;
        PdpChokingHazardView chokingHazardView;
        View contentContainer;
        PdpDvmView dvmView;
        TargetErrorView errorContainer;
        Button expressCheckoutButton;
        PdpFulfillmentView fulfillmentView;
        PdpHeaderView headerView;
        ProductViewPager imageViewPager;
        PdpOtherLayoutView otherLayouts;
        PdpPhonePlanPricingView phonePricingView;
        PdpPriceInfoView prdPriceGuestReviewView;
        PdpPreOrderDateView preOrderDateView;
        View progressContainer;
        PdpRecommendationsView recommendationsView;
        PdpTitleView titleView;
        PdpVariationView variationView;

        Views(View view)
        {
            super(view);
        }
    }

    private class a extends com.target.ui.c.a.e
    {

        final ProductDetailsPageFragment this$0;

        public void a(ProductDetails productdetails)
        {
            super.a(productdetails);
            com.target.ui.analytics.a.l.a(productdetails, com.target.ui.fragment.product.pdp.ProductDetailsPageFragment.a(ProductDetailsPageFragment.this), 3).e();
        }

        public void a(ProductDetails productdetails, ProductVariationModel productvariationmodel, com.target.ui.helper.product.b b1)
        {
            com.target.ui.fragment.product.pdp.ProductDetailsPageFragment.c(ProductDetailsPageFragment.this).a(productdetails, productvariationmodel);
        }

        public void a(com.target.ui.helper.product.b b1, boolean flag)
        {
            com.target.ui.fragment.product.pdp.ProductDetailsPageFragment.a(ProductDetailsPageFragment.this, b1, flag);
        }

        public void a(GridItem griditem)
        {
            com.target.ui.fragment.product.pdp.ProductDetailsPageFragment.c(ProductDetailsPageFragment.this).b(griditem);
        }

        public void a(ProductVariationModel productvariationmodel)
        {
            com.target.ui.fragment.product.pdp.ProductDetailsPageFragment.c(ProductDetailsPageFragment.this).a(productvariationmodel);
        }

        public void a(String s1)
        {
            com.target.ui.fragment.product.pdp.ProductDetailsPageFragment.b(ProductDetailsPageFragment.this).c(s1);
        }

        public void a(boolean flag)
        {
            com.target.ui.fragment.product.pdp.ProductDetailsPageFragment.a(ProductDetailsPageFragment.this, flag);
        }

        private a()
        {
            this$0 = ProductDetailsPageFragment.this;
            super();
        }

    }

    private class b extends com.target.ui.c.b.e
    {

        final ProductDetailsPageFragment this$0;

        public void a(String s1)
        {
            com.target.ui.fragment.product.pdp.ProductDetailsPageFragment.b(ProductDetailsPageFragment.this).c(s1);
        }

        public void a(String s1, ListSummary listsummary)
        {
            ad.a(getActivity(), s1, com.target.ui.fragment.product.pdp.ProductDetailsPageFragment.b(ProductDetailsPageFragment.this), listsummary, m());
        }

        public void a(boolean flag)
        {
            com.target.ui.fragment.product.pdp.ProductDetailsPageFragment.d(ProductDetailsPageFragment.this).fulfillmentView.e(flag);
        }

        private b()
        {
            this$0 = ProductDetailsPageFragment.this;
            super();
        }

    }

    private class c
        implements com.target.ui.view.common.c
    {

        final ProductDetailsPageFragment this$0;

        public void A_()
        {
            com.target.ui.fragment.product.pdp.ProductDetailsPageFragment.c(ProductDetailsPageFragment.this).e();
        }

        private c()
        {
            this$0 = ProductDetailsPageFragment.this;
            super();
        }

    }

    private class d
        implements com.target.ui.view.product.PdpCartwheelAndPromotionView.c
    {

        final ProductDetailsPageFragment this$0;

        public void a(CouponPromotionId couponpromotionid)
        {
            com.target.ui.fragment.product.pdp.ProductDetailsPageFragment.c(ProductDetailsPageFragment.this).a(couponpromotionid);
        }

        public void a(ProductCartWheel productcartwheel)
        {
            com.target.ui.fragment.product.pdp.ProductDetailsPageFragment.c(ProductDetailsPageFragment.this).a(productcartwheel);
        }

        public void a(ProductPromotion productpromotion)
        {
            com.target.ui.fragment.product.pdp.ProductDetailsPageFragment.c(ProductDetailsPageFragment.this).a(productpromotion);
        }

        private d()
        {
            this$0 = ProductDetailsPageFragment.this;
            super();
        }

    }

    private class e
        implements com.target.ui.view.product.PdpChokingHazardView.a
    {

        final ProductDetailsPageFragment this$0;

        public void a()
        {
            com.target.ui.fragment.product.pdp.ProductDetailsPageFragment.c(ProductDetailsPageFragment.this).l();
        }

        private e()
        {
            this$0 = ProductDetailsPageFragment.this;
            super();
        }

    }

    private class f
        implements com.target.ui.view.product.PdpDvmView.a
    {

        final ProductDetailsPageFragment this$0;

        public void a(DvmDataResponse dvmdataresponse)
        {
            com.target.ui.fragment.product.pdp.ProductDetailsPageFragment.c(ProductDetailsPageFragment.this).a(dvmdataresponse);
        }

        private f()
        {
            this$0 = ProductDetailsPageFragment.this;
            super();
        }

    }

    private class g
        implements android.view.View.OnClickListener
    {

        final ProductDetailsPageFragment this$0;

        public void onClick(View view)
        {
            ak.a(com.target.ui.fragment.product.pdp.ProductDetailsPageFragment.a(ProductDetailsPageFragment.this)).e();
            com.target.ui.fragment.product.pdp.ProductDetailsPageFragment.c(ProductDetailsPageFragment.this).a(com.target.ui.helper.product.b.EXPRESS_CHECKOUT);
        }

        private g()
        {
            this$0 = ProductDetailsPageFragment.this;
            super();
        }

    }

    private class h
        implements com.target.ui.view.product.PdpFulfillmentView.a
    {

        final ProductDetailsPageFragment this$0;

        public void a()
        {
            com.target.ui.fragment.product.pdp.ProductDetailsPageFragment.c(ProductDetailsPageFragment.this).a(com.target.ui.helper.product.b.PICK_UP);
        }

        public void b()
        {
            com.target.ui.fragment.product.pdp.ProductDetailsPageFragment.c(ProductDetailsPageFragment.this).a(com.target.ui.helper.product.b.EMAIL);
        }

        public void c()
        {
            com.target.ui.fragment.product.pdp.ProductDetailsPageFragment.c(ProductDetailsPageFragment.this).a(com.target.ui.helper.product.b.SMS);
        }

        public void d()
        {
            com.target.ui.fragment.product.pdp.ProductDetailsPageFragment.c(ProductDetailsPageFragment.this).a(com.target.ui.helper.product.b.MAIL);
        }

        public void e()
        {
            com.target.ui.fragment.product.pdp.ProductDetailsPageFragment.c(ProductDetailsPageFragment.this).a(com.target.ui.helper.product.b.SHIP);
        }

        public void f()
        {
            com.target.ui.fragment.product.pdp.ProductDetailsPageFragment.c(ProductDetailsPageFragment.this).c();
        }

        public void g()
        {
            com.target.ui.fragment.product.pdp.ProductDetailsPageFragment.c(ProductDetailsPageFragment.this).d();
        }

        private h()
        {
            this$0 = ProductDetailsPageFragment.this;
            super();
        }

    }

    private class i
        implements com.target.ui.view.product.PdpHeaderView.a
    {

        final ProductDetailsPageFragment this$0;

        public void a()
        {
            com.target.ui.fragment.product.pdp.ProductDetailsPageFragment.c(ProductDetailsPageFragment.this).f();
        }

        private i()
        {
            this$0 = ProductDetailsPageFragment.this;
            super();
        }

    }

    private class j
        implements com.target.ui.view.product.PdpOtherLayoutView.a
    {

        final ProductDetailsPageFragment this$0;

        public void a()
        {
            com.target.ui.fragment.product.pdp.ProductDetailsPageFragment.c(ProductDetailsPageFragment.this).h();
        }

        public void b()
        {
            com.target.ui.fragment.product.pdp.ProductDetailsPageFragment.c(ProductDetailsPageFragment.this).i();
        }

        public void c()
        {
            com.target.ui.fragment.product.pdp.ProductDetailsPageFragment.c(ProductDetailsPageFragment.this).j();
        }

        public void d()
        {
            com.target.ui.fragment.product.pdp.ProductDetailsPageFragment.c(ProductDetailsPageFragment.this).k();
        }

        private j()
        {
            this$0 = ProductDetailsPageFragment.this;
            super();
        }

    }

    private class k
        implements com.target.ui.view.product.PdpPhonePlanPricingView.a
    {

        final ProductDetailsPageFragment this$0;

        public void a(com.target.ui.common.a a1)
        {
            com.target.ui.fragment.product.pdp.ProductDetailsPageFragment.c(ProductDetailsPageFragment.this).a(a1);
        }

        private k()
        {
            this$0 = ProductDetailsPageFragment.this;
            super();
        }

    }

    private class l
        implements com.target.ui.view.product.PdpPriceInfoView.a
    {

        final ProductDetailsPageFragment this$0;

        public void a()
        {
            com.target.ui.fragment.product.pdp.ProductDetailsPageFragment.c(ProductDetailsPageFragment.this).i();
        }

        private l()
        {
            this$0 = ProductDetailsPageFragment.this;
            super();
        }

    }

    private class m
        implements com.target.ui.view.product.PdpRecommendationsView.a
    {

        final ProductDetailsPageFragment this$0;

        public void a(BitmapImageView bitmapimageview, ProductDetails productdetails)
        {
            com.target.ui.fragment.product.pdp.ProductDetailsPageFragment.c(ProductDetailsPageFragment.this).a(bitmapimageview, productdetails);
        }

        private m()
        {
            this$0 = ProductDetailsPageFragment.this;
            super();
        }

    }

    private class n
        implements com.target.ui.view.product.PdpVariationView.a
    {

        final ProductDetailsPageFragment this$0;

        public void a()
        {
            com.target.ui.fragment.product.pdp.ProductDetailsPageFragment.c(ProductDetailsPageFragment.this).g();
        }

        public void a(GridItem griditem)
        {
            com.target.ui.fragment.product.pdp.ProductDetailsPageFragment.c(ProductDetailsPageFragment.this).a(griditem);
        }

        public void a(ListItem listitem, GridItem griditem)
        {
            com.target.ui.fragment.product.pdp.ProductDetailsPageFragment.c(ProductDetailsPageFragment.this).a(listitem, griditem);
        }

        private n()
        {
            this$0 = ProductDetailsPageFragment.this;
            super();
        }

    }


    protected static final String ARG_CATEGORY_HIERARCHY = "categoryHierarchyArg";
    protected static final String ARG_PRODUCT = "productArg";
    protected static final String ARG_PRODUCT_IDENTIFIER = "productIdentifierArg";
    private static final String ARG_REGISTRY_DETAILS = "registryDetailsArg";
    private static final String ARG_REGISTRY_PRODUCT = "registryProductDetailsArg";
    private static final String ARG_SAVED_STATE_PRESENTER = "pdpPresenterSavedStateArg";
    protected static final String ARG_STORE = "storeArg";
    private static final String ARG_THUMBNAIL = "thumbnailArg";
    private static final String ARG_THUMBNAIL_URL = "thumbnailUrlArg";
    private static final String ARG_TRANSITION_TAG = "transitionTagArg";
    public static final String TAG = com/target/ui/fragment/product/pdp/ProductDetailsPageFragment.getSimpleName();
    private static final String TRANSITION_TAG = "pdp_transition_tag";
    private com.target.ui.c.a.b mAddToCartDelegate;
    private com.target.ui.c.b.b mAddToListDelegate;
    private com.target.ui.c.c.a mNavigateToMapDelegate;
    private com.target.ui.c.d.a mNavigateToPdpDelegate;
    private ProductDetailsPagePresenter mPresenter;
    private Parcelable mSavedState;
    private com.target.ui.view.common.h mSnackBar;
    private Views mViews;

    public ProductDetailsPageFragment()
    {
        mAddToCartDelegate = new com.target.ui.c.a.b(this, new a());
        mAddToListDelegate = new com.target.ui.c.b.b(this, new b());
        mNavigateToMapDelegate = new com.target.ui.c.c.a(this);
        mNavigateToPdpDelegate = new com.target.ui.c.d.a(this);
    }

    private Store F()
    {
        return (Store)getArguments().getParcelable("storeArg");
    }

    private Product G()
    {
        return (Product)getArguments().getParcelable("productArg");
    }

    private ProductIdentifier H()
    {
        return (ProductIdentifier)getArguments().getParcelable("productIdentifierArg");
    }

    private RegistryProductDetails I()
    {
        return (RegistryProductDetails)getArguments().getParcelable("registryProductDetailsArg");
    }

    private RegistryDetails J()
    {
        return (RegistryDetails)getArguments().getParcelable("registryDetailsArg");
    }

    private PageItemHierarchy K()
    {
        return (PageItemHierarchy)getArguments().getParcelable("categoryHierarchyArg");
    }

    private Bitmap L()
    {
        return (Bitmap)getArguments().getParcelable("thumbnailArg");
    }

    private String M()
    {
        return getArguments().getString("thumbnailUrlArg");
    }

    private void N()
    {
        mViews.headerView.setClickListener(new i());
        mViews.prdPriceGuestReviewView.setClickListener(new l());
        mViews.fulfillmentView.setClickListener(new h());
        mViews.expressCheckoutButton.setOnClickListener(new g());
        mViews.variationView.setClickListener(new n());
        mViews.cartwheelAndPromotionView.setClickListener(new d());
        mViews.otherLayouts.setClickListener(new j());
        mViews.chokingHazardView.setClickListener(new e());
        mViews.recommendationsView.setClickListener(new m());
        mViews.dvmView.setClickListener(new f());
        mViews.errorContainer.setClickListener(new c());
        mViews.phonePricingView.setClickListener(new k());
    }

    private void O()
    {
        mViews.variationView.setClickListener(null);
        mViews.fulfillmentView.setClickListener(null);
        mViews.expressCheckoutButton.setOnClickListener(null);
        mViews.headerView.setClickListener(null);
        mViews.prdPriceGuestReviewView.setClickListener(null);
        mViews.cartwheelAndPromotionView.setClickListener(null);
        mViews.otherLayouts.setClickListener(null);
        mViews.chokingHazardView.setClickListener(null);
        mViews.recommendationsView.setClickListener(null);
        mViews.dvmView.setClickListener(null);
        mViews.errorContainer.setClickListener(null);
        mViews.phonePricingView.setClickListener(null);
    }

    static PageItemHierarchy a(ProductDetailsPageFragment productdetailspagefragment)
    {
        return productdetailspagefragment.K();
    }

    public static ProductDetailsPageFragment a(ProductIdentifier productidentifier, Store store)
    {
        ProductDetailsPageFragment productdetailspagefragment = new ProductDetailsPageFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("storeArg", store);
        bundle.putParcelable("productIdentifierArg", productidentifier);
        productdetailspagefragment.setArguments(bundle);
        return productdetailspagefragment;
    }

    public static ProductDetailsPageFragment a(Product product, PageItemHierarchy pageitemhierarchy, Store store)
    {
        ProductDetailsPageFragment productdetailspagefragment = new ProductDetailsPageFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("storeArg", store);
        bundle.putParcelable("productArg", product);
        bundle.putParcelable("categoryHierarchyArg", pageitemhierarchy);
        productdetailspagefragment.setArguments(bundle);
        return productdetailspagefragment;
    }

    public static ProductDetailsPageFragment a(RegistryProductDetails registryproductdetails, RegistryDetails registrydetails, Store store)
    {
        ProductDetailsPageFragment productdetailspagefragment = new ProductDetailsPageFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("storeArg", store);
        bundle.putParcelable("registryProductDetailsArg", registryproductdetails);
        bundle.putParcelable("registryDetailsArg", registrydetails);
        productdetailspagefragment.setArguments(bundle);
        return productdetailspagefragment;
    }

    private static void a(View view, boolean flag)
    {
        if (flag)
        {
            aj.f(view);
            return;
        } else
        {
            al.b(view);
            return;
        }
    }

    static void a(ProductDetailsPageFragment productdetailspagefragment, com.target.ui.helper.product.b b1, boolean flag)
    {
        productdetailspagefragment.a(b1, flag);
    }

    static void a(ProductDetailsPageFragment productdetailspagefragment, boolean flag)
    {
        productdetailspagefragment.o(flag);
    }

    private void a(com.target.ui.helper.product.b b1, boolean flag)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$target$ui$helper$product$AddToCartItemType[];

            static 
            {
                $SwitchMap$com$target$ui$helper$product$AddToCartItemType = new int[com.target.ui.helper.product.b.values().length];
                try
                {
                    $SwitchMap$com$target$ui$helper$product$AddToCartItemType[com.target.ui.helper.product.b.SMS.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$target$ui$helper$product$AddToCartItemType[com.target.ui.helper.product.b.EMAIL.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$target$ui$helper$product$AddToCartItemType[com.target.ui.helper.product.b.MAIL.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$target$ui$helper$product$AddToCartItemType[com.target.ui.helper.product.b.SHIP.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$ui$helper$product$AddToCartItemType[com.target.ui.helper.product.b.PICK_UP.ordinal()] = 5;
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
            mViews.fulfillmentView.d(flag);
            return;

        case 2: // '\002'
            mViews.fulfillmentView.f(flag);
            return;

        case 3: // '\003'
            mViews.fulfillmentView.c(flag);
            return;

        case 4: // '\004'
            mViews.fulfillmentView.b(flag);
            return;

        case 5: // '\005'
            mViews.fulfillmentView.a(flag);
            break;
        }
    }

    private static void a(PdpHeaderView pdpheaderview, boolean flag)
    {
        if (flag)
        {
            aj.h(pdpheaderview);
            return;
        } else
        {
            al.b(pdpheaderview);
            return;
        }
    }

    static com.target.ui.view.common.h b(ProductDetailsPageFragment productdetailspagefragment)
    {
        return productdetailspagefragment.mSnackBar;
    }

    private void b(int i1, int j1, URL url)
    {
        url = (new StringBuilder()).append(getString(i1)).append(" ").append(url.toString()).toString();
        String s1 = getString(i1);
        String s2 = getString(j1);
        com.target.ui.util.n.a(getActivity(), s1, url, s2);
    }

    private void b(DvmDataResponse dvmdataresponse, boolean flag)
    {
        mViews.dvmView.setDvmContent(dvmdataresponse);
        a(mViews.dvmView, flag);
    }

    private void b(ProductRecommendations productrecommendations, boolean flag)
    {
        mViews.recommendationsView.setRecommendations(productrecommendations);
        a(mViews.recommendationsView, flag);
    }

    static ProductDetailsPagePresenter c(ProductDetailsPageFragment productdetailspagefragment)
    {
        return productdetailspagefragment.mPresenter;
    }

    static Views d(ProductDetailsPageFragment productdetailspagefragment)
    {
        return productdetailspagefragment.mViews;
    }

    public void A()
    {
        if (Z())
        {
            return;
        } else
        {
            m().d(com.target.ui.fragment.product.pdp.ProductShippingAndReturnsPageFragment.a());
            return;
        }
    }

    public void B()
    {
        ah.a(com.target.ui.analytics.a.ah.a.ProductDetailPage, K()).e();
    }

    protected Parcelable C()
    {
        return mSavedState;
    }

    protected ProductDetailsPagePresenter D()
    {
        return new ProductDetailsPagePresenter(new com.target.ui.helper.product.g(), new com.target.ui.helper.product.h(), new com.target.ui.helper.g.a(), new com.target.ui.helper.e.a(), new ProductVariationModelHelper(getActivity()), new com.target.ui.service.provider.e(), new com.target.ui.service.provider.i(), new DefaultStringResourceProvider(getActivity()), E(), com.target.ui.j.a.c(), new com.target.ui.service.provider.f(), mSavedState);
    }

    protected com.target.ui.fragment.product.pdp.presenter.b E()
    {
        return (new com.target.ui.fragment.product.pdp.presenter.b.a()).a(F()).a(G()).a(H()).a(I()).a(J()).a(L()).a(M()).b(a()).a();
    }

    public String a()
    {
        if (getArguments().getString("transitionTagArg") == null)
        {
            getArguments().putString("transitionTagArg", (new StringBuilder()).append("pdp_transition_tag").append(String.valueOf(hashCode())).toString());
        }
        return getArguments().getString("transitionTagArg");
    }

    public void a(int i1, int j1, URL url)
    {
        b(i1, j1, url);
    }

    public void a(int i1, int j1, boolean flag)
    {
        mViews.errorContainer.a(getString(i1), getString(j1), flag);
        al.a(mViews.errorContainer, new View[] {
            mViews.progressContainer, mViews.contentContainer
        });
    }

    public void a(int i1, Bundle bundle)
    {
        if (Z())
        {
            return;
        } else
        {
            GenericRetryErrorDialogFragment.a(getString(i1), bundle, this).show(getFragmentManager(), GenericRetryErrorDialogFragment.TAG);
            return;
        }
    }

    public void a(Bitmap bitmap, String s1)
    {
        if (getArguments() == null)
        {
            return;
        } else
        {
            getArguments().putParcelable("thumbnailArg", bitmap);
            getArguments().putString("thumbnailUrlArg", s1);
            return;
        }
    }

    public void a(Bitmap bitmap, String s1, String s2)
    {
        mViews.imageViewPager.a(bitmap, s1, s2);
    }

    public void a(Uri uri, Store store)
    {
        if (Z())
        {
            return;
        }
        uri = (Fragment)com.target.ui.util.deep_link.g.a(uri, store).d().d();
        if (uri == null)
        {
            com.target.ui.util.q.a(TAG, "DVM : No Fragment resulted after parsing the deep link");
            return;
        } else
        {
            m().d(uri);
            return;
        }
    }

    public void a(Bundle bundle)
    {
        mPresenter.a(bundle);
    }

    public void a(Menu menu, MenuInflater menuinflater, int i1)
    {
        menuinflater.inflate(i1, menu);
    }

    public void a(MenuItem menuitem, boolean flag)
    {
        menuitem.setVisible(flag);
    }

    public void a(DvmDataResponse dvmdataresponse, boolean flag)
    {
        b(dvmdataresponse, flag);
    }

    public void a(ProductDetails productdetails)
    {
        mAddToListDelegate.a(productdetails);
    }

    public void a(ProductDetails productdetails, RegistryDetails registrydetails, com.target.ui.helper.product.b b1, Store store, com.target.mothership.common.a.g g1, ProductDetails productdetails1, ProductVariationModel productvariationmodel)
    {
        mAddToCartDelegate.a(productdetails, registrydetails, b1, store, g1, productdetails1, productvariationmodel);
    }

    public void a(ProductDetails productdetails, Store store)
    {
        mNavigateToMapDelegate.a(productdetails, store);
    }

    public void a(ProductDetails productdetails, com.target.ui.analytics.a.al.a a1)
    {
        com.target.ui.analytics.a.al.a(productdetails, a1, K()).e();
    }

    public void a(ProductDetails productdetails, com.target.ui.helper.product.b b1, Store store, com.target.mothership.common.a.g g1, ProductDetails productdetails1, ProductVariationModel productvariationmodel)
    {
        mAddToCartDelegate.a(productdetails, b1, store, g1, productdetails1, productvariationmodel);
    }

    public void a(ProductDetails productdetails, ProductVariationModel productvariationmodel, Store store)
    {
        if (Z())
        {
            return;
        } else
        {
            ProductFiatsDialogFragment.a(productdetails, productvariationmodel, store, this).show(getFragmentManager(), ProductFiatsDialogFragment.TAG);
            return;
        }
    }

    public void a(ProductDetails productdetails, boolean flag)
    {
        com.target.ui.adapter.product.c.a(mViews.expressCheckoutButton, productdetails, flag);
    }

    public void a(ProductGuestReview productguestreview, boolean flag)
    {
        mViews.prdPriceGuestReviewView.setGuestRating(productguestreview);
        a(((View) (mViews.prdPriceGuestReviewView)), flag);
    }

    public void a(ProductImage productimage, boolean flag)
    {
        mViews.imageViewPager.a(productimage, flag);
    }

    public void a(ProductPromotion productpromotion)
    {
        if (Z())
        {
            return;
        } else
        {
            m().d(com.target.ui.fragment.product.pdp.ProductPromotionPageFragment.a(productpromotion));
            return;
        }
    }

    public void a(ProductRecommendations productrecommendations, boolean flag)
    {
        b(productrecommendations, flag);
    }

    public void a(com.target.ui.c.d.d d1)
    {
        mNavigateToPdpDelegate.a(d1);
    }

    public void a(ProductFulfillmentOptions productfulfillmentoptions)
    {
        mViews.fulfillmentView.a(productfulfillmentoptions);
    }

    public void a(ProductFulfillmentOptions productfulfillmentoptions, boolean flag)
    {
        mViews.fulfillmentView.b(productfulfillmentoptions);
        a(((View) (mViews.fulfillmentView)), flag);
    }

    public void a(com.target.ui.common.a a1, boolean flag)
    {
        mViews.phonePricingView.setPhonePlanOptions(a1);
        a(((View) (mViews.phonePricingView)), flag);
    }

    public void a(com.target.ui.common.b b1, boolean flag)
    {
        mViews.prdPriceGuestReviewView.setPriceData(b1);
        mViews.prdPriceGuestReviewView.setEyebrowData(b1);
        a(((View) (mViews.prdPriceGuestReviewView)), flag);
    }

    public void a(com.target.ui.common.e e1, boolean flag)
    {
        mViews.headerView.setDisplayOptions(e1);
        a(mViews.headerView, flag);
    }

    public void a(com.target.ui.common.f f1, boolean flag)
    {
        mViews.otherLayouts.a(f1);
        a(((View) (mViews.otherLayouts)), flag);
    }

    public void a(com.target.ui.common.g g1, boolean flag)
    {
        mViews.cartwheelAndPromotionView.setData(g1);
        a(((View) (mViews.cartwheelAndPromotionView)), flag);
    }

    public void a(com.target.ui.common.h h1, boolean flag)
    {
        mViews.titleView.setDisplayOptions(h1);
        a(((View) (mViews.titleView)), flag);
    }

    public void a(ProductVariationModel productvariationmodel, boolean flag)
    {
        mViews.variationView.a(productvariationmodel);
        a(((View) (mViews.variationView)), flag);
    }

    public void a(String s1)
    {
        j(s1);
    }

    public void a(String s1, int i1)
    {
        if (Z())
        {
            return;
        } else
        {
            m().d(TargetWebFragment.a(true, s1, getString(i1)));
            return;
        }
    }

    public void a(Date date, boolean flag)
    {
        mViews.preOrderDateView.setPreOrderDate(date);
        a(((View) (mViews.preOrderDateView)), flag);
    }

    public void a(List list, boolean flag)
    {
        mViews.imageViewPager.a(list, flag);
    }

    public void a(boolean flag)
    {
        a(((View) (mViews.chokingHazardView)), flag);
    }

    public void b()
    {
        com.target.ui.f.c.f(this);
    }

    public void b(ProductDetails productdetails)
    {
        if (Z())
        {
            return;
        } else
        {
            m().d(ProductReadReviewFragment.a(productdetails));
            return;
        }
    }

    public void b(ProductDetails productdetails, Store store)
    {
        if (Z())
        {
            return;
        } else
        {
            m().d(com.target.ui.fragment.product.pdp.ProductDescriptionPageFragment.a(productdetails, store));
            return;
        }
    }

    public void b(String s1)
    {
        l(s1);
    }

    public void c()
    {
        mSnackBar.a();
    }

    public void c(ProductDetails productdetails)
    {
        com.target.ui.analytics.b.j.a(productdetails, K(), a(V())).a();
    }

    public void d()
    {
        mViews.cartwheelAndPromotionView.a();
    }

    public void e()
    {
        mViews.cartwheelAndPromotionView.b();
    }

    public void f()
    {
        mViews.cartwheelAndPromotionView.c();
    }

    public void g()
    {
        al.a(mViews.progressContainer, new View[] {
            mViews.contentContainer, mViews.errorContainer
        });
    }

    public void h()
    {
        mViews.errorContainer.a(com.target.ui.view.common.b.a.ERROR_NO_NETWORK, true);
        al.a(mViews.errorContainer, new View[] {
            mViews.progressContainer, mViews.contentContainer
        });
    }

    public void i()
    {
        al.a(mViews.contentContainer, new View[] {
            mViews.progressContainer, mViews.errorContainer
        });
    }

    public void j()
    {
        if (getActivity() == null)
        {
            return;
        } else
        {
            getActivity().d();
            return;
        }
    }

    public com.target.ui.fragment.product.dialog.ProductAddToCartErrorDialog.b k()
    {
        return mAddToCartDelegate.k();
    }

    public com.target.ui.fragment.account.BaseAccountDialog.c l()
    {
        return mAddToCartDelegate.l();
    }

    public com.target.ui.fragment.account.BaseAccountDialog.e n()
    {
        return mAddToCartDelegate.n();
    }

    public void o()
    {
        al.d(mViews.headerView);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        a(new com.target.ui.c.a[] {
            mAddToCartDelegate, mAddToListDelegate, mNavigateToMapDelegate, mNavigateToPdpDelegate
        });
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (bundle != null)
        {
            mSavedState = bundle.getParcelable("pdpPresenterSavedStateArg");
        }
        mPresenter = D();
        mSnackBar = new com.target.ui.view.common.h(getActivity());
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        if (!isAdded())
        {
            return;
        } else
        {
            mPresenter.a(menu, menuinflater);
            super.onCreateOptionsMenu(menu, menuinflater);
            return;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f03006f, viewgroup, false);
        mViews = new Views(layoutinflater);
        mPresenter.a(this);
        N();
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
        mPresenter.v_();
        mSnackBar = null;
        mPresenter = null;
        mSavedState = null;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        O();
        mPresenter.z_();
        mViews = null;
    }

    public void onDetach()
    {
        super.onDetach();
        mAddToCartDelegate = null;
        mAddToListDelegate = null;
        mNavigateToMapDelegate = null;
        mNavigateToPdpDelegate = null;
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        return mPresenter.a(menuitem) || super.onOptionsItemSelected(menuitem);
    }

    public void onPrepareOptionsMenu(Menu menu)
    {
        super.onPrepareOptionsMenu(menu);
        mPresenter.a(menu);
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        bundle.putParcelable("pdpPresenterSavedStateArg", mPresenter.m());
        super.onSaveInstanceState(bundle);
    }

    public void p()
    {
        al.d(mViews.titleView);
    }

    public void q()
    {
        al.d(mViews.imageViewPager);
    }

    public void r()
    {
        mViews.prdPriceGuestReviewView.a();
    }

    public com.target.ui.fragment.product.dialog.BaseProductDialogFragment.a r_()
    {
        return mAddToCartDelegate.r_();
    }

    public void s()
    {
        al.c(mViews.preOrderDateView);
    }

    public com.target.ui.fragment.product.dialog.ProductAddToListDialogFragment.b s_()
    {
        return mAddToListDelegate.s_();
    }

    public void t()
    {
        al.c(mViews.variationView);
    }

    public void u()
    {
        al.c(mViews.cartwheelAndPromotionView);
    }

    public void v()
    {
        al.c(mViews.chokingHazardView);
    }

    public void w()
    {
        al.c(mViews.phonePricingView);
    }

    public void x()
    {
        al.c(mViews.recommendationsView);
    }

    public void y()
    {
        al.c(mViews.dvmView);
    }

    public void z()
    {
        al.c(mViews.expressCheckoutButton);
    }

}
