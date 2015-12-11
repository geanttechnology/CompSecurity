// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import b.a.a.b;
import b.a.a.d.aa;
import b.a.a.d.d;
import b.a.a.i;
import com.wishabi.flipp.app.dn;
import com.wishabi.flipp.app.eo;
import com.wishabi.flipp.content.ad;
import com.wishabi.flipp.content.ae;
import com.wishabi.flipp.content.ai;
import com.wishabi.flipp.util.e;
import com.wishabi.flipp.util.l;
import com.wishabi.flipp.util.o;
import com.wishabi.flipp.util.q;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

// Referenced classes of package com.wishabi.flipp.widget:
//            da, az, a, f, 
//            aw, ZeroCaseView, ec

public final class ci extends da
{

    private static final i f = b.a.a.i.a(TimeZone.getTimeZone("America/Toronto"));
    final List a;
    final Cursor b;
    final ae c;
    final HashMap d;
    final l e = new l();
    private final SparseBooleanArray g;
    private final Cursor h;
    private final ZeroCaseView i;
    private final Context k;
    private final dn l;
    private final dn m;
    private final ec n;
    private final int o;
    private final int p;
    private final int q;

    public ci(Context context, Cursor cursor, Cursor cursor1, ae ae1, List list, SparseBooleanArray sparsebooleanarray, HashMap hashmap, 
            ZeroCaseView zerocaseview, dn dn, dn dn1, int j, int i1, int j1, ec ec)
    {
        k = context;
        h = cursor;
        g = sparsebooleanarray;
        b = cursor1;
        c = ae1;
        d = hashmap;
        i = zerocaseview;
        a = list;
        l = dn;
        m = dn1;
        o = j;
        p = i1;
        q = j1;
        n = ec;
        context = com.wishabi.flipp.util.o.a(0, 0);
        context.d = -1;
        e.a(context);
        if (b != null && b.getCount() > 0)
        {
            context = com.wishabi.flipp.util.o.a(2, b.getCount());
            context.d = 2;
            e.a(context);
        }
        if (h != null && h.getCount() > 0)
        {
            context = com.wishabi.flipp.util.o.a(1, h.getCount());
            context.d = 1;
            e.a(context);
        }
        if (a != null && !a.isEmpty())
        {
            context = com.wishabi.flipp.util.o.a(3, a.size());
            context.d = 3;
            e.a(context);
        }
        if (e.b() == 0 && i != null)
        {
            e.a();
            context = com.wishabi.flipp.util.o.a(0, 1);
            context.d = 6;
            e.a(context);
        }
        context = new ArrayList();
        for (cursor = e.iterator(); cursor.hasNext(); context.add(Integer.valueOf(((o)cursor.next()).a()))) { }
        a(context);
    }

