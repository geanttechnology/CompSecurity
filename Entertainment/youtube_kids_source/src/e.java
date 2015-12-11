// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import android.view.ViewTreeObserver;

final class e
    implements android.view.ViewTreeObserver.OnPreDrawListener
{

    private View a;
    private f b;
    private int c;
    private Object d;
    private c e;

    e(c c1, View view, f f, int i, Object obj)
    {
        e = c1;
        a = view;
        b = f;
        c = i;
        d = obj;
        super();
    }

    public final boolean onPreDraw()
    {
        a.getViewTreeObserver().removeOnPreDrawListener(this);
        c.a(e, b, c, d);
        return true;
    }
}
