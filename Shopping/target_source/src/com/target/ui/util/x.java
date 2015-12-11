// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util;

import android.support.v4.f.a;
import com.google.a.a.e;
import com.pointinside.products.BaseProduct;
import com.pointinside.products.LookupResult;
import com.pointinside.products.ProductDesc;
import com.target.mothership.common.product.Dpci;
import com.target.mothership.model.h;
import com.target.mothership.model.product.c;
import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.mothership.model.product.interfaces.ProductDetailsWrapper;
import com.target.mothership.model.store.interfaces.Store;
import com.target.ui.model.MapDisplayableItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.target.ui.util:
//            w

public class x
{
    public static interface a
    {

        public abstract void a(Throwable throwable);

        public abstract void a(List list);
    }


    private a mCallback;
    private boolean mDetailsLoaded;
    private List mDpcisToLoad;
    private Map mGenericProducts;
    private List mGenericProductsToLoad;
    private boolean mPILoaded;
    private List mPreloadedProducts;
    private c mProductManager;
    private Map mProductsWithoutDpcis;
    private Map mSpecificProducts;
    private Store mStoreInfo;
    private List mTcinsToLoad;

    public x(Store store)
    {
        mDpcisToLoad = new ArrayList();
        mTcinsToLoad = new ArrayList();
        mGenericProductsToLoad = new ArrayList();
        mPreloadedProducts = new ArrayList();
        mStoreInfo = store;
        mProductManager = new c();
    }

    static a a(x x1, a a1)
    {
        x1.mCallback = a1;
        return a1;
    }

    static Map a(x x1)
    {
        return x1.mSpecificProducts;
    }

