// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import org.xml.sax.Attributes;

public final class cau extends bnt
{

    public cau()
    {
    }

    public final void a(bmz bmz1, Attributes attributes)
    {
        if ("http://schemas.google.com/g/2005#feed".equals(attributes.getValue("rel")))
        {
            ((cdv)bmz1.a(cdv)).f = Uri.parse(attributes.getValue("href"));
        } else
        if ("http://schemas.google.com/g/2005#post".equals(attributes.getValue("rel")))
        {
            ((cdv)bmz1.a(cdv)).h = Uri.parse(attributes.getValue("href"));
            return;
        }
    }
}
