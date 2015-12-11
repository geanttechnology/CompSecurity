// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.productsV3.a;

import com.target.mothership.common.product.Dpci;
import com.target.mothership.common.product.o;
import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.services.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class com.target.mothership.services.apigee.productsV3.a.a extends k
{
    private class a
    {

        private String mProductId;
        private int mQuantity;
        final com.target.mothership.services.apigee.productsV3.a.a this$0;

        public a(String s, int i)
        {
            this$0 = com.target.mothership.services.apigee.productsV3.a.a.this;
            super();
            mProductId = s;
            mQuantity = i;
        }
    }

    private class b
    {

        private String mStoreId;
        final com.target.mothership.services.apigee.productsV3.a.a this$0;

        public b(String s)
        {
            this$0 = com.target.mothership.services.apigee.productsV3.a.a.this;
            super();
            mStoreId = s;
        }
    }

    private class c
    {

        private String mOption;
        final com.target.mothership.services.apigee.productsV3.a.a this$0;

        public c(String s)
        {
            this$0 = com.target.mothership.services.apigee.productsV3.a.a.this;
            super();
            mOption = s;
        }
    }


    private List mMultichannelOptions;
    private String mNearby;
    private List mProducts;
    private Integer mRadius;
    private List mStores;

    public com.target.mothership.services.apigee.productsV3.a.a(Dpci dpci, int i, String s, o o1, Integer integer)
    {
        mProducts = new ArrayList();
        mProducts.add(new a(dpci.b(), i));
        mNearby = s;
        mRadius = integer;
        mMultichannelOptions = new ArrayList();
        mMultichannelOptions.add(new c(a(o1)));
    }

    public com.target.mothership.services.apigee.productsV3.a.a(Dpci dpci, int i, List list, o o1)
    {
        mProducts = new ArrayList();
        mProducts.add(new a(dpci.b(), i));
        mStores = new ArrayList();
        for (dpci = list.iterator(); dpci.hasNext(); mStores.add(new b(list.a())))
        {
            list = (StoreIdentifier)dpci.next();
        }

        mMultichannelOptions = new ArrayList();
        mMultichannelOptions.add(new c(a(o1)));
    }

    private String a(o o1)
    {
        if (o1 == null)
        {
            return "none";
        }
        static class _cls1
        {

            static final int $SwitchMap$com$target$mothership$common$product$ProductAvailabilityType[];

            static 
            {
                $SwitchMap$com$target$mothership$common$product$ProductAvailabilityType = new int[o.values().length];
                try
                {
                    $SwitchMap$com$target$mothership$common$product$ProductAvailabilityType[o.PICKUP_IN_STORE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$ProductAvailabilityType[o.SHIP_TO_STORE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$ProductAvailabilityType[o.ANY.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.target.mothership.common.product.ProductAvailabilityType[o1.ordinal()])
        {
        default:
            return "none";

        case 1: // '\001'
            return "hold";

        case 2: // '\002'
            return "shiptostore";
        }
    }
}
