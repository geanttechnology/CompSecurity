// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.net.MalformedURLException;
import org.xml.sax.Attributes;

final class bpv extends bnt
{

    bpv()
    {
    }

    public final void a(bmz bmz1, Attributes attributes)
    {
        int i = a.b(attributes.getValue("review_count"), 0);
        bvt bvt1 = new bvt(attributes.getValue("app_name"), attributes.getValue("price"));
        bvt1.d = attributes.getValue("app_id");
        bvt1.a = i;
        bvt1.a(Math.max(0.0F, Math.min(5F, a.a(attributes.getValue("rating"), 0.0F))));
        attributes = attributes.getValue("rating_image");
        if (attributes != null)
        {
            try
            {
                bvt1.c = a.q(attributes.trim());
            }
            // Misplaced declaration of an exception variable
            catch (Attributes attributes)
            {
                bmo.c("Badly formed rating image uri - ignoring");
            }
        }
        bmz1.offer(bvt1);
    }

    public final void a(bmz bmz1, Attributes attributes, String s)
    {
        attributes = ((bvt)bmz1.b(bvt)).a();
        ((bvl)bmz1.a(bvl)).a = attributes;
    }
}
