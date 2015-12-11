// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.text.TextUtils;
import java.util.Set;
import org.xml.sax.Attributes;

final class cbn extends bnt
{

    cbn()
    {
    }

    public final void a(bmz bmz1, Attributes attributes)
    {
        ceb ceb1 = (ceb)bmz1.peek();
        String s = attributes.getValue("rel");
        if (cbm.a().contains(s))
        {
            bmz1 = attributes.getValue("href");
            int i;
            if (TextUtils.isEmpty(bmz1))
            {
                bmz1 = null;
            } else
            {
                bmz1 = Uri.parse(bmz1);
            }
            i = a.b(attributes.getValue("countHint"), -1);
            if ("http://gdata.youtube.com/schemas/2007#user.uploads".equals(s))
            {
                ceb1.n = bmz1;
                ceb1.o = i;
            } else
            {
                if ("http://gdata.youtube.com/schemas/2007#user.favorites".equals(s))
                {
                    ceb1.p = bmz1;
                    ceb1.q = i;
                    return;
                }
                if ("http://gdata.youtube.com/schemas/2007#user.subscriptions".equals(s))
                {
                    ceb1.r = bmz1;
                    ceb1.s = i;
                    return;
                }
                if ("http://gdata.youtube.com/schemas/2007#user.watchhistory".equals(s))
                {
                    ceb1.t = bmz1;
                    return;
                }
                if ("http://gdata.youtube.com/schemas/2007#user.watchlater".equals(s))
                {
                    ceb1.u = bmz1;
                    return;
                }
                if ("http://gdata.youtube.com/schemas/2007#user.playlists".equals(s))
                {
                    ceb1.v = bmz1;
                    return;
                }
                if ("http://gdata.youtube.com/schemas/2007#user.recentactivity".equals(s))
                {
                    ceb1.w = bmz1;
                    return;
                }
            }
        }
    }
}
