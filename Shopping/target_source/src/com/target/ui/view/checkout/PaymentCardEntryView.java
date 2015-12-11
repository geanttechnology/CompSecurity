// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.target.mothership.common.tender.a;
import com.target.mothership.util.o;
import com.target.ui.model.checkout.TGTCardDataModel;
import com.target.ui.util.al;
import com.target.ui.util.d.b;
import com.target.ui.util.e;
import com.target.ui.util.q;
import com.target.ui.util.validation.d;
import com.target.ui.view.BackSpaceDetectorEditText;
import com.target.ui.view.CustomErrorViewWrapper;

// Referenced classes of package com.target.ui.view.checkout:
//            f

public class PaymentCardEntryView extends LinearLayout
{
    static class Views extends com.target.ui.view.a
    {

        ImageView cardImg;
        EditText cardText;
        CustomErrorViewWrapper cardTextWrapper;
        BackSpaceDetectorEditText expiryText;
        EditText lastCardText;
        CustomErrorViewWrapper pinAndCvvWrapper;
        ImageView scanCardImageView;
        BackSpaceDetectorEditText securityCodeText;

        Views(View view)
        {
            super(view);
        }
    }

    public static interface a
    {

        public abstract void a();

        public abstract void a(com.target.mothership.common.tender.a a1, String s, String s1, String s2, String s3);
    }

    private final class b extends com.target.ui.k.b
    {

        String before;
        final PaymentCardEntryView this$0;

        public void a(Editable editable)
        {
            editable = editable.toString();
            if (o.g(PaymentCardEntryView.f(PaymentCardEntryView.this)) && PaymentCardEntryView.f(PaymentCardEntryView.this).length() >= 4)
            {
                Object obj = new StringBuilder(PaymentCardEntryView.f(PaymentCardEntryView.this));
                ((StringBuilder) (obj)).replace(PaymentCardEntryView.f(PaymentCardEntryView.this).length() - 4, PaymentCardEntryView.f(PaymentCardEntryView.this).length(), editable);
                Object obj1 = com.target.ui.util.d.b.b(PaymentCardEntryView.f(PaymentCardEntryView.this), ((StringBuilder) (obj)).toString());
                obj = com.target.ui.util.validation.d.b(((com.target.ui.util.d.a.b) (obj1)).noFormattingString);
                boolean flag = com.target.ui.view.checkout.PaymentCardEntryView.a(PaymentCardEntryView.this, ((com.target.ui.util.validation.a.c) (obj)).cardTypeGuess);
                com.target.ui.view.checkout.PaymentCardEntryView.e(PaymentCardEntryView.this).a(((com.target.ui.util.d.a.b) (obj1)).noFormattingString);
                com.target.ui.view.checkout.PaymentCardEntryView.e(PaymentCardEntryView.this).b(com.target.ui.util.d.b.a(((com.target.ui.util.d.a.b) (obj1)).noFormattingString));
                if (flag)
                {
                    com.target.ui.util.e.a(((com.target.ui.util.validation.a.c) (obj)).cardTypeGuess, com.target.ui.view.checkout.PaymentCardEntryView.a(PaymentCardEntryView.this).cardImg);
                }
                obj1 = PaymentCardEntryView.c(PaymentCardEntryView.this);
                if (!((com.target.ui.util.validation.a.c) (obj)).isValid)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                obj1.hasCardError = flag;
                com.target.ui.view.checkout.PaymentCardEntryView.a(PaymentCardEntryView.this, ((com.target.ui.util.validation.a.c) (obj)).isValid);
                com.target.ui.view.checkout.PaymentCardEntryView.a(PaymentCardEntryView.this, PaymentCardEntryView.c(PaymentCardEntryView.this));
            }
            if (editable.length() == 4)
            {
                if (com.target.ui.util.e.a(com.target.ui.view.checkout.PaymentCardEntryView.e(PaymentCardEntryView.this).a()))
                {
                    com.target.ui.view.checkout.PaymentCardEntryView.a(PaymentCardEntryView.this).expiryText.requestFocus();
                } else
                {
                    com.target.ui.view.checkout.PaymentCardEntryView.a(PaymentCardEntryView.this).securityCodeText.requestFocus();
                }
            }
            if (o.f(before) && o.c(editable))
            {
                com.target.ui.view.checkout.PaymentCardEntryView.a(PaymentCardEntryView.this, null);
                PaymentCardEntryView.g(PaymentCardEntryView.this);
            }
        }

