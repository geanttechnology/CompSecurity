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

public class com.target.mothership.services.apigee.g.a.a extends k
{
    public class a
    {

        private com.target.mothership.common.c.b mChannel;
        private String mItemCode;
        private Boolean mItemCompleted;
        private String mItemNote;
        private Integer mItemPosition;
        private String mItemTitle;
        private com.target.mothership.common.c.a mItemType;
        private String mPromotionType;
        private String mPromotionValue;
        private Integer mPurchasedQuantity;
        private Integer mRequestedQuantity;
        private String mUserId;
        final com.target.mothership.services.apigee.g.a.a this$0;

        static String a(a a1)
        {
            return a1.mUserId;
        }

        static String b(a a1)
        {
            return a1.mItemCode;
        }

        static String c(a a1)
        {
            return a1.mItemNote;
        }

        static Integer d(a a1)
        {
            return a1.mRequestedQuantity;
        }

        static Integer e(a a1)
        {
            return a1.mPurchasedQuantity;
        }

        static com.target.mothership.common.c.b f(a a1)
        {
            return a1.mChannel;
        }

        static String g(a a1)
        {
            return a1.mItemTitle;
        }

        static com.target.mothership.common.c.a h(a a1)
        {
            return a1.mItemType;
        }

        static Integer i(a a1)
        {
            return a1.mItemPosition;
        }

        static Boolean j(a a1)
        {
            return a1.mItemCompleted;
        }

        static String k(a a1)
        {
            return a1.mPromotionType;
        }

        static String l(a a1)
        {
            return a1.mPromotionValue;
        }
    }

    public static class b
        implements t
    {

        public l a(com.target.mothership.services.apigee.g.a.a a1, Type type, s s)
        {
            type = new o();
            s = new i();
            o o1;
            for (a1 = com.target.mothership.services.apigee.g.a.a.a(a1).iterator(); a1.hasNext(); s.a(o1))
            {
                a a2 = (a)a1.next();
                o1 = new o();
                o1.a("user_id", a.a(a2));
                o1.a("item_code", a.b(a2));
                o1.a("item_note", a.c(a2));
                o1.a("requested_quantity", a.d(a2));
                o1.a("purchased_quantity", a.e(a2));
                o1.a("channel", a.f(a2).toString());
                o1.a("item_title", a.g(a2));
                o1.a("item_type", a.h(a2).toString());
                o1.a("item_position", com.target.mothership.services.apigee.g.a.a.i(a2));
                o1.a("item_completed_ind", a.j(a2));
                if (com.target.mothership.services.apigee.g.a.a.k(a2) != null)
                {
                    i j = new i();
                    o o2 = new o();
                    o2.a("promotion_type", com.target.mothership.services.apigee.g.a.a.k(a2));
                    o2.a("promotion_value", com.target.mothership.services.apigee.g.a.a.l(a2));
                    o1.a("promotions", j);
                }
            }

            type.a("items", s);
            return type;
        }

        public l serialize(Object obj, Type type, s s)
        {
            return a((com.target.mothership.services.apigee.g.a.a)obj, type, s);
        }

        public b()
        {
        }
    }


    private List items;

    static List a(com.target.mothership.services.apigee.g.a.a a1)
    {
        return a1.items;
    }
}
