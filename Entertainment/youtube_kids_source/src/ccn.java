// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import org.xml.sax.Attributes;

final class ccn extends bnt
{

    ccn()
    {
    }

    public final void a(bmz bmz1, Attributes attributes)
    {
        bmz1 = (cef)bmz1.a(cef);
        if ("http://gdata.youtube.com/schemas/2007/categories.cat".equals(attributes.getValue("scheme")))
        {
            bmz1.t = attributes.getValue("label");
            bmz1.s = attributes.getValue("term");
        }
    }
}