        public void a(CharSequence charsequence, int k, int l, int i1)
        {
            before = charsequence.toString();
        }

        public void b(CharSequence charsequence, int k, int l, int i1)
        {
        }

        private b()
        {
            this$0 = PaymentCardEntryView.this;
            super();
        }

    }

    private final class c extends com.target.ui.k.b
    {

        String before;
        final PaymentCardEntryView this$0;

        public void a(Editable editable)
        {
            editable = editable.toString();
            if (!o.c(editable))
            {
                editable = com.target.ui.util.d.b.b(before, editable);
                com.target.ui.util.validation.a.c c1 = com.target.ui.util.validation.d.b(((com.target.ui.util.d.a.b) (editable)).noFormattingString);
                boolean flag = com.target.ui.view.checkout.PaymentCardEntryView.a(PaymentCardEntryView.this, c1.cardTypeGuess);
                com.target.ui.view.checkout.PaymentCardEntryView.e(PaymentCardEntryView.this).a(((com.target.ui.util.d.a.b) (editable)).noFormattingString);
                com.target.ui.view.checkout.PaymentCardEntryView.e(PaymentCardEntryView.this).b(com.target.ui.util.d.b.a(((com.target.ui.util.d.a.b) (editable)).noFormattingString));
                if (flag)
                {
                    com.target.ui.util.e.a(c1.cardTypeGuess, com.target.ui.view.checkout.PaymentCardEntryView.a(PaymentCardEntryView.this).cardImg);
                }
                com.target.ui.view.checkout.PaymentCardEntryView.a(PaymentCardEntryView.this, c1.isValid);
                if (c1.isValid)
                {
                    com.target.ui.view.checkout.PaymentCardEntryView.a(PaymentCardEntryView.this, ((com.target.ui.util.d.a.b) (editable)).noFormattingString);
                    com.target.ui.view.checkout.PaymentCardEntryView.b(PaymentCardEntryView.this, c1.cardTypeGuess);
                    com.target.ui.view.checkout.PaymentCardEntryView.a(PaymentCardEntryView.this).cardTextWrapper.b();
                    return;
                }
                if (com.target.ui.util.validation.g.a(c1, com.target.ui.view.checkout.PaymentCardEntryView.a(PaymentCardEntryView.this).cardText, com.target.ui.view.checkout.PaymentCardEntryView.a(PaymentCardEntryView.this).cardTextWrapper))
                {
                    com.target.ui.view.checkout.PaymentCardEntryView.a(PaymentCardEntryView.this).cardTextWrapper.setErrorState(getContext().getString(0x7f090212));
                }
                if (((com.target.ui.util.d.a.b) (editable)).wasFormattingNeeded)
                {
                    com.target.ui.view.checkout.PaymentCardEntryView.a(PaymentCardEntryView.this).cardText.setText(((com.target.ui.util.d.a.b) (editable)).formattingAppliedString);
                    com.target.ui.view.checkout.PaymentCardEntryView.a(PaymentCardEntryView.this).cardText.setSelection(com.target.ui.view.checkout.PaymentCardEntryView.a(PaymentCardEntryView.this).cardText.length());
                    return;
                }
            }
        }

        public void a(CharSequence charsequence, int k, int l, int i1)
        {
            before = charsequence.toString();
        }

        public void b(CharSequence charsequence, int k, int l, int i1)
        {
        }

        private c()
        {
            this$0 = PaymentCardEntryView.this;
            super();
        }

    }

