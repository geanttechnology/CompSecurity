// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import org.xml.sax.Attributes;

final class bpz extends bnt
{

    bpz()
    {
    }

    public final void a(bmz bmz1, Attributes attributes)
    {
        bmz1.offer(new bvl(bpq.a(attributes.getValue("type"), bpq.c(), 0)));
    }

    public final void a(bmz bmz1, Attributes attributes, String s)
    {
        attributes = ((bvl)bmz1.b(bvl)).a();
        ((bqa)bmz1.a(bqa)).a(attributes);
    }
}
