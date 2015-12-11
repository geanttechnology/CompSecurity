// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.net.MalformedURLException;
import org.xml.sax.Attributes;

final class bpw extends bnt
{

    bpw()
    {
    }

    public final void a(bmz bmz1, Attributes attributes)
    {
        int i;
        i = bpq.a(attributes.getValue("type"), bpq.a(), 0);
        bmz1 = (bvl)bmz1.a(bvl);
        attributes = attributes.getValue("base_url");
        if (attributes == null)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        bmz1.a(new bvv(i, a.q(attributes.trim())));
        return;
        bmz1;
        bmo.c("Badly formed event's uri - ignoring event");
        return;
    }
}
