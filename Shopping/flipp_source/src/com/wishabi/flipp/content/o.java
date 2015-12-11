// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.content;

import android.database.Cursor;
import android.graphics.RectF;
import com.wishabi.flipp.util.f;

// Referenced classes of package com.wishabi.flipp.content:
//            m, n

public final class o
{

    public final int a;
    public final int b;
    final int c;
    public final RectF d;
    public final Float e;
    public final Float f;
    public final Float g;
    public final String h;
    public final Float i;
    public final Float j;
    public final Float k;
    public final boolean l;
    public final Integer m;
    public final String n;
    final int o;
    public final int p;
    private final long q;
    private final Float r;
    private final int s;

    public o(Cursor cursor, m m1)
    {
        int i1;
        int j1;
        boolean flag = true;
        super();
        a = cursor.getInt(m1.a);
        b = cursor.getInt(m1.b);
        q = cursor.getLong(m1.c);
        c = cursor.getInt(m1.d);
        d = new RectF();
        d.left = cursor.getFloat(m1.e);
        d.top = cursor.getFloat(m1.f);
        d.right = cursor.getFloat(m1.g);
        d.bottom = cursor.getFloat(m1.h);
        e = com.wishabi.flipp.util.f.b(cursor, m1.i);
        f = com.wishabi.flipp.util.f.b(cursor, m1.j);
        g = com.wishabi.flipp.util.f.b(cursor, m1.k);
        h = com.wishabi.flipp.util.f.d(cursor, m1.l);
        i = com.wishabi.flipp.util.f.b(cursor, m1.m);
        r = com.wishabi.flipp.util.f.b(cursor, m1.n);
        j = com.wishabi.flipp.util.f.b(cursor, m1.o);
        k = com.wishabi.flipp.util.f.b(cursor, m1.p);
        if (cursor.getInt(m1.q) != 1)
        {
            flag = false;
        }
        l = flag;
        m = Integer.valueOf(cursor.getInt(m1.r));
        s = cursor.getInt(m1.s);
        if (m1.t != -1)
        {
            n = cursor.getString(m1.t);
        } else
        {
            n = null;
        }
        if (m1.u != -1)
        {
            o = cursor.getInt(m1.u);
        } else
        {
            o = -1;
        }
        j1 = n.c;
        i1 = j1;
        if (i == null) goto _L2; else goto _L1
_L1:
        i1 = j1;
        if (j == null) goto _L2; else goto _L3
_L3:
        i1 = j1;
        if (k == null) goto _L2; else goto _L4
_L4:
        i1 = j1;
        if (!l) goto _L2; else goto _L5
_L5:
        if (f == null || g == null) goto _L7; else goto _L6
_L6:
        i1 = n.a;
_L2:
        p = i1;
        return;
_L7:
        i1 = j1;
        if (e != null)
        {
            i1 = n.b;
        }
        if (true) goto _L2; else goto _L8
_L8:
    }

    public final RectF a()
    {
        return new RectF(d);
    }

    public final boolean b()
    {
        return p == n.a || p == n.b;
    }

    public final String toString()
    {
        return (new StringBuilder("Model{mId=")).append(a).append(", mFlyerId=").append(b).append(", mItemId=").append(q).append(", mCouponId=").append(c).append(", mItemRect=").append(d).append(", mItemCurrentPrice=").append(e).append(", mItemOriginalPrice=").append(f).append(", mItemDollarsOff=").append(g).append(", mItemCutoutUrl='").append(h).append('\'').append(", mCouponDollarsOff=").append(i).append(", mTotalSavings=").append(r).append(", mFinalPrice=").append(j).append(", mPercentOff=").append(k).append(", mDisplayFinalPrice=").append(l).append(", mDisplayType=").append(m).append(", mItemRank=").append(s).append(", mMerchantName=").append(n).append(", mMerchantId=").append(o).append('}').toString();
    }
}
