// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import org.xml.sax.Attributes;

final class ccm extends bnt
{

    ccm()
    {
    }

    public final void a(bmz bmz1, Attributes attributes)
    {
        bmz1 = (cef)bmz1.a(cef);
        bmz1.m = a.a(attributes.getValue("numLikes"), 0L);
        bmz1.n = a.a(attributes.getValue("numDislikes"), 0L);
    }
}
