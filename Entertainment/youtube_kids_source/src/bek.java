// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.List;
import org.xml.sax.Attributes;

final class bek extends bnt
{

    private bdp a;

    bek(bdp bdp1)
    {
        a = bdp1;
        super();
    }

    public final void a(bmz bmz1, Attributes attributes)
    {
        bvd bvd1 = new bvd(((beu)bmz1.peek()).a);
        bvd1.n = attributes.getValue("id");
        bmz1.offer(bvd1);
    }

    public final void a(bmz bmz1, Attributes attributes, String s)
    {
        attributes = (bvd)bmz1.b(bvd);
        bmz1 = (beu)bmz1.peek();
        if (attributes != null && "402".equals(((bvd) (attributes)).o) && ((bvd) (attributes)).aj != null)
        {
            try
            {
                attributes.ai = a.a(((bvd) (attributes)).aj);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s = String.valueOf(s);
                bmo.b((new StringBuilder(String.valueOf(s).length() + 25)).append("Survey convertion error: ").append(s).toString());
                attributes.ai = bup.a;
            }
        }
        if (attributes != null && bmz1 != null)
        {
            attributes = attributes.a();
            ((beu) (bmz1)).b.add(attributes);
        }
    }
}
