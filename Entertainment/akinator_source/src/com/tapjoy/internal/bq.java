// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.graphics.Point;
import android.graphics.Rect;

// Referenced classes of package com.tapjoy.internal:
//            bp, bu, bz

public final class bq
{

    public static final bp a = new bp() {

        public final Object a(bu bu1)
        {
            Point point = new Point();
            bu1.i();
            while (bu1.k()) 
            {
                String s = bu1.m();
                if ("x".equals(s))
                {
                    point.x = bu1.s();
                } else
                if ("y".equals(s))
                {
                    point.y = bu1.s();
                } else
                {
                    bu1.t();
                }
            }
            bu1.j();
            return point;
        }

    };
    public static final bp b = new bp() {

        public final Object a(bu bu1)
        {
            Rect rect = new Rect();
            static final class _cls3
            {

                static final int a[];

                static 
                {
                    a = new int[bz.values().length];
                    try
                    {
                        a[bz.a.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        a[bz.c.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            switch (_cls3.a[bu1.l().ordinal()])
            {
            default:
                throw new IllegalStateException((new StringBuilder("Unexpected token: ")).append(bu1.l()).toString());

            case 1: // '\001'
                bu1.g();
                rect.left = bu1.s();
                rect.top = bu1.s();
                rect.right = bu1.s();
                rect.bottom = bu1.s();
                for (; bu1.k(); bu1.t()) { }
                bu1.h();
                return rect;

            case 2: // '\002'
                bu1.i();
                break;
            }
            while (bu1.k()) 
            {
                String s = bu1.m();
                if ("left".equals(s))
                {
                    rect.left = bu1.s();
                } else
                if ("top".equals(s))
                {
                    rect.top = bu1.s();
                } else
                if ("right".equals(s))
                {
                    rect.right = bu1.s();
                } else
                if ("bottom".equals(s))
                {
                    rect.bottom = bu1.s();
                } else
                {
                    bu1.t();
                }
            }
            bu1.j();
            return rect;
        }

    };

}
