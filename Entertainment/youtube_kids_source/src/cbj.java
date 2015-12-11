// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.text.TextUtils;
import org.xml.sax.Attributes;

public final class cbj extends bnt
{

    public cbj()
    {
    }

    public final void a(bmz bmz1, Attributes attributes)
    {
        bmz1 = (ceb)bmz1.peek();
        String s = attributes.getValue("rel");
        attributes = attributes.getValue("href");
        if (!TextUtils.isEmpty(attributes))
        {
            if ("self".equals(s))
            {
                bmz1.b = Uri.parse(attributes);
            } else
            if ("alternate".equals(s))
            {
                bmz1.c = Uri.parse(attributes);
                return;
            }
        }
    }
}
