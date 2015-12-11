// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.an.b;

import android.app.Activity;
import android.content.Intent;
import com.shazam.android.an.a.r;
import com.shazam.android.an.p;
import com.shazam.android.an.u;
import com.shazam.android.an.v;
import com.shazam.b.e.a;
import com.shazam.model.authentication.AccessTokenRetrieverListener;
import com.shazam.model.spotify.SpotifyConnectionState;
import com.shazam.server.response.streaming.spotify.SpotifyUser;
import com.spotify.sdk.android.authentication.AuthenticationResponse;

// Referenced classes of package com.shazam.android.an.b:
//            e, ab

public final class ac
    implements e, v, AccessTokenRetrieverListener
{

    private final ab a;
    private final p b;
    private final u c;
    private final SpotifyConnectionState d;
    private r e;

    public ac(ab ab1, p p1, u u1, SpotifyConnectionState spotifyconnectionstate)
    {
        e = r.b;
        a = ab1;
        b = p1;
        c = u1;
        d = spotifyconnectionstate;
    }

    public final void a()
    {
        d.b();
    }

    public final void a(int i, Intent intent)
    {
        intent = a.a(i, intent);
        if (intent.getType() != com.spotify.sdk.android.authentication.AuthenticationResponse.Type.CODE)
        {
            e.d();
        }
        intent = intent.getCode();
        if (com.shazam.b.e.a.c(intent))
        {
            b.a(intent, this);
        }
    }

    public final void a(Activity activity)
    {
        a.a(activity);
    }

    public final void a(r r1)
    {
        e = r1;
    }

    public final void a(Object obj)
    {
        obj = (SpotifyUser)obj;
        d.a(((SpotifyUser) (obj)).id);
        e.c();
    }

    public final void b()
    {
        c.a(this);
    }

    public final void c()
    {
        e.d();
    }

    public final void d()
    {
        e.d();
    }
}
