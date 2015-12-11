// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.base;

import java.util.BitSet;

// Referenced classes of package com.google.common.base:
//            CharMatcher

private static final class match extends tcher
{

    private final char match;

    public CharMatcher and(CharMatcher charmatcher)
    {
        CharMatcher charmatcher1 = charmatcher;
        if (charmatcher.matches(match))
        {
            charmatcher1 = super.and(charmatcher);
        }
        return charmatcher1;
    }

    public boolean matches(char c)
    {
        return c != match;
    }

    public CharMatcher negate()
    {
        return is(match);
    }

    public CharMatcher or(CharMatcher charmatcher)
    {
        Object obj = this;
        if (charmatcher.matches(match))
        {
            obj = any();
        }
        return ((CharMatcher) (obj));
    }

    void setBits(BitSet bitset)
    {
        bitset.set(0, match);
        bitset.set(match + 1, 0x10000);
    }

    public String toString()
    {
        String s = CharMatcher.access$100(match);
        return (new StringBuilder(String.valueOf(s).length() + 21)).append("CharMatcher.isNot('").append(s).append("')").toString();
    }

    tcher(char c)
    {
        match = c;
    }
}
