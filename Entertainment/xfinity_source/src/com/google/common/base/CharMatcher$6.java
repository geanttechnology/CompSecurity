// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.base;


// Referenced classes of package com.google.common.base:
//            CharMatcher, Preconditions

static final class  extends CharMatcher
{

    public volatile boolean apply(Object obj)
    {
        return super.apply((Character)obj);
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

    public CharMatcher or(CharMatcher charmatcher)
    {
        Preconditions.checkNotNull(charmatcher);
        return this;
    }

    public CharMatcher precomputed()
    {
        return this;
    }

    ()
    {
    }
}
