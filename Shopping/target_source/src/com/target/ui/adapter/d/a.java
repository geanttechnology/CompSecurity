// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.target.ui.adapter.b.e;
import com.target.ui.model.checkout.BillingCardDetailsModel;
import com.target.ui.model.checkout.CardDataModel;
import com.target.ui.model.checkout.PaymentCardInformationModel;
import com.target.ui.util.q;
import com.target.ui.util.u;
import com.target.ui.view.account.PaymentCardView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class com.target.ui.adapter.d.a extends e
{
    private final class a
    {

        final PaymentCardInformationModel cardData;
        final com.target.ui.adapter.d.a this$0;
        final c viewModel;

        private a(PaymentCardInformationModel paymentcardinformationmodel, c c1)
        {
            this$0 = com.target.ui.adapter.d.a.this;
            super();
            cardData = paymentcardinformationmodel;
            viewModel = c1;
        }

    }

    public static interface b
    {

        public abstract void a(PaymentCardInformationModel paymentcardinformationmodel);

        public abstract void b(PaymentCardInformationModel paymentcardinformationmodel);
    }

    private class c
        implements com.target.ui.view.account.PaymentCardView.b
    {

        private String addressLine;
        private com.target.mothership.common.tender.a cardType;
        private String last4Digits;
        final com.target.ui.adapter.d.a this$0;

        public String a()
        {
            return last4Digits;
        }

        public String b()
        {
            return addressLine;
        }

        public com.target.mothership.common.tender.a c()
        {
            return cardType;
        }

        c(String s, String s1, com.target.mothership.common.tender.a a2)
        {
            this$0 = com.target.ui.adapter.d.a.this;
            super();
            last4Digits = s;
            addressLine = s1;
            cardType = a2;
        }
    }

    private class d
    {

        final PaymentCardView card;
        int position;
        final com.target.ui.adapter.d.a this$0;

        d(PaymentCardView paymentcardview)
        {
            this$0 = com.target.ui.adapter.d.a.this;
            super();
            position = 0;
            card = paymentcardview;
        }
    }


    private static final int DEFAULT_SELECTION = 0;
    private static final int NO_SELECTION = -1;
    private static final String TAG = com/target/ui/adapter/d/a.getSimpleName();
    private List mCardList;
    private final com.target.ui.view.account.PaymentCardView.a mInternalActionListener;
    private b mListener;
    private int mSelectedPosition;
    private boolean mShowDefaultCard;
    private boolean mShowRadioButtons;

    public com.target.ui.adapter.d.a(Context context, List list, b b1)
    {
        this(context, list, b1, false, false);
    }

    public com.target.ui.adapter.d.a(Context context, List list, b b1, boolean flag, boolean flag1)
    {
        super(context, Collections.emptyList());
        mSelectedPosition = -1;
        mInternalActionListener = new com.target.ui.view.account.PaymentCardView.a() {

            final com.target.ui.adapter.d.a this$0;

            public void a(PaymentCardView paymentcardview)
            {
                if (com.target.ui.adapter.d.a.a(com.target.ui.adapter.d.a.this) != null)
                {
                    if ((paymentcardview = (d)u.a(paymentcardview.getTag(), com/target/ui/adapter/d/a$d)) != null)
                    {
                        com.target.ui.adapter.d.a.a(com.target.ui.adapter.d.a.this).a(((a)com.target.ui.adapter.d.a.b(com.target.ui.adapter.d.a.this).get(((d) (paymentcardview)).position)).cardData);
                        return;
                    }
                }
            }

            public void b(PaymentCardView paymentcardview)
            {
                paymentcardview = (d)u.a(paymentcardview.getTag(), com/target/ui/adapter/d/a$d);
                if (paymentcardview == null)
                {
                    q.a(com.target.ui.adapter.d.a.b(), (new StringBuilder()).append("Expected to find an instance of ").append(com/target/ui/adapter/d/a$d.getSimpleName()).append(" in ").append(com/target/ui/view/account/PaymentCardView.getSimpleName()).append(".getTag(), but found null instead").toString());
                } else
                {
                    int i = ((d) (paymentcardview)).position;
                    if (com.target.ui.adapter.d.a.c(com.target.ui.adapter.d.a.this) != i)
                    {
                        com.target.ui.adapter.d.a.a(com.target.ui.adapter.d.a.this, i);
                        if (com.target.ui.adapter.d.a.a(com.target.ui.adapter.d.a.this) != null)
                        {
                            com.target.ui.adapter.d.a.a(com.target.ui.adapter.d.a.this).b(com.target.ui.adapter.d.a.this.a(com.target.ui.adapter.d.a.c(com.target.ui.adapter.d.a.this)));
                        }
                        notifyDataSetChanged();
                        return;
                    }
                }
            }

            
            {
                this$0 = com.target.ui.adapter.d.a.this;
                super();
            }
        };
        mListener = b1;
        a(list);
        mShowRadioButtons = flag;
        mShowDefaultCard = flag1;
    }

    static int a(com.target.ui.adapter.d.a a1, int i)
    {
        a1.mSelectedPosition = i;
        return i;
    }

    static b a(com.target.ui.adapter.d.a a1)
    {
        return a1.mListener;
    }

    private c a(PaymentCardInformationModel paymentcardinformationmodel)
    {
        return new c(paymentcardinformationmodel.a().a().c(), com.target.ui.util.d.a.a(paymentcardinformationmodel.a().b()), paymentcardinformationmodel.a().a().a());
    }

    static String b()
    {
        return TAG;
    }

    static List b(com.target.ui.adapter.d.a a1)
    {
        return a1.mCardList;
    }

    static int c(com.target.ui.adapter.d.a a1)
    {
        return a1.mSelectedPosition;
    }

    public com.google.a.a.e a()
    {
        if (mSelectedPosition == -1)
        {
            return com.google.a.a.e.e();
        }
        if (mSelectedPosition >= mCardList.size() || mSelectedPosition < 0)
        {
            return com.google.a.a.e.e();
        } else
        {
            return com.google.a.a.e.b(((a)mCardList.get(mSelectedPosition)).cardData);
        }
    }

    public PaymentCardInformationModel a(int i)
    {
        return ((a)mCardList.get(i)).cardData;
    }

    public void a(List list)
    {
        boolean flag = false;
        mCardList = new ArrayList();
        for (int i = 0; i < list.size(); i++)
        {
            PaymentCardInformationModel paymentcardinformationmodel = (PaymentCardInformationModel)list.get(i);
            mCardList.add(new a(paymentcardinformationmodel, a(paymentcardinformationmodel)));
            if (paymentcardinformationmodel.b())
            {
                mSelectedPosition = i;
            }
        }

        if (mSelectedPosition == -1)
        {
            int j;
            if (list.size() > 0)
            {
                j = ((flag) ? 1 : 0);
            } else
            {
                j = -1;
            }
            mSelectedPosition = j;
        }
        notifyDataSetChanged();
    }

    public void a(boolean flag)
    {
        mShowRadioButtons = flag;
    }

    public void b(boolean flag)
    {
        mShowDefaultCard = flag;
    }

    public int getCount()
    {
        return mCardList.size();
    }

    public Object getItem(int i)
    {
        return a(i);
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        a a1 = (a)mCardList.get(i);
        PaymentCardView paymentcardview;
        boolean flag;
        if (view == null)
        {
            view = (PaymentCardView)mInflater.inflate(0x7f030181, viewgroup, false);
            view.setPaymentCardViewActionListener(mInternalActionListener);
            viewgroup = new d(view);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (d)view.getTag();
        }
        viewgroup.position = i;
        ((d) (viewgroup)).card.a(a1.viewModel);
        ((d) (viewgroup)).card.a(mShowRadioButtons);
        paymentcardview = ((d) (viewgroup)).card;
        if (i == mSelectedPosition)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        paymentcardview.setChecked(flag);
        if (mShowDefaultCard && a1.cardData.c())
        {
            ((d) (viewgroup)).card.a();
        }
        return view;
    }

}
