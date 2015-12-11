// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.text.TextUtils;
import org.xml.sax.Attributes;

final class ccw extends bnt
{

    ccw()
    {
    }

    public final void a(bmz bmz1, Attributes attributes, String s)
    {
        bmz1 = (cef)bmz1.a(cef);
        if (!TextUtils.isEmpty(attributes.getValue("yt:country")))
        {
            bmz1.z = true;
        }
    }
}