    private void a()
    {
        this;
        JVM INSTR monitorenter ;
        if (mCallback != null && mDetailsLoaded && mPILoaded)
        {
            ArrayList arraylist = new ArrayList();
            arraylist.addAll(mSpecificProducts.values());
            arraylist.addAll(mGenericProducts.values());
            mCallback.a(arraylist);
            mCallback = null;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void a(Store store)
    {
        ArrayList arraylist = new ArrayList();
        for (Iterator iterator = mSpecificProducts.keySet().iterator(); iterator.hasNext(); arraylist.add(ProductDesc.createWithProductId((String)iterator.next()))) { }
        String s;
        for (Iterator iterator1 = mProductsWithoutDpcis.keySet().iterator(); iterator1.hasNext(); mGenericProducts.put(s, mProductsWithoutDpcis.get(s)))
        {
            s = (String)iterator1.next();
            arraylist.add(ProductDesc.createWithTerm(s));
        }

        String s1;
        for (Iterator iterator2 = mGenericProductsToLoad.iterator(); iterator2.hasNext(); mGenericProducts.put(s1, new MapDisplayableItem()))
        {
            s1 = (String)iterator2.next();
            arraylist.add(ProductDesc.createWithTerm(s1));
        }

        if (!arraylist.isEmpty())
        {
            w.b(arraylist, store, new w.b() {

                final x this$0;

                public void a(Exception exception)
                {
                    x.d(x.this).a(exception);
                }

                public void a(List list)
                {
                    if (list != null)
                    {
                        com.target.ui.util.x.a(x.this, true);
                        list = list.iterator();
                        do
                        {
                            if (!list.hasNext())
                            {
                                break;
                            }
                            LookupResult lookupresult = (LookupResult)list.next();
                            if (lookupresult.lookupStatus == com.pointinside.products.LookupResult.LookupStatus.FOUND)
                            {
                                if (lookupresult.product.type == com.pointinside.products.BaseProduct.PIProductsProductType.product)
                                {
                                    MapDisplayableItem mapdisplayableitem = (MapDisplayableItem)com.target.ui.util.x.a(x.this).get(lookupresult.product.productId);
                                    if (mapdisplayableitem != null)
                                    {
                                        mapdisplayableitem.a(com.target.ui.util.f.a.b(lookupresult.product.locations));
                                        mapdisplayableitem.a(lookupresult.product.title);
                                    }
                                } else
                                {
                                    MapDisplayableItem mapdisplayableitem1 = (MapDisplayableItem)x.b(x.this).get(lookupresult.product.title);
                                    if (mapdisplayableitem1 != null)
                                    {
                                        mapdisplayableitem1.a(com.target.ui.util.f.a.b(lookupresult.product.locations));
                                        mapdisplayableitem1.a(lookupresult.product.title);
                                    }
                                }
                            }
                        } while (true);
                        com.target.ui.util.x.c(x.this);
                    }
                }

            
            {
                this$0 = x.this;
                super();
            }
            }).a();
        } else
        {
            mPILoaded = true;
        }
        if (!mDpcisToLoad.isEmpty())
        {
            a(store, false);
        } else
        {
            mDetailsLoaded = true;
        }
        a();
    }

    private void a(Store store, final boolean tcins)
    {
        ArrayList arraylist = new ArrayList();
        if (tcins)
        {
            arraylist.addAll(mTcinsToLoad);
        } else
        {
            arraylist.addAll(mDpcisToLoad);
        }
        mProductManager.b(store, arraylist, false, new h() {

            final x this$0;
            final boolean val$tcins;

            public void a(ProductDetailsWrapper productdetailswrapper)
            {
                if (!tcins)
                {
                    x.b(x.this, true);
                }
                ProductDetails productdetails;
                String s;
                for (productdetailswrapper = productdetailswrapper.b().iterator(); productdetailswrapper.hasNext(); ((MapDisplayableItem)com.target.ui.util.x.a(x.this).get(s)).a(productdetails))
                {
                    productdetails = (ProductDetails)productdetailswrapper.next();
                    s = ((Dpci)productdetails.e().c()).b();
                    if (tcins)
                    {
                        com.target.ui.util.x.a(x.this).put(s, new MapDisplayableItem());
                    }
                }

                if (tcins)
                {
                    com.target.ui.util.x.a(x.this, com.target.ui.util.x.e(x.this));
                    return;
                } else
                {
                    com.target.ui.util.x.c(x.this);
                    return;
                }
            }

            public void a(com.target.mothership.services.x x1)
            {
                if (x.d(x.this) != null)
                {
                    x.d(x.this).a(x1);
                    com.target.ui.util.x.a(x.this, null);
                }
            }

            public volatile void a(Object obj)
            {
                a((ProductDetailsWrapper)obj);
            }

            public void b(Object obj)
            {
                a((com.target.mothership.services.x)obj);
            }

            
            {
                this$0 = x.this;
                tcins = flag;
                super();
            }
        });
    }

    static void a(x x1, Store store)
    {
        x1.a(store);
    }

    static boolean a(x x1, boolean flag)
    {
        x1.mPILoaded = flag;
        return flag;
    }

    static Map b(x x1)
    {
        return x1.mGenericProducts;
    }

    static boolean b(x x1, boolean flag)
    {
        x1.mDetailsLoaded = flag;
        return flag;
    }

    static void c(x x1)
    {
        x1.a();
    }

    static a d(x x1)
    {
        return x1.mCallback;
    }

    static Store e(x x1)
    {
        return x1.mStoreInfo;
    }

    public void a(a a1)
    {
        mPILoaded = false;
        mDetailsLoaded = false;
        mCallback = a1;
        mSpecificProducts = new android.support.v4.f.a();
        mGenericProducts = new android.support.v4.f.a();
        mProductsWithoutDpcis = new android.support.v4.f.a();
        Dpci dpci;
        for (a1 = mDpcisToLoad.iterator(); a1.hasNext(); mSpecificProducts.put(dpci.b(), new MapDisplayableItem()))
        {
            dpci = (Dpci)a1.next();
        }

        for (a1 = mPreloadedProducts.iterator(); a1.hasNext();)
        {
            ProductDetails productdetails = (ProductDetails)a1.next();
            MapDisplayableItem mapdisplayableitem = new MapDisplayableItem();
            mapdisplayableitem.a(productdetails);
            if (productdetails.e().b())
            {
                mSpecificProducts.put(((Dpci)productdetails.e().c()).b(), mapdisplayableitem);
            } else
            {
                mProductsWithoutDpcis.put(productdetails.g(), mapdisplayableitem);
            }
        }

        if (!mTcinsToLoad.isEmpty())
        {
            a(mStoreInfo, true);
            return;
        } else
        {
            a(mStoreInfo);
            return;
        }
    }

    public void a(List list)
    {
        mGenericProductsToLoad.addAll(list);
    }

    public void b(List list)
    {
        mPreloadedProducts.addAll(list);
    }
}
