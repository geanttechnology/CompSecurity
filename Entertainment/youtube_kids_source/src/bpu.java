// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.text.TextUtils;
import java.net.MalformedURLException;
import org.xml.sax.Attributes;

final class bpu extends bnt
{

    bpu()
    {
    }

    public final void a(bmz bmz1, Attributes attributes, String s)
    {
        s = attributes.getValue("image_url");
        if (TextUtils.isEmpty(s))
        {
            attributes = attributes.getValue("thumbnail_url");
        } else
        {
            attributes = s;
        }
        if (TextUtils.isEmpty(attributes))
        {
            break MISSING_BLOCK_LABEL_53;
        }
        bmz1 = (bvt)bmz1.a(bvt);
        bmz1.b = a.q(attributes.trim());
        return;
        bmz1;
        bmo.c("Badly formed app icon - ignoring");
        return;
    }
}
