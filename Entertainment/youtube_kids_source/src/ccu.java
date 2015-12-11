// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.text.TextUtils;
import org.xml.sax.Attributes;

final class ccu extends bnt
{

    ccu()
    {
    }

    public final void a(bmz bmz1, Attributes attributes, String s)
    {
        bmz1 = (cef)bmz1.a(cef);
        if ("uploader".equals(attributes.getValue("role")))
        {
            bmz1.o = s;
            attributes = attributes.getValue("yt:display");
            if (!TextUtils.isEmpty(attributes))
            {
                bmz1.G = attributes;
            }
        }
    }
}
