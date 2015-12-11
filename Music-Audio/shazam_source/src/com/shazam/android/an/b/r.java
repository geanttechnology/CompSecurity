// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.an.b;

import com.shazam.android.an.m;
import com.shazam.android.an.n;
import com.shazam.android.an.u;
import com.shazam.android.an.v;
import com.shazam.model.streaming.StreamingConnectionState;
import com.shazam.model.streaming.SubscriptionType;
import com.shazam.server.response.streaming.spotify.SpotifyUser;

// Referenced classes of package com.shazam.android.an.b:
//            ad

public final class r
    implements m, v
{

    private final u a;
    private final ad b;
    private final StreamingConnectionState c;
    private n d;

    public r(u u1, ad ad1, StreamingConnectionState streamingconnectionstate)
    {
        a = u1;
        b = ad1;
        c = streamingconnectionstate;
    }

    public final void a(n n1)
    {
        d = n1;
        a.a(this);
    }

    public final void a(Object obj)
    {
        obj = ((SpotifyUser)obj).product;
        c.a(SubscriptionType.fromSpotifyProduct(((String) (obj))));
        if (b.a(((String) (obj))))
        {
            d.f();
            return;
        } else
        {
            d.g();
            return;
        }
    }

    public final void c()
    {
        d.h();
    }
}
