// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.animation.Animator;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import b.a.a.b;
import b.a.a.d.aa;
import b.a.a.d.d;
import b.a.a.i;
import com.wishabi.flipp.content.h;
import com.wishabi.flipp.util.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

// Referenced classes of package com.wishabi.flipp.widget:
//            cz, cb, ca, cc, 
//            by, bx, dz, bz, 
//            ba, FeaturedItemCell, az, da, 
//            ec, bc

public class bw extends cz
{

    private static final int a = cb.values().length;
    private static final int e = ca.a().length;
    private static final int f = cc.a().length;
    private static final i v = b.a.a.i.a(TimeZone.getTimeZone("America/Toronto"));
    public final boolean b;
    public final ArrayList c;
    private final SparseBooleanArray g;
    private final List h;
    private final HashMap i = new HashMap();
    private final int k;
    private final int l;
    private final int m;
    private final int n;
    private final int o;
    private final int p;
    private final int q;
    private final int r;
    private final cb s;
    private final ec t;
    private final bc u;

    public bw(Context context, Cursor cursor, SparseBooleanArray sparsebooleanarray, List list, cb cb1, boolean flag, ec ec, 
            bc bc)
    {
        super(context, cursor);
        g = sparsebooleanarray;
        h = list;
        k = cursor.getColumnIndexOrThrow("name");
        l = cursor.getColumnIndexOrThrow("thumbnail");
        m = cursor.getColumnIndexOrThrow("valid_from");
        n = cursor.getColumnIndexOrThrow("valid_to");
        o = cursor.getColumnIndexOrThrow("merchant");
        p = cursor.getColumnIndexOrThrow("flyer_id");
        q = cursor.getColumnIndexOrThrow("premium");
        s = cb1;
        b = flag;
        t = ec;
        u = bc;
        c = a(cb1, cursor, flag);
        r = cursor.getCount();
        context = new ArrayList();
        for (cursor = c.iterator(); cursor.hasNext(); context.add(Integer.valueOf(((by)cursor.next()).b))) { }
        a(context);
    }

    static int a()
    {
        return a;
    }

    static cb a(bw bw1)
    {
        return bw1.s;
    }

    public static final String a(cb cb1)
    {
        switch (bx.a[cb1.ordinal()])
        {
        default:
            return "premium DESC, priority ASC, available_from DESC";

        case 1: // '\001'
            return "premium DESC, priority ASC, available_from DESC";

        case 2: // '\002'
            return "merchant COLLATE NOCASE ASC, name COLLATE NOCASE ASC, flyer_id DESC";

        case 3: // '\003'
            return "available_from DESC, priority ASC, merchant COLLATE NOCASE ASC, flyer_id DESC";
        }
    }

    private ArrayList a(cb cb1, Cursor cursor, boolean flag)
    {
        ArrayList arraylist;
        int j;
        j = 0;
        arraylist = new ArrayList();
        if (flag)
        {
            arraylist.add(new by(ca.a, 0, com.wishabi.flipp.widget.cc.b, com.wishabi.flipp.widget.cc.d));
        }
        bx.a[cb1.ordinal()];
        JVM INSTR tableswitch 1 3: default 72
    //                   1 75
    //                   2 187
    //                   3 187;
           goto _L1 _L2 _L3 _L3
_L1:
        return arraylist;
_L2:
        for (flag = cursor.moveToFirst(); flag && cursor.getInt(q) != 0; flag = cursor.moveToNext())
        {
            j++;
        }

        int i1 = cursor.getCount() - j;
        if (j > 0)
        {
            arraylist.add(new by(com.wishabi.flipp.widget.ca.b, j, cc.a, cc.c));
        }
        if (i1 > 0)
        {
            arraylist.add(new by(ca.c, i1, com.wishabi.flipp.widget.cc.b, cc.c));
            return arraylist;
        }
          goto _L1
_L3:
        arraylist.add(new by(ca.c, cursor.getCount(), com.wishabi.flipp.widget.cc.b, cc.c));
        return arraylist;
    }

    public final int a(int j, int i1)
    {
        return b(j, i1);
    }

    protected final View a(Context context, int j, View view, ViewGroup viewgroup)
    {
        Object obj = (by)c.get(j);
        com.wishabi.flipp.widget.bx.b[((by) (obj)).a - 1];
        JVM INSTR tableswitch 1 1: default 44
    //                   1 63;
           goto _L1 _L2
_L1:
        obj = a(context, j);
        if (obj != null) goto _L4; else goto _L3
_L3:
        viewgroup = null;
_L6:
        return viewgroup;
_L2:
        viewgroup = view;
        if (view != null) goto _L6; else goto _L5
_L5:
        view = new dz(context);
        view.setTabAdapter(new bz(this, context));
        view.setTabClickListener(t);
        context = view;
_L8:
        return context;
_L4:
        view = (TextView)view;
        context = LayoutInflater.from(context);
        if (view == null)
        {
            context = (TextView)context.inflate(0x7f03002b, viewgroup, false);
        } else
        {
            context = view;
        }
        if (context == null)
        {
            return null;
        }
        context.setText(((CharSequence) (obj)));
        if (true) goto _L8; else goto _L7
_L7:
    }

