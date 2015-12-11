// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import org.xml.sax.Attributes;

final class ccl extends bnt
{

    ccl()
    {
    }

    public final void a(bmz bmz1, Attributes attributes, String s)
    {
        cef cef1;
        String s1;
        String s2;
        s1 = attributes.getValue("action");
        s2 = attributes.getValue("permission");
        cef1 = (cef)bmz1.a(cef);
        if (cef1.w == null)
        {
            cef1.w = new LinkedHashMap();
        }
        cef1.w.put(s1, s2);
        if (!"monetize".equals(s1)) goto _L2; else goto _L1
_L1:
        if (!"country".equals(attributes.getValue("type"))) goto _L4; else goto _L3
_L3:
        bmz1 = new HashSet();
        Collections.addAll(bmz1, s.trim().toLowerCase(Locale.US).split(" "));
        cef1.B = bmz1;
_L6:
        return;
_L4:
        cef1.A = "allowed".equals(s2);
        return;
_L2:
        if ("list".equals(s1))
        {
            if ("allowed".equals(s2))
            {
                bmz1 = ceg.a;
            } else
            {
                bmz1 = ceg.b;
            }
            cef1.a(bmz1);
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }
}
