// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.base;

import java.util.Arrays;
import java.util.BitSet;

// Referenced classes of package com.google.common.base:
//            CharMatcher

private static final class chars extends CharMatcher
{

    private final char chars[];

    public volatile boolean apply(Object obj)
    {
        return super.apply((Character)obj);
    }

    public boolean matches(char c)
    {
        return Arrays.binarySearch(chars, c) >= 0;
    }

    void setBits(BitSet bitset)
    {
        char ac[] = chars;
        int j = ac.length;
        for (int i = 0; i < j; i++)
        {
            bitset.set(ac[i]);
        }

    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("CharMatcher.anyOf(\"");
        char ac[] = chars;
        int j = ac.length;
        for (int i = 0; i < j; i++)
        {
            stringbuilder.append(CharMatcher.access$100(ac[i]));
        }

        stringbuilder.append("\")");
        return stringbuilder.toString();
    }

    public (CharSequence charsequence)
    {
        chars = charsequence.toString().toCharArray();
        Arrays.sort(chars);
    }
}
