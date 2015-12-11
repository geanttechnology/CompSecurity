// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.content;

import android.database.Cursor;
import android.graphics.RectF;
import java.util.Iterator;
import java.util.List;

public final class h
{

    public long a;
    public int b;
    public String c;
    public String d;
    public String e;
    public int f;
    public String g;
    public String h;
    public int i;
    private RectF j;

    public h(Cursor cursor)
    {
        a = cursor.getLong(cursor.getColumnIndex("_id"));
        b = cursor.getInt(cursor.getColumnIndex("flyer_id"));
        c = cursor.getString(cursor.getColumnIndex("item_image_url"));
        i = cursor.getInt(cursor.getColumnIndex("weight"));
        d = cursor.getString(cursor.getColumnIndex("sale_story"));
        e = cursor.getString(cursor.getColumnIndex("description"));
        f = cursor.getInt(cursor.getColumnIndex("brand_id"));
        h = cursor.getString(cursor.getColumnIndex("brand_logo_image_url"));
        g = cursor.getString(cursor.getColumnIndex("brand_display_name"));
        j = new RectF();
        j.left = cursor.getFloat(cursor.getColumnIndex("left"));
        j.top = cursor.getFloat(cursor.getColumnIndex("top"));
        j.right = cursor.getFloat(cursor.getColumnIndex("right"));
        j.bottom = cursor.getFloat(cursor.getColumnIndex("bottom"));
    }

    public static h a(List list)
    {
        if (list == null || list.isEmpty())
        {
            return null;
        }
        int l = list.size();
        float af[] = new float[l];
        int k = 0;
        float f1 = 0.0F;
        for (; k < l; k++)
        {
            float f2 = ((h)list.get(k)).i;
            af[k] = f2;
            f1 += f2;
        }

        float f3 = (float)(Math.random() * (double)f1);
        k = 0;
        f1 = 0.0F;
        for (; k < l; k++)
        {
            f1 += af[k];
            if (f1 >= f3)
            {
                return (h)list.get(k);
            }
        }

        return (h)list.get(l - 1);
    }

    public static h a(List list, long l)
    {
        if (list == null || list.isEmpty())
        {
            return null;
        }
        for (list = list.iterator(); list.hasNext();)
        {
            h h1 = (h)list.next();
            if (h1.a == l)
            {
                return h1;
            }
        }

        return null;
    }

    public final RectF a()
    {
        if (j.isEmpty())
        {
            return null;
        } else
        {
            return j;
        }
    }
}
