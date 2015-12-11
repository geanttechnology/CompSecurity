// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import org.xml.sax.Attributes;

final class bel extends bnt
{

    private bev a;

    bel(bev bev1)
    {
        a = bev1;
        super();
    }

    public final void a(bmz bmz1, Attributes attributes)
    {
        bmz1.offer(new beu((int)a.a(attributes.getValue("version"), 2.0F)));
    }

    public final void a(bmz bmz1, Attributes attributes, String s)
    {
        attributes = (beu)bmz1.b(beu);
        if (a != null)
        {
            a.a(bmz1, attributes.a());
        }
    }
}
