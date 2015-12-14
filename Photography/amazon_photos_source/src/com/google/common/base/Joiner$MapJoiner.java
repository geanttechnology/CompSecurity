// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.base;


// Referenced classes of package com.google.common.base:
//            Joiner, Preconditions

public static final class <init>
{

    private final Joiner joiner;
    private final String keyValueSeparator;

    private (Joiner joiner1, String s)
    {
        joiner = joiner1;
        keyValueSeparator = (String)Preconditions.checkNotNull(s);
    }

    ckNotNull(Joiner joiner1, String s, ckNotNull cknotnull)
    {
        this(joiner1, s);
    }
}