    protected final View a(Context context, Cursor cursor, int j, View view)
    {
        Object obj;
        String s1;
        String s2;
        b b1;
        Object obj1;
        b b2;
        String s3;
        int i1;
        if (Locale.getDefault().getLanguage().equalsIgnoreCase("fr"))
        {
            obj = (new StringBuilder()).append(cursor.getString(k)).append(" ").append(cursor.getString(o)).toString();
        } else
        {
            obj = (new StringBuilder()).append(cursor.getString(o)).append(" ").append(cursor.getString(k)).toString();
        }
        i1 = cursor.getInt(p);
        s1 = cursor.getString(m);
        s2 = cursor.getString(n);
        obj1 = aa.a();
        b1 = ((d) (obj1)).a(s1);
        obj1 = ((d) (obj1)).a(s2);
        b2 = b.a.a.b.a(v);
        s3 = cursor.getString(l);
        if (c(j) != cc.a - 1) goto _L2; else goto _L1
_L1:
        boolean flag;
        if (view != null)
        {
            cursor = (ba)view;
        } else
        {
            cursor = new ba(context);
        }
        cursor.setFlyerName(((String) (obj)));
        if (g != null)
        {
            if (!g.get(i1))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            cursor.setUnread(flag);
        }
        if (b2.a(b1) < 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        cursor.setUpcoming(flag);
        cursor.setThumbnailUrl(s3);
        if (s1 != null && s2 != null)
        {
            cursor.setFlyerDate(com.wishabi.flipp.util.e.a(context.getResources(), b1, b2, ((b) (obj1))));
        }
        view = null;
        obj = h.iterator();
        do
        {
            context = view;
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            context = (h)((Iterator) (obj)).next();
        } while (i1 != ((h) (context)).b);
        if (context != null) goto _L4; else goto _L3
_L3:
        ((ba) (cursor)).a.setData(null);
        ((ba) (cursor)).a.a();
        cursor.setFeaturedItemClickListener(null);
        obj = cursor;
_L6:
        return ((View) (obj));
_L4:
        long l1 = ((h) (context)).a;
        obj = (Boolean)i.get(Long.valueOf(l1));
        view = ((View) (obj));
        if (obj == null)
        {
            view = Boolean.valueOf(false);
        }
        boolean flag1;
        if (!view.booleanValue())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        view = Boolean.valueOf(flag1);
        flag1 = view.booleanValue();
        ((ba) (cursor)).a.setData(context);
        context = ((ba) (cursor)).a;
        ((FeaturedItemCell) (context)).a.cancel();
        context.setVisibility(0);
        if (flag1)
        {
            ((FeaturedItemCell) (context)).a.start();
        } else
        {
            context.setAlpha(1.0F);
            context.setXFraction(0.0F);
        }
        cursor.a();
        cursor.setFeaturedItemClickListener(u);
        obj = cursor;
        if (view.booleanValue())
        {
            i.put(Long.valueOf(l1), Boolean.valueOf(true));
            return cursor;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        boolean flag2;
        if (view != null)
        {
            view = (az)view;
        } else
        {
            view = new az(context);
        }
        view.setFlyerName((new StringBuilder()).append(cursor.getString(o)).append(" ").append(cursor.getString(k)).toString());
        if (g != null)
        {
            if (!g.get(i1))
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            view.setUnread(flag2);
        }
        if (b2.a(b1) < 0)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        view.setUpcoming(flag2);
        view.setThumbnailUrl(s3);
        obj = view;
        if (s1 != null)
        {
            obj = view;
            if (s2 != null)
            {
                view.setFlyerDate(com.wishabi.flipp.util.e.a(context.getResources(), b1, b2, ((b) (obj1))));
                return view;
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public String a(Context context, int j)
    {
        c.get(j);
        String s1 = null;
        if (b && j == 1 || j == 0)
        {
            s1 = context.getResources().getString(0x7f0e0012, new Object[] {
                Integer.valueOf(super.j)
            });
        }
        return s1;
    }

    public final int b(int j)
    {
        return ((by)c.get(j)).a;
    }

    protected final int c(int j)
    {
        return ((by)c.get(j)).c - 1;
    }

    protected final int d(int j)
    {
        return ((by)c.get(j)).d - 1;
    }

    public final int e(int j)
    {
        boolean flag = false;
        Iterator iterator = c.iterator();
        int i1 = 0;
        int j1;
        do
        {
            j1 = ((flag) ? 1 : 0);
            if (!iterator.hasNext())
            {
                break;
            }
            by by1 = (by)iterator.next();
            j1 = i1 + by1.b;
            i1 = j1;
            if (j >= j1)
            {
                continue;
            }
            j1 = by1.a;
            break;
        } while (true);
        return j1;
    }

    public int getViewTypeCount()
    {
        return f;
    }

}
