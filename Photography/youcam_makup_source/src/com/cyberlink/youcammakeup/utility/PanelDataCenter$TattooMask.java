// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import android.graphics.Point;

public class q
{

    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final TattooPosition e;
    private final Point f;
    private final Point g;
    private final Point h;
    private final Point i;
    private final TattooEyeShadowSide j;
    private final Point k;
    private final Point l;
    private final Point m;
    private final int n;
    private final TattooEyeShadowSide o;
    private final TattooBlendMode p;
    private final int q;

    public static int a(TattooBlendMode tattooblendmode)
    {
        class TattooBlendMode extends Enum
        {

            public static final TattooBlendMode a;
            public static final TattooBlendMode b;
            public static final TattooBlendMode c;
            public static final TattooBlendMode d;
            public static final TattooBlendMode e;
            public static final TattooBlendMode f;
            private static final TattooBlendMode g[];

            public static TattooBlendMode valueOf(String s)
            {
                return (TattooBlendMode)Enum.valueOf(com/cyberlink/youcammakeup/utility/PanelDataCenter$TattooMask$TattooBlendMode, s);
            }

            public static TattooBlendMode[] values()
            {
                return (TattooBlendMode[])g.clone();
            }

            static 
            {
                a = new TattooBlendMode("NORMAL_ON_SKIN", 0);
                b = new TattooBlendMode("NORMAL", 1);
                c = new TattooBlendMode("MULTIPLY_ON_SKIN", 2);
                d = new TattooBlendMode("MULTIPLY", 3);
                e = new TattooBlendMode("NATURE_ON_SKIN", 4);
                f = new TattooBlendMode("NATURE", 5);
                g = (new TattooBlendMode[] {
                    a, b, c, d, e, f
                });
            }

            private TattooBlendMode(String s, int i1)
            {
                super(s, i1);
            }
        }

        if (tattooblendmode != TattooBlendMode.a)
        {
            if (tattooblendmode == TattooBlendMode.b)
            {
                return 1;
            }
            if (tattooblendmode == TattooBlendMode.c)
            {
                return 2;
            }
            if (tattooblendmode == TattooBlendMode.d)
            {
                return 3;
            }
            if (tattooblendmode == TattooBlendMode.e)
            {
                return 4;
            }
            if (tattooblendmode == TattooBlendMode.f)
            {
                return 5;
            }
        }
        return 0;
    }

    public static TattooPosition a(String s)
    {
        class TattooPosition extends Enum
        {

            public static final TattooPosition a;
            public static final TattooPosition b;
            public static final TattooPosition c;
            public static final TattooPosition d;
            public static final TattooPosition e;
            private static final TattooPosition f[];

            public static TattooPosition valueOf(String s1)
            {
                return (TattooPosition)Enum.valueOf(com/cyberlink/youcammakeup/utility/PanelDataCenter$TattooMask$TattooPosition, s1);
            }

            public static TattooPosition[] values()
            {
                return (TattooPosition[])f.clone();
            }

            static 
            {
                a = new TattooPosition("LEFT", 0);
                b = new TattooPosition("RIGHT", 1);
                c = new TattooPosition("UPPER", 2);
                d = new TattooPosition("LOWER", 3);
                e = new TattooPosition("NONE", 4);
                f = (new TattooPosition[] {
                    a, b, c, d, e
                });
            }

            private TattooPosition(String s, int i1)
            {
                super(s, i1);
            }
        }

        if (s.equalsIgnoreCase(TattooPosition.a.name()))
        {
            return TattooPosition.a;
        }
        if (s.equalsIgnoreCase(TattooPosition.b.name()))
        {
            return TattooPosition.b;
        }
        if (s.equalsIgnoreCase(TattooPosition.c.name()))
        {
            return TattooPosition.c;
        }
        if (s.equalsIgnoreCase(TattooPosition.d.name()))
        {
            return TattooPosition.d;
        } else
        {
            return TattooPosition.e;
        }
    }

