// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.net.MalformedURLException;
import org.xml.sax.Attributes;

final class bej extends bnt
{

    bej()
    {
    }

    public final void a(bmz bmz1, Attributes attributes, String s)
    {
        bmz1 = (bvd)bmz1.a(bvd);
        try
        {
            bmz1.a(a.q(s.trim()));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (bmz bmz1)
        {
            bmo.c("Badly formed impression uri - ignoring");
        }
    }
}
