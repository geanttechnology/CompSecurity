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
import com.target.ui.model.checkout.SmsRecipientDetailsModel;
import com.target.ui.util.validation.a.e;
import com.target.ui.util.validation.a.g;
import com.target.ui.view.CustomErrorViewWrapper;
import com.target.ui.view.account.b;
import java.util.List;

public class AltSmsRecipientView extends LinearLayout
    implements android.view.View.OnFocusChangeListener, com.target.ui.view.account.b
{
    static class Views extends com.target.ui.view.a
    {

        EditText fromName;
        CustomErrorViewWrapper fromNameWrapper;
        EditText phoneNumber;
        CustomErrorViewWrapper phoneNumberWrapper;
        EditText toName;
        CustomErrorViewWrapper toNameWrapper;

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

    private class b
    {

        boolean fromNameValid;
        boolean phoneNumber;
        final AltSmsRecipientView this$0;
        boolean toNameValid;

        private b()
        {
            this$0 = AltSmsRecipientView.this;
            super();
            toNameValid = false;
            phoneNumber = false;
            fromNameValid = false;
        }

    }

    private final class c
        implements TextWatcher
    {

        final AltSmsRecipientView this$0;
        private boolean wasValid;

        public void afterTextChanged(Editable editable)
        {
            editable = AltSmsRecipientView.a(AltSmsRecipientView.this);
            boolean flag = editable.a();
            if (wasValid != flag)
            {
                a(com.target.ui.view.checkout.AltSmsRecipientView.b(AltSmsRecipientView.this).fromName, flag);
            }
            AltSmsRecipientView.a(AltSmsRecipientView.this, editable);
        }

        public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
        {
            wasValid = AltSmsRecipientView.a(AltSmsRecipientView.this).isValid;
        }

        public void onTextChanged(CharSequence charsequence, int i, int j, int k)
        {
        }

        private c()
        {
            this$0 = AltSmsRecipientView.this;
            super();
        }

    }

    private final class d
        implements TextWatcher
    {

        final AltSmsRecipientView this$0;
        private boolean wasValid;

        public void afterTextChanged(Editable editable)
        {
            editable = AltSmsRecipientView.c(AltSmsRecipientView.this);
            boolean flag = editable.a();
            if (wasValid != flag)
            {
                a(com.target.ui.view.checkout.AltSmsRecipientView.b(AltSmsRecipientView.this).toName, flag);
            }
            com.target.ui.view.checkout.AltSmsRecipientView.b(AltSmsRecipientView.this, editable);
        }

        public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
        {
            wasValid = AltSmsRecipientView.c(AltSmsRecipientView.this).isValid;
        }

        public void onTextChanged(CharSequence charsequence, int i, int j, int k)
        {
        }

        private d()
        {
            this$0 = AltSmsRecipientView.this;
            super();
        }

    }


    private b mFormState;
    private com.target.ui.util.validation.e mPhoneNumberValidationHelper;
    private com.target.ui.view.account.b mValidationListener;
    private Views mViews;

    public AltSmsRecipientView(Context context)
    {
        super(context);
        mViews = null;
        a(context);
    }

    public AltSmsRecipientView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mViews = null;
        a(context);
    }

    public AltSmsRecipientView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mViews = null;
        a(context);
    }

    static e a(AltSmsRecipientView altsmsrecipientview)
    {
        return altsmsrecipientview.c();
    }

    private void a(b b1)
    {
        b1.fromNameValid = c().a();
        b1.phoneNumber = mPhoneNumberValidationHelper.a().a();
        b1.toNameValid = d().a();
    }

    static void a(AltSmsRecipientView altsmsrecipientview, e e1)
    {
        altsmsrecipientview.setFromNameErrorState(e1);
    }

    private void a(List list, CustomErrorViewWrapper customerrorviewwrapper)
    {
        if (list != null && !list.isEmpty())
        {
            Resources resources = getResources();
            if (list.contains(com.target.ui.util.validation.a.e.a.TOO_SHORT) || list.contains(com.target.ui.util.validation.a.e.a.ONLY_SPACES))
            {
                customerrorviewwrapper.setErrorState(resources.getString(0x7f0901ea));
                return;
            }
            if (list.contains(com.target.ui.util.validation.a.e.a.TOO_LONG))
            {
                customerrorviewwrapper.setErrorState(resources.getString(0x7f0901eb));
                return;
            }
            if (list.contains(com.target.ui.util.validation.a.e.a.SPECIAL_CHAR_NOT_ALLOWED))
            {
                customerrorviewwrapper.setErrorState(resources.getString(0x7f0901ee));
                return;
            }
        }
    }

    private void a(boolean flag)
    {
        if (mValidationListener != null)
        {
            mValidationListener.a(this, flag);
        }
    }

    static Views b(AltSmsRecipientView altsmsrecipientview)
    {
        return altsmsrecipientview.mViews;
    }

    static void b(AltSmsRecipientView altsmsrecipientview, e e1)
    {
        altsmsrecipientview.setToNameErrorState(e1);
    }

    private void b(List list, CustomErrorViewWrapper customerrorviewwrapper)
    {
        if (list != null && !list.isEmpty())
        {
            Resources resources = getResources();
            if (list.contains(com.target.ui.util.validation.a.e.a.TOO_SHORT) || list.contains(com.target.ui.util.validation.a.e.a.ONLY_SPACES))
            {
                customerrorviewwrapper.setErrorState(resources.getString(0x7f0901ec));
                return;
            }
            if (list.contains(com.target.ui.util.validation.a.e.a.TOO_LONG))
            {
                customerrorviewwrapper.setErrorState(resources.getString(0x7f0901ed));
                return;
            }
            if (list.contains(com.target.ui.util.validation.a.e.a.SPECIAL_CHAR_NOT_ALLOWED))
            {
                customerrorviewwrapper.setErrorState(resources.getString(0x7f0901ee));
                return;
            }
        }
    }

    private boolean b(b b1)
    {
        return b1.toNameValid && b1.phoneNumber && b1.fromNameValid;
    }

    private e c()
    {
        return com.target.ui.util.validation.b.l(mViews.fromName.getText().toString());
    }

    static e c(AltSmsRecipientView altsmsrecipientview)
    {
        return altsmsrecipientview.d();
    }

    private e d()
    {
        return com.target.ui.util.validation.b.m(mViews.toName.getText().toString());
    }

    private void setFromNameErrorState(e e1)
    {
        if (com.target.ui.util.validation.g.a(e1, mViews.fromName, mViews.fromNameWrapper))
        {
            a(e1.reasons, mViews.fromNameWrapper);
            return;
        } else
        {
            mViews.fromNameWrapper.b();
            return;
        }
    }

    private void setToNameErrorState(e e1)
    {
        if (com.target.ui.util.validation.g.a(e1, mViews.toName, mViews.toNameWrapper))
        {
            b(e1.reasons, mViews.toNameWrapper);
            return;
        } else
        {
            mViews.toNameWrapper.b();
            return;
        }
    }

    public void a()
    {
        a(mFormState);
        a(b());
    }

    public void a(Context context)
    {
        mViews = new Views(LayoutInflater.from(context).inflate(0x7f030126, this, true));
        mViews.toName.setOnFocusChangeListener(this);
        mViews.toName.addTextChangedListener(new d());
        mPhoneNumberValidationHelper = new com.target.ui.util.validation.e(mViews.phoneNumber, mViews.phoneNumberWrapper, this, null);
        mViews.phoneNumber.setOnFocusChangeListener(this);
        mViews.phoneNumber.addTextChangedListener(mPhoneNumberValidationHelper);
        mViews.fromName.addTextChangedListener(new c());
        mViews.fromName.setOnFocusChangeListener(this);
        mFormState = new b();
    }

    public void a(View view, boolean flag)
    {
        int i = view.getId();
        if (i != mViews.toName.getId()) goto _L2; else goto _L1
_L1:
        mFormState.toNameValid = flag;
_L4:
        a(b(mFormState));
        return;
_L2:
        if (i == mViews.phoneNumber.getId())
        {
            mFormState.phoneNumber = flag;
        } else
        if (i == mViews.fromName.getId())
        {
            mFormState.fromNameValid = flag;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void a(SmsRecipientDetailsModel smsrecipientdetailsmodel)
    {
        a();
        if (smsrecipientdetailsmodel != null && !smsrecipientdetailsmodel.a())
        {
            mViews.toName.setText(smsrecipientdetailsmodel.b());
            mViews.phoneNumber.setText(smsrecipientdetailsmodel.c());
            mViews.fromName.setText(smsrecipientdetailsmodel.d());
        }
    }

    public void a(a a1)
    {
        if (b())
        {
            a1.a(mViews.toName.getText().toString(), mViews.phoneNumber.getText().toString(), mViews.fromName.getText().toString());
            return;
        } else
        {
            a1.a();
            return;
        }
    }

    public boolean b()
    {
        boolean flag = d().a();
        boolean flag1 = mPhoneNumberValidationHelper.a().a();
        boolean flag2 = c().a();
        return flag && flag1 && flag2;
    }

    public void onFocusChange(View view, boolean flag)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131755884: 
            setToNameErrorState(d());
            return;

        case 2131755893: 
            view = mPhoneNumberValidationHelper.a();
            mPhoneNumberValidationHelper.a(view);
            return;

        case 2131755888: 
            setFromNameErrorState(c());
            return;
        }
    }

    public void setInputValidationListener(com.target.ui.view.account.b b1)
    {
        mValidationListener = b1;
    }
}
