// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import org.xml.sax.Attributes;

public final class cxp extends bnt
{

    public cxp()
    {
    }

    public final void a(bmz bmz1, Attributes attributes, String s)
    {
        bmz1 = (cyh)bmz1.a(cyh);
        int i = a.a(Float.parseFloat(a.a(attributes, new String[] {
            "start"
        })));
        int j = a.a(a.a(a.a(attributes, new String[] {
            "dur"
        }), 5F));
        bmz1.a(0, s.replaceAll("\n", "<br/>"), i, j + i);
    }
}
