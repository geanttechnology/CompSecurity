// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.cart;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.target.ui.adapter.b.c;
import com.target.ui.util.al;
import com.target.ui.view.BitmapImageView;

// Referenced classes of package com.target.ui.view.cart:
//            SavedForLaterOverflowView

public class SaveForLaterProductView extends LinearLayout
{
    static class Views extends com.target.ui.view.a
    {

        BitmapImageView image;
        TextView outOfStock;
        SavedForLaterOverflowView overflow;
        TextView price;
        TextView title;

        Views(View view)
        {
            super(view);
        }
    }

    public static interface a
    {

        public abstract void a();

        public abstract void a(BitmapImageView bitmapimageview);

        public abstract void b();
    }


    private a mListener;
    private android.view.View.OnClickListener mLocalClickListener = new android.view.View.OnClickListener() {

        final SaveForLaterProductView this$0;

        public void onClick(View view)
        {
            if (SaveForLaterProductView.a(SaveForLaterProductView.this) == null)
            {
                return;
            }
            switch (view.getId())
            {
            default:
                return;

            case 2131756429: 
            case 2131756430: 
                SaveForLaterProductView.a(SaveForLaterProductView.this).a(SaveForLaterProductView.b(SaveForLaterProductView.this).image);
                break;
            }
        }

            
            {
                this$0 = SaveForLaterProductView.this;
                super();
            }
    };
    private SavedForLaterOverflowView.a mLocalOverflowListener = new SavedForLaterOverflowView.a() {

        final SaveForLaterProductView this$0;

        public void a()
        {
            if (SaveForLaterProductView.a(SaveForLaterProductView.this) == null)
            {
                return;
            } else
            {
                SaveForLaterProductView.a(SaveForLaterProductView.this).b();
                return;
            }
        }

        public void b()
        {
            if (SaveForLaterProductView.a(SaveForLaterProductView.this) == null)
            {
                return;
            } else
            {
                SaveForLaterProductView.a(SaveForLaterProductView.this).a();
                return;
            }
        }

            
            {
                this$0 = SaveForLaterProductView.this;
                super();
            }
    };
    private Views mViews;

    public SaveForLaterProductView(Context context)
    {
        super(context);
        a(context);
    }

    public SaveForLaterProductView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a(context);
    }

    public SaveForLaterProductView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a(context);
    }

    static a a(SaveForLaterProductView saveforlaterproductview)
    {
        return saveforlaterproductview.mListener;
    }

    private void a(Context context)
    {
        setOrientation(0);
        setBackgroundColor(getResources().getColor(0x7f0f00f9));
        inflate(context, 0x7f0301e2, this);
        mViews = new Views(this);
        mViews.image.setOnClickListener(mLocalClickListener);
        mViews.title.setOnClickListener(mLocalClickListener);
        mViews.overflow.setSaveForLaterOverflowMenuListener(mLocalOverflowListener);
    }

    static Views b(SaveForLaterProductView saveforlaterproductview)
    {
        return saveforlaterproductview.mViews;
    }

    public void a(String s)
    {
        com.target.ui.adapter.b.c.a(getContext(), s, mViews.image);
    }

    public void a(boolean flag)
    {
        mViews.overflow.a(flag);
    }

    public void b(String s)
    {
        mViews.title.setText(s);
    }

    public void b(boolean flag)
    {
        al.a(mViews.outOfStock, flag);
    }

    public void c(String s)
    {
        mViews.price.setText(s);
    }

    public void setSaveForLaterProductViewListener(a a1)
    {
        mListener = a1;
    }
}
