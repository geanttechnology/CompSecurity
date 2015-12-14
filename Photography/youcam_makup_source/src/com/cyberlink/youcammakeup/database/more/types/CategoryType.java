// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more.types;

import com.cyberlink.youcammakeup.utility.BeautyMode;

public final class CategoryType extends Enum
{

    public static final CategoryType a;
    public static final CategoryType b;
    public static final CategoryType c;
    public static final CategoryType d;
    public static final CategoryType e;
    public static final CategoryType f;
    public static final CategoryType g;
    public static final CategoryType h;
    public static final CategoryType i;
    public static final CategoryType j;
    public static final CategoryType k;
    public static final CategoryType l;
    public static final CategoryType m;
    public static final CategoryType n;
    public static final CategoryType o;
    private static final CategoryType p[];

    private CategoryType(String s, int i1)
    {
        super(s, i1);
    }

    public static final long a(CategoryType categorytype)
    {
        if (categorytype == o)
        {
            return 0x15ab32L;
        }
        if (categorytype == b)
        {
            return 0x15ab1bL;
        }
        if (categorytype == c)
        {
            return 0x15ab1cL;
        }
        if (categorytype == d)
        {
            return 0x15ab16L;
        }
        if (categorytype == e)
        {
            return 0x15ab18L;
        }
        if (categorytype == f)
        {
            return 0x15ab19L;
        }
        if (categorytype == i)
        {
            return 0x15ab38L;
        }
        if (categorytype == j)
        {
            return 0x15ab3aL;
        }
        if (categorytype == k)
        {
            return 0x15ab3bL;
        }
        if (categorytype == l)
        {
            return 0x15ab39L;
        }
        return categorytype != m ? 0L : 0x15ab37L;
    }

    public static final long a(BeautyMode beautymode)
    {
        class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[BeautyMode.values().length];
                try
                {
                    a[BeautyMode.n.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    a[BeautyMode.l.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    a[BeautyMode.m.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    a[BeautyMode.x.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    a[BeautyMode.z.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[BeautyMode.A.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[BeautyMode.B.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[BeautyMode.C.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1.a[beautymode.ordinal()])
        {
        default:
            return 0L;

        case 1: // '\001'
            return 0x15ab16L;

        case 2: // '\002'
            return 0x15ab18L;

        case 3: // '\003'
            return 0x15ab19L;

        case 4: // '\004'
            return 0x15ab32L;

        case 5: // '\005'
            return 0x15ab38L;

        case 6: // '\006'
            return 0x15ab3aL;

        case 7: // '\007'
            return 0x15ab3bL;

        case 8: // '\b'
            return 0x15ab39L;
        }
    }

    public static final CategoryType a(long l1)
    {
        if (l1 == 0x15ab32L)
        {
            return o;
        }
        if (l1 == 0x15ab1bL)
        {
            return b;
        }
        if (l1 == 0x15ab1cL)
        {
            return c;
        }
        if (l1 == 0x15ab16L)
        {
            return d;
        }
        if (l1 == 0x15ab18L)
        {
            return e;
        }
        if (l1 == 0x15ab19L)
        {
            return f;
        }
        if (l1 == 0x15ab38L)
        {
            return i;
        }
        if (l1 == 0x15ab3aL)
        {
            return j;
        }
        if (l1 == 0x15ab3bL)
        {
            return k;
        }
        if (l1 == 0x15ab39L)
        {
            return l;
        }
        if (l1 == 0x15ab37L)
        {
            return m;
        } else
        {
            return b;
        }
    }

    public static CategoryType valueOf(String s)
    {
        return (CategoryType)Enum.valueOf(com/cyberlink/youcammakeup/database/more/types/CategoryType, s);
    }

    public static CategoryType[] values()
    {
        return (CategoryType[])p.clone();
    }

    static 
    {
        a = new CategoryType("LOOKS", 0);
        b = new CategoryType("NATURAL_LOOKS", 1);
        c = new CategoryType("COSTUME_LOOKS", 2);
        d = new CategoryType("EYE_SHADOWS", 3);
        e = new CategoryType("EYE_LINES", 4);
        f = new CategoryType("EYE_LASHES", 5);
        g = new CategoryType("DOUBLE_EYELID", 6);
        h = new CategoryType("COLLAGES", 7);
        i = new CategoryType("EYE_WEAR", 8);
        j = new CategoryType("HAIR_BAND", 9);
        k = new CategoryType("NECKLACE", 10);
        l = new CategoryType("EARRINGS", 11);
        m = new CategoryType("ACCESSORY", 12);
        n = new CategoryType("EFFECTS", 13);
        o = new CategoryType("WIGS", 14);
        p = (new CategoryType[] {
            a, b, c, d, e, f, g, h, i, j, 
            k, l, m, n, o
        });
    }
}
