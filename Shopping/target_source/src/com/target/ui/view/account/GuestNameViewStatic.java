// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.account;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.google.a.a.e;
import com.target.mothership.model.guest.interfaces.AccountDetails;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.ui.i.a.a;
import com.target.ui.util.q;

public class GuestNameViewStatic extends FrameLayout
{
    static class Views extends com.target.ui.view.a
    {

        EditText firstName;
        EditText lastName;
        View root;

        Views(View view)
        {
            super(view);
            root = view;
            firstName = (EditText)view.findViewById(0x7f1002d7);
            lastName = (EditText)view.findViewById(0x7f1002d9);
        }
    }


    private static final String TAG = com/target/ui/view/account/GuestNameViewStatic.getSimpleName();
    private Views mViews;

    public GuestNameViewStatic(Context context)
    {
        super(context);
        a(context);
    }

    public GuestNameViewStatic(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a(context);
    }

    public GuestNameViewStatic(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a(context);
    }

    private void a(Context context)
    {
        inflate(context, 0x7f0300f2, this);
        mViews = new Views(this);
        mViews.lastName.setEnabled(false);
        mViews.firstName.setEnabled(false);
    }

    private void a(AccountDetails accountdetails)
    {
        mViews.firstName.setText(com.target.ui.i.a.a.a(accountdetails));
    }

    public void a(Guest guest)
    {
        if (guest.isAnonymous())
        {
            q.a(TAG, "Tried to show guest name, but the guest is anonymous");
            return;
        }
        if (!guest.getAccountDetails().b())
        {
            q.a(TAG, "Tried to show guest name, but the guest has no account details");
            return;
        } else
        {
            a((AccountDetails)guest.getAccountDetails().c());
            return;
        }
    }

}
