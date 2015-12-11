// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;

final class bes extends bnt
{

    bes()
    {
    }

    public final void a(bmz bmz1, Attributes attributes, String s)
    {
        bmz1 = (bvd)bmz1.a(bvd);
        try
        {
            attributes = a.q(s.trim());
            if (((bvd) (bmz1)).P == null)
            {
                bmz1.P = new ArrayList();
            }
            ((bvd) (bmz1)).P.add(attributes);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (bmz bmz1)
        {
            bmo.c("Badly formed Exclusion Policy Tracking uri - ignoring");
        }
    }
}
