// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.an;
import android.support.v7.widget.av;
import android.support.v7.widget.bi;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.wishabi.flipp.util.i;
import com.wishabi.flipp.util.k;
import com.wishabi.flipp.util.l;
import com.wishabi.flipp.util.m;
import com.wishabi.flipp.util.o;

// Referenced classes of package com.wishabi.flipp.widget:
//            cl, cm, cr, cx, 
//            cn, cs, CouponCell, ct, 
//            z, aw, cw, cv

public final class ck extends an
{

    final l c = new l();
    public final SparseBooleanArray d = new SparseBooleanArray();
    public String e;
    private final Context f;
    private final Cursor g;
    private final String h = com.wishabi.flipp.util.k.a(null);
    private final cw i;
    private final cv j = new cm(this);
    private final TextWatcher k = new cl(this);
    private final boolean l;

    public ck(Context context, Cursor cursor, String s, SparseBooleanArray sparsebooleanarray, cw cw)
    {
        f = context;
        g = cursor;
        i = cw;
        context = new o(-2);
        context.a(new m(-2L, 0));
        c.a(context);
        context = new o(-3);
        context.a(new m(-3L, 1));
        c.a(context);
        e = s;
        boolean flag4 = false;
        int l1 = g.getColumnIndexOrThrow("redemption_method");
        int i2 = g.getColumnIndexOrThrow("barcode_image_url");
        int j2 = g.getColumnIndexOrThrow("_id");
        int k2 = g.getColumnIndexOrThrow("sent");
        boolean flag2 = g.moveToFirst();
        int i1;
        int k1;
        boolean flag;
        boolean flag1;
        if (flag2 && g.getInt(k2) == 1)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        flag = flag2;
        k1 = i1;
        flag1 = flag4;
        if (flag2)
        {
            flag = flag2;
            k1 = i1;
            flag1 = flag4;
            if (i1 == 0)
            {
                context = new o(-4);
                k1 = 0;
                flag = false;
                for (flag1 = flag2; flag1 && i1 == 0;)
                {
                    i1 = g.getInt(j2);
                    if (sparsebooleanarray == null || sparsebooleanarray.get(i1) || sparsebooleanarray.indexOfKey(i1) < 0)
                    {
                        d.put(i1, true);
                        k1++;
                    } else
                    {
                        d.put(i1, false);
                    }
                    context.b(new m(i1, 3, Integer.valueOf(g.getPosition())));
                    flag1 = flag;
                    if (!flag)
                    {
                        cursor = g.getString(l1);
                        flag1 = flag;
                        if (!TextUtils.isEmpty(cursor))
                        {
                            flag1 = flag;
                            if (cursor.equals("print"))
                            {
                                flag1 = flag;
                                if (TextUtils.isEmpty(g.getString(i2)))
                                {
                                    flag1 = true;
                                }
                            }
                        }
                    }
                    flag2 = g.moveToNext();
                    if (flag2 && g.getInt(k2) == 1)
                    {
                        i1 = 1;
                        flag = flag1;
                        flag1 = flag2;
                    } else
                    {
                        i1 = 0;
                        flag = flag1;
                        flag1 = flag2;
                    }
                }

                context.a(new m(-4L, 2, new cr(f.getString(0x7f0e0103), k1)));
                c.a(context);
                flag2 = flag1;
                flag1 = flag;
                k1 = i1;
                flag = flag2;
            }
        }
        while (flag && k1 != 0) 
        {
            context = new o(-5);
            int j1 = 0;
            boolean flag3 = flag1;
            flag1 = flag;
            flag = flag3;
            while (flag1 && k1 != 0) 
            {
                k1 = g.getInt(j2);
                if (sparsebooleanarray != null && sparsebooleanarray.get(k1))
                {
                    d.put(k1, true);
                    j1++;
                } else
                {
                    d.put(k1, false);
                }
                context.b(new m(k1, 3, Integer.valueOf(g.getPosition())));
                flag1 = flag;
                if (!flag)
                {
                    cursor = g.getString(l1);
                    flag1 = flag;
                    if (!TextUtils.isEmpty(cursor))
                    {
                        flag1 = flag;
                        if (cursor.equals("print"))
                        {
                            flag1 = flag;
                            if (TextUtils.isEmpty(g.getString(i2)))
                            {
                                flag1 = true;
                            }
                        }
                    }
                }
                flag3 = g.moveToNext();
                if (flag3 && g.getInt(k2) == 1)
                {
                    k1 = 1;
                    flag = flag1;
                    flag1 = flag3;
                } else
                {
                    k1 = 0;
                    flag = flag1;
                    flag1 = flag3;
                }
            }
            context.a(new m(-5L, 2, new cr(f.getString(0x7f0e010b), j1)));
            c.a(context);
            flag3 = flag;
            flag = flag1;
            flag1 = flag3;
        }
        l = flag1;
    }

