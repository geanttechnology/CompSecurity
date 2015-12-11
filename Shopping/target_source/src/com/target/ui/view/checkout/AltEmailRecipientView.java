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
import com.target.ui.model.checkout.EmailRecipientDetailsModel;
import com.target.ui.util.validation.a.e;
import com.target.ui.util.validation.g;
import com.target.ui.util.validation.h;
import com.target.ui.view.CustomErrorViewWrapper;
import com.target.ui.view.account.b;
import java.util.List;

public class AltEmailRecipientView extends LinearLayout
    implements android.view.View.OnFocusChangeListener, com.target.ui.view.account.b
{
    static class Views extends com.target.ui.view.a
    {

        EditText email;
        CustomErrorViewWrapper emailWrapper;
        EditText fromName;
        CustomErrorViewWrapper fromNameWrapper;
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

    private final class b
        implements TextWatcher
    {

        final AltEmailRecipientView this$0;
        private boolean wasValid;

        public void afterTextChanged(Editable editable)
        {
            boolean flag = AltEmailRecipientView.a(AltEmailRecipientView.this);
            if (wasValid != flag)
            {
                a(com.target.ui.view.checkout.AltEmailRecipientView.b(AltEmailRecipientView.this).email, flag);
            }
            AltEmailRecipientView.a(AltEmailRecipientView.this, flag);
        }

        public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
        {
            wasValid = AltEmailRecipientView.a(AltEmailRecipientView.this);
        }

        public void onTextChanged(CharSequence charsequence, int i, int j, int k)
        {
        }

        private b()
        {
            this$0 = AltEmailRecipientView.this;
            super();
        }

    }

    private class c
    {

        boolean emailValid;
        boolean fromNameValid;
        final AltEmailRecipientView this$0;
        boolean toNameValid;

        private c()
        {
            this$0 = AltEmailRecipientView.this;
            super();
            toNameValid = false;
            emailValid = false;
            fromNameValid = false;
        }

    }

    private final class d
        implements TextWatcher
    {

        final AltEmailRecipientView this$0;
        private boolean wasValid;

        public void afterTextChanged(Editable editable)
        {
            editable = AltEmailRecipientView.c(AltEmailRecipientView.this);
            boolean flag = editable.a();
            if (wasValid != flag)
            {
                a(com.target.ui.view.checkout.AltEmailRecipientView.b(AltEmailRecipientView.this).fromName, flag);
            }
            AltEmailRecipientView.a(AltEmailRecipientView.this, editable);
        }

        public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
        {
            wasValid = AltEmailRecipientView.c(AltEmailRecipientView.this).isValid;
        }

        public void onTextChanged(CharSequence charsequence, int i, int j, int k)
        {
        }

        private d()
        {
            this$0 = AltEmailRecipientView.this;
            super();
        }

    }

    private final class e
        implements TextWatcher
    {

        final AltEmailRecipientView this$0;
        private boolean wasValid;

        public void afterTextChanged(Editable editable)
        {
            editable = AltEmailRecipientView.d(AltEmailRecipientView.this);
            boolean flag = editable.a();
            if (wasValid != flag)
            {
                a(com.target.ui.view.checkout.AltEmailRecipientView.b(AltEmailRecipientView.this).toName, flag);
            }
            com.target.ui.view.checkout.AltEmailRecipientView.b(AltEmailRecipientView.this, editable);
        }

        public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
        {
            wasValid = AltEmailRecipientView.d(AltEmailRecipientView.this).isValid;
        }

        public void onTextChanged(CharSequence charsequence, int i, int j, int k)
        {
        }

        private e()
        {
            this$0 = AltEmailRecipientView.this;
            super();
        }

    }


    private c mFormState;
    private com.target.ui.view.account.b mValidationListener;
    private Views mViews;

    public AltEmailRecipientView(Context context)
    {
        super(context);
        mViews = null;
        a(context);
    }

    public AltEmailRecipientView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mViews = null;
        a(context);
    }

    public AltEmailRecipientView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mViews = null;
        a(context);
    }

    private void a(c c1)
    {
        c1.fromNameValid = d().a();
        c1.emailValid = c();
        c1.toNameValid = e().a();
    }

    static void a(AltEmailRecipientView altemailrecipientview, com.target.ui.util.validation.a.e e1)
    {
        altemailrecipientview.setFromNameErrorState(e1);
    }

    static void a(AltEmailRecipientView altemailrecipientview, boolean flag)
    {
        altemailrecipientview.setEmailIdErrorState(flag);
    }

    private void a(List list, CustomErrorViewWrapper customerrorviewwrapper)
    {
        if (list != null && !list.isEmpty())
        {
            Resources resources = getResources();
            if (list.contains(com.target.ui.util.validation.a.e.a.TOO_SHORT) || list.contains(com.target.ui.util.validation.a.e.a.ONLY_SPACES))
            {
                customerrorviewwrapper.setErrorState(resources.getString(0x7f0901e6));
                return;
            }
            if (list.contains(com.target.ui.util.validation.a.e.a.TOO_LONG))
            {
                customerrorviewwrapper.setErrorState(resources.getString(0x7f0901e7));
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

    static boolean a(AltEmailRecipientView altemailrecipientview)
    {
        return altemailrecipientview.c();
    }

    static Views b(AltEmailRecipientView altemailrecipientview)
    {
        return altemailrecipientview.mViews;
    }

    static void b(AltEmailRecipientView altemailrecipientview, com.target.ui.util.validation.a.e e1)
    {
        altemailrecipientview.setToNameErrorState(e1);
    }

    private void b(List list, CustomErrorViewWrapper customerrorviewwrapper)
    {
        if (list != null && !list.isEmpty())
        {
            Resources resources = getResources();
            if (list.contains(com.target.ui.util.validation.a.e.a.TOO_SHORT) || list.contains(com.target.ui.util.validation.a.e.a.ONLY_SPACES))
            {
                customerrorviewwrapper.setErrorState(resources.getString(0x7f0901e8));
                return;
            }
            if (list.contains(com.target.ui.util.validation.a.e.a.TOO_LONG))
            {
                customerrorviewwrapper.setErrorState(resources.getString(0x7f0901e9));
                return;
            }
            if (list.contains(com.target.ui.util.validation.a.e.a.SPECIAL_CHAR_NOT_ALLOWED))
            {
                customerrorviewwrapper.setErrorState(resources.getString(0x7f0901ee));
                return;
            }
        }
    }

    private boolean b(c c1)
    {
        return c1.toNameValid && c1.emailValid && c1.fromNameValid;
    }

    static com.target.ui.util.validation.a.e c(AltEmailRecipientView altemailrecipientview)
    {
        return altemailrecipientview.d();
    }

    private boolean c()
    {
        return h.i(mViews.email.getText().toString());
    }

    private com.target.ui.util.validation.a.e d()
    {
        return com.target.ui.util.validation.b.j(mViews.fromName.getText().toString());
    }

    static com.target.ui.util.validation.a.e d(AltEmailRecipientView altemailrecipientview)
    {
        return altemailrecipientview.e();
    }

    private com.target.ui.util.validation.a.e e()
    {
        return com.target.ui.util.validation.b.k(mViews.toName.getText().toString());
    }

    private void setEmailIdErrorState(boolean flag)
    {
        if (mViews.email.getText().toString() == null)
        {
            return;
        }
        if (flag)
        {
            mViews.emailWrapper.b();
            return;
        }
        boolean flag1 = mViews.email.hasFocus();
        if (!flag1 && !flag)
        {
            mViews.emailWrapper.setErrorState(getResources().getString(0x7f0901f4));
            return;
        }
        if (flag1 && mViews.emailWrapper.a())
        {
            mViews.emailWrapper.setErrorState(getResources().getString(0x7f0901f4));
            return;
        } else
        {
            mViews.emailWrapper.b();
            return;
        }
    }

    private void setFromNameErrorState(com.target.ui.util.validation.a.e e1)
    {
        if (g.a(e1, mViews.fromName, mViews.fromNameWrapper))
        {
            a(e1.reasons, mViews.fromNameWrapper);
            return;
        } else
        {
            mViews.fromNameWrapper.b();
            return;
        }
    }

    private void setToNameErrorState(com.target.ui.util.validation.a.e e1)
    {
        if (g.a(e1, mViews.toName, mViews.toNameWrapper))
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
        mViews = new Views(LayoutInflater.from(context).inflate(0x7f030124, this, true));
        mViews.toName.setOnFocusChangeListener(this);
        mViews.toName.addTextChangedListener(new e());
        mViews.email.setOnFocusChangeListener(this);
        mViews.email.addTextChangedListener(new b());
        mViews.fromName.addTextChangedListener(new d());
        mViews.fromName.setOnFocusChangeListener(this);
        mFormState = new c();
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
        if (i == mViews.email.getId())
        {
            mFormState.emailValid = flag;
        } else
        if (i == mViews.fromName.getId())
        {
            mFormState.fromNameValid = flag;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void a(EmailRecipientDetailsModel emailrecipientdetailsmodel)
    {
        a();
        if (emailrecipientdetailsmodel != null && !emailrecipientdetailsmodel.a())
        {
            mViews.toName.setText(emailrecipientdetailsmodel.b());
            mViews.email.setText(emailrecipientdetailsmodel.c());
            mViews.fromName.setText(emailrecipientdetailsmodel.d());
        }
    }

    public void a(a a1)
    {
        if (b())
        {
            a1.a(mViews.toName.getText().toString(), mViews.email.getText().toString(), mViews.fromName.getText().toString());
            return;
        } else
        {
            a1.a();
            return;
        }
    }

    public boolean b()
    {
        boolean flag = e().a();
        boolean flag1 = c();
        boolean flag2 = d().a();
        return flag && flag1 && flag2;
    }

    public void onFocusChange(View view, boolean flag)
    {
        switch (view.getId())
        {
        case 2131755885: 
        case 2131755887: 
        default:
            return;

        case 2131755884: 
            setToNameErrorState(e());
            return;

        case 2131755886: 
            setEmailIdErrorState(c());
            return;

        case 2131755888: 
            setFromNameErrorState(d());
            break;
        }
    }

    public void setInputValidationListener(com.target.ui.view.account.b b1)
    {
        mValidationListener = b1;
    }
}
