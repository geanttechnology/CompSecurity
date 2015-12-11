// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.target.mothership.util.o;
import com.target.ui.common.ProductFulfillmentOptions;
import com.target.ui.util.al;
import com.target.ui.util.f.a;
import com.target.ui.view.AisleBadgeView;

public class PlpFulfillmentView extends LinearLayout
    implements android.view.View.OnClickListener
{
    static class Views extends com.target.ui.view.a
    {

        ImageView addToListBtn;
        AisleBadgeView aisleView;
        ImageView pickUpAtStoreBtn;
        ImageView shipMeBtn;

        public Views(View view)
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

    public PlpFulfillmentView(Context context)
    {
        super(context);
        a(context);
    }

    public PlpFulfillmentView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a(context);
    }

    public PlpFulfillmentView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a(context);
    }

    private void a(Context context)
    {
        setOrientation(0);
        inflate(context, 0x7f03019e, this);
        mViews = new Views(this);
        al.a(this, new View[] {
            mViews.aisleView, mViews.pickUpAtStoreBtn, mViews.shipMeBtn, mViews.addToListBtn
        });
    }

    public void a(ProductFulfillmentOptions productfulfillmentoptions)
    {
        if (productfulfillmentoptions.d())
        {
            al.b(mViews.pickUpAtStoreBtn);
        } else
        {
            al.c(mViews.pickUpAtStoreBtn);
        }
        if (productfulfillmentoptions.e())
        {
            al.b(mViews.shipMeBtn);
        } else
        {
            al.c(mViews.shipMeBtn);
        }
        if (productfulfillmentoptions.h())
        {
            al.b(mViews.addToListBtn);
        } else
        {
            al.c(mViews.addToListBtn);
        }
        if (productfulfillmentoptions.g())
        {
            if (o.g(productfulfillmentoptions.t()))
            {
                mViews.aisleView.setAisle(productfulfillmentoptions.t());
            } else
            {
                mViews.aisleView.setDepartment(com.target.ui.util.f.a.a(productfulfillmentoptions.x()));
            }
            al.b(mViews.aisleView);
            return;
        } else
        {
            al.c(mViews.aisleView);
            return;
        }
    }

    public void onClick(View view)
    {
        if (mListener == null)
        {
            return;
        }
        switch (view.getId())
        {
        default:
            return;

        case 2131756262: 
            mListener.a();
            return;

        case 2131756263: 
            mListener.b();
            return;

        case 2131756264: 
            mListener.c();
            return;

        case 2131756265: 
            mListener.d();
            break;
        }
    }

    public void setClickListener(a a1)
    {
        mListener = a1;
    }
}
