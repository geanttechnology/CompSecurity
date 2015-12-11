// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.cart;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MenuItem;
import com.target.ui.view.BaseOverflowView;

public class CartItemOverflowView extends BaseOverflowView
{
    public static interface a
    {

        public abstract void a(CartItemOverflowView cartitemoverflowview);

        public abstract void b(CartItemOverflowView cartitemoverflowview);
    }


    private a mListener;

    public CartItemOverflowView(Context context)
    {
        super(context);
    }

    public CartItemOverflowView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public CartItemOverflowView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    static a a(CartItemOverflowView cartitemoverflowview)
    {
        return cartitemoverflowview.mListener;
    }

    protected int getMenuResource()
    {
        return 0x7f120002;
    }

    protected android.support.v7.widget.y.b getOnMenuItemClickListener()
    {
        return new android.support.v7.widget.y.b() {

            final CartItemOverflowView this$0;

            public boolean a(MenuItem menuitem)
            {
                if (CartItemOverflowView.a(CartItemOverflowView.this) == null)
                {
                    throw new IllegalStateException((new StringBuilder()).append("must set a listener on ").append(com/target/ui/view/cart/CartItemOverflowView.getSimpleName()).toString());
                }
                switch (menuitem.getItemId())
                {
                default:
                    return false;

                case 2131756542: 
                    CartItemOverflowView.a(CartItemOverflowView.this).a(CartItemOverflowView.this);
                    return true;

                case 2131756541: 
                    CartItemOverflowView.a(CartItemOverflowView.this).b(CartItemOverflowView.this);
                    return true;
                }
            }

            
            {
                this$0 = CartItemOverflowView.this;
                super();
            }
        };
    }

    public void setCartItemOverflowListener(a a1)
    {
        mListener = a1;
    }
}
