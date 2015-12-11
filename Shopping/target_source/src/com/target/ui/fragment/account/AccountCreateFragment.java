// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.account;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import com.target.mothership.model.guest.interfaces.a.d;
import com.target.mothership.util.o;
import com.target.ui.analytics.a.v;
import com.target.ui.e.e;
import com.target.ui.f.c;
import com.target.ui.fragment.common.TargetWebFragment;
import com.target.ui.util.SpannableStringUtils;
import com.target.ui.util.q;
import com.target.ui.util.validation.validator.FirstNameValidator;
import com.target.ui.util.validation.validator.LastNameValidator;
import com.target.ui.view.account.AccountCreationEmailView;
import com.target.ui.view.account.AccountCreationHeaderView;
import com.target.ui.view.account.AccountCreationPasswordView;
import com.target.ui.view.common.NameView;
import com.target.ui.view.common.a;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.ui.fragment.account:
//            BaseAccountFragment

public class AccountCreateFragment extends BaseAccountFragment
{
    static class Views extends com.target.ui.view.a
    {

        Button createButton;
        AccountCreationEmailView email;
        com.target.ui.view.common.a emailOptOut;
        AccountCreationHeaderView header;
        NameView name;
        AccountCreationPasswordView password;
        ScrollView scrollContainer;
        TextView termsAndConditionText;

        Views(View view)
        {
            super(view);
        }
    }

    private final class a
        implements com.target.ui.view.account.AccountCreationEmailView.a
    {

        String email;
        boolean isValid;
        final AccountCreateFragment this$0;

        public void a()
        {
            isValid = false;
        }

        public void a(String s)
        {
            isValid = true;
            email = s;
        }

        private a()
        {
            this$0 = AccountCreateFragment.this;
            super();
        }

    }

    private class b
    {

        boolean emailValid;
        boolean nameValid;
        boolean passwordValid;
        final AccountCreateFragment this$0;

        private b()
        {
            this$0 = AccountCreateFragment.this;
            super();
            emailValid = false;
            passwordValid = false;
            nameValid = false;
        }

    }

    private final class c
        implements com.target.ui.view.common.NameView.f
    {

        String firstName;
        boolean isValid;
        String lastName;
        final AccountCreateFragment this$0;

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

        private c()
        {
            this$0 = AccountCreateFragment.this;
            super();
        }

    }

    private final class d
        implements com.target.ui.view.account.AccountCreationPasswordView.a
    {

        boolean isValid;
        String password;
        final AccountCreateFragment this$0;

        public void a()
        {
            isValid = false;
        }

        public void a(String s)
        {
            isValid = true;
            password = s;
        }

        private d()
        {
            this$0 = AccountCreateFragment.this;
            super();
        }

    }

    private final class e
        implements com.target.ui.view.account.b
    {

        final AccountCreateFragment this$0;

        public void a(View view, boolean flag)
        {
            int i = view.getId();
            if (i == AccountCreateFragment.b(AccountCreateFragment.this).email.getId())
            {
                com.target.ui.fragment.account.AccountCreateFragment.a(AccountCreateFragment.this, flag);
            } else
            {
                if (i == AccountCreateFragment.b(AccountCreateFragment.this).name.getId())
                {
                    AccountCreateFragment.b(AccountCreateFragment.this, flag);
                    return;
                }
                if (i == AccountCreateFragment.b(AccountCreateFragment.this).password.getId())
                {
                    com.target.ui.fragment.account.AccountCreateFragment.c(AccountCreateFragment.this, flag);
                    return;
                }
            }
        }

        private e()
        {
            this$0 = AccountCreateFragment.this;
            super();
        }

    }


    private static final String KEY_NEW_EMAIL = "newEmail";
    public static final String TAG = com/target/ui/fragment/account/AccountCreateFragment.getSimpleName();
    private final android.view.View.OnClickListener mCreateAccountButtonListener = new android.view.View.OnClickListener() {

        final AccountCreateFragment this$0;

        public void onClick(View view)
        {
            com.target.ui.fragment.account.AccountCreateFragment.a(AccountCreateFragment.this);
        }

            
            {
                this$0 = AccountCreateFragment.this;
                super();
            }
    };
    private String mEmail;
    private b mFormState;
    private Views mViews;
    private ClickableSpan privacyPolicySpan;
    private ClickableSpan termsOfServiceSpan;

