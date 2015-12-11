// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.base;

import java.util.BitSet;

// Referenced classes of package com.google.common.base:
//            CharMatcher, Preconditions

private static final class endInclusive extends her
{

    private final char endInclusive;
    private final char startInclusive;

    public boolean matches(char c)
    {
        return startInclusive <= c && c <= endInclusive;
    }

    void setBits(BitSet bitset)
    {
        bitset.set(startInclusive, endInclusive + 1);
    }

    public String toString()
    {
        String s = CharMatcher.access$100(startInclusive);
        String s1 = CharMatcher.access$100(endInclusive);
        return (new StringBuilder(String.valueOf(s).length() + 27 + String.valueOf(s1).length())).append("CharMatcher.inRange('").append(s).append("', '").append(s1).append("')").toString();
    }

    her(char c, char c1)
    {
        boolean flag;
        if (c1 >= c)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag);
        startInclusive = c;
        endInclusive = c1;
    }
}
