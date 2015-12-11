// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.mcoupons;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MenuItem;
import com.target.ui.view.BaseOverflowView;

public class CouponsOverflowView extends BaseOverflowView
{
    public static interface a
    {

        public abstract void a();
    }


    private a mListener;

    public CouponsOverflowView(Context context)
    {
        super(context);
    }

    public CouponsOverflowView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public CouponsOverflowView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    static a a(CouponsOverflowView couponsoverflowview)
    {
        return couponsoverflowview.mListener;
    }

    protected int getMenuResource()
    {
        return 0x7f120006;
    }

    protected android.support.v7.widget.y.b getOnMenuItemClickListener()
    {
        return new android.support.v7.widget.y.b() {

            final CouponsOverflowView this$0;

            public boolean a(MenuItem menuitem)
            {
                if (CouponsOverflowView.a(CouponsOverflowView.this) == null)
                {
                    return false;
                }
                switch (menuitem.getItemId())
                {
                default:
                    return false;

                case 2131756547: 
                    CouponsOverflowView.a(CouponsOverflowView.this).a();
                    break;
                }
                return false;
            }

            
            {
                this$0 = CouponsOverflowView.this;
                super();
            }
        };
    }

    public void setListener(a a1)
    {
        mListener = a1;
    }
}
