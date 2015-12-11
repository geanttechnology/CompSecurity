// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import org.xml.sax.Attributes;

final class bzf extends bnt
{

    bzf(byw byw)
    {
    }

    public final void a(bmz bmz1, Attributes attributes)
    {
        if ("http://gdata.youtube.com/schemas/2007#video".equals(attributes.getValue("rel")))
        {
            bmz1.offer(new cef());
        }
    }

    public final void a(bmz bmz1, Attributes attributes, String s)
    {
        if ("http://gdata.youtube.com/schemas/2007#video".equals(attributes.getValue("rel")))
        {
            attributes = ((cef)bmz1.b(cef)).a();
            ((cdo)bmz1.a(cdo)).e = attributes;
        }
    }
}