    protected final View a(int j, int i1, View view)
    {
        boolean flag1 = true;
        Object obj = null;
        Object obj1 = null;
        int j1 = c(j);
        Object obj2 = b.a.a.b.a(f);
        switch (j1)
        {
        case 4: // '\004'
        case 5: // '\005'
        default:
            throw new IllegalArgumentException("Invalid section and index for item in search");

        case 0: // '\0'
            throw new IllegalArgumentException("SearchAdapter is is asking for item in the tab bar section.  The tab bar should be a header");

        case 6: // '\006'
            return i;

        case 1: // '\001'
            String s;
            b b1;
            Object obj3;
            boolean flag;
            if (view != null)
            {
                view = (az)view;
            } else
            {
                view = new az(k);
            }
            obj = (Cursor)a(j, i1);
            view.setFlyerName((new StringBuilder()).append(((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndexOrThrow("merchant"))).append(" ").append(((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndexOrThrow("name"))).toString());
            obj1 = ((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndexOrThrow("valid_from"));
            s = ((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndexOrThrow("valid_to"));
            obj3 = aa.a();
            b1 = ((d) (obj3)).a(((String) (obj1)));
            obj3 = ((d) (obj3)).a(s);
            if (obj1 != null && s != null)
            {
                view.setFlyerDate(com.wishabi.flipp.util.e.a(k.getResources(), b1, ((b) (obj2)), ((b) (obj3))));
            }
            if (g != null)
            {
                if (!g.get(((Cursor) (obj)).getInt(((Cursor) (obj)).getColumnIndexOrThrow("flyer_id"))))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                view.setUnread(flag);
            }
            if (((b) (obj2)).a(b1) < 0)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            view.setUpcoming(flag);
            view.setThumbnailUrl(((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndexOrThrow("thumbnail")));
            return view;

        case 2: // '\002'
            ad ad1;
            String s2;
            String s4;
            String s6;
            String s8;
            if (view != null)
            {
                view = (a)view;
            } else
            {
                view = new a(k);
            }
            ad1 = new ad(b, c, i1);
            obj2 = k;
            obj = aa.a();
            ad1.a.moveToPosition(ad1.c);
            s2 = ad1.a.getString(ad1.b.f);
            if (s2 != null)
            {
                obj = ((d) (obj)).a(s2);
            } else
            {
                obj = null;
            }
            ad1.a.moveToPosition(ad1.c);
            s2 = ad1.a.getString(ad1.b.g);
            ad1.a.moveToPosition(ad1.c);
            s4 = ad1.a.getString(ad1.b.h);
            ad1.a.moveToPosition(ad1.c);
            s6 = ad1.a.getString(ad1.b.j);
            ad1.a.moveToPosition(ad1.c);
            s8 = ad1.a.getString(ad1.b.i);
            j = f.a;
            if (d != null)
            {
                obj1 = (ArrayList)d.get(Long.valueOf(ad1.e()));
            }
            aw.a(((Context) (obj2)), view, ((b) (obj)), s2, s4, s6, s8, i1, j, ((ArrayList) (obj1)), m);
            return view;

        case 3: // '\003'
            break;
        }
        String s1;
        String s3;
        String s5;
        String s7;
        ai ai1;
        if (view != null)
        {
            view = (a)view;
        } else
        {
            view = new a(k);
        }
        ai1 = (ai)a(j, i1);
        obj1 = k;
        obj2 = ai1.i;
        s1 = ai1.d.toString();
        s3 = ai1.c;
        s5 = ai1.g;
        s7 = ai1.f;
        j = f.a;
        if (d != null)
        {
            obj = (ArrayList)d.get(Long.valueOf(ai1.a));
        }
        aw.a(((Context) (obj1)), view, ((b) (obj2)), s1, s3, s5, s7, i1, j, ((ArrayList) (obj)), l);
        return view;
    }

    protected final View a(int j, View view, ViewGroup viewgroup)
    {
        j = b(j);
        j;
        JVM INSTR tableswitch 0 3: default 36
    //                   0 47
    //                   1 77
    //                   2 174
    //                   3 77;
           goto _L1 _L2 _L3 _L4 _L3
_L1:
        throw new IllegalArgumentException("Invalid search section");
_L2:
        if (view == null) goto _L6; else goto _L5
_L5:
        return view;
_L6:
        return eo.a(k, o, p, q, n);
_L3:
        TextView textview = (TextView)view;
        view = textview;
        if (textview == null)
        {
            view = (TextView)LayoutInflater.from(k).inflate(0x7f03002b, viewgroup, false);
        }
        if (j == 1)
        {
            viewgroup = com.wishabi.flipp.util.q.a(com.wishabi.flipp.util.q.b());
        } else
        {
            viewgroup = k.getResources().getQuantityString(0x7f0d0008, a.size(), new Object[] {
                Integer.valueOf(a.size())
            });
        }
        view.setText(viewgroup);
        return view;
_L4:
        if (view == null)
        {
            return LayoutInflater.from(k).inflate(0x7f030009, viewgroup, false);
        }
        if (true) goto _L5; else goto _L7
_L7:
    }

    protected final Object a(int j)
    {
        o o1 = e.c(j);
        return a(e.a.indexOf(o1), j - o1.c);
    }

    final Object a(int j, int i1)
    {
        switch (e.b(j).b)
        {
        default:
            throw new InvalidParameterException("invalid section index");

        case 0: // '\0'
            return i;

        case 1: // '\001'
            if (h != null)
            {
                h.moveToPosition(i1);
            }
            return h;

        case 2: // '\002'
            if (b != null)
            {
                b.moveToPosition(i1);
            }
            return b;

        case 3: // '\003'
            return a.get(i1);
        }
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
        switch (b(j))
        {
        default:
            throw new IllegalArgumentException("Invalid search section");

        case 0: // '\0'
            return 0;

        case 2: // '\002'
            return 5;

        case 1: // '\001'
        case 3: // '\003'
            return 4;
        }
    }

    public final int getViewTypeCount()
    {
        return 7;
    }

}
