// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import org.xml.sax.Attributes;

final class cdd extends bnt
{

    cdd()
    {
    }

    public final void a(bmz bmz1, Attributes attributes)
    {
        ((cef)bmz1.a(cef)).C = "paygate".equals(attributes.getValue("type"));
        ((cef)bmz1.a(cef)).D = "free".equals(attributes.getValue("type"));
    }
}