    public final int a()
    {
        return c.c();
    }

    public final int a(int i1)
    {
        m m1 = c.d(i1);
        if (m1 == null)
        {
            return -1;
        } else
        {
            return m1.d;
        }
    }

    public final bi a(ViewGroup viewgroup, int i1)
    {
        switch (i1)
        {
        default:
            return null;

        case 0: // '\0'
            return new cx(View.inflate(f, 0x7f030049, null));

        case 1: // '\001'
            viewgroup = View.inflate(f, 0x7f030047, null);
            return new cn(f, viewgroup, k, i);

        case 2: // '\002'
            viewgroup = View.inflate(f, 0x7f030048, null);
            i1 = com.wishabi.flipp.util.i.a(5);
            av av1 = new av(-1, -2);
            av1.setMargins(0, i1, 0, i1);
            viewgroup.setLayoutParams(av1);
            return new cs(viewgroup);

        case 3: // '\003'
            viewgroup = new CouponCell(f);
            break;
        }
        viewgroup.setLayoutParams(new av(-1, -2));
        return new ct(viewgroup, j);
    }

    public final void a(bi bi, int i1)
    {
        int j1 = 0;
        Object obj;
        switch (a(i1))
        {
        default:
            return;

        case 1: // '\001'
            bi = (cn)bi;
            String s = e;
            boolean flag = l;
            ((cn) (bi)).l.setText(s);
            bi = ((cn) (bi)).m;
            if (flag)
            {
                i1 = j1;
            } else
            {
                i1 = 8;
            }
            bi.setVisibility(i1);
            return;

        case 2: // '\002'
            cr cr1 = (cr)c.d(i1).e;
            bi = (cs)bi;
            Context context = f;
            ((cs) (bi)).k.setText(cr1.a);
            ((cs) (bi)).l.setText(context.getString(0x7f0e010a, new Object[] {
                Integer.valueOf(cr1.b)
            }));
            return;

        case 3: // '\003'
            obj = c.d(i1);
            j1 = ((Integer)((m) (obj)).e).intValue();
            break;
        }
        if (!g.moveToPosition(j1))
        {
            throw new IllegalStateException((new StringBuilder("Couldn't move cursor to position ")).append(j1).toString());
        }
        i1 = (int)((m) (obj)).a;
        boolean flag1 = d.get(i1);
        Object obj1 = (ct)bi;
        bi = f;
        obj = h;
        obj1 = ((ct) (obj1)).k;
        Cursor cursor = g;
        if (flag1)
        {
            i1 = z.b;
        } else
        {
            i1 = z.c;
        }
        aw.a(bi, ((String) (obj)), ((CouponCell) (obj1)), j1, cursor, false, false, i1, com.wishabi.flipp.util.i.a(260), null, null);
    }

    public final long b(int i1)
    {
        m m1 = c.d(i1);
        if (m1 == null)
        {
            return -1L;
        } else
        {
            return m1.a;
        }
    }
}
