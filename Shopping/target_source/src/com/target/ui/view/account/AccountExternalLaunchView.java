// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.account;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.target.ui.util.al;

public class AccountExternalLaunchView extends LinearLayout
{
    static class Views extends com.target.ui.view.a
    {

        View redCard;
        View trackOrder;

        Views(View view)
        {
            super(view);
        }
    }

    public static interface a
    {

        public abstract void a();

        public abstract void b();
    }

    private class b
        implements android.view.View.OnClickListener
    {

        final AccountExternalLaunchView this$0;

        public void onClick(View view)
        {
            if (AccountExternalLaunchView.a(AccountExternalLaunchView.this) == null)
            {
                return;
            }
            switch (view.getId())
            {
            default:
                return;

            case 2131755706: 
                AccountExternalLaunchView.a(AccountExternalLaunchView.this).a();
                return;

            case 2131755707: 
                AccountExternalLaunchView.a(AccountExternalLaunchView.this).b();
                break;
            }
        }

        private b()
        {
            this$0 = AccountExternalLaunchView.this;
            super();
        }

    }


    private a mListener;
    private Views mViews;

    public AccountExternalLaunchView(Context context)
    {
        super(context);
        a(context);
    }

    public AccountExternalLaunchView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a(context);
    }

    public AccountExternalLaunchView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a(context);
    }

    static a a(AccountExternalLaunchView accountexternallaunchview)
    {
        return accountexternallaunchview.mListener;
    }

    private void a(Context context)
    {
        setOrientation(1);
        inflate(context, 0x7f0300e8, this);
        mViews = new Views(this);
        al.a(new b(), new View[] {
            mViews.redCard, mViews.trackOrder
        });
    }

    public void setAccountExternalLaunchClickListener(a a1)
    {
        mListener = a1;
    }
}
