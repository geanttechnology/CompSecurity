// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.view.ui.scroll;

import and;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import ane;
import anf;
import ang;

public class TProEditStretchSculptBar extends FrameLayout
{

    public ang callback;

    public TProEditStretchSculptBar(Context context)
    {
        super(context);
        init();
    }

    public TProEditStretchSculptBar(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        init();
    }

    public void init()
    {
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f030121, this, true);
        ((FrameLayout)findViewById(0x7f0d0428)).setOnClickListener(new and(this));
        ((FrameLayout)findViewById(0x7f0d0429)).setOnClickListener(new ane(this));
        ((FrameLayout)findViewById(0x7f0d042a)).setOnClickListener(new anf(this));
    }

    public void setCallback(ang ang)
    {
        callback = ang;
    }
}
