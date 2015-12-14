// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.activity.mainpage;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import axw;
import biv;
import bjc;
import com.fotoable.adbuttonlib.TAdButton;

public class ViewMainPage2 extends FrameLayout
{

    public biv clickerListener;
    TAdButton item_adC01;
    TAdButton item_adC02;
    TAdButton item_adC03;
    ViewGroup layout_area;
    View layout_prev_page;
    int srcHeightDp;
    int srcWidthDp;

    public ViewMainPage2(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        srcWidthDp = 320;
        srcHeightDp = 340;
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f030112, this, true);
        layout_area = (ViewGroup)findViewById(0x7f0d0403);
        initView();
    }

    public void initView()
    {
        layout_prev_page = findViewById(0x7f0d0407);
        layout_prev_page.setOnClickListener(new bjc(this));
    }

    public void resize(int i, int j)
    {
        float f = (float)i / (float)srcHeightDp;
        float f1 = (float)j / (float)srcWidthDp;
        if (f >= f1)
        {
            f = f1;
        }
        f1 = f;
        if (j >= 400)
        {
            f1 = f / 1.1F;
        }
        axw.a(this, f1);
        requestLayout();
    }

    public void setHasMaterialNew(boolean flag)
    {
    }

    public void setOnClickListener(biv biv)
    {
        clickerListener = biv;
    }
}
