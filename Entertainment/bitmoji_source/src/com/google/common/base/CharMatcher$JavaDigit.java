// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.base;


// Referenced classes of package com.google.common.base:
//            CharMatcher

private static final class  extends CharMatcher
{

    static final  INSTANCE = new <init>();

    public volatile boolean apply(Object obj)
    {
        return super.apply((Character)obj);
    }

    public boolean matches(char c)
    {
        return Character.isDigit(c);
    }

    public String toString()
    {
        return "CharMatcher.javaDigit()";
    }


    private ()
    {
    }
}
