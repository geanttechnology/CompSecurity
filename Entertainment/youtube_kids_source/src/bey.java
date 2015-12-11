// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;

public final class bey extends bnt
{

    public bey()
    {
    }

    public final void a(bmz bmz1, Attributes attributes, String s)
    {
        bgc bgc1;
        bgc1 = (bgc)bmz1.a(bgc);
        bmz1 = attributes.getValue("event");
        if ("breakEnd".equalsIgnoreCase(bmz1))
        {
            bmz1 = bge.b;
        } else
        if ("error".equalsIgnoreCase(bmz1))
        {
            bmz1 = bge.c;
        } else
        {
            "breakStart".equalsIgnoreCase(bmz1);
            bmz1 = bge.a;
        }
        if (bmz1 == null)
        {
            return;
        }
        attributes = a.q(s.trim());
        b.a(bmz1);
        b.a(attributes);
        bgb.a[bmz1.ordinal()];
        JVM INSTR tableswitch 1 3: default 226
    //                   1 120
    //                   2 160
    //                   3 193;
           goto _L1 _L2 _L3 _L4
_L2:
        if (bgc1.h == null)
        {
            bgc1.h = new ArrayList();
        }
        bgc1.h.add(attributes);
        return;
_L3:
        try
        {
            if (bgc1.i == null)
            {
                bgc1.i = new ArrayList();
            }
            bgc1.i.add(attributes);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (bmz bmz1)
        {
            bmo.c("Badly formed AdBreak tracking uri - ignoring");
            return;
        }
_L4:
        if (bgc1.j == null)
        {
            bgc1.j = new ArrayList();
        }
        bgc1.j.add(attributes);
        return;
_L1:
    }
}
