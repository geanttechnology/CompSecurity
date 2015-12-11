// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.c;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;
import com.mopub.d.a.g;
import com.mopub.d.m;

public final class f extends g
{

    private final int e;

    public f(m m, Context context, com.mopub.d.a.g.b b)
    {
        super(m, b);
        m = ((WindowManager)context.getSystemService("window")).getDefaultDisplay();
        context = new Point();
        if (android.os.Build.VERSION.SDK_INT < 13)
        {
            context.set(m.getWidth(), m.getHeight());
        } else
        {
            m.getSize(context);
        }
        e = Math.min(((Point) (context)).x, ((Point) (context)).y);
    }

    public final com.mopub.d.a.g.c a(String s, com.mopub.d.a.g.d d)
    {
        return super.a(s, d, e);
    }
}
