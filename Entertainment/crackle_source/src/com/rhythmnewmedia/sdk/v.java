// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rhythmnewmedia.sdk;

import android.graphics.Color;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.rhythmnewmedia.sdk:
//            c, g, u, y

public final class v extends c
{

    private final g c = new g(this);
    private final u d = new u();
    private boolean e;
    private boolean f;
    private boolean g;

    public v()
    {
        e = false;
        f = false;
        g = false;
    }

    protected final volatile Object a()
    {
        if (d.d() != null)
        {
            return d;
        } else
        {
            return null;
        }
    }

    public final void endElement(String s, String s1, String s2)
        throws SAXException
    {
        if (!"url".equals(s1) || d == null) goto _L2; else goto _L1
_L1:
        s = c.c.toString();
        if (!e) goto _L4; else goto _L3
_L3:
        d.a(s, g);
_L6:
        return;
_L4:
        if (f)
        {
            d.b(s, g);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if ("impression".equals(s1))
        {
            e = false;
            return;
        }
        if ("clickTracking".equals(s1))
        {
            f = false;
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public final void startElement(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("adresponse".equals(s1))
        {
            d.a(attributes.getValue("requestId"));
        } else
        {
            if ("ad".equals(s1))
            {
                d.d(attributes.getValue("url"));
                d.e(attributes.getValue("clickThruUrl"));
                d.b(attributes.getValue("id"));
                d.c(attributes.getValue("title"));
                try
                {
                    d.a(u.a.valueOf(attributes.getValue("type")));
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    d.a(u.a.b);
                }
                if ("true".equalsIgnoreCase(attributes.getValue("video")))
                {
                    d.a(u.a.c);
                }
                try
                {
                    d.a(Integer.parseInt(attributes.getValue("autodismissDelay")));
                }
                // Misplaced declaration of an exception variable
                catch (String s) { }
                try
                {
                    d.d(Color.parseColor(String.format("#%s", new Object[] {
                        attributes.getValue("clickThruBackground")
                    })));
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    y.c("Failed to set background color to %s", new Object[] {
                        attributes.getValue("clickThruBackground")
                    });
                    d.d(0);
                }
                try
                {
                    d.b(Integer.parseInt(attributes.getValue("closeButtonDelay")));
                }
                // Misplaced declaration of an exception variable
                catch (String s) { }
                try
                {
                    d.c(Integer.parseInt(attributes.getValue("videoSkipDelay")));
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    return;
                }
            }
            if ("impression".equals(s1) && d != null)
            {
                e = true;
                return;
            }
            if ("clickTracking".equals(s1) && d != null)
            {
                f = true;
                return;
            }
            if ("url".equals(s1))
            {
                g = "rhythm".equalsIgnoreCase(attributes.getValue("source"));
                c.a(b, s, s1, s2, attributes);
                return;
            }
        }
    }
}
