// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import android.graphics.Point;

public class D
{

    private final String A;
    private final int B;
    private final String C;
    private final String D;
    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final Position f;
    private final Point g;
    private final Point h;
    private final Point i;
    private final Point j;
    private final EyeShadowSide k;
    private final Point l;
    private final Point m;
    private final Point n;
    private final Point o;
    private final Point p;
    private final Point q;
    private final Point r;
    private final Point s;
    private final Point t;
    private final Point u;
    private final Point v;
    private final Point w;
    private final Point x;
    private final Point y;
    private final Point z;

    public static Position a(String s1)
    {
        class Position extends Enum
        {

            public static final Position a;
            public static final Position b;
            public static final Position c;
            public static final Position d;
            public static final Position e;
            private static final Position f[];

            public static Position valueOf(String s2)
            {
                return (Position)Enum.valueOf(com/cyberlink/youcammakeup/utility/PanelDataCenter$Mask$Position, s2);
            }

            public static Position[] values()
            {
                return (Position[])f.clone();
            }

            static 
            {
                a = new Position("LEFT", 0);
                b = new Position("RIGHT", 1);
                c = new Position("UPPER", 2);
                d = new Position("LOWER", 3);
                e = new Position("NONE", 4);
                f = (new Position[] {
                    a, b, c, d, e
                });
            }

            private Position(String s1, int i1)
            {
                super(s1, i1);
            }
        }

        if (s1.equalsIgnoreCase(Position.a.name()))
        {
            return Position.a;
        }
        if (s1.equalsIgnoreCase(Position.b.name()))
        {
            return Position.b;
        }
        if (s1.equalsIgnoreCase(Position.c.name()))
        {
            return Position.c;
        }
        if (s1.equalsIgnoreCase(Position.d.name()))
        {
            return Position.d;
        } else
        {
            return Position.e;
        }
    }

    public static EyeShadowSide b(String s1)
    {
        class EyeShadowSide extends Enum
        {

            public static final EyeShadowSide a;
            public static final EyeShadowSide b;
            public static final EyeShadowSide c;
            private static final EyeShadowSide d[];

            public static EyeShadowSide valueOf(String s2)
            {
                return (EyeShadowSide)Enum.valueOf(com/cyberlink/youcammakeup/utility/PanelDataCenter$Mask$EyeShadowSide, s2);
            }

            public static EyeShadowSide[] values()
            {
                return (EyeShadowSide[])d.clone();
            }

            static 
            {
                a = new EyeShadowSide("BOTH", 0);
                b = new EyeShadowSide("LEFT", 1);
                c = new EyeShadowSide("RIGHT", 2);
                d = (new EyeShadowSide[] {
                    a, b, c
                });
            }

            private EyeShadowSide(String s1, int i1)
            {
                super(s1, i1);
            }
        }

        if (s1.equalsIgnoreCase(EyeShadowSide.a.name()))
        {
            return EyeShadowSide.a;
        }
        if (s1.equalsIgnoreCase(EyeShadowSide.b.name()))
        {
            return EyeShadowSide.b;
        }
        if (s1.equalsIgnoreCase(EyeShadowSide.c.name()))
        {
            return EyeShadowSide.c;
        } else
        {
            return EyeShadowSide.a;
        }
    }

    public int A()
    {
        int i1;
        try
        {
            i1 = Integer.parseInt(A);
        }
        catch (NumberFormatException numberformatexception)
        {
            return 0;
        }
        return i1;
    }

    public int B()
    {
        return B;
    }

    public String C()
    {
        return D;
    }

    public String a()
    {
        return a;
    }

    public String b()
    {
        return b;
    }

    public String c()
    {
        return c;
    }

    public String d()
    {
        return d;
    }

    public String e()
    {
        return e;
    }

    public Position f()
    {
        return f;
    }

    public Point g()
    {
        return g;
    }

    public Point h()
    {
        return h;
    }

    public Point i()
    {
        return i;
    }

    public Point j()
    {
        return j;
    }

    public EyeShadowSide k()
    {
        return k;
    }

    public Point l()
    {
        return l;
    }

    public Point m()
    {
        return m;
    }

    public Point n()
    {
        return n;
    }

    public Point o()
    {
        return o;
    }

    public Point p()
    {
        return p;
    }

    public Point q()
    {
        return q;
    }

    public Point r()
    {
        return r;
    }

    public Point s()
    {
        return s;
    }

    public Point t()
    {
        return t;
    }

    public Point u()
    {
        return u;
    }

    public Point v()
    {
        return v;
    }

    public Point w()
    {
        return w;
    }

    public Point x()
    {
        return x;
    }

    public Point y()
    {
        return y;
    }

    public Point z()
    {
        return z;
    }

    public EyeShadowSide(EyeShadowSide eyeshadowside)
    {
        a = eyeshadowside.a;
        b = eyeshadowside.b;
        c = eyeshadowside.c;
        d = eyeshadowside.d;
        e = eyeshadowside.e;
        f = eyeshadowside.f;
        g = eyeshadowside.g;
        h = eyeshadowside.h;
        i = eyeshadowside.i;
        j = eyeshadowside.j;
        k = eyeshadowside.k;
        l = eyeshadowside.l;
        m = eyeshadowside.m;
        n = eyeshadowside.n;
        o = eyeshadowside.o;
        p = eyeshadowside.p;
        q = eyeshadowside.q;
        r = eyeshadowside.r;
        s = eyeshadowside.s;
        t = eyeshadowside.t;
        u = eyeshadowside.u;
        v = eyeshadowside.v;
        w = eyeshadowside.w;
        x = eyeshadowside.x;
        y = eyeshadowside.y;
        z = eyeshadowside.z;
        A = eyeshadowside.A;
        B = eyeshadowside.B;
        C = eyeshadowside.C;
        D = eyeshadowside.D;
    }

    public EyeShadowSide(String s1, String s2, String s3, String s4, String s5, Position position, Point point, 
            Point point1, Point point2, Point point3, EyeShadowSide eyeshadowside, Point point4, Point point5, Point point6, 
            Point point7, Point point8, Point point9, Point point10, Point point11, Point point12, Point point13, 
            Point point14, Point point15, Point point16, Point point17, Point point18, String s6, int i1, 
            String s7, String s8)
    {
        a = s1;
        b = s2;
        c = s3;
        d = s4;
        e = s5;
        f = position;
        g = point;
        h = point1;
        i = point2;
        j = point3;
        k = eyeshadowside;
        l = point4;
        m = point5;
        n = point6;
        o = point7;
        p = point8;
        q = point9;
        r = point10;
        s = point11;
        t = point12;
        u = point13;
        v = point14;
        w = point15;
        x = point16;
        y = point17;
        z = point18;
        A = s6;
        B = i1;
        C = s7;
        D = s8;
    }
}
