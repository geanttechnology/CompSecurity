// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Set;

final class chb
    implements Runnable
{

    private Set a;
    private Set b;
    private cha c;

    chb(cha cha1, Set set, Set set1)
    {
        c = cha1;
        a = set;
        b = set1;
        super();
    }

    public final void run()
    {
        cha.a(c, a, b);
    }
}
