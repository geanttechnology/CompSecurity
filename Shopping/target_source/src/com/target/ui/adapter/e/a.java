// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.e;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.a.a.e;
import com.target.mothership.model.product.interfaces.ProductRootLevelCategory;
import com.target.mothership.model.registries.interfaces.RegistryDetails;
import com.target.mothership.model.registries.interfaces.RegistryProductDetails;
import com.target.mothership.util.o;
import com.target.ui.util.af;
import com.target.ui.view.BitmapImageView;
import com.target.ui.view.product.PlpListFooterView;
import com.target.ui.view.product.PlpListItemView;
import com.target.ui.view.registry.RegistryDetailsHeaderView;
import com.target.ui.view.registry.RegistryStickyHeaderView;
import java.util.List;

public class com.target.ui.adapter.e.a extends com.target.ui.adapter.e.a.a
{
    public static interface a
    {

        public abstract void a();

        public abstract void a(RegistryProductDetails registryproductdetails, RegistryDetails registrydetails, BitmapImageView bitmapimageview);
    }


    public static final int NO_STICKY_HEADER = -1;
    public static final int REGISTRY_ITEM = 0;
    private a mListener;
    private RegistryDetails mRegistryDetails;
    private final List mRegistryProductDetails;
    private int mTotalRecordCount;
    private Double mXSizeRatio;

    public com.target.ui.adapter.e.a(List list, Double double1)
    {
        mRegistryProductDetails = list;
        mXSizeRatio = double1;
    }

    static a a(com.target.ui.adapter.e.a a1)
    {
        return a1.mListener;
    }

    static RegistryDetails b(com.target.ui.adapter.e.a a1)
    {
        return a1.mRegistryDetails;
    }

    protected View a(ViewGroup viewgroup)
    {
        return LayoutInflater.from(viewgroup.getContext()).inflate(0x7f0301d4, viewgroup, false);
    }

    public void a(RegistryDetails registrydetails, int i)
    {
        mRegistryDetails = registrydetails;
        mTotalRecordCount = i;
        d();
    }

    public void a(a a1)
    {
        mListener = a1;
    }

    protected View b(ViewGroup viewgroup)
    {
        return LayoutInflater.from(viewgroup.getContext()).inflate(0x7f0301d3, viewgroup, false);
    }

    protected View c(ViewGroup viewgroup)
    {
        viewgroup = (PlpListFooterView)LayoutInflater.from(viewgroup.getContext()).inflate(0x7f0301aa, viewgroup, false);
        a(viewgroup);
        return viewgroup;
    }

    protected View c(ViewGroup viewgroup, int i)
    {
        return LayoutInflater.from(viewgroup.getContext()).inflate(0x7f0301ac, viewgroup, false);
    }

    protected void c(android.support.v7.widget.RecyclerView.t t, int i)
    {
        ((RegistryStickyHeaderView)t.itemView).setTitle(af.a(((ProductRootLevelCategory)((RegistryProductDetails)mRegistryProductDetails.get(i)).s().c()).a()));
    }

    protected void d(android.support.v7.widget.RecyclerView.t t, int i)
    {
        ((RegistryDetailsHeaderView)t.itemView).a(mRegistryDetails, mXSizeRatio, mTotalRecordCount);
    }

    protected void e(android.support.v7.widget.RecyclerView.t t, int i)
    {
        ((PlpListFooterView)t.itemView).setClickListener(new com.target.ui.view.product.PlpFooterView.a() {

            final com.target.ui.adapter.e.a this$0;

            public void a()
            {
                if (com.target.ui.adapter.e.a.a(com.target.ui.adapter.e.a.this) == null)
                {
                    return;
                } else
                {
                    com.target.ui.adapter.e.a.a(com.target.ui.adapter.e.a.this).a();
                    return;
                }
            }

            
            {
                this$0 = com.target.ui.adapter.e.a.this;
                super();
            }
        });
    }

    protected boolean e()
    {
        return true;
    }

    protected long f(int i)
    {
        if (mRegistryProductDetails == null)
        {
            return -1L;
        }
        if (!((RegistryProductDetails)mRegistryProductDetails.get(i)).s().b())
        {
            return -1L;
        }
        String s = ((ProductRootLevelCategory)((RegistryProductDetails)mRegistryProductDetails.get(i)).s().c()).a();
        if (!o.g(s))
        {
            return -1L;
        } else
        {
            return (long)Math.abs(af.a(s).hashCode());
        }
    }

    protected void f(android.support.v7.widget.RecyclerView.t t, int i)
    {
        if (mRegistryProductDetails == null)
        {
            return;
        }
        final RegistryProductDetails registryProduct = (RegistryProductDetails)mRegistryProductDetails.get(i);
        final PlpListItemView plpListItemView = (PlpListItemView)t.itemView;
        int j = registryProduct.L();
        int k = registryProduct.K();
        if (j == k)
        {
            i = 0x7f0f00ec;
            t = plpListItemView.getContext().getString(0x7f0904a9);
        } else
        {
            i = 0x7f0f00f6;
            t = String.format(plpListItemView.getContext().getString(0x7f0904aa), new Object[] {
                Integer.valueOf(j), Integer.valueOf(k)
            });
        }
        plpListItemView.a(false);
        plpListItemView.a(t, i);
        plpListItemView.setItemData(registryProduct);
        plpListItemView.setOnClickListener(new android.view.View.OnClickListener() {

            final com.target.ui.adapter.e.a this$0;
            final PlpListItemView val$plpListItemView;
            final RegistryProductDetails val$registryProduct;

            public void onClick(View view)
            {
                if (com.target.ui.adapter.e.a.a(com.target.ui.adapter.e.a.this) == null)
                {
                    return;
                } else
                {
                    com.target.ui.adapter.e.a.a(com.target.ui.adapter.e.a.this).a(registryProduct, com.target.ui.adapter.e.a.b(com.target.ui.adapter.e.a.this), plpListItemView.getBitmapImageView());
                    return;
                }
            }

            
            {
                this$0 = com.target.ui.adapter.e.a.this;
                registryProduct = registryproductdetails;
                plpListItemView = plplistitemview;
                super();
            }
        });
    }

    protected int g()
    {
        if (mRegistryProductDetails != null)
        {
            return mRegistryProductDetails.size();
        } else
        {
            return 0;
        }
    }

    protected int g(int i)
    {
        return 0;
    }
}
