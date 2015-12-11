// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.base;


// Referenced classes of package com.google.common.base:
//            CharMatcher, Preconditions, Predicate

private static final class l extends CharMatcher
{

    private final Predicate predicate;

    public boolean apply(Character character)
    {
        return predicate.apply(Preconditions.checkNotNull(character));
    }

    public volatile boolean apply(Object obj)
    {
        return apply((Character)obj);
    }

    public boolean matches(char c)
    {
        return predicate.apply(Character.valueOf(c));
    }

    public String toString()
    {
        String s = String.valueOf(predicate);
        return (new StringBuilder(String.valueOf(s).length() + 26)).append("CharMatcher.forPredicate(").append(s).append(")").toString();
    }

    (Predicate predicate1)
    {
        predicate = (Predicate)Preconditions.checkNotNull(predicate1);
    }
}
