// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.apps.youtube.kids.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import b;
import byb;
import vp;

public class InterstitialLayout extends FrameLayout
{

    public int a;
    public int b;
    public int c;
    public byb d;
    private final Context e;

    public InterstitialLayout(Context context)
    {
        super(context);
        e = (Context)b.a(context);
        a(0x7f04003f, 0x7f04003d, 0x7f04003e);
    }

    public InterstitialLayout(Context context, int i, int j)
    {
        super(context);
        e = (Context)b.a(context);
        a(j, 0, i);
    }

    public InterstitialLayout(Context context, int i, int j, int k)
    {
        super(context);
        e = (Context)b.a(context);
        a(j, k, i);
    }

    public InterstitialLayout(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public InterstitialLayout(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        e = (Context)b.a(context);
        context = context.obtainStyledAttributes(attributeset, vp.b, i, 0);
        a(context.getResourceId(1, 0x7f04003f), context.getResourceId(0, 0x7f04003d), context.getResourceId(2, 0x7f04003e));
        context.recycle();
    }

    public static byb a(InterstitialLayout interstitiallayout)
    {
        return interstitiallayout.d;
    }

    private void a(int i, int j, int k)
    {
        a = i;
        b = j;
        c = k;
    }

    public View a(int i)
    {
        return LayoutInflater.from(e).inflate(i, this, false);
    }

    public void a(int i, View view, int j)
    {
        if (i > 0)
        {
            view = (TextView)view.findViewById(j);
            view.setMovementMethod(LinkMovementMethod.getInstance());
            view.setText(getResources().getText(i));
        }
    }

    public final void a(View view)
    {
        removeAllViews();
        addView(view);
    }
}
