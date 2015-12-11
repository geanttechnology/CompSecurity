// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.apps.youtube.core.player;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import b;
import bgv;
import bmf;
import bmj;
import cla;
import cvc;
import cvd;
import sc;

public class PlayerView extends cvc
{

    public cla a;

    public PlayerView(Context context)
    {
        this(context, null);
    }

    public PlayerView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        attributeset = (sc)((Activity)context).getApplication();
        bmj bmj1 = attributeset.g().s();
        byte byte0;
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT >= 17 && bmj1.j())
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        if (byte0 != 0)
        {
            byte0 = 2;
        } else
        {
            byte0 = 3;
        }
        a = new cla(context, this, byte0, attributeset.c().b());
        context = a;
        if (super.b == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b.b(flag, "videoView has already been set");
        super.b = context;
        attributeset = new cvd(-2, -2);
        attributeset.gravity = 17;
        addView(context, 0, attributeset);
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        for (int i1 = 0; i1 < getChildCount(); i1++)
        {
            getChildAt(i1).layout(0, 0, k - i, l - j);
        }

    }
}
