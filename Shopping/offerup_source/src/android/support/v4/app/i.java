// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.view.View;
import android.view.ViewTreeObserver;
import java.util.ArrayList;

// Referenced classes of package android.support.v4.app:
//            d, g, l, Fragment

final class i
    implements android.view.ViewTreeObserver.OnPreDrawListener
{

    private View a;
    private Object b;
    private ArrayList c;
    private l d;
    private boolean e;
    private Fragment f;
    private Fragment g;
    private g h;

    i(g g1, View view, Object obj, ArrayList arraylist, l l1, boolean flag, Fragment fragment, 
            Fragment fragment1)
    {
        h = g1;
        a = view;
        b = obj;
        c = arraylist;
        d = l1;
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
            android.support.v4.app.d.a(b, c);
            c.clear();
            android.support.v4.g.a a1 = android.support.v4.app.g.a(h, d, e, f);
            android.support.v4.app.d.a(b, d.d, a1, c);
            android.support.v4.app.g.a(h, a1, d);
            android.support.v4.app.g.a(h, d, f, g, e, a1);
        }
        return true;
    }
}
