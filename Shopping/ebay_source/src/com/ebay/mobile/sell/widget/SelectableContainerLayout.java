// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.RelativeLayout;

public class SelectableContainerLayout extends RelativeLayout
{

    private CheckedTextView checkBoxImage;
    private ViewGroup container;
    private Drawable defaultBackground;
    private boolean isSelected;
    private boolean isSelectionEnabled;
    private Drawable selectionBackground;

    public SelectableContainerLayout(Context context)
    {
        super(context);
        init(context);
    }

    public SelectableContainerLayout(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public SelectableContainerLayout(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        attributeset = context.obtainStyledAttributes(attributeset, com.ebay.mobile.R.styleable.SelectableContainerLayout, i, 0);
        selectionBackground = attributeset.getDrawable(0);
        attributeset.recycle();
        init(context);
    }

    private void init(Context context)
    {
        LayoutInflater.from(context).inflate(0x7f0301f3, this);
        checkBoxImage = (CheckedTextView)findViewById(0x7f10061d);
        container = (ViewGroup)findViewById(0x7f10061c);
        defaultBackground = container.getBackground();
    }

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutparams)
    {
        if (container != null)
        {
            container.addView(view);
            return;
        } else
        {
            super.addView(view, i, layoutparams);
            return;
        }
    }

    public void setIsSelected(boolean flag)
    {
        isSelected = flag;
        checkBoxImage.setChecked(isSelected);
        if (isSelected)
        {
            container.setBackground(selectionBackground);
            return;
        } else
        {
            container.setBackground(defaultBackground);
            return;
        }
    }

    public void setIsSelectionEnabled(boolean flag)
    {
        setIsSelectionEnabled(flag, true);
    }

    public void setIsSelectionEnabled(boolean flag, boolean flag1)
    {
        isSelectionEnabled = flag;
        if (isSelectionEnabled)
        {
            checkBoxImage.setVisibility(0);
            checkBoxImage.setEnabled(flag1);
            return;
        } else
        {
            checkBoxImage.setChecked(false);
            checkBoxImage.setVisibility(8);
            container.setBackground(defaultBackground);
            return;
        }
    }
}
