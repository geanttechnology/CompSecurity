// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.android.util.view.widget;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public abstract class BreadcrumbAdapter
{

    private boolean addCommas;
    private CharSequence leadText;

    public BreadcrumbAdapter()
    {
    }

    private boolean shouldUseLead()
    {
        return leadText != null && leadText.length() > 0;
    }

    protected void addCommasAndSpacing(LinearLayout linearlayout)
    {
        if (addCommas)
        {
            int j = linearlayout.getChildCount();
            int i = 0;
            if (shouldUseLead())
            {
                i = 1;
            }
            for (; i < j - 1; i++)
            {
                TextView textview = (TextView)linearlayout.getChildAt(i).findViewById(getItemLabelViewId());
                textview.setText((new StringBuilder()).append(textview.getText()).append(", ").toString());
            }

        }
    }

    protected void addLeadIfApplicable(LayoutInflater layoutinflater, ViewGroup viewgroup)
    {
        if (shouldUseLead())
        {
            ((TextView)layoutinflater.inflate(com.comcast.cim.cmasl.android.util.R.layout.breadcrumb_lead, viewgroup).findViewById(com.comcast.cim.cmasl.android.util.R.id.label)).setText(leadText);
        }
    }

    protected abstract void addViews(LayoutInflater layoutinflater, ViewGroup viewgroup, Object obj);

    protected abstract int getItemLabelViewId();

    protected abstract int getItemLayoutId();

    public void setAddCommas(boolean flag)
    {
        addCommas = flag;
    }

    public void setLeadText(CharSequence charsequence)
    {
        leadText = charsequence;
    }
}
