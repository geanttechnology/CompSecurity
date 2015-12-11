// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import org.xml.sax.Attributes;

final class ccz extends bnt
{

    ccz()
    {
    }

    public final void a(bmz bmz1, Attributes attributes)
    {
        bmz1 = (cef)bmz1.a(cef);
        String s = attributes.getValue("yt:name");
        attributes = Uri.parse(attributes.getValue("url"));
        if ("default".equals(s))
        {
            bmz1.d = attributes;
        } else
        {
            if ("mqdefault".equals(s))
            {
                bmz1.e = attributes;
                return;
            }
            if ("hqdefault".equals(s))
            {
                bmz1.f = attributes;
                return;
            }
            if ("sddefault".equals(s))
            {
                bmz1.g = attributes;
                return;
            }
        }
    }
}
