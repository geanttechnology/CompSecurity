// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.widgets;

import android.content.Context;
import android.support.v7.ajx;
import android.support.v7.dz;
import android.support.v7.em;
import android.support.v7.iv;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.Toast;
import butterknife.ButterKnife;

public class NoNetworkView extends RelativeLayout
{

    public NoNetworkView(Context context)
    {
        this(context, null);
    }

    public NoNetworkView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public NoNetworkView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a();
    }

    private void a()
    {
        ButterKnife.bind(this, inflate(getContext(), 0x7f040059, this));
    }

    private void b()
    {
        Toast.makeText(getContext().getApplicationContext(), getContext().getString(0x7f090072), 1).show();
    }

    void onRetryPressed()
    {
        if (iv.b(getContext()))
        {
            dz.a().a(new em());
            return;
        } else
        {
            b();
            return;
        }
    }
}
