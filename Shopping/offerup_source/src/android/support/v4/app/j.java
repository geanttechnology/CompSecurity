// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.view.View;
import android.view.ViewTreeObserver;

// Referenced classes of package android.support.v4.app:
//            g, l

final class j
    implements android.view.ViewTreeObserver.OnPreDrawListener
{

    private View a;
    private l b;
    private int c;
    private Object d;
    private g e;

    j(g g1, View view, l l, int i, Object obj)
    {
        e = g1;
        a = view;
        b = l;
        c = i;
        d = obj;
        super();
    }

    public final boolean onPreDraw()
    {
        a.getViewTreeObserver().removeOnPreDrawListener(this);
        g.a(e, b, c, d);
        return true;
    }
}
