// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.base;


// Referenced classes of package com.google.common.base:
//            Optional

final class Absent extends Optional
{

    static final Absent INSTANCE = new Absent();

    private Absent()
    {
    }

    static Optional withType()
    {
        return INSTANCE;
    }

    public boolean equals(Object obj)
    {
        return obj == this;
    }

    public Object get()
    {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    public int hashCode()
    {
        return 0x598df91c;
    }

    public boolean isPresent()
    {
        return false;
    }

    public String toString()
    {
        return "Optional.absent()";
    }

}
