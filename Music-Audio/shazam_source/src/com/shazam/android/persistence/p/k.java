// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.persistence.p;

import com.shazam.android.activities.streaming.b;
import com.shazam.android.an.c;
import com.shazam.android.an.d;
import com.shazam.android.an.g;
import com.shazam.android.an.h;
import com.shazam.android.an.o;
import com.shazam.android.an.q;
import com.shazam.android.an.r;
import com.shazam.android.analytics.event.EventAnalytics;
import com.shazam.android.analytics.event.factory.StreamingEventFactory;
import com.shazam.b.e.a;
import com.shazam.model.Tag;
import com.shazam.model.streaming.StreamingConnectionState;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.shazam.android.persistence.p:
//            j

public final class k
    implements c, h, r, j
{

    private final StreamingConnectionState b;
    private final EventAnalytics c;
    private final q d;
    private final g e;
    private final d f;
    private final b g;
    private String h;

    public k(StreamingConnectionState streamingconnectionstate, EventAnalytics eventanalytics, q q1, g g1, d d1, b b1)
    {
        b = streamingconnectionstate;
        c = eventanalytics;
        d = q1;
        e = g1;
        f = d1;
        g = b1;
    }

    public final void a()
    {
        c.logEvent(StreamingEventFactory.createStreamingPlaylistUpdatedEvent(g));
    }

    public final volatile void a(Object obj)
    {
        obj = ((Tag)obj).track;
        if (b.a() && obj != null)
        {
            d.a(this, ((com.shazam.model.Track) (obj)));
        }
    }

    public final void a(String s)
    {
        c.logEvent(StreamingEventFactory.createStreamingPlaylistUpdateErrorEvent(g, s));
    }

    public final void a(List list)
    {
        if (!list.isEmpty())
        {
            h = (String)list.get(0);
            if (com.shazam.b.e.a.c(b.f()))
            {
                e.a(list, this);
                return;
            } else
            {
                f.a(new o(g));
                return;
            }
        } else
        {
            c.logEvent(StreamingEventFactory.createStreamingPlaylistUpdateErrorEvent(g, "No rdio track key found for this track"));
            return;
        }
    }

    public final void b()
    {
        f.a(new o(g));
    }

    public final void b(String s)
    {
        c.logEvent(StreamingEventFactory.createStreamingPlaylistUpdateErrorEvent(g, s));
    }

    public final void c()
    {
        c.logEvent(StreamingEventFactory.createStreamingPlaylistUpdateErrorEvent(g, "Failed to retrieve track id"));
    }

    public final void d()
    {
        c.logEvent(StreamingEventFactory.createStreamingPlaylistUpdatedEvent(g));
        e.a(Collections.singletonList(h), this);
    }
}
