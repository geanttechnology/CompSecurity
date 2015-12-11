// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import aca;
import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;

public final class du extends FrameLayout
    implements android.view.View.OnClickListener
{

    private final Activity a;
    private final ImageButton b;

    public du(Activity activity, int i)
    {
        super(activity);
        a = activity;
        setOnClickListener(this);
        b = new ImageButton(activity);
        b.setImageResource(0x1080017);
        b.setBackgroundColor(0);
        b.setOnClickListener(this);
        b.setPadding(0, 0, 0, 0);
        b.setContentDescription("Interstitial close button");
        i = aca.a(activity, i);
        addView(b, new android.widget.FrameLayout.LayoutParams(i, i, 17));
    }

    public void a(boolean flag)
    {
        ImageButton imagebutton = b;
        byte byte0;
        if (flag)
        {
            byte0 = 4;
        } else
        {
            byte0 = 0;
        }
        imagebutton.setVisibility(byte0);
    }

    public void onClick(View view)
    {
        a.finish();
    }
}
