// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.clp.presenter;

import android.graphics.Bitmap;
import com.google.a.a.e;
import com.target.mothership.common.product.ProductIdentifier;
import com.target.mothership.model.product.interfaces.Product;
import com.target.mothership.model.store.interfaces.Store;

public class com.target.ui.fragment.product.clp.presenter.a
{
    public static class a
    {

        private Product mProduct;
        private ProductIdentifier mProductIdentifier;
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

        static Bitmap d(a a1)
        {
            return a1.mTransitionBitmap;
        }

        static String e(a a1)
        {
            return a1.mTransitionUrl;
        }

        static String f(a a1)
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

        public com.target.ui.fragment.product.clp.presenter.a a()
        {
            return new com.target.ui.fragment.product.clp.presenter.a(this);
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
    private Store mStore;
    private Bitmap mTransitionBitmap;
    private String mTransitionTag;
    private String mTransitionUrl;

    private com.target.ui.fragment.product.clp.presenter.a(a a1)
    {
        mStore = a.a(a1);
        mProduct = a.b(a1);
        mProductIdentifier = a.c(a1);
        mTransitionBitmap = a.d(a1);
        mTransitionUrl = com.target.ui.fragment.product.clp.presenter.a.e(a1);
        mTransitionTag = a.f(a1);
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
        return com.google.a.a.e.c(mTransitionBitmap);
    }

    public e e()
    {
        return com.google.a.a.e.c(mTransitionUrl);
    }

    public e f()
    {
        return com.google.a.a.e.c(mTransitionTag);
    }
}