    private final class d
        implements com.target.ui.view.BackSpaceDetectorEditText.a
    {

        final PaymentCardEntryView this$0;

        public void a(BackSpaceDetectorEditText backspacedetectoredittext)
        {
            if (backspacedetectoredittext != null && com.target.ui.view.checkout.PaymentCardEntryView.a(PaymentCardEntryView.this) != null) goto _L2; else goto _L1
_L1:
            return;
_L2:
            backspacedetectoredittext.getId();
            JVM INSTR tableswitch 2131755963 2131755964: default 40
        //                       2131755963 41
        //                       2131755964 95;
               goto _L3 _L4 _L5
_L5:
            continue; /* Loop/switch isn't completed */
_L3:
            return;
_L4:
            if (!o.e(backspacedetectoredittext.getText().toString())) goto _L1; else goto _L6
_L6:
            com.target.ui.view.checkout.PaymentCardEntryView.a(PaymentCardEntryView.this).lastCardText.setSelection(com.target.ui.view.checkout.PaymentCardEntryView.a(PaymentCardEntryView.this).lastCardText.length());
            com.target.ui.view.checkout.PaymentCardEntryView.a(PaymentCardEntryView.this).lastCardText.requestFocus();
            return;
            if (!o.e(backspacedetectoredittext.getText().toString())) goto _L1; else goto _L7
_L7:
            if (com.target.ui.util.e.a(com.target.ui.view.checkout.PaymentCardEntryView.e(PaymentCardEntryView.this).a()))
            {
                com.target.ui.view.checkout.PaymentCardEntryView.a(PaymentCardEntryView.this).expiryText.setSelection(com.target.ui.view.checkout.PaymentCardEntryView.a(PaymentCardEntryView.this).expiryText.length());
                com.target.ui.view.checkout.PaymentCardEntryView.a(PaymentCardEntryView.this).expiryText.requestFocus();
                return;
            } else
            {
                com.target.ui.view.checkout.PaymentCardEntryView.a(PaymentCardEntryView.this).lastCardText.setSelection(com.target.ui.view.checkout.PaymentCardEntryView.a(PaymentCardEntryView.this).lastCardText.length());
                com.target.ui.view.checkout.PaymentCardEntryView.a(PaymentCardEntryView.this).lastCardText.requestFocus();
                return;
            }
        }

        private d()
        {
            this$0 = PaymentCardEntryView.this;
            super();
        }

    }

    private final class e
        implements android.view.View.OnFocusChangeListener
    {

        final PaymentCardEntryView this$0;

        public void onFocusChange(View view, boolean flag)
        {
_L2:
            return;
            if (view == null || com.target.ui.view.checkout.PaymentCardEntryView.a(PaymentCardEntryView.this) == null || flag) goto _L2; else goto _L1
_L1:
            view.getId();
            JVM INSTR tableswitch 2131755959 2131755964: default 60
        //                       2131755959 98
        //                       2131755960 60
        //                       2131755961 60
        //                       2131755962 137
        //                       2131755963 176
        //                       2131755964 215;
               goto _L3 _L4 _L3 _L3 _L5 _L6 _L7
_L3:
            break; /* Loop/switch isn't completed */
_L7:
            break MISSING_BLOCK_LABEL_215;
_L9:
            if (com.target.ui.view.checkout.PaymentCardEntryView.a(PaymentCardEntryView.this, com.target.ui.view.checkout.PaymentCardEntryView.b(PaymentCardEntryView.this)))
            {
                com.target.ui.view.checkout.PaymentCardEntryView.a(PaymentCardEntryView.this).pinAndCvvWrapper.b();
                com.target.ui.view.checkout.PaymentCardEntryView.d(PaymentCardEntryView.this);
                return;
            }
            continue; /* Loop/switch isn't completed */
_L4:
            if (com.target.ui.view.checkout.PaymentCardEntryView.b(PaymentCardEntryView.this).cardValid) goto _L9; else goto _L8
_L8:
            break; /* Loop/switch isn't completed */
            if (true) goto _L2; else goto _L10
_L10:
            com.target.ui.view.checkout.PaymentCardEntryView.a(PaymentCardEntryView.this).cardTextWrapper.setErrorState(getContext().getString(0x7f090212));
            return;
_L5:
            if (!com.target.ui.view.checkout.PaymentCardEntryView.b(PaymentCardEntryView.this).cardValid)
            {
                PaymentCardEntryView.c(PaymentCardEntryView.this).hasCardError = true;
                com.target.ui.view.checkout.PaymentCardEntryView.a(PaymentCardEntryView.this, PaymentCardEntryView.c(PaymentCardEntryView.this));
                return;
            }
              goto _L9
_L6:
            if (!com.target.ui.view.checkout.PaymentCardEntryView.b(PaymentCardEntryView.this).expiryValid)
            {
                PaymentCardEntryView.c(PaymentCardEntryView.this).hasExpiryError = true;
                com.target.ui.view.checkout.PaymentCardEntryView.a(PaymentCardEntryView.this, PaymentCardEntryView.c(PaymentCardEntryView.this));
                return;
            }
              goto _L9
            if (!com.target.ui.view.checkout.PaymentCardEntryView.b(PaymentCardEntryView.this).securityValid)
            {
                PaymentCardEntryView.c(PaymentCardEntryView.this).hasSecurityError = true;
                com.target.ui.view.checkout.PaymentCardEntryView.a(PaymentCardEntryView.this, PaymentCardEntryView.c(PaymentCardEntryView.this));
                return;
            }
              goto _L9
        }

        private e()
        {
            this$0 = PaymentCardEntryView.this;
            super();
        }

    }

