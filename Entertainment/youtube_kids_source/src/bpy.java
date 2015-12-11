// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.net.MalformedURLException;
import org.xml.sax.Attributes;

final class bpy extends bnt
{

    bpy()
    {
    }

    public final void a(bmz bmz1, Attributes attributes)
    {
        Object obj;
        int i;
        i = bpq.a(attributes.getValue("type"), bpq.b(), 0);
        obj = attributes.getValue("link_url");
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_62;
        }
        obj = a.q(((String) (obj)).trim());
_L1:
        bmz1.offer(new bvp(i, ((android.net.Uri) (obj)), attributes.getValue("title")));
        return;
        obj = null;
          goto _L1
        bmz1;
        bmo.c("Badly formed action uri - ignoring action");
        return;
    }

    public final void a(bmz bmz1, Attributes attributes, String s)
    {
        attributes = ((bvp)bmz1.b(bvp)).a();
        ((bvl)bmz1.a(bvl)).a(attributes);
    }
}
