// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.Serializable;

final class eme
    implements Serializable
{

    private static final long serialVersionUID = 0L;
    private final String a;
    private final int b;
    private final String c;

    eme(String s, int i, String s1)
    {
        a = s;
        b = i;
        c = s1;
    }

    private Object readResolve()
    {
        return new emc(a, b, c);
    }
}
