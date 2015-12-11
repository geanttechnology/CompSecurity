// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintreepayments.api.dropin;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.ViewStub;

// Referenced classes of package com.braintreepayments.api.dropin:
//            BraintreePaymentActivity

final class mCurrentView extends Enum
{

    private static final CARD_FORM $VALUES[];
    public static final CARD_FORM CARD_FORM;
    public static final CARD_FORM LOADING_VIEW;
    public static final CARD_FORM SELECT_VIEW;
    private static int mAnimationDuration;
    private boolean mCurrentView;
    private final int mInflatedViewId;
    private final int mStubbedViewId;

    private long getDuration(Context context)
    {
        if (mAnimationDuration == 0)
        {
            mAnimationDuration = context.getResources().getInteger(0x10e0000);
        }
        return (long)mAnimationDuration;
    }

    public static mAnimationDuration valueOf(String s)
    {
        return (mAnimationDuration)Enum.valueOf(com/braintreepayments/api/dropin/BraintreePaymentActivity$StubbedView, s);
    }

    public static mAnimationDuration[] values()
    {
        return (mAnimationDuration[])$VALUES.clone();
    }

    final void hide(BraintreePaymentActivity braintreepaymentactivity)
    {
        if ((ViewStub)BraintreePaymentActivity.access$200(braintreepaymentactivity, mStubbedViewId) == null)
        {
            BraintreePaymentActivity.access$200(braintreepaymentactivity, mInflatedViewId).setVisibility(8);
        }
        mCurrentView = false;
    }

    final View inflateOrFind(BraintreePaymentActivity braintreepaymentactivity)
    {
        ViewStub viewstub = (ViewStub)BraintreePaymentActivity.access$200(braintreepaymentactivity, mStubbedViewId);
        if (viewstub != null)
        {
            return viewstub.inflate();
        } else
        {
            return BraintreePaymentActivity.access$200(braintreepaymentactivity, mInflatedViewId);
        }
    }

    final View show(BraintreePaymentActivity braintreepaymentactivity)
    {
        mInflatedViewId aminflatedviewid[] = values();
        int j = aminflatedviewid.length;
        for (int i = 0; i < j; i++)
        {
            mInflatedViewId minflatedviewid = aminflatedviewid[i];
            if (this != minflatedviewid)
            {
                minflatedviewid.hide(braintreepaymentactivity);
            }
        }

        View view = inflateOrFind(braintreepaymentactivity);
        if (android.os.tActivity >= 12)
        {
            view.setAlpha(0.0F);
            view.setVisibility(0);
            view.animate().alpha(1.0F).setDuration(getDuration(braintreepaymentactivity));
        } else
        {
            view.setVisibility(0);
        }
        mCurrentView = true;
        return view;
    }

    static 
    {
        LOADING_VIEW = new <init>("LOADING_VIEW", 0, <init>, <init>);
        SELECT_VIEW = new <init>("SELECT_VIEW", 1, <init>, );
        CARD_FORM = new <init>("CARD_FORM", 2, <init>, <init>);
        $VALUES = (new .VALUES[] {
            LOADING_VIEW, SELECT_VIEW, CARD_FORM
        });
    }


    private (String s, int i, int j, int k)
    {
        super(s, i);
        mStubbedViewId = j;
        mInflatedViewId = k;
        mCurrentView = false;
    }
}
