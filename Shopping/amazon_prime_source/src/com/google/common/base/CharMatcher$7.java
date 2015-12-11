// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.base;

import java.util.Arrays;

// Referenced classes of package com.google.common.base:
//            CharMatcher, Preconditions

static final class stMatcher extends stMatcher
{

    public CharMatcher and(CharMatcher charmatcher)
    {
        return (CharMatcher)Preconditions.checkNotNull(charmatcher);
    }

    public int indexIn(CharSequence charsequence)
    {
        return charsequence.length() != 0 ? 0 : -1;
    }

    public int indexIn(CharSequence charsequence, int i)
    {
        int k = charsequence.length();
        Preconditions.checkPositionIndex(i, k);
        int j = i;
        if (i == k)
        {
            j = -1;
        }
        return j;
    }

    public boolean matches(char c)
    {
        return true;
    }

    public boolean matchesAllOf(CharSequence charsequence)
    {
        Preconditions.checkNotNull(charsequence);
        return true;
    }

    public boolean matchesNoneOf(CharSequence charsequence)
    {
        return charsequence.length() == 0;
    }

    public CharMatcher negate()
    {
        return NONE;
    }

    public CharMatcher or(CharMatcher charmatcher)
    {
        Preconditions.checkNotNull(charmatcher);
        return this;
    }

    public String removeFrom(CharSequence charsequence)
    {
        Preconditions.checkNotNull(charsequence);
        return "";
    }

    public String replaceFrom(CharSequence charsequence, char c)
    {
        charsequence = new char[charsequence.length()];
        Arrays.fill(charsequence, c);
        return new String(charsequence);
    }

    stMatcher(String s)
    {
        super(s);
    }
}
