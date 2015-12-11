// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.target.mothership.model.cart.interfaces.a.c;
import com.target.mothership.model.common.AppliedGiftCardTender;
import com.target.ui.util.al;
import com.target.ui.util.e;
import com.target.ui.util.e.a;
import com.target.ui.view.common.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.ui.view.checkout:
//            GiftCardInputView, GiftCardAppliedView

public class GiftCardContainerView extends FrameLayout
{
    static class Views extends com.target.ui.view.a
    {

        LinearLayout giftCardContentView;
        GiftCardInputView inputView;
        View myGiftCardViewContainer;
        View progressBar;

        Views(View view)
        {
            super(view);
        }
    }

    public static interface a
    {

        public abstract void e();
    }


    private static final int NO_MARGIN = 0;
    public static final String TAG = com/target/ui/view/checkout/GiftCardContainerView.getSimpleName();
    private d mActionListener;
    private Handler mHandler;
    private int mLeftMargin;
    private boolean mShowMyGiftCardContainer;
    private int mTopMargin;
    private Views mViews;

    public GiftCardContainerView(Context context)
    {
        super(context);
        mViews = null;
        mHandler = new Handler();
        a(context);
    }

    public GiftCardContainerView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mViews = null;
        mHandler = new Handler();
        a(context);
    }

    public GiftCardContainerView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mViews = null;
        mHandler = new Handler();
        a(context);
    }

    static Views a(GiftCardContainerView giftcardcontainerview)
    {
        return giftcardcontainerview.mViews;
    }

    private void a(AppliedGiftCardTender appliedgiftcardtender)
    {
        mViews.inputView.a(false);
        mViews.inputView.b();
        final GiftCardAppliedView appliedView = b();
        appliedView.setRemovalListener(mActionListener);
        mHandler.post(new Runnable() {

            final GiftCardContainerView this$0;
            final GiftCardAppliedView val$appliedView;

            public void run()
            {
                if (com.target.ui.view.checkout.GiftCardContainerView.a(GiftCardContainerView.this) != null)
                {
                    com.target.ui.view.checkout.GiftCardContainerView.a(GiftCardContainerView.this).giftCardContentView.addView(appliedView, 1);
                }
            }

            
            {
                this$0 = GiftCardContainerView.this;
                appliedView = giftcardappliedview;
                super();
            }
        });
        appliedView.a(appliedgiftcardtender);
    }

    private void a(boolean flag, int i)
    {
        if (flag)
        {
            com.target.ui.util.e.a.a(mViews.inputView);
            al.a(new View[] {
                mViews.inputView, mViews.myGiftCardViewContainer
            });
            mShowMyGiftCardContainer = false;
            c(true);
            return;
        }
        if (e.a(i))
        {
            com.target.ui.util.e.a.a(mViews.inputView);
            al.a(new View[] {
                mViews.inputView, mViews.myGiftCardViewContainer
            });
            mShowMyGiftCardContainer = false;
            c(true);
            return;
        } else
        {
            al.b(mViews.inputView);
            al.a(mViews.myGiftCardViewContainer, mShowMyGiftCardContainer);
            c(false);
            return;
        }
    }

    private GiftCardAppliedView b()
    {
        return (GiftCardAppliedView)((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f030131, this, false);
    }

    private void c()
    {
        Object obj = new ArrayList();
        int j = mViews.giftCardContentView.getChildCount();
        for (int i = 0; i < j; i++)
        {
            View view = mViews.giftCardContentView.getChildAt(i);
            if (view instanceof GiftCardAppliedView)
            {
                ((List) (obj)).add(view);
            }
        }

        View view1;
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); mViews.giftCardContentView.removeView(view1))
        {
            view1 = (View)((Iterator) (obj)).next();
        }

    }

    private void c(boolean flag)
    {
        android.widget.FrameLayout.LayoutParams layoutparams;
        int i;
        if (flag)
        {
            i = mTopMargin;
        } else
        {
            i = 0;
        }
        layoutparams = new android.widget.FrameLayout.LayoutParams(-1, -2);
        layoutparams.setMargins(mLeftMargin, i, 0, 0);
        mViews.giftCardContentView.setLayoutParams(layoutparams);
    }

    public void a()
    {
        a(false);
    }

    public void a(Context context)
    {
        inflate(context, 0x7f030132, this);
        mViews = new Views(this);
        mTopMargin = getResources().getDimensionPixelSize(0x7f0a0107);
        mLeftMargin = context.getResources().getDimensionPixelSize(0x7f0a011b);
    }

    public void a(c c1)
    {
        a(false);
        c1 = (com.target.mothership.model.cart.interfaces.a.c.a)c1.e();
        mViews.inputView.b(e.a(getContext(), c1));
        mViews.inputView.a();
    }

    public void a(String s)
    {
        mViews.inputView.a(s);
    }

    public void a(List list, boolean flag, boolean flag1)
    {
        a(false);
        mShowMyGiftCardContainer = flag1;
        c();
        a(flag, list.size());
        for (list = list.iterator(); list.hasNext(); a((AppliedGiftCardTender)list.next())) { }
    }

    public void a(boolean flag)
    {
        if (flag)
        {
            bringChildToFront(mViews.progressBar);
            mViews.giftCardContentView.setEnabled(false);
            mViews.inputView.setEnabled(false);
            mViews.inputView.clearFocus();
            al.b(mViews.progressBar);
            return;
        } else
        {
            al.c(mViews.progressBar);
            mViews.giftCardContentView.setEnabled(true);
            mViews.inputView.setEnabled(true);
            mViews.inputView.a();
            return;
        }
    }

    public void b(boolean flag)
    {
        mShowMyGiftCardContainer = flag;
        al.a(mViews.myGiftCardViewContainer, flag);
    }

    public void setGiftCardActionListener(d d)
    {
        mActionListener = d;
        mViews.inputView.setGiftCardActionListener(mActionListener);
    }

    public void setMyGiftCardActionListener(final a listener)
    {
        mViews.myGiftCardViewContainer.setOnClickListener(new android.view.View.OnClickListener() {

            final GiftCardContainerView this$0;
            final a val$listener;

            public void onClick(View view)
            {
                if (listener != null)
                {
                    listener.e();
                }
            }

            
            {
                this$0 = GiftCardContainerView.this;
                listener = a1;
                super();
            }
        });
    }

}
