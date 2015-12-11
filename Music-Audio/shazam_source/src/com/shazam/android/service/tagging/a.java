// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.service.tagging;

import com.shazam.a.a.a.e;
import com.shazam.a.a.a.f;
import com.shazam.a.a.d;
import com.shazam.android.analytics.TaggingOrigin;
import com.shazam.android.analytics.TaggingStatus;
import com.shazam.android.service.unsubmitted.g;
import com.shazam.android.service.unsubmitted.i;
import com.shazam.android.service.unsubmitted.j;
import com.shazam.android.util.g.b;
import com.shazam.model.Provider;
import com.shazam.model.Tag;
import com.shazam.model.TagContext;
import com.shazam.n.n;
import java.util.Collections;
import java.util.Map;

// Referenced classes of package com.shazam.android.service.tagging:
//            b

public final class a
    implements com.shazam.android.service.tagging.b
{

    private final d a;
    private final TaggingStatus b;
    private final g c;
    private final b d;
    private final TaggingOrigin e;

    public a(d d1, TaggingStatus taggingstatus, g g1, b b1, TaggingOrigin taggingorigin)
    {
        a = d1;
        b = taggingstatus;
        c = g1;
        d = b1;
        e = taggingorigin;
    }

    public final boolean a(Tag tag, j j1, i k)
    {
        return a(tag, j1, k, Collections.emptyMap());
    }

    public final boolean a(Tag tag, j j1, i k, Map map)
    {
        map = com.shazam.android.analytics.TaggedBeaconData.Builder.taggedBeaconData().withTaggingOrigin(e).withAdditionalBeaconParams(map).build();
        b.overallTaggingStart(map);
        d.a(tag.location);
        map = new com.shazam.a.a.a(tag.requestId, new n(tag) {

            final Tag a;
            final a b;

            public final long a()
            {
                return a.timestamp;
            }

            
            {
                b = a.this;
                a = tag;
                super();
            }
        }, new com.shazam.android.au.b.d(tag) {

            final Tag a;
            final a b;

            public final void a(int l, int i1)
            {
            }

            public final byte[] b()
            {
                return a.sig;
            }

            public final long c()
            {
                return 0L;
            }

            
            {
                b = a.this;
                a = tag;
                super();
            }
        }, new Provider(tag) {

            final Tag a;
            final a b;

            public final volatile Object a()
            {
                return a.location;
            }

            
            {
                b = a.this;
                a = tag;
                super();
            }
        });
        if (tag.tagContext != null)
        {
            com.shazam.model.TagContext.Builder builder = TagContext.a(tag.tagContext);
            if (!((com.shazam.a.a.a) (map)).c)
            {
                map.b = builder;
            }
        }
        map = a.a(map, 0, b, b);
        b.markEndOfRecognition();
        if (!(map instanceof e))
        {
            break MISSING_BLOCK_LABEL_204;
        }
        map = (e)map;
        map = ((e) (map)).a;
        c.a(tag, map);
        j1.a(map);
        map.locationName = d.a();
        return true;
        boolean flag = map instanceof f;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_225;
        }
        j1.b(tag);
        return true;
        k.a();
        return false;
        tag;
        flag = false;
_L2:
        b.markEndOfRecognition();
        k.a();
        return flag;
        tag;
        flag = true;
        if (true) goto _L2; else goto _L1
_L1:
    }
}
