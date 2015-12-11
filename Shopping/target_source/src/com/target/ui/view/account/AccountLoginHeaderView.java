// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.account;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.a.a.e;
import com.target.mothership.model.guest.interfaces.a.c;
import com.target.ui.util.SpannableStringUtils;
import com.target.ui.util.a;
import com.target.ui.util.al;

public class AccountLoginHeaderView extends FrameLayout
{
    static class Views extends com.target.ui.view.a
    {

        View bullseye;
        View errorLayout;
        TextView errorText;

        Views(View view)
        {
            super(view);
        }
    }

    public static interface a
    {

        public abstract void a();

        public abstract void a(String s);
    }


    private a mListener;
    private Views mViews;
    private ClickableSpan phoneNumberClickListener = new ClickableSpan() {

        final AccountLoginHeaderView this$0;

        public void onClick(View view)
        {
            if (com.target.ui.view.account.AccountLoginHeaderView.a(AccountLoginHeaderView.this) == null)
            {
                return;
            } else
            {
                com.target.ui.view.account.AccountLoginHeaderView.a(AccountLoginHeaderView.this).a(com.target.ui.view.account.AccountLoginHeaderView.a(AccountLoginHeaderView.this, 0x7f090058));
                return;
            }
        }

        public void updateDrawState(TextPaint textpaint)
        {
            textpaint.setUnderlineText(false);
        }

            
            {
                this$0 = AccountLoginHeaderView.this;
                super();
            }
    };
    private ClickableSpan restPasswordClickListener = new ClickableSpan() {

        final AccountLoginHeaderView this$0;

        public void onClick(View view)
        {
            if (com.target.ui.view.account.AccountLoginHeaderView.a(AccountLoginHeaderView.this) == null)
            {
                return;
            } else
            {
                com.target.ui.view.account.AccountLoginHeaderView.a(AccountLoginHeaderView.this).a();
                return;
            }
        }

        public void updateDrawState(TextPaint textpaint)
        {
            textpaint.setUnderlineText(false);
        }

            
            {
                this$0 = AccountLoginHeaderView.this;
                super();
            }
    };

    public AccountLoginHeaderView(Context context)
    {
        super(context);
        a(context);
    }

    public AccountLoginHeaderView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a(context);
    }

    public AccountLoginHeaderView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a(context);
    }

    static a a(AccountLoginHeaderView accountloginheaderview)
    {
        return accountloginheaderview.mListener;
    }

    private String a(int i)
    {
        return getResources().getString(i);
    }

    static String a(AccountLoginHeaderView accountloginheaderview, int i)
    {
        return accountloginheaderview.a(i);
    }

    private void a(Context context)
    {
        inflate(context, 0x7f0300ee, this);
        mViews = new Views(this);
    }

    private void b()
    {
        String s = a(0x7f09005a);
        String s1 = a(0x7f09005b);
        SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder(s);
        SpannableStringUtils.a(spannablestringbuilder, s, s1, restPasswordClickListener);
        SpannableStringUtils.a(spannablestringbuilder, s, s1, new ForegroundColorSpan(getResources().getColor(0x7f0f00e2)));
        mViews.errorText.setText(spannablestringbuilder);
        mViews.errorText.setMovementMethod(LinkMovementMethod.getInstance());
        com.target.ui.util.a.a(getContext(), this, s);
        al.a(mViews.errorLayout, new View[] {
            mViews.bullseye
        });
    }

    private void b(c c1)
    {
        if (c1.b().b())
        {
            c();
            return;
        } else
        {
            a(a(0x7f090057));
            return;
        }
    }

    private void c()
    {
        String s = a(0x7f090059);
        String s1 = a(0x7f090058);
        SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder(s);
        SpannableStringUtils.a(spannablestringbuilder, s, s1, phoneNumberClickListener);
        SpannableStringUtils.a(spannablestringbuilder, s, s1, new ForegroundColorSpan(getResources().getColor(0x7f0f00e2)));
        mViews.errorText.setText(spannablestringbuilder);
        mViews.errorText.setMovementMethod(LinkMovementMethod.getInstance());
        com.target.ui.util.a.a(getContext(), this, s);
        al.a(mViews.errorLayout, new View[] {
            mViews.bullseye
        });
    }

    public void a()
    {
        mViews.errorText.setText("");
        al.a(mViews.bullseye, new View[] {
            mViews.errorLayout
        });
    }

    public void a(c c1)
    {
        com.target.mothership.model.guest.interfaces.a.c.a a1 = (com.target.mothership.model.guest.interfaces.a.c.a)c1.e();
        static class _cls3
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

        switch (_cls3..SwitchMap.com.target.mothership.model.guest.interfaces.error.AuthFailure.AuthFailureReason[a1.ordinal()])
        {
        default:
            b(c1);
            return;

        case 1: // '\001'
            b();
            break;
        }
    }

    public void a(String s)
    {
        mViews.errorText.setText(s);
        com.target.ui.util.a.a(getContext(), this, s);
        al.a(mViews.errorLayout, new View[] {
            mViews.bullseye
        });
    }

    public void setClickListener(a a1)
    {
        mListener = a1;
    }
}
