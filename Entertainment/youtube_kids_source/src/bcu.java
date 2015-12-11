// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Rect;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class bcu
{

    static final DecimalFormat a;
    static final DecimalFormat b;
    private static final DecimalFormatSymbols o;
    long c;
    double d;
    boolean e;
    boolean f;
    final Long g[] = {
        Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L)
    };
    final Long h[] = {
        Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L)
    };
    final Long i[] = {
        Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L)
    };
    final List j = new ArrayList();
    Rect k;
    int l;
    int m;
    double n;

    public bcu()
    {
    }

    static bcv a(double d1)
    {
        if (d1 >= bcv.a.f)
        {
            return bcv.a;
        }
        if (d1 >= bcv.b.f)
        {
            return bcv.b;
        }
        if (d1 >= bcv.c.f)
        {
            return bcv.c;
        }
        if (d1 >= bcv.d.f)
        {
            return bcv.d;
        }
        if (d1 > bcv.e.f)
        {
            return bcv.e;
        } else
        {
            return null;
        }
    }

    public final void a(double d1, bct bct1)
    {
        if (bct1.k < 0)
        {
            return;
        }
        for (int i1 = j.size(); i1 <= bct1.k; i1++)
        {
            j.add(Integer.valueOf(0));
        }

        j.set(bct1.k, Integer.valueOf((int)(100D * d1)));
    }

    static 
    {
        o = new DecimalFormatSymbols(Locale.US);
        a = new DecimalFormat("0.00", o);
        b = new DecimalFormat("0.000", o);
    }
}
