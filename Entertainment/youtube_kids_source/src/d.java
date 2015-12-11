// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import android.view.ViewTreeObserver;
import java.util.ArrayList;

final class d
    implements android.view.ViewTreeObserver.OnPreDrawListener
{

    private View a;
    private Object b;
    private ArrayList c;
    private f d;
    private boolean e;
    private j f;
    private j g;
    private c h;

    d(c c1, View view, Object obj, ArrayList arraylist, f f1, boolean flag, j j, 
            j j1)
    {
        h = c1;
        a = view;
        b = obj;
        c = arraylist;
        d = f1;
        e = flag;
        f = j;
        g = j1;
        super();
    }

    public final boolean onPreDraw()
    {
        a.getViewTreeObserver().removeOnPreDrawListener(this);
        if (b != null)
        {
            a.a(b, c);
            c.clear();
            cz cz1 = c.a(h, d, e, f);
            if (cz1.isEmpty())
            {
                c.add(d.d);
            } else
            {
                c.addAll(cz1.values());
            }
            a.b(b, c);
            c.a(h, cz1, d);
            c.a(h, d, f, g, e, cz1);
        }
        return true;
    }
}
