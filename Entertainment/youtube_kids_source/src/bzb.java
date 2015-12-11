// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.text.TextUtils;
import java.util.Locale;
import org.xml.sax.Attributes;

final class bzb extends bnt
{

    bzb(byw byw)
    {
    }

    public final void a(bmz bmz1, Attributes attributes, String s)
    {
label0:
        {
            if ("http://gdata.youtube.com/schemas/2007/userevents.cat".equals(attributes.getValue("scheme")))
            {
                s = attributes.getValue("term").toUpperCase(Locale.US);
                if (!TextUtils.isEmpty(s))
                {
                    if (s.equals("BULLETIN_POSTED"))
                    {
                        attributes = cdn.j;
                    } else
                    if (s.equals("VIDEO_UPLOADED"))
                    {
                        attributes = cdn.e;
                    } else
                    if (s.equals("VIDEO_RATED"))
                    {
                        attributes = cdn.a;
                    } else
                    if (s.equals("VIDEO_SHARED"))
                    {
                        attributes = cdn.b;
                    } else
                    if (s.equals("VIDEO_FAVORITED"))
                    {
                        attributes = cdn.c;
                    } else
                    if (s.equals("VIDEO_COMMENTED"))
                    {
                        attributes = cdn.d;
                    } else
                    if (s.equals("VIDEO_RECOMMENDED"))
                    {
                        attributes = cdn.f;
                    } else
                    if (s.equals("VIDEO_ADDED_TO_PLAYLIST"))
                    {
                        attributes = cdn.g;
                    } else
                    if (s.equals("FRIEND_ADDED"))
                    {
                        attributes = cdn.h;
                    } else
                    if (s.equals("USER_SUBSCRIPTION_ADDED"))
                    {
                        attributes = cdn.i;
                    } else
                    {
                        attributes = null;
                    }
                    if (attributes == null)
                    {
                        break label0;
                    }
                    ((cdo)bmz1.a(cdo)).c = attributes;
                }
            }
            return;
        }
        bmz1 = String.valueOf(s);
        if (bmz1.length() != 0)
        {
            bmz1 = "Unexpected event action ".concat(bmz1);
        } else
        {
            bmz1 = new String("Unexpected event action ");
        }
        bmo.c(bmz1);
    }
}
