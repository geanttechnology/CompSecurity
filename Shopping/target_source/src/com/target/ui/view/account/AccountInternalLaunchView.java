// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.account;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.target.ui.util.al;

public class AccountInternalLaunchView extends LinearLayout
{
    static class Views extends com.target.ui.view.a
    {

        View caPrivacy;
        View caSupplyChainAct;
        View privacy;
        View terms;

        Views(View view)
        {
            super(view);
        }
    }

    public static interface a
    {

        public abstract void a();

        public abstract void b();

        public abstract void c();

        public abstract void d();
    }

    private class b
        implements android.view.View.OnClickListener
    {

        final AccountInternalLaunchView this$0;

        public void onClick(View view)
        {
            if (AccountInternalLaunchView.a(AccountInternalLaunchView.this) == null)
            {
                return;
            }
            switch (view.getId())
            {
            default:
                return;

            case 2131755730: 
                AccountInternalLaunchView.a(AccountInternalLaunchView.this).a();
                return;

            case 2131755731: 
                AccountInternalLaunchView.a(AccountInternalLaunchView.this).b();
                return;

            case 2131755732: 
                AccountInternalLaunchView.a(AccountInternalLaunchView.this).c();
                return;

            case 2131755733: 
                AccountInternalLaunchView.a(AccountInternalLaunchView.this).d();
                break;
            }
        }

        private b()
        {
            this$0 = AccountInternalLaunchView.this;
            super();
        }

    }


    private a mListener;
    private Views mViews;

    public AccountInternalLaunchView(Context context)
    {
        super(context);
        a(context);
    }

    public AccountInternalLaunchView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a(context);
    }

    public AccountInternalLaunchView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a(context);
    }

    static a a(AccountInternalLaunchView accountinternallaunchview)
    {
        return accountinternallaunchview.mListener;
    }

    private void a(Context context)
    {
        setOrientation(1);
        inflate(context, 0x7f0300f1, this);
        mViews = new Views(this);
        al.a(new b(), new View[] {
            mViews.privacy, mViews.caPrivacy, mViews.caSupplyChainAct, mViews.terms
        });
    }

    public void setAccountInternalLaunchClickListener(a a1)
    {
        mListener = a1;
    }
}
