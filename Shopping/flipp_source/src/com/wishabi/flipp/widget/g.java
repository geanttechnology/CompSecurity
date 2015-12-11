// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import b.a.a.d.aa;
import b.a.a.d.d;
import com.wishabi.flipp.app.dn;
import com.wishabi.flipp.util.i;
import com.wishabi.flipp.util.k;
import com.wishabi.flipp.util.l;
import com.wishabi.flipp.util.o;
import com.wishabi.flipp.util.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.wishabi.flipp.widget:
//            da, a, f, aw, 
//            CouponCell, z

public final class g extends da
{

    final Cursor a;
    final Cursor b;
    final HashMap c;
    final HashMap d;
    final l e = new l();
    float f[];
    public boolean g;
    int h;
    int i;
    private final Context k;
    private final String l = com.wishabi.flipp.util.k.a(null);
    private final dn m;
    private int n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;

    public g(Context context, Cursor cursor, Cursor cursor1, HashMap hashmap, HashMap hashmap1, dn dn)
    {
        int j = 0;
        super();
        n = -1;
        o = -1;
        p = -1;
        q = -1;
        h = -1;
        r = -1;
        s = -1;
        t = -1;
        u = -1;
        v = -1;
        i = -1;
        k = context;
        a = cursor;
        b = cursor1;
        c = hashmap;
        d = hashmap1;
        m = dn;
        if (a != null)
        {
            n = a.getColumnIndexOrThrow("top");
            o = a.getColumnIndexOrThrow("bottom");
            p = a.getColumnIndexOrThrow("left");
            q = a.getColumnIndexOrThrow("right");
            h = a.getColumnIndexOrThrow("_id");
            r = a.getColumnIndexOrThrow("valid_to");
            s = a.getColumnIndexOrThrow("thumbnail");
            t = a.getColumnIndexOrThrow("name");
            u = a.getColumnIndex("merchant");
            v = a.getColumnIndexOrThrow("merchant_logo");
        }
        if (b != null)
        {
            i = b.getColumnIndexOrThrow("_id");
        }
        if (a != null && a.getCount() > 0)
        {
            context = com.wishabi.flipp.util.o.a(0, a.getCount(), "Flyers");
            context.d = 0;
            e.a(context);
            f = new float[a.getCount()];
            for (int i1 = a.getCount(); j < i1; j++)
            {
                a.moveToPosition(j);
                float f1 = a.getFloat(o);
                float f2 = a.getFloat(n);
                float f3 = a.getFloat(q);
                float f4 = a.getFloat(p);
                f[j] = (f1 - f2) / (f3 - f4);
            }

        }
        if (b != null && b.getCount() > 0)
        {
            context = com.wishabi.flipp.util.o.a(1, b.getCount(), "Coupons");
            context.d = 1;
            e.a(context);
        }
        context = new ArrayList();
        for (cursor = e.iterator(); cursor.hasNext(); context.add(Integer.valueOf(((o)cursor.next()).a()))) { }
        a(context);
    }

    public final int a(int j, int i1)
    {
        return b(j, i1);
    }

    protected final View a(int j, int i1, View view)
    {
        int j1 = b(j, i1);
        switch (b(j))
        {
        default:
            throw new IllegalStateException("Invalid section id requested");

        case 0: // '\0'
            if (!a.moveToPosition(i1))
            {
                throw new IllegalStateException((new StringBuilder("Couldn't move cursor to position ")).append(i1).toString());
            }
            Object obj;
            Object obj1;
            dn dn1;
            Context context1;
            String s2;
            String s3;
            String s4;
            String s5;
            long l1;
            if (view != null)
            {
                view = (a)view;
            } else
            {
                view = new a(k);
            }
            l1 = a.getLong(h);
            obj = a.getString(r);
            obj1 = aa.a();
            if (obj != null)
            {
                obj = ((d) (obj1)).a(((String) (obj)));
            } else
            {
                obj = null;
            }
            context1 = k;
            s2 = a.getString(s);
            s3 = a.getString(t);
            s4 = a.getString(v);
            s5 = a.getString(u);
            if (g)
            {
                j = f.b;
            } else
            {
                j = f.a;
            }
            if (c == null)
            {
                obj1 = null;
            } else
            {
                obj1 = (ArrayList)c.get(Long.valueOf(l1));
            }
            if (g)
            {
                dn1 = null;
            } else
            {
                dn1 = m;
            }
            aw.a(context1, view, ((b.a.a.b) (obj)), s2, s3, s4, s5, j1, j, ((ArrayList) (obj1)), dn1);
            return view;

        case 1: // '\001'
            break;
        }
        if (!b.moveToPosition(i1))
        {
            throw new IllegalStateException((new StringBuilder("Couldn't move cursor to position ")).append(i1).toString());
        }
        ArrayList arraylist;
        dn dn;
        Context context;
        String s1;
        Cursor cursor;
        int k1;
        if (view != null)
        {
            view = (CouponCell)view;
        } else
        {
            view = new CouponCell(k);
        }
        i1 = b.getInt(i);
        context = k;
        s1 = l;
        cursor = b;
        if (g)
        {
            j = com.wishabi.flipp.widget.z.d;
        } else
        {
            j = z.a;
        }
        k1 = com.wishabi.flipp.util.i.a(260);
        if (d != null)
        {
            arraylist = (ArrayList)d.get(Integer.valueOf(i1));
        } else
        {
            arraylist = null;
        }
        if (g)
        {
            dn = null;
        } else
        {
            dn = m;
        }
        aw.a(context, s1, view, j1, cursor, false, true, j, k1, arraylist, dn);
        return view;
    }

    protected final View a(int j, View view, ViewGroup viewgroup)
    {
        view = (TextView)view;
        if (view == null)
        {
            view = (TextView)LayoutInflater.from(k).inflate(0x7f03002b, viewgroup, false);
        }
        if (view == null) goto _L2; else goto _L1
_L1:
        b(j);
        JVM INSTR tableswitch 0 1: default 60
    //                   0 62
    //                   1 74;
           goto _L2 _L3 _L4
_L2:
        return view;
_L3:
        view.setText(com.wishabi.flipp.util.q.a(com.wishabi.flipp.util.q.b()));
        return view;
_L4:
        view.setText(0x7f0e0086);
        return view;
    }

    public final Object a(int j)
    {
        o o1;
        o1 = e.c(j);
        j -= o1.c;
        o1.b;
        JVM INSTR tableswitch 0 1: default 44
    //                   0 55
    //                   1 93;
           goto _L1 _L2 _L3
_L1:
        throw new IllegalArgumentException("Invalid position idx");
_L2:
        if (a != null && j < a.getCount()) goto _L5; else goto _L4
_L4:
        return null;
_L5:
        a.moveToPosition(j);
        return a;
_L3:
        if (b != null && j < b.getCount())
        {
            b.moveToPosition(j);
            return b;
        }
        if (true) goto _L4; else goto _L6
_L6:
    }

    public final int b(int j)
    {
        return e.b(j).b;
    }

    protected final int c(int j)
    {
        return e.b(j).d;
    }

    protected final int d(int j)
    {
        return 2;
    }

    public final int getViewTypeCount()
    {
        return 3;
    }
}
