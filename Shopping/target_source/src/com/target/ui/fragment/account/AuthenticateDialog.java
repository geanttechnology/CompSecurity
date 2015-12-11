// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.account;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.c.a.b;
import com.google.a.a.e;
import com.google.a.a.f;
import com.target.mothership.model.d;
import com.target.mothership.model.guest.interfaces.AccountDetails;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.guest.interfaces.a.c;
import com.target.mothership.services.o;
import com.target.ui.service.a;
import com.target.ui.util.al;
import com.target.ui.view.account.AccountCredentialsInputView;
import java.io.Serializable;

// Referenced classes of package com.target.ui.fragment.account:
//            BaseAccountDialog, AccountLockedDialog, ForgotPasswordDialog

public class AuthenticateDialog extends BaseAccountDialog
    implements com.target.ui.view.account.AccountCredentialsInputView.c
{
    static class Views extends com.target.ui.view.a
    {

        AccountCredentialsInputView credentials;
        View errorContainer;
        TextView errorText;
        View forgotPassword;
        View formContainer;
        View progressContainer;
        Button signInButton;
        TextView title;

        Views(View view)
        {
            super(view);
        }
    }

    private final class a
        implements com.target.ui.view.account.AccountCredentialsInputView.a
    {

        String account;
        boolean isValid;
        String password;
        final AuthenticateDialog this$0;

        public void a()
        {
            isValid = false;
        }

        public void a(String s, String s1)
        {
            isValid = true;
            account = s;
            password = s1;
        }

        private a()
        {
            this$0 = AuthenticateDialog.this;
            super();
        }

    }


    private static final String ARG_ERROR = "authFailureReason";
    private static final String ARG_GUEST = "guest";
    private static final String ARG_TAG = "tag";
    public static final String TAG = com/target/ui/fragment/account/AuthenticateDialog.getSimpleName();
    private final android.view.View.OnClickListener mForgotPasswordClickListener = new android.view.View.OnClickListener() {

        final AuthenticateDialog this$0;

        public void onClick(View view)
        {
            com.target.ui.fragment.account.AuthenticateDialog.d(AuthenticateDialog.this);
        }

            
            {
                this$0 = AuthenticateDialog.this;
                super();
            }
    };
    private BaseAccountDialog.e mListener;
    private final d mLoginReceiver = new d() {

        final AuthenticateDialog this$0;

        public String a()
        {
            return AuthenticateDialog.TAG;
        }

        public void a(Guest guest)
        {
            if (com.target.ui.fragment.account.AuthenticateDialog.a(AuthenticateDialog.this) == null)
            {
                return;
            }
            if (com.target.ui.fragment.account.AuthenticateDialog.b(AuthenticateDialog.this) != null)
            {
                com.target.ui.fragment.account.AuthenticateDialog.a(AuthenticateDialog.this, guest, com.target.ui.fragment.account.AuthenticateDialog.b(AuthenticateDialog.this));
                return;
            } else
            {
                com.target.ui.fragment.account.AuthenticateDialog.a(AuthenticateDialog.this, guest);
                return;
            }
        }

        public void a(c c1)
        {
            if (com.target.ui.fragment.account.AuthenticateDialog.a(AuthenticateDialog.this) == null)
            {
                return;
            } else
            {
                com.target.ui.fragment.account.AuthenticateDialog.a(AuthenticateDialog.this, c1);
                return;
            }
        }

        public volatile void a(Object obj)
        {
            a((Guest)obj);
        }

        public void b(Object obj)
        {
            a((c)obj);
        }

            
            {
                this$0 = AuthenticateDialog.this;
                super();
            }
    };
    private o mRequestRetryable;
    private final android.view.View.OnClickListener mSubmitButtonListener = new android.view.View.OnClickListener() {

        final AuthenticateDialog this$0;

        public void onClick(View view)
        {
            com.target.ui.fragment.account.AuthenticateDialog.c(AuthenticateDialog.this);
        }

            
            {
                this$0 = AuthenticateDialog.this;
                super();
            }
    };
    private Views mViews;

    public AuthenticateDialog()
    {
    }

    static Views a(AuthenticateDialog authenticatedialog)
    {
        return authenticatedialog.mViews;
    }

    public static AuthenticateDialog a(Guest guest, Fragment fragment)
        throws IllegalArgumentException
    {
        AuthenticateDialog authenticatedialog = new AuthenticateDialog();
        if (fragment != null)
        {
            authenticatedialog.setTargetFragment(fragment, 0);
        }
        return (AuthenticateDialog)com.c.a.b.a(authenticatedialog).a("guest", guest).a();
    }

    private static AuthenticateDialog a(Guest guest, Fragment fragment, com.target.mothership.model.guest.interfaces.a.c.a a1)
    {
        com.google.a.a.f.a(a1);
        guest = a(guest, fragment);
        guest.getArguments().putInt("authFailureReason", a1.ordinal());
        return guest;
    }

    public static AuthenticateDialog a(Guest guest, Fragment fragment, Serializable serializable)
        throws IllegalArgumentException
    {
        AuthenticateDialog authenticatedialog = new AuthenticateDialog();
        if (fragment != null)
        {
            authenticatedialog.setTargetFragment(fragment, 0);
        }
        return (AuthenticateDialog)com.c.a.b.a(authenticatedialog).a("guest", guest).a("tag", serializable).a();
    }

    private BaseAccountDialog.e a()
    {
        BaseAccountDialog.f f1 = (BaseAccountDialog.f)getTargetFragment();
        if (f1 == null)
        {
            return null;
        } else
        {
            return f1.n();
        }
    }

    private String a(com.target.mothership.model.guest.interfaces.a.c.a a1)
    {
        static class _cls4
        {

            static final int $SwitchMap$com$target$mothership$model$guest$interfaces$error$AuthFailure$AuthFailureReason[];

            static 
            {
                $SwitchMap$com$target$mothership$model$guest$interfaces$error$AuthFailure$AuthFailureReason = new int[com.target.mothership.model.guest.interfaces.a.c.a.values().length];
                try
                {
                    $SwitchMap$com$target$mothership$model$guest$interfaces$error$AuthFailure$AuthFailureReason[com.target.mothership.model.guest.interfaces.a.c.a.ERR_ACCOUNT_LOCKED.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$target$mothership$model$guest$interfaces$error$AuthFailure$AuthFailureReason[com.target.mothership.model.guest.interfaces.a.c.a.ERR_REQUIRED_FIELD_EMAIL.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$target$mothership$model$guest$interfaces$error$AuthFailure$AuthFailureReason[com.target.mothership.model.guest.interfaces.a.c.a.ERR_REQUIRED_FIELD_PASSWORD.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$target$mothership$model$guest$interfaces$error$AuthFailure$AuthFailureReason[com.target.mothership.model.guest.interfaces.a.c.a.ERR_INVALID_EMAIL.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$mothership$model$guest$interfaces$error$AuthFailure$AuthFailureReason[com.target.mothership.model.guest.interfaces.a.c.a.ERR_INVALID_ACCOUNT_OR_PASSWORD.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls4..SwitchMap.com.target.mothership.model.guest.interfaces.error.AuthFailure.AuthFailureReason[a1.ordinal()])
        {
        default:
            return getResources().getString(0x7f09005c);

        case 1: // '\001'
            return getResources().getString(0x7f09005d);
        }
    }

    private void a(Guest guest)
    {
        if (mListener != null)
        {
            mListener.a(guest);
        }
        dismiss();
    }

    private void a(Guest guest, o o1)
    {
        if (mListener != null)
        {
            Serializable serializable = c();
            mListener.b(serializable);
        }
        o1.a(guest);
        o1.a();
        dismiss();
    }

    private void a(c c1)
    {
        android.support.v4.app.h h1 = getFragmentManager();
        Fragment fragment = getTargetFragment();
        if (c1.e() == com.target.mothership.model.guest.interfaces.a.c.a.ERR_ACCOUNT_LOCKED)
        {
            c1 = com.target.ui.fragment.account.AccountLockedDialog.a(fragment);
        } else
        {
            c1 = a(f(), fragment, (com.target.mothership.model.guest.interfaces.a.c.a)c1.e());
        }
        dismiss();
        c1.show(h1, TAG);
    }

    static void a(AuthenticateDialog authenticatedialog, Guest guest)
    {
        authenticatedialog.a(guest);
    }

    static void a(AuthenticateDialog authenticatedialog, Guest guest, o o1)
    {
        authenticatedialog.a(guest, o1);
    }

    static void a(AuthenticateDialog authenticatedialog, c c1)
    {
        authenticatedialog.a(c1);
    }

    private void a(String s, String s1)
    {
        e();
        com.target.ui.service.a.a().a(s, s1, mLoginReceiver);
    }

    static o b(AuthenticateDialog authenticatedialog)
    {
        return authenticatedialog.mRequestRetryable;
    }

    private void b()
    {
        a a1 = new a();
        mViews.credentials.a(a1);
        if (!a1.isValid)
        {
            return;
        } else
        {
            a(a1.account, a1.password);
            return;
        }
    }

    private Serializable c()
    {
        Bundle bundle;
        for (bundle = getArguments(); bundle == null || !bundle.containsKey("tag");)
        {
            return null;
        }

        return bundle.getSerializable("tag");
    }

    static void c(AuthenticateDialog authenticatedialog)
    {
        authenticatedialog.b();
    }

    private void d()
    {
        dismiss();
        com.target.ui.fragment.account.ForgotPasswordDialog.a(h(), (BaseAccountDialog.d)getTargetFragment()).show(getFragmentManager(), ForgotPasswordDialog.TAG);
    }

    static void d(AuthenticateDialog authenticatedialog)
    {
        authenticatedialog.d();
    }

    private void e()
    {
        com.target.ui.util.e.a.a(this);
        mViews.signInButton.setText(0x7f09007a);
        mViews.signInButton.setEnabled(false);
        al.b(mViews.progressContainer);
    }

    private Guest f()
    {
        Bundle bundle;
        for (bundle = getArguments(); bundle == null || !bundle.containsKey("guest");)
        {
            return null;
        }

        return (Guest)bundle.getParcelable("guest");
    }

    private com.target.mothership.model.guest.interfaces.a.c.a g()
    {
        Bundle bundle;
        for (bundle = getArguments(); bundle == null || !bundle.containsKey("authFailureReason");)
        {
            return null;
        }

        return com.target.mothership.model.guest.interfaces.a.c.a.values()[bundle.getInt("authFailureReason")];
    }

    private String h()
    {
        Guest guest;
        for (guest = f(); guest == null || !guest.getAccountDetails().b();)
        {
            return null;
        }

        return ((AccountDetails)guest.getAccountDetails().c()).getEmailAddress();
    }

    public void a(View view, String s, String s1)
    {
        a(s, s1);
    }

    public void a(View view, boolean flag)
    {
        mViews.signInButton.setEnabled(flag);
    }

    public void a(o o1)
    {
        mRequestRetryable = o1;
    }

    public void onAttach(Activity activity)
    {
        mListener = a();
        super.onAttach(activity);
    }

    public void onCancel(DialogInterface dialoginterface)
    {
        super.onCancel(dialoginterface);
        if (mListener == null)
        {
            return;
        } else
        {
            mListener.c();
            return;
        }
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        bundle = super.onCreateDialog(bundle);
        bundle.requestWindowFeature(1);
        return bundle;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f03003d, viewgroup, false);
        mViews = new Views(layoutinflater);
        viewgroup = f();
        if (viewgroup != null && !viewgroup.isAnonymous())
        {
            mViews.credentials.a(viewgroup);
            mViews.credentials.c();
            mViews.title.setText(getString(0x7f090052));
        } else
        {
            mViews.title.setText(getString(0x7f090051));
        }
        viewgroup = g();
        if (viewgroup != null)
        {
            al.b(mViews.errorContainer);
            mViews.errorText.setText(a(viewgroup));
        }
        mViews.credentials.setCredentialsValidationListener(this);
        mViews.signInButton.setEnabled(mViews.credentials.d());
        mViews.signInButton.setOnClickListener(mSubmitButtonListener);
        mViews.forgotPassword.setOnClickListener(mForgotPasswordClickListener);
        al.c(mViews.progressContainer);
        return layoutinflater;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        mViews = null;
        com.target.ui.service.a.a().a(TAG);
    }

    public void onDetach()
    {
        mListener = null;
        super.onDetach();
    }

}
