// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import java.util.Set;
import org.xml.sax.Attributes;

final class cco extends bnt
{

    cco()
    {
    }

    public final void a(bmz bmz1, Attributes attributes)
    {
        String s;
        bmz1 = (cef)bmz1.a(cef);
        s = attributes.getValue("rel");
        if (!cce.b().contains(s)) goto _L2; else goto _L1
_L1:
        Uri uri = Uri.parse(attributes.getValue("href"));
        if (!"edit".equals(s)) goto _L4; else goto _L3
_L3:
        bmz1.h = uri;
_L2:
        return;
_L4:
        if (!"http://gdata.youtube.com/schemas/2007#video.captionTracks".equals(s))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!"true".equals(attributes.getValue("yt:hasEntries"))) goto _L2; else goto _L5
_L5:
        bmz1.i = uri;
        return;
        if (!"http://gdata.youtube.com/schemas/2007#live.event".equals(s)) goto _L2; else goto _L6
_L6:
        bmz1.E = uri;
        return;
    }
}
