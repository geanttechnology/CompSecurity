// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.an.b;

import com.shazam.android.an.v;
import com.shazam.h.j;

// Referenced classes of package com.shazam.android.an.b:
//            ae, h

public final class aa
    implements Runnable
{

    v a;
    private final h b;
    private final ae c;

    public aa(h h1, ae ae1)
    {
        b = h1;
        c = ae1;
    }

    public final void run()
    {
        try
        {
            c.a();
            com.shazam.server.response.streaming.spotify.SpotifyUser spotifyuser = b.a();
            a.a(spotifyuser);
            return;
        }
        catch (j j1)
        {
            a.c();
        }
    }
}
