// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.an.a;

import com.shazam.a.g;
import com.shazam.android.an.r;
import com.shazam.k.s;
import com.shazam.model.Tag;
import com.shazam.model.Track;
import com.shazam.server.response.streaming.rdio.RdioTrackMapping;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.shazam.android.an.a:
//            b

public final class a extends b
{

    private final Set a;
    private final s b;

    public a(r r, Set set, g g, URL url, s s1)
    {
        super(r, g, url);
        a = set;
        b = s1;
    }

    protected final volatile Object a(Object aobj[])
    {
        return a((String[])aobj);
    }

    protected final transient List a(String as[])
    {
        Object obj = b.a();
        as = new ArrayList(((List) (obj)).size());
        obj = ((List) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            Track track = ((Tag)((Iterator) (obj)).next()).track;
            if (track != null)
            {
                as.add(track.id);
            }
        } while (true);
        Collections.reverse(as);
        return super.a((String[])as.toArray(new String[as.size()]));
    }

    protected final boolean a(RdioTrackMapping rdiotrackmapping)
    {
        return super.a(rdiotrackmapping) && !a.contains(rdiotrackmapping.trackKey);
    }
}
