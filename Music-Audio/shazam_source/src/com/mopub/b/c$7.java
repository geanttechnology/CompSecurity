// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.FrameLayout;

// Referenced classes of package com.mopub.b:
//            c, g, a

final class 
    implements Runnable
{

    final View a;
    final Runnable b;
    final c c;

    public final void run()
    {
        DisplayMetrics displaymetrics = c.a.getResources().getDisplayMetrics();
        Object obj = c.f;
        int i = displaymetrics.widthPixels;
        int j = displaymetrics.heightPixels;
        ((g) (obj)).a.set(0, 0, i, j);
        ((g) (obj)).a(((g) (obj)).a, ((g) (obj)).b);
        int ai[] = new int[2];
        obj = c.c();
        ((View) (obj)).getLocationOnScreen(ai);
        g g1 = c.f;
        i = ai[0];
        j = ai[1];
        int k = ((View) (obj)).getWidth();
        int l = ((View) (obj)).getHeight();
        g1.c.set(i, j, k + i, l + j);
        g1.a(g1.c, g1.d);
        c.c.getLocationOnScreen(ai);
        obj = c.f;
        i = ai[0];
        j = ai[1];
        k = c.c.getWidth();
        l = c.c.getHeight();
        ((g) (obj)).g.set(i, j, k + i, l + j);
        ((g) (obj)).a(((g) (obj)).g, ((g) (obj)).h);
        a.getLocationOnScreen(ai);
        obj = c.f;
        i = ai[0];
        j = ai[1];
        k = a.getWidth();
        l = a.getHeight();
        ((g) (obj)).e.set(i, j, k + i, l + j);
        ((g) (obj)).a(((g) (obj)).e, ((g) (obj)).f);
        c.m.a(c.f);
        if (c.n.b())
        {
            c.n.a(c.f);
        }
        if (b != null)
        {
            b.run();
        }
    }

    le(c c1, View view, Runnable runnable)
    {
        c = c1;
        a = view;
        b = runnable;
        super();
    }
}
