// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

// Referenced classes of package com.groupon.view:
//            HeaderToggleView, HeaderTogglePresenter

public class HeaderToggle extends RelativeLayout
    implements HeaderToggleView
{
    private static class OnToggledListener
        implements android.view.View.OnClickListener
    {

        private HeaderTogglePresenter presenter;
        private Switch toggleView;

        public void onClick(View view)
        {
            toggleView.setChecked(presenter.toggle());
        }

        public OnToggledListener(HeaderTogglePresenter headertogglepresenter, Switch switch1)
        {
            presenter = headertogglepresenter;
            toggleView = switch1;
        }
    }


    private HeaderTogglePresenter presenter;
    private TextView titleView;
    private FrameLayout toggleContainer;
    private Switch toggleView;

    public HeaderToggle(Context context)
    {
        super(context);
        init(context, null);
    }

    public HeaderToggle(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        init(context, attributeset);
    }

    public HeaderToggle(Context context, AttributeSet attributeset, int i)
    {
        this(context, attributeset);
    }

    private void init(Context context, AttributeSet attributeset)
    {
        presenter = new HeaderTogglePresenter(this);
        LayoutInflater.from(context).inflate(0x7f030131, this, true);
        titleView = (TextView)findViewById(0x7f100381);
        toggleContainer = (FrameLayout)findViewById(0x7f100382);
        toggleView = (Switch)findViewById(0x7f100383);
        toggleContainer.setOnClickListener(new OnToggledListener(presenter, toggleView));
    }

    public HeaderTogglePresenter getPresenter()
    {
        return presenter;
    }

    public void setEnabled(boolean flag)
    {
        toggleView.setEnabled(flag);
    }

    public void setTitle(String s)
    {
        titleView.setText(s);
    }

    public void setToggled(boolean flag)
    {
        toggleView.setChecked(flag);
    }
}
