// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.checkout;

import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import butterknife.ButterKnife;

// Referenced classes of package com.target.ui.adapter.checkout:
//            GiftCardAdapter

static class mListener extends android.support.v7.widget.lder
{
    static interface a
    {

        public abstract void a(int i);
    }


    TextView cardBalance;
    TextView cardNumber;
    private a mListener;
    RadioButton radioButton;

    public void onItemClicked()
    {
        if (mListener != null)
        {
            mListener.a(f());
        }
    }

    public void onRadioClicked()
    {
        onItemClicked();
    }

    public a(View view, a a1)
    {
        super(view);
        ButterKnife.bind(this, view);
        mListener = a1;
    }
}
