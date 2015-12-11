// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.product;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.target.mothership.model.dvm.interfaces.DvmDataResponse;
import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.ui.common.ProductErrorHeaderOptions;
import com.target.ui.common.ProductHeaderOptions;
import com.target.ui.model.product.CompositeProduct;
import com.target.ui.model.product.a;
import com.target.ui.view.BitmapImageView;
import com.target.ui.view.product.PlpCardView;
import com.target.ui.view.product.PlpDvmView;
import com.target.ui.view.product.PlpGridFooterView;
import com.target.ui.view.product.PlpGridHeaderView;
import java.util.List;

// Referenced classes of package com.target.ui.adapter.product:
//            g

public class e extends g
{
    public static interface a
    {

        public abstract void a();

        public abstract void a(BitmapImageView bitmapimageview, ProductDetails productdetails);

        public abstract void a(PlpDvmView plpdvmview);

        public abstract void a(String s);

        public abstract void b();
    }


    private List mCompositeProductList;
    private a mListener;

    public e(List list)
    {
        mCompositeProductList = list;
    }

    static a a(e e1)
    {
        return e1.mListener;
    }

    public void a(a a1)
    {
        mListener = a1;
    }

    public void a(List list)
    {
        mCompositeProductList = list;
        d();
    }

    protected View b(ViewGroup viewgroup)
    {
        return (PlpGridHeaderView)LayoutInflater.from(viewgroup.getContext()).inflate(0x7f0301a0, viewgroup, false);
    }

    protected View c(ViewGroup viewgroup)
    {
        viewgroup = (PlpGridFooterView)LayoutInflater.from(viewgroup.getContext()).inflate(0x7f03019f, viewgroup, false);
        a(viewgroup);
        return viewgroup;
    }

    protected void d(android.support.v7.widget.RecyclerView.t t, int k)
    {
        t = (PlpGridHeaderView)t.itemView;
        if (k().b())
        {
            t.setErrorHeaderData((ProductErrorHeaderOptions)k().c());
        } else
        {
            t.setHeaderData((ProductHeaderOptions)l().d());
        }
        t.setClickListener(new com.target.ui.view.product.PlpHeaderView.a() {

            final e this$0;

            public void a()
            {
                if (com.target.ui.adapter.product.e.a(e.this) == null)
                {
                    return;
                } else
                {
                    com.target.ui.adapter.product.e.a(e.this).b();
                    return;
                }
            }

            public void a(String s)
            {
                if (com.target.ui.adapter.product.e.a(e.this) == null)
                {
                    return;
                } else
                {
                    com.target.ui.adapter.product.e.a(e.this).a(s);
                    return;
                }
            }

            
            {
                this$0 = e.this;
                super();
            }
        });
    }

    protected View e(ViewGroup viewgroup)
    {
        return (PlpCardView)LayoutInflater.from(viewgroup.getContext()).inflate(0x7f0301a6, viewgroup, false);
    }

    protected void e(android.support.v7.widget.RecyclerView.t t, int k)
    {
        ((PlpGridFooterView)t.itemView).setClickListener(new com.target.ui.view.product.PlpFooterView.a() {

            final e this$0;

            public void a()
            {
                if (com.target.ui.adapter.product.e.a(e.this) == null)
                {
                    return;
                } else
                {
                    com.target.ui.adapter.product.e.a(e.this).a();
                    return;
                }
            }

            
            {
                this$0 = e.this;
                super();
            }
        });
    }

    protected View f(ViewGroup viewgroup)
    {
        return (PlpDvmView)LayoutInflater.from(viewgroup.getContext()).inflate(0x7f03019b, viewgroup, false);
    }

    protected void h(final android.support.v7.widget.RecyclerView.t plpCardView, int k)
    {
        if (mCompositeProductList == null)
        {
            return;
        } else
        {
            final ProductDetails productDetails = (CompositeProduct)mCompositeProductList.get(k);
            plpCardView = (PlpCardView)plpCardView.itemView;
            productDetails = (ProductDetails)productDetails.b().c();
            plpCardView.setItemData(productDetails);
            plpCardView.setOnClickListener(new android.view.View.OnClickListener() {

                final e this$0;
                final PlpCardView val$plpCardView;
                final ProductDetails val$productDetails;

                public void onClick(View view)
                {
                    if (com.target.ui.adapter.product.e.a(e.this) == null)
                    {
                        return;
                    } else
                    {
                        com.target.ui.adapter.product.e.a(e.this).a(plpCardView.getBitmapImageView(), productDetails);
                        return;
                    }
                }

            
            {
                this$0 = e.this;
                plpCardView = plpcardview;
                productDetails = productdetails;
                super();
            }
            });
            return;
        }
    }

    protected int i()
    {
        if (mCompositeProductList != null)
        {
            return mCompositeProductList.size();
        } else
        {
            return 0;
        }
    }

    protected void i(android.support.v7.widget.RecyclerView.t t, int k)
    {
        if (mCompositeProductList == null || !((CompositeProduct)mCompositeProductList.get(k)).c().b())
        {
            return;
        } else
        {
            t = (PlpDvmView)t.itemView;
            t.setDvmContent((DvmDataResponse)((CompositeProduct)mCompositeProductList.get(k)).c().c());
            t.setOnClickListener(new android.view.View.OnClickListener() {

                final e this$0;

                public void onClick(View view)
                {
                    if (com.target.ui.adapter.product.e.a(e.this) == null)
                    {
                        return;
                    } else
                    {
                        com.target.ui.adapter.product.e.a(e.this).a((PlpDvmView)view);
                        return;
                    }
                }

            
            {
                this$0 = e.this;
                super();
            }
            });
            return;
        }
    }

    protected boolean i(int k)
    {
        return ((CompositeProduct)mCompositeProductList.get(k)).a().equals(com.target.ui.model.product.a.DVM);
    }

    protected boolean j()
    {
        return true;
    }
}
