// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.navigation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.a.a.e;
import com.target.mothership.model.guest.interfaces.AccountDetails;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.ui.i.a.a;
import com.target.ui.util.al;

public class NavigationHeaderView extends FrameLayout
{
    static class Views extends com.target.ui.view.a
    {

        TextView accountNameText;
        View bullseyeLarge;
        View bullseyeSmall;

        Views(View view)
        {
            super(view);
        }
    }


    private Views mViews;

    public NavigationHeaderView(Context context)
    {
        super(context);
        a(context);
    }

    public NavigationHeaderView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a(context);
    }

    public NavigationHeaderView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a(context);
    }

    private void a(Context context)
    {
        inflate(context, 0x7f030173, this);
        mViews = new Views(this);
    }

    private void a(AccountDetails accountdetails)
    {
        accountdetails = com.target.ui.i.a.a.a(accountdetails);
        al.b(mViews.accountNameText);
        mViews.accountNameText.setText(accountdetails);
        al.a(mViews.bullseyeSmall, new View[] {
            mViews.bullseyeLarge
        });
    }

    private void b()
    {
        al.a(mViews.bullseyeLarge, new View[] {
            mViews.bullseyeSmall, mViews.accountNameText
        });
    }

    public void a()
    {
        b();
    }

    public void a(int i)
    {
        mViews.bullseyeLarge.setTranslationY(mViews.bullseyeLarge.getTranslationY() + (float)i);
        mViews.bullseyeSmall.setTranslationY(mViews.bullseyeSmall.getTranslationY() + (float)i);
        android.view.ViewGroup.LayoutParams layoutparams = getLayoutParams();
        layoutparams.height = layoutparams.height + i;
        requestLayout();
    }

    public void a(e e1)
    {
        if (!e1.b())
        {
            b();
            return;
        } else
        {
            a((Guest)e1.c());
            return;
        }
    }

    public void a(Guest guest)
    {
        if (guest.isAnonymous() || !guest.getAccountDetails().b())
        {
            b();
            return;
        } else
        {
            a((AccountDetails)guest.getAccountDetails().c());
            return;
        }
    }
}
