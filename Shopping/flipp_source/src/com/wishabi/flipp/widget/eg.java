// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.SparseArray;
import android.view.accessibility.AccessibilityManager;
import com.wishabi.flipp.c.a;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.wishabi.flipp.widget:
//            n, o, CollectionView, eh

public final class eg extends n
{

    public eh b;
    private int c;
    private int d;
    private final boolean e;
    private final Rect f = new Rect();
    private final Rect g = new Rect();
    private SparseArray h;

    public eg(Context context)
    {
        context = (AccessibilityManager)context.getSystemService("accessibility");
        boolean flag;
        if (!context.isEnabled() || !context.isTouchExplorationEnabled())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        e = flag;
    }

    public final int a()
    {
        return c;
    }

    public final o a(int i)
    {
        return (o)h.get(i);
    }

    public final List a(int i, int j, int k)
    {
        ArrayList arraylist = new ArrayList();
        SparseArray sparsearray = h;
        int i1 = sparsearray.size();
        for (int l = 0; l < i1; l++)
        {
            o o1 = (o)sparsearray.valueAt(l);
            if (o1.b != null && e)
            {
                Rect rect = o1.a;
                rect.offsetTo(rect.left, Math.min(o1.b.top, Math.max(i, o1.c.top)));
            }
            if (o1.a.intersects(0, i, j, k))
            {
                arraylist.add(o1);
            }
        }

        return arraylist;
    }

    public final int b()
    {
        return d;
    }

    public final void c()
    {
        com.wishabi.flipp.c.a.a("prepareLayout");
        int i3 = super.a.getMeasuredWidth();
        SparseArray sparsearray = new SparseArray();
        eh eh1 = b;
        super.a.getDrawingRect(g);
        int j3 = eh1.a();
        int k1 = 0;
        boolean flag = true;
        Object obj = null;
        int i = 0;
        while (k1 < j3) 
        {
            int k = eh1.b(k1);
            boolean flag2 = flag;
            o o2 = ((o) (obj));
            int j = i;
            if (k != 0)
            {
                eh1.a(k1, f);
                int l3 = f.left;
                j = f.top;
                int l1 = f.right;
                int k3 = f.bottom;
                int i4 = eh1.c(k1);
                int i1 = eh1.d(k1);
                int i2 = eh1.e(k1);
                o o1;
                int j4;
                boolean flag1;
                if (k > 1)
                {
                    l1 = (int)Math.floor(((float)(i3 - l3 - l1) - (float)(k * i4)) / (float)(k - 1));
                } else
                {
                    l1 = 0;
                }
                j = i + j;
                flag1 = flag;
                o1 = ((o) (obj));
                i = j;
                if (i1 > 0)
                {
                    int j2 = eh1.f(k1);
                    flag1 = flag;
                    o1 = ((o) (obj));
                    i = j;
                    if (j2 != -1)
                    {
                        o1 = new o();
                        o1.e = 1;
                        o1.a = new Rect(0, j, i3, j + i1);
                        o1.c = new Rect(0, j, i3, j + i1);
                        o1.d = j2;
                        sparsearray.put(j2, o1);
                        i = j + (i1 + i2);
                        flag1 = eh1.g(k1);
                    }
                }
                obj = new int[k];
                for (j = 0; j < k; j++)
                {
                    obj[j] = i;
                }

                j4 = eh1.a(k1);
                i2 = 0;
                while (i2 < j4) 
                {
                    int k4 = eh1.a(k1, i2);
                    if (k4 == 0)
                    {
                        continue;
                    }
                    int l4 = eh1.b(k1, i2);
                    if (l4 == -1)
                    {
                        continue;
                    }
                    int l = 0;
                    int j1 = 0x7fffffff;
                    j = 0;
                    int i5 = obj.length;
                    while (j < i5) 
                    {
                        int k2 = obj[j];
                        if (k2 < j1)
                        {
                            j1 = j;
                            l = k2;
                        } else
                        {
                            int l2 = l;
                            l = j1;
                            j1 = l2;
                        }
                        j++;
                        k2 = j1;
                        j1 = l;
                        l = k2;
                    }
                    j = (i4 + l1) * l + l3;
                    o2 = new o();
                    o2.a = new Rect(j, j1, j + i4, j1 + k4);
                    o2.d = l4;
                    o2.f = true;
                    sparsearray.put(l4, o2);
                    obj[l] = obj[l] + (k4 + l1);
                    i2++;
                }
                j1 = obj.length;
                l = 0;
                j = i;
                for (i = l; i < j1; i++)
                {
                    j = Math.max(j, Integer.valueOf(obj[i]).intValue());
                }

                i = j + k3;
                flag2 = flag1;
                o2 = o1;
                j = i;
                if (o1 != null)
                {
                    flag2 = flag1;
                    o2 = o1;
                    j = i;
                    if (e)
                    {
                        flag2 = flag1;
                        o2 = o1;
                        j = i;
                        if (flag1)
                        {
                            obj = o1.a;
                            j = i - ((Rect) (obj)).height();
                            o1.b = new Rect(((Rect) (obj)).left, j, ((Rect) (obj)).right, ((Rect) (obj)).height() + j);
                            ((Rect) (obj)).offsetTo(((Rect) (obj)).left, Math.min(j, Math.max(g.top, ((Rect) (obj)).top)));
                            j = i;
                            o2 = o1;
                            flag2 = flag1;
                        }
                    }
                }
            }
            k1++;
            flag = flag2;
            obj = o2;
            i = j;
        }
        c = i3;
        d = i;
        h = sparsearray;
        com.wishabi.flipp.c.a.a();
    }
}
