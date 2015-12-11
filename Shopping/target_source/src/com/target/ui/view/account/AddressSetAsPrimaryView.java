// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.account;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import com.target.ui.view.TargetCheckBox;
import com.target.ui.view.TargetTextView;

public class AddressSetAsPrimaryView extends RelativeLayout
    implements android.widget.CompoundButton.OnCheckedChangeListener
{
    static class Views extends com.target.ui.view.a
    {

        TargetCheckBox checkBox;
        TargetTextView description;
        View root;

        Views(View view)
        {
            super(view);
            root = view;
        }
    }

    public static interface a
    {

        public abstract void g(boolean flag);
    }


    private a mListener;
    private Views mViews;

    public AddressSetAsPrimaryView(Context context)
    {
        super(context);
        a(context);
    }

    public AddressSetAsPrimaryView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a(context);
    }

    public AddressSetAsPrimaryView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a(context);
    }

    public void a(Context context)
    {
        inflate(context, 0x7f030100, this);
        mViews = new Views(this);
        mViews.checkBox.setOnCheckedChangeListener(this);
    }

    public void a(boolean flag)
    {
        mViews.checkBox.setChecked(flag);
    }

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        mListener.g(flag);
    }

    public void setAddressSetAsDefaultListener(a a1)
    {
        mListener = a1;
    }
}
