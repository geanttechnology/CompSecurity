// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.apps.youtube.kids.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class ParentalControlLaunchBar extends FrameLayout
{

    private final ImageView a = (ImageView)findViewById(0x7f100167);

    public ParentalControlLaunchBar(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        ((LayoutInflater)context.getSystemService("layout_inflater")).inflate(0x7f04004d, this, true);
    }

    public final void a()
    {
        a.setImageResource(0x7f0201e5);
    }
}
