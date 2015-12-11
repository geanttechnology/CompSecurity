// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import org.xml.sax.Attributes;

final class ccg extends bnt
{

    ccg()
    {
    }

    public final void a(bmz bmz1, Attributes attributes, String s)
    {
        attributes = bnh.a(s);
        bmz1 = (cef)bmz1.a(cef);
        bmz1.r = attributes;
        if (((cef) (bmz1)).q == null)
        {
            bmz1.q = attributes;
        }
    }
}
