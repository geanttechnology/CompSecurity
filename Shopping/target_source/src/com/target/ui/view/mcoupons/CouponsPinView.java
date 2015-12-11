// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.mcoupons;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.target.ui.view.BackSpaceDetectorEditText;
import com.target.ui.view.account.b;

public class CouponsPinView extends LinearLayout
    implements com.target.ui.view.BackSpaceDetectorEditText.a
{
    private class a
    {

        boolean pinFourValid;
        boolean pinOneValid;
        boolean pinThreeValid;
        boolean pinTwoValid;
        final CouponsPinView this$0;

        private a()
        {
            this$0 = CouponsPinView.this;
            super();
            pinOneValid = false;
            pinTwoValid = false;
            pinThreeValid = false;
            pinFourValid = false;
        }

    }

    private final class b
        implements TextWatcher
    {

        final CouponsPinView this$0;
        private boolean wasValid;

        public void afterTextChanged(Editable editable)
        {
            editable = Boolean.valueOf(CouponsPinView.a(CouponsPinView.this, CouponsPinView.a(CouponsPinView.this).pinFour));
            if (wasValid != editable.booleanValue())
            {
                CouponsPinView.a(CouponsPinView.this, editable.booleanValue());
            }
        }

        public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
        {
            wasValid = CouponsPinView.a(CouponsPinView.this, CouponsPinView.a(CouponsPinView.this).pinFour);
        }

        public void onTextChanged(CharSequence charsequence, int i, int j, int k)
        {
        }

        private b()
        {
            this$0 = CouponsPinView.this;
            super();
        }

    }

    private final class c
        implements TextWatcher
    {

        final CouponsPinView this$0;
        private boolean wasValid;

        public void afterTextChanged(Editable editable)
        {
            editable = Boolean.valueOf(CouponsPinView.a(CouponsPinView.this, CouponsPinView.a(CouponsPinView.this).pinOne));
            if (wasValid != editable.booleanValue())
            {
                CouponsPinView.a(CouponsPinView.this, editable.booleanValue());
            }
        }

        public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
        {
            wasValid = CouponsPinView.a(CouponsPinView.this, CouponsPinView.a(CouponsPinView.this).pinOne);
        }

        public void onTextChanged(CharSequence charsequence, int i, int j, int k)
        {
            if (CouponsPinView.a(CouponsPinView.this).pinOne.getText().toString().length() == 1)
            {
                CouponsPinView.a(CouponsPinView.this).pinTwo.requestFocus();
            }
        }

        private c()
        {
            this$0 = CouponsPinView.this;
            super();
        }

    }

    private final class d
        implements TextWatcher
    {

        final CouponsPinView this$0;
        private boolean wasValid;

        public void afterTextChanged(Editable editable)
        {
            editable = Boolean.valueOf(CouponsPinView.a(CouponsPinView.this, CouponsPinView.a(CouponsPinView.this).pinThree));
            if (wasValid != editable.booleanValue())
            {
                CouponsPinView.a(CouponsPinView.this, editable.booleanValue());
            }
        }

        public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
        {
            wasValid = CouponsPinView.a(CouponsPinView.this, CouponsPinView.a(CouponsPinView.this).pinThree);
        }

        public void onTextChanged(CharSequence charsequence, int i, int j, int k)
        {
            if (CouponsPinView.a(CouponsPinView.this).pinThree.getText().toString().length() == 1)
            {
                CouponsPinView.a(CouponsPinView.this).pinFour.requestFocus();
            }
        }

        private d()
        {
            this$0 = CouponsPinView.this;
            super();
        }

    }

    private final class e
        implements TextWatcher
    {

        final CouponsPinView this$0;
        private boolean wasValid;

        public void afterTextChanged(Editable editable)
        {
            editable = Boolean.valueOf(CouponsPinView.a(CouponsPinView.this, CouponsPinView.a(CouponsPinView.this).pinTwo));
            if (wasValid != editable.booleanValue())
            {
                CouponsPinView.a(CouponsPinView.this, editable.booleanValue());
            }
        }

        public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
        {
            wasValid = CouponsPinView.a(CouponsPinView.this, CouponsPinView.a(CouponsPinView.this).pinTwo);
        }

        public void onTextChanged(CharSequence charsequence, int i, int j, int k)
        {
            if (CouponsPinView.a(CouponsPinView.this).pinTwo.getText().toString().length() == 1)
            {
                CouponsPinView.a(CouponsPinView.this).pinThree.requestFocus();
            }
        }

        private e()
        {
            this$0 = CouponsPinView.this;
            super();
        }

    }

    private static class f
    {

        BackSpaceDetectorEditText pinFour;
        BackSpaceDetectorEditText pinOne;
        BackSpaceDetectorEditText pinThree;
        BackSpaceDetectorEditText pinTwo;

        public f(View view)
        {
            pinOne = (BackSpaceDetectorEditText)view.findViewById(0x7f10041b);
            pinTwo = (BackSpaceDetectorEditText)view.findViewById(0x7f10041c);
            pinThree = (BackSpaceDetectorEditText)view.findViewById(0x7f10041d);
            pinFour = (BackSpaceDetectorEditText)view.findViewById(0x7f10041e);
        }
    }


    private static final int MAX_PIN_SIZE_PER_EDIT_TEXT = 1;
    private static final int MIN_PIN_SIZE_PER_EDIT_TEXT = 0;
    private a mFormState;
    private com.target.ui.view.account.b mValidationListener;
    private f mViews;

    public CouponsPinView(Context context)
    {
        super(context);
        a(context);
    }

    public CouponsPinView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a(context);
    }

    public CouponsPinView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a(context);
    }

    static f a(CouponsPinView couponspinview)
    {
        return couponspinview.mViews;
    }

    private void a(a a1)
    {
        a1.pinOneValid = a(((EditText) (mViews.pinOne)));
        a1.pinTwoValid = a(((EditText) (mViews.pinTwo)));
        a1.pinThreeValid = a(((EditText) (mViews.pinThree)));
        a1.pinFourValid = a(((EditText) (mViews.pinFour)));
    }

    static void a(CouponsPinView couponspinview, boolean flag)
    {
        couponspinview.a(flag);
    }

    private void a(boolean flag)
    {
label0:
        {
            a(mFormState);
            if (mValidationListener != null && mViews != null)
            {
                if (!flag)
                {
                    break label0;
                }
                mValidationListener.a(this, b(mFormState));
            }
            return;
        }
        mValidationListener.a(this, flag);
    }

    private boolean a(EditText edittext)
    {
        return edittext.getText().toString().length() == 1;
    }

    static boolean a(CouponsPinView couponspinview, EditText edittext)
    {
        return couponspinview.a(edittext);
    }

    private void b()
    {
        mViews.pinOne.addTextChangedListener(new c());
        mViews.pinTwo.addTextChangedListener(new e());
        mViews.pinThree.addTextChangedListener(new d());
        mViews.pinFour.addTextChangedListener(new b());
    }

    private boolean b(a a1)
    {
        return a1.pinOneValid && a1.pinTwoValid && a1.pinThreeValid && a1.pinFourValid;
    }

    private void c()
    {
        mViews.pinOne.setBackSpacePressListener(this);
        mViews.pinTwo.setBackSpacePressListener(this);
        mViews.pinThree.setBackSpacePressListener(this);
        mViews.pinFour.setBackSpacePressListener(this);
    }

    public void a(Context context)
    {
        mViews = new f(LayoutInflater.from(context).inflate(0x7f03014a, this, true));
        b();
        c();
        mFormState = new a();
        a(mFormState);
    }

    public void a(BackSpaceDetectorEditText backspacedetectoredittext)
    {
        backspacedetectoredittext.getId();
        JVM INSTR tableswitch 2131756060 2131756062: default 32
    //                   2131756060 33
    //                   2131756061 64
    //                   2131756062 95;
           goto _L1 _L2 _L3 _L4
_L1:
        return;
_L2:
        if (mViews.pinTwo.getText().toString().length() == 0)
        {
            mViews.pinOne.requestFocus();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (mViews.pinThree.getText().toString().length() == 0)
        {
            mViews.pinTwo.requestFocus();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (mViews.pinFour.getText().toString().length() == 0)
        {
            mViews.pinThree.requestFocus();
            return;
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    public boolean a()
    {
        return a(((EditText) (mViews.pinOne))) && a(((EditText) (mViews.pinTwo))) && a(((EditText) (mViews.pinThree))) && a(((EditText) (mViews.pinFour)));
    }

    public String getCompletePinNumber()
    {
        StringBuilder stringbuilder = new StringBuilder("");
        stringbuilder.append(mViews.pinOne.getText().toString());
        stringbuilder.append(mViews.pinTwo.getText().toString());
        stringbuilder.append(mViews.pinThree.getText().toString());
        stringbuilder.append(mViews.pinFour.getText().toString());
        return stringbuilder.toString();
    }

    public void setInputValidationListener(com.target.ui.view.account.b b1)
    {
        mValidationListener = b1;
    }
}
