// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.g.a;

import com.google.b.i;
import com.google.b.l;
import com.google.b.o;
import com.google.b.s;
import com.google.b.t;
import com.target.mothership.services.k;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;

public class com.target.mothership.services.apigee.g.a.b extends k
{
    public static class a
        implements t
    {

        public l a(com.target.mothership.services.apigee.g.a.b b1, Type type, s s)
        {
            type = new o();
            s = new i();
            o o1;
            for (b1 = b1.b().iterator(); b1.hasNext(); s.a(o1))
            {
                b b2 = (b)b1.next();
                o1 = new o();
                o1.a("item_id", b.a(b2));
                o1.a("user_id", b.b(b2));
                o1.a("item_code", b.c(b2));
                o1.a("item_note", b.d(b2));
                o1.a("requested_quantity", b.e(b2));
                o1.a("purchased_quantity", b.f(b2));
                o1.a("channel", b.g(b2).toString());
                o1.a("item_title", b.h(b2));
                o1.a("item_type", com.target.mothership.services.apigee.g.a.b.i(b2).toString());
                o1.a("item_position", b.j(b2));
                o1.a("item_completed_ind", com.target.mothership.services.apigee.g.a.b.k(b2));
                if (com.target.mothership.services.apigee.g.a.b.l(b2) != null)
                {
                    i j = new i();
                    o o2 = new o();
                    o2.a("promotion_type", com.target.mothership.services.apigee.g.a.b.l(b2));
                    o2.a("promotion_value", b.m(b2));
                    o1.a("promotions", j);
                }
            }

            type.a("items", s);
            return type;
        }

        public l serialize(Object obj, Type type, s s)
        {
            return a((com.target.mothership.services.apigee.g.a.b)obj, type, s);
        }

        public a()
        {
        }
    }

    public class b extends k
    {

        private com.target.mothership.common.c.b mChannel;
        private String mItemCode;
        private Boolean mItemCompleted;
        private String mItemId;
        private String mItemNote;
        private Integer mItemPosition;
        private String mItemTitle;
        private com.target.mothership.common.c.a mItemType;
        private String mPromotionType;
        private String mPromotionValue;
        private Integer mPurchasedQuantity;
        private Integer mRequestedQuantity;
        private String mUserId;
        final com.target.mothership.services.apigee.g.a.b this$0;

        static String a(b b1)
        {
            return b1.mItemId;
        }

        static String b(b b1)
        {
            return b1.mUserId;
        }

        static String c(b b1)
        {
            return b1.mItemCode;
        }

        static String d(b b1)
        {
            return b1.mItemNote;
        }

        static Integer e(b b1)
        {
            return b1.mRequestedQuantity;
        }

        static Integer f(b b1)
        {
            return b1.mPurchasedQuantity;
        }

        static com.target.mothership.common.c.b g(b b1)
        {
            return b1.mChannel;
        }

        static String h(b b1)
        {
            return b1.mItemTitle;
        }

        static com.target.mothership.common.c.a i(b b1)
        {
            return b1.mItemType;
        }

        static Integer j(b b1)
        {
            return b1.mItemPosition;
        }

        static Boolean k(b b1)
        {
            return b1.mItemCompleted;
        }

        static String l(b b1)
        {
            return b1.mPromotionType;
        }

        static String m(b b1)
        {
            return b1.mPromotionValue;
        }
    }


    private List mItems;

    public List b()
    {
        return mItems;
    }
}
