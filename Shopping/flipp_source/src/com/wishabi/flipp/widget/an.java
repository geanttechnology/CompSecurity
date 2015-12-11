// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.content.Context;
import android.support.v7.widget.av;
import android.support.v7.widget.bi;
import android.view.View;
import android.view.ViewGroup;
import com.wishabi.flipp.app.dn;
import com.wishabi.flipp.content.c;
import com.wishabi.flipp.util.i;
import com.wishabi.flipp.util.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.wishabi.flipp.widget:
//            u, ao, cd, aq, 
//            ar, CouponCell, ap, aw, 
//            z

public final class an extends android.support.v7.widget.an
{

    private final Context c;
    private final String d = k.a(null);
    private final List e;
    private final List f;
    private final HashMap g;
    private final dn h;
    private final int i;
    private final boolean j;

    public an(Context context, List list, List list1, HashMap hashmap, dn dn)
    {
        boolean flag = false;
        super();
        HashMap hashmap1 = hashmap;
        if (hashmap == null)
        {
            hashmap1 = new HashMap();
        }
        c = context;
        e = list;
        f = list1;
        g = hashmap1;
        h = dn;
        context = list.iterator();
        int l = 0;
        do
        {
            if (!context.hasNext())
            {
                break;
            }
            list = (ArrayList)hashmap1.get(Integer.valueOf(((c)context.next()).a));
            if (list != null && !list.isEmpty())
            {
                l = list.size() + l;
            }
        } while (true);
        context = list1.iterator();
        do
        {
            if (!context.hasNext())
            {
                break;
            }
            list = (ArrayList)hashmap1.get(Integer.valueOf(((c)context.next()).a));
            if (list != null && !list.isEmpty())
            {
                l += list.size();
            }
        } while (true);
        i = l;
        if (i > 0)
        {
            flag = true;
        }
        j = flag;
    }

    public final int a()
    {
        int i1 = e.size();
        int j1 = f.size();
        int l;
        if (j)
        {
            l = 1;
        } else
        {
            l = 0;
        }
        return l + (j1 + i1) + 1;
    }

    public final int a(int l)
    {
        int i1 = l;
        if (j)
        {
            if (l == 0)
            {
                return 0;
            }
            i1 = l - 1;
        }
        if (i1 < e.size())
        {
            return 1;
        }
        return i1 != e.size() ? 3 : 2;
    }

    public final bi a(ViewGroup viewgroup, int l)
    {
        switch (l)
        {
        default:
            return null;

        case 0: // '\0'
            viewgroup = new u(c);
            l = com.wishabi.flipp.util.i.a(5);
            av av1 = new av(-1, -2);
            av1.setMargins(0, 0, 0, l);
            viewgroup.setLayoutParams(av1);
            return new ao(viewgroup);

        case 1: // '\001'
            viewgroup = new cd(c);
            viewgroup.setLayoutParams(new av(-1, com.wishabi.flipp.util.i.a(210)));
            return new aq(viewgroup);

        case 2: // '\002'
            viewgroup = new View(c);
            viewgroup.setLayoutParams(new av(-1, 0));
            return new ar(viewgroup);

        case 3: // '\003'
            viewgroup = new CouponCell(c);
            break;
        }
        viewgroup.setLayoutParams(new av(-1, -2));
        viewgroup.setContainerHeight(com.wishabi.flipp.util.i.a(260));
        return new ap(viewgroup);
    }

    public final void a(bi bi, int l)
    {
        Object obj = null;
        a(l);
        JVM INSTR tableswitch 0 3: default 36
    //                   0 37
    //                   1 52
    //                   2 36
    //                   3 129;
           goto _L1 _L2 _L3 _L1 _L4
_L1:
        return;
_L2:
        ((ao)bi).k.setCount(i);
        return;
_L3:
        c c2 = d(l);
        if (c2 != null)
        {
            aq aq1 = (aq)bi;
            bi = obj;
            if (g != null)
            {
                bi = (ArrayList)g.get(Integer.valueOf(c2.a));
            }
            aw.a(c, d, aq1.k, l, c2, com.wishabi.flipp.util.i.a(210), bi, h);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        c c1 = d(l);
        if (c1 != null)
        {
            ap ap1 = (ap)bi;
            if (g != null)
            {
                bi = (ArrayList)g.get(Integer.valueOf(c1.a));
            } else
            {
                bi = null;
            }
            aw.a(c, d, ap1.k, l, c1, true, true, z.a, true, com.wishabi.flipp.util.i.a(260), bi, h);
            return;
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    public final c d(int l)
    {
        int i1 = l;
        if (!j) goto _L2; else goto _L1
_L1:
        if (l != 0) goto _L4; else goto _L3
_L3:
        return null;
_L4:
        i1 = l - 1;
_L2:
        if (i1 < e.size())
        {
            return (c)e.get(i1);
        }
        if (i1 != e.size())
        {
            l = e.size();
            return (c)f.get(i1 - l - 1);
        }
        if (true) goto _L3; else goto _L5
_L5:
    }
}
