// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.h;

import com.shazam.android.aq.c;
import com.shazam.k.b;
import com.shazam.server.response.config.AmpAccount;
import com.shazam.server.response.config.AmpApis;
import com.shazam.server.response.config.AmpConfig;
import com.shazam.server.response.config.AmpHref;
import com.shazam.server.response.config.AmpSocial;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.shazam.h:
//            n

public final class a
    implements n
{

    private final b b;
    private final c c;
    private final com.shazam.android.j.o.b d;

    public a(b b1, c c1, com.shazam.android.j.o.b b2)
    {
        b = b1;
        c = c1;
        d = b2;
    }

    private static boolean a(URLConnection urlconnection, String s, boolean flag)
    {
        return Pattern.compile(s.replaceAll("\\{.*\\}", ".*")).matcher(urlconnection.getURL().toString()).matches() && flag;
    }

    public final void a(URLConnection urlconnection)
    {
        String s = b.a();
        Object obj = c.a();
        if (com.shazam.b.e.a.c(s))
        {
            if (a(urlconnection, d.a().toString(), true))
            {
                urlconnection.setRequestProperty("X-Shazam-AMPKey", s);
            } else
            {
                HashMap hashmap = new HashMap(((AmpConfig) (obj)).getAmpApis().getAmpAccount().getHrefMap());
                hashmap.putAll(((AmpConfig) (obj)).getAmpApis().getSocial().getHrefMap());
                obj = hashmap.entrySet().iterator();
                while (((Iterator) (obj)).hasNext()) 
                {
                    AmpHref amphref = (AmpHref)((java.util.Map.Entry)((Iterator) (obj)).next()).getValue();
                    boolean flag;
                    if (amphref != null && a(urlconnection, amphref.getHref(), amphref.isAuthenticated()))
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if (flag)
                    {
                        urlconnection.setRequestProperty("X-Shazam-AMPKey", s);
                    }
                }
            }
        }
    }
}
