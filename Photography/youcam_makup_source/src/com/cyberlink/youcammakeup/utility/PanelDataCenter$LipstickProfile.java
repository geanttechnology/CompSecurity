// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;


public class a
{

    private final LipstickType a;

    public static LipstickType a(String s)
    {
        class LipstickType extends Enum
        {

            public static final LipstickType a;
            public static final LipstickType b;
            public static final LipstickType c;
            public static final LipstickType d;
            public static final LipstickType e;
            private static final LipstickType f[];

            public static LipstickType valueOf(String s1)
            {
                return (LipstickType)Enum.valueOf(com/cyberlink/youcammakeup/utility/PanelDataCenter$LipstickProfile$LipstickType, s1);
            }

            public static LipstickType[] values()
            {
                return (LipstickType[])f.clone();
            }

            static 
            {
                a = new LipstickType("BRIGHT", 0);
                b = new LipstickType("THICK", 1);
                c = new LipstickType("GLOSS", 2);
                d = new LipstickType("CHERRY", 3);
                e = new LipstickType("NONE", 4);
                f = (new LipstickType[] {
                    a, b, c, d, e
                });
            }

            private LipstickType(String s, int i)
            {
                super(s, i);
            }
        }

        if (LipstickType.a.name().equalsIgnoreCase(s))
        {
            return LipstickType.a;
        }
        if (LipstickType.b.name().equalsIgnoreCase(s))
        {
            return LipstickType.b;
        }
        if (LipstickType.c.name().equalsIgnoreCase(s))
        {
            return LipstickType.c;
        }
        if (LipstickType.d.name().equalsIgnoreCase(s))
        {
            return LipstickType.d;
        } else
        {
            return LipstickType.e;
        }
    }

    public static LipstickType.e a()
    {
        return new <init>(LipstickType.e);
    }

    public LipstickType b()
    {
        return a;
    }

    public String toString()
    {
        return (new StringBuilder()).append("type: ").append(a.name()).toString();
    }

    public LipstickType(LipstickType lipsticktype)
    {
        a = lipsticktype;
    }
}
