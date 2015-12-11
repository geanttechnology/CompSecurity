// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.product;

import com.google.a.a.e;
import com.target.mothership.common.params.ProductRecommendationsParam;
import com.target.mothership.common.params.ProductSummaryParam;
import com.target.mothership.common.product.Dpci;
import com.target.mothership.common.product.ProductIdentifier;
import com.target.mothership.common.product.Tcin;
import com.target.mothership.common.product.o;
import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.model.product.a.c;
import com.target.mothership.model.product.handler.d;
import com.target.mothership.model.product.handler.h;
import com.target.mothership.model.product.handler.i;
import com.target.mothership.model.product.handler.l;
import com.target.mothership.model.product.interfaces.Product;
import com.target.mothership.model.store.interfaces.Store;
import com.target.mothership.services.e.e.c.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.mothership.model.product:
//            a

class b
    implements com.target.mothership.model.product.a
{

    private com.target.mothership.common.product.ProductIdentifier.a SUPPORTED_PRODUCT_TYPES[];
    private com.target.mothership.services.apigee.a.c.a mAvailableToPromiseV2Services;
    private com.target.mothership.common.product.ProductIdentifier.a mDefaultProductType;
    private com.target.mothership.services.apigee.productsV3.b.a mProductV3Service;
    private a mService;

    public b()
    {
        SUPPORTED_PRODUCT_TYPES = (new com.target.mothership.common.product.ProductIdentifier.a[] {
            com.target.mothership.common.product.ProductIdentifier.a.TCIN, com.target.mothership.common.product.ProductIdentifier.a.DPCI, com.target.mothership.common.product.ProductIdentifier.a.BARCODE
        });
        mDefaultProductType = SUPPORTED_PRODUCT_TYPES[0];
        mService = new a();
        mProductV3Service = new com.target.mothership.services.apigee.productsV3.b.a();
        mAvailableToPromiseV2Services = new com.target.mothership.services.apigee.a.c.a();
    }

    private com.target.mothership.services.e.e.a.a a(List list, Store store, boolean flag)
    {
        if (list == null || list.size() == 0)
        {
            return null;
        }
        ArrayList arraylist = new ArrayList();
        Iterator iterator = list.iterator();
        do
        {
            if (iterator.hasNext())
            {
                Product product = (Product)iterator.next();
                static class _cls1
                {

                    static final int $SwitchMap$com$target$mothership$common$product$ProductIdentifier$ProductIdType[];

                    static 
                    {
                        $SwitchMap$com$target$mothership$common$product$ProductIdentifier$ProductIdType = new int[com.target.mothership.common.product.ProductIdentifier.a.values().length];
                        try
                        {
                            $SwitchMap$com$target$mothership$common$product$ProductIdentifier$ProductIdType[com.target.mothership.common.product.ProductIdentifier.a.DPCI.ordinal()] = 1;
                        }
                        catch (NoSuchFieldError nosuchfielderror1) { }
                        try
                        {
                            $SwitchMap$com$target$mothership$common$product$ProductIdentifier$ProductIdType[com.target.mothership.common.product.ProductIdentifier.a.TCIN.ordinal()] = 2;
                        }
                        catch (NoSuchFieldError nosuchfielderror)
                        {
                            return;
                        }
                    }
                }

                switch (_cls1..SwitchMap.com.target.mothership.common.product.ProductIdentifier.ProductIdType[mDefaultProductType.ordinal()])
                {
                default:
                    if (product.h().b() && ((Tcin)product.h().c()).b() != null)
                    {
                        arraylist.add(((Tcin)product.h().c()).b());
                    } else
                    {
                        arraylist.add(product.k_().b());
                    }
                    break;

                case 1: // '\001'
                    arraylist.add(((Dpci)product.e().c()).b());
                    break;
                }
            } else
            {
                if (mDefaultProductType == com.target.mothership.common.product.ProductIdentifier.a.TCIN)
                {
                    list = ((Product)list.get(0)).k_();
                } else
                {
                    list = (ProductIdentifier)((Product)list.get(0)).e().c();
                }
                return new com.target.mothership.services.e.e.a.a(list, arraylist, a(store), flag);
            }
        } while (true);
    }

    private String a(Store store)
    {
        String s = null;
        if (store != null)
        {
            s = store.getStoreId().a();
        }
        return s;
    }

    public void a(ProductRecommendationsParam productrecommendationsparam, com.target.mothership.model.h h1)
    {
        h1 = new com.target.mothership.model.e(new h(h1));
        mService.a(productrecommendationsparam, h1);
    }

    public void a(ProductSummaryParam productsummaryparam, com.target.mothership.model.h h1)
    {
        com.target.mothership.model.e e1 = new com.target.mothership.model.e(new l(h1));
        com.target.mothership.model.product.a.b b1 = new com.target.mothership.model.product.a.b(productsummaryparam);
        if (b1.b())
        {
            h1.a(b1.a().a());
            return;
        } else
        {
            mService.a(productsummaryparam, e1);
            return;
        }
    }

    public void a(Dpci dpci, int j, String s, int k, com.target.mothership.model.h h1)
    {
        h1 = new com.target.mothership.model.e(new i(h1));
        mAvailableToPromiseV2Services.a(dpci, j, s, k, h1);
    }

    public void a(Dpci dpci, int j, List list, com.target.mothership.model.h h1)
    {
        h1 = new com.target.mothership.model.e(new i(h1));
        mAvailableToPromiseV2Services.a(dpci, j, list, h1);
    }

    public void a(Dpci dpci, String s, o o, com.target.mothership.model.h h1)
    {
        h1 = new com.target.mothership.model.e(new com.target.mothership.model.product.handler.b(h1));
        mProductV3Service.a(dpci, s, o, h1);
    }

    public void a(Dpci dpci, List list, o o, com.target.mothership.model.h h1)
    {
        h1 = new com.target.mothership.model.e(new com.target.mothership.model.product.handler.b(h1));
        mProductV3Service.a(dpci, list, o, h1);
    }

    public void a(Store store, ProductIdentifier productidentifier, boolean flag, com.target.mothership.model.h h1)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(productidentifier);
        b(store, arraylist, flag, h1);
    }

    public void a(Store store, com.target.mothership.model.h h1)
    {
        h1 = new com.target.mothership.model.e(new com.target.mothership.model.product.handler.a(h1));
        mService.a(a(store), h1);
    }

    public void a(Store store, Product product, boolean flag, com.target.mothership.model.h h1)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(product);
        c(store, arraylist, flag, h1);
    }

    public void a(Store store, List list, boolean flag, com.target.mothership.model.h h1)
    {
        if (list == null || list.size() == 0)
        {
            return;
        }
        ArrayList arraylist = new ArrayList();
        for (Iterator iterator = list.iterator(); iterator.hasNext(); arraylist.add(((ProductIdentifier)iterator.next()).b())) { }
        store = new com.target.mothership.services.e.e.a.a((ProductIdentifier)list.get(0), arraylist, a(store), flag);
        list = new com.target.mothership.model.e(new l(h1));
        mService.b(store, list);
    }

    public void b(ProductSummaryParam productsummaryparam, com.target.mothership.model.h h1)
    {
        com.target.mothership.model.e e1 = new com.target.mothership.model.e(new l(h1));
        c c1 = new c(productsummaryparam);
        if (c1.b())
        {
            h1.a(c1.a().a());
            return;
        } else
        {
            mService.b(productsummaryparam, e1);
            return;
        }
    }

    public void b(Store store, List list, boolean flag, com.target.mothership.model.h h1)
    {
        if (list == null || list.size() == 0)
        {
            return;
        }
        ArrayList arraylist = new ArrayList();
        for (Iterator iterator = list.iterator(); iterator.hasNext(); arraylist.add(((ProductIdentifier)iterator.next()).b())) { }
        store = new com.target.mothership.services.e.e.a.a((ProductIdentifier)list.get(0), arraylist, a(store), flag);
        list = new com.target.mothership.model.e(new d(h1));
        mService.a(store, list);
    }

    public void c(Store store, List list, boolean flag, com.target.mothership.model.h h1)
    {
        h1 = new com.target.mothership.model.e(new d(h1));
        mService.a(a(list, store, flag), h1);
    }
}
