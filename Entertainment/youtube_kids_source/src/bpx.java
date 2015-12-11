// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.net.MalformedURLException;
import org.xml.sax.Attributes;

final class bpx extends bnt
{

    bpx()
    {
    }

    public final void a(bmz bmz1, Attributes attributes)
    {
        bmz1 = (bvp)bmz1.a(bvp);
        attributes = attributes.getValue("base_url");
        if (attributes == null)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        bmz1.a(a.q(attributes.trim()));
        return;
        bmz1;
        bmo.c("Badly formed action's event uri - ignoring event");
        return;
    }
}
