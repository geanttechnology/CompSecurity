// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import org.xml.sax.Attributes;

public final class bfa extends bnt
{

    public bfa()
    {
    }

    public final void a(bmz bmz1, Attributes attributes)
    {
        bmz1 = (bfy)bmz1.a(bfy);
        String s = attributes.getValue("headers");
        attributes = attributes.getValue("match");
        if (s != null && attributes != null)
        {
            bmz1.a(new bfu(attributes, s.contains("device"), s.contains("user")));
        }
    }
}
