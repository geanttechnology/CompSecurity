// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

public class ProgramCover extends RelativeLayout
{

    public ProgramCover(Context context)
    {
        super(context);
        init(context);
    }

    public ProgramCover(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        init(context);
    }

    public ProgramCover(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        init(context);
    }

    private void init(Context context)
    {
        LayoutInflater.from(context).inflate(com.xfinity.playerlib.R.layout.clickable_program_cover, this, true);
    }
}
