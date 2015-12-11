// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.base;


// Referenced classes of package com.google.common.base:
//            CharMatcher, Preconditions

private static class heckNotNull extends CharMatcher
{

    final CharMatcher first;
    final CharMatcher second;

    public volatile boolean apply(Object obj)
    {
        return super.apply((Character)obj);
    }

    public boolean matches(char c)
    {
        return first.matches(c) || second.matches(c);
    }

    CharMatcher withToString(String s)
    {
        return new <init>(first, second, s);
    }

    (CharMatcher charmatcher, CharMatcher charmatcher1)
    {
        this(charmatcher, charmatcher1, (new StringBuilder()).append("CharMatcher.or(").append(charmatcher).append(", ").append(charmatcher1).append(")").toString());
    }

    <init>(CharMatcher charmatcher, CharMatcher charmatcher1, String s)
    {
        super(s);
        first = (CharMatcher)Preconditions.checkNotNull(charmatcher);
        second = (CharMatcher)Preconditions.checkNotNull(charmatcher1);
    }
}
