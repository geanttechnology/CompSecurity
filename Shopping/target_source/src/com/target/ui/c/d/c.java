// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.c.d;

import com.google.a.a.e;
import com.target.mothership.common.product.ProductIdentifier;
import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.mothership.model.product.interfaces.ProductImage;
import com.target.mothership.model.registries.interfaces.RegistryDetails;
import com.target.mothership.model.registries.interfaces.RegistryProductDetails;
import com.target.mothership.model.store.interfaces.Store;
import com.target.ui.fragment.product.common.PageItemHierarchy;
import com.target.ui.service.provider.l;
import com.target.ui.util.j;
import com.target.ui.view.BitmapImageView;
import java.net.URL;

// Referenced classes of package com.target.ui.c.d:
//            b, d

public class c
{

    private l mDeviceOsProvider;
    private b mNavigateToProductPresentation;

    public c(b b1, l l1)
    {
        mNavigateToProductPresentation = b1;
        mDeviceOsProvider = l1;
    }

    private String a(ProductDetails productdetails)
    {
label0:
        {
            String s = null;
            if (productdetails.r().b())
            {
                if (!((ProductImage)productdetails.r().c()).b().b())
                {
                    break label0;
                }
                s = ((URL)((ProductImage)productdetails.r().c()).b().c()).toString();
            }
            return s;
        }
        return ((ProductImage)productdetails.r().c()).a().toString();
    }

    private final void a(ProductIdentifier productidentifier, Store store)
    {
        mNavigateToProductPresentation.a(productidentifier, store);
    }

    private void a(ProductIdentifier productidentifier, String s, BitmapImageView bitmapimageview, Store store)
    {
        if (mDeviceOsProvider.a())
        {
            b(productidentifier, s, bitmapimageview, store);
            return;
        } else
        {
            a(productidentifier, store);
            return;
        }
    }

    private final void a(ProductDetails productdetails, Store store, PageItemHierarchy pageitemhierarchy)
    {
        if (productdetails.I())
        {
            mNavigateToProductPresentation.b(productdetails, store, pageitemhierarchy);
            return;
        } else
        {
            mNavigateToProductPresentation.a(productdetails, store, pageitemhierarchy);
            return;
        }
    }

    private void a(ProductDetails productdetails, BitmapImageView bitmapimageview, Store store, PageItemHierarchy pageitemhierarchy)
    {
        if (productdetails == null)
        {
            return;
        }
        if (mDeviceOsProvider.a())
        {
            b(productdetails, bitmapimageview, store, pageitemhierarchy);
            return;
        } else
        {
            a(productdetails, store, pageitemhierarchy);
            return;
        }
    }

    private final void a(RegistryProductDetails registryproductdetails, RegistryDetails registrydetails, Store store, PageItemHierarchy pageitemhierarchy)
    {
        if (registryproductdetails.I())
        {
            mNavigateToProductPresentation.b(registryproductdetails, store, pageitemhierarchy);
            return;
        } else
        {
            mNavigateToProductPresentation.a(registryproductdetails, registrydetails, store);
            return;
        }
    }

    private void a(RegistryProductDetails registryproductdetails, RegistryDetails registrydetails, BitmapImageView bitmapimageview, Store store, PageItemHierarchy pageitemhierarchy)
    {
        if (registryproductdetails == null || registrydetails == null)
        {
            return;
        }
        if (j.b())
        {
            b(registryproductdetails, registrydetails, bitmapimageview, store, pageitemhierarchy);
            return;
        } else
        {
            a(registryproductdetails, registrydetails, store, pageitemhierarchy);
            return;
        }
    }

    private final void b(ProductIdentifier productidentifier, String s, BitmapImageView bitmapimageview, Store store)
    {
        mNavigateToProductPresentation.a(productidentifier, s, bitmapimageview, store);
    }

    private final void b(ProductDetails productdetails, BitmapImageView bitmapimageview, Store store, PageItemHierarchy pageitemhierarchy)
    {
        String s = a(productdetails);
        if (productdetails.I())
        {
            mNavigateToProductPresentation.b(productdetails, s, bitmapimageview, store, pageitemhierarchy);
            return;
        } else
        {
            mNavigateToProductPresentation.a(productdetails, s, bitmapimageview, store, pageitemhierarchy);
            return;
        }
    }

    private final void b(RegistryProductDetails registryproductdetails, RegistryDetails registrydetails, BitmapImageView bitmapimageview, Store store, PageItemHierarchy pageitemhierarchy)
    {
        String s = a(registryproductdetails);
        if (registryproductdetails.I())
        {
            mNavigateToProductPresentation.b(registryproductdetails, s, bitmapimageview, store, pageitemhierarchy);
            return;
        } else
        {
            mNavigateToProductPresentation.a(registryproductdetails, registrydetails, s, bitmapimageview, store);
            return;
        }
    }

    public void a(d d1)
    {
        switch (d1.i())
        {
        default:
            return;

        case 1: // '\001'
            a((RegistryProductDetails)d1.c().d(), (RegistryDetails)d1.d().d(), (BitmapImageView)d1.f().d(), (Store)d1.e().d(), (PageItemHierarchy)d1.h().d());
            return;

        case 2: // '\002'
            a((ProductDetails)d1.b().d(), (BitmapImageView)d1.f().d(), (Store)d1.e().d(), (PageItemHierarchy)d1.h().d());
            return;

        case 3: // '\003'
            a((ProductIdentifier)d1.a().d(), (String)d1.g().d(), (BitmapImageView)d1.f().d(), (Store)d1.e().d());
            break;
        }
    }
}
