// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.base;

import java.util.BitSet;

// Referenced classes of package com.google.common.base:
//            CharMatcher

private static final class match2 extends er
{

    private final char match1;
    private final char match2;

    public boolean matches(char c)
    {
        return c == match1 || c == match2;
    }

    void setBits(BitSet bitset)
    {
        bitset.set(match1);
        bitset.set(match2);
    }

    public String toString()
    {
        String s = CharMatcher.access$100(match1);
        String s1 = CharMatcher.access$100(match2);
        return (new StringBuilder(String.valueOf(s).length() + 21 + String.valueOf(s1).length())).append("CharMatcher.anyOf(\"").append(s).append(s1).append("\")").toString();
    }

    er(char c, char c1)
    {
        match1 = c;
        match2 = c1;
    }
}
