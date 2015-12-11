// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.base;

import java.util.BitSet;

// Referenced classes of package com.google.common.base:
//            CharMatcher

private static final class match extends tMatcher
{

    private final char match;

    public CharMatcher and(CharMatcher charmatcher)
    {
        if (charmatcher.matches(match))
        {
            return this;
        } else
        {
            return none();
        }
    }

    public boolean matches(char c)
    {
        return c == match;
    }

    public CharMatcher negate()
    {
        return isNot(match);
    }

    public CharMatcher or(CharMatcher charmatcher)
    {
        if (charmatcher.matches(match))
        {
            return charmatcher;
        } else
        {
            return super.or(charmatcher);
        }
    }

    public String replaceFrom(CharSequence charsequence, char c)
    {
        return charsequence.toString().replace(match, c);
    }

    void setBits(BitSet bitset)
    {
        bitset.set(match);
    }

    public String toString()
    {
        String s = CharMatcher.access$100(match);
        return (new StringBuilder(String.valueOf(s).length() + 18)).append("CharMatcher.is('").append(s).append("')").toString();
    }

    tMatcher(char c)
    {
        match = c;
    }
}
