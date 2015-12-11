// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.a.a.e;
import com.target.mothership.model.product.interfaces.ProductGuestReview;
import com.target.ui.common.f;
import com.target.ui.util.al;

public class PdpOtherLayoutView extends LinearLayout
    implements android.view.View.OnClickListener
{
    static class Views extends com.target.ui.view.a
    {

        View findInNearByStoresLayout;
        View findInNearByStoresLayoutDiv;
        View freeShippingLayout;
        View guestReviewLayout;
        View guestReviewLayoutDiv;
        TextView guestReviewText;
        View productDetailLayout;

        Views(View view)
        {
            super(view);
        }
    }

    public static interface a
    {

        public abstract void a();

        public abstract void b();

        public abstract void c();

        public abstract void d();
    }


    private a mListener;
    private Views mViews;

    public PdpOtherLayoutView(Context context)
    {
        super(context);
        b();
    }

    public PdpOtherLayoutView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        b();
    }

    public PdpOtherLayoutView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        b();
    }

    private void a()
    {
        al.a(new View[] {
            mViews.guestReviewLayout, mViews.guestReviewLayoutDiv
        });
    }

    private void a(ProductGuestReview productguestreview)
    {
        productguestreview = String.format(getContext().getResources().getString(0x7f09047e), new Object[] {
            Integer.valueOf(productguestreview.b())
        });
        mViews.guestReviewText.setText(productguestreview);
        al.b(new View[] {
            mViews.guestReviewLayout, mViews.guestReviewLayoutDiv
        });
    }

    private void a(boolean flag)
    {
        if (!flag)
        {
            al.a(new View[] {
                mViews.findInNearByStoresLayout, mViews.findInNearByStoresLayoutDiv
            });
            return;
        } else
        {
            al.b(new View[] {
                mViews.findInNearByStoresLayout, mViews.findInNearByStoresLayoutDiv
            });
            return;
        }
    }

    private void b()
    {
        inflate(getContext(), 0x7f03018e, this);
        mViews = new Views(this);
        al.a(this, new View[] {
            mViews.productDetailLayout, mViews.guestReviewLayout, mViews.findInNearByStoresLayout, mViews.freeShippingLayout
        });
    }

    public void a(f f1)
    {
        if (f1.b().b())
        {
            a((ProductGuestReview)f1.b().c());
        } else
        {
            a();
        }
        a(f1.a());
    }

    public void onClick(View view)
    {
        if (mListener == null)
        {
            return;
        }
        switch (view.getId())
        {
        case 2131756230: 
        case 2131756231: 
        case 2131756233: 
        default:
            return;

        case 2131756228: 
            mListener.a();
            return;

        case 2131756229: 
            mListener.b();
            return;

        case 2131756232: 
            mListener.c();
            return;

        case 2131756234: 
            mListener.d();
            break;
        }
    }

    public void setClickListener(a a1)
    {
        mListener = a1;
    }
}
