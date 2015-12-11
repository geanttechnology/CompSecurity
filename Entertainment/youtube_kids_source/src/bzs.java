// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import org.xml.sax.Attributes;

final class bzs extends bnt
{

    bzs()
    {
    }

    public final void a(bmz bmz1, Attributes attributes)
    {
        bmz1.offer(new cdq());
    }

    public final void a(bmz bmz1, Attributes attributes, String s)
    {
        attributes = (cdq)bmz1.b(cdq);
        attributes = new cdp(((cdq) (attributes)).a, ((cdq) (attributes)).b, ((cdq) (attributes)).c, ((cdq) (attributes)).d);
        ((ArrayList)bmz1.a(java/util/ArrayList)).add(attributes);
    }
}
