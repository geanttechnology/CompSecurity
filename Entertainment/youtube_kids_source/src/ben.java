// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.text.TextUtils;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;

final class ben extends bnt
{

    ben()
    {
    }

    private static bvg a(String s, Uri uri)
    {
        if (!TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        bmo.c("Badly formed progress tracking event (missing offset attribute) - ignoring");
_L4:
        return null;
_L2:
        if (s.endsWith("%"))
        {
            int i = a.b(s.substring(0, s.length() - 1), -1);
            if (i >= 0 && i <= 100)
            {
                return new bvg(i, true, uri);
            }
            bmo.c("Badly formed progress tracking event (invalid offset percentage) - ignoring");
            continue; /* Loop/switch isn't completed */
        }
        s = new bvg(a.o(s), false, uri);
        return s;
        s;
        bmo.c("Badly formed progress tracking event (invalid offset format) - ignoring");
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final void a(bmz bmz1, Attributes attributes, String s)
    {
        String s1;
        bmz1 = (bvd)bmz1.a(bvd);
        s1 = attributes.getValue("event");
        if (s1 != null) goto _L2; else goto _L1
_L1:
        bmo.c("Badly formed tracking event - ignoring");
_L4:
        return;
_L2:
        try
        {
            s = a.q(s.trim());
            if ("start".equals(s1))
            {
                bmz1.b(s);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (bmz bmz1)
        {
            bmo.c("Badly formed tracking uri - ignoring");
            return;
        }
        if ("creativeView".equals(s1))
        {
            bmz1.b(s);
            return;
        }
        if ("firstQuartile".equals(s1))
        {
            bmz1.c(s);
            return;
        }
        if ("midpoint".equals(s1))
        {
            bmz1.d(s);
            return;
        }
        if ("thirdQuartile".equals(s1))
        {
            bmz1.e(s);
            return;
        }
        if ("complete".equals(s1))
        {
            bmz1.h(s);
            return;
        }
        if ("pause".equals(s1))
        {
            bmz1.j(s);
            return;
        }
        if ("resume".equals(s1))
        {
            bmz1.k(s);
            return;
        }
        if ("mute".equals(s1))
        {
            bmz1.l(s);
            return;
        }
        if ("fullscreen".equals(s1))
        {
            bmz1.m(s);
            return;
        }
        if ("endFullscreen".equals(s1))
        {
            if (((bvd) (bmz1)).L == null)
            {
                bmz1.L = new ArrayList();
            }
            ((bvd) (bmz1)).L.add(s);
            return;
        }
        if ("close".equals(s1))
        {
            bmz1.i(s);
            return;
        }
        if ("skip".equals(s1) && ((bvd) (bmz1)).a >= 3)
        {
            bmz1.f(s);
            return;
        }
        if (!"progress".equals(s1) || ((bvd) (bmz1)).a < 3) goto _L4; else goto _L3
_L3:
        attributes = a(attributes.getValue("offset"), ((Uri) (s)));
        if (attributes == null) goto _L4; else goto _L5
_L5:
        bmz1.a(attributes);
        return;
    }
}
