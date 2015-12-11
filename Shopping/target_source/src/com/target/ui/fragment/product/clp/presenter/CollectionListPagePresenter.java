// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.clp.presenter;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.google.a.a.e;
import com.target.mothership.common.product.ProductIdentifier;
import com.target.mothership.common.product.m;
import com.target.mothership.model.product.interfaces.Product;
import com.target.mothership.model.product.interfaces.ProductCollection;
import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.mothership.model.product.interfaces.ProductDetailsWrapper;
import com.target.mothership.model.product.interfaces.ProductImage;
import com.target.mothership.model.product.interfaces.ProductOnlineInfo;
import com.target.mothership.model.product.interfaces.ProductPromotion;
import com.target.mothership.model.product.interfaces.ProductStoreInfo;
import com.target.mothership.model.store.interfaces.Store;
import com.target.mothership.services.x;
import com.target.ui.common.ProductFulfillmentOptions;
import com.target.ui.common.d;
import com.target.ui.common.h;
import com.target.ui.g.a;
import com.target.ui.helper.product.b;
import com.target.ui.helper.product.g;
import com.target.ui.service.provider.l;
import com.target.ui.view.BitmapImageView;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.ui.fragment.product.clp.presenter:
//            a

public class CollectionListPagePresenter
    implements com.target.ui.g.a
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
        Parcelable customParcelableData;
        ProductDetails productDetails;

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i1)
        {
            parcel.writeParcelable(productDetails, 0);
            parcel.writeParcelable(customParcelableData, 0);
        }


        public SavedState()
        {
        }

        protected SavedState(Parcel parcel)
        {
            productDetails = (ProductDetails)parcel.readParcelable(com/target/mothership/model/product/interfaces/ProductDetails.getClassLoader());
            customParcelableData = parcel.readParcelable(android/os/Parcelable.getClassLoader());
        }
    }

    private class a
        implements com.target.ui.helper.product.g.c
    {

        final CollectionListPagePresenter this$0;

        public void a(ProductDetailsWrapper productdetailswrapper)
        {
            if (com.target.ui.fragment.product.clp.presenter.CollectionListPagePresenter.a(CollectionListPagePresenter.this) == null || productdetailswrapper == null || productdetailswrapper.b().isEmpty())
            {
                return;
            } else
            {
                com.target.ui.fragment.product.clp.presenter.CollectionListPagePresenter.a(CollectionListPagePresenter.this, productdetailswrapper);
                return;
            }
        }

        public void a(x x)
        {
            if (com.target.ui.fragment.product.clp.presenter.CollectionListPagePresenter.a(CollectionListPagePresenter.this) == null)
            {
                return;
            } else
            {
                com.target.ui.fragment.product.clp.presenter.CollectionListPagePresenter.a(CollectionListPagePresenter.this, x);
                return;
            }
        }

        public void t_()
        {
            if (com.target.ui.fragment.product.clp.presenter.CollectionListPagePresenter.a(CollectionListPagePresenter.this) == null)
            {
                return;
            } else
            {
                com.target.ui.fragment.product.clp.presenter.CollectionListPagePresenter.b(CollectionListPagePresenter.this);
                return;
            }
        }

        private a()
        {
            this$0 = CollectionListPagePresenter.this;
            super();
        }

    }


    private static final int PRODUCT_DETAIL_DEFAULT_INDEX = 0;
    private static final String TAG = com/target/ui/fragment/product/clp/presenter/CollectionListPagePresenter.getSimpleName();
    private com.target.ui.fragment.product.clp.presenter.a mCollectionListRequestParam;
    private l mDeviceOsProvider;
    private com.target.ui.fragment.product.clp.a.a mPresentation;
    private g mProductDataHelper;
    private Parcelable mSavedCustomParcelableData;
    private ProductDetails mSavedProductDetails;
    private boolean mShowShareAs;

    public CollectionListPagePresenter(g g1, l l1, com.target.ui.fragment.product.clp.presenter.a a1, Parcelable parcelable)
    {
        mShowShareAs = false;
        mProductDataHelper = g1;
        mDeviceOsProvider = l1;
        mCollectionListRequestParam = a1;
        if (parcelable != null)
        {
            b(parcelable);
        }
    }

    private ProductDetails a(ProductDetailsWrapper productdetailswrapper)
    {
        return (ProductDetails)productdetailswrapper.b().get(0);
    }

    static com.target.ui.fragment.product.clp.a.a a(CollectionListPagePresenter collectionlistpagepresenter)
    {
        return collectionlistpagepresenter.mPresentation;
    }

    private List a(List list)
    {
        ArrayList arraylist = new ArrayList();
        for (list = list.iterator(); list.hasNext(); arraylist.add((ProductCollection)list.next())) { }
        return arraylist;
    }

    private void a(ProductIdentifier productidentifier, Store store)
    {
        mProductDataHelper.a(productidentifier, store, new a());
    }

    private void a(Product product, Store store)
    {
        mProductDataHelper.a(product, store, new a());
    }

    private void a(x x)
    {
        if (mDeviceOsProvider.a())
        {
            mPresentation.a(0x7f090429);
            return;
        } else
        {
            mPresentation.a(0x7f09042a, 0x7f090429, true);
            return;
        }
    }

    static void a(CollectionListPagePresenter collectionlistpagepresenter, ProductDetailsWrapper productdetailswrapper)
    {
        collectionlistpagepresenter.b(productdetailswrapper);
    }

    static void a(CollectionListPagePresenter collectionlistpagepresenter, x x)
    {
        collectionlistpagepresenter.a(x);
    }

    private void a(boolean flag)
    {
        Object obj = new ProductFulfillmentOptions();
        ((ProductFulfillmentOptions) (obj)).o(true);
        ((ProductFulfillmentOptions) (obj)).h(true);
        ((ProductFulfillmentOptions) (obj)).e(0x7f0900d4);
        obj = new d(new h(mSavedProductDetails.g()), ((ProductFulfillmentOptions) (obj)), new com.target.ui.common.g(mSavedProductDetails), (ProductImage)mSavedProductDetails.r().d());
        mPresentation.a(((d) (obj)), flag);
        mPresentation.i();
        mPresentation.a(a(mSavedProductDetails.F()), flag);
        mPresentation.h();
        l();
    }

    private com.target.mothership.common.a.g b(ProductDetails productdetails)
    {
        m m1 = productdetails.c().e();
        if ((m1.equals(m.ShipToStore) || m1.equals(m.PickUpInStore)) && productdetails.u().a() && productdetails.u().d().equals(m.ShipToStore))
        {
            return com.target.mothership.common.a.g.SHIP_TO_STORE;
        } else
        {
            return com.target.mothership.common.a.g.PICK_UP_IN_STORE;
        }
    }

    private void b(Parcelable parcelable)
    {
        parcelable = (SavedState)parcelable;
        mSavedCustomParcelableData = ((SavedState) (parcelable)).customParcelableData;
        mSavedProductDetails = ((SavedState) (parcelable)).productDetails;
    }

    private void b(ProductDetailsWrapper productdetailswrapper)
    {
        mSavedProductDetails = a(productdetailswrapper);
        a(true);
    }

    static void b(CollectionListPagePresenter collectionlistpagepresenter)
    {
        collectionlistpagepresenter.n();
    }

    private void f()
    {
        mPresentation.a(mSavedCustomParcelableData);
        mSavedCustomParcelableData = null;
    }

    private void g()
    {
        mPresentation.a((Bitmap)mCollectionListRequestParam.d().c(), (String)mCollectionListRequestParam.f().c(), (String)mCollectionListRequestParam.e().d());
    }

    private void h()
    {
        if (mSavedProductDetails == null || !mSavedProductDetails.q().b())
        {
            return;
        } else
        {
            URL url = (URL)mSavedProductDetails.q().c();
            mPresentation.a(0x7f0901b6, 0x7f0904fb, url);
            return;
        }
    }

    private boolean i()
    {
        return mSavedCustomParcelableData != null;
    }

    private boolean j()
    {
        return mSavedProductDetails != null;
    }

    private boolean k()
    {
        return mCollectionListRequestParam.d().b() && mCollectionListRequestParam.f().b();
    }

    private void l()
    {
        boolean flag;
        if (mSavedProductDetails != null && mSavedProductDetails.q().b())
        {
            flag = true;
        } else
        {
            flag = false;
        }
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

    private void m()
    {
        if (mDeviceOsProvider.a())
        {
            mPresentation.e();
        } else
        {
            mPresentation.d();
        }
        if (mCollectionListRequestParam.b().b())
        {
            a((Product)mCollectionListRequestParam.b().c(), (Store)mCollectionListRequestParam.a().d());
        } else
        if (mCollectionListRequestParam.c().b())
        {
            a((ProductIdentifier)mCollectionListRequestParam.c().c(), (Store)mCollectionListRequestParam.a().d());
            return;
        }
    }

    private void n()
    {
        if (mDeviceOsProvider.a())
        {
            mPresentation.g();
            return;
        } else
        {
            mPresentation.f();
            return;
        }
    }

    public void a(Parcelable parcelable)
    {
        mSavedCustomParcelableData = parcelable;
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

    public void a(ProductDetails productdetails)
    {
        if (!mCollectionListRequestParam.a().b())
        {
            return;
        } else
        {
            mPresentation.a(productdetails, (Store)mCollectionListRequestParam.a().c());
            return;
        }
    }

    public void a(ProductDetails productdetails, b b1)
    {
        mPresentation.a(productdetails, b1, (Store)mCollectionListRequestParam.a().d(), b(productdetails));
    }

    public void a(ProductDetails productdetails, BitmapImageView bitmapimageview)
    {
        productdetails = new com.target.ui.c.d.d(productdetails);
        productdetails.a(bitmapimageview);
        productdetails.a((Store)mCollectionListRequestParam.a().d());
        mPresentation.a(productdetails);
    }

    public void a(ProductPromotion productpromotion)
    {
        mPresentation.a(productpromotion);
    }

    public void a(com.target.ui.fragment.product.clp.a.a a1)
    {
        mPresentation = a1;
        if (i())
        {
            f();
        }
        if (j())
        {
            a(false);
            return;
        }
        if (mDeviceOsProvider.a())
        {
            mPresentation.b();
            if (k())
            {
                g();
            }
        }
        m();
    }

    public volatile void a(Object obj)
    {
        a((com.target.ui.fragment.product.clp.a.a)obj);
    }

    public boolean a(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return false;

        case 2131756555: 
            h();
            break;
        }
        return true;
    }

    public void c()
    {
        m();
    }

    public void d()
    {
        mPresentation.a(mSavedProductDetails);
    }

    public Parcelable e()
    {
        SavedState savedstate = new SavedState();
        savedstate.customParcelableData = mSavedCustomParcelableData;
        savedstate.productDetails = mSavedProductDetails;
        return savedstate;
    }

    public void v_()
    {
        mProductDataHelper = null;
        mDeviceOsProvider = null;
    }

    public void z_()
    {
        mPresentation.c();
        mProductDataHelper.a();
        mPresentation = null;
    }

}
