// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public final class cfg extends DefaultHandler
{

    Uri a;
    boolean b;
    String c;
    String d;
    int e;
    boolean f;
    boolean g;
    private final StringBuilder h = new StringBuilder();

    public cfg()
    {
        b = false;
        e = -2;
        a = null;
        f = true;
        g = false;
    }

    public final void characters(char ac[], int i, int j)
    {
        h.append(ac, i, j);
    }

    public final void endElement(String s, String s1, String s2)
    {
        if (!"state".equals(s1)) goto _L2; else goto _L1
_L1:
        s = h.toString().toLowerCase(Locale.US);
        if (!s.startsWith("installable")) goto _L4; else goto _L3
_L3:
        e = 0;
        a = Uri.parse(s.replace("installable = ", ""));
_L6:
        return;
_L4:
        if (s.equals("running"))
        {
            e = 1;
            return;
        }
        if (s.equals("stopped"))
        {
            e = 2;
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if ("screenId".equals(s1))
        {
            d = h.toString();
            return;
        }
        if ("isInAppDial".equals(s1))
        {
            b = Boolean.parseBoolean(h.toString());
            return;
        }
        if ("discovery".equals(s1) && Arrays.asList(h.toString().split(",")).contains("CastV2"))
        {
            g = true;
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public final void startDocument()
    {
    }

    public final void startElement(String s, String s1, String s2, Attributes attributes)
    {
        h.delete(0, h.length());
        if ("link".equals(s1) && "run".equals(attributes.getValue("", "rel")))
        {
            c = attributes.getValue("", "href");
        }
        if ("options".equals(s1))
        {
            f = Boolean.parseBoolean(attributes.getValue("", "allowStop"));
        }
    }
}
