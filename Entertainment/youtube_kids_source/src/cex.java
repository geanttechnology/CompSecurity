// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.List;

final class cex
{

    static int a = 30000;
    final List b;
    final cgl c;
    final cgo d;
    final long e = System.currentTimeMillis();

    public cex(cgl cgl, cgo cgo1, List list)
    {
        c = cgl;
        d = cgo1;
        b = list;
    }

    public final String toString()
    {
        String s = String.valueOf(c);
        String s1 = String.valueOf(d.toString());
        return (new StringBuilder(String.valueOf(s).length() + 2 + String.valueOf(s1).length())).append(s).append("(").append(s1).append(")").toString();
    }

}
