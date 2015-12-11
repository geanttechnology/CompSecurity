// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import org.xml.sax.Attributes;

public final class cac extends bnt
{

    public cac()
    {
    }

    public final void a(bmz bmz1, Attributes attributes, String s)
    {
        bmz1 = (cds)bmz1.a(cds);
        bmz1.a = bnh.a(attributes.getValue("start"));
        attributes = attributes.getValue("end");
        if (attributes != null)
        {
            bmz1.b = bnh.a(attributes);
        }
    }
}
