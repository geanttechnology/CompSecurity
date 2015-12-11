// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import org.xml.sax.Attributes;

public final class cai extends bnt
{

    public cai()
    {
    }

    public final void a(bmz bmz1, Attributes attributes)
    {
        Uri uri = Uri.parse(attributes.getValue("url"));
        attributes = attributes.getValue("yt:name");
        if ("default".equals(attributes))
        {
            ((cdv)bmz1.a(cdv)).i = uri;
        } else
        {
            if ("hqdefault".equals(attributes))
            {
                ((cdv)bmz1.a(cdv)).j = uri;
                return;
            }
            if ("sddefault".equals(attributes))
            {
                ((cdv)bmz1.a(cdv)).k = uri;
                return;
            }
        }
    }
}
