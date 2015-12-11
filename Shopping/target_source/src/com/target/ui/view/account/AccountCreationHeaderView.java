// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.account;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.target.ui.util.a;
import com.target.ui.util.al;

public class AccountCreationHeaderView extends FrameLayout
{
    static class Views extends com.target.ui.view.a
    {

        View banner;
        View errorContainer;
        TextView errorText;

        Views(View view)
        {
            super(view);
        }
    }


    private Views mViews;

    public AccountCreationHeaderView(Context context)
    {
        super(context);
        a(context);
    }

    public AccountCreationHeaderView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a(context);
    }

    public AccountCreationHeaderView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a(context);
    }

    private void a(Context context)
    {
        inflate(context, 0x7f0300ed, this);
        mViews = new Views(this);
    }

    public void a()
    {
        mViews.errorText.setText("");
        al.a(mViews.banner, new View[] {
            mViews.errorContainer
        });
    }

    public void a(String s)
    {
        mViews.errorText.setText(s);
        com.target.ui.util.a.a(getContext(), this, s);
        al.a(mViews.errorContainer, new View[] {
            mViews.banner
        });
    }
}