    private class f
    {

        boolean hasCardError;
        boolean hasExpiryError;
        boolean hasSecurityError;
        final PaymentCardEntryView this$0;

        private f()
        {
            this$0 = PaymentCardEntryView.this;
            super();
            hasCardError = false;
            hasExpiryError = false;
            hasSecurityError = false;
        }

    }

    private final class g extends com.target.ui.k.b
    {

        String before;
        final PaymentCardEntryView this$0;

        public void a(Editable editable)
        {
            Object obj = null;
            editable = editable.toString();
            if (o.c(editable))
            {
                com.target.ui.view.checkout.PaymentCardEntryView.a(PaymentCardEntryView.this).lastCardText.setSelection(com.target.ui.view.checkout.PaymentCardEntryView.a(PaymentCardEntryView.this).lastCardText.length());
                com.target.ui.view.checkout.PaymentCardEntryView.a(PaymentCardEntryView.this).lastCardText.requestFocus();
            } else
            {
                com.target.ui.util.d.a.a a1 = com.target.ui.util.d.b.c(before, editable);
                TGTCardDataModel tgtcarddatamodel = com.target.ui.view.checkout.PaymentCardEntryView.e(PaymentCardEntryView.this);
                boolean flag;
                boolean flag1;
                if (a1.expirationMonth == null)
                {
                    editable = null;
                } else
                {
                    editable = a1.expirationMonth.toString();
                }
                tgtcarddatamodel.d(editable);
                tgtcarddatamodel = com.target.ui.view.checkout.PaymentCardEntryView.e(PaymentCardEntryView.this);
                if (a1.expirationYear == null)
                {
                    editable = obj;
                } else
                {
                    editable = String.valueOf(a1.expirationYear);
                }
                tgtcarddatamodel.c(editable);
                flag1 = com.target.ui.util.validation.d.a(a1.expirationMonth, a1.expirationYear);
                editable = PaymentCardEntryView.c(PaymentCardEntryView.this);
                if (!flag1)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                editable.hasExpiryError = flag;
                com.target.ui.view.checkout.PaymentCardEntryView.b(PaymentCardEntryView.this, flag1);
                if (flag1)
                {
                    com.target.ui.view.checkout.PaymentCardEntryView.a(PaymentCardEntryView.this, PaymentCardEntryView.c(PaymentCardEntryView.this));
                    com.target.ui.view.checkout.PaymentCardEntryView.a(PaymentCardEntryView.this).securityCodeText.requestFocus();
                }
                if (a1.wasFormattingNeeded)
                {
                    com.target.ui.view.checkout.PaymentCardEntryView.a(PaymentCardEntryView.this).expiryText.setText(a1.withFormatting);
                    com.target.ui.view.checkout.PaymentCardEntryView.a(PaymentCardEntryView.this).expiryText.setSelection(com.target.ui.view.checkout.PaymentCardEntryView.a(PaymentCardEntryView.this).expiryText.length());
                    return;
                }
            }
        }

        public void a(CharSequence charsequence, int k, int l, int i1)
        {
            before = charsequence.toString();
        }

