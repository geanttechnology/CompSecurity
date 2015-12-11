// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import org.xml.sax.Attributes;

final class ccf extends bnt
{

    ccf()
    {
    }

    public final void a(bmz bmz1, Attributes attributes)
    {
        bmz1.offer(new cef());
    }

    public final void a(bmz bmz1, Attributes attributes, String s)
    {
        attributes = ((cef)bmz1.b(cef)).a();
        ((cpw)bmz1.a(cpw)).a(attributes);
    }
}
