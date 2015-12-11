// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import org.xml.sax.Attributes;

final class bed extends bnt
{

    bed()
    {
    }

    public final void a(bmz bmz1, Attributes attributes)
    {
        if ("InfoCards".equals(attributes.getValue("type")))
        {
            bmz1.offer(new bqa());
        }
    }

    public final void a(bmz bmz1, Attributes attributes, String s)
    {
        if ("InfoCards".equals(attributes.getValue("type")))
        {
            attributes = ((bqa)bmz1.b(bqa)).a();
            ((bvd)bmz1.a(bvd)).ah = attributes;
        }
    }
}
