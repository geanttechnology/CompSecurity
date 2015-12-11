// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.checkout;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.ButterKnife;

// Referenced classes of package com.target.ui.fragment.checkout:
//            GiftCardSelectorDialogFragment

static class mListener
{

    View giftCardListContainer;
    private mListener mListener;
    TextView messageTextView;
    RecyclerView myGiftCardListRecyclerView;
    View noGiftCardMessageContainer;
    View progressContainer;

    public void onApplyClick()
    {
        if (mListener != null)
        {
            mListener.mListener();
        }
    }

    public void onCancelClick()
    {
        if (mListener != null)
        {
            mListener.mListener();
        }
    }

    public void onNoGiftCardOkClick()
    {
        if (mListener != null)
        {
            mListener.mListener();
        }
    }

    public (View view,  )
    {
        ButterKnife.bind(this, view);
        mListener = ;
    }
}
