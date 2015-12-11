// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rhythmnewmedia.sdk;

import android.graphics.Color;
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.rhythmnewmedia.sdk:
//            c, g, G, y, 
//            I

public final class N extends c
{

    G c;
    private final g d = new g(this);
    private I e;
    private boolean f;
    private boolean g;

    public N(c c1)
    {
        super(c1);
        f = false;
        g = false;
    }

    protected final volatile Object a()
    {
        return c;
    }

    public final void endElement(String s, String s1, String s2)
        throws SAXException
    {
        boolean flag = false;
        if (!"ad".equals(s1)) goto _L2; else goto _L1
_L1:
        a(s, s1, s2);
_L6:
        return;
_L2:
        if (!"ad-element".equals(s1) || c == null || e == null)
        {
            break MISSING_BLOCK_LABEL_104;
        }
        s = c;
        s1 = e;
        if (((G) (s)).e != null) goto _L4; else goto _L3
_L3:
        s;
        JVM INSTR monitorenter ;
        if (((G) (s)).e == null)
        {
            s.e = new ArrayList();
        }
        s;
        JVM INSTR monitorexit ;
_L4:
        ((G) (s)).e.add(s1);
        e = null;
        return;
        s1;
        throw s1;
        boolean flag1;
        if (!"url".equals(s1) || !f)
        {
            continue; /* Loop/switch isn't completed */
        }
        s = d.c.toString();
        s1 = c;
        flag1 = g;
        if (s == null || s.length() <= 0) goto _L6; else goto _L5
_L5:
        s1 = ((G) (s1)).a;
        s = s.trim();
        if (!flag1)
        {
            flag = true;
        }
        s1.add(new a.e(s, flag, flag1));
        return;
        if (!"trackingUrls".equals(s1)) goto _L6; else goto _L7
_L7:
        f = false;
        return;
    }

    public final void startElement(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        int i = 0;
        if (!"ad".equals(s1)) goto _L2; else goto _L1
_L1:
        s = attributes.getValue("id");
        s1 = attributes.getValue("url");
        s2 = attributes.getValue("title");
        double d1 = Double.parseDouble(attributes.getValue("duration"));
        i = (int)(1000D * d1);
_L6:
        c = new G(s, s1, s2, i);
        c.b = Color.parseColor(String.format("#%s", new Object[] {
            attributes.getValue("clickThruBackground")
        }));
_L3:
        return;
        s;
        c.b = -1;
        return;
_L2:
label0:
        {
            if (!"overlay".equals(s1) || c == null)
            {
                break label0;
            }
            c.c = attributes.getValue("url");
            s = attributes.getValue("videoFade");
            if (s != null)
            {
                try
                {
                    double d2 = Double.valueOf(s).doubleValue();
                    c.d = d2;
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (String s1)
                {
                    y.a("ignoring fade alpha of %s", new Object[] {
                        s
                    });
                }
                return;
            }
        }
          goto _L3
        if ("ad-element".equals(s1) && c != null)
        {
            try
            {
                e = new I();
                e.a = I.a.valueOf(attributes.getValue("type"));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                y.a("ignoring unknown legacy overlay type: %s", new Object[] {
                    attributes.getValue("type")
                });
            }
            e = null;
            return;
        }
        if ("action".equals(s1) && e != null)
        {
            e.b = attributes.getValue("info");
            return;
        }
        if ("trackingUrls".equals(s1) && c != null)
        {
            f = true;
            return;
        }
        if (!"url".equals(s1) || !f) goto _L3; else goto _L4
_L4:
        g = "rhythm".equalsIgnoreCase(attributes.getValue("source"));
        d.a(b, s, s1, s2, attributes);
        return;
        Throwable throwable;
        throwable;
        if (true) goto _L6; else goto _L5
_L5:
    }
}
