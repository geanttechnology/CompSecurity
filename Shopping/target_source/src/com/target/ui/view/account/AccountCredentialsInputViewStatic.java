// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.account;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.google.a.a.e;
import com.target.mothership.model.guest.interfaces.AccountDetails;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.ui.util.q;
import com.target.ui.view.a;

public class AccountCredentialsInputViewStatic extends LinearLayout
{
    static class Views extends a
    {

        EditText account;
        EditText password;

        Views(View view)
        {
            super(view);
        }
    }


    private static final String TAG = com/target/ui/view/account/AccountCredentialsInputViewStatic.getSimpleName();
    private Views mViews;

    public AccountCredentialsInputViewStatic(Context context)
    {
        super(context);
        a(context);
    }

    public AccountCredentialsInputViewStatic(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a(context);
    }

    public AccountCredentialsInputViewStatic(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a(context);
    }

    private void a(Context context)
    {
        inflate(context, 0x7f0300fa, this);
        mViews = new Views(this);
        mViews.account.setEnabled(false);
        mViews.password.setEnabled(false);
    }

    private void a(AccountDetails accountdetails)
    {
        accountdetails = accountdetails.getEmailAddress();
        mViews.account.setText(accountdetails);
        mViews.password.setText(getResources().getString(0x7f09007d));
    }

    public void a(Guest guest)
    {
        if (guest.isAnonymous())
        {
            q.a(TAG, "Tried to show guest credentials but the guest is anonymous");
            return;
        }
        if (!guest.getAccountDetails().b())
        {
            q.a(TAG, "Tried to show guest credentials but the guest has no account details");
            return;
        } else
        {
            a((AccountDetails)guest.getAccountDetails().c());
            return;
        }
    }

}
