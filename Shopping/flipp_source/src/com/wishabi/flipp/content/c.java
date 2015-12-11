// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.content;

import android.content.Context;
import android.database.Cursor;
import com.wishabi.flipp.app.FlippApplication;
import com.wishabi.flipp.util.f;
import com.wishabi.flipp.util.q;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

// Referenced classes of package com.wishabi.flipp.content:
//            d, f, e

public final class c
{

    private final String A;
    public final int a;
    public final Integer b;
    public final String c;
    public final String d;
    public final Integer e;
    public final com.wishabi.flipp.content.f f;
    public final String g;
    public final String h;
    public final String i;
    public final e j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;
    public final int o;
    public final boolean p;
    public final boolean q;
    public final boolean r;
    private final String s;
    private final Double t;
    private final Double u;
    private final Integer v;
    private final Integer w;
    private final String x;
    private final String y;
    private final boolean z;

    public c(Cursor cursor)
    {
        this(cursor, null);
    }

    public c(Cursor cursor, d d1)
    {
        boolean flag1 = true;
        super();
        d d2 = d1;
        if (d1 == null)
        {
            d2 = new d(cursor);
        }
        a = cursor.getInt(d2.a);
        b = com.wishabi.flipp.util.f.c(cursor, d2.b);
        c = com.wishabi.flipp.util.f.d(cursor, d2.c);
        d = com.wishabi.flipp.util.f.d(cursor, d2.d);
        e = com.wishabi.flipp.util.f.c(cursor, d2.e);
        f = com.wishabi.flipp.content.f.a(cursor.getString(d2.f));
        g = com.wishabi.flipp.util.f.d(cursor, d2.g);
        h = com.wishabi.flipp.util.f.d(cursor, d2.h);
        s = com.wishabi.flipp.util.f.d(cursor, d2.i);
        t = com.wishabi.flipp.util.f.a(cursor, d2.j);
        u = com.wishabi.flipp.util.f.a(cursor, d2.k);
        v = com.wishabi.flipp.util.f.c(cursor, d2.l);
        w = com.wishabi.flipp.util.f.c(cursor, d2.m);
        i = com.wishabi.flipp.util.f.d(cursor, d2.n);
        j = com.wishabi.flipp.content.e.a(cursor.getString(d2.o));
        x = cursor.getString(d2.p);
        y = com.wishabi.flipp.util.f.d(cursor, d2.q);
        k = cursor.getString(d2.r);
        l = com.wishabi.flipp.util.f.d(cursor, d2.s);
        m = cursor.getString(d2.t);
        n = com.wishabi.flipp.util.f.d(cursor, d2.u);
        boolean flag;
        if (cursor.getInt(d2.v) == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        z = flag;
        o = cursor.getInt(d2.w);
        A = cursor.getString(d2.x);
        if (cursor.getInt(d2.y) == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        p = flag;
        if (d2.z >= 0 && cursor.getInt(d2.z) == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        q = flag;
        if (d2.A >= 0 && cursor.getInt(d2.A) == 1)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        r = flag;
    }

    public final boolean a(String s1)
    {
        return A.equalsIgnoreCase(s1);
    }

    public final String[] a()
    {
        Context context;
        String as[];
        context = FlippApplication.b();
        if (context == null)
        {
            return null;
        }
        as = new String[3];
        if (z)
        {
            as[0] = s;
            return as;
        }
        if (f != f.a) goto _L2; else goto _L1
_L1:
        if (t != null && t.doubleValue() > 0.0D)
        {
            as[0] = context.getString(0x7f0e011d);
            as[1] = com.wishabi.flipp.util.q.a(t.doubleValue());
            as[2] = null;
        }
_L4:
        return as;
_L2:
        if (f == f.b)
        {
            if (u != null && u.doubleValue() > 0.0D)
            {
                String s1 = (new DecimalFormat()).format(u.doubleValue() * 100D);
                as[0] = null;
                as[1] = (new StringBuilder()).append(s1).append("%").toString();
                as[2] = context.getString(0x7f0e011b);
            }
        } else
        if (f == f.c && v != null && v.intValue() > 0)
        {
            if (Locale.getDefault().equals(Locale.CANADA_FRENCH))
            {
                if (t != null && t.doubleValue() > 0.0D)
                {
                    if (w != null && w.intValue() > 0)
                    {
                        as[0] = (new StringBuilder()).append(context.getString(0x7f0e0119, new Object[] {
                            v, w
                        })).append(" ").append(context.getString(0x7f0e011c, new Object[] {
                            com.wishabi.flipp.util.q.a(t.doubleValue())
                        })).append(" ").append(context.getString(0x7f0e011b)).toString();
                    } else
                    {
                        as[0] = (new StringBuilder()).append(context.getString(0x7f0e0118, new Object[] {
                            v
                        })).append(" ").append(com.wishabi.flipp.util.q.a(t.doubleValue())).append(" ").append(context.getString(0x7f0e011b)).toString();
                    }
                    as[1] = null;
                    as[2] = null;
                } else
                if (u != null && u.doubleValue() > 0.0D)
                {
                    String s2 = (new DecimalFormat()).format(u.doubleValue() * 100D);
                    if (w != null && w.intValue() > 0)
                    {
                        as[0] = (new StringBuilder()).append(context.getString(0x7f0e0119, new Object[] {
                            v, w
                        })).append(" ").append(context.getString(0x7f0e011c, new Object[] {
                            (new StringBuilder()).append(s2).append("%").toString()
                        })).append(" ").append(context.getString(0x7f0e011b)).toString();
                    } else
                    {
                        as[0] = (new StringBuilder()).append(context.getString(0x7f0e0118, new Object[] {
                            v
                        })).append(" ").append(s2).append("% ").append(context.getString(0x7f0e011b)).toString();
                    }
                    as[1] = null;
                    as[2] = null;
                } else
                if (t == null && u == null && w != null && w.intValue() > 0)
                {
                    as[0] = (new StringBuilder()).append(context.getString(0x7f0e0119, new Object[] {
                        v, w
                    })).append(" ").append(context.getString(0x7f0e011a)).toString();
                    as[1] = null;
                    as[2] = null;
                }
            } else
            if (t != null && t.doubleValue() > 0.0D)
            {
                Integer integer = v;
                Object obj;
                if (w != null && w.intValue() > 0)
                {
                    obj = w;
                } else
                {
                    obj = "";
                }
                as[0] = context.getString(0x7f0e0119, new Object[] {
                    integer, obj
                });
                as[1] = (new StringBuilder()).append(context.getString(0x7f0e011c, new Object[] {
                    com.wishabi.flipp.util.q.a(t.doubleValue())
                })).append(" ").append(context.getString(0x7f0e011b)).toString();
                as[2] = null;
            } else
            if (u != null && u.doubleValue() > 0.0D)
            {
                String s3 = (new DecimalFormat()).format(u.doubleValue() * 100D);
                Integer integer1 = v;
                Object obj1;
                if (w != null && w.intValue() > 0)
                {
                    obj1 = w;
                } else
                {
                    obj1 = "";
                }
                as[0] = context.getString(0x7f0e0119, new Object[] {
                    integer1, obj1
                });
                as[1] = (new StringBuilder()).append(context.getString(0x7f0e011c, new Object[] {
                    (new StringBuilder()).append(s3).append("%").toString()
                })).append(" ").append(context.getString(0x7f0e011b)).toString();
                as[2] = null;
            } else
            if (t == null && u == null && w != null && w.intValue() > 0)
            {
                as[0] = context.getString(0x7f0e0119, new Object[] {
                    v, w
                });
                as[1] = context.getString(0x7f0e011a);
                as[2] = null;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final String toString()
    {
        return (new StringBuilder("Model{mCouponId=")).append(a).append(", mMerchantId=").append(b).append(", mMerchantName='").append(c).append('\'').append(", mMerchantLogoUrl='").append(d).append('\'').append(", mCouponVendorId=").append(e).append(", mType=").append(f).append(", mBrand='").append(g).append('\'').append(", mBrandLogoUrl='").append(h).append('\'').append(", mSaleStory='").append(s).append('\'').append(", mDollarsOff=").append(t).append(", mPercentOff=").append(u).append(", mQualifyingQuantity=").append(v).append(", mRewardQuantity=").append(w).append(", mPromotionText='").append(i).append('\'').append(", mRedemptionMethod=").append(j).append(", mAvailableFrom='").append(x).append('\'').append(", mAvailableTo='").append(y).append('\'').append(", mValidFrom='").append(k).append('\'').append(", mValidTo='").append(l).append('\'').append(", mCouponImageUrl='").append(m).append('\'').append(", mBarcodeImageUrl='").append(n).append('\'').append(", mUseSaleStory=").append(z).append(", mPriority=").append(o).append(", mPostalCode='").append(A).append('\'').append(", mDeleted='").append(p).append('\'').append('}').toString();
    }
}
