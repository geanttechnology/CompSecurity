// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.text.TextUtils;
import org.xml.sax.Attributes;

public final class bfb extends bnt
{

    public bfb()
    {
    }

    public final void a(bmz bmz1, Attributes attributes, String s)
    {
        bmz1 = (bfy)bmz1.a(bfy);
        s = attributes.getValue("macros");
        attributes = attributes.getValue("match");
        if ("device_id".equals(s) && attributes != null)
        {
            attributes = attributes.trim();
            if (!TextUtils.isEmpty(attributes))
            {
                bmz1.b = attributes.trim();
            }
        }
    }
}
