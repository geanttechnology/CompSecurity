// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.an.a;

import com.shazam.a.g;
import com.shazam.android.an.a;
import com.shazam.android.an.r;
import com.shazam.k.s;
import com.shazam.model.configuration.StreamingTrackMappingsUrlConfiguration;
import java.util.Set;

// Referenced classes of package com.shazam.android.an.a:
//            a

public final class c
    implements a
{

    private final g a;
    private final StreamingTrackMappingsUrlConfiguration b;
    private final s c;
    private com.shazam.android.an.a.a d;

    public c(g g, s s, StreamingTrackMappingsUrlConfiguration streamingtrackmappingsurlconfiguration)
    {
        a = g;
        b = streamingtrackmappingsurlconfiguration;
        c = s;
    }

    public final void a(r r, Set set)
    {
        if (d != null && d.getStatus() != android.os.AsyncTask.Status.FINISHED)
        {
            d.cancel(true);
        }
        d = new com.shazam.android.an.a.a(r, set, a, b.a(), c);
        d.execute(new String[0]);
    }
}
