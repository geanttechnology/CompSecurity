// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.base;


// Referenced classes of package com.google.common.base:
//            CharMatcher, Preconditions

static final class okupTable extends CharMatcher
{

    public volatile boolean apply(Object obj)
    {
        return super.apply((Character)obj);
    }

    public int indexIn(CharSequence charsequence, int i)
    {
        Preconditions.checkPositionIndex(i, charsequence.length());
        return -1;
    }

    public boolean matches(char c)
    {
        return false;
    }

    public CharMatcher or(CharMatcher charmatcher)
    {
        return (CharMatcher)Preconditions.checkNotNull(charmatcher);
    }

    public CharMatcher precomputed()
    {
        return this;
    }

    void setBits(okupTable okuptable)
    {
    }

    okupTable()
    {
    }
}
