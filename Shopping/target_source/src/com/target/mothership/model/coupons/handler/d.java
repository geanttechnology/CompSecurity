// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.coupons.handler;

import com.target.mothership.common.coupons.CouponIdentifier;
import com.target.mothership.model.b;
import com.target.mothership.services.b.a.b.g;
import com.target.mothership.util.o;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

// Referenced classes of package com.target.mothership.model.coupons.handler:
//            TGTBaseCouponOffer

public abstract class d extends b
{

    public static final int DATE_CORRECTION_FACTOR = -12;
    public static final String DATE_FORMAT = "yyyy/MM/dd HH:mm:ss ZZZ";

    public d(com.target.mothership.model.d d1)
    {
        super(d1);
    }

    private Date a(String s)
    {
        Date date = b(s);
        s = null;
        if (date != null)
        {
            s = Calendar.getInstance();
            s.setTime(date);
            s.add(11, -12);
            s = s.getTime();
        }
        return s;
    }

    private Date b(String s)
    {
        Date date = null;
        if (o.g(s))
        {
            date = (new SimpleDateFormat("yyyy/MM/dd HH:mm:ss ZZZ", Locale.US)).parse(s, new ParsePosition(0));
        }
        return date;
    }

    protected void a(TGTBaseCouponOffer tgtbasecouponoffer, g g1)
    {
        CouponIdentifier couponidentifier = new CouponIdentifier(g1.f());
        String s = g1.c();
        Date date = b(g1.d());
        g1 = a(g1.e());
        tgtbasecouponoffer.a(couponidentifier);
        tgtbasecouponoffer.b(s);
        tgtbasecouponoffer.a(date);
        tgtbasecouponoffer.b(g1);
    }
}
