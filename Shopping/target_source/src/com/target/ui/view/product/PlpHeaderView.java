// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.a.a.e;
import com.target.ui.common.ProductErrorHeaderOptions;
import com.target.ui.common.ProductHeaderOptions;
import com.target.ui.util.al;
import com.target.ui.view.AisleBadgeView;
import com.target.ui.view.common.TargetErrorView;
import com.target.ui.view.common.c;

public abstract class PlpHeaderView extends FrameLayout
    implements android.view.View.OnClickListener
{
    static class Views extends com.target.ui.view.a
    {

        AisleBadgeView aisle;
        TargetErrorView errorContainer;
        TextView find;
        TextView inStore;
        View rootContainer;
        View storeLocationHeader;

        public Views(View view)
        {
            super(view);
            rootContainer = view;
        }
    }

    public static interface a
    {

        public abstract void a();

        public abstract void a(String s);
    }


    private int mErrorHeaderHeightLarge;
    private int mErrorHeaderHeightSmall;
    private a mListener;
    private String mTitle;
    private Views mViews;

    public PlpHeaderView(Context context)
    {
        super(context);
        a(context);
    }

    public PlpHeaderView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a(context);
    }

    public PlpHeaderView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a(context);
    }

    static a a(PlpHeaderView plpheaderview)
    {
        return plpheaderview.mListener;
    }

    private void a(Context context)
    {
        inflate(context, getLayoutId(), this);
        setBackgroundColor(getResources().getColor(0x7f0f00ef));
        mErrorHeaderHeightSmall = getResources().getDimensionPixelSize(0x7f0a0259);
        mErrorHeaderHeightLarge = getResources().getDimensionPixelSize(0x7f0a0258);
        mViews = new Views(this);
        mViews.aisle.setOnClickListener(this);
        mTitle = "";
        mViews.errorContainer.setClickListener(new c() {

            final PlpHeaderView this$0;

            public void A_()
            {
                if (PlpHeaderView.a(PlpHeaderView.this) == null)
                {
                    return;
                } else
                {
                    PlpHeaderView.a(PlpHeaderView.this).a();
                    return;
                }
            }

            
            {
                this$0 = PlpHeaderView.this;
                super();
            }
        });
    }

    protected abstract int getLayoutId();

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

        case 2131756279: 
            mListener.a(mTitle);
            break;
        }
    }

    public void setClickListener(a a1)
    {
        mListener = a1;
    }

    public void setErrorHeaderData(ProductErrorHeaderOptions producterrorheaderoptions)
    {
        al.a(mViews.errorContainer, new View[] {
            mViews.storeLocationHeader
        });
        int i;
        if (producterrorheaderoptions.c().b())
        {
            mViews.errorContainer.a((com.target.ui.view.common.b.a)producterrorheaderoptions.c().c(), producterrorheaderoptions.b());
        } else
        {
            mViews.errorContainer.a((String)producterrorheaderoptions.d().d(), (String)producterrorheaderoptions.e().d(), producterrorheaderoptions.b());
        }
        if (producterrorheaderoptions.a())
        {
            i = mErrorHeaderHeightLarge;
        } else
        {
            i = mErrorHeaderHeightSmall;
        }
        mViews.errorContainer.setMinimumHeight(i);
    }

    public void setHeaderData(ProductHeaderOptions productheaderoptions)
    {
        if (productheaderoptions == null)
        {
            return;
        }
        al.a(mViews.storeLocationHeader, new View[] {
            mViews.errorContainer
        });
        if (productheaderoptions.a() != null)
        {
            mTitle = productheaderoptions.a();
            String s = String.format(getResources().getString(0x7f090461), new Object[] {
                productheaderoptions.a()
            });
            mViews.find.setText(s);
            al.b(mViews.find);
        } else
        {
            al.c(mViews.find);
        }
        if (productheaderoptions.c() != null)
        {
            String s1 = String.format(getResources().getString(0x7f090463), new Object[] {
                productheaderoptions.c()
            });
            mViews.inStore.setText(s1);
            al.b(mViews.inStore);
        } else
        {
            al.c(mViews.inStore);
        }
        if (productheaderoptions.b() != null)
        {
            mViews.aisle.setLocation(productheaderoptions.b());
            if (mViews.aisle.a())
            {
                al.c(mViews.aisle);
                return;
            } else
            {
                al.b(mViews.aisle);
                return;
            }
        } else
        {
            al.c(mViews.aisle);
            return;
        }
    }
}
