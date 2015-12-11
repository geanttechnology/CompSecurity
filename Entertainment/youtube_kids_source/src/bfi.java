// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Random;

public final class bfi
{

    private final String a;
    private final bmi b;
    private final bde c;
    private final crh d;

    public bfi(String s, bmi bmi1, bde bde1, crh crh1)
    {
        a = (String)b.a(s);
        b = (bmi)b.a(bmi1);
        c = (bde)b.a(bde1);
        d = (crh)b.a(crh1);
        bde1.a();
    }

    public final bfh a()
    {
        bfh bfh1 = new bfh(a, new Random(b.a()), c);
        d.a(bfh1);
        return bfh1;
    }
}
