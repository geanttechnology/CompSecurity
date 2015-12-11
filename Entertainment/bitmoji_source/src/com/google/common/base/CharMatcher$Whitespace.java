// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.base;

import java.util.BitSet;

// Referenced classes of package com.google.common.base:
//            CharMatcher

static final class tcher extends tcher
{

    static final SHIFT INSTANCE = new <init>();
    static final int MULTIPLIER = 0x6449bf0a;
    static final int SHIFT = Integer.numberOfLeadingZeros("\u2002\u3000\r\205\u200A\u2005\u2000\u3000\u2029\013\u3000\u2008\u2003\u205F\u3000\u1680\t \u2006\u2001\u202F\240\f\u2009\u3000\u2004\u3000\u3000\u2028\n\u2007\u3000".length() - 1);
    static final String TABLE = "\u2002\u3000\r\205\u200A\u2005\u2000\u3000\u2029\013\u3000\u2008\u2003\u205F\u3000\u1680\t \u2006\u2001\u202F\240\f\u2009\u3000\u2004\u3000\u3000\u2028\n\u2007\u3000";

    public boolean matches(char c)
    {
        return "\u2002\u3000\r\205\u200A\u2005\u2000\u3000\u2029\013\u3000\u2008\u2003\u205F\u3000\u1680\t \u2006\u2001\u202F\240\f\u2009\u3000\u2004\u3000\u3000\u2028\n\u2007\u3000".charAt(0x6449bf0a * c >>> SHIFT) == c;
    }

    void setBits(BitSet bitset)
    {
        for (int i = 0; i < "\u2002\u3000\r\205\u200A\u2005\u2000\u3000\u2029\013\u3000\u2008\u2003\u205F\u3000\u1680\t \u2006\u2001\u202F\240\f\u2009\u3000\u2004\u3000\u3000\u2028\n\u2007\u3000".length(); i++)
        {
            bitset.set("\u2002\u3000\r\205\u200A\u2005\u2000\u3000\u2029\013\u3000\u2008\u2003\u205F\u3000\u1680\t \u2006\u2001\u202F\240\f\u2009\u3000\u2004\u3000\u3000\u2028\n\u2007\u3000".charAt(i));
        }

    }


    tcher()
    {
        super("CharMatcher.whitespace()");
    }
}
