// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.common;

import com.ebay.nautilus.domain.data.NameValue;

// Referenced classes of package com.ebay.mobile.common:
//            ItemPrice

public final class HashCodeUtil
{

    public static final int SEED = 47;
    private static final int fODD_PRIME_NUMBER = 37;

    public HashCodeUtil()
    {
    }

    private static int firstTerm(int i)
    {
        return i * 37;
    }

    public static int hash(int i, char c)
    {
        return firstTerm(i) + c;
    }

    public static int hash(int i, double d)
    {
        return hash(i, Double.doubleToLongBits(d));
    }

    public static int hash(int i, float f)
    {
        return hash(i, Float.floatToIntBits(f));
    }

    public static int hash(int i, int j)
    {
        return firstTerm(i) + j;
    }

    public static int hash(int i, long l)
    {
        return firstTerm(i) + (int)(l >>> 32 ^ l);
    }

    public static int hash(int i, ItemPrice itemprice)
    {
        if (itemprice == null)
        {
            return hash(i, 0);
        } else
        {
            return itemprice.hashCode();
        }
    }

    public static int hash(int i, NameValue namevalue)
    {
        if (namevalue == null)
        {
            return hash(i, 0);
        } else
        {
            return namevalue.hashCode();
        }
    }

    public static int hash(int i, String s)
    {
        if (s == null)
        {
            return hash(i, 0);
        } else
        {
            return s.hashCode();
        }
    }

    public static int hash(int i, boolean flag)
    {
        int j = firstTerm(i);
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        return i + j;
    }
}
