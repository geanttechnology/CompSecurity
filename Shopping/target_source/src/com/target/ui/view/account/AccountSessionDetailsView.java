// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.account;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.ui.view.a;

// Referenced classes of package com.target.ui.view.account:
//            GuestNameViewStatic, AccountCredentialsInputViewStatic

public class AccountSessionDetailsView extends LinearLayout
{
    static class Views extends a
    {

        AccountCredentialsInputViewStatic credentials;
        GuestNameViewStatic name;

        Views(View view)
        {
            super(view);
        }
    }


    private Views mViews;

    public AccountSessionDetailsView(Context context)
    {
        super(context);
        a(context);
    }

    public AccountSessionDetailsView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a(context);
    }

    public AccountSessionDetailsView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a(context);
    }

    private void a(Context context)
    {
        setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, -2));
        setOrientation(1);
        inflate(context, 0x7f0300fc, this);
        mViews = new Views(this);
    }

    public void a(Guest guest)
    {
        mViews.name.a(guest);
        mViews.credentials.a(guest);
    }
}
