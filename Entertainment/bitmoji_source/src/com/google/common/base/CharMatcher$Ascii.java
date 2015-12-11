// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.base;


// Referenced classes of package com.google.common.base:
//            CharMatcher

private static final class astMatcher extends astMatcher
{

    static final astMatcher INSTANCE = new <init>();

    public boolean matches(char c)
    {
        return c <= '\177';
    }


    astMatcher()
    {
        super("CharMatcher.ascii()");
    }
}
