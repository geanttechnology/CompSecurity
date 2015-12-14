// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.moreview;


public final class LayoutType
{

    public static int a(LayoutType layouttype)
    {
        class LayoutType extends Enum
        {

            public static final LayoutType a;
            public static final LayoutType b;
            public static final LayoutType c;
            public static final LayoutType d;
            public static final LayoutType e;
            public static final LayoutType f;
            public static final LayoutType g;
            public static final LayoutType h;
            public static final LayoutType i;
            private static final LayoutType j[];

            public static LayoutType valueOf(String s)
            {
                return (LayoutType)Enum.valueOf(com/cyberlink/youcammakeup/pages/moreview/DownloadGridItem$LayoutTypeInfo$LayoutType, s);
            }

            public static LayoutType[] values()
            {
                return (LayoutType[])j.clone();
            }

            static 
            {
                a = new LayoutType("LOOK_TYPE", 0);
                b = new LayoutType("EYE_SHADOW_TYPE", 1);
                c = new LayoutType("EYE_LINE_TYPE", 2);
                d = new LayoutType("EYE_LASH_TYPE", 3);
                e = new LayoutType("CATEGOTY_LOOK_TYPE", 4);
                f = new LayoutType("PROMOTION_LOOK_TYPE", 5);
                g = new LayoutType("WIG_TYPE", 6);
                h = new LayoutType("CATEGORY_ACCESSORY_TYPE", 7);
                i = new LayoutType("ACCESSORY_TYPE", 8);
                j = (new LayoutType[] {
                    a, b, c, d, e, f, g, h, i
                });
            }

            private LayoutType(String s, int k)
            {
                super(s, k);
            }
        }

        if (layouttype == LayoutType.g)
        {
            return 6;
        }
        if (layouttype == LayoutType.c || layouttype == LayoutType.d)
        {
            return 2;
        }
        if (layouttype == LayoutType.b)
        {
            return 1;
        }
        if (layouttype == LayoutType.e)
        {
            return 4;
        }
        if (layouttype == LayoutType.f)
        {
            return 5;
        }
        if (layouttype == LayoutType.h)
        {
            return 7;
        }
        return layouttype != LayoutType.i ? 0 : 8;
    }

    public static LayoutType a(int i)
    {
        if (i == 6)
        {
            return LayoutType.g;
        }
        if (i == 2)
        {
            return LayoutType.c;
        }
        if (i == 3)
        {
            return LayoutType.d;
        }
        if (i == 1)
        {
            return LayoutType.b;
        }
        if (i == 4)
        {
            return LayoutType.e;
        }
        if (i == 5)
        {
            return LayoutType.f;
        }
        if (i == 7)
        {
            return LayoutType.h;
        }
        if (i == 8)
        {
            return LayoutType.i;
        } else
        {
            return LayoutType.a;
        }
    }
}
