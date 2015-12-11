// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.account;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.target.ui.util.al;

public class AccountHelpView extends LinearLayout
{
    static class Views extends com.target.ui.view.a
    {

        View helpGiftCards;
        View helpPharmacy;
        View helpRecalls;
        View helpRedCard;
        View helpSearchBrowse;
        View helpStorePickUp;
        View helpWarranty;

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

        public abstract void e();

        public abstract void f();

        public abstract void g();
    }

    private class b
        implements android.view.View.OnClickListener
    {

        final AccountHelpView this$0;

        public void onClick(View view)
        {
            if (AccountHelpView.a(AccountHelpView.this) == null)
            {
                return;
            }
            switch (view.getId())
            {
            default:
                return;

            case 2131755719: 
                AccountHelpView.a(AccountHelpView.this).a();
                return;

            case 2131755720: 
                AccountHelpView.a(AccountHelpView.this).b();
                return;

            case 2131755721: 
                AccountHelpView.a(AccountHelpView.this).c();
                return;

            case 2131755722: 
                AccountHelpView.a(AccountHelpView.this).d();
                return;

            case 2131755723: 
                AccountHelpView.a(AccountHelpView.this).e();
                return;

            case 2131755724: 
                AccountHelpView.a(AccountHelpView.this).f();
                return;

            case 2131755725: 
                AccountHelpView.a(AccountHelpView.this).g();
                break;
            }
        }

        private b()
        {
            this$0 = AccountHelpView.this;
            super();
        }

    }


    private a mListener;
    private Views mViews;

    public AccountHelpView(Context context)
    {
        super(context);
        a();
    }

    public AccountHelpView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a();
    }

    static a a(AccountHelpView accounthelpview)
    {
        return accounthelpview.mListener;
    }

    private void a()
    {
        setOrientation(1);
        inflate(getContext(), 0x7f0300ef, this);
        mViews = new Views(this);
        al.a(new b(), new View[] {
            mViews.helpSearchBrowse, mViews.helpStorePickUp, mViews.helpRedCard, mViews.helpPharmacy, mViews.helpGiftCards, mViews.helpWarranty, mViews.helpRecalls
        });
    }

    public void setAccountHelpClickListener(a a1)
    {
        mListener = a1;
    }
}
