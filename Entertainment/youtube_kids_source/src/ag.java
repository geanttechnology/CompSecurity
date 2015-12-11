// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.transition.Transition;
import android.view.View;
import android.view.ViewTreeObserver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class ag
    implements android.view.ViewTreeObserver.OnPreDrawListener
{

    private View a;
    private Transition b;
    private View c;
    private ArrayList d;
    private Transition e;
    private ArrayList f;
    private Transition g;
    private ArrayList h;
    private Map i;
    private ArrayList j;
    private Transition k;

    ag(View view, Transition transition, View view1, ArrayList arraylist, Transition transition1, ArrayList arraylist1, Transition transition2, 
            ArrayList arraylist2, Map map, ArrayList arraylist3, Transition transition3)
    {
        a = view;
        b = transition;
        c = view1;
        d = arraylist;
        e = transition1;
        f = arraylist1;
        g = transition2;
        h = arraylist2;
        i = map;
        j = arraylist3;
        k = transition3;
        super();
    }

    public final boolean onPreDraw()
    {
        a.getViewTreeObserver().removeOnPreDrawListener(this);
        if (b != null)
        {
            b.removeTarget(c);
            a.a(b, d);
        }
        if (e != null)
        {
            a.a(e, f);
        }
        if (g != null)
        {
            a.a(g, h);
        }
        java.util.Map.Entry entry;
        for (Iterator iterator = i.entrySet().iterator(); iterator.hasNext(); ((View)entry.getValue()).setTransitionName((String)entry.getKey()))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        int i1 = j.size();
        for (int l = 0; l < i1; l++)
        {
            k.excludeTarget((View)j.get(l), false);
        }

        k.excludeTarget(c, false);
        return true;
    }
}
