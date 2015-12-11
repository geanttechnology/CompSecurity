// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

public final class ah extends Enum
{

    public static final ah a;
    public static final ah b;
    public static final ah c;
    public static final ah d;
    public static final ah e;
    public static final ah f;
    public static final ah g;
    public static final ah h;
    public static final ah i;
    public static final ah j;
    public static final ah k;
    public static final ah l;
    public static final ah m;
    public static final ah n;
    public static final ah o;
    public static final ah p;
    private static final ah s[];
    private final ah q;
    private final ah r;

    private ah(String s1, int i1)
    {
        super(s1, i1);
        q = this;
        r = null;
    }

    private ah(String s1, int i1, ah ah1)
    {
        super(s1, i1);
        q = ah1;
        r = this;
    }

    private ah(String s1, int i1, ah ah1, ah ah2)
    {
        super(s1, i1);
        q = ah1;
        r = ah2;
    }

    public static ah a(Context context)
    {
        context = ((WindowManager)context.getSystemService("window")).getDefaultDisplay();
        int i1 = context.getRotation();
        Point point = new Point();
        if (android.os.Build.VERSION.SDK_INT >= 13)
        {
            context.getSize(point);
        } else
        {
            point.x = context.getWidth();
            point.y = context.getHeight();
        }
        if (point.x < point.y)
        {
            switch (i1 & 3)
            {
            default:
                return e;

            case 1: // '\001'
                return j;

            case 2: // '\002'
                return g;

            case 3: // '\003'
                return l;
            }
        }
        if (point.x > point.y)
        {
            switch (i1 & 3)
            {
            default:
                return i;

            case 1: // '\001'
                return f;

            case 2: // '\002'
                return k;

            case 3: // '\003'
                return h;
            }
        }
        switch (i1 & 3)
        {
        default:
            return m;

        case 1: // '\001'
            return n;

        case 2: // '\002'
            return o;

        case 3: // '\003'
            return p;
        }
    }

    public static ah b(Context context)
    {
        switch (context.getResources().getConfiguration().orientation)
        {
        default:
            return a;

        case 1: // '\001'
            return b;

        case 2: // '\002'
            return c;
        }
    }

    public static ah valueOf(String s1)
    {
        return (ah)Enum.valueOf(com/tapjoy/internal/ah, s1);
    }

    public static ah[] values()
    {
        return (ah[])s.clone();
    }

    public final boolean a()
    {
        return this == b || q == b;
    }

    public final boolean b()
    {
        return this == c || q == c;
    }

    public final int c()
    {
        if (r != null)
        {
            return ordinal() - r.ordinal();
        } else
        {
            return 0;
        }
    }

    static 
    {
        a = new ah("UNSPECIFIED", 0);
        b = new ah("PORTRAIT", 1);
        c = new ah("LANDSCAPE", 2);
        d = new ah("SQUARE", 3);
        e = new ah("NATURAL_PORTRAIT", 4, b);
        f = new ah("RIGHT_LANDSCAPE", 5, c, e);
        g = new ah("REVERSE_PORTRAIT", 6, b, e);
        h = new ah("LEFT_LANDSCAPE", 7, c, e);
        i = new ah("NATURAL_LANDSCAPE", 8, c);
        j = new ah("RIGHT_PORTRAIT", 9, b, i);
        k = new ah("REVERSE_LANDSCAPE", 10, c, i);
        l = new ah("LEFT_PORTRAIT", 11, b, i);
        m = new ah("NATURAL_SQUARE", 12, d);
        n = new ah("RIGHT_SQUARE", 13, d, m);
        o = new ah("REVERSE_SQUARE", 14, d, m);
        p = new ah("LEFT_SQUARE", 15, d, m);
        s = (new ah[] {
            a, b, c, d, e, f, g, h, i, j, 
            k, l, m, n, o, p
        });
    }
}
