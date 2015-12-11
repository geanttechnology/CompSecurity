// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.Serializable;

final class emf extends elw
    implements Serializable
{

    private static final long serialVersionUID = 0L;
    private final int a;

    emf(int i)
    {
        a = i;
    }

    public final elx a()
    {
        return new emg(a);
    }

    public final String toString()
    {
        return (new StringBuilder("Hashing.murmur3_128(")).append(a).append(")").toString();
    }
}
