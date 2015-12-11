// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.mcoupons;

import android.content.Context;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.target.ui.util.validation.a.g;
import com.target.ui.util.validation.a.m;
import com.target.ui.util.validation.e;
import com.target.ui.util.validation.validator.FirstNameValidator;
import com.target.ui.util.validation.validator.LastNameValidator;
import com.target.ui.view.CustomErrorViewWrapper;
import com.target.ui.view.account.b;
import com.target.ui.view.common.NameView;

public class CouponsSignUpView extends LinearLayout
    implements com.target.ui.view.account.b
{
    private class a
    {

        boolean nameValid;
        boolean phoneNumberValid;
        final CouponsSignUpView this$0;
        boolean zipValid;

        private a()
        {
            this$0 = CouponsSignUpView.this;
            super();
            nameValid = false;
            zipValid = false;
            phoneNumberValid = false;
        }

    }

    public final class b
        implements com.target.ui.view.common.NameView.f
    {

        String firstName;
        boolean isValid;
        String lastName;
        final CouponsSignUpView this$0;

        public void a()
        {
            isValid = false;
        }

        public void a(String s, String s1)
        {
            firstName = s;
            lastName = s1;
            isValid = true;
        }

        public String b()
        {
            return firstName;
        }

        public String c()
        {
            return lastName;
        }

        public b()
        {
            this$0 = CouponsSignUpView.this;
            super();
        }
    }

    private static class c
    {

        NameView mNameView;
        CustomErrorViewWrapper phoneNumWrapper;
        EditText phoneNumber;
        EditText zipCode;
        CustomErrorViewWrapper zipCodeWrapper;

        public c(View view)
        {
            zipCode = (EditText)view.findViewById(0x7f100424);
            zipCodeWrapper = (CustomErrorViewWrapper)view.findViewById(0x7f100423);
            phoneNumber = (EditText)view.findViewById(0x7f100427);
            phoneNumWrapper = (CustomErrorViewWrapper)view.findViewById(0x7f100426);
            mNameView = (NameView)view.findViewById(0x7f100421);
        }
    }

    private final class d extends com.target.ui.k.b
    {

        final CouponsSignUpView this$0;
        private boolean wasValid;

        public void a(Editable editable)
        {
            editable = CouponsSignUpView.c(CouponsSignUpView.this);
            if (wasValid != ((m) (editable)).isValid)
            {
                CouponsSignUpView.a(CouponsSignUpView.this, ((m) (editable)).isValid);
            }
            CouponsSignUpView.a(CouponsSignUpView.this, editable);
        }

        public void a(CharSequence charsequence, int i, int j, int k)
        {
            wasValid = CouponsSignUpView.c(CouponsSignUpView.this).isValid;
        }

        public void b(CharSequence charsequence, int i, int j, int k)
        {
        }

        private d()
        {
            this$0 = CouponsSignUpView.this;
            super();
        }

    }


    private a mFormState;
    private final android.view.View.OnFocusChangeListener mPhoneNumberFocusListener;
    private e mPhoneNumberValidationHelper;
    private com.target.ui.view.account.b mValidationListener;
    private c mViews;
    private final android.view.View.OnFocusChangeListener mZipCodeFocusListener;

    public CouponsSignUpView(Context context)
    {
        super(context);
        mViews = null;
        mPhoneNumberFocusListener = new android.view.View.OnFocusChangeListener() {

            final CouponsSignUpView this$0;

            public void onFocusChange(View view, boolean flag)
            {
                if (!flag)
                {
                    CouponsSignUpView.a(CouponsSignUpView.this);
                }
            }

            
            {
                this$0 = CouponsSignUpView.this;
                super();
            }
        };
        mZipCodeFocusListener = new android.view.View.OnFocusChangeListener() {

            final CouponsSignUpView this$0;

            public void onFocusChange(View view, boolean flag)
            {
                if (!flag)
                {
                    com.target.ui.view.mcoupons.CouponsSignUpView.b(CouponsSignUpView.this);
                }
            }

            
            {
                this$0 = CouponsSignUpView.this;
                super();
            }
        };
        a(context);
    }

    public CouponsSignUpView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mViews = null;
        mPhoneNumberFocusListener = new _cls1();
        mZipCodeFocusListener = new _cls2();
        a(context);
    }

    public CouponsSignUpView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mViews = null;
        mPhoneNumberFocusListener = new _cls1();
        mZipCodeFocusListener = new _cls2();
        a(context);
    }

    private void a(a a1)
    {
        a1.nameValid = mViews.mNameView.a();
        a1.zipValid = com.target.ui.util.validation.b.e(mViews.zipCode.getText().toString()).isValid;
        a1.phoneNumberValid = mPhoneNumberValidationHelper.a().a();
    }

    static void a(CouponsSignUpView couponssignupview)
    {
        couponssignupview.b();
    }

    static void a(CouponsSignUpView couponssignupview, m m1)
    {
        couponssignupview.setZipCodeErrorState(m1);
    }

    static void a(CouponsSignUpView couponssignupview, boolean flag)
    {
        couponssignupview.a(flag);
    }

    private void a(boolean flag)
    {
label0:
        {
            if (mValidationListener != null && mViews != null)
            {
                if (!flag)
                {
                    break label0;
                }
                mValidationListener.a(this, a());
            }
            return;
        }
        mValidationListener.a(this, flag);
    }

    private void b()
    {
        g g1 = mPhoneNumberValidationHelper.a();
        mPhoneNumberValidationHelper.a(g1);
    }

    static void b(CouponsSignUpView couponssignupview)
    {
        couponssignupview.c();
    }

    private boolean b(a a1)
    {
        return a1.nameValid && a1.zipValid && a1.phoneNumberValid;
    }

    static m c(CouponsSignUpView couponssignupview)
    {
        return couponssignupview.d();
    }

    private void c()
    {
        setZipCodeErrorState(d());
    }

    private m d()
    {
        return com.target.ui.util.validation.b.e(mViews.zipCode.getText().toString());
    }

    private void setZipCodeErrorState(m m1)
    {
        com.target.ui.util.validation.b.a(getContext(), m1, mViews.zipCode, mViews.zipCodeWrapper);
    }

    public void a(Context context)
    {
        mViews = new c(LayoutInflater.from(context).inflate(0x7f03014b, this, true));
        mViews.zipCode.addTextChangedListener(new d());
        mViews.zipCode.setOnFocusChangeListener(mZipCodeFocusListener);
        mViews.mNameView.setFirstNameValidator(new FirstNameValidator(getContext()));
        mViews.mNameView.setLastNameValidator(new LastNameValidator(getContext()));
        mViews.mNameView.setInputValidationListener(this);
        mPhoneNumberValidationHelper = new e(mViews.phoneNumber, mViews.phoneNumWrapper, this, null);
        mViews.phoneNumber.setOnFocusChangeListener(mPhoneNumberFocusListener);
        mViews.phoneNumber.addTextChangedListener(mPhoneNumberValidationHelper);
        mFormState = new a();
        a(mFormState);
    }

    public void a(View view, boolean flag)
    {
        int i = view.getId();
        if (i != mViews.mNameView.getId()) goto _L2; else goto _L1
_L1:
        mFormState.nameValid = flag;
_L4:
        a(mFormState);
        a(b(mFormState));
        return;
_L2:
        if (i == mViews.zipCode.getId())
        {
            mFormState.zipValid = flag;
        } else
        if (i == mViews.phoneNumber.getId())
        {
            mFormState.phoneNumberValid = flag;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public boolean a()
    {
        boolean flag = mViews.mNameView.a();
        boolean flag1 = com.target.ui.util.validation.b.e(mViews.zipCode.getText().toString()).isValid;
        boolean flag2 = com.target.ui.util.validation.b.f(mViews.phoneNumber.getText().toString()).isValid;
        return flag && flag1 && flag2;
    }

    public b getName()
    {
        b b1 = new b();
        mViews.mNameView.a(b1);
        return b1;
    }

    public String getPhoneNumberEntered()
    {
        return mViews.phoneNumber.getText().toString();
    }

    public String getZipCode()
    {
        return mViews.zipCode.getText().toString();
    }

    public void setInputValidationListener(com.target.ui.view.account.b b1)
    {
        mValidationListener = b1;
    }
}
