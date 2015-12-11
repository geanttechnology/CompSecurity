// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.text.TextUtils;
import org.xml.sax.Attributes;

final class byx extends bnt
{

    byx(byw byw)
    {
    }

    public final void a(bmz bmz1, Attributes attributes, String s)
    {
        bmz1 = (cdo)bmz1.a(cdo);
        bmz1.d = s;
        attributes = attributes.getValue("display");
        if (!TextUtils.isEmpty(attributes))
        {
            bmz1.f = attributes;
        }
    }
}
