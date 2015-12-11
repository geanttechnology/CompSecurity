// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.plp.presenter;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.pointinside.maps.Location;
import com.target.mothership.common.a.g;
import com.target.mothership.common.params.ProductRecommendationsParam;
import com.target.mothership.common.params.ProductSummaryParam;
import com.target.mothership.common.product.CategoryId;
import com.target.mothership.common.product.m;
import com.target.mothership.model.dvm.interfaces.DvmDataResponse;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.page_item.interfaces.PageItem;
import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.mothership.model.product.interfaces.ProductEntry;
import com.target.mothership.model.product.interfaces.ProductFacet;
import com.target.mothership.model.product.interfaces.ProductOnlineInfo;
import com.target.mothership.model.product.interfaces.ProductRecommendations;
import com.target.mothership.model.product.interfaces.ProductStoreInfo;
import com.target.mothership.model.product.interfaces.ProductSummary;
import com.target.mothership.model.product.interfaces.ProductSummaryWrapper;
import com.target.mothership.model.store.interfaces.RelevantStoreSummary;
import com.target.mothership.model.store.interfaces.Store;
import com.target.mothership.services.x;
import com.target.mothership.util.o;
import com.target.ui.analytics.h;
import com.target.ui.c.d.d;
import com.target.ui.common.ProductHeaderOptions;
import com.target.ui.fragment.product.common.PageItemHierarchy;
import com.target.ui.g.a;
import com.target.ui.helper.product.b;
import com.target.ui.helper.product.e;
import com.target.ui.model.product.AggregateProductSummaryData;
import com.target.ui.model.product.CompositeProduct;
import com.target.ui.model.refine.ProductRefineModel;
import com.target.ui.service.provider.t;
import com.target.ui.util.l;
import com.target.ui.util.q;
import com.target.ui.util.y;
import com.target.ui.view.BitmapImageView;
import com.target.ui.view.ToolbarSpinner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.target.ui.fragment.product.plp.presenter:
//            ProductSummaryPagePresenterParam, a

