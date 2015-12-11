// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.base;

import java.util.BitSet;

// Referenced classes of package com.google.common.base:
//            CharMatcher, Preconditions

private static final class eckNotNull extends CharMatcher
{

    final CharMatcher first;
    final CharMatcher second;

    public volatile boolean apply(Object obj)
    {
        return super.apply((Character)obj);
    }

    public boolean matches(char c)
    {
        return first.matches(c) && second.matches(c);
    }

    void setBits(BitSet bitset)
    {
        BitSet bitset1 = new BitSet();
        first.setBits(bitset1);
        BitSet bitset2 = new BitSet();
        second.setBits(bitset2);
        bitset1.and(bitset2);
        bitset.or(bitset1);
    }

    public String toString()
    {
        String s = String.valueOf(first);
        String s1 = String.valueOf(second);
        return (new StringBuilder(String.valueOf(s).length() + 19 + String.valueOf(s1).length())).append("CharMatcher.and(").append(s).append(", ").append(s1).append(")").toString();
    }

    (CharMatcher charmatcher, CharMatcher charmatcher1)
    {
        first = (CharMatcher)Preconditions.checkNotNull(charmatcher);
        second = (CharMatcher)Preconditions.checkNotNull(charmatcher1);
    }
}
