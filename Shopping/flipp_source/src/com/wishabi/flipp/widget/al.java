// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.wishabi.flipp.app.dn;
import com.wishabi.flipp.app.eo;
import com.wishabi.flipp.util.i;
import com.wishabi.flipp.util.k;
import com.wishabi.flipp.util.l;
import com.wishabi.flipp.util.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.wishabi.flipp.widget:
//            da, CouponCell, z, aw, 
//            ZeroCaseView, ec

public final class al extends da
{

    final l a = new l();
    private final Context b;
    private final Cursor c;
    private final Cursor d;
    private final HashMap e;
    private final int f;
    private final int g;
    private final int h;
    private final String i = com.wishabi.flipp.util.k.a(null);
    private final boolean k;
    private final ZeroCaseView l;
    private final ec m;
    private final dn n;
    private final dn o;
    private int p;
    private int q;

    public al(Context context, Cursor cursor, Cursor cursor1, HashMap hashmap, int j, int i1, int j1, 
            boolean flag, ZeroCaseView zerocaseview, ec ec, dn dn, dn dn1)
    {
        p = -1;
        q = -1;
        b = context;
        c = cursor;
        d = cursor1;
        e = hashmap;
        f = j;
        g = i1;
        h = j1;
        k = flag;
        l = zerocaseview;
        m = ec;
        n = dn;
        o = dn1;
        if (c != null)
        {
            p = c.getColumnIndexOrThrow("_id");
        }
        if (d != null)
        {
            q = d.getColumnIndexOrThrow("_id");
        }
        context = com.wishabi.flipp.util.o.a(0, 0);
        context.d = -1;
        a.a(context);
        if (d != null && d.getCount() > 0)
        {
            context = com.wishabi.flipp.util.o.a(1, d.getCount(), "Clippings");
            context.d = 1;
            a.a(context);
        }
        if (c != null && c.getCount() > 0)
        {
            context = com.wishabi.flipp.util.o.a(2, c.getCount(), "Coupons");
            context.d = 2;
            a.a(context);
        }
        if (a.b() == 0 && l != null)
        {
            a.a();
            context = com.wishabi.flipp.util.o.a(0, 1);
            context.d = 5;
            a.a(context);
        }
        context = new ArrayList();
        for (cursor = a.iterator(); cursor.hasNext(); context.add(Integer.valueOf(((o)cursor.next()).a()))) { }
        a(context);
    }

    public final int a(int j, int i1)
    {
        return b(j, i1);
    }

    protected final View a(int j, int i1, View view)
    {
        Context context = null;
        Object obj = null;
        switch (c(j))
        {
        case 3: // '\003'
        case 4: // '\004'
        default:
            throw new IllegalStateException("Invalid section id requested");

        case 0: // '\0'
            throw new IllegalArgumentException("SearchAdapter is is asking for item in the tab bar section.  The tab bar should be a header");

        case 5: // '\005'
            return l;

        case 1: // '\001'
            d.moveToPosition(i1);
            String s;
            Cursor cursor;
            int j1;
            int l1;
            if (view != null)
            {
                view = (CouponCell)view;
            } else
            {
                view = new CouponCell(b);
            }
            j = d.getInt(q);
            context = b;
            s = i;
            cursor = d;
            j1 = z.a;
            l1 = com.wishabi.flipp.util.i.a(260);
            if (e != null)
            {
                obj = (ArrayList)e.get(Integer.valueOf(j));
            }
            aw.a(context, s, view, i1, cursor, false, true, j1, l1, ((ArrayList) (obj)), o);
            return view;

        case 2: // '\002'
            c.moveToPosition(i1);
            break;
        }
        Context context1;
        String s1;
        Cursor cursor1;
        int k1;
        int i2;
        boolean flag;
        if (view != null)
        {
            view = (CouponCell)view;
        } else
        {
            view = new CouponCell(b);
        }
        j = c.getInt(p);
        context1 = b;
        s1 = i;
        cursor1 = c;
        flag = k;
        k1 = z.a;
        i2 = com.wishabi.flipp.util.i.a(260);
        obj = context;
        if (e != null)
        {
            obj = (ArrayList)e.get(Integer.valueOf(j));
        }
        aw.a(context1, s1, view, i1, cursor1, flag, true, k1, i2, ((ArrayList) (obj)), n);
        return view;
    }

    protected final View a(int j, View view, ViewGroup viewgroup)
    {
        b(j);
        JVM INSTR tableswitch 0 2: default 32
    //                   0 42
    //                   1 72
    //                   2 91;
           goto _L1 _L2 _L3 _L4
_L1:
        throw new IllegalStateException("invalid section type requested");
_L2:
        if (view == null) goto _L6; else goto _L5
_L5:
        return view;
_L6:
        return eo.a(b, f, g, h, m);
_L3:
        if (view != null) goto _L5; else goto _L7
_L7:
        return LayoutInflater.from(b).inflate(0x7f030009, viewgroup, false);
_L4:
        view = (TextView)view;
        if (view == null)
        {
            view = (TextView)LayoutInflater.from(b).inflate(0x7f03002b, viewgroup, false);
        }
        view.setText(b.getResources().getQuantityString(0x7f0d0000, c.getCount(), new Object[] {
            Integer.valueOf(c.getCount())
        }));
        return view;
    }

    public final Object a(int j)
    {
        Object obj;
        Object obj1;
        obj1 = null;
        obj = a.c(j);
        j -= ((o) (obj)).c;
        ((o) (obj)).b;
        JVM INSTR tableswitch 0 2: default 48
    //                   0 58
    //                   1 65
    //                   2 105;
           goto _L1 _L2 _L3 _L4
_L1:
        throw new IllegalArgumentException("Invalid position idx");
_L2:
        obj = l;
_L6:
        return obj;
_L3:
        obj = obj1;
        if (d != null)
        {
            obj = obj1;
            if (j < d.getCount())
            {
                d.moveToPosition(j);
                return d;
            }
        }
        continue; /* Loop/switch isn't completed */
_L4:
        obj = obj1;
        if (c != null)
        {
            obj = obj1;
            if (j < c.getCount())
            {
                c.moveToPosition(j);
                return c;
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public final int b(int j)
    {
        return a.b(j).b;
    }

    protected final int c(int j)
    {
        return a.b(j).d;
    }

    protected final int d(int j)
    {
        switch (b(j))
        {
        default:
            throw new IllegalArgumentException("Invalid search section");

        case 0: // '\0'
            return 0;

        case 1: // '\001'
            return 4;

        case 2: // '\002'
            return 3;
        }
    }

    public final int getViewTypeCount()
    {
        return 6;
    }
}
