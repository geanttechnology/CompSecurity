// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.support.v4.c.a;
import android.view.View;
import android.view.ViewTreeObserver;
import java.util.ArrayList;

// Referenced classes of package android.support.v4.app:
//            as, r, w, Fragment

final class t
    implements android.view.ViewTreeObserver.OnPreDrawListener
{

    final View a;
    final Object b;
    final ArrayList c;
    final w d;
    final boolean e;
    final Fragment f;
    final Fragment g;
    final r h;

    t(r r1, View view, Object obj, ArrayList arraylist, w w1, boolean flag, Fragment fragment, 
            Fragment fragment1)
    {
        h = r1;
        a = view;
        b = obj;
        c = arraylist;
        d = w1;
        e = flag;
        f = fragment;
        g = fragment1;
        super();
    }

    public final boolean onPreDraw()
    {
        a.getViewTreeObserver().removeOnPreDrawListener(this);
        if (b != null)
        {
            android.support.v4.app.as.a(b, c);
            c.clear();
            a a1 = android.support.v4.app.r.a(h, d, e, f);
            if (a1.isEmpty())
            {
                c.add(d.d);
            } else
            {
                c.addAll(a1.values());
            }
            as.b(b, c);
            android.support.v4.app.r.a(h, a1, d);
            android.support.v4.app.r.a(f, g, e, a1);
        }
        return true;
    }
}
