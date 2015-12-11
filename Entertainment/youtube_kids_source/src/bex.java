// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.List;
import org.xml.sax.Attributes;

public final class bex extends bnt
{

    public bex()
    {
    }

    public final void a(bmz bmz1, Attributes attributes)
    {
        bgc bgc1 = new bgc();
        bgc1.b = a.l(attributes.getValue("timeOffset"));
        String s = attributes.getValue("breakType");
        if (s == null)
        {
            bmo.b("in Vmap AdBreak: timeOffset is null");
        } else
        {
            String as[] = s.split(",");
            if (as.length > 1)
            {
                int j = as.length;
                int i = 0;
                while (i < j) 
                {
                    a.a(as[i], bgc1);
                    i++;
                }
            } else
            {
                a.a(s, bgc1);
            }
        }
        bgc1.a = attributes.getValue("breakId");
        bmz1.offer(bgc1);
    }

    public final void a(bmz bmz1, Attributes attributes, String s)
    {
        attributes = (bgc)bmz1.b(bgc);
        bmz1 = (bfy)bmz1.a(bfy);
        if (attributes == null || bmz1 == null)
        {
            return;
        } else
        {
            attributes = attributes.a();
            ((bfy) (bmz1)).a.add(attributes);
            return;
        }
    }
}
