// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Map;
import org.xml.sax.Attributes;

final class bdu extends bnt
{

    bdu()
    {
    }

    public final void a(bmz bmz1, Attributes attributes)
    {
        Object obj = (buy)bdp.a().get(attributes.getValue("type"));
        if (obj == null)
        {
            bmo.c("Invalid survey type encountered");
            obj = buy.c;
        }
        Object obj2 = (bux)bdp.b().get(attributes.getValue("randomize_option"));
        Object obj1 = obj2;
        if (obj2 == null)
        {
            bmo.c("Invalid randomize type encountered");
            obj1 = bux.c;
        }
        obj2 = new buv(((buy) (obj)), bdp.b(attributes.getValue("text")));
        ((buv) (obj2)).a.e = ((bux) (obj1)).d;
        obj1 = attributes.getValue("api_context");
        amy amy1 = ((buv) (obj2)).a;
        obj = obj1;
        if (obj1 == null)
        {
            obj = "";
        }
        amy1.g = ((String) (obj));
        attributes = attributes.getValue("video_timeout_seconds");
        if (attributes != null)
        {
            try
            {
                int i = Integer.valueOf(attributes.trim()).intValue();
                ((buv) (obj2)).a.h = i;
            }
            catch (NumberFormatException numberformatexception)
            {
                attributes = String.valueOf(attributes);
                if (attributes.length() != 0)
                {
                    attributes = "Invalid value for duration: ".concat(attributes);
                } else
                {
                    attributes = new String("Invalid value for duration: ");
                }
                bmo.c(attributes);
            }
        }
        bmz1.add(obj2);
    }

    public final void a(bmz bmz1, Attributes attributes, String s)
    {
        attributes = ((buv)bmz1.b(buv)).a();
        ((bur)bmz1.a(bur)).a(attributes);
    }
}