    public AccountCreateFragment()
    {
        termsOfServiceSpan = new ClickableSpan() {

            final AccountCreateFragment this$0;

            public void onClick(View view)
            {
                com.target.ui.fragment.account.AccountCreateFragment.a(AccountCreateFragment.this, "file:///android_asset/htmls/terms.html", getString(0x7f090313));
            }

            public void updateDrawState(TextPaint textpaint)
            {
                textpaint.setUnderlineText(false);
            }

            
            {
                this$0 = AccountCreateFragment.this;
                super();
            }
        };
        privacyPolicySpan = new ClickableSpan() {

            final AccountCreateFragment this$0;

            public void onClick(View view)
            {
                com.target.ui.fragment.account.AccountCreateFragment.a(AccountCreateFragment.this, "file:///android_asset/htmls/privacy.html", getString(0x7f09030c));
            }

            public void updateDrawState(TextPaint textpaint)
            {
                textpaint.setUnderlineText(false);
            }

            
            {
                this$0 = AccountCreateFragment.this;
                super();
            }
        };
    }

    public static AccountCreateFragment a()
    {
        return new AccountCreateFragment();
    }

    public static AccountCreateFragment a(String s)
    {
        AccountCreateFragment accountcreatefragment = new AccountCreateFragment();
        Bundle bundle = new Bundle();
        bundle.putString("newEmail", s);
        accountcreatefragment.setArguments(bundle);
        return accountcreatefragment;
    }

