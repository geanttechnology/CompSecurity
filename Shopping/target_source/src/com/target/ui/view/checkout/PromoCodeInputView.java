// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.target.mothership.util.o;
import com.target.ui.util.al;
import com.target.ui.util.e.a;
import com.target.ui.util.q;
import com.target.ui.view.CustomErrorViewWrapper;

// Referenced classes of package com.target.ui.view.checkout:
//            g

public class PromoCodeInputView extends LinearLayout
{
    static class Views extends com.target.ui.view.a
    {

        Button applyButton;
        ProgressBar progressBar;
        View progressContainer;
        CustomErrorViewWrapper promoCodeError;
        EditText promoCodeText;

        Views(View view)
        {
            super(view);
        }
    }


    private static final String TAG = com/target/ui/view/checkout/PromoCodeInputView.getSimpleName();
    private final android.view.View.OnClickListener mApplyClickListener;
    private g mListener;
    private final TextWatcher mPromoCodeTextWatcher;
    private Views mViews;

    public PromoCodeInputView(Context context)
    {
        super(context);
        mApplyClickListener = new android.view.View.OnClickListener() {

            final PromoCodeInputView this$0;

            public void onClick(View view)
            {
                com.target.ui.view.checkout.PromoCodeInputView.a(PromoCodeInputView.this);
            }

            
            {
                this$0 = PromoCodeInputView.this;
                super();
            }
        };
        mPromoCodeTextWatcher = new TextWatcher() {

            final PromoCodeInputView this$0;

            public void afterTextChanged(Editable editable)
            {
                PromoCodeInputView.b(PromoCodeInputView.this).promoCodeError.b();
                if (editable.length() == 0)
                {
                    com.target.ui.view.checkout.PromoCodeInputView.a(PromoCodeInputView.this, false);
                    return;
                } else
                {
                    com.target.ui.view.checkout.PromoCodeInputView.a(PromoCodeInputView.this, true);
                    return;
                }
            }

            public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
            {
            }

            public void onTextChanged(CharSequence charsequence, int i, int j, int k)
            {
            }

            
            {
                this$0 = PromoCodeInputView.this;
                super();
            }
        };
        a(context);
    }

