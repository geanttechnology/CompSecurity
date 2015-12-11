// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.an;

import com.shazam.android.activities.streaming.b;
import com.shazam.android.analytics.event.EventAnalytics;
import com.shazam.android.analytics.event.factory.StreamingEventFactory;
import java.util.Collections;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.shazam.android.an:
//            c, d, h, l, 
//            r, e, k, g, 
//            a, b

public final class j
    implements c, d, h, l, r
{

    private final k b;
    private final com.shazam.android.an.b c;
    private final a d;
    private final g e;
    private final EventAnalytics f;
    private final b g;
    private e h;

    public j(k k1, com.shazam.android.an.b b1, a a1, g g1, EventAnalytics eventanalytics, b b2)
    {
        h = e.a;
        b = k1;
        c = b1;
        d = a1;
        e = g1;
        f = eventanalytics;
        g = b2;
    }

    public final void a()
    {
        h.a();
    }

    public final void a(e e1)
    {
        h = e1;
        b.a(this);
    }

    public final void a(String s)
    {
        f.logEvent(StreamingEventFactory.createMyShazamPlaylistCreatedErrorBeacon(g.c));
        h.b();
    }

    public final void a(List list)
    {
        f.logEvent(StreamingEventFactory.createMyShazamPlaylistCreatedBeacon(g.c, list.size()));
        e.a(list, this);
    }

    public final void a(Set set)
    {
        d.a(this, set);
    }

    public final void b()
    {
        h.b();
    }

    public final void b(String s)
    {
        f.logEvent(StreamingEventFactory.createMyShazamPlaylistCreatedErrorBeacon(g.c));
        h.b();
    }

    public final void c()
    {
        h.b();
    }

    public final void d()
    {
        d.a(this, Collections.emptySet());
    }

    public final void e()
    {
        c.a(this);
    }

    public final void f()
    {
        h.b();
    }
}