public class ProductSummaryPagePresenter
    implements a, com.target.ui.helper.product.e.b, com.target.ui.helper.product.e.c, com.target.ui.helper.product.e.d, com.target.ui.helper.product.e.e
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
        float actionBarDropShadowStrength;
        List appliedCategoryRefineFacets;
        List appliedRefineFacets;
        List compositeProductsGridArray;
        List compositeProductsListArray;
        int currentPageNumber;
        ProductHeaderOptions displayOptions;
        boolean isRecommendationsShown;
        int pageSize;
        ProductRefineModel refineModel;
        ProductSummaryPagePresenterParam requestParam;
        List selectedFacet;
        boolean showGridView;
        boolean showListGridToggleBtn;
        int totalRecordCount;

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i1)
        {
            boolean flag = true;
            byte byte0;
            if (showGridView)
            {
                byte0 = 1;
            } else
            {
                byte0 = 0;
            }
            parcel.writeByte(byte0);
            if (showListGridToggleBtn)
            {
                byte0 = 1;
            } else
            {
                byte0 = 0;
            }
            parcel.writeByte(byte0);
            if (isRecommendationsShown)
            {
                byte0 = flag;
            } else
            {
                byte0 = 0;
            }
            parcel.writeByte(byte0);
            parcel.writeFloat(actionBarDropShadowStrength);
            parcel.writeInt(pageSize);
            parcel.writeInt(totalRecordCount);
            parcel.writeInt(currentPageNumber);
            parcel.writeParcelable(refineModel, 0);
            parcel.writeParcelable(displayOptions, i1);
            parcel.writeList(selectedFacet);
            parcel.writeList(appliedRefineFacets);
            parcel.writeList(appliedCategoryRefineFacets);
            parcel.writeList(compositeProductsListArray);
            parcel.writeList(compositeProductsGridArray);
            parcel.writeParcelable(requestParam, i1);
        }


        public SavedState()
        {
        }

        protected SavedState(Parcel parcel)
        {
            boolean flag1 = true;
            super();
            boolean flag;
            if (parcel.readByte() != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            showGridView = flag;
            if (parcel.readByte() != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            showListGridToggleBtn = flag;
            if (parcel.readByte() != 0)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            isRecommendationsShown = flag;
            actionBarDropShadowStrength = parcel.readFloat();
            pageSize = parcel.readInt();
            totalRecordCount = parcel.readInt();
            currentPageNumber = parcel.readInt();
            refineModel = (ProductRefineModel)parcel.readParcelable(com/target/ui/model/refine/ProductRefineModel.getClassLoader());
            displayOptions = (ProductHeaderOptions)parcel.readParcelable(com/target/ui/common/ProductHeaderOptions.getClassLoader());
            selectedFacet = new ArrayList();
            appliedRefineFacets = new ArrayList();
            appliedCategoryRefineFacets = new ArrayList();
            compositeProductsListArray = new ArrayList();
            compositeProductsGridArray = new ArrayList();
            parcel.readList(selectedFacet, com/target/mothership/model/product/interfaces/ProductEntry.getClassLoader());
            parcel.readList(appliedRefineFacets, com/target/mothership/model/product/interfaces/ProductFacet.getClassLoader());
            parcel.readList(appliedCategoryRefineFacets, com/target/mothership/model/product/interfaces/ProductFacet.getClassLoader());
            parcel.readList(compositeProductsListArray, com/target/ui/model/product/CompositeProduct.getClassLoader());
            parcel.readList(compositeProductsGridArray, com/target/ui/model/product/CompositeProduct.getClassLoader());
            requestParam = (ProductSummaryPagePresenterParam)parcel.readParcelable(com/target/ui/fragment/product/plp/presenter/ProductSummaryPagePresenterParam.getClassLoader());
        }
    }


    static final int DECORATION_SCROLL_SHADOW_THRESHOLD = 20;
    private static final int DEFAULT_PAGE_NUMBER = 0;
    static final int NO_SCROLL = 0;
    private static final int PRODUCT_MAX_RECOMMENDATION = 6;
    private static final int PRODUCT_MIN_RECOMMENDATION = 6;
    static final float SHADOW_STRENGTH_MAX = 1F;
    static final float SHADOW_STRENGTH_MIN = 0F;
    private static String TAG = com/target/ui/fragment/product/plp/presenter/ProductSummaryPagePresenter.getSimpleName();
    private e mCompositeProductDataHelper;
    private com.target.ui.service.provider.l mDeviceOsProvider;
    private Guest mGuest;
    private h mLoadingTimestamp;
    private boolean mMissedLastRefineHeaderRefreshEvent;
    private com.target.ui.fragment.product.plp.a.a mPresentation;
    private RelevantStoreSummary mRelevantStoreSummary;
    private float mSavedActionBarDropShadowStrength;
    private List mSavedAppliedCategoryRefineFacets;
    private List mSavedAppliedRefineFacets;
    private List mSavedCompositeProductsGridArray;
    private List mSavedCompositeProductsListArray;
    private int mSavedCurrentPageNumber;
    private ProductHeaderOptions mSavedDisplayOptions;
    private boolean mSavedIsRecommendationsShown;
    private int mSavedPageSize;
    private ProductSummaryPagePresenterParam mSavedProductSummaryRequestParam;
    private ProductRefineModel mSavedRefineModel;
    private List mSavedSelectedFacet;
    private boolean mSavedShowGridView;
    private boolean mSavedShowListGridToggleBtn;
    private int mSavedTotalRecordCount;
    private t mTimeMeasurementProvider;

    public ProductSummaryPagePresenter(e e1, com.target.ui.service.provider.l l1, t t1, ProductSummaryPagePresenterParam productsummarypagepresenterparam, Guest guest, RelevantStoreSummary relevantstoresummary, Parcelable parcelable)
    {
        mMissedLastRefineHeaderRefreshEvent = false;
        mSavedActionBarDropShadowStrength = 1.0F;
        mSavedSelectedFacet = new ArrayList();
        mSavedAppliedRefineFacets = new ArrayList();
        mSavedAppliedCategoryRefineFacets = new ArrayList();
        mSavedCompositeProductsListArray = new ArrayList();
        mSavedCompositeProductsGridArray = new ArrayList();
        mLoadingTimestamp = new h();
        if (parcelable != null)
        {
            a(parcelable);
        }
        if (mSavedProductSummaryRequestParam == null)
        {
            mSavedProductSummaryRequestParam = productsummarypagepresenterparam;
        }
        mGuest = guest;
        mDeviceOsProvider = l1;
        mTimeMeasurementProvider = t1;
        mRelevantStoreSummary = relevantstoresummary;
        mCompositeProductDataHelper = e1;
    }

    private void A()
    {
        int i1;
        boolean flag;
        if (mSavedProductSummaryRequestParam.j())
        {
            i1 = 0x7f090484;
        } else
        {
            i1 = 0x7f090465;
        }
        if (mSavedRefineModel == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mPresentation.a(0x7f090481, i1, true, flag);
        a(false);
    }

    private void B()
    {
        boolean flag;
        if (mSavedRefineModel == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mPresentation.a(0x7f090483, 0x7f090482, false, flag);
        a(false);
    }

    private void C()
    {
        mSavedActionBarDropShadowStrength = 1.0F;
        a(mSavedActionBarDropShadowStrength);
        mPresentation.e();
    }

    private void D()
    {
        mPresentation.d(true);
        mPresentation.c(true);
    }

    private void E()
    {
        mPresentation.c(mSavedCompositeProductsGridArray);
        mPresentation.b(mSavedCompositeProductsListArray);
        com.target.ui.fragment.product.plp.a.a a1 = mPresentation;
        int i1 = mSavedTotalRecordCount;
        Object obj;
        if (mSavedRefineModel != null)
        {
            obj = mSavedRefineModel.f();
        } else
        {
            obj = new ArrayList();
        }
        a1.a(i1, ((List) (obj)));
        mPresentation.f(false);
        mPresentation.e(false);
        G();
    }

    private void F()
    {
        boolean flag = false;
        mPresentation.j();
        mPresentation.f(false);
        Object obj = mPresentation;
        if (mSavedRefineModel != null)
        {
            flag = true;
        }
        ((com.target.ui.fragment.product.plp.a.a) (obj)).a(flag);
        com.target.ui.fragment.product.plp.a.a a1 = mPresentation;
        int i1 = mSavedTotalRecordCount;
        if (mSavedRefineModel != null)
        {
            obj = mSavedRefineModel.f();
        } else
        {
            obj = new ArrayList();
        }
        a1.a(i1, ((List) (obj)));
        mPresentation.c(mSavedCompositeProductsGridArray);
        mPresentation.d();
    }

    private void G()
    {
        boolean flag = true;
        com.target.ui.fragment.product.plp.a.a a1;
        if (mSavedShowGridView)
        {
            mPresentation.p();
            mPresentation.a(1, 0);
        } else
        {
            mPresentation.q();
            mPresentation.b(1, 0);
        }
        a1 = mPresentation;
        if (mSavedRefineModel == null)
        {
            flag = false;
        }
        a1.a(flag);
        mPresentation.c();
    }

    private void H()
    {
        boolean flag;
        if (!mSavedShowGridView)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mSavedShowGridView = flag;
        mPresentation.f();
    }

    private int I()
    {
        if (mSavedProductSummaryRequestParam.k())
        {
            return 2;
        }
        return !mSavedProductSummaryRequestParam.l() ? 3 : 1;
    }

    private void J()
    {
        mLoadingTimestamp = new h();
    }

    private void K()
    {
        if (mLoadingTimestamp == null)
        {
            return;
        } else
        {
            mLoadingTimestamp.a();
            return;
        }
    }

    private void L()
    {
        com.target.ui.analytics.a.ah.a a1 = com.target.ui.analytics.a.ah.a.ProductListPage;
        if (mSavedProductSummaryRequestParam.j())
        {
            a1 = com.target.ui.analytics.a.ah.a.SearchResults;
        }
        mPresentation.a(a1);
    }

    private long a(h h1)
    {
        return mTimeMeasurementProvider.a(h1);
    }

    private ProductRecommendationsParam a(CategoryId categoryid, String s1)
    {
        ProductRecommendationsParam productrecommendationsparam = new ProductRecommendationsParam();
        productrecommendationsparam.a(6);
        productrecommendationsparam.b(6);
        productrecommendationsparam.a(mGuest);
        productrecommendationsparam.a(s1);
        productrecommendationsparam.a(categoryid);
        return productrecommendationsparam;
    }

    private void a(float f1)
    {
        mPresentation.a(f1);
        mPresentation.b(1.0F - f1);
    }

    private void a(int i1, int j1, int k1)
    {
        if (b(i1, j1, k1))
        {
            d(mSavedCurrentPageNumber + 1);
        }
    }

    private final void a(ProductRecommendationsParam productrecommendationsparam)
    {
        mCompositeProductDataHelper.a(productrecommendationsparam, this);
    }

    private void a(ProductSummary productsummary)
    {
        mSavedIsRecommendationsShown = false;
        b(productsummary);
        c(productsummary.a());
        E();
    }

    private void a(ProductSummary productsummary, ProductSummaryParam productsummaryparam)
    {
        mPresentation.a(productsummary, productsummaryparam, a(mLoadingTimestamp));
        K();
    }

    private void a(ProductSummary productsummary, ProductSummaryParam productsummaryparam, PageItemHierarchy pageitemhierarchy)
    {
        mPresentation.a(productsummary, productsummaryparam, pageitemhierarchy, a(mLoadingTimestamp));
        K();
    }

    private void a(ProductSummary productsummary, List list)
    {
        if (mSavedIsRecommendationsShown)
        {
            a(true);
        }
        mSavedIsRecommendationsShown = false;
        mPresentation.i();
        a(mSavedDisplayOptions);
        b(productsummary);
        c(productsummary);
        a(productsummary.a(), list);
        b((String)mSavedProductSummaryRequestParam.b().d());
        E();
    }

    private void a(ProductHeaderOptions productheaderoptions)
    {
        if (productheaderoptions == null)
        {
            mPresentation.j();
            mPresentation.o();
            return;
        } else
        {
            mPresentation.b(productheaderoptions);
            mPresentation.a(productheaderoptions);
            return;
        }
    }

    private void a(List list)
    {
        com.target.ui.util.l.a(mSavedCompositeProductsGridArray, list);
    }

    private void a(List list, List list1)
    {
        com.target.ui.util.l.a(mSavedCompositeProductsListArray, list, list1, I(), false);
        com.target.ui.util.l.a(mSavedCompositeProductsGridArray, list, list1, I(), true);
    }

    private void a(boolean flag)
    {
        mSavedShowListGridToggleBtn = flag;
        mPresentation.f();
    }

    private void b(ProductRecommendations productrecommendations)
    {
        mSavedCompositeProductsListArray.clear();
        mSavedCompositeProductsGridArray.clear();
        mSavedIsRecommendationsShown = true;
        a(productrecommendations.a());
        B();
        F();
    }

    private void b(ProductSummary productsummary)
    {
        mSavedPageSize = productsummary.d();
        mSavedTotalRecordCount = productsummary.f();
        mSavedCurrentPageNumber = productsummary.h();
        mSavedAppliedRefineFacets.clear();
        mSavedAppliedCategoryRefineFacets.clear();
        mSavedAppliedRefineFacets.addAll(productsummary.b());
        mSavedAppliedCategoryRefineFacets.addAll(productsummary.c());
    }

    private void b(ProductSummaryWrapper productsummarywrapper)
    {
        if (mSavedProductSummaryRequestParam.k())
        {
            d(productsummarywrapper.a());
            return;
        }
        if (mSavedProductSummaryRequestParam.l())
        {
            a(productsummarywrapper.a(), (ProductSummaryParam)mSavedProductSummaryRequestParam.g().d(), (PageItemHierarchy)mSavedProductSummaryRequestParam.e().d());
            return;
        } else
        {
            a(productsummarywrapper.a(), (ProductSummaryParam)mSavedProductSummaryRequestParam.g().d());
            return;
        }
    }

    private void b(String s1)
    {
        if (com.target.mothership.util.o.g(s1))
        {
            mPresentation.b(s1);
            return;
        } else
        {
            mPresentation.g();
            return;
        }
    }

    private void b(String s1, RelevantStoreSummary relevantstoresummary, Location location)
    {
        mSavedDisplayOptions = new ProductHeaderOptions(s1, location, relevantstoresummary.getName());
        if (mSavedIsRecommendationsShown)
        {
            return;
        } else
        {
            a(mSavedDisplayOptions);
            return;
        }
    }

    private void b(List list)
    {
        com.target.ui.util.l.a(mSavedCompositeProductsListArray, list);
    }

    private boolean b(int i1, int j1, int k1)
    {
        boolean flag2 = true;
        boolean flag3 = false;
        boolean flag;
        boolean flag1;
        if (k1 < s())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        flag1 = flag3;
        if (j1 > 0)
        {
            flag1 = flag3;
            if (flag)
            {
                if (i1 + j1 >= k1 - t() / 2)
                {
                    i1 = 1;
                } else
                {
                    i1 = 0;
                }
                if (i1 != 0 && !q())
                {
                    flag1 = flag2;
                } else
                {
                    flag1 = false;
                }
            }
        }
        return flag1;
    }

    private void c(ProductSummary productsummary)
    {
        if (mSavedRefineModel != null || productsummary.c().isEmpty() && productsummary.b().isEmpty())
        {
            return;
        } else
        {
            mSavedRefineModel = new ProductRefineModel(productsummary.c(), productsummary.b());
            return;
        }
    }

    private void c(List list)
    {
        a(list);
        b(list);
    }

    private void d(int i1)
    {
        mPresentation.f(true);
        mPresentation.e(true);
        if (mSavedProductSummaryRequestParam.k())
        {
            return;
        }
        if (mSavedProductSummaryRequestParam.l())
        {
            ProductSummaryParam productsummaryparam = (ProductSummaryParam)mSavedProductSummaryRequestParam.g().c();
            productsummaryparam.c(Integer.valueOf(i1));
            mCompositeProductDataHelper.a(productsummaryparam, this);
        } else
        {
            ProductSummaryParam productsummaryparam1 = (ProductSummaryParam)mSavedProductSummaryRequestParam.g().c();
            productsummaryparam1.c(Integer.valueOf(i1));
            mCompositeProductDataHelper.a(productsummaryparam1, this);
        }
        J();
    }

    private void d(ProductSummary productsummary)
    {
        mPresentation.a(productsummary, a(mLoadingTimestamp));
        K();
    }

    private void d(x x1)
    {
        A();
    }

    private g e(ProductDetails productdetails)
    {
        if ((productdetails.c().e().equals(m.ShipToStore) || productdetails.c().e().equals(m.PickUpInStore)) && productdetails.u().a() && productdetails.u().d().equals(m.ShipToStore))
        {
            return g.SHIP_TO_STORE;
        } else
        {
            return g.PICK_UP_IN_STORE;
        }
    }

    private void e(x x1)
    {
        D();
    }

    private ProductRecommendations m()
    {
        return new ProductRecommendations() {

            final ProductSummaryPagePresenter this$0;

            public List a()
            {
                return Collections.emptyList();
            }

            public int describeContents()
            {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i1)
            {
            }

            
            {
                this$0 = ProductSummaryPagePresenter.this;
                super();
            }
        };
    }

    private String n()
    {
        if (mSavedProductSummaryRequestParam.i().b())
        {
            return (String)mSavedProductSummaryRequestParam.i().c();
        } else
        {
            return "";
        }
    }

    private boolean o()
    {
        return mSavedCompositeProductsListArray != null && !mSavedCompositeProductsListArray.isEmpty() && mSavedCompositeProductsGridArray != null && !mSavedCompositeProductsGridArray.isEmpty();
    }

    private boolean p()
    {
        return mSavedCompositeProductsGridArray != null && !mSavedCompositeProductsGridArray.isEmpty();
    }

    private boolean q()
    {
        return mCompositeProductDataHelper.b();
    }

    private boolean r()
    {
        return mSavedShowGridView || mSavedIsRecommendationsShown;
    }

    private int s()
    {
        return mSavedTotalRecordCount;
    }

    private int t()
    {
        return mSavedPageSize;
    }

    private void u()
    {
        if (q())
        {
            return;
        }
        if (p() && mSavedIsRecommendationsShown)
        {
            B();
            F();
            return;
        }
        if (o())
        {
            a(mSavedDisplayOptions);
            E();
            return;
        } else
        {
            a(true);
            w();
            v();
            return;
        }
    }

    private void v()
    {
        mPresentation.b();
        mSavedActionBarDropShadowStrength = 1.0F;
        a(mSavedActionBarDropShadowStrength);
        if (mSavedProductSummaryRequestParam.k())
        {
            mCompositeProductDataHelper.a(mSavedProductSummaryRequestParam.h(), com.target.ui.util.l.a(2), (Store)mSavedProductSummaryRequestParam.a().d(), this);
        } else
        if (mSavedProductSummaryRequestParam.l())
        {
            mCompositeProductDataHelper.a((ProductSummaryParam)mSavedProductSummaryRequestParam.g().c(), com.target.ui.util.l.a(1), this);
        } else
        {
            mCompositeProductDataHelper.a((ProductSummaryParam)mSavedProductSummaryRequestParam.g().c(), com.target.ui.util.l.a(3), this);
        }
        J();
    }

    private void w()
    {
        if (!mSavedIsRecommendationsShown && mRelevantStoreSummary != null && mRelevantStoreSummary.a())
        {
            String s1 = (String)mSavedProductSummaryRequestParam.i().d();
            if (com.target.mothership.util.o.g(s1))
            {
                mCompositeProductDataHelper.a(s1, mRelevantStoreSummary, this);
                return;
            }
        }
    }

    private void x()
    {
        a(false);
        Object obj;
        if (mSavedProductSummaryRequestParam.g().b())
        {
            obj = (CategoryId)((ProductSummaryParam)mSavedProductSummaryRequestParam.g().c()).c().d();
        } else
        {
            obj = null;
        }
        obj = a(((CategoryId) (obj)), (String)mSavedProductSummaryRequestParam.i().d());
        ((ProductRecommendationsParam) (obj)).a(com.target.mothership.common.params.ProductRecommendationsParam.a.SLP_RECOMMENDATIONS);
        a(((ProductRecommendationsParam) (obj)));
    }

    private void y()
    {
        C();
    }

    private void z()
    {
        D();
    }

    public void a(int i1)
    {
        while (!r() || i1 != 0) 
        {
            return;
        }
        mPresentation.a(3, 0);
    }

    public void a(int i1, int j1, int k1, int l1, int i2)
    {
        if (!r())
        {
            return;
        } else
        {
            a(i1, j1, k1);
            mPresentation.a(2, i2);
            return;
        }
    }

    void a(Parcelable parcelable)
    {
        parcelable = (SavedState)parcelable;
        mSavedShowGridView = ((SavedState) (parcelable)).showGridView;
        mSavedShowListGridToggleBtn = ((SavedState) (parcelable)).showListGridToggleBtn;
        mSavedIsRecommendationsShown = ((SavedState) (parcelable)).isRecommendationsShown;
        mSavedActionBarDropShadowStrength = ((SavedState) (parcelable)).actionBarDropShadowStrength;
        mSavedPageSize = ((SavedState) (parcelable)).pageSize;
        mSavedTotalRecordCount = ((SavedState) (parcelable)).totalRecordCount;
        mSavedCurrentPageNumber = ((SavedState) (parcelable)).currentPageNumber;
        mSavedRefineModel = ((SavedState) (parcelable)).refineModel;
        mSavedDisplayOptions = ((SavedState) (parcelable)).displayOptions;
        mSavedSelectedFacet = ((SavedState) (parcelable)).selectedFacet;
        mSavedAppliedRefineFacets = ((SavedState) (parcelable)).appliedRefineFacets;
        mSavedAppliedCategoryRefineFacets = ((SavedState) (parcelable)).appliedCategoryRefineFacets;
        mSavedCompositeProductsListArray = ((SavedState) (parcelable)).compositeProductsListArray;
        mSavedCompositeProductsGridArray = ((SavedState) (parcelable)).compositeProductsGridArray;
        mSavedProductSummaryRequestParam = ((SavedState) (parcelable)).requestParam;
    }

    public void a(Menu menu)
    {
        MenuItem menuitem = menu.findItem(0x7f100610);
        menu = menu.findItem(0x7f10060f);
        if (menuitem == null || menu == null)
        {
            return;
        }
        if (!mSavedShowListGridToggleBtn)
        {
            mPresentation.a(menuitem, false);
            mPresentation.a(menu, false);
            return;
        }
        if (mSavedShowGridView)
        {
            mPresentation.a(menuitem, false);
            mPresentation.a(menu, true);
            return;
        } else
        {
            mPresentation.a(menuitem, true);
            mPresentation.a(menu, false);
            return;
        }
    }

    public void a(Menu menu, MenuInflater menuinflater)
    {
        mPresentation.a(menu, menuinflater, 0x7f120013);
        mPresentation.a(n());
        mPresentation.h(false);
        a(mSavedActionBarDropShadowStrength);
    }

    public void a(ProductSummaryParam productsummaryparam, ArrayList arraylist)
    {
        mSavedCompositeProductsListArray.clear();
        mSavedCompositeProductsGridArray.clear();
        mSavedCurrentPageNumber = 0;
        mSavedPageSize = 0;
        mSavedTotalRecordCount = 0;
        mSavedProductSummaryRequestParam = (new ProductSummaryPagePresenterParam.a()).a(mSavedProductSummaryRequestParam).a(productsummaryparam).a();
        mSavedSelectedFacet.clear();
        mSavedSelectedFacet.addAll(arraylist);
        if (mPresentation == null)
        {
            return;
        } else
        {
            v();
            return;
        }
    }

    public void a(DvmDataResponse dvmdataresponse)
    {
        Uri uri = Uri.parse(dvmdataresponse.c());
        mCompositeProductDataHelper.a(dvmdataresponse.b());
        mPresentation.a(uri, (Store)mSavedProductSummaryRequestParam.a().d());
    }

    public void a(ProductDetails productdetails)
    {
        Store store = (Store)mSavedProductSummaryRequestParam.a().d();
        if (store == null)
        {
            return;
        } else
        {
            L();
            mPresentation.a(productdetails, store);
            return;
        }
    }

    public void a(ProductEntry productentry)
    {
        mSavedCompositeProductsListArray.clear();
        mSavedCompositeProductsGridArray.clear();
        mSavedCurrentPageNumber = 0;
        mSavedPageSize = 0;
        mSavedTotalRecordCount = 0;
        mSavedSelectedFacet.remove(productentry);
        productentry = com.target.ui.util.f.a.a((ProductSummaryParam)mSavedProductSummaryRequestParam.g().c(), mSavedRefineModel, mSavedSelectedFacet);
        mSavedProductSummaryRequestParam = (new ProductSummaryPagePresenterParam.a()).a(mSavedProductSummaryRequestParam).a(productentry).a();
        v();
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

    public void a(ProductSummaryWrapper productsummarywrapper)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            a(productsummarywrapper.a());
            b(productsummarywrapper);
            return;
        }
    }

    public void a(x x1)
    {
        com.target.ui.util.q.a(TAG, (new StringBuilder()).append("Error while getting product recommendations : ").append(x1.getMessage()).toString());
        if (mPresentation == null)
        {
            return;
        } else
        {
            b(m());
            return;
        }
    }

    public void a(com.target.ui.fragment.product.plp.a.a a1)
    {
        mPresentation = a1;
        if (mDeviceOsProvider.a())
        {
            mPresentation.a();
        }
        u();
    }

    public void a(com.target.ui.fragment.product.plp.presenter.a a1)
    {
        boolean flag;
        boolean flag2;
        boolean flag3;
        int l1;
        int j2;
        int k2;
        int k1 = a1.b();
        l1 = a1.a();
        int i1 = a1.c();
        int i2 = a1.d();
        int l2 = a1.e();
        j2 = a1.f();
        k2 = a1.g();
        boolean flag4 = a1.h();
        boolean flag1;
        int j1;
        if (l2 < i1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (l2 == i1)
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        if (i2 > 0)
        {
            j1 = 1;
        } else
        {
            j1 = 0;
        }
        if (flag || flag3 && j2 >= l1)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag || flag3 && j2 >= l1 / 2)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (flag || flag3 && j2 > 0)
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        if (flag && j1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag4)
        {
            mSavedActionBarDropShadowStrength = 1.0F;
            a(mSavedActionBarDropShadowStrength);
            return;
        }
        if (l2 == -1)
        {
            boolean flag5;
            if (k1 == 1)
            {
                flag5 = true;
            } else
            {
                flag5 = false;
            }
            mMissedLastRefineHeaderRefreshEvent = flag5;
            return;
        }
        j1 = k1;
        if (mMissedLastRefineHeaderRefreshEvent)
        {
            mMissedLastRefineHeaderRefreshEvent = false;
            j1 = 1;
        }
        a1 = mPresentation;
        float f1;
        if (flag)
        {
            f1 = i2;
        } else
        {
            f1 = 0.0F;
        }
        a1.c(f1);
        j1;
        JVM INSTR tableswitch 1 3: default 296
    //                   1 320
    //                   2 338
    //                   3 357;
           goto _L1 _L2 _L3 _L4
_L1:
        break; /* Loop/switch isn't completed */
_L4:
        break MISSING_BLOCK_LABEL_357;
_L5:
        if (flag1)
        {
            mSavedActionBarDropShadowStrength = 1.0F;
        } else
        if (flag3)
        {
            mSavedActionBarDropShadowStrength = 1.0F - Math.max(Math.min((float)(l1 - j2) / 20F, 1.0F), 0.0F);
        } else
        {
            mSavedActionBarDropShadowStrength = 0.0F;
        }
        a(mSavedActionBarDropShadowStrength);
        return;
_L2:
        if (flag3)
        {
            mPresentation.g(false);
        }
          goto _L5
_L3:
        if (!flag)
        {
            mPresentation.a(-k2);
        }
          goto _L5
        if (flag2)
        {
            mPresentation.g(true);
        } else
        {
            mPresentation.r();
        }
          goto _L5
    }

    public void a(AggregateProductSummaryData aggregateproductsummarydata)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            a(aggregateproductsummarydata.a().a(), aggregateproductsummarydata.b());
            b(aggregateproductsummarydata.a());
            return;
        }
    }

    public void a(BitmapImageView bitmapimageview, ProductDetails productdetails)
    {
        productdetails = new d(productdetails);
        productdetails.a((Store)mSavedProductSummaryRequestParam.a().d());
        productdetails.a(bitmapimageview);
        productdetails.a((PageItemHierarchy)mSavedProductSummaryRequestParam.e().d());
        mPresentation.a(productdetails);
    }

    public void a(ToolbarSpinner toolbarspinner)
    {
        mPresentation.a(toolbarspinner, mSavedProductSummaryRequestParam.f(), (PageItemHierarchy)mSavedProductSummaryRequestParam.e().c());
    }

    public volatile void a(Object obj)
    {
        a((com.target.ui.fragment.product.plp.a.a)obj);
    }

    public void a(String s1)
    {
        Store store = (Store)mSavedProductSummaryRequestParam.a().d();
        if (store == null)
        {
            return;
        } else
        {
            L();
            mPresentation.a(s1, store);
            return;
        }
    }

    public void a(String s1, RelevantStoreSummary relevantstoresummary, Location location)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            b(s1, relevantstoresummary, location);
            return;
        }
    }

    public boolean a(MenuItem menuitem)
    {
        menuitem.getItemId();
        JVM INSTR lookupswitch 3: default 40
    //                   16908332: 42
    //                   2131756559: 63
    //                   2131756560: 63;
           goto _L1 _L2 _L3 _L3
_L1:
        return false;
_L2:
        if (mSavedProductSummaryRequestParam.l())
        {
            mPresentation.h();
            return true;
        }
          goto _L1
_L3:
        H();
        u();
        return true;
    }

    public void b(int i1)
    {
        while (r() || i1 != 0) 
        {
            return;
        }
        mPresentation.b(3, 0);
    }

    public void b(int i1, int j1, int k1, int l1, int i2)
    {
        if (r())
        {
            return;
        } else
        {
            a(i1, j1, k1);
            mPresentation.b(2, i2);
            return;
        }
    }

    public void b(ProductDetails productdetails)
    {
        mPresentation.a(productdetails, b.PICK_UP, (Store)mSavedProductSummaryRequestParam.a().d(), e(productdetails));
    }

    public void b(x x1)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            com.target.ui.util.q.a(TAG, (new StringBuilder()).append("Error while getting composite product data : ").append(x1.getMessage()).toString());
            d(x1);
            return;
        }
    }

    public void c()
    {
        v();
    }

    public void c(ProductDetails productdetails)
    {
        mPresentation.a(productdetails, b.SHIP, (Store)mSavedProductSummaryRequestParam.a().d(), e(productdetails));
    }

    public void c(x x1)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            com.target.ui.util.q.a(TAG, (new StringBuilder()).append("Error while getting product summary data : ").append(x1.getMessage()).toString());
            e(x1);
            return;
        }
    }

    public boolean c(int i1)
    {
        if (mPresentation == null)
        {
            return false;
        }
        PageItem pageitem = (PageItem)mSavedProductSummaryRequestParam.f().get(i1);
        if (com.target.ui.util.y.a(((PageItemHierarchy)mSavedProductSummaryRequestParam.e().c()).a(), pageitem))
        {
            return false;
        } else
        {
            mPresentation.a(pageitem, mSavedProductSummaryRequestParam.f(), (PageItemHierarchy)mSavedProductSummaryRequestParam.e().c(), (Store)mSavedProductSummaryRequestParam.a().d());
            return true;
        }
    }

    public void d()
    {
        mPresentation.d(false);
        mPresentation.c(false);
        d(mSavedCurrentPageNumber + 1);
        J();
    }

    public void d(ProductDetails productdetails)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.a(productdetails, (PageItemHierarchy)mSavedProductSummaryRequestParam.e().d());
            return;
        }
    }

    public boolean e()
    {
        return mSavedProductSummaryRequestParam.m();
    }

    public void f()
    {
        ProductSummaryParam productsummaryparam = (ProductSummaryParam)mSavedProductSummaryRequestParam.g().d();
        if (productsummaryparam == null)
        {
            return;
        } else
        {
            mSavedRefineModel.c(mSavedSelectedFacet);
            mSavedRefineModel.a(mSavedAppliedRefineFacets);
            mSavedRefineModel.b(mSavedAppliedCategoryRefineFacets);
            mPresentation.a(mSavedRefineModel, productsummaryparam);
            return;
        }
    }

    public Parcelable g()
    {
        SavedState savedstate = new SavedState();
        savedstate.showGridView = mSavedShowGridView;
        savedstate.showListGridToggleBtn = mSavedShowListGridToggleBtn;
        savedstate.isRecommendationsShown = mSavedIsRecommendationsShown;
        savedstate.actionBarDropShadowStrength = mSavedActionBarDropShadowStrength;
        savedstate.pageSize = mSavedPageSize;
        savedstate.totalRecordCount = mSavedTotalRecordCount;
        savedstate.currentPageNumber = mSavedCurrentPageNumber;
        savedstate.refineModel = mSavedRefineModel;
        savedstate.displayOptions = mSavedDisplayOptions;
        savedstate.selectedFacet = mSavedSelectedFacet;
        savedstate.appliedRefineFacets = mSavedAppliedRefineFacets;
        savedstate.appliedCategoryRefineFacets = mSavedAppliedCategoryRefineFacets;
        savedstate.compositeProductsListArray = mSavedCompositeProductsListArray;
        savedstate.compositeProductsGridArray = mSavedCompositeProductsGridArray;
        savedstate.requestParam = mSavedProductSummaryRequestParam;
        return savedstate;
    }

    public void h()
    {
        com.target.ui.util.q.a(TAG, "Unable to get the PI location");
    }

    public void i()
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            com.target.ui.util.q.a(TAG, "No data connectivity while getting recommendations");
            y();
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
            com.target.ui.util.q.a(TAG, "No data connectivity while getting composite product data");
            y();
            return;
        }
    }

    public void k()
    {
        com.target.ui.util.q.a(TAG, "No data error occurred while getting composite product data");
        x();
    }

    public void l()
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            com.target.ui.util.q.a(TAG, "No data connectivity while getting product summary data");
            z();
            return;
        }
    }

    public void v_()
    {
        mGuest = null;
        mDeviceOsProvider = null;
        mTimeMeasurementProvider = null;
        mRelevantStoreSummary = null;
        mCompositeProductDataHelper = null;
    }

    public void z_()
    {
        mCompositeProductDataHelper.a();
        mPresentation = null;
    }

}
