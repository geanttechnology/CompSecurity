// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.c.d;

import com.target.mothership.common.product.ProductIdentifier;
import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.mothership.model.registries.interfaces.RegistryDetails;
import com.target.mothership.model.registries.interfaces.RegistryProductDetails;
import com.target.mothership.model.store.interfaces.Store;
import com.target.ui.f.b;
import com.target.ui.f.c;
import com.target.ui.fragment.common.BaseNavigationFragment;
import com.target.ui.fragment.product.clp.CollectionsListPageFragment;
import com.target.ui.fragment.product.common.PageItemHierarchy;
import com.target.ui.fragment.product.pdp.ProductDetailsPageFragment;
import com.target.ui.service.provider.e;
import com.target.ui.view.BitmapImageView;

// Referenced classes of package com.target.ui.c.d:
//            b, c, d

public class a extends com.target.ui.c.a
    implements com.target.ui.c.d.b
{

    private com.target.ui.c.d.c mProductNavigationPresenter;

    public a(BaseNavigationFragment basenavigationfragment)
    {
        super(basenavigationfragment);
    }

    private void a(BaseNavigationFragment basenavigationfragment, BaseNavigationFragment basenavigationfragment1, String s, String s1, BitmapImageView bitmapimageview)
    {
        basenavigationfragment = new com.target.ui.f.a(a(), basenavigationfragment, bitmapimageview, s1);
        basenavigationfragment.a(s);
        (new b(d())).a(basenavigationfragment1, basenavigationfragment);
    }

    public void a(ProductIdentifier productidentifier, Store store)
    {
        d().d(ProductDetailsPageFragment.a(productidentifier, store));
    }

    public void a(ProductIdentifier productidentifier, String s, BitmapImageView bitmapimageview, Store store)
    {
        productidentifier = ProductDetailsPageFragment.a(productidentifier, store);
        store = productidentifier.a();
        a(b(), ((BaseNavigationFragment) (productidentifier)), s, ((String) (store)), bitmapimageview);
    }

    public void a(ProductDetails productdetails, Store store, PageItemHierarchy pageitemhierarchy)
    {
        d().d(ProductDetailsPageFragment.a(productdetails, pageitemhierarchy, store));
    }

    public void a(ProductDetails productdetails, String s, BitmapImageView bitmapimageview, Store store, PageItemHierarchy pageitemhierarchy)
    {
        productdetails = ProductDetailsPageFragment.a(productdetails, pageitemhierarchy, store);
        store = productdetails.a();
        a(b(), ((BaseNavigationFragment) (productdetails)), s, ((String) (store)), bitmapimageview);
    }

    public void a(RegistryProductDetails registryproductdetails, RegistryDetails registrydetails, Store store)
    {
        d().d(ProductDetailsPageFragment.a(registryproductdetails, registrydetails, store));
    }

    public void a(RegistryProductDetails registryproductdetails, RegistryDetails registrydetails, String s, BitmapImageView bitmapimageview, Store store)
    {
        registryproductdetails = ProductDetailsPageFragment.a(registryproductdetails, registrydetails, store);
        registrydetails = registryproductdetails.a();
        a(b(), ((BaseNavigationFragment) (registryproductdetails)), s, ((String) (registrydetails)), bitmapimageview);
    }

    public void a(d d)
    {
        if (mProductNavigationPresenter == null)
        {
            throw new IllegalArgumentException("Should call onCreateView() first");
        } else
        {
            mProductNavigationPresenter.a(d);
            return;
        }
    }

    public void b(ProductDetails productdetails, Store store, PageItemHierarchy pageitemhierarchy)
    {
        d().d(CollectionsListPageFragment.a(productdetails, pageitemhierarchy, store));
    }

    public void b(ProductDetails productdetails, String s, BitmapImageView bitmapimageview, Store store, PageItemHierarchy pageitemhierarchy)
    {
        productdetails = CollectionsListPageFragment.a(productdetails, pageitemhierarchy, store);
        store = productdetails.a();
        a(b(), productdetails, s, store, bitmapimageview);
    }

    public void f()
    {
        super.f();
        mProductNavigationPresenter = new com.target.ui.c.d.c(this, new e());
    }

    public void h()
    {
        super.h();
        mProductNavigationPresenter = null;
    }
}
