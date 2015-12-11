// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.content;

import android.content.Context;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import com.wishabi.flipp.util.a;
import com.wishabi.flipp.util.f;
import com.wishabi.flipp.util.q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

// Referenced classes of package com.wishabi.flipp.content:
//            ag, i, d, c, 
//            m, o

public final class l
{

    public static Loader a(Context context, String s, String as[], boolean flag)
    {
        s = (new StringBuilder()).append(s).append(" AND coupons_deleted = 0").toString();
        if (flag)
        {
            String as1[] = q.a(ag.v);
            s = (new StringBuilder()).append(s).append(" AND ").append(f.b("display_type", as1)).toString();
            as = com.wishabi.flipp.util.a.a(as, as1);
        }
        return new CursorLoader(context, i.r, new String[] {
            "flyerdb.flyer_item_coupons._id AS _id", "flyerdb.flyer_item_coupons.flyer_item_id AS flyer_item_id", "flyerdb.coupons.* AS coupons_*", "user_coupon_data.* AS user_coupon_data_*"
        }, s, as, "flyer_item_id ASC, coupons_priority ASC, coupons_available_from DESC, coupons__id DESC");
    }

    public static Loader a(Context context, int ai[], boolean flag, boolean flag1)
    {
        ArrayList arraylist = new ArrayList();
        int k = ai.length;
        for (int j = 0; j < k; j++)
        {
            arraylist.add(Integer.valueOf(ai[j]));
        }

        Collections.sort(arraylist, Collections.reverseOrder());
        ai = arraylist;
        if (arraylist.size() > 950)
        {
            ai = arraylist.subList(0, 950);
        }
        String as1[] = q.a(ai);
        String as[] = new String[3];
        as[0] = "flyer_item_coupons.*";
        as[1] = "flyerdb.flyers.merchant as merchant_name";
        as[2] = "flyerdb.flyers.merchant_id as merchant_id";
        ai = as;
        if (flag)
        {
            ai = com.wishabi.flipp.util.a.a(as, new String[] {
                "CASE WHEN clipped_items._id IS NULL THEN 0 ELSE 1 END AS item_clipped"
            });
        }
        Object obj1 = f.a("coupon_id", as1);
        Object obj = obj1;
        as = as1;
        String s;
        if (flag1)
        {
            String as2[] = q.a(ag.v);
            if (obj1 == null)
            {
                as = "";
            } else
            {
                as = (new StringBuilder()).append(((String) (obj1))).append(" AND ").toString();
            }
            obj = (new StringBuilder()).append(as).append(f.b("display_type", as2)).toString();
            as = com.wishabi.flipp.util.a.a(as1, as2);
        }
        obj1 = i.r;
        if (flag)
        {
            s = "coupon_id ASC, item_clipped DESC, item_rank ASC, _id DESC";
        } else
        {
            s = "coupon_id ASC, item_rank ASC, _id DESC";
        }
        return new CursorLoader(context, ((android.net.Uri) (obj1)), ai, ((String) (obj)), as, s);
    }

    public static Loader a(Context context, long al[])
    {
        ArrayList arraylist = new ArrayList();
        int k = al.length;
        for (int j = 0; j < k; j++)
        {
            arraylist.add(Long.valueOf(al[j]));
        }

        Collections.sort(arraylist, Collections.reverseOrder());
        al = arraylist;
        if (arraylist.size() > 950)
        {
            al = arraylist.subList(0, 950);
        }
        al = q.a(al);
        return a(context, f.a("flyer_item_id", al), ((String []) (al)), true);
    }

    public static HashMap a(Cursor cursor)
    {
        HashMap hashmap = new HashMap();
        if (cursor == null)
        {
            return hashmap;
        }
        int j = cursor.getColumnIndexOrThrow("flyer_item_id");
        d d1 = new d(cursor, "coupons_", "user_coupon_data_");
        for (boolean flag = cursor.moveToFirst(); flag; flag = cursor.moveToNext())
        {
            c c1 = new c(cursor, d1);
            long l1 = cursor.getLong(j);
            ArrayList arraylist1 = (ArrayList)hashmap.get(Long.valueOf(l1));
            ArrayList arraylist = arraylist1;
            if (arraylist1 == null)
            {
                arraylist = new ArrayList();
                hashmap.put(Long.valueOf(l1), arraylist);
            }
            arraylist.add(c1);
        }

        return hashmap;
    }

    public static HashMap a(Cursor cursor, boolean flag)
    {
        HashMap hashmap = new HashMap();
        m m1 = new m(cursor, "merchant_name", "merchant_id");
        for (boolean flag1 = cursor.moveToFirst(); flag1; flag1 = cursor.moveToNext())
        {
            o o1 = new o(cursor, m1);
            ArrayList arraylist1 = (ArrayList)hashmap.get(Integer.valueOf(o1.c));
            ArrayList arraylist = arraylist1;
            if (arraylist1 == null)
            {
                arraylist = new ArrayList();
                hashmap.put(Integer.valueOf(o1.c), arraylist);
            }
            if (!flag || o1.o != 3563)
            {
                arraylist.add(o1);
            }
        }

        return hashmap;
    }

    public static HashMap b(Cursor cursor)
    {
        return a(cursor, false);
    }
}
