// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.base;


// Referenced classes of package com.google.common.base:
//            Objects, Preconditions

public static final class <init>
{

    private final StringBuilder builder;
    private boolean needsSeparator;

    private StringBuilder checkNameAndAppend(String s)
    {
        Preconditions.checkNotNull(s);
        return maybeAppendSeparator().append(s).append('=');
    }

    private StringBuilder maybeAppendSeparator()
    {
        if (needsSeparator)
        {
            return builder.append(", ");
        } else
        {
            needsSeparator = true;
            return builder;
        }
    }

    public builder add(String s, int i)
    {
        checkNameAndAppend(s).append(i);
        return this;
    }

    public checkNameAndAppend add(String s, long l)
    {
        checkNameAndAppend(s).append(l);
        return this;
    }

    public checkNameAndAppend add(String s, Object obj)
    {
        checkNameAndAppend(s).append(obj);
        return this;
    }

    public checkNameAndAppend addValue(Object obj)
    {
        maybeAppendSeparator().append(obj);
        return this;
    }

    public String toString()
    {
        String s = builder.append('}').toString();
        builder.setLength(builder.length() - 1);
        return s;
        Exception exception;
        exception;
        builder.setLength(builder.length() - 1);
        throw exception;
    }

    private (String s)
    {
        needsSeparator = false;
        Preconditions.checkNotNull(s);
        builder = (new StringBuilder(32)).append(s).append('{');
    }

    builder(String s, builder builder1)
    {
        this(s);
    }
}
