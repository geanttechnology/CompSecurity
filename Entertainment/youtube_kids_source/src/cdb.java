// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.List;
import org.xml.sax.Attributes;

final class cdb extends bnt
{

    cdb()
    {
    }

    public final void a(bmz bmz1, Attributes attributes)
    {
        bmz1.offer(new cdk());
        bmz1.offer(new cef());
    }

    public final void a(bmz bmz1, Attributes attributes, String s)
    {
        s = (cef)bmz1.b(cef);
        attributes = (cdk)bmz1.b(cdk);
        if (((cdk) (attributes)).b == 200)
        {
            attributes.a = s.a();
        }
        bmz1 = (cpt)bmz1.a(cpt);
        attributes = attributes.a();
        ((cpt) (bmz1)).a.add(attributes);
    }
}
