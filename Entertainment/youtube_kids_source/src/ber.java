// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.net.MalformedURLException;
import org.xml.sax.Attributes;

final class ber extends bnt
{

    ber()
    {
    }

    public final void a(bmz bmz1, Attributes attributes, String s)
    {
        bmz1 = (bvd)bmz1.a(bvd);
        if (!"engagedView".equals(attributes.getValue("id")))
        {
            break MISSING_BLOCK_LABEL_38;
        }
        bmz1.g(a.q(s.trim()));
        return;
        bmz1;
        bmo.c("Badly formed custom click tracking uri - ignoring");
        return;
    }
}
