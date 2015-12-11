// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.product;

import android.util.SparseArray;

public final class f extends Enum
{

    private static final f $VALUES[];
    public static final f CLEARANCE;
    public static final f PRICE_CUT;
    public static final f SALE;
    public static final f TEMPORARY_PRICE_CUT;
    public static final f UNKNOWN;
    private static final SparseArray mIntToEnumType;
    private final int mValue;

    private f(String s, int i, int j)
    {
        super(s, i);
        mValue = j;
    }

    public static f a(int i)
    {
        f f2 = (f)mIntToEnumType.get(i);
        f f1 = f2;
        if (f2 == null)
        {
            f1 = UNKNOWN;
        }
        return f1;
    }

    public static f valueOf(String s)
    {
        return (f)Enum.valueOf(com/target/mothership/common/product/f, s);
    }

    public static f[] values()
    {
        return (f[])$VALUES.clone();
    }

    public int a()
    {
        return mValue;
    }

    static 
    {
        int i = 0;
        SALE = new f("SALE", 0, 1);
        TEMPORARY_PRICE_CUT = new f("TEMPORARY_PRICE_CUT", 1, 2);
        CLEARANCE = new f("CLEARANCE", 2, 3);
        PRICE_CUT = new f("PRICE_CUT", 3, 4);
        UNKNOWN = new f("UNKNOWN", 4, -1);
        $VALUES = (new f[] {
            SALE, TEMPORARY_PRICE_CUT, CLEARANCE, PRICE_CUT, UNKNOWN
        });
        mIntToEnumType = new SparseArray();
        f af[] = values();
        for (int j = af.length; i < j; i++)
        {
            f f1 = af[i];
            mIntToEnumType.put(f1.a(), f1);
        }

    }
}
