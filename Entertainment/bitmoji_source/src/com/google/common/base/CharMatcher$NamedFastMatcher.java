// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.base;


// Referenced classes of package com.google.common.base:
//            CharMatcher, Preconditions

static abstract class description extends description
{

    private final String description;

    public final String toString()
    {
        return description;
    }

    _cls9(String s)
    {
        description = (String)Preconditions.checkNotNull(s);
    }
}
