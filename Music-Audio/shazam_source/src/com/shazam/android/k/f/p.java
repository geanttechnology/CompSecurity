// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.k.f;

import android.net.Uri;
import com.shazam.android.persistence.c;
import com.shazam.i.b.ah.a;
import com.shazam.model.AutoTag;
import com.shazam.model.Tag;
import com.shazam.model.Track;
import com.shazam.p.p.j;

// Referenced classes of package com.shazam.android.k.f:
//            t, a

public final class p
    implements t
{

    private final c a = com.shazam.i.b.ah.a.a();

    public p()
    {
    }

    private static Uri a(Uri uri, String s)
    {
        Uri uri1 = uri;
        if (!com.shazam.b.e.a.a(s))
        {
            uri1 = uri.buildUpon().appendQueryParameter("eventId", s).build();
        }
        return uri1;
    }

    public final Uri a()
    {
        return a.a("my_tags", new String[0]);
    }

    public final Uri a(AutoTag autotag)
    {
        return e(autotag.uuid);
    }

    public final Uri a(Tag tag)
    {
        Object obj = tag.requestId;
        if (com.shazam.b.e.a.a(((String) (obj))))
        {
            obj = a(tag.track);
        } else
        {
            obj = c(((String) (obj)));
        }
        return a(((Uri) (obj)), tag.eventId);
    }

    public final Uri a(Track track)
    {
        Uri uri1 = b(track.id);
        Uri uri = uri1;
        if (com.shazam.b.e.a.c(track.campaign))
        {
            String s = track.campaign;
            uri = uri1;
            if (!com.shazam.b.e.a.a(s))
            {
                uri = uri1.buildUpon().appendQueryParameter("campaign", s).build();
            }
        }
        uri1 = uri;
        if (com.shazam.b.e.a.c(track.beaconKey))
        {
            track = track.beaconKey;
            uri1 = uri;
            if (!com.shazam.b.e.a.a(track))
            {
                uri1 = uri.buildUpon().appendQueryParameter("beaconKey", track).build();
            }
        }
        return uri1;
    }

    public final Uri a(String s)
    {
        return c(s);
    }

    public final Uri a(String s, j j1, String s1)
    {
        return com.shazam.android.k.f.a.a(a.v, new Object[] {
            s, j1.c, s1
        });
    }

    public final Uri a(String s, String s1)
    {
        Uri uri = a(a.a("news_feed_tracks", new String[] {
            s
        }), null);
        s = uri;
        if (!com.shazam.b.e.a.a(s1))
        {
            s = uri.buildUpon().appendQueryParameter("trackKey", s1).build();
        }
        return s;
    }

    public final Uri b()
    {
        return a.a("myshazam", new String[0]);
    }

    public final Uri b(String s)
    {
        return a.a("track", new String[] {
            s
        });
    }

    public final Uri b(String s, String s1)
    {
        return a(a.a("deep_link_tag", new String[] {
            s
        }), s1);
    }

    public final Uri c()
    {
        return a.a("chart", new String[0]);
    }

    public final Uri c(String s)
    {
        return a.a("my_tags", new String[] {
            s
        });
    }

    public final Uri d()
    {
        return a.a("news_feed", new String[0]);
    }

    public final Uri d(String s)
    {
        return a.a("chart", new String[] {
            s
        });
    }

    public final Uri e()
    {
        return a.a("explore", new String[0]);
    }

    public final Uri e(String s)
    {
        return a.a("auto_tags", new String[] {
            s
        });
    }

    public final Uri f()
    {
        return a.a("auto_tags", new String[0]);
    }

    public final Uri f(String s)
    {
        return a.a("artist_follow_status", new String[] {
            s
        });
    }

    public final Uri g()
    {
        return com.shazam.android.k.f.a.a(a.u, new Object[0]);
    }

    public final Uri g(String s)
    {
        return a.a("follow_artist", new String[] {
            s
        });
    }

    public final Uri h()
    {
        return a.a("streaming_provider", new String[0]);
    }

    public final Uri h(String s)
    {
        return a.a("unfollow_artist", new String[] {
            s
        });
    }

    public final Uri i()
    {
        return a.a("social_setup", new String[0]);
    }

    public final Uri i(String s)
    {
        return a.a("artist_followers_count", new String[] {
            s
        });
    }

    public final Uri j()
    {
        return a.a("follow_artist_status", new String[0]);
    }

    public final Uri j(String s)
    {
        return com.shazam.android.k.f.a.a(a.m, new Object[] {
            s
        });
    }

    public final Uri k(String s)
    {
        return a.a("like", new String[] {
            s
        });
    }

    public final Uri l(String s)
    {
        return a.a("unlike", new String[] {
            s
        });
    }
}
