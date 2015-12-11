// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.graphics.Point;
import java.net.URL;

// Referenced classes of package com.tapjoy.internal:
//            bp, gx, bu, cw, 
//            gz

static final class 
    implements bp
{

    private static Point b(bu bu1)
    {
        Object obj = null;
        bu1.i();
        while (bu1.k()) 
        {
            if ("offset".equals(bu1.m()))
            {
                bu1.i();
                int j = 0;
                int i = 0;
                while (bu1.k()) 
                {
                    obj = bu1.m();
                    if ("x".equals(obj))
                    {
                        i = bu1.s();
                    } else
                    if ("y".equals(obj))
                    {
                        j = bu1.s();
                    } else
                    {
                        bu1.t();
                    }
                }
                bu1.j();
                obj = new Point(i, j);
            } else
            {
                bu1.t();
            }
        }
        bu1.j();
        return ((Point) (obj));
    }

    public final Object a(bu bu1)
    {
        gz gz1 = null;
        bu1.i();
        Point point1 = null;
        Point point = null;
        do
        {
            if (!bu1.k())
            {
                break;
            }
            String s = bu1.m();
            if ("image".equals(s))
            {
                s = bu1.n();
                if (!cw.c(s))
                {
                    gz1 = new gz(new URL(s));
                }
            } else
            if ("landscape".equals(s))
            {
                point = b(bu1);
            } else
            if ("portrait".equals(s))
            {
                point1 = b(bu1);
            } else
            {
                bu1.t();
            }
        } while (true);
        bu1.j();
        return new gx(gz1, point, point1);
    }

    ()
    {
    }
}
