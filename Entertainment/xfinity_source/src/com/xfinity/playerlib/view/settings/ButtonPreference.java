// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.settings;

import android.content.Context;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ButtonPreference extends Preference
{

    private android.view.View.OnClickListener buttonListener;
    private ProgressBar loadingProgressBar;
    private Button rightButton;
    private String rightButtonString;
    private String summaryString;
    private TextView summaryText;
    private String titleString;
    private TextView titleText;

    public ButtonPreference(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public ButtonPreference(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        rightButtonString = null;
        titleString = null;
        summaryString = null;
        loadingProgressBar = null;
        buttonListener = null;
    }

    protected View onCreateView(ViewGroup viewgroup)
    {
        viewgroup = (LinearLayout)((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(com.xfinity.playerlib.R.layout.button_preference, viewgroup, false);
        rightButton = (Button)viewgroup.findViewById(com.xfinity.playerlib.R.id.right_button);
        setRightButtonText(rightButtonString);
        setRightButtonClickListener(buttonListener);
        titleText = (TextView)viewgroup.findViewById(com.xfinity.playerlib.R.id.title_text);
        setTitleText(titleString);
        summaryText = (TextView)viewgroup.findViewById(com.xfinity.playerlib.R.id.summary_text);
        setSummaryText(summaryString);
        loadingProgressBar = (ProgressBar)viewgroup.findViewById(com.xfinity.playerlib.R.id.loading_progressbar);
        setSelectable(false);
        return viewgroup;
    }

    public void setRightButtonClickListener(android.view.View.OnClickListener onclicklistener)
    {
        if (rightButton == null)
        {
            buttonListener = onclicklistener;
            return;
        } else
        {
            rightButton.setOnClickListener(onclicklistener);
            return;
        }
    }

    public void setRightButtonText(String s)
    {
        if (rightButton == null)
        {
            rightButtonString = s;
            return;
        }
        if (s == null)
        {
            rightButton.setVisibility(8);
            return;
        } else
        {
            rightButton.setVisibility(0);
            rightButton.setText(s);
            return;
        }
    }

    public void setSummaryText(String s)
    {
        if (summaryText == null)
        {
            summaryString = s;
            return;
        }
        if (s == null)
        {
            summaryText.setVisibility(8);
            return;
        } else
        {
            summaryText.setVisibility(0);
            summaryText.setText(s);
            return;
        }
    }

    public void setTitleText(String s)
    {
        if (titleText == null)
        {
            titleString = s;
            return;
        }
        if (s == null)
        {
            titleText.setVisibility(8);
            return;
        } else
        {
            titleText.setVisibility(0);
            titleText.setText(s);
            return;
        }
    }

    public void showProgress()
    {
        rightButton.setVisibility(8);
        loadingProgressBar.setVisibility(0);
    }
}
