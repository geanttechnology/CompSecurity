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
import android.widget.LinearLayout;
import android.widget.TextView;
import com.target.ui.fragment.account.ExternalUrlLauncherImpl;
import com.target.ui.util.SpannableStringUtils;
import com.target.ui.view.a;

public class AccountOrderHistoryFooterView extends LinearLayout
{
    static class Views extends a
    {

        TextView orderHistoryFooterCopy;

        Views(View view)
        {
            super(view);
        }
    }


    private Views mViews;
    private ClickableSpan orderHistoryTapHereSpan = new ClickableSpan() {

        final AccountOrderHistoryFooterView this$0;

        public void onClick(View view)
        {
            (new ExternalUrlLauncherImpl(getContext())).a("https://m-secure.target.com/gam-findorder");
        }

        public void updateDrawState(TextPaint textpaint)
        {
            textpaint.setUnderlineText(false);
        }

            
            {
                this$0 = AccountOrderHistoryFooterView.this;
                super();
            }
    };

    public AccountOrderHistoryFooterView(Context context)
    {
        super(context);
        a(context);
    }

    public AccountOrderHistoryFooterView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a(context);
    }

    public AccountOrderHistoryFooterView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a(context);
    }

    private String a(int i)
    {
        return getContext().getString(i);
    }

    private void a(Context context)
    {
        inflate(context, 0x7f0300f8, this);
        mViews = new Views(this);
        context = new SpannableStringBuilder(a(0x7f0900ab));
        SpannableStringUtils.a(context, a(0x7f0900ab), a(0x7f0900aa), orderHistoryTapHereSpan);
        SpannableStringUtils.a(context, a(0x7f0900ab), a(0x7f0900aa), new ForegroundColorSpan(getResources().getColor(0x7f0f00e2)));
        mViews.orderHistoryFooterCopy.setText(context);
        mViews.orderHistoryFooterCopy.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
