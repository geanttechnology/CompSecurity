// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.cart;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MenuItem;
import com.target.ui.view.BaseOverflowView;

public class SavedForLaterOverflowView extends BaseOverflowView
{
    public static interface a
    {

        public abstract void a();

        public abstract void b();
    }


    private a mListener;
    private boolean mShowingOutOfStockMenu;

    public SavedForLaterOverflowView(Context context)
    {
        super(context);
        mShowingOutOfStockMenu = false;
    }

    public SavedForLaterOverflowView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mShowingOutOfStockMenu = false;
    }

    public SavedForLaterOverflowView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mShowingOutOfStockMenu = false;
    }

    static a a(SavedForLaterOverflowView savedforlateroverflowview)
    {
        return savedforlateroverflowview.mListener;
    }

    public void a(boolean flag)
    {
        if (flag == mShowingOutOfStockMenu)
        {
            return;
        }
        mShowingOutOfStockMenu = flag;
        if (flag)
        {
            a(0x7f120015);
            return;
        } else
        {
            a(0x7f120014);
            return;
        }
    }

    protected int getMenuResource()
    {
        return 0x7f120014;
    }

    protected android.support.v7.widget.y.b getOnMenuItemClickListener()
    {
        return new android.support.v7.widget.y.b() {

            final SavedForLaterOverflowView this$0;

            public boolean a(MenuItem menuitem)
            {
                if (SavedForLaterOverflowView.a(SavedForLaterOverflowView.this) == null)
                {
                    throw new IllegalStateException((new StringBuilder()).append("must set a listener on ").append(com/target/ui/view/cart/SavedForLaterOverflowView.getSimpleName()).toString());
                }
                switch (menuitem.getItemId())
                {
                default:
                    return false;

                case 2131756561: 
                    SavedForLaterOverflowView.a(SavedForLaterOverflowView.this).a();
                    return true;

                case 2131756562: 
                    SavedForLaterOverflowView.a(SavedForLaterOverflowView.this).b();
                    break;
                }
                return true;
            }

            
            {
                this$0 = SavedForLaterOverflowView.this;
                super();
            }
        };
    }

    public void setSaveForLaterOverflowMenuListener(a a1)
    {
        mListener = a1;
    }
}
