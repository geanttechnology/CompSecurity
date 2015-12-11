// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.product;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.a.a.e;
import com.target.mothership.model.dvm.interfaces.DvmDataResponse;
import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.ui.common.ProductErrorHeaderOptions;
import com.target.ui.common.ProductHeaderOptions;
import com.target.ui.model.product.CompositeProduct;
import com.target.ui.model.product.a;
import com.target.ui.view.BitmapImageView;
import com.target.ui.view.product.PlpDvmView;
import com.target.ui.view.product.PlpHeaderView;
import com.target.ui.view.product.PlpListFooterView;
import com.target.ui.view.product.PlpListItemView;
import java.util.List;

// Referenced classes of package com.target.ui.adapter.product:
//            g

public class f extends g
{
    public static interface a
    {

        public abstract void a();

        public abstract void a(ProductDetails productdetails);

        public abstract void a(BitmapImageView bitmapimageview, ProductDetails productdetails);

        public abstract void a(PlpDvmView plpdvmview);

        public abstract void a(String s);

        public abstract void b();

        public abstract void b(ProductDetails productdetails);

        public abstract void c(ProductDetails productdetails);
    }


    private List mCompositeProductList;
    private a mListener;

    public f(List list)
    {
        mCompositeProductList = list;
    }

    static a a(f f1)
    {
        return f1.mListener;
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
        return LayoutInflater.from(viewgroup.getContext()).inflate(0x7f0301ab, viewgroup, false);
    }

    protected View c(ViewGroup viewgroup)
    {
        viewgroup = (PlpListFooterView)LayoutInflater.from(viewgroup.getContext()).inflate(0x7f0301aa, viewgroup, false);
        a(viewgroup);
        return viewgroup;
    }

    protected void d(android.support.v7.widget.RecyclerView.t t, int k)
    {
        t = (PlpHeaderView)t.itemView;
        if (k().b())
        {
            t.setErrorHeaderData((ProductErrorHeaderOptions)k().c());
        } else
        {
            t.setHeaderData((ProductHeaderOptions)l().d());
        }
        t.setClickListener(new com.target.ui.view.product.PlpHeaderView.a() {

            final f this$0;

            public void a()
            {
                if (com.target.ui.adapter.product.f.a(f.this) == null)
                {
                    return;
                } else
                {
                    com.target.ui.adapter.product.f.a(f.this).b();
                    return;
                }
            }

            public void a(String s)
            {
                if (com.target.ui.adapter.product.f.a(f.this) == null)
                {
                    return;
                } else
                {
                    com.target.ui.adapter.product.f.a(f.this).a(s);
                    return;
                }
            }

            
            {
                this$0 = f.this;
                super();
            }
        });
    }

    protected View e(ViewGroup viewgroup)
    {
        return (PlpListItemView)LayoutInflater.from(viewgroup.getContext()).inflate(0x7f0301ac, viewgroup, false);
    }

    protected void e(android.support.v7.widget.RecyclerView.t t, int k)
    {
        ((PlpListFooterView)t.itemView).setClickListener(new com.target.ui.view.product.PlpFooterView.a() {

            final f this$0;

            public void a()
            {
                if (com.target.ui.adapter.product.f.a(f.this) == null)
                {
                    return;
                } else
                {
                    com.target.ui.adapter.product.f.a(f.this).a();
                    return;
                }
            }

            
            {
                this$0 = f.this;
                super();
            }
        });
    }

    protected View f(ViewGroup viewgroup)
    {
        return (PlpDvmView)LayoutInflater.from(viewgroup.getContext()).inflate(0x7f03019c, viewgroup, false);
    }

    protected void h(final android.support.v7.widget.RecyclerView.t plpListItemView, int k)
    {
        if (mCompositeProductList == null)
        {
            return;
        } else
        {
            final ProductDetails productDetails = (ProductDetails)((CompositeProduct)mCompositeProductList.get(k)).b().c();
            plpListItemView = (PlpListItemView)plpListItemView.itemView;
            plpListItemView.setItemData(productDetails);
            plpListItemView.setOnClickListener(new android.view.View.OnClickListener() {

                final f this$0;
                final PlpListItemView val$plpListItemView;
                final ProductDetails val$productDetails;

                public void onClick(View view)
                {
                    if (com.target.ui.adapter.product.f.a(f.this) == null)
                    {
                        return;
                    } else
                    {
                        com.target.ui.adapter.product.f.a(f.this).a(plpListItemView.getBitmapImageView(), productDetails);
                        return;
                    }
                }

            
            {
                this$0 = f.this;
                plpListItemView = plplistitemview;
                productDetails = productdetails;
                super();
            }
            });
            plpListItemView.setClickListener(new com.target.ui.view.product.PlpListItemView.d() {

                final f this$0;

                public void a(ProductDetails productdetails)
                {
                    if (com.target.ui.adapter.product.f.a(f.this) == null)
                    {
                        return;
                    } else
                    {
                        com.target.ui.adapter.product.f.a(f.this).a(productdetails);
                        return;
                    }
                }

                public void b(ProductDetails productdetails)
                {
                    if (com.target.ui.adapter.product.f.a(f.this) == null)
                    {
                        return;
                    } else
                    {
                        com.target.ui.adapter.product.f.a(f.this).b(productdetails);
                        return;
                    }
                }

                public void c(ProductDetails productdetails)
                {
                    if (com.target.ui.adapter.product.f.a(f.this) == null)
                    {
                        return;
                    } else
                    {
                        com.target.ui.adapter.product.f.a(f.this).c(productdetails);
                        return;
                    }
                }

            
            {
                this$0 = f.this;
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

                final f this$0;

                public void onClick(View view)
                {
                    if (com.target.ui.adapter.product.f.a(f.this) == null)
                    {
                        return;
                    } else
                    {
                        com.target.ui.adapter.product.f.a(f.this).a((PlpDvmView)view);
                        return;
                    }
                }

            
            {
                this$0 = f.this;
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
