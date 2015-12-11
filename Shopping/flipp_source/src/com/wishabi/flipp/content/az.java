// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.content;

import android.database.Cursor;

public final class az
{

    static int a = -1;
    private static int e = -1;
    private static int f = -1;
    private static int g = -1;
    private static int h = -1;
    private static int i = -1;
    private static int j = -1;
    public int b;
    public boolean c;
    Cursor d;
    private int k;
    private int l;

    public az(Cursor cursor, int i1)
    {
        b = -1;
        k = -1;
        l = -1;
        a(cursor, i1);
    }

    public az(az az1, Cursor cursor, int i1)
    {
        b = -1;
        k = -1;
        l = -1;
        b = az1.b;
        c = az1.c;
        a(cursor, i1);
    }

    private void a(Cursor cursor, int i1)
    {
        if (e == -1)
        {
            e = cursor.getColumnIndexOrThrow("id");
        }
        if (f == -1)
        {
            f = cursor.getColumnIndexOrThrow("name");
        }
        if (g == -1)
        {
            g = cursor.getColumnIndexOrThrow("checked");
        }
        if (h == -1)
        {
            h = cursor.getColumnIndexOrThrow("position");
        }
        if (i == -1)
        {
            i = cursor.getColumnIndexOrThrow("datetime_updated");
        }
        if (a == -1)
        {
            a = cursor.getColumnIndex("category");
        }
        if (j == -1)
        {
            j = cursor.getColumnIndex("cat_position");
        }
        d = cursor;
        k = i1;
    }

    public final long a()
    {
        f();
        long l1 = d.getLong(e);
        g();
        return l1;
    }

    public final String b()
    {
        f();
        String s = d.getString(f);
        g();
        return s;
    }

    public final boolean c()
    {
        boolean flag = true;
        f();
        if (d.getInt(g) != 1)
        {
            flag = false;
        }
        g();
        return flag;
    }

    public final int d()
    {
        if (j == -1)
        {
            throw new IllegalAccessError("Trying to grab category postion for ShoppingListItem without joining on the query");
        } else
        {
            f();
            int i1 = d.getInt(j);
            g();
            return i1;
        }
    }

    public final long e()
    {
        f();
        int i1 = d.getInt(i);
        g();
        return (long)i1;
    }

    final void f()
    {
        l = d.getPosition();
        if (d.getPosition() != k && !d.moveToPosition(k))
        {
            throw new IllegalStateException("Shopping list item has no cursor row backing it");
        } else
        {
            return;
        }
    }

    final void g()
    {
        if (d.getPosition() != l)
        {
            d.moveToPosition(l);
        }
    }

}
