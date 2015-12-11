// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.content.Context;
import android.support.v7.widget.y;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import com.target.ui.common.ProductFulfillmentOptions;
import com.target.ui.view.BaseOverflowView;

public class PlpFulfillmentOverflowView extends BaseOverflowView
{
    public static interface a
    {

        public abstract void a();

        public abstract void b();

        public abstract void c();

        public abstract void d();

        public abstract void e();

        public abstract void f();
    }


    private a mListener;

    public PlpFulfillmentOverflowView(Context context)
    {
        super(context);
    }

    public PlpFulfillmentOverflowView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public PlpFulfillmentOverflowView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    static a a(PlpFulfillmentOverflowView plpfulfillmentoverflowview)
    {
        return plpfulfillmentoverflowview.mListener;
    }

    public void a(ProductFulfillmentOptions productfulfillmentoptions)
    {
        boolean flag1 = true;
        Object obj = getPopupMenu().a();
        MenuItem menuitem = ((Menu) (obj)).findItem(0x7f100070);
        boolean flag;
        if (productfulfillmentoptions.h() && productfulfillmentoptions.o())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        menuitem.setVisible(flag);
        menuitem = ((Menu) (obj)).findItem(0x7f100071);
        if (productfulfillmentoptions.a() && productfulfillmentoptions.i())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        menuitem.setVisible(flag);
        menuitem = ((Menu) (obj)).findItem(0x7f100073);
        if (productfulfillmentoptions.f() && productfulfillmentoptions.m())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        menuitem.setVisible(flag);
        menuitem = ((Menu) (obj)).findItem(0x7f100074);
        if (productfulfillmentoptions.d() && productfulfillmentoptions.k())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        menuitem.setVisible(flag);
        menuitem = ((Menu) (obj)).findItem(0x7f100075);
        if (productfulfillmentoptions.e() && productfulfillmentoptions.l())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        menuitem.setVisible(flag);
        obj = ((Menu) (obj)).findItem(0x7f100076);
        if (productfulfillmentoptions.b() && productfulfillmentoptions.j())
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        ((MenuItem) (obj)).setVisible(flag);
    }

    protected int getMenuResource()
    {
        return 0x7f120011;
    }

    protected android.support.v7.widget.y.b getOnMenuItemClickListener()
    {
        return new android.support.v7.widget.y.b() {

            final PlpFulfillmentOverflowView this$0;

            public boolean a(MenuItem menuitem)
            {
                if (PlpFulfillmentOverflowView.a(PlpFulfillmentOverflowView.this) == null)
                {
                    return false;
                }
                switch (menuitem.getItemId())
                {
                case 2131755122: 
                default:
                    return false;

                case 2131755120: 
                    PlpFulfillmentOverflowView.a(PlpFulfillmentOverflowView.this).a();
                    return false;

                case 2131755121: 
                    PlpFulfillmentOverflowView.a(PlpFulfillmentOverflowView.this).b();
                    return false;

                case 2131755123: 
                    PlpFulfillmentOverflowView.a(PlpFulfillmentOverflowView.this).c();
                    return false;

                case 2131755124: 
                    PlpFulfillmentOverflowView.a(PlpFulfillmentOverflowView.this).d();
                    return false;

                case 2131755125: 
                    PlpFulfillmentOverflowView.a(PlpFulfillmentOverflowView.this).e();
                    return false;

                case 2131755126: 
                    PlpFulfillmentOverflowView.a(PlpFulfillmentOverflowView.this).f();
                    break;
                }
                return false;
            }

            
            {
                this$0 = PlpFulfillmentOverflowView.this;
                super();
            }
        };
    }

    public void setListener(a a1)
    {
        mListener = a1;
    }
}