        public void b(CharSequence charsequence, int k, int l, int i1)
        {
        }

        private g()
        {
            this$0 = PaymentCardEntryView.this;
            super();
        }

    }

    private class h
    {

        boolean cardValid;
        boolean expiryValid;
        boolean securityValid;
        final PaymentCardEntryView this$0;

        private h()
        {
            this$0 = PaymentCardEntryView.this;
            super();
            cardValid = false;
            expiryValid = false;
            securityValid = false;
        }

    }

    private final class i
        implements android.view.View.OnClickListener
    {

        final PaymentCardEntryView this$0;

        public void onClick(View view)
        {
            if (PaymentCardEntryView.h(PaymentCardEntryView.this) != null)
            {
                PaymentCardEntryView.h(PaymentCardEntryView.this).q();
            }
        }

        private i()
        {
            this$0 = PaymentCardEntryView.this;
            super();
        }

    }

    private final class j extends com.target.ui.k.b
    {

        String before;
        final PaymentCardEntryView this$0;

        public void a(Editable editable)
        {
            boolean flag = true;
            if (o.f(before) && o.c(editable.toString()))
            {
                if (com.target.ui.util.e.a(com.target.ui.view.checkout.PaymentCardEntryView.e(PaymentCardEntryView.this).a()))
                {
                    com.target.ui.view.checkout.PaymentCardEntryView.a(PaymentCardEntryView.this).expiryText.setSelection(com.target.ui.view.checkout.PaymentCardEntryView.a(PaymentCardEntryView.this).expiryText.length());
                    com.target.ui.view.checkout.PaymentCardEntryView.a(PaymentCardEntryView.this).expiryText.requestFocus();
                } else
                {
                    com.target.ui.view.checkout.PaymentCardEntryView.a(PaymentCardEntryView.this).lastCardText.setSelection(com.target.ui.view.checkout.PaymentCardEntryView.a(PaymentCardEntryView.this).lastCardText.length());
                    com.target.ui.view.checkout.PaymentCardEntryView.a(PaymentCardEntryView.this).lastCardText.requestFocus();
                }
                PaymentCardEntryView.c(PaymentCardEntryView.this).hasSecurityError = true;
                com.target.ui.view.checkout.PaymentCardEntryView.a(PaymentCardEntryView.this).pinAndCvvWrapper.setErrorState(getContext().getString(0x7f090215));
            } else
            {
                com.target.ui.view.checkout.PaymentCardEntryView.e(PaymentCardEntryView.this).e(editable.toString());
                boolean flag1 = com.target.ui.util.validation.d.a(com.target.ui.view.checkout.PaymentCardEntryView.e(PaymentCardEntryView.this).a(), editable.toString());
                PaymentCardEntryView.c(PaymentCardEntryView.this, flag1);
                editable = PaymentCardEntryView.c(PaymentCardEntryView.this);
                if (flag1)
                {
                    flag = false;
                }
                editable.hasSecurityError = flag;
                if (com.target.ui.view.checkout.PaymentCardEntryView.a(PaymentCardEntryView.this, com.target.ui.view.checkout.PaymentCardEntryView.b(PaymentCardEntryView.this)))
                {
                    com.target.ui.view.checkout.PaymentCardEntryView.a(PaymentCardEntryView.this).pinAndCvvWrapper.b();
                    return;
                }
            }
        }

        public void a(CharSequence charsequence, int k, int l, int i1)
        {
            before = charsequence.toString();
        }

        public void b(CharSequence charsequence, int k, int l, int i1)
        {
        }

        private j()
        {
            this$0 = PaymentCardEntryView.this;
            super();
        }

    }


    private static final int CARD_LAST_DIGITS_LENGTH = 4;
    private static final int REQUEST_FOCUS_DELAY = 100;
    public static final String TAG = com/target/ui/view/checkout/PaymentCardEntryView.getSimpleName();
    private TGTCardDataModel mCardDataModel;
    private transient String mCardNumber;
    private f mErrorState;
    private h mFormState;
    private com.target.ui.view.checkout.f mPaymentCardEntryActionListener;
    private com.target.ui.view.account.b mValidationListener;
    private Views mViews;

