// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.target.a.a.b;
import com.target.mothership.model.coupons.c;
import com.target.mothership.util.o;

public class t
{
    public static class a
    {

        private static final String COUPON_SHARED_PREF_OLD_APP = "couponPrefs";
        private static final String COUPON_SHARED_PREF_OLD_APP_ACCESS_KEY = "validatedKey";

        public static void a(Context context, c c1)
        {
            String s = com/target/ui/util/t$a.getSimpleName();
            context = context.getSharedPreferences("couponPrefs", 0);
            String s1 = context.getString("validatedKey", null);
            if (s1 != null)
            {
                if (o.g(s1))
                {
                    c1.b(s1);
                } else
                {
                    b.a(s, "Mobile coupon migration failed.");
                }
                context.edit().remove("validatedKey").apply();
                return;
            } else
            {
                b.a(s, "Old app had no signed up coupons");
                return;
            }
        }

        public a()
        {
        }
    }

}
