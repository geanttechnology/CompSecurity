// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.shop;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

// Referenced classes of package com.picsart.shop:
//            h, q, o, f, 
//            g

public class s
{

    h a;

    s(h h1)
    {
        a = h1;
        super();
    }

    public void a()
    {
        h.i(a).setVisibility(0);
        h.b(a).a = h.f(a) + h.k(a);
        int j = h.b(a).getCount();
        h.l(a);
        h.a(a, 0);
        h.c(a, 0);
        h.h(a).setTranslationY(h.c(a));
        h.i(a).setTranslationY((h.c(a) * -2) / 3);
        h.m(a);
        int i = 0;
        while (i < j) 
        {
            Object obj = h.b(a).a(i);
            if (obj != null)
            {
                if (obj instanceof o)
                {
                    ((o)obj).a(h.f(a) + h.k(a), true);
                } else
                if (obj instanceof f)
                {
                    obj = (f)obj;
                    int k = h.f(a);
                    int l = h.k(a);
                    ((f) (obj)).b.a = k + l;
                    ((f) (obj)).a.removeItemDecoration(((f) (obj)).b);
                    ((f) (obj)).a.addItemDecoration(((f) (obj)).b);
                    ((f) (obj)).a.scrollToPosition(0);
                }
            }
            i++;
        }
    }
}
