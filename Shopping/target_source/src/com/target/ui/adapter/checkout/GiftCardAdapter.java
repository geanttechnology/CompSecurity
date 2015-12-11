// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.checkout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.target.mothership.model.common.GiftCardTender;
import com.target.ui.util.d.a;
import com.target.ui.util.d.b;
import java.util.List;

public class GiftCardAdapter extends android.support.v7.widget.RecyclerView.a
{
    static class ViewHolder extends android.support.v7.widget.RecyclerView.t
    {

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

        public ViewHolder(View view, a a1)
        {
            super(view);
            ButterKnife.bind(this, view);
            mListener = a1;
        }
    }

    static interface ViewHolder.a
    {

        public abstract void a(int i);
    }


    private List mGiftCardTenderList;
    private ViewHolder.a mItemClickListener;
    private int mSelectedPosition;

    public GiftCardAdapter()
    {
        mSelectedPosition = 0;
        mItemClickListener = new ViewHolder.a() {

            final GiftCardAdapter this$0;

            public void a(int i)
            {
                com.target.ui.adapter.checkout.GiftCardAdapter.a(GiftCardAdapter.this, i);
                d();
            }

            
            {
                this$0 = GiftCardAdapter.this;
                super();
            }
        };
    }

    static int a(GiftCardAdapter giftcardadapter, int i)
    {
        giftcardadapter.mSelectedPosition = i;
        return i;
    }

    public int a()
    {
        if (mGiftCardTenderList == null)
        {
            return 0;
        } else
        {
            return mGiftCardTenderList.size();
        }
    }

    public android.support.v7.widget.RecyclerView.t a(ViewGroup viewgroup, int i)
    {
        return c(viewgroup, i);
    }

    public volatile void a(android.support.v7.widget.RecyclerView.t t, int i)
    {
        a((ViewHolder)t, i);
    }

    public void a(ViewHolder viewholder, int i)
    {
        Object obj = (GiftCardTender)mGiftCardTenderList.get(i);
        Object obj1 = viewholder.radioButton;
        boolean flag;
        if (mSelectedPosition == i)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ((RadioButton) (obj1)).setChecked(flag);
        obj1 = b.b(((GiftCardTender) (obj)).b());
        viewholder.cardNumber.setText(((CharSequence) (obj1)));
        obj = com.target.ui.util.d.a.a(((GiftCardTender) (obj)).d());
        viewholder.cardBalance.setText(((CharSequence) (obj)));
    }

    public void a(List list)
    {
        mGiftCardTenderList = list;
        d();
    }

    public ViewHolder c(ViewGroup viewgroup, int i)
    {
        return new ViewHolder(LayoutInflater.from(viewgroup.getContext()).inflate(0x7f030134, viewgroup, false), mItemClickListener);
    }

    public GiftCardTender e()
    {
        if (mGiftCardTenderList == null || mSelectedPosition >= mGiftCardTenderList.size())
        {
            return null;
        } else
        {
            return (GiftCardTender)mGiftCardTenderList.get(mSelectedPosition);
        }
    }
}
