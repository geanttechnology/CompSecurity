// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.aq;

import com.shazam.android.p.g;
import com.shazam.k.t;
import com.shazam.model.account.UserState;
import com.shazam.model.rdio.RdioConnectionState;
import com.shazam.model.social.ConnectionState;
import com.shazam.model.spotify.SpotifyConnectionState;
import com.shazam.model.streaming.StreamingConnectionState;
import com.shazam.model.streaming.SubscriptionType;
import com.shazam.n.b;
import com.shazam.n.m;
import java.util.Map;

// Referenced classes of package com.shazam.android.aq:
//            e, n

public final class i
    implements e
{

    private final String a;
    private final String b;
    private final m c;
    private final n d;
    private final RdioConnectionState e;
    private final ConnectionState f;
    private final ConnectionState g;
    private final SpotifyConnectionState h;
    private final t i;
    private final b j;

    public i(g g1, m m1, n n1, RdioConnectionState rdioconnectionstate, ConnectionState connectionstate, ConnectionState connectionstate1, SpotifyConnectionState spotifyconnectionstate, 
            t t1, b b1)
    {
        if (g1.a.b)
        {
            g1 = "largetablet";
        } else
        if (g1.a.a)
        {
            g1 = "smalltablet";
        } else
        if (g1.a.c)
        {
            g1 = "smallphone";
        } else
        if (g1.a.d)
        {
            g1 = "nosmallphone";
        } else
        {
            g1 = "phone";
        }
        a = g1;
        b = String.valueOf(android.os.Build.VERSION.SDK_INT);
        c = m1;
        d = n1;
        e = rdioconnectionstate;
        f = connectionstate;
        g = connectionstate1;
        h = spotifyconnectionstate;
        i = t1;
        j = b1;
    }

    private static String a(StreamingConnectionState streamingconnectionstate)
    {
        if (streamingconnectionstate.a())
        {
            return streamingconnectionstate.g().getBeaconValue();
        } else
        {
            return "none";
        }
    }

    private static String a(boolean flag)
    {
        if (flag)
        {
            return "1";
        } else
        {
            return "0";
        }
    }

    private boolean a()
    {
        return j.b();
    }

    public final void a(Map map)
    {
        map.put("osversion", b);
        map.put("deviceclass", a);
        long l;
        boolean flag;
        if (a())
        {
            l = j.a();
        } else
        {
            l = c.a();
        }
        map.put("clientcreationtimestamp", String.valueOf(l));
        map.put("rdc", a(e.a()));
        map.put("spc", a(h.a()));
        map.put("rdcs", a(((StreamingConnectionState) (e))));
        map.put("spcs", a(((StreamingConnectionState) (h))));
        map.put("fbc", a(f.a()));
        map.put("gpc", a(g.a()));
        if (i.a() == UserState.EMAIL_VALIDATED)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        map.put("ec", a(flag));
        map.put("us", String.valueOf(i.a().getUserStateCode()));
        map.put("sessionid", d.a());
        if (!a())
        {
            map.put("ntpsync", "0");
        }
    }
}
