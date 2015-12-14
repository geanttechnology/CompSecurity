// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;

public final class g extends android.support.v7.widget.RecyclerView.ViewHolder
{

    ImageView a;
    ProgressBar b;
    FrameLayout c;

    public g(View view)
    {
        super(view);
        a = (ImageView)view.findViewById(0x7f100797);
        b = (ProgressBar)view.findViewById(0x7f100798);
        c = (FrameLayout)view.findViewById(0x7f100796);
    }
}