    public PromoCodeInputView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mApplyClickListener = new _cls1();
        mPromoCodeTextWatcher = new _cls2();
        a(context);
    }

    public PromoCodeInputView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mApplyClickListener = new _cls1();
        mPromoCodeTextWatcher = new _cls2();
        a(context);
    }

    static void a(PromoCodeInputView promocodeinputview)
    {
        promocodeinputview.b();
    }

    static void a(PromoCodeInputView promocodeinputview, boolean flag)
    {
        promocodeinputview.b(flag);
    }

    public static int b(com.target.mothership.model.cart.interfaces.a.e.a a1)
    {
        static class _cls3
        {

            static final int $SwitchMap$com$target$mothership$model$cart$interfaces$error$ApplyPromoCodeFailure$ApplyPromoCodeFailureReason[];
            static final int $SwitchMap$com$target$mothership$model$cart$interfaces$error$ApplyTeamMemberDiscountFailure$ApplyTeamMemberDiscountFailureReason[];

            static 
            {
                $SwitchMap$com$target$mothership$model$cart$interfaces$error$ApplyTeamMemberDiscountFailure$ApplyTeamMemberDiscountFailureReason = new int[com.target.mothership.model.cart.interfaces.a.g.a.values().length];
                try
                {
                    $SwitchMap$com$target$mothership$model$cart$interfaces$error$ApplyTeamMemberDiscountFailure$ApplyTeamMemberDiscountFailureReason[com.target.mothership.model.cart.interfaces.a.g.a.ERR_TEAM_MEMBER_DISCOUNT_ALREADY_APPLIED.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$target$mothership$model$cart$interfaces$error$ApplyTeamMemberDiscountFailure$ApplyTeamMemberDiscountFailureReason[com.target.mothership.model.cart.interfaces.a.g.a.ERR_TEAM_MEMBER_NUMBER_INVALID.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                $SwitchMap$com$target$mothership$model$cart$interfaces$error$ApplyPromoCodeFailure$ApplyPromoCodeFailureReason = new int[com.target.mothership.model.cart.interfaces.a.e.a.values().length];
                try
                {
                    $SwitchMap$com$target$mothership$model$cart$interfaces$error$ApplyPromoCodeFailure$ApplyPromoCodeFailureReason[com.target.mothership.model.cart.interfaces.a.e.a.ERR_PROMO_CODE_DUPLICATE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$mothership$model$cart$interfaces$error$ApplyPromoCodeFailure$ApplyPromoCodeFailureReason[com.target.mothership.model.cart.interfaces.a.e.a.ERR_PROMO_CODE_NOT_ELIGIBLE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls3..SwitchMap.com.target.mothership.model.cart.interfaces.error.ApplyPromoCodeFailure.ApplyPromoCodeFailureReason[a1.ordinal()])
        {
        default:
            return 0x7f09022e;

        case 1: // '\001'
            return 0x7f09022d;

        case 2: // '\002'
            return 0x7f090230;
        }
    }

    static Views b(PromoCodeInputView promocodeinputview)
    {
        return promocodeinputview.mViews;
    }

    private void b()
    {
        com.target.ui.util.e.a.a(mViews.promoCodeText);
        if (mListener != null)
        {
            String s = mViews.promoCodeText.getText().toString();
            mListener.d(s);
        }
    }

    private void b(boolean flag)
    {
        if (flag)
        {
            al.b(mViews.applyButton);
            mViews.applyButton.setEnabled(true);
            return;
        } else
        {
            al.c(mViews.applyButton);
            mViews.applyButton.setEnabled(false);
            return;
        }
    }

    public void a()
    {
        mViews.promoCodeText.getText().clear();
    }

    public void a(Context context)
    {
        inflate(context, 0x7f03013d, this);
        mViews = new Views(this);
        mViews.applyButton.setOnClickListener(mApplyClickListener);
        mViews.promoCodeText.addTextChangedListener(mPromoCodeTextWatcher);
    }

    public void a(com.target.mothership.model.cart.interfaces.a.e.a a1)
    {
        if (a1 == null)
        {
            q.a(TAG, "Can't display a null ApplyPromoCodeFailureReason");
            return;
        } else
        {
            mViews.promoCodeError.setErrorState(getContext().getString(b(a1)));
            return;
        }
    }

    public void a(com.target.mothership.model.cart.interfaces.a.g.a a1)
    {
        if (a1 == null)
        {
            q.a(TAG, "Can't display a null ApplyTeamMemberDiscountFailureReason");
            return;
        }
        switch (_cls3..SwitchMap.com.target.mothership.model.cart.interfaces.error.ApplyTeamMemberDiscountFailure.ApplyTeamMemberDiscountFailureReason[a1.ordinal()])
        {
        default:
            mViews.promoCodeError.setErrorState(getContext().getString(0x7f09022e));
            return;

        case 1: // '\001'
            mViews.promoCodeError.setErrorState(getContext().getString(0x7f09022d));
            return;

        case 2: // '\002'
            mViews.promoCodeError.setErrorState(getContext().getString(0x7f090230));
            break;
        }
    }

    public void a(boolean flag)
    {
        if (flag)
        {
            al.a(mViews.progressBar, new View[] {
                mViews.applyButton
            });
            mViews.applyButton.setEnabled(false);
            mViews.promoCodeText.setEnabled(false);
            return;
        }
        al.c(mViews.progressBar);
        mViews.applyButton.setEnabled(true);
        mViews.promoCodeText.setEnabled(true);
        if (o.g(mViews.promoCodeText.getText().toString()))
        {
            al.b(mViews.applyButton);
            return;
        } else
        {
            al.c(mViews.applyButton);
            return;
        }
    }

    public void setPromoCodeInputListener(g g1)
    {
        mListener = g1;
    }

}