    private void a(com.target.mothership.model.guest.interfaces.a.d.a a1)
    {
        if (a1 == null)
        {
            com.target.ui.util.q.a(TAG, "Can't handle a null CreateAccountFailureReason");
            return;
        }
        static class _cls4
        {

            static final int $SwitchMap$com$target$mothership$model$guest$interfaces$error$CreateAccountFailure$CreateAccountFailureReason[];

            static 
            {
                $SwitchMap$com$target$mothership$model$guest$interfaces$error$CreateAccountFailure$CreateAccountFailureReason = new int[com.target.mothership.model.guest.interfaces.a.d.a.values().length];
                try
                {
                    $SwitchMap$com$target$mothership$model$guest$interfaces$error$CreateAccountFailure$CreateAccountFailureReason[com.target.mothership.model.guest.interfaces.a.d.a.ERR_LOGIN_ID_ALREADY_EXISTS.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror) { }
            }
        }

        switch (_cls4..SwitchMap.com.target.mothership.model.guest.interfaces.error.CreateAccountFailure.CreateAccountFailureReason[a1.ordinal()])
        {
        default:
            mViews.header.a(getString(0x7f0900be));
            return;

        case 1: // '\001'
            mViews.header.a(getString(0x7f0900bd));
            break;
        }
    }

    private void a(b b1)
    {
        b1.emailValid = mViews.email.a();
        b1.nameValid = mViews.name.a();
        b1.passwordValid = mViews.password.a();
    }

    static void a(AccountCreateFragment accountcreatefragment)
    {
        accountcreatefragment.l();
    }

    static void a(AccountCreateFragment accountcreatefragment, String s, String s1)
    {
        accountcreatefragment.b(s, s1);
    }

    static void a(AccountCreateFragment accountcreatefragment, boolean flag)
    {
        accountcreatefragment.a(flag);
    }

    private void a(boolean flag)
    {
        mFormState.emailValid = flag;
        c(mFormState);
    }

    static Views b(AccountCreateFragment accountcreatefragment)
    {
        return accountcreatefragment.mViews;
    }

    static void b(AccountCreateFragment accountcreatefragment, boolean flag)
    {
        accountcreatefragment.d(flag);
    }

    private void b(String s, String s1)
    {
        s = TargetWebFragment.a(false, s, s1);
        m().d(s);
    }

    private boolean b(b b1)
    {
        return b1.emailValid && b1.nameValid && b1.passwordValid;
    }

    private void c(b b1)
    {
        boolean flag = b(b1);
        mViews.createButton.setEnabled(flag);
    }

    static void c(AccountCreateFragment accountcreatefragment, boolean flag)
    {
        accountcreatefragment.c(flag);
    }

    private void c(boolean flag)
    {
        mFormState.passwordValid = flag;
        c(mFormState);
    }

    private void d(boolean flag)
    {
        mFormState.nameValid = flag;
        c(mFormState);
    }

    private void k()
    {
        SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder(getString(0x7f0900b8));
        SpannableStringUtils.a(spannablestringbuilder, getString(0x7f0900b8), getString(0x7f0900b7), termsOfServiceSpan);
        SpannableStringUtils.a(spannablestringbuilder, getString(0x7f0900b8), getString(0x7f0900b6), privacyPolicySpan);
        SpannableStringUtils.a(spannablestringbuilder, getString(0x7f0900b8), getString(0x7f0900b7), new ForegroundColorSpan(getResources().getColor(0x7f0f00e2)));
        SpannableStringUtils.a(spannablestringbuilder, getString(0x7f0900b8), getString(0x7f0900b6), new ForegroundColorSpan(getResources().getColor(0x7f0f00e2)));
        mViews.termsAndConditionText.setText(spannablestringbuilder);
        mViews.termsAndConditionText.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void l()
    {
        d d1 = new d();
        c c1 = new c();
        a a1 = new a();
        mViews.name.a(c1);
        mViews.password.a(d1);
        mViews.email.a(a1);
        boolean flag = mViews.emailOptOut.isChecked();
        if (!d1.isValid || !c1.isValid || !a1.isValid)
        {
            return;
        } else
        {
            n();
            a(c1.firstName.trim(), c1.lastName.trim(), a1.email.trim(), d1.password, flag);
            v.j().e();
            return;
        }
    }

    private void n()
    {
        if (mViews == null)
        {
            return;
        } else
        {
            o(true);
            mViews.createButton.setEnabled(false);
            mViews.header.a();
            mViews.createButton.setText(getString(0x7f0900ba));
            return;
        }
    }

    private void o()
    {
        o(false);
        mViews.createButton.setEnabled(true);
        mViews.createButton.setText(0x7f0900b9);
        mViews.scrollContainer.smoothScrollTo(0, 0);
    }

    private void p()
    {
        mViews.email.setInputValidationListener(new e());
        mViews.password.setInputValidationListener(new e());
        mViews.name.setInputValidationListener(new e());
        mViews.name.setFirstNameValidator(new FirstNameValidator(getActivity()));
        mViews.name.setLastNameValidator(new LastNameValidator(getActivity()));
        mViews.createButton.setOnClickListener(mCreateAccountButtonListener);
    }

    private void q()
    {
        if (mViews == null)
        {
            return;
        } else
        {
            mViews.createButton.setOnClickListener(null);
            return;
        }
    }

    protected void a(com.target.mothership.model.guest.interfaces.a.d d1)
    {
        o();
        for (d1 = d1.f().iterator(); d1.hasNext(); a((com.target.mothership.model.guest.interfaces.a.d.a)d1.next())) { }
    }

    public boolean a(com.target.ui.e.e e1)
    {
        e1.c(false);
        if (mViews == null)
        {
            return false;
        } else
        {
            h();
            mViews.createButton.setEnabled(true);
            mViews.createButton.setText(getString(0x7f0900b9));
            return true;
        }
    }

    protected void b()
    {
        if (mViews == null)
        {
            return;
        } else
        {
            o();
            mViews.header.a(getString(0x7f0902fc));
            return;
        }
    }

    protected void c()
    {
        o(false);
    }

    protected void d()
    {
        o();
        mViews.header.a(getString(0x7f09027b));
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (getArguments() != null)
        {
            mEmail = getArguments().getString("newEmail");
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f03003e, viewgroup, false);
        mViews = new Views(layoutinflater);
        p();
        mFormState = new b();
        if (com.target.mothership.util.o.g(mEmail))
        {
            mViews.email.setEmail(mEmail);
        }
        mViews.emailOptOut.setText(getString(0x7f0900bc));
        a(mFormState);
        k();
        return layoutinflater;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        o(false);
        q();
        mViews = null;
    }

}
