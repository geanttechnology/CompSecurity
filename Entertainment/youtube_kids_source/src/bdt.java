// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.List;
import org.xml.sax.Attributes;

final class bdt extends bnt
{

    bdt()
    {
    }

    public final void a(bmz bmz1, Attributes attributes, String s)
    {
        bmz1 = (buv)bmz1.a(buv);
        attributes = bdp.b(s);
        if (((buv) (bmz1)).a.j.length < 0)
        {
            ((buv) (bmz1)).a.j = new int[0];
        }
        ((buv) (bmz1)).b.add(attributes);
    }
}
