// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.f;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.google.a.a.f;
import com.target.mothership.model.cart.interfaces.SaveForLaterProduct;
import com.target.mothership.model.common.OrderProductImage;
import com.target.ui.util.d.b;
import com.target.ui.view.BitmapImageView;
import com.target.ui.view.cart.SaveForLaterProductView;
import java.util.List;

public class com.target.ui.adapter.f.a extends android.support.v7.widget.RecyclerView.a
{
    public static interface a
    {

        public abstract void a(SaveForLaterProduct saveforlaterproduct);

        public abstract void a(BitmapImageView bitmapimageview, SaveForLaterProduct saveforlaterproduct);

        public abstract void b(SaveForLaterProduct saveforlaterproduct);
    }

    public class b extends android.support.v7.widget.RecyclerView.t
    {

        final com.target.ui.adapter.f.a this$0;
        SaveForLaterProductView view;

        static boolean a(b b1, int i)
        {
            return b1.c(i);
        }

        private boolean c(int i)
        {
            return i >= 0 && i < com.target.ui.adapter.f.a.a(com.target.ui.adapter.f.a.this).size();
        }

        public b(SaveForLaterProductView saveforlaterproductview)
        {
            this$0 = com.target.ui.adapter.f.a.this;
            super(saveforlaterproductview);
            view = saveforlaterproductview;
            view.setSaveForLaterProductViewListener(new _cls1());
        }
    }


    private int mImageSize;
    private a mListener;
    private List mProducts;

    public com.target.ui.adapter.f.a(Context context, a a1)
    {
        f.a(a1);
        mListener = a1;
        mImageSize = context.getResources().getDimensionPixelSize(0x7f0a029a);
    }

    static List a(com.target.ui.adapter.f.a a1)
    {
        return a1.mProducts;
    }

    static a b(com.target.ui.adapter.f.a a1)
    {
        return a1.mListener;
    }

    public int a()
    {
        if (mProducts == null)
        {
            return 0;
        } else
        {
            return mProducts.size();
        }
    }

    public android.support.v7.widget.RecyclerView.t a(ViewGroup viewgroup, int i)
    {
        return c(viewgroup, i);
    }

    public volatile void a(android.support.v7.widget.RecyclerView.t t, int i)
    {
        a((b)t, i);
    }

    public void a(b b1, int i)
    {
        boolean flag1 = true;
        b1 = (SaveForLaterProductView)b1.itemView;
        SaveForLaterProduct saveforlaterproduct = (SaveForLaterProduct)mProducts.get(i);
        b1.c(com.target.ui.util.d.b.a(saveforlaterproduct.c()));
        b1.b(saveforlaterproduct.g());
        b1.a(saveforlaterproduct.a().a(mImageSize));
        boolean flag;
        if (!saveforlaterproduct.i())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b1.b(flag);
        if (!saveforlaterproduct.i())
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        b1.a(flag);
    }

    public void a(List list)
    {
        mProducts = list;
        d();
    }

    public b c(ViewGroup viewgroup, int i)
    {
        return new b((SaveForLaterProductView)LayoutInflater.from(viewgroup.getContext()).inflate(0x7f0301e3, viewgroup, false));
    }

    // Unreferenced inner class com/target/ui/adapter/f/a$b$1

/* anonymous class */
    class b._cls1
        implements com.target.ui.view.cart.SaveForLaterProductView.a
    {

        final b this$1;
        final com.target.ui.adapter.f.a val$this$0;

        public void a()
        {
            int i = f();
            if (!b.a(b.this, i))
            {
                return;
            } else
            {
                com.target.ui.adapter.f.a.b(_fld0).a((SaveForLaterProduct)com.target.ui.adapter.f.a.a(_fld0).get(i));
                return;
            }
        }

        public void a(BitmapImageView bitmapimageview)
        {
            int i = f();
            if (!b.a(b.this, i))
            {
                return;
            } else
            {
                com.target.ui.adapter.f.a.b(_fld0).a(bitmapimageview, (SaveForLaterProduct)com.target.ui.adapter.f.a.a(_fld0).get(i));
                return;
            }
        }

        public void b()
        {
            int i = f();
            if (!b.a(b.this, i))
            {
                return;
            } else
            {
                com.target.ui.adapter.f.a.b(_fld0).b((SaveForLaterProduct)com.target.ui.adapter.f.a.a(_fld0).get(i));
                return;
            }
        }

            
            {
                this$1 = final_b1;
                this$0 = com.target.ui.adapter.f.a.this;
                super();
            }
    }

}
