// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.target.mothership.util.o;
import com.target.ui.model.checkout.PickUpPersonDetailsModel;
import com.target.ui.util.validation.validator.FirstNameValidator;
import com.target.ui.util.validation.validator.LastNameValidator;
import com.target.ui.view.CustomErrorViewWrapper;
import com.target.ui.view.account.b;
import com.target.ui.view.common.NameView;

public class AltPickUpDetailsView extends LinearLayout
    implements com.target.ui.view.account.b
{
    static class Views extends com.target.ui.view.a
    {

        EditText emailId;
        CustomErrorViewWrapper emailIdWrapper;
        NameView nameView;

        Views(View view)
        {
            super(view);
        }
    }

    public static interface a
    {

        public abstract void a();

        public abstract void a(String s, String s1, String s2);
    }

    private final class b
        implements TextWatcher
    {

        final AltPickUpDetailsView this$0;
        private boolean wasValid;

        public void afterTextChanged(Editable editable)
        {
            boolean flag = com.target.ui.view.checkout.AltPickUpDetailsView.b(AltPickUpDetailsView.this);
            if (wasValid != flag)
            {
                a(AltPickUpDetailsView.a(AltPickUpDetailsView.this).emailId, flag);
            }
            AltPickUpDetailsView.a(AltPickUpDetailsView.this, flag);
        }

        public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
        {
            wasValid = com.target.ui.view.checkout.AltPickUpDetailsView.b(AltPickUpDetailsView.this);
        }

        public void onTextChanged(CharSequence charsequence, int i, int j, int k)
        {
        }

        private b()
        {
            this$0 = AltPickUpDetailsView.this;
            super();
        }

    }

    private class c
    {

        boolean emailIdValid;
        boolean nameValid;
        final AltPickUpDetailsView this$0;

        private c()
        {
            this$0 = AltPickUpDetailsView.this;
            super();
            nameValid = false;
            emailIdValid = false;
        }

    }

    private final class d
        implements com.target.ui.view.common.NameView.f
    {

        String firstName;
        boolean isValid;
        String lastName;
        final AltPickUpDetailsView this$0;

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

        private d()
        {
            this$0 = AltPickUpDetailsView.this;
            super();
        }

    }


    private final android.view.View.OnFocusChangeListener mFocusChangeListener;
    private c mFormState;
    private com.target.ui.view.account.b mValidationListener;
    private Views mViews;

    public AltPickUpDetailsView(Context context)
    {
        super(context);
        mViews = null;
        mFocusChangeListener = new android.view.View.OnFocusChangeListener() {

            final AltPickUpDetailsView this$0;

            public void onFocusChange(View view, boolean flag)
            {
                while (view.getId() != AltPickUpDetailsView.a(AltPickUpDetailsView.this).emailId.getId() || flag) 
                {
                    return;
                }
                AltPickUpDetailsView.a(AltPickUpDetailsView.this, com.target.ui.view.checkout.AltPickUpDetailsView.b(AltPickUpDetailsView.this));
            }

            
            {
                this$0 = AltPickUpDetailsView.this;
                super();
            }
        };
        a(context);
    }

    public AltPickUpDetailsView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mViews = null;
        mFocusChangeListener = new _cls1();
        a(context);
    }

    public AltPickUpDetailsView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mViews = null;
        mFocusChangeListener = new _cls1();
        a(context);
    }

    static Views a(AltPickUpDetailsView altpickupdetailsview)
    {
        return altpickupdetailsview.mViews;
    }

    private void a(c c1)
    {
        c1.nameValid = mViews.nameView.a();
        c1.emailIdValid = c();
    }

    static void a(AltPickUpDetailsView altpickupdetailsview, boolean flag)
    {
        altpickupdetailsview.setEmailIdErrorState(flag);
    }

    private void a(boolean flag)
    {
        if (mValidationListener != null)
        {
            mValidationListener.a(this, flag);
        }
    }

    private boolean b(c c1)
    {
        return c1.nameValid && c1.emailIdValid;
    }

    static boolean b(AltPickUpDetailsView altpickupdetailsview)
    {
        return altpickupdetailsview.c();
    }

    private boolean c()
    {
        return com.target.ui.util.validation.b.i(mViews.emailId.getText().toString());
    }

    private void setEmailIdErrorState(boolean flag)
    {
        if (mViews.emailId.getText().toString() == null)
        {
            return;
        }
        if (flag)
        {
            mViews.emailIdWrapper.b();
            return;
        }
        boolean flag1 = mViews.emailId.hasFocus();
        if (!flag1 && !flag)
        {
            mViews.emailIdWrapper.setErrorState(getResources().getString(0x7f0901f4));
            return;
        }
        if (flag1 && mViews.emailIdWrapper.a())
        {
            mViews.emailIdWrapper.setErrorState(getResources().getString(0x7f0901f4));
            return;
        } else
        {
            mViews.emailIdWrapper.b();
            return;
        }
    }

    public void a(Context context)
    {
        mViews = new Views(LayoutInflater.from(context).inflate(0x7f030125, this, true));
        mViews.emailId.setOnFocusChangeListener(mFocusChangeListener);
        mViews.emailId.addTextChangedListener(new b());
        mViews.nameView.setFirstNameValidator(new FirstNameValidator(getContext()));
        mViews.nameView.setLastNameValidator(new LastNameValidator(getContext()));
        mFormState = new c();
    }

    public void a(View view, boolean flag)
    {
        int i = view.getId();
        if (i != mViews.nameView.getId()) goto _L2; else goto _L1
_L1:
        mFormState.nameValid = flag;
_L4:
        a(b(mFormState));
        return;
_L2:
        if (i == mViews.emailId.getId())
        {
            mFormState.emailIdValid = flag;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void a(PickUpPersonDetailsModel pickuppersondetailsmodel)
    {
        b();
        if (pickuppersondetailsmodel.a())
        {
            return;
        }
        String s = pickuppersondetailsmodel.c();
        String s1 = pickuppersondetailsmodel.d();
        pickuppersondetailsmodel = pickuppersondetailsmodel.e();
        if (o.g(s))
        {
            mViews.nameView.a(s, s1);
        }
        mViews.emailId.setText(pickuppersondetailsmodel);
    }

    public void a(a a1)
    {
        d d1 = new d();
        mViews.nameView.a(d1);
        if (a())
        {
            a1.a(d1.firstName, d1.lastName, mViews.emailId.getText().toString());
            return;
        } else
        {
            a1.a();
            return;
        }
    }

    public boolean a()
    {
        boolean flag = mViews.nameView.a();
        boolean flag1 = c();
        return flag && flag1;
    }

    public void b()
    {
        a(mFormState);
        mViews.nameView.setInputValidationListener(this);
        mViews.nameView.setHintText(getResources().getString(0x7f09020f));
        a(a());
    }

    public void setInputValidationListener(com.target.ui.view.account.b b1)
    {
        mValidationListener = b1;
    }
}
