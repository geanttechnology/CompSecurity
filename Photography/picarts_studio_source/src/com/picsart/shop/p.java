// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.shop;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

// Referenced classes of package com.picsart.shop:
//            o, k

final class p extends android.support.v7.widget.RecyclerView.ItemDecoration
{

    int a;
    int b;
    private o c;

    private p(o o1)
    {
        c = o1;
        super();
        b = 0;
    }

    p(o o1, byte byte0)
    {
        this(o1);
    }

    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerview, android.support.v7.widget.RecyclerView.State state)
    {
        super.getItemOffsets(rect, view, recyclerview, state);
        int l = recyclerview.getChildPosition(view);
        int i;
        int j;
        if (l < o.v(c))
        {
            i = a;
        } else
        {
            i = 0;
        }
        if (o.d(c).getItemCount() % o.v(c) == 0)
        {
            j = o.v(c);
        } else
        {
            j = o.d(c).getItemCount() % o.v(c);
        }
        if (l >= o.d(c).getItemCount() - j && !o.i(c))
        {
            j = b;
        } else
        {
            j = 0;
        }
        rect.set(0, i, 0, j);
    }
}
