// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import java.util.List;

// Referenced classes of package com.wishabi.flipp.widget:
//            bl

public final class bj
{

    final List a;
    final PointF b;
    final float c;
    final float d;
    final int e;
    final RectF f;
    public final Matrix g;
    public final RectF h;
    public final Rect i;
    public final Rect j;
    long k;
    public boolean l;
    public boolean m;
    public long n;
    boolean o;

    private bj(bl bl1)
    {
        a = bl1.b;
        b = bl1.c;
        c = bl1.d;
        d = bl1.e;
        e = bl1.f;
        f = bl1.g;
        g = new Matrix();
        h = new RectF();
        i = new Rect();
        j = new Rect();
        if (bl1.a == null)
        {
            k = 333L;
            l = false;
            m = false;
            n = -1L;
            o = false;
            return;
        } else
        {
            k = bl1.a.k;
            l = bl1.a.l;
            m = bl1.a.m;
            n = bl1.a.n;
            o = bl1.a.o;
            return;
        }
    }

    public bj(bl bl1, byte byte0)
    {
        this(bl1);
    }
}