    public static TattooEyeShadowSide b(String s)
    {
        class TattooEyeShadowSide extends Enum
        {

            public static final TattooEyeShadowSide a;
            public static final TattooEyeShadowSide b;
            public static final TattooEyeShadowSide c;
            private static final TattooEyeShadowSide d[];

            public static TattooEyeShadowSide valueOf(String s1)
            {
                return (TattooEyeShadowSide)Enum.valueOf(com/cyberlink/youcammakeup/utility/PanelDataCenter$TattooMask$TattooEyeShadowSide, s1);
            }

            public static TattooEyeShadowSide[] values()
            {
                return (TattooEyeShadowSide[])d.clone();
            }

            static 
            {
                a = new TattooEyeShadowSide("BOTH", 0);
                b = new TattooEyeShadowSide("LEFT", 1);
                c = new TattooEyeShadowSide("RIGHT", 2);
                d = (new TattooEyeShadowSide[] {
                    a, b, c
                });
            }

            private TattooEyeShadowSide(String s, int i1)
            {
                super(s, i1);
            }
        }

        if (s.equalsIgnoreCase(TattooEyeShadowSide.a.name()))
        {
            return TattooEyeShadowSide.a;
        }
        if (s.equalsIgnoreCase(TattooEyeShadowSide.b.name()))
        {
            return TattooEyeShadowSide.b;
        }
        if (s.equalsIgnoreCase(TattooEyeShadowSide.c.name()))
        {
            return TattooEyeShadowSide.c;
        } else
        {
            return TattooEyeShadowSide.a;
        }
    }

    public static TattooBlendMode c(String s)
    {
        if (s.equalsIgnoreCase(TattooBlendMode.a.name()))
        {
            return TattooBlendMode.a;
        }
        if (s.equalsIgnoreCase(TattooBlendMode.b.name()))
        {
            return TattooBlendMode.b;
        }
        if (s.equalsIgnoreCase(TattooBlendMode.c.name()))
        {
            return TattooBlendMode.c;
        }
        if (s.equalsIgnoreCase(TattooBlendMode.d.name()))
        {
            return TattooBlendMode.d;
        }
        if (s.equalsIgnoreCase(TattooBlendMode.e.name()))
        {
            return TattooBlendMode.e;
        }
        if (s.equalsIgnoreCase(TattooBlendMode.f.name()))
        {
            return TattooBlendMode.f;
        } else
        {
            return TattooBlendMode.a;
        }
    }

    public String a()
    {
        return b;
    }

    public TattooPosition b()
    {
        return e;
    }

    public Point c()
    {
        return f;
    }

    public Point d()
    {
        return g;
    }

    public Point e()
    {
        return h;
    }

    public Point f()
    {
        return i;
    }

    public Point g()
    {
        return k;
    }

    public Point h()
    {
        return l;
    }

    public Point i()
    {
        return m;
    }

    public TattooEyeShadowSide j()
    {
        return o;
    }

    public TattooBlendMode k()
    {
        return p;
    }

    public int l()
    {
        return q;
    }

    public TattooBlendMode(String s, String s1, String s2, String s3, TattooPosition tattooposition, Point point, Point point1, 
            Point point2, Point point3, TattooEyeShadowSide tattooeyeshadowside, Point point4, Point point5, Point point6, int i1, 
            TattooEyeShadowSide tattooeyeshadowside1, TattooBlendMode tattooblendmode, int j1)
    {
        a = s;
        b = s1;
        c = s2;
        d = s3;
        e = tattooposition;
        f = point;
        g = point1;
        h = point2;
        i = point3;
        j = tattooeyeshadowside;
        k = point4;
        l = point5;
        m = point6;
        n = i1;
        o = tattooeyeshadowside1;
        p = tattooblendmode;
        q = j1;
    }
}
