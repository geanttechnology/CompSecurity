// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import org.xml.sax.Attributes;

final class beg extends bnt
{

    private bmi a;

    beg(bmi bmi1)
    {
        a = bmi1;
        super();
    }

    public final void a(bmz bmz1, Attributes attributes, String s)
    {
        bmz1 = (bvd)bmz1.a(bvd);
        dla dla1 = new dla();
        dla1.c = s.trim();
        dla1.d = attributes.getValue("type");
        dla1.g = bdx.a(attributes.getValue("height"), 0);
        bmz1.ag = a.b();
        bmz1.a(dla1);
    }
}
