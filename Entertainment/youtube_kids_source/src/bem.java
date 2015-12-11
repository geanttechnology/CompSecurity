// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import org.xml.sax.Attributes;

final class bem extends bnt
{

    private bmi a;

    bem(bmi bmi1)
    {
        a = bmi1;
        super();
    }

    public final void a(bmz bmz1, Attributes attributes, String s)
    {
        bmz1 = (bvd)bmz1.a(bvd);
        int i = a.o(s.trim());
        bmz1.S = a.a() + (long)i;
    }
}
