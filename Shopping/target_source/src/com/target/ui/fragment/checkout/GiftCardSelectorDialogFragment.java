// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.checkout;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.target.mothership.model.common.GiftCardTender;
import com.target.ui.adapter.checkout.GiftCardAdapter;
import com.target.ui.fragment.common.BaseDialogFragment;
import com.target.ui.util.al;
import com.target.ui.view.common.d;
import java.util.ArrayList;
import java.util.List;

public class GiftCardSelectorDialogFragment extends BaseDialogFragment
{
    static class Views
    {

        View giftCardListContainer;
        private a mListener;
        TextView messageTextView;
        RecyclerView myGiftCardListRecyclerView;
        View noGiftCardMessageContainer;
        View progressContainer;

        public void onApplyClick()
        {
            if (mListener != null)
            {
                mListener.b();
            }
        }

        public void onCancelClick()
        {
            if (mListener != null)
            {
                mListener.a();
            }
        }

        public void onNoGiftCardOkClick()
        {
            if (mListener != null)
            {
                mListener.c();
            }
        }

        public Views(View view, a a1)
        {
            ButterKnife.bind(this, view);
            mListener = a1;
        }
    }

    private static interface a
    {

        public abstract void a();

        public abstract void b();

        public abstract void c();
    }


    private static final String ARG_GIFT_CARD_LIST = "gift_card_list";
    private static final int MODE_CARD_LIST = 0;
    private static final int MODE_MESSAGE = 1;
    public static final String TAG = com/target/ui/fragment/checkout/GiftCardSelectorDialogFragment.getSimpleName();
    private GiftCardAdapter mAdapter;
    private a mButtonClickListener;
    private d mGiftCardActionListener;
    private List mGiftCardTenderList;
    private Views mViews;

    public GiftCardSelectorDialogFragment()
    {
        mButtonClickListener = new a() {

            final GiftCardSelectorDialogFragment this$0;

            public void a()
            {
                dismiss();
            }

            public void b()
            {
                dismiss();
                Object obj = GiftCardSelectorDialogFragment.a(GiftCardSelectorDialogFragment.this).e();
                if (GiftCardSelectorDialogFragment.b(GiftCardSelectorDialogFragment.this) != null && obj != null)
                {
                    obj = new com.target.mothership.model.cart.b.d(((GiftCardTender) (obj)).b(), ((GiftCardTender) (obj)).c());
                    GiftCardSelectorDialogFragment.b(GiftCardSelectorDialogFragment.this).a(((com.target.mothership.model.cart.b.d) (obj)), GiftCardSelectorDialogFragment.TAG);
                }
            }

            public void c()
            {
                dismiss();
            }

            
            {
                this$0 = GiftCardSelectorDialogFragment.this;
                super();
            }
        };
    }

    static GiftCardAdapter a(GiftCardSelectorDialogFragment giftcardselectordialogfragment)
    {
        return giftcardselectordialogfragment.mAdapter;
    }

    public static GiftCardSelectorDialogFragment a(List list, d d)
    {
        GiftCardSelectorDialogFragment giftcardselectordialogfragment = new GiftCardSelectorDialogFragment();
        Bundle bundle = new Bundle();
        if (list != null)
        {
            bundle.putParcelableArrayList("gift_card_list", new ArrayList(list));
        }
        giftcardselectordialogfragment.setArguments(bundle);
        giftcardselectordialogfragment.mGiftCardActionListener = d;
        return giftcardselectordialogfragment;
    }

    private void a()
    {
        if (mGiftCardTenderList == null)
        {
            a(0, true);
            return;
        }
        if (mGiftCardTenderList.isEmpty())
        {
            a(getString(0x7f09021c));
            return;
        } else
        {
            a(0, false);
            return;
        }
    }

    static d b(GiftCardSelectorDialogFragment giftcardselectordialogfragment)
    {
        return giftcardselectordialogfragment.mGiftCardActionListener;
    }

    public void a(int i, boolean flag)
    {
        boolean flag2 = true;
        View view = mViews.giftCardListContainer;
        boolean flag1;
        if (i == 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        al.a(view, flag1);
        view = mViews.noGiftCardMessageContainer;
        if (1 == i)
        {
            flag1 = flag2;
        } else
        {
            flag1 = false;
        }
        al.a(view, flag1);
        al.a(mViews.progressContainer, flag);
    }

    public void a(String s)
    {
        mViews.messageTextView.setText(s);
        a(1, false);
    }

    public void a(List list)
    {
        mGiftCardTenderList = list;
        if (mAdapter != null)
        {
            mAdapter.a(mGiftCardTenderList);
        }
        a();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mGiftCardTenderList = getArguments().getParcelableArrayList("gift_card_list");
        mAdapter = new GiftCardAdapter();
        mAdapter.a(mGiftCardTenderList);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f03003a, viewgroup, false);
        mViews = new Views(layoutinflater, mButtonClickListener);
        mViews.myGiftCardListRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mViews.myGiftCardListRecyclerView.setHasFixedSize(true);
        mViews.myGiftCardListRecyclerView.setAdapter(mAdapter);
        a();
        return layoutinflater;
    }

}
