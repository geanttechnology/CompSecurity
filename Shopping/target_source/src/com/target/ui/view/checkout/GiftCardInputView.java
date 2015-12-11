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
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.target.mothership.model.cart.b.d;
import com.target.mothership.util.o;
import com.target.ui.util.al;
import com.target.ui.util.d.b;
import com.target.ui.util.e.a;
import com.target.ui.util.q;
import com.target.ui.view.BackSpaceDetectorEditText;
import com.target.ui.view.CustomErrorViewWrapper;
import com.target.ui.view.common.e;

public class GiftCardInputView extends RelativeLayout
    implements android.view.View.OnClickListener
{
    static class Views extends com.target.ui.view.a
    {

        BackSpaceDetectorEditText gcAccessCode;
        EditText gcEditText;
        CustomErrorViewWrapper gcInputWrapper;
        EditText gcLastDigits;
        CustomErrorViewWrapper gcNumberWrapper;
        Button redeemButton;
        ImageView scanButton;

        Views(View view)
        {
            super(view);
        }
    }

    private final class a
        implements com.target.ui.view.BackSpaceDetectorEditText.a
    {

        final GiftCardInputView this$0;

        public void a(BackSpaceDetectorEditText backspacedetectoredittext)
        {
            if (backspacedetectoredittext != null && com.target.ui.view.checkout.GiftCardInputView.a(GiftCardInputView.this) != null)
            {
                switch (backspacedetectoredittext.getId())
                {
                default:
                    return;

                case 2131755949: 
                    break;
                }
                if (o.e(backspacedetectoredittext.getText().toString()))
                {
                    com.target.ui.view.checkout.GiftCardInputView.a(GiftCardInputView.this).gcLastDigits.setSelection(com.target.ui.view.checkout.GiftCardInputView.a(GiftCardInputView.this).gcLastDigits.length());
                    com.target.ui.view.checkout.GiftCardInputView.a(GiftCardInputView.this).gcLastDigits.requestFocus();
                    return;
                }
            }
        }

        private a()
        {
            this$0 = GiftCardInputView.this;
            super();
        }

    }

    private final class b
        implements TextWatcher
    {

        final GiftCardInputView this$0;

        public void afterTextChanged(Editable editable)
        {
            if (o.c(editable.toString()))
            {
                com.target.ui.view.checkout.GiftCardInputView.a(GiftCardInputView.this).gcLastDigits.setSelection(com.target.ui.view.checkout.GiftCardInputView.a(GiftCardInputView.this).gcLastDigits.length());
                com.target.ui.view.checkout.GiftCardInputView.a(GiftCardInputView.this).gcLastDigits.requestFocus();
            }
            if (com.target.ui.view.checkout.GiftCardInputView.a(GiftCardInputView.this).gcInputWrapper.a())
            {
                com.target.ui.view.checkout.GiftCardInputView.a(GiftCardInputView.this).gcInputWrapper.b();
            }
        }

        public void beforeTextChanged(CharSequence charsequence, int j, int k, int l)
        {
        }

        public void onTextChanged(CharSequence charsequence, int j, int k, int l)
        {
            if (charsequence.length() == 8)
            {
                GiftCardInputView.f(GiftCardInputView.this);
                return;
            } else
            {
                com.target.ui.view.checkout.GiftCardInputView.a(GiftCardInputView.this).redeemButton.setEnabled(false);
                return;
            }
        }

        private b()
        {
            this$0 = GiftCardInputView.this;
            super();
        }

    }

    private final class c
        implements TextWatcher
    {

        final GiftCardInputView this$0;

        public void afterTextChanged(Editable editable)
        {
            editable = editable.toString();
            if (o.g(GiftCardInputView.c(GiftCardInputView.this)) && GiftCardInputView.c(GiftCardInputView.this).length() >= 3)
            {
                StringBuilder stringbuilder = new StringBuilder(com.target.ui.view.checkout.GiftCardInputView.d(GiftCardInputView.this));
                stringbuilder.replace(GiftCardInputView.c(GiftCardInputView.this).length() - 3, GiftCardInputView.c(GiftCardInputView.this).length(), editable);
                com.target.ui.view.checkout.GiftCardInputView.a(GiftCardInputView.this, stringbuilder.toString());
            }
            if (o.e(editable))
            {
                com.target.ui.view.checkout.GiftCardInputView.b(GiftCardInputView.this, null);
                com.target.ui.view.checkout.GiftCardInputView.e(GiftCardInputView.this);
            } else
            {
                if (com.target.ui.view.checkout.GiftCardInputView.a(GiftCardInputView.this).gcInputWrapper.a())
                {
                    com.target.ui.view.checkout.GiftCardInputView.a(GiftCardInputView.this).gcInputWrapper.b();
                }
                if (editable.length() == 3)
                {
                    com.target.ui.view.checkout.GiftCardInputView.a(GiftCardInputView.this).gcAccessCode.requestFocus();
                    return;
                }
            }
        }

        public void beforeTextChanged(CharSequence charsequence, int j, int k, int l)
        {
        }

        public void onTextChanged(CharSequence charsequence, int j, int k, int l)
        {
        }

        private c()
        {
            this$0 = GiftCardInputView.this;
            super();
        }

    }

    private final class d
        implements TextWatcher
    {

        String before;
        final GiftCardInputView this$0;

        public void afterTextChanged(Editable editable)
        {
            String s = editable.toString();
            if (!o.c(editable.toString()))
            {
                if (((com.target.ui.util.d.a.b) (editable = com.target.ui.util.d.b.a(before, s))).wasFormattingNeeded)
                {
                    com.target.ui.view.checkout.GiftCardInputView.a(GiftCardInputView.this).gcEditText.setText(((com.target.ui.util.d.a.b) (editable)).formattingAppliedString);
                    com.target.ui.view.checkout.GiftCardInputView.a(GiftCardInputView.this).gcEditText.setSelection(com.target.ui.view.checkout.GiftCardInputView.a(GiftCardInputView.this).gcEditText.length());
                    return;
                }
            }
        }

        public void beforeTextChanged(CharSequence charsequence, int j, int k, int l)
        {
            before = charsequence.toString();
        }

        public void onTextChanged(CharSequence charsequence, int j, int k, int l)
        {
            if (charsequence.length() == 0)
            {
                com.target.ui.view.checkout.GiftCardInputView.a(GiftCardInputView.this).gcNumberWrapper.b();
            } else
            if (charsequence.length() == 19)
            {
                com.target.ui.view.checkout.GiftCardInputView.a(GiftCardInputView.this, com.target.ui.view.checkout.GiftCardInputView.b(GiftCardInputView.this, com.target.ui.util.d.b.d(charsequence.toString())));
                com.target.ui.view.checkout.GiftCardInputView.b(GiftCardInputView.this);
                return;
            }
        }

        private d()
        {
            this$0 = GiftCardInputView.this;
            super();
        }

    }


    private static final int GC_ACCESS_CODE_LENGTH = 8;
    private static final int GC_CARD_NUMBER_LENGTH = 19;
    private static final int GC_LAST_DIGITS_LENGTH = 3;
    public static final String TAG = com/target/ui/view/checkout/GiftCardInputView.getSimpleName();
    private e mActionListener;
    private d mGcNumberTextWatcher;
    private String mGiftCardNumber;
    private transient String mGiftCardNumberTempHolder;
    private Views mViews;

    public GiftCardInputView(Context context)
    {
        super(context);
        mGcNumberTextWatcher = new d();
        a(context);
    }

    public GiftCardInputView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mGcNumberTextWatcher = new d();
        a(context);
    }

    public GiftCardInputView(Context context, AttributeSet attributeset, int j)
    {
        super(context, attributeset, j);
        mGcNumberTextWatcher = new d();
        a(context);
    }

    static Views a(GiftCardInputView giftcardinputview)
    {
        return giftcardinputview.mViews;
    }

    static String a(GiftCardInputView giftcardinputview, String s)
    {
        giftcardinputview.mGiftCardNumber = s;
        return s;
    }

    static String b(GiftCardInputView giftcardinputview, String s)
    {
        giftcardinputview.mGiftCardNumberTempHolder = s;
        return s;
    }

    static void b(GiftCardInputView giftcardinputview)
    {
        giftcardinputview.g();
    }

    static String c(GiftCardInputView giftcardinputview)
    {
        return giftcardinputview.mGiftCardNumberTempHolder;
    }

    private void c()
    {
        mViews.scanButton.setOnClickListener(this);
        mViews.redeemButton.setOnClickListener(this);
        mViews.gcAccessCode.setBackSpacePressListener(new a());
    }

    static String d(GiftCardInputView giftcardinputview)
    {
        return giftcardinputview.mGiftCardNumber;
    }

    private void d()
    {
        mViews.gcEditText.addTextChangedListener(mGcNumberTextWatcher);
        mViews.gcLastDigits.addTextChangedListener(new c());
        mViews.gcAccessCode.addTextChangedListener(new b());
    }

    private void e()
    {
        mViews.redeemButton.setEnabled(true);
    }

    static void e(GiftCardInputView giftcardinputview)
    {
        giftcardinputview.h();
    }

    private void f()
    {
        String s = com.target.ui.util.d.b.b(mViews.gcEditText.getText().toString().replace("\\s+", ""));
        mViews.gcLastDigits.setText(s);
    }

    static void f(GiftCardInputView giftcardinputview)
    {
        giftcardinputview.e();
    }

    private void g()
    {
        al.a(new View[] {
            mViews.gcNumberWrapper, mViews.scanButton
        });
        al.b(new View[] {
            mViews.gcInputWrapper, mViews.redeemButton
        });
        f();
        mViews.gcInputWrapper.setEnabled(false);
        mViews.gcAccessCode.requestFocus();
        com.target.ui.util.e.a.b(mViews.gcAccessCode);
        mViews.gcAccessCode.setSelection(0);
    }

    private void h()
    {
        al.a(new View[] {
            mViews.gcInputWrapper, mViews.redeemButton
        });
        al.b(new View[] {
            mViews.gcNumberWrapper, mViews.scanButton
        });
        mViews.gcNumberWrapper.requestFocus();
        String s1 = mViews.gcEditText.getText().toString();
        String s = s1;
        if (o.g(s1))
        {
            s = s1;
            if (s1.length() > 3)
            {
                s = s1.substring(0, s1.length() - 3);
            }
        }
        mViews.gcEditText.setText(s);
        mViews.gcEditText.setSelection(mViews.gcEditText.length());
    }

    private void i()
    {
        Object obj = mViews.gcAccessCode.getText().toString();
        obj = new com.target.mothership.model.cart.b.d(mGiftCardNumber, ((String) (obj)));
        a(true);
        mActionListener.a(((com.target.mothership.model.cart.b.d) (obj)), TAG);
    }

    public void a()
    {
        if (al.a(mViews.gcInputWrapper))
        {
            al.a(mViews.redeemButton, new View[] {
                mViews.scanButton
            });
            al.a(mViews.gcInputWrapper, new View[] {
                mViews.gcNumberWrapper
            });
            mViews.redeemButton.setEnabled(true);
            mViews.gcLastDigits.setEnabled(true);
            mViews.gcAccessCode.setEnabled(true);
            mViews.gcAccessCode.setSelection(mViews.gcAccessCode.length());
            mViews.gcAccessCode.requestFocus();
        }
    }

    public void a(Context context)
    {
        inflate(context, 0x7f030133, this);
        mViews = new Views(this);
        c();
        d();
    }

    public void a(String s)
    {
        mGiftCardNumber = s;
        mViews.gcEditText.requestFocus();
        mViews.gcEditText.setSelection(mViews.gcEditText.length());
        s = com.target.ui.util.d.b.c(s);
        mViews.gcEditText.removeTextChangedListener(mGcNumberTextWatcher);
        mViews.gcEditText.setText(((com.target.ui.util.d.a.e) (s)).withFormatting);
        mViews.gcEditText.addTextChangedListener(mGcNumberTextWatcher);
        g();
    }

    public void a(boolean flag)
    {
        if (flag)
        {
            al.a(new View[] {
                mViews.scanButton
            });
            mViews.redeemButton.setEnabled(false);
            mViews.gcLastDigits.setEnabled(false);
            mViews.gcAccessCode.setEnabled(false);
            return;
        } else
        {
            al.a(mViews.scanButton, new View[] {
                mViews.redeemButton
            });
            al.b(mViews.gcNumberWrapper);
            mViews.redeemButton.setEnabled(true);
            mViews.gcLastDigits.setEnabled(true);
            mViews.gcAccessCode.setEnabled(true);
            return;
        }
    }

    public void b()
    {
        mViews.gcInputWrapper.b();
        mViews.gcEditText.getText().clear();
        mViews.gcLastDigits.getText().clear();
        mViews.gcAccessCode.getText().clear();
        mGiftCardNumberTempHolder = null;
    }

    public void b(String s)
    {
        if (s == null)
        {
            q.a(TAG, "Can't display a null error string");
            return;
        } else
        {
            mViews.gcInputWrapper.setErrorState(s);
            return;
        }
    }

    public void onClick(View view)
    {
        if (view == null || mActionListener == null)
        {
            return;
        }
        switch (view.getId())
        {
        default:
            return;

        case 2131755950: 
            mActionListener.g();
            return;

        case 2131755951: 
            i();
            break;
        }
    }

    public void setGiftCardActionListener(e e1)
    {
        mActionListener = e1;
    }

    public void setRedeemButtonLabel(String s)
    {
        if (!o.g(s))
        {
            q.a(TAG, "Not a valid label for the button");
            return;
        } else
        {
            mViews.redeemButton.setText(s);
            return;
        }
    }

}
