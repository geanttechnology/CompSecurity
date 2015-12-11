// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.plp.presenter;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.a.a.e;
import com.target.mothership.common.params.ProductSummaryParam;
import com.target.mothership.common.product.ProductIdentifier;
import com.target.mothership.model.page_item.interfaces.PageItem;
import com.target.mothership.model.store.interfaces.Store;
import com.target.ui.fragment.product.common.PageItemHierarchy;
import com.target.ui.util.v;
import java.util.ArrayList;
import java.util.List;

public class ProductSummaryPagePresenterParam
    implements Parcelable
{
    public static class a
    {

        String dvmBannerUrl;
        private List filteredSiblingPageItemList;
        private PageItemHierarchy pageItemHierarchy;
        String pageTitle;
        private List productIdentifiers;
        private ProductSummaryParam productSummaryParam;
        boolean showGridView;
        Store store;

        static ProductSummaryParam a(a a1)
        {
            return a1.productSummaryParam;
        }

        static List b(a a1)
        {
            return a1.productIdentifiers;
        }

        static PageItemHierarchy c(a a1)
        {
            return a1.pageItemHierarchy;
        }

        static List d(a a1)
        {
            return a1.filteredSiblingPageItemList;
        }

        public a a(ProductSummaryParam productsummaryparam)
        {
            productSummaryParam = productsummaryparam;
            return this;
        }

        public a a(Store store1)
        {
            store = store1;
            return this;
        }

        public a a(PageItemHierarchy pageitemhierarchy)
        {
            pageItemHierarchy = pageitemhierarchy;
            return this;
        }

        public a a(ProductSummaryPagePresenterParam productsummarypagepresenterparam)
        {
            a((Store)productsummarypagepresenterparam.a().d());
            a((String)productsummarypagepresenterparam.b().d());
            b((String)productsummarypagepresenterparam.c().d());
            a(productsummarypagepresenterparam.d());
            a((PageItemHierarchy)productsummarypagepresenterparam.e().d());
            a(productsummarypagepresenterparam.f());
            a((ProductSummaryParam)productsummarypagepresenterparam.g().d());
            b(productsummarypagepresenterparam.h());
            return this;
        }

        public a a(String s)
        {
            dvmBannerUrl = s;
            return this;
        }

        public a a(List list)
        {
            filteredSiblingPageItemList = list;
            return this;
        }

        public a a(boolean flag)
        {
            showGridView = flag;
            return this;
        }

        public ProductSummaryPagePresenterParam a()
        {
            if (productSummaryParam == null && productIdentifiers == null)
            {
                throw new IllegalArgumentException("We have to set either setProductSummaryParam() orsetFilteredSiblingPages() to get the product summary");
            } else
            {
                return new ProductSummaryPagePresenterParam(this);
            }
        }

        public a b(String s)
        {
            pageTitle = s;
            return this;
        }

        public a b(List list)
        {
            productIdentifiers = list;
            return this;
        }

        public a()
        {
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ProductSummaryPagePresenterParam a(Parcel parcel)
        {
            return new ProductSummaryPagePresenterParam(parcel);
        }

        public ProductSummaryPagePresenterParam[] a(int i1)
        {
            return new ProductSummaryPagePresenterParam[i1];
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
    private String mDvmBannerUrl;
    private List mFilteredSiblingPageItemList;
    private PageItemHierarchy mPageItemHierarchy;
    private String mPageTitle;
    private List mProductIdentifiers;
    private ProductSummaryParam mProductSummaryParam;
    private boolean mShowGridView;
    private Store mStore;

    protected ProductSummaryPagePresenterParam(Parcel parcel)
    {
        mStore = (Store)parcel.readParcelable(com/target/mothership/model/store/interfaces/Store.getClassLoader());
        mPageTitle = parcel.readString();
        mDvmBannerUrl = parcel.readString();
        boolean flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mShowGridView = flag;
        mProductSummaryParam = (ProductSummaryParam)parcel.readParcelable(com/target/mothership/common/params/ProductSummaryParam.getClassLoader());
        if (mProductIdentifiers == null)
        {
            mProductIdentifiers = new ArrayList();
        }
        parcel.readList(mProductIdentifiers, com/target/mothership/common/product/ProductIdentifier.getClassLoader());
        mPageItemHierarchy = (PageItemHierarchy)parcel.readParcelable(com/target/ui/fragment/product/common/PageItemHierarchy.getClassLoader());
        if (mFilteredSiblingPageItemList == null)
        {
            mFilteredSiblingPageItemList = new ArrayList();
        }
        parcel.readList(mFilteredSiblingPageItemList, com/target/mothership/model/page_item/interfaces/PageItem.getClassLoader());
    }

    private ProductSummaryPagePresenterParam(a a1)
    {
        mStore = a1.store;
        mPageTitle = a1.pageTitle;
        mDvmBannerUrl = a1.dvmBannerUrl;
        mShowGridView = a1.showGridView;
        mProductSummaryParam = a.a(a1);
        mProductIdentifiers = a.b(a1);
        mPageItemHierarchy = a.c(a1);
        mFilteredSiblingPageItemList = a.d(a1);
    }


    public e a()
    {
        return com.google.a.a.e.c(mStore);
    }

    public e b()
    {
        return com.google.a.a.e.c(mDvmBannerUrl);
    }

    public e c()
    {
        return com.google.a.a.e.c(mPageTitle);
    }

    public boolean d()
    {
        return mShowGridView;
    }

    public int describeContents()
    {
        return 0;
    }

    public e e()
    {
        return com.google.a.a.e.c(mPageItemHierarchy);
    }

    public List f()
    {
        return v.a(mFilteredSiblingPageItemList);
    }

    public e g()
    {
        return com.google.a.a.e.c(mProductSummaryParam);
    }

    public List h()
    {
        return v.a(mProductIdentifiers);
    }

    public e i()
    {
        String s = null;
        if (!l()) goto _L2; else goto _L1
_L1:
        s = (String)mPageItemHierarchy.a().g().d();
_L4:
        return com.google.a.a.e.c(s);
_L2:
        if (j())
        {
            s = (String)mProductSummaryParam.e().d();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public boolean j()
    {
        return mProductSummaryParam != null;
    }

    public boolean k()
    {
        return mProductIdentifiers != null && !j();
    }

    public boolean l()
    {
        return j() && m();
    }

    public boolean m()
    {
        return mPageItemHierarchy != null && mFilteredSiblingPageItemList != null;
    }

    public void writeToParcel(Parcel parcel, int i1)
    {
        parcel.writeParcelable(mStore, 0);
        parcel.writeString(mPageTitle);
        parcel.writeString(mDvmBannerUrl);
        byte byte0;
        if (mShowGridView)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        parcel.writeParcelable(mProductSummaryParam, 0);
        parcel.writeList(mProductIdentifiers);
        parcel.writeParcelable(mPageItemHierarchy, 0);
        parcel.writeList(mFilteredSiblingPageItemList);
    }

}
