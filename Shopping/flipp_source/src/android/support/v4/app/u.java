// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.view.View;
import android.view.ViewTreeObserver;

// Referenced classes of package android.support.v4.app:
//            r, w

final class u
    implements android.view.ViewTreeObserver.OnPreDrawListener
{

    final View a;
    final w b;
    final int c;
    final Object d;
    final r e;

    u(r r1, View view, w w, int i, Object obj)
    {
        e = r1;
        a = view;
        b = w;
        c = i;
        d = obj;
        super();
    }

    public final boolean onPreDraw()
    {
        a.getViewTreeObserver().removeOnPreDrawListener(this);
        r.a(e, b, c, d);
        return true;
    }
}