    public PaymentCardEntryView(Context context)
    {
        super(context);
        mCardDataModel = new TGTCardDataModel();
        a(context);
    }

    public PaymentCardEntryView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mCardDataModel = new TGTCardDataModel();
        a(context);
    }

    public PaymentCardEntryView(Context context, AttributeSet attributeset, int k)
    {
        super(context, attributeset, k);
        mCardDataModel = new TGTCardDataModel();
        a(context);
    }

    static Views a(PaymentCardEntryView paymentcardentryview)
    {
        return paymentcardentryview.mViews;
    }

    static String a(PaymentCardEntryView paymentcardentryview, String s)
    {
        paymentcardentryview.mCardNumber = s;
        return s;
    }

    private void a()
    {
        mErrorState.hasCardError = false;
        mErrorState.hasExpiryError = false;
        mErrorState.hasSecurityError = false;
    }

    private void a(Context context)
    {
        setOrientation(0);
        inflate(getContext(), 0x7f030135, this);
        mViews = new Views(this);
        mViews.cardText.setOnFocusChangeListener(new e());
        mViews.lastCardText.setOnFocusChangeListener(new e());
        mViews.expiryText.setOnFocusChangeListener(new e());
        mViews.securityCodeText.setOnFocusChangeListener(new e());
        mViews.cardText.addTextChangedListener(new c());
        mViews.lastCardText.addTextChangedListener(new b());
        mViews.expiryText.addTextChangedListener(new g());
        mViews.securityCodeText.addTextChangedListener(new j());
        mViews.scanCardImageView.setOnClickListener(new i());
        mViews.expiryText.setBackSpacePressListener(new d());
        mViews.securityCodeText.setBackSpacePressListener(new d());
        mFormState = new h();
        mErrorState = new f();
    }

    private void a(f f1)
    {
        if (a(mFormState))
        {
            mViews.pinAndCvvWrapper.b();
            a();
            return;
        }
        if (f1.hasCardError)
        {
            mViews.pinAndCvvWrapper.setErrorState(getContext().getString(0x7f090212));
            return;
        }
        if (f1.hasExpiryError)
        {
            mViews.pinAndCvvWrapper.setErrorState(getContext().getString(0x7f090213));
            return;
        }
        if (f1.hasSecurityError)
        {
            mViews.pinAndCvvWrapper.setErrorState(getContext().getString(0x7f090215));
            return;
        } else
        {
            mViews.pinAndCvvWrapper.b();
            return;
        }
    }

    static void a(PaymentCardEntryView paymentcardentryview, f f1)
    {
        paymentcardentryview.a(f1);
    }

    static void a(PaymentCardEntryView paymentcardentryview, boolean flag)
    {
        paymentcardentryview.a(flag);
    }

    private void a(boolean flag)
    {
        boolean flag1 = a(mFormState);
        mFormState.cardValid = flag;
        flag = a(mFormState);
        if (flag != flag1)
        {
            d(flag);
        }
    }

    private boolean a(com.target.mothership.common.tender.a a1)
    {
        if (a1 == mCardDataModel.a())
        {
            return false;
        } else
        {
            mCardDataModel.a(a1);
            return true;
        }
    }

    private boolean a(h h1)
    {
        return h1.cardValid && h1.expiryValid && h1.securityValid;
    }

    static boolean a(PaymentCardEntryView paymentcardentryview, com.target.mothership.common.tender.a a1)
    {
        return paymentcardentryview.a(a1);
    }

    static boolean a(PaymentCardEntryView paymentcardentryview, h h1)
    {
        return paymentcardentryview.a(h1);
    }

    static h b(PaymentCardEntryView paymentcardentryview)
    {
        return paymentcardentryview.mFormState;
    }

    private void b()
    {
        al.a(mViews.cardTextWrapper, new View[] {
            mViews.pinAndCvvWrapper
        });
        com.target.ui.util.d.a.b b1 = com.target.ui.util.d.b.e(mCardDataModel.b());
        mViews.cardText.setText(b1.formattingAppliedString);
        mViews.cardText.setSelection(mViews.cardText.length());
        mViews.cardText.requestFocus();
    }

    private void b(com.target.mothership.common.tender.a a1)
    {
        al.a(mViews.pinAndCvvWrapper, new View[] {
            mViews.cardTextWrapper
        });
        if (com.target.ui.util.e.a(a1))
        {
            al.b(mViews.expiryText);
            mViews.expiryText.requestFocus();
        } else
        {
            al.c(mViews.expiryText);
            mViews.securityCodeText.requestFocus();
            b(true);
            mErrorState.hasExpiryError = false;
        }
        if (com.target.ui.util.e.b(a1))
        {
            mViews.securityCodeText.setHint(getResources().getString(0x7f0901cc));
        } else
        {
            mViews.securityCodeText.setHint(getResources().getString(0x7f09022c));
        }
        setSecurityCodeMaxLength(a1);
        mViews.lastCardText.setText(mCardDataModel.c());
    }

    static void b(PaymentCardEntryView paymentcardentryview, com.target.mothership.common.tender.a a1)
    {
        paymentcardentryview.b(a1);
    }

    static void b(PaymentCardEntryView paymentcardentryview, boolean flag)
    {
        paymentcardentryview.b(flag);
    }

    private void b(boolean flag)
    {
        boolean flag1 = a(mFormState);
        mFormState.expiryValid = flag;
        flag = a(mFormState);
        if (flag != flag1)
        {
            d(flag);
        }
    }

    static f c(PaymentCardEntryView paymentcardentryview)
    {
        return paymentcardentryview.mErrorState;
    }

    static void c(PaymentCardEntryView paymentcardentryview, boolean flag)
    {
        paymentcardentryview.c(flag);
    }

    private void c(boolean flag)
    {
        boolean flag1 = a(mFormState);
        mFormState.securityValid = flag;
        flag = a(mFormState);
        if (flag != flag1)
        {
            d(flag);
        }
    }

    static void d(PaymentCardEntryView paymentcardentryview)
    {
        paymentcardentryview.a();
    }

    private void d(boolean flag)
    {
        if (mValidationListener != null)
        {
            mValidationListener.a(this, flag);
        }
    }

    static TGTCardDataModel e(PaymentCardEntryView paymentcardentryview)
    {
        return paymentcardentryview.mCardDataModel;
    }

    static String f(PaymentCardEntryView paymentcardentryview)
    {
        return paymentcardentryview.mCardNumber;
    }

    static void g(PaymentCardEntryView paymentcardentryview)
    {
        paymentcardentryview.b();
    }

    static com.target.ui.view.checkout.f h(PaymentCardEntryView paymentcardentryview)
    {
        return paymentcardentryview.mPaymentCardEntryActionListener;
    }

    private void setSecurityCodeMaxLength(com.target.mothership.common.tender.a a1)
    {
        a1 = new android.text.InputFilter.LengthFilter(com.target.ui.util.validation.d.a(a1));
        mViews.securityCodeText.setFilters(new InputFilter[] {
            a1
        });
    }

    public void a(a a1)
    {
        if (a(mFormState))
        {
            a1.a(mCardDataModel.a(), mCardDataModel.b(), mCardDataModel.d(), mCardDataModel.e(), mCardDataModel.f());
            return;
        } else
        {
            a1.a();
            return;
        }
    }

    public void a(String s)
    {
        if (mViews == null)
        {
            return;
        } else
        {
            mViews.cardText.setText(s);
            return;
        }
    }

    public void setInputValidationListener(com.target.ui.view.account.b b1)
    {
        mValidationListener = b1;
    }

    public void setPaymentCardEntryActionListener(com.target.ui.view.checkout.f f1)
    {
        mPaymentCardEntryActionListener = f1;
    }


    // Unreferenced inner class com/target/ui/view/checkout/PaymentCardEntryView$1

/* anonymous class */
    class _cls1
        implements Runnable
    {

        final PaymentCardEntryView this$0;
        final EditText val$editText;

        public void run()
        {
            if (editText == null)
            {
                q.a(PaymentCardEntryView.TAG, "EditText null while performing delayedRequestFocus");
                return;
            } else
            {
                editText.requestFocus();
                return;
            }
        }
    }

}
