// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.account;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.target.mothership.model.h;
import com.target.mothership.services.x;
import com.target.mothership.util.o;
import com.target.ui.util.al;
import com.target.ui.util.e.a;
import com.target.ui.view.RevealImageView;
import com.target.ui.view.account.ForgotPasswordInputView;

// Referenced classes of package com.target.ui.fragment.account:
//            BaseAccountDialog

public class ForgotPasswordDialog extends BaseAccountDialog
{
    static class Views extends com.target.ui.view.a
    {

        RevealImageView bullseye;
        ViewGroup contentContainer;
        ForgotPasswordInputView emailInput;
        TextView header;
        TextView message;
        ViewGroup progressContainer;
        View root;
        View textContainer;
        View textSentContainer;

        Views(View view)
        {
            super(view);
            root = view;
        }
    }

    private class a
        implements com.target.ui.view.account.ForgotPasswordInputView.b
    {

        final ForgotPasswordDialog this$0;

        public void a(String s)
        {
            com.target.ui.fragment.account.ForgotPasswordDialog.a(ForgotPasswordDialog.this);
            com.target.ui.fragment.account.ForgotPasswordDialog.a(ForgotPasswordDialog.this, s);
            com.target.ui.service.a.a().a(s, ForgotPasswordDialog.b(ForgotPasswordDialog.this));
        }

        private a()
        {
            this$0 = ForgotPasswordDialog.this;
            super();
        }

    }


    private static final String ARG_EMAIL = "Email";
    public static final String TAG = com/target/ui/fragment/account/ForgotPasswordDialog.getSimpleName();
    private String mEmail;
    private BaseAccountDialog.c mListener;
    private final h mResetPasswordReceiver = new h() {

        final ForgotPasswordDialog this$0;

        public String a()
        {
            return ForgotPasswordDialog.TAG;
        }

        public void a(x x1)
        {
            if (ForgotPasswordDialog.c(ForgotPasswordDialog.this) == null || ForgotPasswordDialog.d(ForgotPasswordDialog.this) == null)
            {
                return;
            } else
            {
                com.target.ui.fragment.account.ForgotPasswordDialog.a(ForgotPasswordDialog.this, false);
                ForgotPasswordDialog.d(ForgotPasswordDialog.this).a(ForgotPasswordDialog.e(ForgotPasswordDialog.this));
                dismiss();
                return;
            }
        }

        public volatile void a(Object obj)
        {
            a((Void)obj);
        }

        public void a(Void void1)
        {
            if (ForgotPasswordDialog.c(ForgotPasswordDialog.this) == null || ForgotPasswordDialog.d(ForgotPasswordDialog.this) == null)
            {
                return;
            } else
            {
                com.target.ui.fragment.account.ForgotPasswordDialog.a(ForgotPasswordDialog.this, false);
                ForgotPasswordDialog.d(ForgotPasswordDialog.this).b(ForgotPasswordDialog.e(ForgotPasswordDialog.this));
                dismiss();
                return;
            }
        }

        public void b(Object obj)
        {
            a((x)obj);
        }

            
            {
                this$0 = ForgotPasswordDialog.this;
                super();
            }
    };
    private Views mViews;

    public ForgotPasswordDialog()
    {
    }

    public static ForgotPasswordDialog a(String s, BaseAccountDialog.d d1)
    {
        ForgotPasswordDialog forgotpassworddialog = new ForgotPasswordDialog();
        a(((DialogFragment) (forgotpassworddialog)), d1);
        d1 = new Bundle();
        if (!o.c(s))
        {
            d1.putString("Email", s);
        }
        forgotpassworddialog.setArguments(d1);
        return forgotpassworddialog;
    }

    static String a(ForgotPasswordDialog forgotpassworddialog, String s)
    {
        forgotpassworddialog.mEmail = s;
        return s;
    }

    private void a()
    {
        a(true);
        com.target.ui.util.e.a.a(this);
    }

    private static void a(DialogFragment dialogfragment, BaseAccountDialog.d d1)
        throws IllegalArgumentException
    {
        if (d1 == null)
        {
            throw new IllegalArgumentException("ForgotPasswordDialogListenerProvider listener cannot be null");
        }
        if (!(d1 instanceof Fragment))
        {
            throw new IllegalArgumentException("Must implement ForgotPasswordDialogListenerProvider");
        } else
        {
            dialogfragment.setTargetFragment((Fragment)d1, 0);
            return;
        }
    }

    static void a(ForgotPasswordDialog forgotpassworddialog)
    {
        forgotpassworddialog.a();
    }

    static void a(ForgotPasswordDialog forgotpassworddialog, boolean flag)
    {
        forgotpassworddialog.a(flag);
    }

    private void a(boolean flag)
    {
        al.a(mViews.progressContainer, flag);
    }

    static h b(ForgotPasswordDialog forgotpassworddialog)
    {
        return forgotpassworddialog.mResetPasswordReceiver;
    }

    private String b()
    {
        Bundle bundle = getArguments();
        if (bundle.containsKey("Email"))
        {
            return bundle.getString("Email");
        } else
        {
            return "";
        }
    }

    static Views c(ForgotPasswordDialog forgotpassworddialog)
    {
        return forgotpassworddialog.mViews;
    }

    private void c()
    {
        a(false);
        al.a(mViews.contentContainer, new View[] {
            mViews.progressContainer
        });
    }

    static BaseAccountDialog.c d(ForgotPasswordDialog forgotpassworddialog)
    {
        return forgotpassworddialog.mListener;
    }

    static String e(ForgotPasswordDialog forgotpassworddialog)
    {
        return forgotpassworddialog.mEmail;
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        if (getTargetFragment() instanceof BaseAccountDialog.d)
        {
            mListener = ((BaseAccountDialog.d)getTargetFragment()).l();
            return;
        } else
        {
            throw new IllegalStateException("Make sure to implement ForgotPasswordDialogListenerProvider");
        }
    }

    public void onCancel(DialogInterface dialoginterface)
    {
        super.onCancel(dialoginterface);
        if (mListener == null)
        {
            return;
        } else
        {
            mListener.n_();
            return;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f03003f, viewgroup, false);
        mViews = new Views(layoutinflater);
        mViews.emailInput.setOnResetRequestedListener(new a());
        mViews.emailInput.a(b(), true);
        c();
        return layoutinflater;
    }

    public void onDetach()
    {
        super.onDetach();
        mListener = null;
    }

}
