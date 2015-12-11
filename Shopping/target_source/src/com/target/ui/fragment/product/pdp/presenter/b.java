// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.pdp.presenter;

import android.graphics.Bitmap;
import com.google.a.a.e;
import com.target.mothership.common.product.ProductIdentifier;
import com.target.mothership.model.product.interfaces.Product;
import com.target.mothership.model.registries.interfaces.RegistryDetails;
import com.target.mothership.model.registries.interfaces.RegistryProductDetails;
import com.target.mothership.model.store.interfaces.Store;

public class b
{
    public static class a
    {

        private Product mProduct;
        private ProductIdentifier mProductIdentifier;
        private RegistryDetails mRegistryDetails;
        private RegistryProductDetails mRegistryProductDetails;
        private Store mStore;
        private Bitmap mTransitionBitmap;
        private String mTransitionTag;
        private String mTransitionUrl;

        static Store a(a a1)
        {
            return a1.mStore;
        }

        static Product b(a a1)
        {
            return a1.mProduct;
        }

        static ProductIdentifier c(a a1)
        {
            return a1.mProductIdentifier;
        }

        static RegistryProductDetails d(a a1)
        {
            return a1.mRegistryProductDetails;
        }

        static RegistryDetails e(a a1)
        {
            return a1.mRegistryDetails;
        }

        static Bitmap f(a a1)
        {
            return a1.mTransitionBitmap;
        }

        static String g(a a1)
        {
            return a1.mTransitionUrl;
        }

        static String h(a a1)
        {
            return a1.mTransitionTag;
        }

        public a a(Bitmap bitmap)
        {
            mTransitionBitmap = bitmap;
            return this;
        }

        public a a(ProductIdentifier productidentifier)
        {
            mProductIdentifier = productidentifier;
            return this;
        }

        public a a(Product product)
        {
            mProduct = product;
            return this;
        }

        public a a(RegistryDetails registrydetails)
        {
            mRegistryDetails = registrydetails;
            return this;
        }

        public a a(RegistryProductDetails registryproductdetails)
        {
            mRegistryProductDetails = registryproductdetails;
            return this;
        }

        public a a(Store store)
        {
            mStore = store;
            return this;
        }

        public a a(String s)
        {
            mTransitionUrl = s;
            return this;
        }

        public b a()
        {
            return new b(this);
        }

        public a b(String s)
        {
            mTransitionTag = s;
            return this;
        }

        public a()
        {
        }
    }


    private Product mProduct;
    private ProductIdentifier mProductIdentifier;
    private RegistryDetails mRegistryDetails;
    private RegistryProductDetails mRegistryProductDetails;
    private Store mStore;
    private Bitmap mTransitionBitmap;
    private String mTransitionTag;
    private String mTransitionUrl;

    private b(a a1)
    {
        mStore = a.a(a1);
        mProduct = a.b(a1);
        mProductIdentifier = a.c(a1);
        mRegistryProductDetails = a.d(a1);
        mRegistryDetails = com.target.ui.fragment.product.pdp.presenter.a.e(a1);
        mTransitionBitmap = a.f(a1);
        mTransitionUrl = a.g(a1);
        mTransitionTag = a.h(a1);
    }


    public e a()
    {
        return com.google.a.a.e.c(mStore);
    }

    public e b()
    {
        return com.google.a.a.e.c(mProduct);
    }

    public e c()
    {
        return com.google.a.a.e.c(mProductIdentifier);
    }

    public e d()
    {
        return com.google.a.a.e.c(mRegistryProductDetails);
    }

    public e e()
    {
        return com.google.a.a.e.c(mRegistryDetails);
    }

    public e f()
    {
        return com.google.a.a.e.c(mTransitionBitmap);
    }

    public e g()
    {
        return com.google.a.a.e.c(mTransitionUrl);
    }

    public e h()
    {
        return com.google.a.a.e.c(mTransitionTag);
    }
}
