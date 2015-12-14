// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class PalettesGroupView extends FrameLayout
{

    private TextView a;

    public PalettesGroupView(Context context)
    {
        super(context);
        a = null;
        a = (TextView)((LayoutInflater)context.getSystemService("layout_inflater")).inflate(0x7f0301f9, this).findViewById(0x7f0c08ca);
    }

    public PalettesGroupView(Context context, AttributeSet attributeset, int i)
    {
        this(context);
    }

    public void a()
    {
        a.setVisibility(0);
    }

    public void b()
    {
        a.setVisibility(8);
    }

    public void setText(String s)
    {
        a.setText(s);
    }
}
