// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.base;


// Referenced classes of package com.google.common.base:
//            CharMatcher

static final class tMatcher extends tMatcher
{

    public boolean matches(char c)
    {
        return "\t\u3000\n\t\t\t\u202F\t\t\u2001\u2006\t\t\t\t\t\u180E\t\u2029\t\t\t\u2000\u2005\u200A\t\t\t\r\t\t\u2028\u1680\t\240\t\u2004\u2009\t\t\t\f\u205F\t\t \t\t\u2003\u2008\t\t\t\013\205\t\t\t\t\t\t\u2002\u2007\t".charAt(0xcdaacadf * c >>> 26) == c;
    }

    tMatcher(String s)
    {
        super(s);
    }
}
