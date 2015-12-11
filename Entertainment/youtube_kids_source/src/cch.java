// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Map;
import org.xml.sax.Attributes;

final class cch extends bnt
{

    cch()
    {
    }

    public final void a(bmz bmz1, Attributes attributes)
    {
        cef cef1 = (cef)bmz1.a(cef);
        String s = attributes.getValue("reasonCode");
        bmz1 = s;
        if (s == null)
        {
            bmz1 = attributes.getValue("name");
        }
        cef1.a((ceh)cce.a().get(bmz1));
    }
}
