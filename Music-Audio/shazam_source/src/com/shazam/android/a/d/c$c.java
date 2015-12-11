// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.a.d;

import com.shazam.g.f;
import com.shazam.model.news.ChartFeedCard;
import com.shazam.model.news.FeedCard;
import java.util.List;

// Referenced classes of package com.shazam.android.a.d:
//            c

private final class b
    implements f
{

    final c a;
    private final ChartFeedCard b;

    public final void onDataFailedToLoad()
    {
        (new StringBuilder("Failed to load data for chart card: ")).append(b);
    }

    public final void onDataFetched(Object obj)
    {
        obj = (List)obj;
        int i = com.shazam.android.a.d.c.a(a, ((FeedCard) (b)).id);
        if (com.shazam.android.a.d.c.e(i))
        {
            com.shazam.model.news.tFeedCard.Builder builder = com.shazam.model.news.tFeedCard.Builder.a(b);
            builder.tracks = ((List) (obj));
            obj = builder.b();
            a.e.set(i, obj);
            a.h(i);
        }
    }

    public FeedCard(c c1, ChartFeedCard chartfeedcard)
    {
        a = c1;
        super();
        b = chartfeedcard;
    }
}
