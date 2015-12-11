// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.Resources;
import com.wishabi.flipp.b.ao;
import com.wishabi.flipp.b.ap;
import com.wishabi.flipp.content.a;
import com.wishabi.flipp.util.p;
import com.wishabi.flipp.widget.ck;

// Referenced classes of package com.wishabi.flipp.app:
//            PrintCouponFragment

final class dx extends ao
{

    final int a;
    final PrintCouponFragment b;

    transient dx(PrintCouponFragment printcouponfragment, String s, int ai[], int i)
    {
        b = printcouponfragment;
        a = i;
        super(s, ai);
    }

    protected final void onCancelled()
    {
        PrintCouponFragment.c(b);
    }

    protected final void onPostExecute(Object obj)
    {
label0:
        {
            Object obj1 = (ap)obj;
            PrintCouponFragment.c(b);
            obj = b.getActivity();
            if (obj != null)
            {
                if (obj1 != ap.a)
                {
                    break label0;
                }
                int ai[] = new int[super.c.length];
                System.arraycopy(super.c, 0, ai, 0, super.c.length);
                com.wishabi.flipp.content.a.a(ai);
                ai = p.a();
                if (ai != null)
                {
                    ai.edit().putString("print_coupon_user_email", com.wishabi.flipp.app.PrintCouponFragment.a(b).e).commit();
                }
                com.wishabi.flipp.app.PrintCouponFragment.a(b, b.getResources().getQuantityString(0x7f0d0009, a, new Object[] {
                    Integer.valueOf(a)
                }));
                ((Activity) (obj)).finish();
            }
            return;
        }
        com.wishabi.flipp.app.PrintCouponFragment.a(b, b.getString(0x7f0e0124));
    }
}
