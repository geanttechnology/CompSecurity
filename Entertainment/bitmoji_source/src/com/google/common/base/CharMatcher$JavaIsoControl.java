// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.base;


// Referenced classes of package com.google.common.base:
//            CharMatcher

private static final class r extends r
{

    static final r INSTANCE = new <init>();

    public boolean matches(char c)
    {
        return c <= '\037' || c >= '\177' && c <= '\237';
    }


    private r()
    {
        super("CharMatcher.javaIsoControl()");
    }
}
