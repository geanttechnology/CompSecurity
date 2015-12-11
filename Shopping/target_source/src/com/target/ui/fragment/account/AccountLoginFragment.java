// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.account;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import com.target.ui.analytics.a.w;
import com.target.ui.e.e;
import com.target.ui.e.j;
import com.target.ui.fragment.account.a.b;
import com.target.ui.fragment.account.a.c;
import com.target.ui.util.e.a;
import com.target.ui.util.validation.h;
import com.target.ui.view.account.AccountCredentialsInputView;
import com.target.ui.view.account.AccountExternalLaunchView;
import com.target.ui.view.account.AccountInternalLaunchView;
import com.target.ui.view.account.AccountLoginHeaderView;
import com.target.ui.view.account.SettingsView;

// Referenced classes of package com.target.ui.fragment.account:
//            BaseAccountFragment, ForgotPasswordDialog, ExternalUrlLauncherImpl, c

public class AccountLoginFragment extends BaseAccountFragment
    implements BaseAccountDialog.c, BaseAccountDialog.d
{
    static class Views extends com.target.ui.view.a
    {

        AccountCredentialsInputView accountInputView;
        AccountExternalLaunchView externalLaunchView;
        View forgotPasswordButton;
        AccountLoginHeaderView header;
        AccountInternalLaunchView internalLaunchView;
        Button loginButton;
        ScrollView scrollContainer;
        SettingsView settingsView;

        Views(View view)
        {
            super(view);
        }
    }

    private class a
        implements com.target.ui.view.account.AccountCredentialsInputView.a
    {

        private String account;
        private boolean isValid;
        private String password;
        final AccountLoginFragment this$0;

        static boolean a(a a1)
        {
            return a1.isValid;
        }

        static String b(a a1)
        {
            return a1.account;
        }

        static String c(a a1)
        {
            return a1.password;
        }

        public void a()
        {
            isValid = false;
        }

        public void a(String s, String s1)
        {
            account = s;
            password = s1;
            isValid = true;
        }

        private a()
        {
            this$0 = AccountLoginFragment.this;
            super();
        }

    }

    private class b
        implements android.view.View.OnClickListener
    {

        final AccountLoginFragment this$0;

        public void onClick(View view)
        {
            com.target.ui.fragment.account.AccountLoginFragment.b(AccountLoginFragment.this);
        }

        private b()
        {
            this$0 = AccountLoginFragment.this;
            super();
        }

    }

    private class c
        implements android.view.View.OnClickListener
    {

        final AccountLoginFragment this$0;

        public void onClick(View view)
        {
            com.target.ui.fragment.account.AccountLoginFragment.a(AccountLoginFragment.this);
        }

        private c()
        {
            this$0 = AccountLoginFragment.this;
            super();
        }

    }

    private class d
        implements com.target.ui.view.account.AccountLoginHeaderView.a
    {

        final AccountLoginFragment this$0;

        public void a()
        {
            com.target.ui.fragment.account.AccountLoginFragment.b(AccountLoginFragment.this);
        }

        public void a(String s)
        {
            Intent intent = new Intent("android.intent.action.DIAL");
            intent.setData(Uri.parse((new StringBuilder()).append("tel:").append(s).toString()));
            startActivity(intent);
        }

        private d()
        {
            this$0 = AccountLoginFragment.this;
            super();
        }

    }

    private class e
        implements com.target.ui.view.account.AccountCredentialsInputView.c
    {

        final AccountLoginFragment this$0;

        public void a(View view, String s, String s1)
        {
            com.target.ui.fragment.account.AccountLoginFragment.c(AccountLoginFragment.this);
            AccountLoginFragment.this.a(s, s1);
            w.j().e();
        }

        public void a(View view, boolean flag)
        {
            AccountLoginFragment.d(AccountLoginFragment.this).loginButton.setEnabled(flag);
        }

        private e()
        {
            this$0 = AccountLoginFragment.this;
            super();
        }

    }


    private static final String SCHEME_TEL = "tel:";
    private static final String TAG = com/target/ui/fragment/account/AccountLoginFragment.getSimpleName();
    private com.target.ui.view.common.h mSnackBar;
    private com.target.ui.l.a mUserPreferenceService;
    private Views mViews;
    private j mVlcManagerWrapperProvider;

    public AccountLoginFragment()
    {
    }

    public static AccountLoginFragment a()
    {
        return new AccountLoginFragment();
    }

    static void a(AccountLoginFragment accountloginfragment)
    {
        accountloginfragment.n();
    }

    private void b(com.target.mothership.model.guest.interfaces.a.c c1)
    {
        mViews.header.a(c1);
        mViews.scrollContainer.smoothScrollTo(0, 0);
    }

    static void b(AccountLoginFragment accountloginfragment)
    {
        accountloginfragment.k();
    }

    static void c(AccountLoginFragment accountloginfragment)
    {
        accountloginfragment.o();
    }

    private void c(String s)
    {
        com.target.ui.fragment.account.ForgotPasswordDialog.a(s, this).show(getFragmentManager(), ForgotPasswordDialog.TAG);
    }

    static Views d(AccountLoginFragment accountloginfragment)
    {
        return accountloginfragment.mViews;
    }

    private void k()
    {
        String s = mViews.accountInputView.a();
        if (h.i(s))
        {
            c(s);
            return;
        } else
        {
            c(((String) (null)));
            return;
        }
    }

    private void n()
    {
        o();
        a a1 = new a();
        mViews.accountInputView.a(a1);
        if (!com.target.ui.fragment.account.a.a(a1))
        {
            return;
        } else
        {
            a(com.target.ui.fragment.account.a.b(a1), com.target.ui.fragment.account.a.c(a1));
            w.j().e();
            return;
        }
    }

    private void o()
    {
        com.target.ui.util.e.a.a(this);
        o(true);
        mViews.loginButton.setEnabled(false);
        mViews.loginButton.setText(0x7f09007a);
        mViews.header.a();
    }

    private void p()
    {
        mViews.header.setClickListener(new d());
        mViews.loginButton.setOnClickListener(new c());
        mViews.accountInputView.setCredentialsValidationListener(new e());
        mViews.forgotPasswordButton.setOnClickListener(new b());
        mViews.externalLaunchView.setAccountExternalLaunchClickListener(new com.target.ui.fragment.account.a.b(new ExternalUrlLauncherImpl(getActivity())));
        mViews.internalLaunchView.setAccountInternalLaunchClickListener(new com.target.ui.fragment.account.a.c(getActivity(), m()));
        mViews.settingsView.setSettingsViewListener(new com.target.ui.fragment.account.c(mUserPreferenceService, mVlcManagerWrapperProvider.o()));
    }

    private void q()
    {
        if (mViews == null)
        {
            return;
        } else
        {
            mViews.header.setClickListener(null);
            mViews.loginButton.setOnClickListener(null);
            mViews.accountInputView.setCredentialsValidationListener(null);
            mViews.forgotPasswordButton.setOnClickListener(null);
            mViews.externalLaunchView.setAccountExternalLaunchClickListener(null);
            mViews.internalLaunchView.setAccountInternalLaunchClickListener(null);
            mViews.settingsView.setSettingsViewListener(null);
            return;
        }
    }

    protected void a(com.target.mothership.model.guest.interfaces.a.c c1)
    {
        mViews.loginButton.setEnabled(true);
        mViews.loginButton.setText(0x7f090079);
        mViews.accountInputView.b();
        o(false);
        b(c1);
    }

    public void a(String s)
    {
        mSnackBar.c(getString(0x7f09006c));
        mViews.accountInputView.setEmailAddress(s);
    }

    public boolean a(com.target.ui.e.e e1)
    {
        e1.c(false);
        h();
        if (mViews == null)
        {
            return false;
        } else
        {
            mViews.loginButton.setEnabled(true);
            mViews.loginButton.setText(0x7f090079);
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
            mViews.header.a(getString(0x7f0902fc));
            mViews.scrollContainer.smoothScrollTo(0, 0);
            o(false);
            return;
        }
    }

    public void b(String s)
    {
        mSnackBar.c(getString(0x7f090074));
        mViews.accountInputView.setEmailAddress(s);
    }

    protected void d()
    {
        if (mViews == null)
        {
            return;
        } else
        {
            o(false);
            mViews.header.a(getString(0x7f09027b));
            return;
        }
    }

    protected void e()
    {
        if (mViews == null)
        {
            return;
        } else
        {
            mViews.loginButton.setEnabled(true);
            o(false);
            return;
        }
    }

    public BaseAccountDialog.c l()
    {
        return this;
    }

    public void n_()
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mSnackBar = new com.target.ui.view.common.h(getActivity());
        mUserPreferenceService = com.target.ui.l.a.a();
        try
        {
            mVlcManagerWrapperProvider = (j)getActivity();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            throw new ClassCastException((new StringBuilder()).append("Activity must implement ").append(com/target/ui/e/j.getSimpleName()).toString());
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030043, viewgroup, false);
        mViews = new Views(layoutinflater);
        mViews.loginButton.setEnabled(mViews.accountInputView.d());
        mViews.settingsView.setNotificationEnabled(mUserPreferenceService.b());
        mViews.settingsView.setInStoreLocationEnabled(mUserPreferenceService.c());
        p();
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
        mSnackBar = null;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        q();
        mViews = null;
        o(false);
    }

    public void onPause()
    {
        super.onPause();
        mSnackBar.a();
        com.target.ui.util.e.a.a(this);
    }

}
